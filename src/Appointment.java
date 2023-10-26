import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Appointment {
        static ArrayList<Customer> listCustomer = new ArrayList<>();

        public static void main(String[] args) {
                NewAppointment();
        }

        public static void NewAppointment() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                        System.out.println("1. monday");
                        System.out.println("2. tirsday");
                        System.out.println("3. onsdag");
                        System.out.println("4. torsdag");
                        System.out.println("5. fredag");


                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                                case 1:
                                        Monday();
                                        break;
                        }


                }
        }


        public static void Monday() {

                Scanner scanner = new Scanner(System.in);

                System.out.println("du har valgt mandag");
                System.out.println("skriv kundens telefon nr");
                int phoneNumber = scanner.nextInt();
                System.out.println("skriv kundens navn");
                String name = scanner.next();
                System.out.println();

                Customer customer = new Customer(phoneNumber, name, 0);
                listCustomer.add(customer);

                Day[] App = new Day[8];
                // ArrayList<String> MandagsTidsListe = new ArrayList<>();

                System.out.println("liste over dagen");
                printDay(App);

                System.out.println("skriv kundens navn og tid");
                String tid = scanner.next();

                System.out.println("skriv nummer i rækken");
                System.out.println(" ");

                int Nr = scanner.nextInt();

                App[Nr] = new Day(tid);

                printDay(App);

                // MandagsTidsListe.add(tid);


        }

        static void printDay(Day[] team) {
                for (int i = 0; i < team.length; i++)
                        System.out.println(team[i]);
        }

}


 class Day {

         public Day(String tid) {

         }
 }