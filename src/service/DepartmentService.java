package service;

import Entites.*;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService implements Manageable, Searchable {
    List<Departments> departmentsList = new ArrayList<>();
    List<Doctors> doctors = new ArrayList<>();
    List<Nurses> nurses = new ArrayList<>();
    //private DoctorService doctorService = new DoctorService();
    NurseService nurseService = new NurseService();
    Departments departments = new Departments();

    private DoctorService doctorService;

    // Constructor Injection
    public DepartmentService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    Scanner scanner = new Scanner(System.in);

    public Departments addDepartment() {
        System.out.println("Add new Department ");

        System.out.println("Department ID: ");
        //String departmentId = scanner.nextLine();
        String departmentId = HelperUtils.generateId("DEP");
        System.out.println("Assigned ID to Department: " + departmentId );

        System.out.println("Enter Department Name: ");
        String departmentName = scanner.nextLine();

        System.out.println("Enter Head Doctor ID: ");
        String headDoctorId = scanner.nextLine();

        System.out.println("Enter Bed Capacity: ");
        int bedCapacity = scanner.nextInt();

        System.out.println("Enter available Beds: ");
        int availableBeds = scanner.nextInt();
        scanner.nextLine();

        Departments departments = new Departments(departmentId,doctors,departmentName,headDoctorId,nurses,bedCapacity,availableBeds);
        return departments;
    }

    public List<Departments> addDepartments() {
        Boolean continueFlag = true;

        while (continueFlag) {
            departmentsList.add(addDepartment());
            System.out.println("Department Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return departmentsList;
    }

    public boolean editDepartment() {

        System.out.println("Enter Department ID: ");
        String dId = scanner.nextLine();

        for (Departments department: departmentsList){
            if (department.getDepartmentId().equals(dId)){
                System.out.println("Enter Updated Department Name: ");
                department.setDepartmentName(scanner.nextLine());

                System.out.println("Updated head doctor ID: ");
                department.setHeadDoctorId(scanner.nextLine());

                System.out.println("Updated Bed Capacity: ");
                department.setBedCapacity(scanner.nextInt());

                System.out.println("Updated Available Beds: ");
                department.setAvailableBeds(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Department updated successfully.");
                return true;
            }

        }

        System.out.println("Department not found.");
        return false;
    }

    public boolean removeDepartment() {
        System.out.println("Enter department ID: ");
        String dId = scanner.nextLine();

        for (Departments department: departmentsList) {
            if (department.getDepartmentId().equals(dId)) {
                departmentsList.remove(department);
                System.out.println("department removed successfully");
                return true;
            }
        }
        System.out.println("department not found");
        return false;
    }

    public Departments getDepartmentById(String departmentId) {
        for (Departments department: departmentsList) {
            if (department.getDepartmentId().equals(departmentId)) {
                //department.displayInfo();
                return department;
            }
        }
        System.out.println("Department not found");
        return null;
    }

    public void displayAllDepartments() {
        if (departmentsList.isEmpty()){
            System.out.println("No Patient added");
            return;
        }
        for (Departments department: departmentsList) {
            department.displayInfo();
        }
    }

    public void assignDoctor(String doctorId, String departmentId) {

        Doctors doctors1 = doctorService.getDoctorById(doctorId);

        for (Departments department: departmentsList){
            if (department.getDepartmentId().equals(departmentId)) {
                department.getDoctors().add(doctors1);
                System.out.println("Doctor Assigned Successfully");
                return;
            }
        }
        System.out.println("Doctor failed to assign");
    }

    public void assignNurse(String nurseID, String departmentId) {

        Nurses nurses1 = nurseService.getNurseById(nurseID);

        for (Departments department: departmentsList){
            if (department.getDepartmentId().equals(departmentId)) {
                department.getNurses().add(nurses1);
                System.out.println("Nurse Assigned Successfully");
                return;
            }
        }
        System.out.println("Doctor failed to assign");
    }

    public void updateBedAvailability(String departmentId, int availableBeds) {
        for (Departments dept:departmentsList){
            if (dept.getDepartmentId().equals(departmentId)){
                dept.setAvailableBeds(availableBeds);
                System.out.println("Beds updated successfully.");
                return;
            }
        }
        System.out.println("Department not found");
    }

    public boolean handleDepartmentMenu(Integer departmentOption){

        switch (departmentOption) {
            case 1 -> {
                addDepartments();
            }
            case 2 -> {
                editDepartment();
            }
            case 3 -> {
                removeDepartment();
            }
            case 4 -> {
                System.out.println("Write Department ID: ");
                String id = scanner.nextLine();
                getDepartmentById(id);
            }
            case 5 -> {
                displayAllDepartments();
            }
            case 6 -> {
                System.out.println("Write Doctor ID: ");
                String doctorId = scanner.nextLine();
                System.out.println("Write Department ID: ");
                String departmentId = scanner.nextLine();

                assignDoctor(doctorId, departmentId);
            }
            case 7 -> {
                System.out.println("Write Nurse ID: ");
                String nurseID = scanner.nextLine();
                System.out.println("Write Department ID: ");
                String departmentId = scanner.nextLine();

                assignNurse(nurseID, departmentId);
            }
            case 8 -> {
                System.out.println("Write Department ID: ");
                String departmentId = scanner.nextLine();
                System.out.println("Write Number of available beds: ");
                int availableBeds = scanner.nextInt();
                scanner.nextLine();

                updateBedAvailability(departmentId,availableBeds);
            }
            case 9 -> {
                System.out.println("Exit");
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
