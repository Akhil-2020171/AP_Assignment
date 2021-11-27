import java.io.IOException;

public class Q2 {
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        Matrix matrix = new Matrix();
        while(true){
            System.out.println();
            menu();
            System.out.println();
            int query = Reader.nextInt();
            if(query==0){
                break;
            }
            if(query==1){
                matrix.input();
            }
            if(query==2){
                matrix.create();
            }
            if(query==3){
                matrix.update();
            }
            if(query==4){
                matrix.display();
            }
            if(query==5){
                matrix.computeNegative();
            }
        }
    }
    private static void menu(){

        System.out.println("Press 0 for aborting the process");
        System.out.println("Press 1 for input operation");
        System.out.println("Press 2 for create operation");
        System.out.println("Press 3 for update operation");
        System.out.println("Press 4 for display operstion");
        System.out.println("Press 5 for negative opertaion");
        
    }
}