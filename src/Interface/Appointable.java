package Interface;

import Entites.Appointments;

import java.time.LocalDate;

public interface Appointable {
    void scheduleAppointment(Appointments appointment);
    void cancelAppointment(String appointmentId);
    void rescheduleAppointment(String appointmentId, LocalDate newDate);
}
