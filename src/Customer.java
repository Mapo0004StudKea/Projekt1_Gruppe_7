import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 * @author sebastian
 * Info: Customer class to select, add and create customer.
 */

public class Customer {
    private String name;
    private String phoneNumber;
    private double balance;
    protected ArrayList<transektion> transektions = new ArrayList<>();


    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "name " + getName() + " number "+ getPhoneNumber();
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
        scanner.nextLine();

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
            System.out.println((i + 1) + ". Name: " + customer.getName() + ", Phone: " + customer.getPhoneNumber()+" balance " +customer.balance);
        }
    }

    void NeedToPay(double amount) {
        transektions.add(new transektion("owes", amount, balance));
        balance = balance + amount;

    }

    void HasPaid(double amount) {
        transektions.add(new transektion("paid", amount, balance));
        balance = balance - amount;
        ArrayList<Double> list = new ArrayList<>();
        //lav en ekstra arry list som gemmer amount, som man så kan regne samme seneer.
        double amountPaid=0;
        double regnUd = amount + amountPaid;
        System.out.println(amountPaid);
        list.add(amountPaid);
    }
    void printTransektions(){
        System.out.println(this);
        System.out.println("text"+"\t"+"dato"+"\t"+"owes");
        for ( transektion t : transektions){
            System.out.println(t);
        }
        System.out.println();
    }
}

class transektion {
    String text;
    LocalDate date;
    double amount;
    double newBalacen;
    protected ArrayList<transektion> transektions = new ArrayList<>();

    transektion(String text, double amount, double newBalacen) {
        this.text = text;
        this.amount = amount;
        this.newBalacen = newBalacen;
        date = LocalDate.now();
    }

    @Override
    public String toString() {
        return text + "\t" + date + "\t" + amount + "\t" + newBalacen;

    }
}