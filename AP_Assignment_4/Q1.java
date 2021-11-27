import java.io.IOException;
//import java.util.Arrays;  // for sorting arrays

public class Q1{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        
        // int N = Reader.nextInt(); // Number of books
        // int K = Reader.nextInt(); // Number of racks

        BookGenerics<String,Integer,Integer> Book = new BookGenerics<String,Integer,Integer>();

        while(true){
            System.out.println();
            System.out.println("Enter book title , ISBN and bar-code or press 0 in title name to abort.");
            System.out.println();
            System.out.print("Enter Tile/Name : ");
            String title = Reader.nextLine();
            if(title.equals("0")){
                break;
            }
            System.out.print("Enter ISBN : ");
            Integer ISBN = Reader.nextInt();
            System.out.print("Enter Bar-Code : ");
            Integer Barcode = Reader.nextInt() ;
            System.out.println();
            // Storing the books //
            Book.add(title,ISBN,Barcode);
        }
        Book.sort();
        Book.show();
        
    }
}