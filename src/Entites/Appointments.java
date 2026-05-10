package Entites;

import java.time.LocalDate;

public class Appointments {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointments(String appointmentId, String doctorId,
                        String patientId, LocalDate appointmentDate,
                        String appointmentTime, String status,
                        String reason, String notes) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }


}
