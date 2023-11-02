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

        System.out.println("Indtast password");
        System.out.println("Tast b for at afslutte");

        while (!a.equals(passwords)) {
            a = scanner.nextLine();
            if (a.equals("hairyharry")) {
                System.out.println("Velkommen ind");
                return true;

            } else if (a.equals("b")) {
                System.out.println("Farvel");
                return false;

            } else {
                System.out.println("Forkert password");

            }

        }
        return false;
    }
}