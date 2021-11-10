import java.util.ArrayList;

public class Square {
    private static ArrayList<double[][]> Sq = new ArrayList<double[][]>();
    
    Square(double[][] s, int rows, int columns){
        if(rows==columns){
            Sq.add(s);
        }
    }

    public static boolean getSquare(double[][] m){
        return Sq.contains(m);
    }
}