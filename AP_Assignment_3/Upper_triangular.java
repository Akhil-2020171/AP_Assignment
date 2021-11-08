import java.util.ArrayList;

public class Upper_triangular {
    private static ArrayList<float[][]> UT = new ArrayList<float[][]>();
    
    Upper_triangular(float[][] m , int rows ,int columns){
        for(int i = 0 ; i<rows ; i++){
            for(int j =0 ; j<columns ; j++){
                if(i>j && m[i][j]==0){
                    UT.add(m);
                }
            }
        }
    }
}