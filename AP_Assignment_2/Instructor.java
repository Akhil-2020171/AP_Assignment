package AP_Assignment.AP_Assignment_2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Instructor implements View,AddComments {

    public static HashMap<String,String>         ID_Slides = new HashMap<String,String>();            // for storing slides by specific instructor 
    public static HashMap<String,String> Slides_timestamp  = new HashMap<String,String>();            // for stroing slides with their timestamp
    public static HashMap<String,ArrayList<String>> Slides = new HashMap<String,ArrayList<String>>(); // for storing slides with slide name/title 
    public static HashMap<String,String>         ID_Videos = new HashMap<String,String>();            // for storing Videos by specific instructor 
    public static HashMap<String,String> Videos_timestamp  = new HashMap<String,String>();            // for stroing Videos with their timestamp
    public static HashMap<String,ArrayList<String>> Videos = new HashMap<String,ArrayList<String>>(); // for storing videos with video name/title
    public static HashMap<String,ArrayList<String>> ID_C   = new HashMap<String,ArrayList<String>>(); // for storing comment with specific ID
    public static HashMap<String,String> comment_timestamp = new HashMap<String,String>();            // for storing comment with their timestamp
    public static HashMap<String,ArrayList<String>>ID_St_A = new HashMap<String,ArrayList<String>>(); // for storing problem by specific instructor for Assignment
    public static HashMap<String,Integer>        Asg_Marks = new HashMap<String,Integer>();           // for storing assignment question with marks // for student class
    public static HashMap<String,ArrayList<String>>  ID_Q  = new HashMap<String,ArrayList<String>>(); // for storing Quiz problem by specific instructor

    public static Stack<String> Assignments = new Stack<String>();
    public static Stack<String> Quiz        = new Stack<String>();

    public static HashMap<String,String> ID_Sub_Asg  = Student.ID_Sub_Asg;
    public static HashMap<String,String> ID_Sub_quiz = Student.ID_Sub_quiz;

    public static HashMap<String,HashMap<String,String>> ID_SubAsg_grade  = Student.ID_SubAsg_grade;
    public static HashMap<String,HashMap<String,String>> ID_Subquiz_grade = Student.ID_Subquiz_grade;

    public static HashMap<String,HashMap<String,Integer>> ID_Asg_marks  = new HashMap<String,HashMap<String,Integer>>();
    public static HashMap<String,HashMap<String,Integer>> ID_Quiz_marks = new HashMap<String,HashMap<String,Integer>>();
    public static HashMap<String,String> Grade_inID                     = new HashMap<String,String>();

    public static HashMap<Integer,String> Instructor_ID    = new HashMap<Integer,String>();    // used in menu , for creating ids of the instructors

    public void menu(){
        // MENU //
        System.out.println("----- INSTRUCTOR's MENU -----");
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");

        Instructor_ID.put(0,"I0");               // id = 0 ------ I0
        Instructor_ID.put(1,"I1");               // id = 1 ------ I1
    }

    public void close_assessment() throws IOException{
        Reader.init(System.in);
        System.out.println("List of open Assessments");
        int a = 0;
        for(int i = 0 ; i<Assignments.size() ; i++){
            System.out.println("ID: "+i+" Assignmet: "+Assignments.get(i)+" Max Marks: "+Asg_Marks.get(Assignments.get(i)));
            a++;
        }
        System.out.println("-----------------------------------------");
        for(int i = 0 ; i<Quiz.size() ; i++){
            int c= a+i;
            System.out.println("ID: "+c+" Question: "+Quiz.get(i));
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.print("Enter ID of assessment to close : ");
        int ID = Reader.nextInt();
        if(ID<a){
            if(ID_St_A.containsKey("I0")){
                if(ID_St_A.get("I0").contains(Assignments.get(ID))){
                    ID_St_A.get("I0").remove(Assignments.get(ID));
                }
            }
            if(ID_St_A.containsKey("I1")){
                if(ID_St_A.get("I1").contains(Assignments.get(ID))){
                    ID_St_A.get("I1").remove(Assignments.get(ID));
                }
            }
        }
        else{
            if(ID_Q.containsKey("I0")){
                if(ID_Q.get("I0").contains(Quiz.get(ID-a))){
                    ID_Q.get("I0").remove(Quiz.get(ID-a));
                }
            }
            if(ID_Q.containsKey("I1")){
                if(ID_Q.get("I1").contains(Quiz.get(ID-a))){
                    ID_Q.get("I1").remove(Quiz.get(ID-a));
                }
            }
        }
    }

    public void Add_class_Materials(int option,int id) throws IOException{
        // option = 1  Add Lecture slide
        // option = 2  Add Lecture video
        // id = 0 ------ I0
        // id = 1 ------ I1
        Reader.init(System.in);
        ArrayList<String> Contents_Slides = new ArrayList<String>(); // Contents of Slides
        ArrayList<String> Contents_Videos = new ArrayList<String>(); // Contents of Videos

        String timeStamp = timestamp();

        if(option==1){
            System.out.print("Enter Topic of Slides : ");
            String Title = Reader.nextLine();
            System.out.print("Enter Number of Slides : ");
            int noOfSlides = Reader.nextInt();
            System.out.println("Enter Content of Slides");
            for(int i = 0 ; i<noOfSlides ; i++){
                int c = i+1;
                System.out.print("Content of Slide "+c+" :");
                String content = Reader.nextLine();
                Contents_Slides.add(content);
            }
            Slides.put(Title,Contents_Slides);
            ID_Slides.put(Instructor_ID.get(id),Title);
            Slides_timestamp.put(Title,timeStamp);
        }
        else if(option==2){
            System.out.print("Enter topic of Video : ");
            String Title = Reader.nextLine();
            System.out.print("Enter filename of video : ");
            String name = Reader.nextLine();
            if(name.substring(name.length()-4).equals(".mp4")){
                Contents_Videos.add(name);
                Videos.put(Title,Contents_Videos);
                ID_Videos.put(Instructor_ID.get(id),Title);
                Videos_timestamp.put(Title,timeStamp);
            }
            else{
                System.out.println("NOT A VALID FORMAT!!");
            }
        }
    }

    public void Add_Asseement(int option , int id) throws IOException{
        // option = 1  Add Assignment
        // option = 2  Add Quiz
        // id = 0 ------ I0
        // id = 1 ------ I1
        Reader.init(System.in);
        ArrayList<String> problem = new ArrayList<String>();
        ArrayList<String> quiz    = new ArrayList<String>();

        if(option==1){ // Assignment
            System.out.print("Enter problem statement : ");
            String statement = Reader.nextLine();
            System.out.print("Enter max marks : ");
            int marks = Reader.nextInt();
            problem.add(statement);
            ID_St_A.put(Instructor_ID.get(id),problem);
            Asg_Marks.put(statement,marks);
            Assignments.add(statement);
        }
        else if(option==2){ // Quiz
            System.out.print("Enter quiz question : ");
            String Question = Reader.nextLine();
            quiz.add(Question);
            ID_Q.put(Instructor_ID.get(id),quiz);
            Quiz.add(Question);
        }
    }

    public void Grade_Assessments(int In_id)throws IOException{
        Reader.init(System.in);
        System.out.println("List of Assesment");
        int a = 0;
        for(int i = 0 ; i<Assignments.size() ; i++){
            System.out.println("ID: "+i+" Assignmet: "+Assignments.get(i)+" Max Marks: "+Asg_Marks.get(Assignments.get(i)));
            a++;
        }
        System.out.println("-----------------------------------------");
        for(int i = 0 ; i<Quiz.size() ; i++){
            int c= a+i;
            System.out.println("ID: "+c+" Question: "+Quiz.get(i));
        }
        System.out.println("-----------------------------------------");
        System.out.print("Enter ID of Assement to view submission : ");
        int ID = Reader.nextInt();
        System.out.println();

        if(ID<a){
            System.out.println("Choose ID from these ungraded submission");
            if(ID_Sub_Asg.containsKey(Assignments.get(ID))){
                if(ID_SubAsg_grade.containsKey("S0")){
                    if(ID_SubAsg_grade.get("S0").get(Assignments.get(ID)).equals("ungraded")){
                        System.out.println("0.-- S0"); 
                    }
                }
                if(ID_SubAsg_grade.containsKey("S1")){
                    if(ID_SubAsg_grade.get("S1").get(Assignments.get(ID)).equals("ungraded")){
                        System.out.println("1.-- S1"); 
                    }
                }
                if(ID_SubAsg_grade.containsKey("S2")){
                    if(ID_SubAsg_grade.get("S2").get(Assignments.get(ID)).equals("ungraded")){
                        System.out.println("2.-- S2"); 
                    }
                }
            }
            int id = Reader.nextInt();
            System.out.println();
            String submission = ID_Sub_Asg.get(Assignments.get(ID));
            System.out.println("Submission: "+submission);
            System.out.println("-------------------------------------------------");
            System.out.println("Max MArks : "+Asg_Marks.get(Assignments.get(ID)));
            System.out.print("Marks Scored : ");
            int marks = Reader.nextInt();
            HashMap<String,Integer> Asg_marks = new HashMap<String,Integer>();
            Asg_marks.put(Assignments.get(ID),marks);
            Grade_inID.put(Assignments.get(ID),Instructor_ID.get(In_id));
            ID_Asg_marks.put(Student.Student_ID.get(id),Asg_marks);
            if(ID_SubAsg_grade.containsKey(Student.Student_ID.get(id))){
                ID_SubAsg_grade.get(Student.Student_ID.get(id)).replace(Assignments.get(ID),"graded");
            }
        }
        if(ID>=a){
            System.out.println("Choose ID from these ungraded submission");
            if(ID_Sub_quiz.containsKey(Quiz.get(ID))){
                if(ID_Subquiz_grade.containsKey("S0")){
                    if(ID_Subquiz_grade.get("S0").get(Quiz.get(ID)).equals("ungraded")){
                        System.out.println("0.-- S0"); 
                    }
                }
                if(ID_Subquiz_grade.containsKey("S1")){
                    if(ID_Subquiz_grade.get("S1").get(Quiz.get(ID)).equals("ungraded")){
                        System.out.println("1.-- S1"); 
                    }
                }
                if(ID_Subquiz_grade.containsKey("S2")){
                    if(ID_Subquiz_grade.get("S2").get(Quiz.get(ID)).equals("ungraded")){
                        System.out.println("2.-- S2"); 
                    }
                }
            }
            int id = Reader.nextInt();
            System.out.println();
            String submission = ID_Sub_quiz.get(Quiz.get(ID-a));
            System.out.println("Submission: "+submission);
            System.out.println("-------------------------------------------------");
            System.out.println("Max MArks : 1");
            System.out.print("Marks Scored : ");
            int marks = Reader.nextInt();
            HashMap<String,Integer> Quiz_marks = new HashMap<String,Integer>();
            Quiz_marks.put(Assignments.get(ID),marks);
            Grade_inID.put(Quiz.get(ID-a),Instructor_ID.get(In_id));
            ID_Quiz_marks.put(Student.Student_ID.get(id),Quiz_marks);
            if(ID_Subquiz_grade.containsKey(Student.Student_ID.get(id))){
                ID_Subquiz_grade.get(Student.Student_ID.get(id)).replace(Quiz.get(ID-a),"graded");
            }
        }
    }

    @Override
    public void Add_Comments(String input,int id) {
        String timeStamp = timestamp();
        if( ID_C.get(Instructor_ID.get(id))==null){
            ArrayList<String> comments = new ArrayList<String>();
            comments.add(input);
            ID_C.put(Instructor_ID.get(id),comments);
            comment_timestamp.put(input,timeStamp);
        }
        else{
            ID_C.get(Instructor_ID.get(id)).add(input);
            comment_timestamp.put(input,timeStamp);
        }
    }

    @Override
    public void View_Comment() {
        if(ID_C.containsKey("I0")){
            for(int i=0 ; i<ID_C.get("I0").size() ;i++){
                System.out.println(ID_C.get("I0").get(i)+"  --  "+"I0");
                System.out.println(comment_timestamp.get(ID_C.get("I0").get(i)));
            }
        }
        if(ID_C.containsKey("I1")){
            for(int i=0 ; i<ID_C.get("I1").size() ;i++){
                System.out.println(ID_C.get("I1").get(i)+"  --  "+"I1");
                System.out.println(comment_timestamp.get(ID_C.get("I1").get(i)));
            }
        }
    }

    @Override
    public void View_Lec_Materails() {

        if(ID_Slides.containsKey("I0")){
            // for slides //
            if(Slides.containsKey(ID_Slides.get("I0"))){
                System.out.println("Title : "+ID_Slides.get("I0"));
                int size = Slides.get(ID_Slides.get("I0")).size();
                for(int i = 1; i<=size; i++){
                    System.out.println("Slide no "+i+" : "+Slides.get(ID_Slides.get("I0")).get(i-1));
                }
                System.out.println("Number of Slides : "+size);
                System.out.println("Date of Upload : "+Slides_timestamp.get(ID_Slides.get("I0")));            ///////////////////////
                System.out.println("Uploaded by I0");
            }
            // for videos //
            if(Videos.containsKey(ID_Videos.get("I0"))){
                System.out.println("Title of the Video : "+ID_Videos.get("I0"));
                int size = Videos.get(ID_Videos.get("I0")).size();
                for(int i = 1; i<=size; i++){
                    System.out.println("Video file : "+i+" : "+Videos.get(ID_Videos.get("I0")).get(i-1));
                }
                System.out.println("Number of Videos : "+size);
                System.out.println("Date of Upload : "+Videos_timestamp.get(ID_Videos.get("I0")));            ///////////////////////
                System.out.println("Uploaded by I0");
            }
        }

        if(ID_Slides.containsKey("I1")){
            // for slides //
            if(Slides.containsKey(ID_Slides.get("I1"))){
                System.out.println("Title : "+ID_Slides.get("I1"));
                int size = Slides.get(ID_Slides.get("I1")).size();
                for(int i = 1; i<=size; i++){
                    System.out.println("Slide no "+i+" : "+Slides.get(ID_Slides.get("I1")).get(i-1));
                }
                System.out.println("Number of Slides : "+size);
                System.out.println("Date of Upload : "+Slides_timestamp.get(ID_Slides.get("I1")));            ////////////////////////
                System.out.println("Uploaded by I1");
            }
            // for videos //
            if(Videos.containsKey(ID_Videos.get("I1"))){
                System.out.println("Title of the Video : "+ID_Videos.get("I1"));
                int size = Videos.get(ID_Videos.get("I1")).size();
                for(int i = 1; i<=size; i++){
                    System.out.println("Video file : "+i+" : "+Videos.get(ID_Videos.get("I1")).get(i-1));
                }
                System.out.println("Number of Videos : "+size);
                System.out.println("Date of Upload : "+Videos_timestamp.get(ID_Videos.get("I1")));            ////////////////////////
                System.out.println("Uploaded by I1");
            }
        }
        else if(!ID_Slides.containsKey("I1") && !ID_Slides.containsKey("I0")){
            System.out.println("No Lecture Material has been added yet.");
        }        
    }

    @Override
    public void View_Assessments(){
        int p = 0;
        if(ID_St_A.containsKey("I0")){
            int size = ID_St_A.get("I0").size();
            for(int i =0 ; i<size ; i++){
                System.out.println("ID: "+p+" Assignment: "+ID_St_A.get("I0").get(i)+" Max Marks: "+Asg_Marks.get(ID_St_A.get("I0").get(i)));
                p++;
            }
        }
        if(ID_St_A.containsKey("I1")){
            int size = ID_St_A.get("I1").size();
            for(int i =0 ; i<size ; i++){
                System.out.println("ID: "+p+" Assignment: "+ID_St_A.get("I1").get(i)+" Max Marks: "+Asg_Marks.get(ID_St_A.get("I1").get(i)));
                p++;
            }
        }
        System.out.println("------------------------------------");
        if(ID_Q.containsKey("I0")){
            int size = ID_Q.get("I0").size();
            for(int i = 0; i<size ; i++){
                System.out.println("ID: "+p+" Question: "+ID_Q.get("I0").get(i));
                p++;
            }
        }
        if(ID_Q.containsKey("I1")){
            int size = ID_Q.get("I1").size();
            for(int i = 0; i<size ; i++){
                System.out.println("ID: "+p+" Question: "+ID_Q.get("I1").get(i));
                p++;
            }
        }
        System.out.println("------------------------------------");
    }


    ///// Helper method for timestamp ///////
    private String timestamp(){
        String timeStamp = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date());
        return timeStamp;
    }
}