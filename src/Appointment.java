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
                                case 2:
                                        Tuesday();
                                        break;
                                case 3:
                                       Wednesday();
                                       break;
                                case 4:
                                        Thursday();
                                        break;
                                case 5:
                                        Friday();
                                        break;
                                case 6:
                                        lavBruger();
                                        break;
                        }


                }
        }

        public static void Monday() {
                Scanner scanner = new Scanner(System.in);
                Day[] mondayArry = new Day[7];
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
                printDay(mondayArry);

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

                if (Nr >= 0 && Nr < mondayArry.length) {
                        if (mondayArry[Nr] == null) // ! betyder at vi tester om dagen er booket.
                        {
                                Calendar mondayDate = Calendar.getInstance();
                                mondayDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                mondayArry[Nr] = new Day(foundCustomer, mondayDate);
                                System.out.println("Aftale oprettet.");
                        } else {
                                System.out.println("du har valg en nr sommer allerede er booket");
                        }
                }
                printDay(mondayArry);}

        public static void Tuesday(){
        Scanner scanner = new Scanner(System.in);
        Day[] tuesdayArry = new Day[7];
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

        printDay(tuesdayArry);

                System.out.println("skriv kundens telefon nr");

        int getCustomerPhoneNumber = scanner.nextInt();
        Customer foundCustomer = findCustomerByPhoneNumber(getCustomerPhoneNumber);

                if(foundCustomer !=null)
        {
                foundCustomer.PrintCustom();
        } else {
                System.out.println("Kunden blev ikke fundet.");
        }

                System.out.println("skriv nummer i rækken");
        int Nr = scanner.nextInt();

                if(Nr >=0&&Nr<tuesdayArry.length) {
                if (tuesdayArry[Nr] == null) // ! betyder at vi tester om dagen er booket.
                {
                        Calendar tuesdayDate = Calendar.getInstance();
                        tuesdayDate.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                        tuesdayArry[Nr] = new Day(foundCustomer, tuesdayDate);
                        System.out.println("Aftale oprettet.");
                } else {
                        System.out.println("du har valg en nr sommer allerede er booket");
                }
        }



        printDay(tuesdayArry);
}
        public static void Wednesday(){
                Scanner scanner = new Scanner(System.in);
                Day[] wednesdayArry = new Day[7];
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

                printDay(wednesdayArry);

                System.out.println("skriv kundens telefon nr");

                int getCustomerPhoneNumber = scanner.nextInt();
                Customer foundCustomer = findCustomerByPhoneNumber(getCustomerPhoneNumber);

                if(foundCustomer !=null)

                {
                        foundCustomer.PrintCustom();
                } else
                {
                        System.out.println("Kunden blev ikke fundet.");
                }

                System.out.println("skriv nummer i rækken");
                int Nr = scanner.nextInt();

                if(Nr >=0&&Nr<wednesdayArry.length) {
                        if (wednesdayArry[Nr] == null) // ! betyder at vi tester om dagen er booket.
                        {
                                Calendar wednesdayDate = Calendar.getInstance();
                                wednesdayDate.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                wednesdayArry[Nr] = new Day(foundCustomer, wednesdayDate);
                                System.out.println("Aftale oprettet.");
                        } else {
                                System.out.println("du har valg en nr sommer allerede er booket");
                        }
                }
                printDay(wednesdayArry);}

        public static void Thursday(){
                Scanner scanner = new Scanner(System.in);
                Day[] thursdayArry = new Day[7];
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

                printDay(thursdayArry);

                System.out.println("skriv kundens telefon nr");

                int getCustomerPhoneNumber = scanner.nextInt();
                Customer foundCustomer = findCustomerByPhoneNumber(getCustomerPhoneNumber);

                if(foundCustomer !=null) {
                        foundCustomer.PrintCustom();
                } else

                {
                        System.out.println("Kunden blev ikke fundet.");
                }

                System.out.println("skriv nummer i rækken");
                int Nr = scanner.nextInt();

                if(Nr >=0&&Nr<thursdayArry.length) {
                        if (thursdayArry[Nr] == null) // ! betyder at vi tester om dagen er booket.
                        {
                                Calendar thursdayDate = Calendar.getInstance();
                                thursdayDate.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                thursdayArry[Nr] = new Day(foundCustomer, thursdayDate);
                                System.out.println("Aftale oprettet.");
                        } else {
                                System.out.println("du har valg en nr sommer allerede er booket");
                        }
                }

                // App[Nr] = new Day("Booket");

                printDay(thursdayArry);

        }
        public static void Friday(){
                Scanner scanner = new Scanner(System.in);
                Day[] fridayArry = new Day[7];
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

                printDay(fridayArry);

                System.out.println("skriv kundens telefon nr");

                int getCustomerPhoneNumber = scanner.nextInt();
                Customer foundCustomer = findCustomerByPhoneNumber(getCustomerPhoneNumber);

                if(foundCustomer !=null) {
                        foundCustomer.PrintCustom();
                } else {
                        System.out.println("Kunden blev ikke fundet.");
                }

                System.out.println("skriv nummer i rækken");
                int Nr = scanner.nextInt();

                if(Nr >=0&&Nr<fridayArry.length) {
                        if (fridayArry[Nr] == null) // ! betyder at vi tester om dagen er booket.
                        {
                        Calendar fridayDate = Calendar.getInstance();
                        fridayDate.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                        fridayArry[Nr] = new Day(foundCustomer, fridayDate);
                        System.out.println("Aftale oprettet.");
                        } else {
                                System.out.println("du har valg en nr sommer allerede er booket");
                        }
                }
                printDay(fridayArry);}

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
                return null;
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
         Calendar date;

         public Day(Customer customer, Calendar date) {
                 this.customer = customer;
                 this.date = date;
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
                         return customer.getNavn() + " " + customer.getPhoneNumber() + " dato = " + date.getTime();
                 } else {
                         return "Ledig tid";
                 }
         }
 }
