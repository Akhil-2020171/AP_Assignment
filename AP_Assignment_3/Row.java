import java.util.ArrayList;

public class Row {
    private static ArrayList<double[][]> R = new ArrayList<double[][]>();
    
    Row(double[][] r,int rows, int columns){
        if(rows == 1){
            R.add(r);
        }
    }

    public static boolean getRow(double[][] m){
        return R.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getRow(m)){
            R.remove(m);
        }
    }
}