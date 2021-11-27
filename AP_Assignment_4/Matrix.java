import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Matrix{
    private HashMap<String,ArrayList<Object[]>> ColorMatrix = new HashMap<String,ArrayList<Object[]>>();
    private HashMap<String,ArrayList<Object[]>> GrayMatrix  = new HashMap<String,ArrayList<Object[]>>();
    private ArrayList<Object[]> CM = new ArrayList<Object[]>();
    private ArrayList<Object[]> GM = new ArrayList<Object[]>();

    Matrix(){
        ColorMatrix.put("C",CM);
        GrayMatrix.put("G",GM);
    }

    public void input() throws IOException{
        System.out.print("Press 1 for Color image or Press 2 for Grayscale image : ");
        int choice = Reader.nextInt();

        if(choice==1){
            ArrayList<Object> nums = new ArrayList<Object>();
            System.out.println();
            System.out.println("Enter numbers");
            
            while(true){
                try{
                    int p = Reader.nextInt();
                    nums.add(p);
                }
                catch(Exception e){
                    break;
                }
            }
            int c = 0;
            for(int i = 0 ; i<nums.size()/3;i++){
                Object [] matrix = new Object[3];
                for(int j = 0; j<3 ; j++){
                    matrix[j] = nums.get(c);
                    c++;
                }
                ColorMatrix.get("C").add(matrix);
            }

        }
        if(choice==2){
            ArrayList<Object> nums = new ArrayList<Object>();
            System.out.println();
            System.out.println("Enter numbers");
            while(true){
                try{
                    int p = Reader.nextInt();
                    nums.add(p);
                }
                catch(Exception e){
                    break;
                }
            }
            int c = 0;
           
            for(int i = 0 ; i<nums.size();i++){
                Object [] matrix = new Object[1];
                matrix[0] = nums.get(c);
                c++;
                GrayMatrix.get("G").add(matrix);
            }

        }
    }

    public void create() throws IOException{
        Reader.init(System.in);
        System.out.print("Press 1 for Color image or Press 2 for Grayscale image : ");
        int choice = Reader.nextInt();
        if(choice==1){ // color image//
            System.out.println();
            System.out.println("Choose dimension of a matrix");
            System.out.print("Enter number of rows : ");
            int rows = Reader.nextInt();
            System.out.print("Enter number of columns : ");
            int columns = Reader.nextInt();
            Object[] E1 = {1,1,1}; // for color matrix
            Object [][]matrix = new Object[rows][columns];
            for(int i = 0; i<rows ; i++){
                matrix[i] = E1;
            }
            ColorMatrix.get("C").add(matrix);
        }
        if(choice==2){ // gray image //
            System.out.println();
            System.out.println("Choose dimension of a matrix");
            System.out.print("Enter number of rows : ");
            int rows = Reader.nextInt();
            System.out.print("Enter number of columns : ");
            int columns = Reader.nextInt();
            Object[] E1 = {0,0,0}; // for gray matrix
            Object [][]matrix = new Object[rows][columns];
            for(int i = 0; i<rows ; i++){
                matrix[i] = E1;
            }
            GrayMatrix.get("G").add(matrix);
        }
    }

    public void update() throws IOException{
        Reader.init(System.in);
        if(ColorMatrix.containsKey("C") && !ColorMatrix.get("C").isEmpty()){
            ArrayList<Object[]> C_M = ColorMatrix.get("C");
            for(int i = 0  ; i< C_M.size() ; i++){
                System.out.println("Color :" + i + "  "+Arrays.toString(C_M.get(i)));
            }
            System.out.println();
            System.out.print("Choose number to select matrix you want to update :");
            int choice  = Reader.nextInt();
            Object [] matrix = C_M.get(choice);
            C_M.remove(matrix);
            System.out.print("Enter numbers : ");
            String[] p = Reader.nextLine().split(" ");
            Object[] m = new Object[3];
            for(int i = 0 ; i<3 ;i++){
                m[i] = Integer.parseInt(p[i]);
            }
            C_M.add(m);
            ColorMatrix.replace("C",C_M);

        }
        if(GrayMatrix.containsKey("G") && !GrayMatrix.get("G").isEmpty()){
            ArrayList<Object[]> G_M = GrayMatrix.get("G");
            for(int i = 0  ; i< G_M.size() ; i++){
                System.out.println("Gray :" + i + "  "+Arrays.toString(G_M.get(i)));
            }
            System.out.println();
            System.out.print("Choose number to select matrix you want to update :");
            int choice  = Reader.nextInt();
            Object [] matrix = G_M.get(choice);
            G_M.remove(matrix);
            System.out.print("Enter numbers : ");
            String[] p = Reader.nextLine().split(" ");
            Object[] m = new Object[3];
            for(int i = 0 ; i<3 ;i++){
                m[i] = Integer.parseInt(p[i]);
            }
            G_M.add(m);
            GrayMatrix.replace("G",G_M);
        }
    }

    public void display() throws IOException{
        System.out.print("Enter which image you want to see (C for color and G for Gray) : ");
        String choice = Reader.next();
        if(choice.equals("C")){
            if(ColorMatrix.containsKey("C") && !ColorMatrix.get("C").isEmpty()){
                ArrayList<Object[]> C_M = ColorMatrix.get("C");
                for(int i = 0  ; i< C_M.size() ; i++){
                    System.out.println("Color : " + i + "  "+Arrays.toString(C_M.get(i)));
                }
            }
        }
        System.out.println();
        if(choice.equals("G")){
            if(GrayMatrix.containsKey("G") && !GrayMatrix.get("G").isEmpty()){
                ArrayList<Object[]> G_M = GrayMatrix.get("G");
                for(int i = 0  ; i< G_M.size() ; i++){
                    System.out.println("Gray : " + i + "  "+Arrays.toString(G_M.get(i)));
                }
            }
        }
        System.out.println();
    }

    public void computeNegative() throws IOException{
        Reader.init(System.in);
        System.out.println();
        if(ColorMatrix.containsKey("C") && !ColorMatrix.get("C").isEmpty()){
            ArrayList<Object[]> C_M = ColorMatrix.get("C");
            for(int i = 0  ; i< C_M.size() ; i++){
                int c  = i+1;
                System.out.println("Color :" + c + "  "+Arrays.toString(C_M.get(i)));
            }
        }
        System.out.println();
        if(GrayMatrix.containsKey("G") && !GrayMatrix.get("G").isEmpty()){
            ArrayList<Object[]> G_M = GrayMatrix.get("G");
            for(int i = 0  ; i< G_M.size() ; i++){
                int c = i+1;
                System.out.println("Gray :" + c + "  "+Arrays.toString(G_M.get(i)));
            }
        }
        System.out.println();
        System.out.print("Select Color image or Gray image (C/G) : ");
        String image = Reader.next();
        if(image.equals("C")){
            if(ColorMatrix.containsKey("C") && !ColorMatrix.get("C").isEmpty()){
                ArrayList<Object[]> C_M = ColorMatrix.get("C");
                for(int i = 0 ; i<C_M.size() ;i++){
                    int p = 0;
                    for(int j = 0 ; j<3 ; j++){
                        p = (int)C_M.get(i)[j];
                        p = 255 - (int)C_M.get(i)[j];
                    }
                    for(int j = 0 ; j<3 ;j++){
                        System.out.print(p+"  ");
                    }
                    System.out.println();
                }
            }
        }
        if(image.equals("G")){
            if(GrayMatrix.containsKey("G") && !GrayMatrix.get("G").isEmpty()){
                ArrayList<Object[]> G_M = GrayMatrix.get("G");
                for(int i = 0; i<G_M.size();i++){
                    int p = 0;
                    for(int j = 0; j<1 ;j++){
                        p = (int)G_M.get(i)[j];
                        p = 255 - (int)G_M.get(i)[j];
                    }
                    for(int j = 0 ; j<1 ;j++){
                        System.out.print(p+"  ");
                    }
                    System.out.println();
                }
            }
        }
    }
}