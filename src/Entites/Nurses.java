package Entites;

import Interface.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurses extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;

    public Nurses(String id, String firstName, String lastName,
                  LocalDate dateOfBirth, String gender,
                  String poneNumber, String email, String address,
                  String departmentId, String nurseId, String shift,
                  String qualification, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber,
                email, address);
        this.departmentId = departmentId;
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public Nurses(String departmentId, String nurseId, String shift,
                  String qualification, List<String> assignedPatients) {
        this.departmentId = departmentId;
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public Nurses() {
        this.assignedPatients = new ArrayList<>();
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void assignPatient(String patients) {
        assignedPatients.add(patients);
    }

    public void removePatient(Patients patients) {
        assignedPatients.remove(patients);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    @Override
    public void displaySummary() {
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Nurse: " + getFirstName() + " " + getLastName());
    }

    @Override
    public String toString() {
        return "Nurses{" +
                "nurseId='" + nurseId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", shift='" + shift + '\'' +
                ", qualification='" + qualification + '\'' +
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
