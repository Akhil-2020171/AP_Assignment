import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Menu{
    void Print(){
        System.out.println("CoWin Portal initialized.....");
        System.out.println("----------------------------------------");
        System.out.println("1. Add Vacine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("----------------------------------------");
    }
}

class Add_Vacine{

    Add_Vacine(String Vaccine_Name,int No_of_doses,int gap_btw_doses,HashMap<String,Integer> Vaccine){
        Vaccine.put(Vaccine_Name,No_of_doses);
    }
    void Print(String Vaccine_Name, int gap ,HashMap<String,Integer> Vaccine){
        System.out.println("Vaccine name: "+Vaccine_Name+", Number of Doses: "+Vaccine.get(Vaccine_Name)+", Gap between doses: "+gap);
    }
}

class Register_Hospital{

    Register_Hospital(String Hospital_Name , int Pin_Code,HashMap<String,Integer> Hospital_Pin,HashMap<Integer,String> Pin_Hospital){
        Hospital_Pin.put(Hospital_Name, Pin_Code);
        Pin_Hospital.put(Pin_Code, Hospital_Name);
    }
    void Book(int pin,HashMap<Integer,String>Pin_Hospital,HashMap<Integer,String>Pin_ID, HashMap<Integer,ArrayList<String>>Both){
        String IdName = Pin_ID.get(pin)+":"+Pin_Hospital.get(pin);
        ArrayList<String> item = new ArrayList<String>();
        item.add(IdName);

        if(!Both.containsKey(pin)){
            Both.put(pin,item);
        }
        else if(Both.containsKey(pin)){
            Both.get(pin).add(IdName);
        }
    }
    void Print(String Hospital_Name,String ID,HashMap<String,Integer> Hospital_Pin,HashMap<String,String> Hospital_ID,HashMap<Integer,String> Pin_ID
                    ,HashMap<String,String> ID_Hospital){

        ID_Hospital.put(ID,Hospital_Name);                
        Hospital_ID.put(Hospital_Name,ID);
        Pin_ID.put(Hospital_Pin.get(Hospital_Name),ID);
        System.out.println("Hospital name: "+Hospital_Name+", Pin-Code: "+Hospital_Pin.get(Hospital_Name)+", Unique ID: "+Hospital_ID.get(Hospital_Name));
    }
}

class Register_Citizen{
    
    Register_Citizen(String Citizen_Name,int Age,String Unique_ID,HashMap<String,String>Citizen_ID,HashMap<String,Integer>Citizen_age,HashMap<String,Integer>Registered){

        Citizen_ID.put(Unique_ID,Citizen_Name);
        Citizen_age.put(Unique_ID,Age);
        Registered.put(Unique_ID,1);
    }
    void print(String ID,HashMap<String,String> Citizen_ID,HashMap<String,Integer> Citizen_age){
        System.out.println("Citizen name: "+Citizen_ID.get(ID)+", Age: "+Citizen_age.get(ID)+", Unique ID: "+ID);
        if(Citizen_age.get(ID)<18) System.out.println("Only above 18 are allowed..");
    }
}

class Create_Slot{

    Create_Slot(String ID,int days,int quantity,String type,HashMap<String,Integer> ID_days,HashMap<String,Integer> ID_quantity,HashMap<String,String> ID_Type
            ,HashMap<String,String>Type_ID,HashMap<String,Integer> Type_quantity){

        ID_days.put(ID,days);
        ID_quantity.put(ID,quantity);
        ID_Type.put(ID,type);
        Type_ID.put(type,ID);
        if(Type_quantity.containsKey(type)==true){
            int q = Type_quantity.get(type)+quantity;
            Type_quantity.replace(type, q);
        }
        else{
            Type_quantity.put(type,quantity);
        }
    }
    void match(String vaccine,HashMap<String,String> ID_Hospital,HashMap<String,String>Type_ID,HashMap<String,ArrayList<String>> Match){
        String IdName = Type_ID.get(vaccine)+":"+ID_Hospital.get(Type_ID.get(vaccine));
        ArrayList<String> item = new ArrayList<String>();
        item.add(IdName);

        if(!Match.containsKey(vaccine)){
            Match.put(vaccine,item);
        }
        else if(Match.containsKey(vaccine)){
            Match.get(vaccine).add(IdName);
        }
    }
    void print(String ID,HashMap<String,Integer> ID_days,HashMap<String,Integer> ID_quantity,HashMap<String,String> ID_Type){
        System.out.println("Slot added by Hospital "+ID+" for Day: "+ID_days.get(ID)+", Available Quantity: "+ID_quantity.get(ID)+" of Vaccine "+ID_Type.get(ID));
    }
} 

class Book_Slot{
    public String ID;
    Book_Slot(String Citizen_ID){
        ID = Citizen_ID;
    }
    void print(HashMap<String,String> Status,HashMap<String,Integer> Registered){
        if(!Status.containsKey(ID) && Registered.containsKey(ID)){
            Status.put(ID, "PARTIOALLY VACCINATED");
        }
        else if(Status.get(ID) == "PARTIOALLY VACCINATED"){
            Status.replace(ID,"FULLY VACCINATED");
        }
    }
}

class Slot_Available{
    public String ID ;

    Slot_Available(String HospID){
        ID = HospID;
    }
    void print(HashMap<String,Integer> ID_days,HashMap<String,Integer> ID_quantity,HashMap<String,String> ID_Type,HashMap<String,ArrayList<String>> info,
                ArrayList<String> ArrayOfSlots ){

        String information = "Day: "+ID_days.get(ID)+" "+", Available QTY: "+ID_quantity.get(ID)+", Vaccine: "+ID_Type.get(ID);
        ArrayList<String> item = new ArrayList<String>();

        ArrayOfSlots.add(information);
        item.add(information);

        if(!info.containsKey(ID)){
            info.put(ID,item);
        }
        else if(info.containsKey(ID)){
            info.get(ID).add(information);
        }
    }
}

class Check_Status{
    Check_Status(String Patient_ID,HashMap<String,Integer> Registered,HashMap<String,String> Status){
        if(Status.containsKey(Patient_ID)){
            System.out.println(Status.get(Patient_ID));
        }
        else if(Registered.containsKey(Patient_ID)){
            System.out.println("Citizen Registered!!");
        }
        else{
            System.out.println("No status!");
        }
    }
    void print(HashMap<String,Integer> Type_quantity,HashMap<String,Integer> Doses,HashMap<String,String> ID_vaccine,String ID,HashMap<String,String> Status){
        if(ID_vaccine.containsKey(ID) && Status.containsKey(ID) )System.out.println("Vaccine name : "+ID_vaccine.get(ID));
        if(Doses.containsKey(ID_vaccine.get(ID)) && Status.containsKey(ID))System.out.println("Number Of Doses given : "+Doses.get(ID_vaccine.get(ID)));
        if(Status.get(ID) == "PARTIOALLY VACCINATED") System.out.println("Next Dose due date : 15");
    }
}

public class project{
    private static int Hospital_uniqueID = 111111;
    private static HashMap<Integer,ArrayList<String>>  Both = new HashMap<Integer,ArrayList<String>>(); // id and  name
    private static HashMap<String,ArrayList<String>> Match  = new HashMap<String,ArrayList<String>>();  // id and name
    private static HashMap<String,ArrayList<String>> info   = new HashMap<String,ArrayList<String>>();  // detail 
    private static ArrayList<String> ArrayOfSlots = new ArrayList<String>();
    private static HashMap<String,String> Status = new HashMap<String,String>();

    /// For Add Vaccine //
    private static HashMap<String,Integer> Vaccine   = new HashMap<String,Integer>(); 
    private static HashMap<String,Integer> Doses     = new HashMap<String,Integer>(); 
    private static HashMap<String,String> ID_vaccine = new HashMap<String,String>();
    /// For Register Hospital //
    private static HashMap<String,Integer> Hospital_Pin = new HashMap<String,Integer>();
    private static HashMap<Integer,String> Pin_Hospital = new HashMap<Integer,String>();
    private static HashMap<String,String> Hospital_ID = new HashMap<String,String>();
    private static HashMap<String,String> ID_Hospital = new HashMap<String,String>();
    private static HashMap<Integer,String> Pin_ID = new HashMap<Integer,String>();
    /// For Register Citizen //
    private static HashMap<String,String> Citizen_ID = new HashMap<String,String>();    
    private static HashMap<String,Integer> Citizen_age = new HashMap<String,Integer>();
    private static HashMap<String,Integer> Registered = new HashMap<String,Integer>();
    /// For Create Slot //
    private static HashMap<String,Integer> ID_days = new HashMap<String,Integer>();
    private static HashMap<String,Integer> ID_quantity = new HashMap<String,Integer>();
    private static HashMap<String,String> ID_Type  = new HashMap<String,String>();
    private static HashMap<String,String> Type_ID  = new HashMap<String,String>();
    private static HashMap<String,Integer> Type_quantity = new HashMap<String,Integer>(); 
    ////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        Menu menu = new Menu();
        int c = 1;   // for counting number of doses
        while(true){
            System.out.println();
            menu.Print();

            try{
                int n = Reader.nextInt();

                if(n==1){
                    System.out.print("Vaccine name : ");
                    String Vaccine_Name = Reader.nextLine();
                    System.out.print("Number of Doses : ");
                    int No_of_doses = Reader.nextInt();
                    if(No_of_doses>1){
                        System.out.print("Gap between Doses : ");
                        int gap_btw_doses = Reader.nextInt();
                        Add_Vacine Av = new Add_Vacine(Vaccine_Name,No_of_doses,gap_btw_doses,Vaccine);
                        Av.Print(Vaccine_Name,gap_btw_doses,Vaccine);
                        System.out.println();
                    }
                    else{
                        Add_Vacine Av = new Add_Vacine(Vaccine_Name,No_of_doses,0,Vaccine);
                        Av.Print(Vaccine_Name,0,Vaccine);
                        System.out.println();
                    }
                }
                else if(n==2){
                    System.out.print("Hospital name : ");
                    String Hospital_Name = Reader.nextLine();
                    System.out.print("PinCode : ");
                    int Pin_Code = Reader.nextInt();
                    Register_Hospital Rh = new Register_Hospital(Hospital_Name, Pin_Code,Hospital_Pin,Pin_Hospital);
                    String H_ID = Integer.toString(Hospital_uniqueID);
                    Rh.Print(Hospital_Name,H_ID,Hospital_Pin,Hospital_ID,Pin_ID,ID_Hospital);
                    System.out.println();
                    Rh.Book(Pin_Code,Pin_Hospital,Pin_ID,Both);
                    Hospital_uniqueID++;
                }
                else if(n==3){
                    System.out.print("Citizen name : ");
                    String Citizen_Name = Reader.nextLine();
                    System.out.print("Age : ");
                    int Age = Reader.nextInt();
                    System.out.print("Unique ID : ");
                    String Unique_ID = Reader.nextLine();
                    Register_Citizen Rc = new Register_Citizen(Citizen_Name,Age,Unique_ID,Citizen_ID,Citizen_age,Registered);
                    Rc.print(Unique_ID,Citizen_ID,Citizen_age);
                    System.out.println();
                }
                else if(n==4){
                    System.out.print("Enter Hospital ID : ");
                    String ID = Reader.nextLine();
                    System.out.print("Enter number of Slots to be added : ");
                    int slots = Reader.nextInt();
                    for(int i = 0; i<slots ; i++){
                        System.out.print("Enter Day Number : ");
                        int day = Reader.nextInt();
                        System.out.print("Enter Quantity : ");
                        int quantity = Reader.nextInt();
                        System.out.println("Select Vaccine---");
                        System.out.println("0. Covax");
                        System.out.println("1. Covi");
                        String[] Vaccine_Type = {"Covax","Covi"};
                        int vaccine = Reader.nextInt();
                        Create_Slot Cs = new Create_Slot(ID,day,quantity,Vaccine_Type[vaccine],ID_days,ID_quantity,ID_Type,Type_ID,Type_quantity);
                        Cs.print(ID,ID_days,ID_quantity,ID_Type);
                        Cs.match(Vaccine_Type[vaccine], ID_Hospital, Type_ID, Match);
                        System.out.println();
                        Slot_Available Sa = new Slot_Available(ID);
                        Sa.print(ID_days, ID_quantity, ID_Type, info,ArrayOfSlots);
                    }
                }
                else if(n==5){
                    System.out.print("Enter Patient Unique ID : ");
                    String ID = Reader.nextLine();
                    System.out.println("1. Search by area...");
                    System.out.println("2. Search by Vaccine ...");
                    System.out.println("3. Exit...");
                    System.out.print("Enter Option : ");
                    int option = Reader.nextInt();
                    if(option==1){
                        System.out.print("Enter Pin-Code : ");
                        int PinCode = Reader.nextInt();
                        System.out.println(Both.get(PinCode));
                        System.out.print("Enter Hospital ID : ");
                        String HospID = Reader.nextLine();
                        if(info.containsKey(HospID)){
                            for(int i = 0; i<info.get(HospID).size() ; i++){
                                System.out.println(i+"-> "+info.get(HospID).get(i));
                            }
                            System.out.print("Choose Slot : ");
                            int slotnumber = Reader.nextInt();
                            if(ArrayOfSlots.get(slotnumber)!=null){
                                String[] parts = ArrayOfSlots.get(slotnumber).split(" ");
                                String type = parts[parts.length-1];
                                Book_Slot Bs = new Book_Slot(ID);
                                Bs.print(Status,Registered);
                                if(Citizen_ID.containsKey(ID)){
                                    System.out.println(Citizen_ID.get(ID)+" vaccinated with "+type);
                                    ID_vaccine.put(ID,type);
                                    int new_Quanity = Type_quantity.get(type)-1;
                                    Type_quantity.replace(type,new_Quanity);
                                    ID_quantity.replace(HospID, new_Quanity);
                                    if(!Doses.containsKey(type)){
                                        Doses.put(type,c);
                                    }
                                    else{
                                        c++;
                                        Doses.replace(type,c);
                                    }
                                }
                                else{
                                    System.out.println("Citizen needs to register himself or herself in CoWin Portal!!");
                                }
                            }
                            else{
                                System.out.println("Invalid Slot Number!");
                            }
                        }
                        else{
                            System.out.println("No Slot Available..");
                        }
                    }
                    else if(option==2){
                        System.out.print("Enter Vaccine Name : ");
                        String VacName = Reader.nextLine();
                        System.out.println(Match.get(VacName));
                        System.out.print("Enter Hospital ID : ");
                        String HospID = Reader.nextLine();
                        if(info.containsKey(HospID)){
                            for(int i = 0; i<info.get(HospID).size() ; i++){
                                System.out.println(i+"-> "+info.get(HospID).get(i));
                            }
                            System.out.print("Choose Slot : ");
                            int slotnumber = Reader.nextInt();
                            if(ArrayOfSlots.get(slotnumber)!=null){
                                String[] parts = ArrayOfSlots.get(slotnumber).split(" ");
                                String type = parts[parts.length-1];
                                Book_Slot Bs = new Book_Slot(ID);
                                Bs.print(Status,Registered);
                                if(Citizen_ID.containsKey(ID)){
                                    System.out.println(Citizen_ID.get(ID)+" vaccinated with "+type);
                                    ID_vaccine.put(ID,type);
                                    int new_Quanity = Type_quantity.get(type)-1;
                                    Type_quantity.replace(type,new_Quanity);
                                    ID_quantity.replace(HospID, new_Quanity);
                                    if(!Doses.containsKey(type)){
                                        Doses.put(type,c);
                                    }
                                    else{
                                        c++;
                                        Doses.replace(type,c);
                                    }
                                }
                                else{
                                    System.out.println("Citizen needs to register him/her in CoWin Portal!!");
                                }
                            }
                            else{
                                System.out.println("Invalid Slot Number!");
                            }
                        }
                        else{
                            System.out.println("No Slot Available..");
                        }
                    }
                    else{
                        continue;
                    }
                }
                else if(n==6){
                    System.out.print("Enter Hospital ID : ");
                    String HospID = Reader.nextLine();
                    System.out.println(info.get(HospID));
    
                }
                else if(n==7){
                    System.out.print("Enter Patient ID : ");
                    String Pa_ID = Reader.nextLine();
                    Check_Status CS = new Check_Status(Pa_ID,Registered,Status);
                    CS.print(Type_quantity,Doses,ID_vaccine,Pa_ID,Status);
                }
                else if(n==8){
                    System.out.println("END!");
                    break;
                }
            }
            catch(IOException e){
                System.out.println("Invalid query number!!! Please try again or Press 8 for EXIT");
                System.out.println();
            }
        }
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static String nextLine() throws IOException {
    return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
}