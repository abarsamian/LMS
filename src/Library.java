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
        int id = scnr.nextInt();
        scnr.nextLine();
        System.out.println("Patron Name:");
        String name = scnr.nextLine();
        System.out.println("Patron Address:");
        String address = scnr.nextLine();
        System.out.println("Patron fee:");
        double fee = scnr.nextDouble();

        Patron p = new Patron(id, name, address, fee);
        // this adds to patron array list
        patrons.add(p);

    }
    //removes patron using id number
    public void removePatron(){
        Scanner scnr = new Scanner(System.in);
        //added scanner and then prompts user to enter id to remove
        System.out.println("Enter patron id you wish to remove:");
        int idEntry = scnr.nextInt();
        //we needed a variable for whatever id the user entered

        patrons.removeIf(p -> p.id == idEntry);
        //this line removes patron if patron id matched identry from user
    }

    //user enters id they want to edit and then prompts a menu for what they wish to edit
    public void editPatron(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patron id you wish to edit:");
        int idEntry = scnr.nextInt();

        for(Patron p : patrons){
            if (p.id == idEntry){
                System.out.println("1. Edit name");
                System.out.println("2. Edit address");
                System.out.println("3. Edit fee");
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
                    p.fee = scnr.nextDouble();
                }

                break;
            }else{
                System.out.println("ID entry not found");
            }
        }

    }
    //prints updated list of patrons
    public void showAllPatrons(){
        System.out.println("Here are all patrons in LMS:");
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
            }
        }
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



