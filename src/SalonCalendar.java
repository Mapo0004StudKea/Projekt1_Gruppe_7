import java.util.ArrayList;

public class SalonCalendar {
    public SalonCalendar() {
        Appointment.appointments = new ArrayList<>();
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