import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 *
 * Info: main menu class.
 */
public class HarrysSalonMenu {
    private static List<Customer> customers;
    //Customer cus = new Customer("sebastian", "22263888");

    public static void main(String[] args) {
        SalonCalendar salonCalendar = new SalonCalendar();
        customers = new ArrayList<>();
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
                case 6:
                    Accounting(scanner);
                    break;
                case 7:
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
        System.out.println("6. regnskab");
        System.out.println("7. Exit");
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
    public static void Accounting(Scanner scanner){
        boolean shutUp = false;
        double totalPaid = 0;
        while (!shutUp) {
            System.out.println("1. Enter an amount the customer owes.");
            System.out.println("2: Enter an amount the customer has paid.");
            System.out.println("3. Check the customers balance.");
            System.out.println("4. View total balance");
            System.out.println("5. Exit to main menu");
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("choose a customer");
                    int customerNumber1 = Customer.selectCustomer(scanner, customers);
                    System.out.println("How much does the customer need to pay: ");
                    double maengde = scanner.nextDouble();

                    customers.get(customerNumber1).NeedToPay(maengde);
                    System.out.println("The new balance is: ");
                    customers.get(customerNumber1);
                    customers.get(customerNumber1).printTransektions();
                    System.out.println();

                    break;
                case 2:
                    /*
                    // Scanner scanner = new Scanner(System.in);
                    System.out.println("choose a customer: ");
                    int customerNumber = Customer.selectCustomer(scanner, customers);
                    System.out.println("how much did the customer pay");
                    double paying = scanner.nextDouble();

                    customers.get(customerNumber).HasPaid(paying);
                    System.out.println("The new balance is: ");
                    customers.get(customerNumber);
                    customers.get(customerNumber).printTransektions();
                    System.out.println();

                     */
                    System.out.println("Choose a customer: ");
                    int customerNumber = Customer.selectCustomer(scanner, customers);
                    System.out.println("How much did the customer pay: ");
                    double paying = scanner.nextDouble();
                    customers.get(customerNumber).HasPaid(paying);
                    totalPaid += paying; // Update the total paid
                    System.out.println("The new total amount paid is: " + totalPaid);
                    System.out.println();
                    break;
                case 3:
                    //henter balancen for kunden
                    //double hej = 0;
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println("The customers balance is: ");
                        System.out.println(customers.get(i).getBalance());
                    }
                    break;
                case 4:
                    //View total balance
                    System.out.println("Total amount paid by all customers: " + totalPaid);

                    break;
                case 5:
                    System.out.println("Exiting to main menu");
                    shutUp = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}