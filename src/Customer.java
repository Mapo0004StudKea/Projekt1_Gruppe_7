import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 * @author Sebastian Holger Drumm, sedr0001@stud.kea.dk
 * @author Viktor Rasmussen, Vira0004@stud.kea.dk
 * Info: Customer class to select, add and create customer.
 */

public class Customer {
    private final String name;
    private final String phoneNumber;
    private double balance;
    protected static ArrayList<Transaction> transactions = new ArrayList<>();
    static ArrayList <Product> products  = new ArrayList<Product>();


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
        Customer c2 = new Customer("tino", "2015315");
        customers.add(c2);
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

    public void customerNeedToPay(double amount) {
        transactions.add(new Transaction("owes", amount, balance));
        balance = balance + amount;
    }

    public void customerHasPaid(double amount) {
        transactions.add(new Transaction("paid", amount, balance));
        balance = balance - amount;
        ArrayList<Double> list = new ArrayList<>();
        //lav en ekstra array list som gemmer amount, som man så kan regne samme senere.
        double amountPaid=0;
        System.out.println(amountPaid);
        list.add(amountPaid);
    }

    public void printCustomerTransactions(){
        System.out.println(this);
        System.out.println("text"+"\t"+"dato"+"\t"+"owes");
        for ( Transaction t : transactions){
            System.out.println(t);
        }
        System.out.println();
    }

    public static void register(List<Customer> customers, String name, double price) {
        Product getProduct = new Product(name, price);

        Scanner scanner = new Scanner(System.in);
        getProduct.makeProduct(scanner);

        System.out.println("vælg et product");
        if (products == null) {
            getProduct.selectProduct( scanner);
        }
        System.out.println("Select a customer:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Enter the customer number: ");
        int customerNumber = scanner.nextInt();
        scanner.nextLine();

        customerNeedToPay(products.get(getProduct.selectProduct(scanner)).getPrice());

        HarrysSalonMenu.Accounting(scanner);

        /*
        for (int i = 1; i < products.size(); i++) {
            System.out.println(products.get(i).name);

            System.out.println("vælg kunde, som skal havde product");
            for (int e = 1; e < customers.size(); e++) {
                System.out.println(customers.get(e - 1));
            }

            int væglNummerIArrylist = scanner.nextInt();
            customers.get(væglNummerIArrylist);

            int customerNumber = Customer.selectCustomer(scanner, customers);
            Customer.customerNeedToPay(products.get(væglNummerIArrylist).getPrice() + customers.get(customerNumber).getBalance());
          }
         */
    }
}