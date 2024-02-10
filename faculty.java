import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class faculty extends university{
    String name1= "Shreya",name2= "Somya",name3= "Shruti";
    int id1= 234,id2= 343,id3= 564;
    String contact1= "8988675634",contact2= "8988343433",contact3= "8348348634";
    String programme;
    File f = new File("faculty.txt");
    String filename= "faculty.txt";
    
    public void BCA_FACULTY()
    {
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        programme =  "BCA";
         try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(programme+" "+name1+" "+id1+" "+contact1+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }

    public void BSC_FACULTY()
    {
        programme =  "BSC";
 
        try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(programme+" "+name2+" "+id2+" "+contact2+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Name    : "+name);
        // System.out.println("id      : "+id);
        // System.out.println("Contact : "+contact);
    }

    public void MCA_FACULTY()
    {
        programme =  "MCA";
        try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(programme+" "+name3+" "+id3+" "+contact3+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Name    : "+name);
        // System.out.println("id      : "+id);
        // System.out.println("Contact : "+contact);
    }


    public void getFaculty()
    {
        System.out.println("\n\n ===================== Bca Faculty ======================\n");
        System.out.println("\t\tName : "+name1+"\tId : "+id1+"\tContact : "+contact1);
         System.out.println("\n\n ===================== Bsc Faculty ======================\n ");
        System.out.println("\t\tName : "+name2+"\tId : "+id2+"\tContact : "+contact2);
         System.out.println("\n\n ===================== Mca Faculty ======================\n ");
        System.out.println("\t\tName : "+name3+"\tId : "+id3+"\tContact : "+contact3);
    }
    public static void main(String[] args) {
       
        faculty f = new faculty();
        f.BSC_FACULTY();
        f.BCA_FACULTY();
        f.MCA_FACULTY();
        
        
    }
}
