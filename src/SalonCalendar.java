import java.util.ArrayList;

/**
 * @author Martin Poulsen, mapo0004@stud.kea.dk
 * @author Sebastian Holger Drumm, sedr0001@stud.kea.dk
 * @author Viktor Rasmussen, Vira0004@stud.kea.dk
 * Info: calendar class to handle timeslot and some parts of the appointment.
 */

public class SalonCalendar {

    public SalonCalendar() {
        Appointment.appointments = new ArrayList<>();
    }

    public static void createAppointment(String date, String details) {
        Appointment.appointments.add(date + " - " + details);
    }

    public boolean isTimeSlotOccupied(String selectedTimeSlot) {
        for (String appointment : Appointment.appointments) {
            if (appointment.startsWith(selectedTimeSlot)) {
                return true;
            }
        }
        return false;
    }
}