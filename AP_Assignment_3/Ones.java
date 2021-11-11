import java.util.ArrayList;

public class Ones {
    private static ArrayList<double[][]> one = new ArrayList<double[][]>();
    
    Ones(double[][] o , int rows, int columns){
        int c = 0;
        for(int i=0; i<rows ; i++){
            for(int j = 0; j<columns ; j++){
                if(o[i][j]==1){
                    c++;
                }
            }
        }

        if(c==rows*columns){
            one.add(o);
        }
    }

    public static boolean getOnes(double[][] m){
        return one.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getOnes(m)){
            one.remove(m);
        }
    }
}