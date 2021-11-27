import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BookGenerics <B,I,C> {
    private ArrayList<B> BookList = new ArrayList<B>();
    private HashMap<B,I> BookIsbn = new HashMap<B,I>();
    private HashMap<B,C> BookCode = new HashMap<B,C>();

    private int size;
    private String[] B;

    private B book;
    private I ISBN;
    private C Code;

    private void Set(){
        BookList.add(book);
        BookIsbn.put(book,ISBN);
        BookCode.put(book,Code);
    }

    public void sort(){
        this.size = BookList.size();
        String Book[] = new String[size];
        for(int i = 0 ; i<size ; i++){
            Book[i] = (String)BookList.get(i);
        }
        Arrays.sort(Book);
        B = Book;
    }

    public void add(B Book, I Isbn , C Code){
        this.book = Book;
        this.ISBN = Isbn;
        this.Code = Code;
        Set();
    }

    public void show(){
        System.out.println();
        System.out.printf("%15s%15s%20s","Book Name","ISBN","Bar-Code");
        System.out.println();
        for(int i = 0 ; i<size; i++){
            System.out.printf("%-5s%10s%15s%20s\n",i+1,B[i],BookIsbn.get(B[i]),BookCode.get(B[i]));
        }
    }
}