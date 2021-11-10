import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static HashMap<String,double[][]> MatrixObject = new HashMap<>(); // ID with matrix
    private static HashMap<String,String> MatrixDimension  = new HashMap<>(); // ID with matrix dimensions
    
    private static ArrayList<Object> Type = new ArrayList<>(); // Matrix type object

    public static void main(String[] args) throws IOException{
        Reader.init(System.in);

        try{
            while(true){
                System.out.println("Press 1 to which types of matrices are implemented.");
                System.out.println("Press 2 to perform the tasks for Task menu.");
                System.out.println("Press 3 to abort operation.");
                System.out.println();
                System.out.print("Query : ");
                int query = Reader.nextInt();
        
                if(query == 1){
                    menu1(); // For to know the types of matrices
                }
                else if(query == 2){
                    menu2(); // For the functions of the matrices
                    System.out.println();
                    System.out.println("Choose task to perfom (if not press - 0):");
                    while(true){
                        int task = Reader.nextInt();
                        if(task==0){
                            break;
                        }
                        else if(task ==1){
                            Input();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task ==2){
                            Create();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task ==3){
                            Change();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task ==4){
                            Display();   
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task ==5){
                            operation();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==6){
                            element_wise();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==7){
                            Transpose();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==8){
                            Inverse();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==9){
                            Means();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==10){
                            Determinant();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==11){
                            Scalar();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==12){
                            A_At();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==13){
                            Eigen();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==14){
                            linear();
                            System.out.println("=================================");
                            System.out.println();
                        }
                        else if(task==15){
                            Retrieve();
                            System.out.println("=================================");
                            System.out.println();
                        }
                    }
                }
                else if(query==3){
                    break;
                }
                else{
                    System.out.println("Try Again!");
                }
            }
        }
        catch(Exception e){
            System.out.println("Try Again!");
        }
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

        double[][] matrix = new double[rows][col];

        for(int i = 0; i<rows ; i++){
            String[] M = m[i].split(",");
            for(int j = 0 ;j<col ; j++){
                matrix[i][j] = Double.parseDouble(M[j]);
            }
        }
        MatrixObject.put(name,matrix);
        String dimension = rows+"x"+col;
        MatrixDimension.put(name,dimension);

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

        double[][] matrix = new double[rows][col]; // For creating a matrix with "rows" rows and "col" columns

        System.out.print("Enter name to refer a matrix : ");
        String name = Reader.nextLine(); // name of the matrix
        System.out.println("Enter elements "+(rows*col)+ " ELEMENTS : ");
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<col ; j++){
                matrix[i][j] = Reader.nextDouble();  // created a matrix
            }
        }
        MatrixObject.put(name,matrix);
        String dimension = rows+"x"+col;
        MatrixDimension.put(name,dimension);

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
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose matrix Name/ID : ");
        String ID = Reader.next();

        double[][] A = MatrixObject.get(ID);
        int rows = A.length;
        int columns = A[0].length;
        // Before the Change //
        System.out.println(ID + " = ");
        for(int i = 0; i<rows ; i++){
            for(int j = 0; j<columns ; j++){
                System.out.println("  "+A[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.print("Choose which row number    : ");
        int r = Reader.nextInt();
        System.out.print("Choose which column number : ");
        int c = Reader.nextInt();
        System.out.println();
        System.out.print("Choose Number to interchange : ");
        int n = Reader.nextInt();
        System.out.println();
        A[r-1][c-1] = n;
        // After the Change //
        System.out.println(ID + " = ");
        for(int i = 0; i<rows ; i++){
            for(int j = 0; j<columns ; j++){
                System.out.println("  "+A[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static void Display() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose matrix Name/ID : ");
        String ID = Reader.next();

        // getter functions //
        if(Column.getColumn(MatrixObject.get(ID))){
            System.out.println("Column Matrix");
        }
        if(Diagonal.getDiagonal(MatrixObject.get(ID))){
            System.out.println("Diagonal Matrix");
        }
        if(Identity.getIdentity(MatrixObject.get(ID))){
            System.out.println("Identity Matrix");
        }
        if(Lower_triangular.getLT(MatrixObject.get(ID))){
            System.out.println("Lower-Triangular Matrix");
        }
        if(Null.getNull(MatrixObject.get(ID))){
            System.out.println("Null Matrix");
        }
        if(Ones.getOnes(MatrixObject.get(ID))){
            System.out.println("Ones Matrix");
        }
        if(Reactangular.getRectangular(MatrixObject.get(ID))){
            System.out.println("Rectangular Matrix");
        }
        if(Row.getRow(MatrixObject.get(ID))){
            System.out.println("Row Matrix");
        }
        if(Scalar.getScalar(MatrixObject.get(ID))){
            System.out.println("Scalar Matrix");
        }
        if(Singleton.getSingleton(MatrixObject.get(ID))){
            System.out.println("Singleton Matrix");
        }
        if(Singular.getSingular(MatrixObject.get(ID))){
            System.out.println("Singular Matrix");
        }
        if(Skew_Symmetric.getSkew(MatrixObject.get(ID))){
            System.out.println("Skew-Symmetric Matrix");
        }
        if(Square.getSquare(MatrixObject.get(ID))){
            System.out.println("Square Matrix");
        }
        if(Symmetric.getSymmetric(MatrixObject.get(ID))){
            System.out.println("Symmetric Matrix");
        }
        if(Upper_triangular.getUT(MatrixObject.get(ID))){
            System.out.println("Upper-Triangular Matrix");
        }
    }

    private static void operation() throws IOException{
        Reader.init(System.in);
        System.out.println("Choose operation to perform.");
        System.out.println("Press 1 for ADDITION");
        System.out.println("Press 2 for SUBTRACTION");
        System.out.println("Press 3 for MULTIPLICATION");
        System.out.println("Press 4 for DIVISION");

        int query = Reader.nextInt();

        if(query==1){
            // Addition //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID : ");
            String ID1 = Reader.next(); // Matrix name 1
            String ID2 = Reader.next(); // Matrix name 2

            if(MatrixDimension.get(ID1).equals(MatrixDimension.get(ID2))){
                double[][] A = MatrixObject.get(ID1);
                double[][] B = MatrixObject.get(ID2);

                int rows = (MatrixObject.get(ID1)).length;
                int columns = (MatrixObject.get(ID1))[0].length;

                double[][] b = new double[rows][columns];

                for(int i = 0 ; i<rows ; i++){
                    for(int j = 0 ; j<columns ; j++){
                        b[i][j] = A[i][j] + B[i][j];
                    }
                }

                System.out.println(MatrixObject.get(ID1)+" + "+MatrixObject.get(ID2)+" = ");
                for(int i = 0 ; i<rows ; i++){
                    for(int j = 0 ; j<columns ; j++){
                        System.out.print("    "+b[i][j]+"  ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since the dimensions of both the matrices are different , we cannot perfom Addition.");
            }
        }
        else if(query==2){
            // Subtraction //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID : ");
            String ID1 = Reader.next();
            String ID2 = Reader.next();

            if(MatrixDimension.get(ID1).equals(MatrixDimension.get(ID2))){
                double[][] A = MatrixObject.get(ID1);
                double[][] B = MatrixObject.get(ID2);

                int rows = (MatrixObject.get(ID1)).length;
                int columns = (MatrixObject.get(ID1))[0].length;

                double[][] b = new double[rows][columns];

                for(int i = 0 ; i<rows ; i++){
                    for(int j = 0 ; j<columns ; j++){
                        b[i][j] = A[i][j] - B[i][j];
                    }
                }

                System.out.println(MatrixObject.get(ID1)+" - "+MatrixObject.get(ID2)+" = ");
                for(int i = 0 ; i<rows ; i++){
                    for(int j = 0 ; j<columns ; j++){
                        System.out.print("    "+b[i][j]+"  ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since the dimensions of both the matrices are different , we cannot perfom Subtraction.");
            }
        }
        else if(query==3){
            // Multiplication //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID : ");
            String ID1 = Reader.next();
            String ID2 = Reader.next();

            double[][] A = MatrixObject.get(ID1);
            double[][] B = MatrixObject.get(ID2);

            int row1 = A.length;
            int col1 = A[0].length;

            int row2 = B.length;
            int col2 = B[0].length;

            if(row2==col1){
                double[][] b = new double[row1][col2];

                for(int i = 0; i<row1 ; i++){
                    for(int j = 0 ; j<col2 ;j++){
                        for(int k = 0 ; k<row2 ; k++){
                            b[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }

                System.out.println(MatrixObject.get(ID1)+" * "+MatrixObject.get(ID2)+" = ");
                for(int i = 0; i<row1 ; i++){
                    for(int j = 0 ; j< col2 ; j++){
                        System.out.print("  "+b[i][j]+"  ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since Columns of first is not equal to Rows of second , we cannot perfom Multiplication.");
            }

        }
        else if(query==4){
            // Division //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID : ");
            String ID1 = Reader.next();
            String ID2 = Reader.next();

            double[][] A = MatrixObject.get(ID1);
            double[][] B = MatrixObject.get(ID2);

            if(Singular.getSingular(B)==false || Singular.getSingular(A)==false){
                int row1 = A.length;
                int col1 = A[0].length;
    
                int row2 = B.length;
                int col2 = B[0].length;

                B = Inverse(B);
    
                if(row2==col1){
                    double[][] b = new double[row1][col2];
    
                    for(int i = 0; i<row1 ; i++){
                        for(int j = 0 ; j<col2 ;j++){
                            for(int k = 0 ; k<row2 ; k++){
                                b[i][j] += A[i][k] * B[k][j];
                            }
                        }
                    }
    
                    System.out.println(MatrixObject.get(ID1)+" / "+MatrixObject.get(ID2)+" = ");
                    for(int i = 0; i<row1 ; i++){
                        for(int j = 0 ; j< col2 ; j++){
                            System.out.print("  "+b[i][j]+"  ");
                        }
                        System.out.println();
                    }
                }
                else{
                    System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                    System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                    System.out.println();
                    System.out.println("Since Columns of first is not equal to Rows of second , we cannot perfom Divison.");
                }
            }
            else{
                if(Singular.getSingular(A)){
                    System.out.println("Matrix "+MatrixObject.get(ID1)+" is a Singular matrix, Hence we cannot perform Division.");
                }
                else if(Singular.getSingular(B)){
                    System.out.println("Matrix "+MatrixObject.get(ID2)+" is a Singular matrix, Hence we cannot perform Division.");
                }
            }
        }
    }

    private static void element_wise() throws IOException{
        Reader.init(System.in);
        System.out.println("Choose elemnet-wise operation to perform.");
        System.out.println("Press 1 for elemnet-wise MULTIPLICATION");
        System.out.println("Press 2 for elemnet-wise DIVISION");

        int query = Reader.nextInt();
        if(query==1){
            // elemnet-wise Multiplication //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID with same dimensions : ");
            String ID1 = Reader.next();
            String ID2 = Reader.next();

            double[][] A = MatrixObject.get(ID1);
            double[][] B = MatrixObject.get(ID2);

            int row1 = A.length;
            int col1 = A[0].length;

            int row2 = B.length;
            int col2 = B[0].length;

            if(row1==row2 && col1==col2){ // same dimensions
                double[][] C = new double[row1][col1];
                for(int i = 0 ; i<row1 ; i++){
                    for(int j =0 ; j<col1 ;j++){
                        C[i][j] = A[i][j]*B[i][j];
                    }
                }
                System.out.println(MatrixObject.get(ID1)+" .* "+MatrixObject.get(ID2)+" = ");
                for(int i = 0; i<row1 ; i++){
                    for(int j = 0 ; j< col2 ; j++){
                        System.out.print("  "+C[i][j]+"  ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since Dimensions of both the matrices are different , we cannot perfom Elementry-wise Multiplication.");
            }
        }
        else if(query==2){
            // elemnet-wise Division //
            System.out.println("Stored Matrices -----------");
            for(String key : MatrixObject.keySet()){
                System.out.println(key + " with dimension "+ MatrixDimension.get(key));
            }
    
            System.out.print("Choose any two matrix Name/ID with same dimensions : ");
            String ID1 = Reader.next();
            String ID2 = Reader.next();

            double[][] A = MatrixObject.get(ID1);
            double[][] B = MatrixObject.get(ID2);

            int row1 = A.length;
            int col1 = A[0].length;

            int row2 = B.length;
            int col2 = B[0].length;

            if(row1==row2 && col1==col2){ // same dimensions
                double[][] C = new double[row1][col1];
                for(int i = 0 ; i<row1 ; i++){
                    for(int j =0 ; j<col1 ;j++){
                        C[i][j] = A[i][j]/B[i][j];
                    }
                }
                System.out.println(MatrixObject.get(ID1)+" ./ "+MatrixObject.get(ID2)+" = ");
                for(int i = 0; i<row1 ; i++){
                    for(int j = 0 ; j< col2 ; j++){
                        System.out.print("  "+C[i][j]+"  ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
                System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since Dimensions of both the matrices are different , we cannot perfom Elementry-wise Division.");
            }
        }
    }

    private static void Transpose() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);

        int rows = A.length;
        int columns = A[0].length;

        if(rows==columns){
            double[][] B = new double[rows][columns];
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns ;j++){
                    B[i][j] = A[j][i];
                }
            }
            for(int i = 0; i<rows ; i++){
                for(int j = 0 ; j< columns ; j++){
                    System.out.print(B[i][j]+"  ");
                }
                System.out.println();
            }
        }
        else{
            double[][] B = new double[columns][rows];
            for(int i = 0; i<columns ; i++){
                for(int j =0 ; j<rows ; j++){
                    B[i][j] = A[j][i];
                }
            }
            for(int i = 0; i<columns ; i++){
                for(int j = 0 ; j<rows ; j++){
                    System.out.print(B[i][j]+"  ");
                }
                System.out.println();
            }
        }
    }

    private static void Inverse() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);
        int rows = A.length;
        int columns = A[0].length;

        if(rows==columns){
            A = Inverse(A);
            for(int i = 0; i<rows ; i++){
                for(int j = 0 ; j< columns ; j++){
                    System.out.print(A[i][j]+"  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
            System.out.println();
            System.out.println("Since matrix is not Square type, we cannot determine it's Inverse.");
        }
    }

    private static void Means() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);

        int rows = A.length;
        int columns = A[0].length;

        System.out.println();
        System.out.println("Press 1 for row wise mean.");
        System.out.println("Press 2 for column wise mean.");
        System.out.println("Press 3 for complete mean.");
        System.out.println();
        System.out.print("Query no. : ");
        int query = Reader.nextInt();

        if(query==1){
            // Row wise mean //
            double[] Rmean = new double[rows];

            for(int i = 0; i<rows ;i++){
                for(int j= 0; j<columns ; j++){
                    Rmean[i] += A[i][j];
                }
            }

            for(int j= 0; j<columns ; j++){
                Rmean[j] = Rmean[j]/columns;
            }

            System.out.println("Row Wise Mean : ");
            for(int i = 0 ; i<rows ; i++){
                System.out.print(Rmean[i] + "  ");
            }
            System.out.println();
        }
        else if(query==2){
            // Column wise mean //
            double[] Cmean = new double[columns];

            for(int i = 0 ; i<columns ; i++){
                for(int j = 0 ; j<rows ; j++){
                    Cmean[i] +=  A[j][i];
                }
            }

            for(int j = 0 ; j<rows ; j++){
                Cmean[j] =  Cmean[j]/rows;
            }

            System.out.println("Row Wise Mean : ");
            for(int i = 0 ; i<columns ; i++){
                System.out.print(Cmean[i] + "  ");
            }
            System.out.println();
        }
        else if(query==3){
            // Mean of all numbers //
            double mean = 0;
            for(int i = 0; i<rows ; i++){
                for(int j = 0 ; j<columns ; j++){
                    mean += A[i][j];
                }
            }
            int t = rows*columns;
            System.out.println("Mean of all numbers : "+ mean/t);
        }
    }

    private static void Determinant() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);
        int rows = A.length;
        int columns = A[0].length;

        if(rows==columns){
            double d = Determinant(A, rows);
            System.out.println("Determinant of "+MatrixObject.get(ID1)+" : "+d);
        }
        else{
            System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
            System.out.println();
            System.out.println("Since matrix is not Square type, we cannot determine it's Determinant.");
        }
    }

    private static void Scalar() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next(); // Matrix name 1
        double[][] A = MatrixObject.get(ID1);
        System.out.println();
        System.out.print("Choose any Singleton Matrix : ");
        String ID2 = Reader.next(); // Matrix name 2
        double[][] B = MatrixObject.get(ID2);

        if(Singleton.getSingleton(B)){
            double k = B[0][0];

            int rows = A.length;
            int columns = A[0].length;

            double[][] b = new double[rows][columns];
            for(int i=0 ; i<rows ; i++){
                for(int j = 0; j<columns ; j++){
                    b[i][j] = k*A[i][j];
                }
            }
            System.out.println();
            System.out.println(MatrixObject.get(ID2)+" * "+MatrixObject.get(ID1));
            for(int i=0; i<rows ;i++){
                for(int j = 0; j<columns; j++){
                    System.out.print("  "+b[i][j]+"  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Dimensions of matrix "+ID2+" is "+MatrixDimension.get(ID2));
            System.out.println();
            System.out.println("Since matrix is not Singleton type, we cannot use it as Scalar Quantity.");
        }
    }

    private static void A_At() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);
        int rows = A.length;
        int columns = A[0].length;

        if(rows==columns){
            double[][] B = new double[rows][columns];
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns ;j++){
                    B[i][j] = A[j][i];
                }
            }
            double[][] C = new double[rows][columns];
            for(int i = 0; i<rows ; i++){
                for(int j = 0; j<columns ; j++){
                    C[i][j] = A[i][j]+B[i][j];
                }
            }
            for(int i = 0; i<rows ; i++){
                for(int j = 0 ; j< columns ; j++){
                    System.out.print(C[i][j]+"  ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
            System.out.println();
            System.out.println("Since matrix is not Square type, we cannot determine it's Transpose.");
        }
    }

    private static void Eigen() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);

        if(Square.getSquare(A)){
            Matrix m = new Matrix(A);

            EigenvalueDecomposition eig = new EigenvalueDecomposition(m);
            
            double[][] m2 = eig.getD().getArray();

            // Eigen Values 
            for(int i = 0 ; i<m2.length ; i++){
                for(int j = 0 ; j<m2[0].length ; j++){
                    if(i==j){
                        System.out.print((double)m2[i][j]+" ");
                    }
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
            System.out.println();
            System.out.println("Since matrix is not Square type, we cannot use it to find Eigens.");
        }
    }

    private static void linear() throws IOException{
        Reader.init(System.in);
        System.out.println("Stored Matrices -----------");
        for(String key : MatrixObject.keySet()){
            System.out.println(key + " with dimension "+ MatrixDimension.get(key));
        }

        System.out.print("Choose any matrix Name/ID : ");
        String ID1 = Reader.next();

        double[][] A = MatrixObject.get(ID1);
        int rows = A.length;
        int columns = A[0].length;
        A = Inverse(A);

        if(rows==columns){
            System.out.println("Choose column Matrix with same number of rows.");
            String ID2 = Reader.next();
            double[][] B = MatrixObject.get(ID2);
            int cols = B[0].length;
            if(cols==1){
                double[][] b = new double[rows][cols];
                for(int i = 0; i<rows ; i++){
                    for(int j = 0 ; j<cols ;j++){
                        for(int k = 0 ; k<columns ; k++){
                            b[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
                for(int i = 0 ; i<rows ; i++){
                    for(int j = 0 ; j<cols ; j++){
                        System.out.print("  "+b[i][j]);
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID2));
                System.out.println();
                System.out.println("Since matrix is not Column type, we cannot use it to solve Linear Equations.");
            }
        }
        else{
            System.out.println("Dimensions of matrix "+ID1+" is "+MatrixDimension.get(ID1));
            System.out.println();
            System.out.println("Since matrix is not Square type, we cannot use it to solve Linear Equations.");
        }
    }

    private static void Retrieve() throws IOException{
        Reader.init(System.in);
        System.out.println("What type of matrix you want to retrieve.");
        menu1();
        System.out.print("Type ID number for matrix type: ");
        int type = Reader.nextInt();
        if(type==1){ // Reactangular Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Reactangular.getRectangular(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==2){ // Square Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Square.getSquare(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==3){ // Column Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Column.getColumn(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==4){ // Row Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Row.getRow(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==5){ // Symmetric Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Symmetric.getSymmetric(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==6){ // Skew - Symmetric Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Skew_Symmetric.getSkew(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==7){ // Upper-Triangular Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Upper_triangular.getUT(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==8){ // Lower-Triangular Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Lower_triangular.getLT(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==9){ //Singular Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Singular.getSingular(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==10){ // Diagonal Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Diagonal.getDiagonal(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==11){ // Scalar Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Scalar.getScalar(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==12){ // Identity Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Identity.getIdentity(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==13){ // Singleton Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Singleton.getSingleton(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==14){ // Ones Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Ones.getOnes(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        else if(type==15){ // Null Matrix
            for(String key: MatrixObject.keySet()){
                double[][] value = MatrixObject.get(key);
                if(Null.getNull(value)){
                    int rows = value.length;
                    int columns = value[0].length;
                    System.out.println(key+" = ");
                    for(int i = 0; i<rows ; i++){
                        for(int j = 0; j<columns ; j++){
                            System.out.print("  "+value[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
    }


    // Helper functions //
    

    private static double[][] Inverse(double[][] m){
        int N = m.length;
        double det = Determinant(m, N);
 
        // Find adjoint
        double [][]adj = new double[N][N];
        adjoint(m, adj);
 
        double[][] inverse = new double[N][N];
        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                inverse[i][j] = adj[i][j]/det;
            }
        }
        return inverse;
    }
    
    private static void adjoint(double A[][],double [][]adj){
        int N = A.length;
        if (N == 1){
            adj[0][0] = 1;
            return;
        }
 
        // temp is used to store cofactors of A[][]
        double sign = 1;
        double [][]temp = new double[N][N];
 
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                // Get cofactor of A[i][j]
                cofactor(A, temp, i, j, N);
 
                // sign of adj[j][i] positive if sum of row and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;
 
                // Interchanging rows and columns to get the transpose of the cofactor matrix
                adj[j][i] = (sign)*(Determinant(temp, N-1));
            }
        }
    }

    private static double Determinant(double[][] m , int n){
        double determinant = 0;

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
}