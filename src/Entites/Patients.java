package Entites;

import java.time.LocalDate;
import java.util.List;

public class Patients extends Person{
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecords> medicalRecords;
    private List<Appointments> appointments;
}
