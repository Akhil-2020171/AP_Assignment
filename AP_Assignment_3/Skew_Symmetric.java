import java.util.ArrayList;

public class Skew_Symmetric {
    private static ArrayList<double[][]> Sk_sym = new ArrayList<double[][]>();   

    Skew_Symmetric(double[][] m , int rows, int columns){
        if(rows==columns){
            double[][] mt = new double[rows][columns]; // for tranposing the matrix
        
            for(int i = 0 ; i<rows ; i++){
                for(int j = 0; j<columns ; j++){
                    mt[i][j] = m[j][i];
                }
            }
    
            boolean flag = compare(m, mt, rows, columns);
    
            if(flag){
                Sk_sym.add(m);
            }
        }
    }

    private static boolean compare(double[][] m , double[][] mt , int rows, int columns){
        boolean flag = true;

        //Calculates the number of rows and columns present in the first matrix  
        int row1 = m.length; 
        int col1 = m[0].length;
        
        for(int i = 0; i < row1; i++){    
            for(int j = 0; j < col1; j++){    
                if(m[i][j] != -mt[i][j]){    
                    flag = false;    
                    break;    
                }    
            }    
        }
        return flag;
    }

    public static boolean getSkew(double[][] m){
        return Sk_sym.contains(m);
    }
}