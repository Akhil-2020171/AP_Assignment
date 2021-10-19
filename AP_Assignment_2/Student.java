package AP_Assignment_2;

import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements View,AddComments {
 
    public static HashMap<String,String>        comment_timestamp = new HashMap<String,String>();                      // for storing comment with their timestamp
    public static HashMap<String,ArrayList<String>> ID_comment    = new HashMap<String,ArrayList<String>>();           // ID with comment
    public static HashMap<String,String> ID_Sub_Asg               = new HashMap<String,String>();
    public static HashMap<String,String> ID_Sub_quiz              = new HashMap<String,String>();
    public static  HashMap<String,Stack<String>>    ID_Asg      = new HashMap<String,Stack<String>>();
    public static HashMap<String,Stack<String>>     ID_Quiz     = new HashMap<String,Stack<String>>();
     
    public static HashMap<String,Integer> Asg_Marks  = Instructor.Asg_Marks;  
    public static Stack<String> Assignments          = Instructor.Assignments;
    public static Stack<String> Quiz                 = Instructor.Quiz;
    public static HashMap<String,String> Grade_inID  = Instructor.Grade_inID;
    public static HashMap<String,HashMap<String,Integer>> ID_Asg_marks  = Instructor.ID_Asg_marks;
    public static HashMap<String,HashMap<String,Integer>> ID_Quiz_marks = Instructor.ID_Quiz_marks; 

    public static HashMap<String,HashMap<String,String>> ID_SubAsg_grade  = new HashMap<String,HashMap<String,String>>();
    public static HashMap<String,HashMap<String,String>> ID_Subquiz_grade = new HashMap<String,HashMap<String,String>>();
    public static HashMap<Integer,String> Student_ID         = new HashMap<Integer,String>();                     // used in menu , for creating ids of the instructors

    public void menu(){
        // MENU //
        System.out.println("----- STUDENT's MENU -----");
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");

        Student_ID.put(0,"S0");   // 0 -- S0 //
        Student_ID.put(1,"S1");   // 1 -- S1 //
        Student_ID.put(2,"S2");   // 2 -- S2 //

    }

    public void view_grade(int id){
        System.out.println("Graded Submission");
        for(int i = 0; i<Assignments.size() ; i++){
            if(ID_SubAsg_grade.containsKey(Student_ID.get(id))){
                if(ID_SubAsg_grade.get(Student_ID.get(id)).containsKey(Assignments.get(i))){
                    if(ID_SubAsg_grade.get(Student_ID.get(id)).get(Assignments.get(i)).equals("graded")){
                        System.out.println("Submission   : "+ID_Sub_Asg.get(Assignments.get(i)));
                        System.out.println("Marks Scored : "+ID_Asg_marks.get(Student_ID.get(id)).get(Assignments.get(i)));
                        System.out.println("Graded by    : "+Grade_inID.get(Assignments.get(i)));
                    }
                }
            }
        }
        for(int i = 0 ; i<Quiz.size() ; i++){
            if(ID_Subquiz_grade.containsKey(Student_ID.get(id))){
                if(ID_Subquiz_grade.get(Student_ID.get(id)).get(Quiz.get(i)).equals("graded")){
                    System.out.println("Submission   : "+ID_Sub_quiz.get(Quiz.get(i)));
                    System.out.println("Marks Scored : "+ID_Quiz_marks.get(Student_ID.get(id)).get(Quiz.get(i)));
                    System.out.println("Graded by    : "+Grade_inID.get(Quiz.get(i)));
                }
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("Ungraded Submission");
        for(int i = 0; i<Assignments.size() ; i++){
            if(ID_SubAsg_grade.containsKey(Student_ID.get(id))){
                if(ID_SubAsg_grade.get(Student_ID.get(id)).containsKey(Assignments.get(i))){
                    if(ID_SubAsg_grade.get(Student_ID.get(id)).get(Assignments.get(i)).equals("ungraded")){
                        System.out.println("Submission   : "+ID_Sub_Asg.get(Assignments.get(i)));
                    }
                }
            }
        }
        for(int i = 0 ; i<Quiz.size() ; i++){
            if(ID_Subquiz_grade.containsKey(Student_ID.get(id))){
                if(ID_Subquiz_grade.get(Student_ID.get(id)).get(Quiz.get(i)).equals("ungraded")){
                    System.out.println("Submission   : "+ID_Sub_quiz.get(Quiz.get(i)));
                }
            }
        }
        System.out.println("----------------------------------------------");
    }

    public void Sumbit_Assessment(int id) throws IOException {
        Reader.init(System.in);
        System.out.println("Pending Assessment");
        Stack<String> asg  = Assignments;
        Stack<String> quiz = Quiz;

        int a = 0;

        for(int i = 0; i<asg.size() ; i++){
            System.out.println("ID: "+i+" Assignment "+asg.get(i)+" Max Marks: "+Asg_Marks.get(asg.get(i)));
            a++;
        }

        for(int i = 0 ; i<quiz.size() ; i++){
            int c = i+a;
            System.out.println("ID: "+c+" Question: "+quiz.get(i));
        }

        System.out.print("Enter ID of Assessment : ");
        int ID = Reader.nextInt();

        HashMap<String,String> grade = new HashMap<String,String>();
        if(ID<a){
            System.out.print("Enter filname of assignment : ");
            String name = Reader.nextLine();
            if(name.substring(name.length()-4).equals(".zip")){
                ID_Sub_Asg.put(asg.get(ID),name);
                grade.put(asg.get(ID),"ungraded");
                ID_SubAsg_grade.put(Student_ID.get(id),grade);
            }
            else{
                System.out.println("Invalid Format");
            }
        }
        else if(ID>=a){
            System.out.print(Quiz.get(ID-a)+" : ");
            String answer = Reader.nextLine();

            ID_Sub_quiz.put(asg.get(ID-a),answer);
            grade.put(quiz.get(ID-a),"ungraded");
            ID_Subquiz_grade.put(Student_ID.get(id), grade);
            
            quiz.remove(quiz.get(ID-a));
            ID_Quiz.put(Student_ID.get(id), quiz);
        }
    }

    @Override
    public void Add_Comments(String input,int id) {
        String timeStamp = timestamp();
        if(ID_comment.get(Student_ID.get(id)) == null){
            ArrayList<String> comment = new ArrayList<String>();
            comment.add(input);
            ID_comment.put(Student_ID.get(id),comment);
            comment_timestamp.put(input,timeStamp);
        }
        else{
            ID_comment.get(Student_ID.get(id)).add(input);
            comment_timestamp.put(input,timeStamp);
        }
    }

    @Override
    public void View_Comment() {
        if(ID_comment.containsKey("S0")){
            for(int i = 0 ; i<ID_comment.get("S0").size() ; i++){
                System.out.println(ID_comment.get("S0").get(i)+" -- "+"S0");
                System.out.println(comment_timestamp.get(ID_comment.get("S0").get(i)));
            }
        }
        if(ID_comment.containsKey("S1")){
            for(int i = 0 ; i<ID_comment.get("S1").size() ; i++){
                System.out.println(ID_comment.get("S1").get(i)+" -- "+"S1");
                System.out.println(comment_timestamp.get(ID_comment.get("S1").get(i)));
            }
        }
        if(ID_comment.containsKey("S2")){
            for(int i = 0 ; i<ID_comment.get("S2").size() ; i++){
                System.out.println(ID_comment.get("S2").get(i)+" -- "+"S2");
                System.out.println(comment_timestamp.get(ID_comment.get("S2").get(i)));
            }  
        }
    }

    @Override
    public void View_Lec_Materails() {
        View In = new Instructor();
        In.View_Lec_Materails();
    }

    @Override
    public void View_Assessments() {
        View In = new Instructor();
        In.View_Assessments();
    }

    //// Helper method for timestamp ////
    private String timestamp(){
        String timeStamp = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date());
        return timeStamp;
    }
}