package Entites;

import java.time.LocalDateTime;
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



}
