import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 *
 * Info: Appointment class to create, delete/cancel and display/view appointments.
 */
public class Appointment {
        public static List<String> appointments;

        public static void deleteAppointment(String appointment) {
                appointments.remove(appointment);
        }
        public static List<String> getAllAppointments() {
                return new ArrayList<>(Appointment.appointments);
        }

        public static void displayAllAppointments() {
                for (String appointment : Appointment.appointments) {
                        System.out.println(appointment);
                }
        }
        public static void createAppointment(SalonCalendar salonCalendar, List<Customer> customers, Scanner scanner) {
                String selectedTimeSlot = HarrysSalonMenu.selectTimeSlot(scanner);

                if (selectedTimeSlot == null) {
                        System.out.println("Invalid day or time slot selection.");
                        return;
                }

                if (salonCalendar.isTimeSlotOccupied(selectedTimeSlot)) {
                        System.out.println("The selected timeslot is already occupied.");
                        return;
                }

                String details = Appointment.enterAppointmentDetails(scanner);

                if (customers.isEmpty() && Customer.createCustomerOption(scanner)) {
                        Customer.addCustomer(customers, scanner);
                        int customerNumber = Customer.selectCustomer(scanner, customers);
                        if (customerNumber != -1) {
                                Customer selectedCustomer = customers.get(customerNumber);
                                String appointmentInfo = "Customer: " + selectedCustomer.getName() + ", " + details;
                                SalonCalendar.createAppointment(selectedTimeSlot, appointmentInfo);
                                System.out.println("Appointment created for " + selectedTimeSlot);
                        } else {
                                System.out.println("Invalid customer selection.");
                        }
                } else if (!customers.isEmpty()) {
                        int customerNumber = Customer.selectCustomer(scanner, customers);

                        if (customerNumber != -1) {
                                Customer selectedCustomer = customers.get(customerNumber);
                                String appointmentInfo = "Customer: " + selectedCustomer.getName() + ", " + details;
                                SalonCalendar.createAppointment(selectedTimeSlot, appointmentInfo);
                                System.out.println("Appointment created for " + selectedTimeSlot);
                        } else {
                                System.out.println("Invalid customer selection.");
                        }
                } else {
                        System.out.println("Appointment creation canceled.");
                }
        }

        public static String enterAppointmentDetails(Scanner scanner) {
                System.out.print("Enter appointment details: ");
                return scanner.nextLine();
        }

        public static void cancelAppointment(Scanner scanner) {
                List<String> appointments = getAllAppointments();

                if (appointments.isEmpty()) {
                        System.out.println("No appointments available to cancel.");
                        return;
                }

                System.out.println("Select an appointment to cancel:");
                for (int i = 0; i < appointments.size(); i++) {
                        System.out.println((i + 1) + ". " + appointments.get(i));
                }
                System.out.print("Enter the appointment number to cancel (1-" + appointments.size() + "): ");
                int appointmentNumber = scanner.nextInt();
                scanner.nextLine();

                if (appointmentNumber < 1 || appointmentNumber > appointments.size()) {
                        System.out.println("Invalid appointment selection.");
                        return;
                }

                String appointmentToCancel = appointments.get(appointmentNumber - 1);
                deleteAppointment(appointmentToCancel);
                System.out.println("Appointment canceled: " + appointmentToCancel);
        }

        static void viewAppointments() {
                System.out.println("Appointments:");
                displayAllAppointments();
        }
}
