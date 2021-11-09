import java.util.ArrayList;

public class Singleton {
    private static ArrayList<float[][]> Single = new ArrayList<float[][]>();

    Singleton(float[][] m , int rows ,int columns){
        if(rows==1 && columns ==1){
            Single.add(m);
        }
    }

    public static boolean getSingleton(float[][] m){
        return Single.contains(m);
    }
}