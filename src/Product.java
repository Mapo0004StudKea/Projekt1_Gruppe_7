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




    }

    public static void makeProduct(Scanner scanner) {
        products = new ArrayList<Product>();
        System.out.println("Skriv produktets navn: ");
        String name = scanner.nextLine();
        System.out.println("Indtast hvad produktet koster");
        double cost = scanner.nextDouble();
        Product newProduct = new Product(name, cost);
        products.add(newProduct);
        Product cut = new Product("cut", 400);
        products.add(cut);

        System.out.println("Dine produkter:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + " " + products.get(i).getPrice());
        }
    }


    public static void register( List<Customer> customers) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("vælg et product");
        if (products == null) {
            makeProduct(scanner);
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).name);

            System.out.println("vælg kunde, som skal havde product");
            for (int e = 0; e < customers.size(); e++) {
                System.out.println(customers.get(e - 1));
            }

            int væglNummerIArrylist = scanner.nextInt();
            products.get(væglNummerIArrylist);

            int customerNumber = Customer.selectCustomer(scanner, customers);
            Customer.customerNeedToPay(products.get(væglNummerIArrylist).getPrice() + customers.get(customerNumber).getBalance());

        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}