package Entites;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctors{
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

    public GeneralPractitioner(){

    }
}
