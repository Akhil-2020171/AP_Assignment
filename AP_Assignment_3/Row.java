import java.util.ArrayList;

public class Row {
    private static ArrayList<float[][]> R = new ArrayList<float[][]>();
    
    Row(float[][] r,int rows, int columns){
        if(rows == 1){
            R.add(r);
        }
    }

    public static boolean getRow(float[][] m){
        return R.contains(m);
    }
}
