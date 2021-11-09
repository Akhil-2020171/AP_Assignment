import java.util.ArrayList;

public class Reactangular {
    private static ArrayList<float[][]> R = new ArrayList<float[][]>();
    
    Reactangular(float[][] r, int rows, int columns){
        if(rows!=columns){
            R.add(r);
        }
    }

    public static boolean getRectangular(float[][] m){
        return R.contains(m);
    }
}