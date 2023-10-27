import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static boolean createCustomerOption(Scanner scanner) {
        System.out.println("No customers available. Do you want to create a new customer?");
        System.out.print("Enter 'Y' for yes or any other key for no: ");
        String createCustomerChoice = scanner.nextLine();
        return createCustomerChoice.equalsIgnoreCase("Y");
    }

    public static int selectCustomer(Scanner scanner, List<Customer> customers) {
        System.out.println("Select a customer:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Enter the customer number: ");
        int customerNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        return (customerNumber < 1 || customerNumber > customers.size()) ? -1 : customerNumber - 1;
    }

    public static void addCustomer(List<Customer> customers, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();
        Customer customer = new Customer(customerName, phoneNumber);
        customers.add(customer);
    }

    public static void viewCustomers(List<Customer> customers) {
        System.out.println("Customers:");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println((i + 1) + ". Name: " + customer.getName() + ", Phone: " + customer.getPhoneNumber());
        }
    }
}