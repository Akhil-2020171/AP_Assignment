import java.util.ArrayList;

public class Identity {
    private static ArrayList<double[][]> Ide = new ArrayList<double[][]>();

    Identity(double[][] I , int rows, int columns){
        boolean flag = true;
        if(rows==columns){
            for(int i = 0 ; i<rows ; i++){
                for(int j = 0 ; j<columns ; j++){
                    if(i == j && I[i][j] != 1){    
                        flag = false;    
                        break;    
                    }  
                    if(i != j && I[i][j] != 0){    
                        flag = false;    
                        break;    
                    }  
                }
            }
            if(flag){
                Ide.add(I);
            }
        }
    }

    public static boolean getIdentity(double[][] m){
        return Ide.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getIdentity(m)){
            Ide.remove(m);
        }
    }
}