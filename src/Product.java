
public class Product {

    private int cut = 300;
    private double shampoo = 100;
    private double scissor = 50;
    private double hairwax = 59.99;

    public Product (double cut, double shampoo, double scissor, double hairwax) {
        this.cut = cut;
        this.shampoo = shampoo;
        this.scissor = scissor;
        this.hairwax = hairwax;
    }

    public int getCut() {
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
    public static void diaplayCutValue() {
        System.out.println("Hair cut Price"+getCut);
    }
    public static void main(String[] args) {
        Product p = new Product();
        System.out.println(p.shampooAndCut());
        System.out.println(p.scissorAndCut());
        System.out.println(p.hairwaxAndCut());
        System.out.println(p.getCut());

    }
}





