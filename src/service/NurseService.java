package service;

import Entites.Doctors;
import Entites.Nurses;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService implements Manageable, Searchable {
    static List<Nurses> nursesList = new ArrayList<>();
    List<String> assignedPatients =new ArrayList<>();

    public Nurses addNurse() {
        System.out.println("Add new Nurse ");
        System.out.println("Nurse ID: ");
        //String nurseId = scanner.nextLine();
        String nurseId = HelperUtils.generateId("NUR");
        System.out.println("Assigned ID to Nurse: " + nurseId );

        /*System.out.println("Enter Civil ID: ");
        String civilId = scanner.nextLine();*/
        String civilId = InputHandler.getStringInput("Enter Civil ID: ");

        /*System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();*/
        String firstName = InputHandler.getStringInput("Enter First Name: ");

        /*System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();*/
        String lastName = InputHandler.getStringInput("Enter Last Name: ");

        /*System.out.println("Date Of Birth: ");
        String dateOfBirth = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);*/
        LocalDate dob = InputHandler.getDateInput("Date Of Birth: ");

        /*System.out.println("Gender: ");
        String gender = scanner.nextLine();*/
        String gender = InputHandler.getStringInput("Gender: ");

        /*System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();*/
        String phoneNumber = InputHandler.getStringInput("Phone Number: ");

        /*System.out.println("Email: ");
        String email = scanner.nextLine();*/
        String email = InputHandler.getStringInput("Email: ");

        /*System.out.println("Address: ");
        String address = scanner.nextLine();*/
        String address = InputHandler.getStringInput("Address: ");


        /*System.out.println("Department ID: ");
        String departmentId = scanner.nextLine();*/
        String departmentId = InputHandler.getStringInput("Department ID: ");

        /*System.out.println("Shift: ");
        String shift = scanner.nextLine();*/
        String shift = InputHandler.getStringInput("Shift: ");

        /*System.out.println("Qualification: ");
        String qualification = scanner.nextLine();*/
        String qualification = InputHandler.getStringInput("Qualification: ");

        Nurses nurses = new Nurses(civilId,firstName,lastName,dob,gender,phoneNumber,email,address,departmentId,nurseId,shift,qualification,assignedPatients);

        return nurses;
    }

    public List<Nurses> addNurses() {
        Boolean continueFlag = true;

        while (continueFlag) {
            nursesList.add(addNurse());
            System.out.println("Nurse Added Successfully");

            String input =  InputHandler.getStringInput("Enter q to exit, press ENTER to continue: ");
            if (input.equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return nursesList;
    }

    public boolean editNurse(String nurseId) {
        for (Nurses nurse: nursesList){
            if (nurse.getNurseId().equals(nurseId)){
                /*System.out.println("Enter Updated Civil ID: ");
                nurse.setId(scanner.nextLine());*/
                nurse.setId(InputHandler.getStringInput("Enter Updated Civil ID: "));

                /*System.out.println("Enter Updated First Name: ");
                nurse.setFirstName(scanner.nextLine());*/
                nurse.setFirstName(InputHandler.getStringInput("Enter Updated First Name: "));

                /*System.out.println("Enter Updated Last Name: ");
                nurse.setLastName(scanner.nextLine());*/
                nurse.setLastName(InputHandler.getStringInput("Enter Updated Last Name: "));

               /* System.out.println("Updated Date Of Birth: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate dob = LocalDate.parse(dateOfBirth);*/
                LocalDate dob = InputHandler.getDateInput("Updated Date Of Birth: ");
                nurse.setDateOfBirth(dob);

                /*System.out.println("Updated Gender: ");
                nurse.setGender(scanner.nextLine());*/
                nurse.setGender(InputHandler.getStringInput("Updated Gender: "));

                /*System.out.println("Updated Phone Number: ");
                nurse.setPoneNumber(scanner.nextLine());*/
                nurse.setPoneNumber(InputHandler.getStringInput("Updated Phone Number: "));


               /* System.out.println("Updated Email: ");
                nurse.setEmail(scanner.nextLine());*/
                nurse.setEmail(InputHandler.getStringInput("Updated Email: "));

                /*System.out.println("Updated Address: ");
                nurse.setAddress(scanner.nextLine());*/
                nurse.setAddress(InputHandler.getStringInput("Updated Address: "));

                /*System.out.println("Department ID: ");
                nurse.setDepartmentId(scanner.nextLine());*/
                nurse.setDepartmentId(InputHandler.getStringInput("Department ID: "));

                /*System.out.println("Shift: ");
                nurse.setShift(scanner.nextLine());*/
                nurse.setShift(InputHandler.getStringInput("Shift: "));

                /*System.out.println("Qualification: ");
                nurse.setQualification(scanner.nextLine());*/
                nurse.setQualification(InputHandler.getStringInput("Qualification: "));

            }
            System.out.println("Nurse updated successfully.");
            return true;
        }

        System.out.println("Nurse not found.");
        return false;
    }

    public boolean removeNurse(String nurseId) {
        for (Nurses nurse: nursesList) {

            if (HelperUtils.isNotNull(nurse)
            && nurse.getNurseId().equals(nurseId)){

                nursesList.remove(nurse);
                System.out.println("Nurse removed successfully");
                return true;
            }
        }
        System.out.println("Nurse not found");
        return false;
    }

    public Nurses getNurseById(String nurseId) {
        for (Nurses nurse: nursesList) {
            if (HelperUtils.isNotNull(nurse)
            && nurse.getNurseId().equals(nurseId)){
                nurse.displayInfo();
                return nurse;
            }
        }
        return null;
    }

    public void displayAllNurses() {
        if (nursesList.isEmpty()) {
            System.out.println("No Nurse added");
            return;
        }

        for (Nurses nurses: nursesList) {
            nurses.displayInfo();
            System.out.println("\n");
        }
    }

    public List<Nurses> getNurseByDepartment(String departmentId) {
        List<Nurses> result = new ArrayList<>();

        for (Nurses nurse: nursesList) {
            if (HelperUtils.isNotNull(nurse)
            && nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                nurse.displayInfo();
                result.add(nurse);
            }
        }
        return result;
    }

    public List<Nurses> getNursesByShift(String shiftToDisplay) {
        List<Nurses> result = new ArrayList<>();

        for (Nurses nurse: nursesList) {
            if (HelperUtils.isNotNull(nurse)
            && nurse.getShift().equalsIgnoreCase(shiftToDisplay)) {
                nurse.displayInfo();
                result.add(nurse);
            }
        }
        return result;
    }

    public boolean handleNurseMenu(Integer nurseOption){

        switch (nurseOption) {
            case 1 -> {
                addNurses();
            }
            case 2 -> {
                String nId = InputHandler.getStringInput("Enter Nurse ID: ");
                editNurse(nId);
            }
            case 3 -> {
                String nId = InputHandler.getStringInput("Enter Nurse ID: ");
                removeNurse(nId);
            }
            case 4 -> {
                String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
                getNurseById(nurseId);
            }
            case 5 -> {
                displayAllNurses();
            }
            case 6 -> {
                String departmentId = InputHandler.getStringInput("Enter Department ID: ");
                getNurseByDepartment(departmentId);
            }
            case 7 -> {
                String shiftToDisplay = InputHandler.getStringInput("Enter shift: ");
                getNursesByShift(shiftToDisplay);
            }
            case 8 -> {
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
