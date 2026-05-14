package service;

import Entites.*;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

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

    public Departments addDepartment() {
        System.out.println("Add new Department ");

        System.out.println("Department ID: ");
        //String departmentId = scanner.nextLine();
        String departmentId = HelperUtils.generateId("DEP");
        System.out.println("Assigned ID to Department: " + departmentId );

        /*System.out.println("Enter Department Name: ");
        String departmentName = scanner.nextLine();*/
        String departmentName = InputHandler.getStringInput("Enter Department Name: ");

        /*System.out.println("Enter Head Doctor ID: ");
        String headDoctorId = scanner.nextLine();*/
        String headDoctorId = InputHandler.getStringInput("Enter Head Doctor ID: ");

        /*System.out.println("Enter Bed Capacity: ");
        int bedCapacity = scanner.nextInt();*/
        int bedCapacity = InputHandler.getIntInput("Enter Bed Capacity: ");

        /*System.out.println("Enter available Beds: ");
        int availableBeds = scanner.nextInt();
        scanner.nextLine();*/
        int availableBeds = InputHandler.getIntInput("Enter Available Beds: ");

        Departments departments = new Departments(departmentId,doctors,departmentName,headDoctorId,nurses,bedCapacity,availableBeds);
        return departments;
    }

    public List<Departments> addDepartments() {
        Boolean continueFlag = true;

        while (continueFlag) {
            departmentsList.add(addDepartment());
            System.out.println("Department Added Successfully");

            String input = InputHandler.getStringInput("Enter q to exit, press ENTER to continue: ");

            if (input.equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return departmentsList;
    }

    public boolean editDepartment(String departmentId) {
        for (Departments department: departmentsList){
            if (HelperUtils.isNotNull(department.getDepartmentId())
            && department.getDepartmentId().equals(departmentId)){
                /*System.out.println("Enter Updated Department Name: ");
                department.setDepartmentName(scanner.nextLine());*/
                department.setDepartmentName(InputHandler.getStringInput("Enter Updated Department Name: "));

                /*System.out.println("Updated head doctor ID: ");
                department.setHeadDoctorId(scanner.nextLine());*/
                department.setHeadDoctorId(InputHandler.getStringInput("Updated Head Doctor ID: "));

              /*  System.out.println("Updated Bed Capacity: ");
                department.setBedCapacity(scanner.nextInt());*/
                int bedCapacity = InputHandler.getIntInput("Updated Bed Capacity: ");
                department.setBedCapacity(bedCapacity);

               /* System.out.println("Updated Available Beds: ");
                department.setAvailableBeds(scanner.nextInt());
                scanner.nextLine();*/
                int availableBeds = InputHandler.getIntInput("Updated Available Beds: ");
                department.setAvailableBeds(availableBeds);

                System.out.println("Department updated successfully.");
                return true;
            }

        }

        System.out.println("Department not found.");
        return false;
    }

    public boolean removeDepartment(String departmentId) {

        for (Departments department: departmentsList) {
            if (department.getDepartmentId().equals(departmentId)) {
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
            if (HelperUtils.isNotNull(department.getDepartmentId())
            && department.getDepartmentId().equals(departmentId)) {
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
            if (HelperUtils.isNotNull(department.getDepartmentId())
            && department.getDepartmentId().equals(departmentId)) {
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
            if (HelperUtils.isNotNull(department.getDepartmentId())
            && department.getDepartmentId().equals(departmentId)) {
                department.getNurses().add(nurses1);
                System.out.println("Nurse Assigned Successfully");
                return;
            }
        }
        System.out.println("Doctor failed to assign");
    }

    public void updateBedAvailability(String departmentId, int availableBeds) {
        for (Departments dept:departmentsList){
            if (HelperUtils.isNotNull(dept.getDepartmentId())
            && dept.getDepartmentId().equals(departmentId)){
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
                String dId = InputHandler.getStringInput("Enter Department ID: ");

                editDepartment(dId);
            }
            case 3 -> {
                String dId = InputHandler.getStringInput("Enter Department ID: ");

                removeDepartment(dId);
            }
            case 4 -> {
                String id = InputHandler.getStringInput("Write Department ID: ");

                getDepartmentById(id);
            }
            case 5 -> {
                displayAllDepartments();
            }
            case 6 -> {
                String doctorId = InputHandler.getStringInput("Write Doctor ID: ");
                String departmentId = InputHandler.getStringInput("Write Department ID: ");


                assignDoctor(doctorId, departmentId);
            }
            case 7 -> {
                String nurseID = InputHandler.getStringInput("Write Nurse ID: ");
                String departmentId = InputHandler.getStringInput("Write Department ID: ");

                assignNurse(nurseID, departmentId);
            }
            case 8 -> {
                String departmentId = InputHandler.getStringInput("Write Department ID: ");
                int availableBeds = InputHandler.getIntInput("Write Number of available beds: ");

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
