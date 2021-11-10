
// Tester class for testing various implementations // 

public class tester {
    public static void main(String[] args){
        double[][] matrix = {{1,2},{3,4}}; // for eigen values and vector
        Matrix m = new Matrix(matrix);

        EigenvalueDecomposition eig = new EigenvalueDecomposition(m);
        
        double[][] m1 = eig.getV().getArray();
        double[][] m2 = eig.getD().getArray();

        // Eigen Vector Matrix
        for(int i = 0 ; i<m1.length ; i++){
            for(int j = 0 ; j<m1[0].length ; j++){
                System.out.print((float)m1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        // Eigen Values 
        for(int i = 0 ; i<m2.length ; i++){
            for(int j = 0 ; j<m2[0].length ; j++){
                if(i==j){
                    System.out.print((float)m2[i][j]+" ");
                }
            }
            System.out.println();
        }
    }   
}