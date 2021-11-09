import java.util.ArrayList;

public class Lower_triangular {
    private static ArrayList<float[][]> LT = new ArrayList<float[][]>();
    
    Lower_triangular(float[][] L , int rows ,int columns){
        for(int i = 0 ; i<rows ; i++){
            for(int j =0 ; j<columns ; j++){
                if(i<j && L[i][j]==0){
                    LT.add(L);
                }
            }
        }
    }

    public static boolean getLT(float[][] m){
        return LT.contains(m);
    }
}