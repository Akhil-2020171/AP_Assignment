import java.util.ArrayList;

public class Reactangular {
    private static ArrayList<float[][]> R = new ArrayList<float[][]>();
    
    Reactangular(float[][] r, int rows, int columns){
        if(rows!=columns){
            R.add(r);
        }
    }
}