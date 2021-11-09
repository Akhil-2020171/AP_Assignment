import java.util.ArrayList;

public class Symmetric {
    private static ArrayList<float[][]> sym = new ArrayList<float[][]>();   

    Symmetric(float[][] m , int rows, int columns){
        float[][] mt = new float[rows][columns]; // for tranposing the matrix
        
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0; j<columns ; j++){
                mt[i][j] = m[j][i];
            }
        }

        boolean flag = compare(m, mt, rows, columns);
        
        if(flag){
            sym.add(m);
        }
    }

    private static boolean compare(float[][] m , float[][] mt , int rows, int columns){
        boolean flag = true;

        //Calculates the number of rows and columns present in the first matrix  
        int row1 = m.length; 
        int col1 = m[0].length;
        
        for(int i = 0; i < row1; i++){    
            for(int j = 0; j < col1; j++){    
                if(m[i][j] != mt[i][j]){    
                    flag = false;    
                    break;    
                }    
            }    
        }
        return flag;
    }

    public static boolean getSymmetric(float[][] m){
        return sym.contains(m);
    }
}