import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        //create library and scanner
        Library lib = new Library();
        Scanner scnr = new Scanner(System.in);
//menu loops with while loop
        while (true) {
            System.out.println("Welcome to your Library Management System!!");
            System.out.println("Please choose one:");
            System.out.println("1. Add patron");
            System.out.println("2. Remove patron");
            System.out.println("3. Edit patron");
            System.out.println("4. Show all patrons");
            System.out.println("5. Load patron from file");
            System.out.println("6. Exit");

//get user choice
            int choice = scnr.nextInt();

//if else for each number choice
            if (choice == 1) {
                lib.addPatron();
                lib.showAllPatrons();
            } else if (choice == 2) {
                lib.removePatron();
                lib.showAllPatrons();
                //we want updated patron list after add and remove so we add those methods here
            } else if (choice == 3) {
                lib.editPatron();
            } else if (choice == 4) {
                lib.showAllPatrons();
            } else if (choice == 5) {
                lib.loadFromFile();
                lib.showAllPatrons();
            } else if (choice == 6) {
                break;
                //break stops the loop and exits menu
            } else {
                System.out.println("Invalid entry.");
                //if there is a different entry throw invalid entry
            }
        }
    }
}



