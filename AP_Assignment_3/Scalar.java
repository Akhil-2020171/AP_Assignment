import java.util.ArrayList;

public class Scalar {
    private static ArrayList<double[][]> S = new ArrayList<double[][]>();

    Scalar(double[][] scal , int rows, int columns){
        double k = scal[0][0];

        if(rows==columns){
            for(int i = 0 ; i<rows ; i++){
                if(scal[i][i]==k){
                    for(int j = 0 ; j<columns ; j++){
                        if(i!=j && scal[i][j] == 0){
                            S.add(scal);
                        }
                    }
                }
            }
        }
    }

    public static boolean getScalar(double[][] m){
        return S.contains(m);
    }
}