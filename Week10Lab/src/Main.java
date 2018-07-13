import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Actor actor = new Actor();
        try {

            while (true) {
                int option = 1;
                System.out.println("Actor Table : ");
                System.out.println("1- Display all Rows | 2- Get a row | 3- Add a new row | 4- Update an existing row "
                        + "| 5- Delete a row | 6-Exit the application");
                System.out.println("Select an option : ");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        ActorMgr.getAllRecords();
                        break;
                    case 2: {
                        System.out.println("Enter the actor id : ");
                        actor = ActorMgr.getRecord(input.nextInt());
                        if (actor != null) {
                            System.out.println("Id : " + actor.getActor_id() + "\nFirstName : " + actor.getFirst_name()
                                    + "\nLastName : " + actor.getLast_name() + "\nLast update : " + actor.getLast_update());
                        } else {
                            System.out.println("No such actor found");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the details of actor in the order of firstname, lastname : ");
                        actor.setFirst_name(input.next());
                        actor.setLast_name(input.next());
                        if (ActorMgr.insertRecord(actor))
                            System.out.println("Row inserted successfully");
                        else
                            System.out.println("Row insertion failed");
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the actor id you want to update : ");
                        actor.setActor_id(input.nextInt());
                        System.out.println("Enter the details of actor in the order of firstname, lastname : ");
                        actor.setFirst_name(input.next());
                        actor.setLast_name(input.next());
                        if (ActorMgr.updateRecord(actor))
                            System.out.println("Row updated successfully");
                        else
                            System.out.println("Row updation failed");
                        break;
                    }
                    case 5: {
                        System.out.println("Enter the actor id you want to delete : ");
                        if (ActorMgr.deleteRecord(input.nextInt()))
                            System.out.println("Row deleted successfully");
                        else
                            System.out.println("Row deletion failed");
                        break;
                    }
                    case 6:
                        System.exit(0);

                    default: {
                        System.out.println("Invalid option");
                        break;
                    }
                }


            }
        } catch (NumberFormatException ex) {
            System.out.println("Enter an integer as option value");
        }
    }

}
