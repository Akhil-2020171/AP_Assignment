import java.util.ArrayList;

public class Singleton {
    private static ArrayList<Float> Single = new ArrayList<Float>();

    Singleton(float[][] m , int rows ,int columns){
        if(rows==1 && columns ==1){
            Single.add(m[rows][columns]);
        }
    }
}