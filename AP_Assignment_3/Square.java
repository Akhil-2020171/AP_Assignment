import java.util.ArrayList;

public class Square {
    private static ArrayList<float[][]> Sq = new ArrayList<float[][]>();
    
    Square(float[][] s, int rows, int columns){
        if(rows==columns){
            Sq.add(s);
        }
    }

    public static boolean getSquare(float[][] m){
        return Sq.contains(m);
    }
}