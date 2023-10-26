import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Appointment {
        static ArrayList<Customer> listCustomer = new ArrayList<>();

        public static void main(String[] args) {
                Customer c1 = new Customer(22263888, "henrik", 0);
                Customer c2 = new Customer(888, "kim", 0);
                Customer tester = new Customer(10, "Ledig Tid", 0);
                listCustomer.add(tester);
                listCustomer.add(c1);
                listCustomer.add(c2);

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
                        System.out.println("6. lav bruger");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                                case 1:
                                        Monday();
                                        break;
                                case 6:
                                lavBruger();
                                break;
                        }


                }
        }


        public static void Monday() {
                Scanner scanner = new Scanner(System.in);
                Day[] App = new Day[7];
/*
                App[0]=new Day(listCustomer.get(0));
                App[1]=new Day(listCustomer.get(0));
                App[2]=new Day(listCustomer.get(0));
                App[3]=new Day(listCustomer.get(0));
                App[4]=new Day(listCustomer.get(0));
                App[5]=new Day(listCustomer.get(0));
               App[6]=new Day(listCustomer.get(0));
*/
                // ArrayList<String> MandagsTidsListe = new ArrayList<>();

                System.out.println("liste over dagen");
                printDay(App);

                System.out.println("skriv kundens telefon nr");

                int getCustomerPhoneNumber = scanner.nextInt();
                Customer foundCustomer = findCustomerByPhoneNumber(getCustomerPhoneNumber);

                if (foundCustomer != null) {
                        foundCustomer.PrintCustom();
                } else {
                        System.out.println("Kunden blev ikke fundet.");
                }

                System.out.println("skriv nummer i rækken");
                int Nr = scanner.nextInt();

                if (Nr >= 0 && Nr < App.length) {
                        if (App[Nr] == null) // ! betyder at vi tester om dagen er booket.
                                 {
                                App[Nr] = new Day(foundCustomer);
                                System.out.println("Aftale oprettet.");
                        }else {
                                System.out.println("du har valg en nr sommer allerede er booket");
                        }
                }

               // App[Nr] = new Day("Booket");

                printDay(App);

        }
        static void printDay(Day[] team) {
                for (int i = 0; i < team.length; i++)
                        System.out.println(team[i]);
        }

        public static Customer findCustomerByPhoneNumber(int phoneNumber) {
                for (Customer customer : listCustomer) {
                        if (customer.getPhoneNumber() == phoneNumber) {
                                return customer;
                        }
                }
                return null; // Returnerer null, hvis kunden ikke blev fundet
        }


        public static void lavBruger(){
                Scanner scanner = new Scanner(System.in);

                System.out.println("du har valgt mandag");
                System.out.println("skriv kundens telefon nr");
                int phoneNumber = scanner.nextInt();
                System.out.println("skriv kundens navn");
                String name = scanner.next();
                System.out.println();

                Customer customer = new Customer(phoneNumber, name, 0);
                listCustomer.add(customer);
                System.out.println(customer);

        }


}


class Day {
         Customer customer;

         public Day(Customer customer) {
                 this.customer = customer;
         }

        public boolean isBooked() {
                 boolean tjek = false;
                if ( customer== null) tjek = false;
                else tjek=true;

                 return tjek;
        }

         @Override
         public String toString() {
                 if (customer != null) {
                         return customer.getNavn() + " (" + customer.getPhoneNumber() + ")";
                 } else {
                         return "Ledig tid";
                 }
         }
 }
