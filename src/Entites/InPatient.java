package Entites;

import Interface.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patients implements Displayable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String poneNumber, String email, String address, String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments, String insuranceId, String emergencyContact, LocalDate registrationDate, List<String> allergies, String bloodGroup, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address, patientId, medicalRecords, appointments, insuranceId, emergencyContact, registrationDate, allergies, bloodGroup);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public InPatient(String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments, String insuranceId, String emergencyContact, LocalDate registrationDate, List<String> allergies, String bloodGroup, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(patientId, medicalRecords, appointments, insuranceId, emergencyContact, registrationDate, allergies, bloodGroup);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public InPatient(LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public InPatient() {

    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public long calculateStayDuration(){
        if(admissionDate == null || dischargeDate == null) {
            return 0;
        }
        //Count days between admissionDate and dischargeDate
        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);
    }

    public double calculateTotalCharges() {
        long days = calculateStayDuration();

        if (days <= 0) {
            return 0;
        }

        return days * dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("Admitting Doctor ID: " + admittingDoctorId);
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("Stay Duration: " + calculateStayDuration() + " days");
        System.out.println("Total Charges: " + calculateTotalCharges());
    }

    @Override
    public void displaySummary() {
        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Admitting Doctor ID: " + admittingDoctorId);
    }

    @Override
    public String toString() {
        return "InPatient{" +
                "admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedNumber='" + bedNumber + '\'' +
                ", admittingDoctorId='" + admittingDoctorId + '\'' +
                ", dailyCharges=" + dailyCharges +
                '}';
    }
}
