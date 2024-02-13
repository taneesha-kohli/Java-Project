import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class student{
    
    String name;
    String id;
    String enrollment;
    String course; 
    Scanner sc = new Scanner(System.in);

    public void add_details()
    {
         String line;
         int foundId=0,foundroll=0;
         String filename = "student.txt";
        File file = new File(filename);

        System.out.println("\n\n\t\t==================== WELCOME ON REGISTRATION PAGE =====================\n\n");

        System.out.println("Enter your name :");
        name = sc.next();
        System.out.println("Enter your id :");
        id = sc.next();
        System.out.println("Enter your enrollment number :");
        enrollment=sc.next();
        System.out.println("Enter your course :");
        course = sc.next();
         /*checking if id is already exists by reading a file */
         
        try {
            if(file.exists())
            {
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            try {
                while ((line=reader.readLine())!=null) {
                    String words[] = line.split(" ");
                    for(int i=0;i<words.length;i++)
                    {
                    if(words[i].equals(id))
                    {
                        foundId++;
                        // System.out.println("found id value :"+foundId);
                    }
                    if(words[i].equals(enrollment))
                    {
                    
                        foundroll++;
                        // System.out.println("found roll value :"+foundroll);
                    }
                  
                }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

      
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    
        

          /* doing file write operation */
        try {
            
            if(file.exists())
            {    
                // System.out.println("File already exists");
                 if (foundId!=0&&foundroll!=0)
                {
                    System.out.println("\n student is already enrolled with same id and enrollment !!!!!!!!!!!!!!!!!!\n");
                }
                else if (foundId!=0) {
                 System.out.println("\nstudent is already enrolled with this id  !!!!!!!!!!!!!!!!!\n");
                }
                 else if (foundroll!=0) {
                 System.out.println("\nstudent is already enrolled with this enrollment !!!!!!!!!!!!!!!!!\n");
                }
           
                else
                {
                    FileWriter write = new FileWriter(file,true);
                    write.append(id +" "+name+" "+enrollment+" "+course+"\n");
                    write.close();
                    System.out.println("\nRegistered successfully --------------------\n");
                }
                
            }
            else 
            {
                File newfile = new File(filename);
                 newfile.createNewFile();
                 FileWriter write = new FileWriter(file,true);
                 write.append(id +" "+name+" "+enrollment+" "+course+"\n");
                 write.close();
                 System.out.println("\nRegistered successfully --------------------\n");
        
            }
        
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /*getting details of student */
    public void get_details()
    {
        int found =0;
        String Course =" ";

        System.out.println("\n\n\t\t==================== WELCOME ON RECORD PAGE =====================\n\n");

        System.out.println("\nEnter your Id to fetch your details ");
        String unique = sc.next();
        String word;
        try {
           BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            String line;
           

            try {
                while((line=reader.readLine()) !=null)
                {
                    // System.out.println(line);
                    String words[] = line.split(" ");
                    word = words[0];
                    // System.out.println(word);
                    // System.out.println(data);

                    // getting student detail
                    if(word.equals(unique))
                    {
                        System.out.println("\n\t\t\t========================= STUDENT DATA =========================\n\n");
                        System.out.println("\t\t\t\t\tNAME       : "+ words[1].toUpperCase());
                        System.out.println("\t\t\t\t\tID         : "+ words[0].toUpperCase());
                        System.out.println("\t\t\t\t\tENROLLMENT : "+ words[2].toUpperCase());
                        System.out.println("\t\t\t\t\tCOURSE     : "+ words[3].toUpperCase());
                        System.out.println(("\n\t\t\t=================================================================\n\n"));
                        found++;
                    }
    

                    // for getting the course
                    if(word.equals(unique))
                    {
                        for(int i=0;i<words.length;i++)
                        {
                          if(words[i].equalsIgnoreCase("bca"))
                          {
                            Course = "bca";
                          }
                          if(words[i].equalsIgnoreCase("bsc"))
                          {
                            Course = "bsc";
                          }
                          if(words[i].equalsIgnoreCase("mca"))
                          {
                            Course = "mca";
                          }
                          
                        }
                    }
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      
        if(found==0)
        {
            System.out.println("\nNo data found with this id !!!!!!!!!!\n");
            return;
        }

        // Fetching faculty details;
         String string;
         
         try {
           BufferedReader reader = new BufferedReader(new FileReader("faculty.txt"));
           try {
            while((string=reader.readLine())!=null)
               {
                String words[]=string.split(" ");
                if(words[0].equalsIgnoreCase(Course))
                {
                    System.out.println("\n\t\t\t========================= FACULTY DATA ===========================\n\n");
                    System.out.println("\t\t\t\t\t NAME       : "+words[1].toUpperCase());
                    System.out.println("\t\t\t\t\t ID         : "+words[2].toUpperCase());
                    System.out.println("\t\t\t\t\t CONTACT    : "+words[3].toUpperCase());
                    System.out.println(("\n\t\t\t==================================================================\n\n"));
                }
               }
        } catch (IOException e) {
            e.printStackTrace();
        }
         try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      
    //  Fetching university details

      String string2;
      try {
        BufferedReader reader2 = new BufferedReader(new FileReader("university.txt"));
        try {
            while((string2=reader2.readLine())!=null)
            {
                String words2[] = string2.split(" ");
                if(words2[0].equalsIgnoreCase(Course))
                {
                    System.out.println("\n\t\t\t========================= UNIVERSITY DATA =========================\n\n");
                    System.out.println("\t\t\t\t\t NAME       : "+words2[1].replace("_", " ").toUpperCase());
                    System.out.println("\t\t\t\t\t ADDRESS    : "+words2[2].replace("_", " ").toUpperCase());
                    System.out.println(("\n\t\t\t===================================================================\n\n"));
                    System.out.println("\n\n");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
     
        
    }
 
    /*updating the existing data */
    public void update_data()
    {
        String line,line1,newName;
        int update;
        String newId;
        String newRoll;
        String newCourse;
        int foundId =0,foundroll=0,foundId2=0;
       
        System.out.println("\n\n\t\t==================== WELCOME ON UPDATE PAGE =====================\n\n");

        System.out.println("\nEnter your Id to update your data ");
        String unique = sc.next();
      

        try {
            BufferedReader checkid = new BufferedReader(new FileReader("student.txt"));
            try {
                while ((line1=checkid.readLine())!=null) {
                    String word[]=line1.split(" ");
                    

                    if (word[0].equals(unique)) {
                       
                        foundId++;
                        System.out.println("id found");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                checkid.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if(foundId==0)
        {
            System.out.println("\nNo data found with id !!!!!!!!!!!!!!!!!!!\n");
        }
        else
        {
            System.out.println("\nWhat do you want to update ? \n\n 1 - Name \n 2 - id \n 3 - enrollment \n 4 - course \n 5 - All record");
            System.out.println("Enter your choice : ");
            update = sc.nextInt();

            File original = new File("student.txt");
            File temp = new File("temp.txt");
            try {
             temp.createNewFile();
         } catch (IOException e) {
             e.printStackTrace();
         }

        try {
            BufferedReader read = new BufferedReader(new FileReader("student.txt"));
           
            try {
                BufferedWriter write = new BufferedWriter(new FileWriter("temp.txt",true));

                while ((line=read.readLine())!=null) {
                    String words[]=line.split(" ");
                    // System.out.println("string length :"+words.length);
                    // System.out.println("value of words [0]"+words[0]);
                    // System.out.println("value of unique"+unique);
                    if (words[0].equals(unique)) {
                       
                      switch (update) {
                        case 1:
                        {
                        
                           System.out.println("Enter new name to update");
                           newName = sc.next();

                           write.append(words[0] +" "+newName+" "+words[2]+" "+words[3]+"\n");
                        //    System.out.println("\nName is updated successfully---------------------\n");
                       
                        System.out.println("\nYour data has been updated successfully ----------------------\n");

                        } 
                        break;
                        case 2:
                        {
                            System.out.println("Enter new id to update");
                            newId = sc.next();
                            
                            try {
                                BufferedReader checkid = new BufferedReader(new FileReader("student.txt"));

                                try {
                                    while ((line1=checkid.readLine())!=null) {
                                        String word[]=line1.split(" ");
                                        
                    
                                        if (word[0].equals(newId)) {
                                           
                                            foundId2++;
                                          
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    checkid.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                           if(foundId2!=0)
                           {
                            System.out.println("\nstudent found with same id , please enter valid id ---------------\n");
                            write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");

                            foundId2=0;
                           }
                           else 
                           {
                            write.append(newId +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                            // System.out.println("\nId is updated successfully---------------------\n");
                            // System.out.println("string length :"+words.length);
                            System.out.println("\nYour data has been updated successfully ----------------------\n");
                           }
                           
                        } 
                        break;
                        case 3:
                        {
                            System.out.println("Enter new enrollment to update");
                            newRoll = sc.next();
                            try {
                                BufferedReader checkid = new BufferedReader(new FileReader("student.txt"));
                                try {
                                    while ((line1=checkid.readLine())!=null) {
                                        String word[]=line1.split(" ");
                                        
                    
                                        if (word[2].equals(newRoll)) {
                                           
                                            foundroll++;
                                          
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    checkid.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            if(foundroll!=0)
                            {
                                System.out.println("\nstudent found with same enrollment , please enter valid enrollment ---------------\n");
                                write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                               
                                foundroll=0;
                            }
                            else 
                            {
                            
                            write.append(words[0] +" "+words[1]+" "+newRoll+" "+words[3]+"\n");
                            // System.out.println("\nEnrollment number is updated successfully---------------------\n");
                          
                            System.out.println("\nYour data has been updated successfully ----------------------\n");
                            }
                            
                        } 
                        break;
                        case 4:
                        {
                            System.out.println("Enter new course to update");
                            newCourse = sc.next();
                            
                            write.append(words[0] +" "+words[1]+" "+words[2]+" "+newCourse+"\n");
                            // System.out.println("\nCourse is updated successfully---------------------\n");
                            System.out.println("\nYour data has been updated successfully ----------------------\n");
                        } 
                        break;
                        case 5:
                        {
                            System.out.println("Enter new name to update");
                            newName = sc.next();

                            System.out.println("\nEnter new id to update");
                            newId = sc.next();
                            
                            System.out.println("\nEnter new enrollment to update");
                            newRoll = sc.next();

                            System.out.println("\nEnter new course to update");
                            newCourse = sc.next();
                            
                            try {
                               
                                BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
                                try {
                                    while ((line=reader.readLine())!=null) {
                                        String word[] = line.split(" ");
                                        for(int i=0;i<word.length;i++)
                                        {
                                        if(word[i].equals(newId))
                                        {
                                            foundId2++;
                                           
                                        }
                                        if(word[i].equals(newRoll))
                                        {
                                        
                                            foundroll++;
                                            System.out.println("found roll value :"+foundroll);
                                        }
                                    }
                    
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    reader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            if (foundId2!=0&&foundroll!=0)
                            {
                                System.out.println("\n student is already enrolled with same id and enrollment !!!!!!!!!!!!!!!!!!\n");
                                write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                                foundId2=0;
                               foundroll=0;
                            }
                            else if (foundId2!=0) {
                             System.out.println("\nstudent is already enrolled with this id  !!!!!!!!!!!!!!!!!\n");
                             write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                             foundId2=0;
                            }
                             else if (foundroll!=0) {
                             System.out.println("\nstudent is already enrolled with this enrollment !!!!!!!!!!!!!!!!!\n");
                             write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                             foundroll=0;
                            }
                            else
                            {

                            write.append(newId +" "+newName+" "+newRoll+" "+newCourse+"\n");
                            // System.out.println("\nAll record is updated successfully---------------------\n");
                           

                            System.out.println("\nYour data has been updated successfully ----------------------\n");
                            }
                            
                        }
                        break; 
                      }  
                    }
                    else
                    {
                        write.append(words[0] +" "+words[1]+" "+words[2]+" "+words[3]+"\n");
                       
                    }
                }
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
          
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         
      original.delete();
      temp.renameTo(original);
    }
        
       
       
    } 

    /*deleting to a particular record*/
    public void delete_data()
    {
        String record;
        int foundId=0;
        String line;

        System.out.println("\n\n\t\t==================== WELCOME ON DELETE PAGE =====================\n\n");

        System.out.println("\nEnter your Id to delete your data ");
        String unique = sc.next();


        try {
            BufferedReader checkid = new BufferedReader(new FileReader("student.txt"));
            try {
                while ((line=checkid.readLine())!=null) {
                    String words[]=line.split(" ");
                    

                    if (words[0].equals(unique)) {
                       
                        foundId++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                checkid.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if(foundId==0)
        {
            System.out.println("\nNo data found with id !!!!!!!!!!!!!!!!!!!\n");
        }

        else
        {

        File temp = new File("temp.txt");
        File original = new File("student.txt");

        Path tempfile = Paths.get("temp.txt");
        Path originalfile = Paths.get("student.txt");

        try {
            temp.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

   
        try {
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            
            try {
                while ((record=reader.readLine())!=null) {
                    String words[]=record.split(" ");
                    if(words[0].equals(unique))
                    {

                    }
                    else 
                    {
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt",true));
                            writer.append(record+"\n");
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        System.out.println("\nYour record has been deleted successfully ----------------\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        original.delete();
        
        try {
            Files.move(tempfile, originalfile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  }

}
