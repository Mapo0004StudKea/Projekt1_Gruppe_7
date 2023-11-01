import java.time.LocalDate;
/**
 * @author Sebastian Holger Drumm, sedr0001@stud.kea.dk
 * @author Viktor Rasmussen, Vira0004@stud.kea.dk
 * Info: Customer class to select, add and create customer.
 */
public class Transaction {
    String text;
    LocalDate date;
    double amount;
    double newBalance;

    Transaction(String text, double amount, double newBalance) {
        this.text = text;
        this.amount = amount;
        this.newBalance = newBalance;
        date = LocalDate.now();
    }

    @Override
    public String toString() {
        return text + "\t" + date + "\t" + amount + "\t" + newBalance;

    }
}