import java.util.ArrayList;

public class Scalar {
    private static ArrayList<double[][]> S = new ArrayList<double[][]>();

    Scalar(double[][] scal , int rows, int columns){
        boolean flag = true;
        if(rows==columns){
		    for(int i=0;i<rows;i++){
		        for(int j=0;j<columns;j++){
		            if(i!=j && scal[i][j]!=0){
		                flag=false;
		                break;
		            }
		            if(i==j && scal[i][j]!=scal[i][j]){
		                flag=false;
		                break;
		            }
		        }
		    }
            if(flag){
                S.add(scal);
            }
        }
    }

    public static boolean getScalar(double[][] m){
        return S.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getScalar(m)){
            S.remove(m);
        }
    }
}