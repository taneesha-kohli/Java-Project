import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

 public class university {
  
    String name1= "1110_UIHMT",name2= "11000_UMT",name3= "10000_UHT";
    String address1= "Mohkhampur_,_102_sector",address2= "Kuanwala_,_1065_sector",address3= "Rispana_,_1037_sector";
    String course1,course2,course3;

    File f = new File("university.txt");
    String filename = "university.txt";
  public void BCA_UNVST()
    {
     
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        course1 = "BCA";
   
        try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(course1+" "+name1+" "+address1+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
    public void BSC_UNVST()
    {
       
        course2 = "BSC";
 
         try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(course2+" "+name2+" "+address2+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  System.out.println("Name     : "+name);
        // System.out.println("Address  : "+address);
    }
    public void MCA_UNVST()
    {
        course3 = "MCA";
    
         try {
            FileWriter writer = new FileWriter(filename,true);
            writer.append(course3+" "+name3+" "+address3+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  System.out.println("Name     : "+name);
        // System.out.println("Address  : "+address);
    }

    public void getuniversity()
    {
          System.out.println("\n\n ===================== Bca University ======================\n");
         System.out.println("\t\tName : "+name1.replace("_", " ")+"\tAddress : "+address1.replace("_", " "));
          System.out.println("\n\n ===================== Bsc University ======================\n ");
         System.out.println("\t\tName : "+name2.replace("_", " ")+"\tAddress : "+address2.replace("_", " "));
          System.out.println("\n\n ===================== Mca University ======================\n ");
         System.out.println("\t\tName : "+name3.replace("_", " ")+"\tAddress : "+address3.replace("_", " "));
    }

    public static void main(String[] args) {
      
        university u = new university();
        u.BCA_UNVST();
        u.BSC_UNVST();
        u.MCA_UNVST();
        
    }
}
