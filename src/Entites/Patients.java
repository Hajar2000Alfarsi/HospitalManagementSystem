package Entites;

import Interface.Displayable;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patients extends Person implements Displayable {
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

    public Patients(String patientId, List<MedicalRecords> medicalRecords, List<Appointments> appointments,
                    String insuranceId, String emergencyContact,
                    LocalDate registrationDate, List<String> allergies,
                    String bloodGroup) {
        this.patientId = patientId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
        this.insuranceId = insuranceId;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
    }

    //empty constructor
    public Patients() {
        this.allergies = new ArrayList<>();
        this.medicalRecords =  new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isNotNull(patientId)) {
            this.patientId = patientId;
        }
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (HelperUtils.isNotNull(registrationDate)) {
            this.registrationDate = registrationDate;
        }
    }

    public List<MedicalRecords> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        if (HelperUtils.isNotNull(emergencyContact)) {
            this.emergencyContact = emergencyContact;
        }
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if (HelperUtils.isNotNull(bloodGroup)) {
            this.bloodGroup = bloodGroup;
        }
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        if (HelperUtils.isNotNull(allergies)) {
            this.allergies = allergies;
        }
    }

    //Update phone number
    public void updateContact(String phone) {
        setPoneNumber(phone);
    }

    //Update phone number, email
    public void updateContact(String phone, String email){
        setPoneNumber(phone);
        setEmail(email);
    }

    //Update phone number, email, address
    public void updateContact(String phone, String email, String address){
        setPoneNumber(phone);
        setEmail(email);
        setAddress(address);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Patient ID:" + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Allergies: " + allergies);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance ID:" + insuranceId);
    }

    @Override
    public void displaySummary() {
        System.out.println("Patient ID:" + patientId);
        System.out.println("Patient: " + getFirstName() + " " + getLastName());
    }

    public void addMedicalRecord(MedicalRecords medicalRecords){
        this.medicalRecords.add(medicalRecords);

    }

    public void addAppointment(Appointments appointments) {
        this.appointments.add(appointments);
    }

    public void updateInsurance(String newInsuranceId) {
        this.insuranceId = newInsuranceId;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId='" + patientId + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", allergies=" + allergies +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", registrationDate=" + registrationDate +
                ", insuranceId='" + insuranceId + '\'' +
                ", medicalRecords=" + medicalRecords +
                ", appointments=" + appointments +
                '}';
    }

    @Override
    public void edit(Object updatedData) {
        Patients p = (Patients) updatedData;

        if (!HelperUtils.isNotNull(getLastName())) {
            System.out.println("Last name is required");
        }

        if (!HelperUtils.isValidAge(getDateOfBirth())) {
            System.out.println("Invalid date of birth");
        }

        if (!HelperUtils.isNotNull(getPoneNumber())) {
            System.out.println("Phone number is required");
        }

        if (!HelperUtils.isNotNull(getEmail())) {
            System.out.println("Email is required");
        }

        if (!HelperUtils.isNotNull(patientId)) {
            System.out.println("Patient ID is required");
        }

        if (!HelperUtils.isNotNull(bloodGroup)) {
            System.out.println("Blood group is required");
        }
    }

    @Override
    public void validate() {

    }
}

