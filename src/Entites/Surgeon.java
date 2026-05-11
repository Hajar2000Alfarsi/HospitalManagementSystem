package Entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctors{
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String poneNumber, String email,
                   String address, String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee,
                   String departmentId, int experienceYears, String qualification, String specialization, int surgeriesPerformed,
                   List<String> surgeryTypes, boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address, doctorId, assignedPatients, availableSlots, consultationFee,
                departmentId, experienceYears, qualification, specialization);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public Surgeon(String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee, String departmentId,
                   int experienceYears, String qualification, String specialization, int surgeriesPerformed, List<String> surgeryTypes,
                   boolean operationTheatreAccess) {
        super(doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public Surgeon() {
        this.surgeryTypes = new ArrayList<>();
    }

    public Surgeon(int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }


}
