import java.util.ArrayList;

public class Identity {
    private static ArrayList<float[][]> Ide = new ArrayList<float[][]>();

    Identity(float[][] I , int rows, int columns){
        if(rows==columns){
            for(int i = 0 ; i<rows ; i++){
                for(int j = 0 ; j<columns ; j++){
                    if(I[i][i]==1){
                        if(i!=j && I[i][j] == 0){
                            Ide.add(I);
                        }
                    }
                }
            }
        }
    }

    public static boolean getIdentity(float[][] m){
        return Ide.contains(m);
    }
}