import java.util.Scanner;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 *
 * The main menu class for the program.
 */

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("*        Welcome to Harrys Booking-System        *");

        while (true) {
            int choice;
            System.out.println("**************************************************");
            System.out.println("*       You have the following options:          *");
            System.out.println("*       Press 1: to create an appointment.       *");
            System.out.println("*       Press 2: to cancel an appointment.       *");
            System.out.println("*       Press 3: to view appointments.           *");
            System.out.println("*       Press 4: to see the economy.             *");
            System.out.println("*       Press 0: to exit the booking system.     *");
            System.out.println("**************************************************");
            System.out.println("\nChoose one: ");
            choice =scanner.nextInt();
            if(choice == 0) break;

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
        System.out.println("Closing the program ...");
        System.out.println("Goodbye");
    }

}