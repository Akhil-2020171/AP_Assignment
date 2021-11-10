import java.util.ArrayList;

public class Reactangular {
    private static ArrayList<double[][]> R = new ArrayList<double[][]>();
    
    Reactangular(double[][] r, int rows, int columns){
        if(rows!=columns){
            R.add(r);
        }
    }

    public static boolean getRectangular(double[][] m){
        return R.contains(m);
    }
}