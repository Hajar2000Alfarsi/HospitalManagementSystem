package Entites;

import java.util.List;

public class Departments {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<Doctors> doctors;
    private List<Nurses> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Departments(String departmentId, List<Doctors> doctors,
                       String departmentName, String headDoctorId,
                       List<Nurses> nurses, int bedCapacity,
                       int availableBeds) {
        this.departmentId = departmentId;
        this.doctors = doctors;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }
}
