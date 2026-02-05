import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        System.out.println("Welcome to your Library Management System!!");
        System.out.println("Please choose one:");
        System.out.println("1. Add patron");
        System.out.println("2. Remove patron");
        System.out.println("3. Edit patron");
        System.out.println("4. Show all patrons");
        System.out.println("5. Load patron from file");

        Scanner scnr = new Scanner(System.in);
        int choice = scnr.nextInt();


    }
}