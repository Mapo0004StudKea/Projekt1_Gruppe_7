import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private static List<Customer> customers;
    private static List<Product> products;

    Scanner scanner = new Scanner(System.in);
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;

    }

    @Override
    public String toString() {
        return name + " " + price;
    }

    public static void main(String[] args) {
        customers = new ArrayList<>();
        Customer newCustomer = new Customer("Viktor", "52222222");
        Customer newCustomer2 = new Customer("Sebastian", "20503010");
        Customer newCustomer3 = new Customer("Tunahan", "30604020");
        Customer newCustomer4 = new Customer("Laurits", " 40705030");
        Customer newCustomer5 = new Customer("Martin", "50806040");
        customers.add(newCustomer);customers.add(newCustomer2);
        customers.add(newCustomer3);customers.add(newCustomer4);
        customers.add(newCustomer5);
        Scanner scanner = new Scanner(System.in);
        makeProduct(scanner);
        register(customers);
        selectProduct(scanner);



    }

    public static void makeProduct(Scanner scanner) {
        products = new ArrayList<Product>();
        System.out.println("Skriv produktets navn: ");
        String name = scanner.nextLine();
        System.out.println("Indtast hvad produktet koster");
        double cost = scanner.nextDouble();
        Product newProduct = new Product(name, cost);
        products.add(newProduct);
        //Product cut = new Product("cut", 400);
        //products.add(cut);

        System.out.println("Dine produkter:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + " " + products.get(i).getPrice());
        }
    }
    public static int selectProduct(Scanner scanner) {
        System.out.println("Select a prodcuct:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }
        int ProductName = scanner.nextInt();
        scanner.nextLine();
        return (ProductName < 1 || ProductName > products.size()) ? -1 : ProductName - 1;
    }

    public static void register(List<Customer> customers) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("vælg et product");
        if (products == null) {
            makeProduct(scanner);
        }
        System.out.println("Select a customer:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Enter the customer number: ");
        int customerNumber = scanner.nextInt();
        scanner.nextLine();

        Customer.customerNeedToPay(products.get(selectProduct(scanner)).getPrice());

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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}