package Entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurses extends Person{
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<Patients> assignedPatients;

    public Nurses(String id, String firstName, String lastName,
                  LocalDate dateOfBirth, String gender,
                  String poneNumber, String email, String address,
                  String departmentId, String nurseId, String shift,
                  String qualification, List<Patients> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, poneNumber,
                email, address);
        this.departmentId = departmentId;
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public Nurses(String departmentId, String nurseId, String shift,
                  String qualification, List<Patients> assignedPatients) {
        this.departmentId = departmentId;
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public Nurses() {
        this.assignedPatients = new ArrayList<>();
    }
}
