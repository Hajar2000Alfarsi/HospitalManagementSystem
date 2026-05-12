package Entites;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patients{
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String poneNumber, String email, String address, String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments, String insuranceId, String emergencyContact, LocalDate registrationDate, List<String> allergies, String bloodGroup, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address, patientId, medicalRecords, appointments, insuranceId, emergencyContact, registrationDate, allergies, bloodGroup);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments, String insuranceId, String emergencyContact, LocalDate registrationDate, List<String> allergies, String bloodGroup, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(patientId, medicalRecords, appointments, insuranceId, emergencyContact, registrationDate, allergies, bloodGroup);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public void outPatient() {

    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    public void scheduleFollowUp(LocalDate followUpDate) {
        if (followUpDate == null) {
            System.out.println("Invalid follow-up date.");
            return;
        }

        System.out.println("Follow-up appointment scheduled successfully.");
        System.out.println("Follow-up Date: " + followUpDate);
    }
}
