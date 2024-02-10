import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class course {
    
    public void addCourse()
    {
       String courses[]= {"BCA","MCA","BSC"};

       File file = new File("course.txt");
       try {
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter("course.txt",true));

        for (String course : courses) {
            writer.append(course+"\n");
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
       
    }


    public void getcourse()
    {
       System.out.println("\nWe offers courses ---------------- \n");
       System.out.println("BCA");
       System.out.println("MCA");
       System.out.println("BSC");
    }

    public static void main(String[] args) {
        course add = new course();
        add.addCourse();
    }
}
