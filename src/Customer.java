public class  Customer {
    int Phonenumber;
    String navn;
    double PaymentBalance;

    Customer(int Phone, String name, double Balance){
        Phonenumber=Phone;
        navn=name;
        PaymentBalance=Balance;
    }

    void PrintCustom() {
        System.out.println(this);

    }
    @Override
    public String toString() {
        return  "kundens Telefon nr " + Phonenumber + " kundens navn: " + navn + " kundens balacne " + PaymentBalance;
    }

    public int getPhoneNumber() {
        return Phonenumber;
    }

    public String getNavn() {
        return navn;
    }
}
