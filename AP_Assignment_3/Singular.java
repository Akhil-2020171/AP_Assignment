import java.util.ArrayList;

public class Singular {
    private static ArrayList<double[][]> sin = new ArrayList<double[][]>(); 
    
    Singular(double[][] m ,int rows, int columns){
        if(rows==columns){
            double determinant = Determinant(m,rows);
            if(determinant==0){
                sin.add(m);
            }
        }
    }

    private static double Determinant(double[][] m , int n){
        double determinant=0;

        if(n==1){
            return m[0][0];
        }

        double[][] temp = new double[n][n];

        double sign = 1;

        for(int f= 0 ; f<n ; f++){
            cofactor(m, temp, 0, f, n);
            determinant += sign*m[0][f]*Determinant(temp, n-1);
            sign = -sign;
        }

        return determinant;
    }

    private static void cofactor(double[][] m , double temp[][],int p , int q , int n){
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

    public static boolean getSingular(double[][] m){
        return sin.contains(m);
    }

    public static void getRemove(double[][] m){
        if(getSingular(m)){
            sin.remove(m);
        }
    }
}