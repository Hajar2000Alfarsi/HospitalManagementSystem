package Entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Doctors extends Person{
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<LocalDateTime> availableSlots;
    private List<Patients> assignedPatients;

    public Doctors(String id, String firstName, String lastName,
                   LocalDate dateOfBirth, String gender,
                   String poneNumber, String email, String address,
                   String doctorId, List<Patients> assignedPatients,
                   List<LocalDateTime> availableSlots,
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

    public Doctors(String doctorId, List<Patients> assignedPatients,
                   List<LocalDateTime> availableSlots, double consultationFee,
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

    public List<LocalDateTime> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<LocalDateTime> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<Patients> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patients> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    //Add Patient
    public void assignPatient(Patients patients) {
        this.assignedPatients.add(patients);
    }

    // Remove Patient
    public void removePatient(Patients patient) {
        assignedPatients.remove(patient);
    }

    //Update Availability
    public void updateAvailability(LocalDateTime slot) {
        availableSlots.add(slot);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Available Slots: " + availableSlots);
        System.out.println("Assigned Patients: " + assignedPatients);
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
}
