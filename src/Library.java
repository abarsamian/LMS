import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Patron> patrons = new ArrayList<>();

    public void addPatron(){

        Scanner scnr = new Scanner(System.in);
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

        patrons.add(p);


    }

    public void removePatron(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patron id you wish to remove:");
        int idEntry = scnr.nextInt();
        patrons.removeIf(p -> p.id == idEntry);

    }

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
            }
        }

    }
    public void showAllPatrons(){
        System.out.println("Here are all patrons in LMS:");
        if(patrons.isEmpty()){
            System.out.println("No patrons to display");
        }
        else {
            for (Patron p : patrons) {
                System.out.println(p.id);
                System.out.println(p.name);
                System.out.println(p.address);
                System.out.println(p.fee);
            }
        }
    }

    public void loadFromFile(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter file name");
        String filename = scnr.nextLine();

        try{
            Scanner fileScnr = new Scanner(new File(filename));

            while(fileScnr.hasNextLine()){
                String line = fileScnr.nextLine();
                String[] parts = line.split("-");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String address = parts[2];
                double fee = Double.parseDouble(parts[3]);

                patrons.add(new Patron(id, name, address, fee));
                }

            fileScnr.close();
            System.out.println("Loaded patrons from file.");

            } catch (Exception e) {
            System.out.println("Error reading file.");
        }

    }

}



