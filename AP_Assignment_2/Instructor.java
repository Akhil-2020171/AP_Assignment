package AP_Assignment_2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Instructor implements View,AddComments {

    public static HashMap<String,String>         ID_Slides = new HashMap<String,String>();            // for storing slides by specific instructor 
    public static HashMap<String,String> Slides_timestamp  = new HashMap<String,String>();            // for stroing slides with their timestamp
    public static HashMap<String,ArrayList<String>> Slides = new HashMap<String,ArrayList<String>>(); // for storing slides with slide name/title 
    public static HashMap<String,String>         ID_Videos = new HashMap<String,String>();            // for storing Videos by specific instructor 
    public static HashMap<String,String> Videos_timestamp  = new HashMap<String,String>();            // for stroing Videos with their timestamp
    public static HashMap<String,ArrayList<String>> Videos = new HashMap<String,ArrayList<String>>(); // for storing videos with video name/title 
    public static HashMap<String,ArrayList<String>>ID_St_A = new HashMap<String,ArrayList<String>>(); // for storing problem by specific instructor for Assignment
    public static HashMap<String,Integer>        Asg_Marks = new HashMap<String,Integer>();           // for storing assignment question with marks
    public static HashMap<String,ArrayList<String>>ID_Q    = new HashMap<String,ArrayList<String>>(); // for storing Quiz problem by specific instructor
    public static HashMap<String,ArrayList<String>> ID_C   = new HashMap<String,ArrayList<String>>(); // for storing comment with specific ID
    public static HashMap<String,String> comment_timestamp = new HashMap<String,String>();            // for storing comment with their timestamp

    public static HashMap<Integer,String> Instructor_ID    = new HashMap<Integer,String>();           // used in menu , for creating ids of the instructors

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
            if(name.substring(name.length()-3).equals("mp4")){
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
        }
        else{ // Quiz
            System.out.print("Enter quiz question : ");
            String Question = Reader.nextLine();
            quiz.add(Question);
            ID_Q.put(Instructor_ID.get(id),quiz);
        }
    }

    public void Grade_Assessments(){

    }

    @Override
    public void Add_Comments(String input,int id) {
        String timeStamp = timestamp();
        ArrayList<String> comments = new ArrayList<String>();
        comments.add(input);
        ID_C.put(Instructor_ID.get(id),comments);
        comment_timestamp.put(input,timeStamp);
    }

    @Override
    public void View_Comment() {
        // TODO Auto-generated method stub
        
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
        else{
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
            }
            p++;
        }
        if(ID_St_A.containsKey("I1")){
            int size = ID_St_A.get("I1").size();
            for(int i =0 ; i<size ; i++){
                System.out.println("ID: "+p+" Assignment: "+ID_St_A.get("I1").get(i)+" Max Marks: "+Asg_Marks.get(ID_St_A.get("I1").get(i)));
            }
            p++;
        }
        System.out.println("------------------------------------");
        if(ID_Q.containsKey("I0")){
            int size = ID_Q.get("I0").size();
            for(int i = 0; i<size ; i++){
                System.out.println("ID: "+p+" Question: "+ID_Q.get("I0").get(i));
            }
            p++;
        }
        if(ID_Q.containsKey("I1")){
            int size = ID_Q.get("I1").size();
            for(int i = 0; i<size ; i++){
                System.out.println("ID: "+p+" Question: "+ID_Q.get("I1").get(i));
            }
            p++;
        }
        System.out.println("------------------------------------");
    }


    ///// Helper method for timestamp ///////
    private String timestamp(){
        String timeStamp = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date());
        return timeStamp;
    }
}