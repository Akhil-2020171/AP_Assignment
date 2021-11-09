import java.util.ArrayList;

public class Column {
    private static ArrayList<float[][]> col = new ArrayList<float[][]>();

    Column(float[][] colm, int rows, int columns){
        if(columns==1){
            col.add(colm); 
        }
    }

    public static boolean getColumn(float[][] m){
        return col.contains(m);
    }
}