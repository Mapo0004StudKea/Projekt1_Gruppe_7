import java.util.ArrayList;
public class AppointmentCalendar {

    public AppointmentCalendar() {
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