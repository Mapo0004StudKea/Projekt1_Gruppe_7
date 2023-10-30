
public class Product {

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



}





