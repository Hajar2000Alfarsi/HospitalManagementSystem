package Entites;

import Interface.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Doctors extends Person implements Displayable {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctors(String id, String firstName, String lastName,
                   LocalDate dateOfBirth, String gender,
                   String poneNumber, String email, String address,
                   String doctorId, List<String> assignedPatients,
                   List<String> availableSlots,
                   double consultationFee, String departmentId,
                   int experienceYears, String qualification,
                   String specialization) {
        super(id, firstName, lastName, dateOfBirth, gender,
                poneNumber, email, address);
        this.doctorId = doctorId;
        this.assignedPatients = assignedPatients;
        this.availableSlots = availableSlots;
        this.consultationFee = consultationFee;
        this.departmentId = departmentId;
        this.experienceYears = experienceYears;
        this.qualification = qualification;
        this.specialization = specialization;
    }

    public Doctors(String doctorId, List<String> assignedPatients,
                   List<String> availableSlots, double consultationFee,
                   String departmentId, int experienceYears, String qualification,
                   String specialization) {
        this.doctorId = doctorId;
        this.assignedPatients = assignedPatients;
        this.availableSlots = availableSlots;
        this.consultationFee = consultationFee;
        this.departmentId = departmentId;
        this.experienceYears = experienceYears;
        this.qualification = qualification;
        this.specialization = specialization;
    }

    public Doctors() {
        this.availableSlots = new ArrayList<>();
        this.assignedPatients = new ArrayList<>();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    //Add Patient
    public void assignPatient(String patients) {
        this.assignedPatients.add(patients);
    }

    // Remove Patient
    public void removePatient(String patient) {
        assignedPatients.remove(patient);
    }

    //Update Availability
    public void updateAvailability(String slot) {
        availableSlots.add(slot);
    }

    //update fee
    public void updateFee(double fee) {
        this.consultationFee = fee;
    }

    //update fee , reason
    public void updateFee(double fee, String reason) {
        this.consultationFee = fee;
        System.out.println("Fee updated because: " + reason);
    }

    //Add Availability of slot
    public void addAvailability(String slot) {
        if (this.availableSlots == null) {
            this.availableSlots = new ArrayList<>();
        }
        this.availableSlots.add(slot);
    }

    //Add list of slot
    public void addAvailability(List<String> slots){
        if (this.availableSlots == null) {
            this.availableSlots = new ArrayList<>();
        }

        this.availableSlots.addAll(slots);
    }

    @Override
    public void displayInfo() {
        //super.displayInfo();

        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        /*System.out.println("Available Slots: " + availableSlots);
        System.out.println("Assigned Patients: " + assignedPatients);*/

        System.out.println("Available Slots: " +
                (availableSlots != null ? availableSlots : "[]"));

        System.out.println("Assigned Patients: " +
                (assignedPatients != null ? assignedPatients : "[]"));
    }

    @Override
    public void displaySummary() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Dr: " + getFirstName() + " " + getLastName());
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId='" + doctorId + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experienceYears=" + experienceYears +
                ", departmentId='" + departmentId + '\'' +
                ", consultationFee=" + consultationFee +
                ", availableSlots=" + availableSlots +
                ", assignedPatients=" + assignedPatients +
                '}';
    }

    @Override
    public void edit(Object updatedData) {
    }

    @Override
    public void validate() {

    }
}
