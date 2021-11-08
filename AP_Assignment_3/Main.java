import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static HashMap<String,Object> MatrixObject = new HashMap<>(); // ID with matrix
    private static ArrayList<Object> Type = new ArrayList<>(); // Matrix type object

    // private final float[][] Identiy_Matrix_2x2 = {{1,0},{0,1}};
    // private final float[][] Identiy_Matrix_3x3 = {{1,0,0},{0,1,0},{0,0,1}};

    // private final float[][] Null_Matrix_2x2 = {{0,0},{0,0}};
    // private final float[][] Null_Matrix_3x3 = {{0,0,0},{0,0,0},{0,0,0}};

    // private final float[][] Ones_Matrix_2x2 = {{1,1},{1,1}};
    // private final float[][] Ones_Matrix_3x3 = {{1,1,1},{1,1,1},{1,1,1}};

    public static void main(String[] args) throws IOException{
        menu1(); // For to know the types of matrices
        menu2(); // For the functions of the matrices

    }   

    private static void menu1(){
        System.out.println();
        System.out.println("======================================");
        System.out.println("There are 15 types of matrices.");
        System.out.println();
        System.out.println("1.  Rectangular Matrix");
        System.out.println("2.  Square Matrix");
        System.out.println("3.  Column Matrix");
        System.out.println("4.  Row Matrix");
        System.out.println("5.  Symmetric Matrix");
        System.out.println("6.  Skew-Symmetric Matrix");
        System.out.println("7.  Upper-Triangular Matrix");
        System.out.println("8.  Lower-Triangluar Matrix");
        System.out.println("9.  Singular Matrix");
        System.out.println("10. Diagonal Matrix");
        System.out.println("11. Scalar Matrix");
        System.out.println("12. Identity Matrix");
        System.out.println("13. Singleton Matrix");
        System.out.println("14. Ones Matrix");
        System.out.println("15. Null Matrix");
        System.out.println("======================================");
        System.out.println();
    }

    private static void menu2(){
        System.out.println();
        System.out.println("======================================");
        System.out.println("Matrix Functionality.");
        System.out.println();
        System.out.println("1.  Take matrix as input and label them with appropriate matrix-type");
        System.out.println("2.  Create matrix of requested matrix-types and label them accordingly");
        System.out.println("3.  Change the elements of a matrix as long as the matrix-type remains same");
        System.out.println("4.  Display all matrix-type labels of a requested matrix");
        System.out.println("5.  Perform Addition , Subtraction, Multiplication and Division");
        System.out.println("6.  Element-wise operation");
        System.out.println("7.  Transpose the matrix");
        System.out.println("8.  Inverse the matrix");
        System.out.println("9.  Compute means : row-wise mean , cloumn-wise mean , mean of all elements");
        System.out.println("10. Compute the determinant");
        System.out.println("11. Use singleton matrices as scalars");
        System.out.println("12. Compute A + Transpose(A) for a matrix A");
        System.out.println("13. Compute Eigen vectors and values");
        System.out.println("14. Solve sets of linear equations.");
        System.out.println("15. Retrieve all the existing matrices of a requested matrix-type Labels");
        System.out.println("======================================");
        System.out.println();
    }

    private static void Input() throws IOException{
        Reader.init(System.in);

        System.out.print("Enter name to refer a matrix : ");
        String name = Reader.nextLine(); // name of the matrix

        System.out.print(name +" = ");
        String input = Reader.nextLine();
        String[] Matrix = input.split(";"); 

        int rows = 1; // for counting number of rows
        for(int i = 0 ; i<input.length() ; i++){
            if(input.charAt(i) == ';'){
                rows++;
            }
        }
        
        int col = 0; // for counting number of columns
        for(int i = 0 ; i<input.length() ; i++){
            if(input.charAt(i)==';'){
                break;
            }
            else if(input.charAt(i)==','){
                continue;
            }
            else{
                col++;
            }
        }
        
        String[] m = new String[rows];

        for(int i = 0 ; i<rows ; i++){
            m[i] = Matrix[i];
        }

        float[][] matrix = new float[rows][col];

        for(int i = 0; i<rows ; i++){
            String[] M = m[i].split(",");
            for(int j = 0 ;j<col ; j++){
                matrix[i][j] = Float.parseFloat(M[j]);
            }
        }
        MatrixObject.put(name,matrix);

        // Passing the matrix to all classes //
        Square square = new Square(matrix,rows,col);
        Reactangular rectangle = new Reactangular(matrix,rows,col);
        Row row = new Row(matrix,rows,col);
        Column column = new Column(matrix, rows, col);
        Identity identity = new Identity(matrix, rows, col);
        Singleton single = new Singleton(matrix, rows, col); 
        Lower_triangular lt = new Lower_triangular(matrix, rows, col);
        Upper_triangular ut = new Upper_triangular(matrix, rows, col);
        Null nu = new Null(matrix, rows, col);
        Ones one = new Ones(matrix, rows, col);
        Scalar scalar = new Scalar(matrix, rows, col);
        Symmetric symmetry = new Symmetric(matrix, rows, col);
        Skew_Symmetric Sk_symmetry = new Skew_Symmetric(matrix, rows, col);
        Singular sin = new Singular(matrix, rows, col);

        // Saving the objects in ArrayList //
        Type.add(square);
        Type.add(rectangle);
        Type.add(row);
        Type.add(column);
        Type.add(identity);
        Type.add(single);
        Type.add(lt);
        Type.add(ut);
        Type.add(nu);
        Type.add(one);
        Type.add(scalar);
        Type.add(symmetry);
        Type.add(Sk_symmetry);
        Type.add(sin);
    }

    private static void Create() throws IOException{
        Reader.init(System.in);
        System.out.println("Type number of rows and columns for the matrix , you want to create.");
        System.out.print("Number of rows    : ");
        int rows = Reader.nextInt(); // number of rows
        System.out.print("Number of columns : ");
        int col = Reader.nextInt(); // number of columns 

        float[][] matrix = new float[rows][col]; // For creating a matrix with "rows" rows and "col" columns

        System.out.print("Enter name to refer a matrix : ");
        String name = Reader.nextLine(); // name of the matrix
        System.out.println("Enter elements "+(rows*col)+ " ELEMENTS : ");
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<col ; j++){
                matrix[i][j] = Reader.nextFloat();  // created a matrix
            }
        }
        MatrixObject.put(name,matrix);

        // Passing the matrix to all classes //
        Square square = new Square(matrix,rows,col);
        Reactangular rectangle = new Reactangular(matrix,rows,col);
        Row row = new Row(matrix,rows,col);
        Column column = new Column(matrix, rows, col);
        Identity identity = new Identity(matrix, rows, col);
        Singleton single = new Singleton(matrix, rows, col); 
        Lower_triangular lt = new Lower_triangular(matrix, rows, col);
        Upper_triangular ut = new Upper_triangular(matrix, rows, col);
        Null nu = new Null(matrix, rows, col);
        Ones one = new Ones(matrix, rows, col);
        Scalar scalar = new Scalar(matrix, rows, col);
        Symmetric symmetry = new Symmetric(matrix, rows, col);
        Skew_Symmetric Sk_symmetry = new Skew_Symmetric(matrix, rows, col);
        Singular sin = new Singular(matrix, rows, col);

        // Saving the objects in ArrayList //
        Type.add(square);
        Type.add(rectangle);
        Type.add(row);
        Type.add(column);
        Type.add(identity);
        Type.add(single);
        Type.add(lt);
        Type.add(ut);
        Type.add(nu);
        Type.add(one);
        Type.add(scalar);
        Type.add(symmetry);
        Type.add(Sk_symmetry);
        Type.add(sin);
    }

    private static void Change() throws IOException{

    }

    private static void Display() throws IOException{

    }
}