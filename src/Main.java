import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Library lib = new Library();
        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to your Library Management System!!");
            System.out.println("Please choose one:");
            System.out.println("1. Add patron");
            System.out.println("2. Remove patron");
            System.out.println("3. Edit patron");
            System.out.println("4. Show all patrons");
            System.out.println("5. Load patron from file");
            System.out.println("6. Exit");


            int choice = scnr.nextInt();


            if (choice == 1) {
                lib.addPatron();
            } else if (choice == 2) {
                lib.removePatron();
            } else if (choice == 3) {
                lib.editPatron();
            } else if (choice == 4) {
                lib.showAllPatrons();
            } else if (choice == 5) {
                lib.loadFromFile();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid entry.");
            }
        }
    }
}



