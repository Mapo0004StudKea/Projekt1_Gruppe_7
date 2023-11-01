import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 * @author Sebastian Holger Drumm, sedr0001@stud.kea.dk
 * @author Viktor Rasmussen, Vira0004@stud.kea.dk
 * Info: main menu class.
 */
public class HarrysSalonMenu {
    private static List<Customer> customers;
    private static List<Product> products;

    public static void main(String[] args) {
        SalonCalendar salonCalendar = new SalonCalendar();
        customers = new ArrayList<>();
        products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //Product cut = new Product("cut", 400);
        Customer newCustomer = new Customer("Viktor", "52222222");
        customers.add(newCustomer);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Customer.addCustomer(customers, scanner);
                    break;
                case 2:
                    Customer.viewCustomers(customers);
                    break;
                case 3:
                    Appointment.createAppointment(salonCalendar, customers, scanner);
                    break;
                case 4:
                    Appointment.viewAppointments();
                    break;
                case 5:
                    Appointment.cancelAppointment(scanner);
                    break;
                case 6:
                    if (Password.password()){

                        Accounting(scanner);
            }
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
        System.out.println("1. Add Customer");
        System.out.println("2. View Customer");
        System.out.println("3. Create Appointment");
        System.out.println("4. View Appointments");
        System.out.println("5. Cancel Appointment");
        System.out.println("6. Accounting");
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

    public static void Accounting(Scanner scanner) {
        boolean shutUp = false;
        double totalPaid = 0;
            //String passwordToEnter = "hairyharry";
            //System.out.println("Enter password: ");
            //String enteredPassword = scanner.nextLine();
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

                        customers.get(customerNumber1).customerNeedToPay(maengde);
                        System.out.println("The new balance is: ");
                        customers.get(customerNumber1);
                        customers.get(customerNumber1).printCustomerTransactions();
                        System.out.println();

                        break;
                    case 2:
                        System.out.println("Choose a customer: ");
                        int customerNumber = Customer.selectCustomer(scanner, customers);
                        System.out.println("How much did the customer pay: ");
                        double paying = scanner.nextDouble();
                        customers.get(customerNumber).customerHasPaid(paying);
                        totalPaid += paying; // Update the total paid
                        System.out.println("The new total amount paid is: " + totalPaid);
                        System.out.println();
                        break;
                    case 3:
                        //henter balancen for kunden
                        for (int i = 0; i < customers.size(); i++) {
                            System.out.println("The customers balance is: ");
                            System.out.println(customers.get(i).getName() + customers.get(i).getBalance());
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

        /*if (passwordToEnter.equals(enteredPassword)) {

        } else {
            System.out.println("Wrong password, Try again!");
        }*/

        }
    }