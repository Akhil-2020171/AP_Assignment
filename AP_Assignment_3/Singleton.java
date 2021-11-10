import java.util.ArrayList;

public class Singleton {
    private static ArrayList<double[][]> Single = new ArrayList<double[][]>();

    Singleton(double[][] m , int rows ,int columns){
        if(rows==1 && columns ==1){
            Single.add(m);
        }
    }

    public static boolean getSingleton(double[][] m){
        return Single.contains(m);
    }
}