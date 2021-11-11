import java.util.ArrayList;

public class Column {
    private static ArrayList<double[][]> col = new ArrayList<double[][]>();

    Column(double[][] colm, int rows, int columns){
        if(columns==1){
            col.add(colm); 
        }
    }

    public static boolean getColumn(double[][] m){
        return col.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getColumn(m)){
            col.remove(m);
        }
    }
}