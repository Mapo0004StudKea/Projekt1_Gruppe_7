import java.util.Scanner;
/**
 * @author Viktor Rasmussen, Vira0004@stud.kea.dk
 * Info: Class to keep track of password.
 */
public class Password {
    static String passwords;
    static String a;


    public static boolean password() {

        Scanner scanner = new Scanner(System.in);

        passwords = "hairyharry";
        a = "";

        System.out.println("Enter password");
        System.out.println("Enter b to end");

        while (!a.equals(passwords)) {
            a = scanner.nextLine();
            if (a.equals("hairyharry")) {
                System.out.println("Welcome in");
                return true;

            } else if (a.equals("b")) {
                System.out.println("Bye");
                return false;

            } else {
                System.out.println("Wrong password");

            }

        }
        return false;
    }
}