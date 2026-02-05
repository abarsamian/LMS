import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Patron> patrons = new ArrayList<>();

    public void addPatron(){

        Scanner scnr = new Scanner(System.in);
        System.out.println("Patron id:");
        int id = scnr.nextInt();
        System.out.println("Patron Name:");
        String name = scnr.nextLine();
        System.out.println("Patron Address:");
        String address = scnr.nextLine();
        System.out.println("Patron fee:");
        double fee = scnr.nextDouble();



    }
}
