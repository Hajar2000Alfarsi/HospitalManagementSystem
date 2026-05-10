package Entites;

import java.util.ArrayList;
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

    public Departments() {
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Nurses> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurses> nurses) {
        this.nurses = nurses;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    //Assign Doctor
    public void assignDoctor(Doctors doctors) {
        this.doctors.add(doctors);
    }

    // Assign Nurse
    public void  assignNurse(Nurses nurses) {
        this.nurses.add(nurses);
    }

    //Update Bed Availability
    public void updateBedAvailability(int beds) {
        this.availableBeds = beds;
    }


    public void displayInfo() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Doctors: " + doctors);
        System.out.println("Nurses: " + nurses);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }
}
