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

    public Patients(String id, String firstName, String lastName,
                    LocalDate dateOfBirth, String gender,
                    String poneNumber, String email, String address,
                    String patientId, List<MedicalRecords> medicalRecords,
                    List<Appointments> appointments, String insuranceId,
                    String emergencyContact, LocalDate registrationDate,
                    List<String> allergies, String bloodGroup) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address);
        this.patientId = patientId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
        this.insuranceId = insuranceId;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
    }

    public Patients(String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments, String insuranceId, String emergencyContact, LocalDate registrationDate, List<String> allergies, String bloodGroup) {
        this.patientId = patientId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
        this.insuranceId = insuranceId;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
    }
}
