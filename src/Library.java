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
                if(editEntry == 1){
                    System.out.println("New name:");
                    String newName = scnr.nextLine();
                    p.name = newName;
                }
                else if(editEntry == 2){
                    System.out.println("New address:");
                    String newAddress = scnr.nextLine();
                    p.address = newAddress;
                }
                else if(editEntry == 3){
                    System.out.println("New fee:");
                    double newFee = scnr.nextDouble();
                    p.fee = newFee;
                }
                break;
            }
        }

    }
}
