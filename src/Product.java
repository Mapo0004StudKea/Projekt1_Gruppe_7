import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    Scanner scanner = new Scanner(System.in);
    String name;
    double price;

    public Product( String name, double price){
        this.name = name;
        this.price =price;
    }

    public static void main(String[] args) {
        Product cut = new Product("cut", 400);


        System.out.println(cut);
    }

    public static void makeProduct(Scanner scanner) {
        ArrayList<Product> list = new ArrayList<>();
        System.out.println("Skriv produktet navn: ");
        String name = scanner.nextLine();
        System.out.println("Indtast hvad produktet koster");
        String cost = scanner.nextLine();


    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}