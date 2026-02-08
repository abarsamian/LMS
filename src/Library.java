import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    //we make an array list called patrons so we can load data into it
    ArrayList<Patron> patrons = new ArrayList<>();


    //this adds a new patron with respective data
    public void addPatron(){
        Scanner scnr = new Scanner(System.in);
        //added scanner and now scan all data in for patron


        System.out.println("Patron id:");
        //need validation checks that the id number is 7 digits and an integer
        while (!scnr.hasNextInt()) {
            System.out.println("Invalid entry- 7 digit number please.");
            scnr.next();
        }
        int id = scnr.nextInt();
        while (id < 1000000 || id > 9999999) {
            System.out.println("ID must be 7 digits:");
            id = scnr.nextInt();
        }
        scnr.nextLine();

        System.out.println("Patron Name:");
        String name = scnr.nextLine();

        System.out.println("Patron Address:");
        String address = scnr.nextLine();

        System.out.println("Patron fee:");
        while (!scnr.hasNextDouble()) {
            System.out.println("Invalid fee:");
            scnr.next();
        }
        double fee = scnr.nextDouble();


        Patron p = new Patron(id, name, address, fee);
        // this adds to patron array list
        patrons.add(p);


    }
    //removes patron using id number
    public void removePatron(){
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter patron id you wish to remove:");

        //validation for id data
        while (!scnr.hasNextInt()) {
            System.out.println("Invalid entry- 7 digit number please.");
            scnr.next();
        }

        int idEntry = scnr.nextInt();

        while (idEntry < 1000000 || idEntry > 9999999) {
            System.out.println("ID must be 7 digits:");
            idEntry = scnr.nextInt();
        }

        //we needed a variable for whatever id the user entered
        int finalIdEntry = idEntry;
        patrons.removeIf(p -> p.id == finalIdEntry);
        //this line removes patron if patron id matched identry from user
        boolean removed = patrons.removeIf(p -> p.id == finalIdEntry);
        if (!removed) {
            System.out.println("No patron with that ID found.");
        }
        //throw this message if there was no one with id found and nothing was removed.
    }

    //user enters id they want to edit and then prompts a menu for what they wish to edit
    public void editPatron(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patron id you wish to edit:");
        //id validation check
        while (!scnr.hasNextInt()) {
            System.out.println("Invalid entry- 7 digit number please.");
            scnr.next();
        }
        int idEntry = scnr.nextInt();

        boolean found = false;

        for(Patron p : patrons){
            if (p.id == idEntry){

                found = true;

                System.out.println("1. Edit name");
                System.out.println("2. Edit address");
                System.out.println("3. Edit fee");
                //menu selection validation

                while (!scnr.hasNextInt()) {
                    System.out.println("Enter 1–3:");
                    scnr.next();
                }
                int editEntry = scnr.nextInt();

                scnr.nextLine();
                if(editEntry == 1){
                    System.out.println("New name:");
                    p.name = scnr.nextLine();
                }
                else if(editEntry == 2){
                    System.out.println("New address:");
                    p.address = scnr.nextLine();
                }
                else if(editEntry == 3){
                    System.out.println("New fee:");
                    //validation for fee entry
                    while (!scnr.hasNextDouble()) {
                        System.out.println("Invalid fee:");
                        scnr.next();
                    }
                    p.fee = scnr.nextDouble();

                }

                break;
            }
        }
        if(! found){
            System.out.println("ID entry not found");
        }
    }
    //prints updated list of patrons
    public void showAllPatrons(){

        System.out.println("*---Here are all patrons in LMS:---*");
        System.out.println();
        //need to be able to display if there are no patrons

        if(patrons.isEmpty()){
            System.out.println("No patrons to display");
        }
        //else: print all patrons
        else {
            for (Patron p : patrons) {
                System.out.println(p.id);
                System.out.println(p.name);
                System.out.println(p.address);
                System.out.println(p.fee);
                System.out.println("-------------------------");
                System.out.println();
            }
        }
        System.out.println();

    }

    //loads patron data from file
    public void loadFromFile(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter file name");
        String filename = scnr.nextLine();
    //need a try catch for the file scanner
        try{
            Scanner fileScnr = new Scanner(new File(filename));

            while(fileScnr.hasNextLine()){
                String line = fileScnr.nextLine();
                //reads dash formatting
                String[] parts = line.split("-");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String address = parts[2];
                double fee = Double.parseDouble(parts[3]);
                //then adds a new patron based on what it reads from the file
                patrons.add(new Patron(id, name, address, fee));
                }

            fileScnr.close();
            System.out.println("Loaded patrons from file."); //this tells us it was successful

            } catch (Exception e) {
            System.out.println("Error reading file."); //tells us it was unsuccessful
        }

    }

}



