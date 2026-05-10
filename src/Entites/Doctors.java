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

}
