package Entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctors{
    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String poneNumber, String email, String address, String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee, String departmentId, int experienceYears, String qualification, String specialization, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber, email, address, doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public Consultant(String doctorId, List<String> assignedPatients, List<String> availableSlots, double consultationFee, String departmentId, int experienceYears, String qualification, String specialization, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public Consultant(List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public Consultant() {
        this.consultationTypes = new ArrayList<>();
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public void scheduleConsultation(String consultationType, boolean online){
        if (!consultationTypes.contains(consultationType)){
            System.out.println("Consultation Types Not supported");
            return;
        }

        //if patient want online and doctor not support online
        if (online && !onlineConsultationAvailable) {
            System.out.println("Online consultation is not available.");
            return;
        }

        System.out.println("Consultation scheduled successfully.");
        System.out.println("Type: " + consultationType);
        System.out.println("Mode: " + (online? "online" : "Offline"));
    }


}
