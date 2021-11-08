package AP_Assignment.AP_Assignment_2;

import java.io.IOException;

public class Portal{
    public static void main(String[] args) throws IOException{

        Reader.init(System.in);

        while(true){
            System.out.println();
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as an Instructor");
            System.out.println("2. Enter as a Student");
            System.out.println("3. Exit");
        
            int option = Reader.nextInt();
            if(option==1){
                System.out.println();
                System.out.println("Instructors:");
                System.out.println("0 - I0");
                System.out.println("1 - I1");
                System.out.print("Choose ID : ");

                int id = Reader.nextInt();
                System.out.println();            

                Instructor In = new Instructor();

                while(true){
                    if(id==0){
                        System.out.println("Welcome I0");
                    }
                    else if (id==1){
                        System.out.println("Welcome I1");
                    }
                    System.out.println();
                    In.menu();
                    int access = Reader.nextInt();
                    if(access == 1){
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        int choose = Reader.nextInt();
                        In.Add_class_Materials(choose,id);
                    }
                    else if(access==2){
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int choose = Reader.nextInt();
                        In.Add_Asseement(choose,id);
                    }
                    else if(access==3){
                        View instructor = new Instructor();
                        instructor.View_Lec_Materails();
                    }
                    else if(access==4){
                        View instructor = new Instructor();
                        instructor.View_Assessments();
                    }
                    else if(access==5){
                        In.Grade_Assessments(id);
                    }
                    else if(access==6){
                        In.close_assessment();
                    }
                    else if(access==7){
                        View instructor = new Instructor();
                        View student    = new Student();
                        instructor.View_Comment();
                        student.View_Comment();
                        System.out.println();
                    }
                    else if(access==8){
                        System.out.println();
                        System.out.print("Enter Comment : ");
                        String comment = Reader.nextLine();
                        AddComments instuctor = new Instructor();
                        instuctor.Add_Comments(comment,id);
                    }
                    else if(access == 9){
                        System.out.println();
                        System.out.println("You have been successfully Logged Out.");
                        break;
                    }
                }
            }
            if(option==2){
                System.out.println();
                System.out.println("Students:");
                System.out.println("0 - S0");
                System.out.println("1 - S1");
                System.out.println("2 - S2");
                System.out.print("Choose ID : ");
                int id = Reader.nextInt();
                System.out.println();

                Student st = new Student();

                while(true){
                    if(id==0){
                        System.out.println("Welcome S0");
                    }
                    else if (id==1){
                        System.out.println("Welcome S1");
                    }
                    else if(id==2){
                        System.out.println("Welcome S2");
                    }
                    System.out.println();
                    st.menu();

                    int access = Reader.nextInt();
                    
                    if(access==1){
                        View student = new Student();
                        student.View_Lec_Materails();
                    }
                    else if(access==2){
                        View student = new Student();
                        student.View_Assessments();
                    }
                    else if(access==3){
                        st.Sumbit_Assessment(id);
                    }
                    else if(access==4){
                        st.view_grade(id);
                    }
                    else if(access==5){
                        View instructor = new Instructor();
                        View student    = new Student();
                        instructor.View_Comment();
                        student.View_Comment();
                        System.out.println();
                    }
                    else if(access==6){
                        System.out.println();
                        System.out.print("Enter Comment : ");
                        String comment = Reader.nextLine();
                        AddComments student = new Student();
                        student.Add_Comments(comment, id);
                    }
                    else if(access==7){
                        System.out.println();
                        System.out.println("You have been successfully Logged Out.");
                        break;
                    }
                }
            }
            else if(option==3){
                System.out.println();
                System.out.println("======== EXIT ========");
                break;
            }
        }
    }
}