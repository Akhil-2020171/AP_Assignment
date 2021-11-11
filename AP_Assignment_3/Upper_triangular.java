import java.util.ArrayList;

public class Upper_triangular {
    private static ArrayList<double[][]> UT = new ArrayList<double[][]>();
    
    Upper_triangular(double[][] m , int rows ,int columns){
        for(int i = 0 ; i<rows ; i++){
            for(int j =0 ; j<columns ; j++){
                if(i>j && m[i][j]==0){
                    UT.add(m);
                }
            }
        }
    }

    public static boolean getUT(double[][] m){
        return UT.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getUT(m)){
            UT.remove(m);
        }
    }
}