import java.util.Scanner;

public class _1_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        student s = new student();
        faculty f = new faculty();
        university u = new university();
        course c = new course();
        int choice;
        String choice2;
     do 
     {
        System.out.println("\n\n\t\t======================================================================");
        System.out.println("\t\t==================== WELCOME ON STUDENT DATABASE =====================");
        System.out.println("\t\t======================================================================");

        System.out.println("\n\n\t\t\t\t=============== MENU ==============\n\n");

        System.out.println("\t\t\t\t 1 - VIEW COURSES \n");
        System.out.println("\t\t\t\t 2 - VIEW FACULTIES \n");
        System.out.println("\t\t\t\t 3 - VIEW UNIVERSITIES \n");
        System.out.println("\t\t\t\t 4 - REGISTRATION \n");
        System.out.println("\t\t\t\t 5 - GET YOUR RECORD \n");
        System.out.println("\t\t\t\t 6 - UPDATE YOUR RECORD \n");
        System.out.println("\t\t\t\t 7 - DELETE YOUR RECORD \n");
     
        System.out.println("\n\nEnter your choice : ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
            c.getcourse();
            break;
            case 2:
            f.getFaculty();
            break;
            case 3:
            u.getuniversity();
            break;
            case 4:
            s.add_details();
            break;
            case 5:
            s.get_details();
            break;
            case 6:
            s.update_data();
            break;
            case 7:
            s.delete_data();
            break;
            default:
                break;
        }
        System.out.println("\n would you like to continue  ? (exit - no/continue - yes)\n");
        choice2 = sc.next();
        if(choice2.equalsIgnoreCase("yes"))
        {
            continue;
        }
        else
        {
            return;
        }

    }while(true);
    
    }
}

