package Entites;

import Interface.Displayable;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctors implements Displayable {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String poneNumber, String email, String address, String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee, String departmentId, int experienceYears, String qualification, String specialization, boolean walkinAvailable, boolean vaccinationCertified, boolean homeVisitAvailable) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address, doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        this.walkinAvailable = walkinAvailable;
        this.vaccinationCertified = vaccinationCertified;
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public GeneralPractitioner(boolean walkinAvailable, boolean vaccinationCertified, boolean homeVisitAvailable) {
        this.walkinAvailable = walkinAvailable;
        this.vaccinationCertified = vaccinationCertified;
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public GeneralPractitioner(String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee, String departmentId, int experienceYears, String qualification, String specialization, boolean walkinAvailable, boolean vaccinationCertified, boolean homeVisitAvailable) {
        super(doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        this.walkinAvailable = walkinAvailable;
        this.vaccinationCertified = vaccinationCertified;
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public void scheduleHomeVisit(Patients patients, String address, String time) {
        if (!homeVisitAvailable) {
            System.out.println("Home visit is not available.");
            return;
        }
        System.out.println("Home visit scheduled successfully.");
        System.out.println("Patient: " + patients.getFirstName() + " " + patients.getLastName());
        System.out.println("Address: " + address);
        System.out.println("Time: " + time);
    }

    public void administerVaccine(Patients patients, String vaccineType) {
        //Check if doctor have permission
        if (!vaccinationCertified) {
            System.out.println("Doctor is not certified for vaccination");
            return;
        }

        if (patients == null) {
            System.out.println("Patient not found.");
            return;
        }

        //Check if user write vaccine
        if (vaccineType.isEmpty() || vaccineType == null) {
            System.out.println("Invalid vaccine type");
            return;
        }

        //display
        System.out.println("Vaccine administered successfully.");
        System.out.println("Patient Id: " + patients.getPatientId());
        System.out.println("Patient Name: " + patients.getFirstName() + " " + patients.getLastName());
        System.out.println("Vaccine Type: " + vaccineType);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Walk-in Available: " + walkinAvailable);
        System.out.println("Home Visit Available: " + homeVisitAvailable);
        System.out.println("Vaccination Certified: " + vaccinationCertified);
    }

    @Override
    public void displaySummary() {
        System.out.println("Doctor ID: " + getDoctorId());
        System.out.println("Doctor Name: " + getFirstName() + " " + getLastName());
        System.out.println("Walk-in Available: " + walkinAvailable);
    }

    @Override
    public String toString() {
        return "GeneralPractitioner{" +
                "walkinAvailable=" + walkinAvailable +
                ", homeVisitAvailable=" + homeVisitAvailable +
                ", vaccinationCertified=" + vaccinationCertified +
                '}';
    }
}
