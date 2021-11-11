import java.util.ArrayList;

public class Lower_triangular {
    private static ArrayList<double[][]> LT = new ArrayList<double[][]>();
    
    Lower_triangular(double[][] L , int rows ,int columns){
        for(int i = 0 ; i<rows ; i++){
            for(int j =0 ; j<columns ; j++){
                if(i<j && L[i][j]==0){
                    LT.add(L);
                }
            }
        }
    }

    public static boolean getLT(double[][] m){
        return LT.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getLT(m)){
            LT.remove(m);
        }
    }
}