package AP_Assignment_2;

import java.io.IOException;

public class Project2{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);

        while(true){
            System.out.println();
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as an Instructor");
            System.out.println("2. Enter as a Student");
            System.out.println("3. Exit");
        
            try{
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
                            In.View_Lec_Materails();
                        }
                        else if(access==4){
                            In.View_Assessments();
                        }
                        else if(access==5){

                        }
                        else if(access==6){

                        }
                        else if(access==7){

                        }
                        else if(access==8){
                            System.out.println();
                            System.out.print("Enter Comment : ");
                            String comment = Reader.nextLine();
                            In.Add_Comments(comment,id);
                        }
                        else if(access == 9){
                            System.out.println();
                            System.out.println("You have been successfully Logged Out.");
                            break;
                        }
                    }
                }
                else if(option==2){
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
                            st.View_Lec_Materails();
                        }
                        else if(access==2){
                            st.View_Assessments();
                        }
                        else if(access==3){

                        }
                        else if(access==4){

                        }
                        else if(access==5){

                        }
                        else if(access==6){

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
            catch(Exception e){
                System.out.println("Try Again!!");
            }
        }
    }
}