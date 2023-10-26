import java.util.List;
import java.util.Scanner;

public class HarrysSalonMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSalon Calendar Menu:");
            System.out.println("1. Create Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. Add Customer");
            System.out.println("5. View Customers");
            System.out.println("6. View Economy");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println(Appointment.listCustomer);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
            }
        }
    }
}