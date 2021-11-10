import java.util.ArrayList;

public class Null {
    private static ArrayList<double[][]> N = new ArrayList<double[][]>();
    
    Null(double[][] n , int rows , int columns){
        int c=0;
        for(int i=0 ; i<rows ; i++){
            for(int j =0 ; j<columns ; j++){
                if(n[i][j]==0){
                    c++;
                }
            }
        }
        if(c==rows*columns){
            N.add(n);
        }
    }

    public static boolean getNull(double[][] m){
        return N.contains(m);
    }
}