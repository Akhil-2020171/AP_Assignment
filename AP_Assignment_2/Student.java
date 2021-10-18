package AP_Assignment_2;

import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements View ,AddComments {

    public static HashMap<String,String> Pen_Asg = new HashMap<String,String>();                    // for storing pending assessments

    public static HashMap<Integer,String> Student_ID    = new HashMap<Integer,String>();            // used in menu , for creating ids of the instructors

    public void menu(){
        System.out.println("----- STUDENT's MENU -----");
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
        Student_ID.put(0,"S0");
        Student_ID.put(1,"S1");
        Student_ID.put(2,"S2");
    }

    public void Sumbit_Assessment(int id){
        
    }

    @Override
    public void Add_Comments(String input,int id) {
        String timeStamp = timestamp();
        System.out.println(timeStamp);                       ////////////////////
    }

    @Override
    public void View_Comment() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void View_Lec_Materails() {
        Instructor In = new Instructor();
        In.View_Lec_Materails();
    }

    @Override
    public void View_Assessments() {
        Instructor In = new Instructor();
        In.View_Assessments();
    }

    //// Helper method for timestamp ////
    private String timestamp(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").format(new Date());
        return timeStamp;
    }
}