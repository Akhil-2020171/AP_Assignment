import java.util.ArrayList;

public class Singular {
    private static ArrayList<float[][]> sin = new ArrayList<float[][]>(); 
    
    Singular(float[][] m ,int rows, int columns){
        if(rows==columns){
            float determinant = Determinant(m,rows);
            if(determinant==0){
                sin.add(m);
            }
        }
    }

    private static float Determinant(float[][] m , int n){
        float determinant=0;

        if(n==1){
            return m[0][0];
        }

        float[][] temp = new float[n][n];

        float sign = 1;

        for(int f= 0 ; f<n ; f++){
            cofactor(m, temp, 0, f, n);
            determinant += sign*m[0][f]*Determinant(temp, n-1);
            sign = -sign;
        }

        return determinant;
    }

    private static void cofactor(float[][] m , float temp[][],int p , int q , int n){
        int i = 0, j = 0;

        for(int row = 0; row < n ; row++){
            for(int col = 0; col<n ; col++){
                if(row!=p && col!=q){
                    temp[i][j++] = m[row][col];
                    if(j==n-1){
                        j=0;
                        i++;
                    }
                }
            }
        }
    }

    public static boolean getSingular(float[][] m){
        return sin.contains(m);
    }
}