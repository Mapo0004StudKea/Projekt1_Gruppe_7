
public class Product {

    double cut = 300;
    int shampoo = 100;
    int scissor = 50;
    double hairwax = 59.99;

    public double getCut() {
        return cut;
    }

    public double shampooAndCut() {
        return shampoo + cut;
    }

    public double scissorAndCut() {
        return scissor + cut;
    }

    public double hairwaxAndCut() {
        return hairwax + cut;
    }

    public static void main(String[] args) {
        Product p = new Product();
        System.out.println(p.shampooAndCut());
        System.out.println(p.scissorAndCut());
        System.out.println(p.hairwaxAndCut());
        System.out.println(p.getCut());

    }
}





