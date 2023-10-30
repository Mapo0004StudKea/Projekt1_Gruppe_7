import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 *
 * Info: main menu class.
 */
public class HarrysSalonMenu {
    Customer cus = new Customer("sebastian", "22263888");

    public static void main(String[] args) {
        SalonCalendar salonCalendar = new SalonCalendar();
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Appointment.createAppointment(salonCalendar, customers, scanner);
                    break;
                case 2:
                    Appointment.cancelAppointment(scanner);
                    break;

                case 3:
                    Appointment.viewAppointments();
                    break;

                case 4:
                    Customer.addCustomer(customers, scanner);
                    break;

                case 5:
                    Customer.viewCustomers(customers);
                    break;
                case 7:


                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("\nSalon Calendar Menu:");
        System.out.println("1. Create Appointment");
        System.out.println("2. Cancel Appointment");
        System.out.println("3. View Appointments");
        System.out.println("4. Add Customer");
        System.out.println("5. View Customers");
        System.out.println("6. Exit");
        System.out.print("Please enter your choice: ");
    }

    public static String selectTimeSlot(Scanner scanner) {
        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thursday");
        System.out.println("5. Friday");
        System.out.print("Enter the day (1-5): ");
        int dayChoice = scanner.nextInt();
        scanner.nextLine();

        if (dayChoice < 1 || dayChoice > 5) {
            return null;
        }

        System.out.println("Select a time slot:");
        System.out.println("1. 10:00 AM - 11:00 AM");
        System.out.println("2. 11:00 AM - 12:00 PM");
        System.out.println("3. 12:00 PM - 1:00 PM");
        System.out.println("4. 1:00 PM - 2:00 PM");
        System.out.println("5. 2:00 PM - 3:00 PM");
        System.out.println("6. 3:00 PM - 4:00 PM");
        System.out.println("7. 4:00 PM - 5:00 PM");
        System.out.println("8. 5:00 PM - 6:00 PM");
        System.out.print("Enter the time slot (1-8): ");
        int timeSlotChoice = scanner.nextInt();
        scanner.nextLine();

        if (timeSlotChoice < 1 || timeSlotChoice > 8) {
            return null;
        }

        String day = switch (dayChoice) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "";
        };

        String[] timeSlots = {
                "10:00 AM - 11:00 AM",
                "11:00 AM - 12:00 PM",
                "12:00 PM - 1:00 PM",
                "1:00 PM - 2:00 PM",
                "2:00 PM - 3:00 PM",
                "3:00 PM - 4:00 PM",
                "4:00 PM - 5:00 PM",
                "5:00 PM - 6:00 PM"
        };

        return day + " " + timeSlots[timeSlotChoice - 1];
    }



}