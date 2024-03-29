import java.util.ArrayList;

public class Diagonal {
    private static ArrayList<double[][]> Dia = new ArrayList<double[][]>();

    Diagonal(double[][] D, int rows, int columns){
        if(rows==columns){
            for(int i = 0 ; i<rows ; i++){
                for(int j = 0 ; j<columns ; j++){
                    if(i!=j && D[i][j]==0){
                        Dia.add(D);
                    }
                }
            }
        }
    }

    public static boolean getDiagonal(double[][] m){
        return Dia.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getDiagonal(m)){
            Dia.remove(m);
        }
    }
}