import java.util.ArrayList;

public class Scalar {
    private static ArrayList<float[][]> S = new ArrayList<float[][]>();

    Scalar(float[][] scal , int rows, int columns){
        float k = scal[0][0];

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
}