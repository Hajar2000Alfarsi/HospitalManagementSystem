package service;

import Entites.Doctors;
import Entites.Nurses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService {
    static List<Nurses> nursesList = new ArrayList<>();
    List<String> assignedPatients =new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Nurses addNurse() {
        System.out.println("Add new Nurse ");

        System.out.println("Enter Civil ID: ");
        String civilId = scanner.nextLine();

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Date Of Birth: ");
        String dateOfBirth = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);

        System.out.println("Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Address: ");
        String address = scanner.nextLine();

        System.out.println("Nurse ID: ");
        String nurseId = scanner.nextLine();

        System.out.println("Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.println("Shift: ");
        String shift = scanner.nextLine();

        System.out.println("Qualification: ");
        String qualification = scanner.nextLine();

        Nurses nurses = new Nurses(civilId,firstName,lastName,dob,gender,phoneNumber,email,address,departmentId,nurseId,shift,qualification,assignedPatients);

        return nurses;
    }

    public List<Nurses> addNurses() {
        Boolean continueFlag = true;

        while (continueFlag) {
            nursesList.add(addNurse());
            System.out.println("Nurse Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return nursesList;
    }

    public boolean editNurse() {
        System.out.println("Enter Doctor ID: ");
        String nId = scanner.nextLine();

        for (Nurses nurse: nursesList){
            if (nurse.getNurseId().equals(nId)){
                System.out.println("Enter Updated Civil ID: ");
                nurse.setId(scanner.nextLine());

                System.out.println("Enter Updated First Name: ");
                nurse.setFirstName(scanner.nextLine());

                System.out.println("Enter Updated Last Name: ");
                nurse.setLastName(scanner.nextLine());

                System.out.println("Updated Date Of Birth: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate dob = LocalDate.parse(dateOfBirth);
                nurse.setDateOfBirth(dob);

                System.out.println("Updated Gender: ");
                nurse.setGender(scanner.nextLine());

                System.out.println("Updated Phone Number: ");
                nurse.setPoneNumber(scanner.nextLine());

                System.out.println("Updated Email: ");
                nurse.setEmail(scanner.nextLine());

                System.out.println("Updated Address: ");
                nurse.setAddress(scanner.nextLine());

                System.out.println("Department ID: ");
                nurse.setDepartmentId(scanner.nextLine());

                System.out.println("Shift: ");
                nurse.setShift(scanner.nextLine());

                System.out.println("Qualification: ");
                nurse.setQualification(scanner.nextLine());
            }
            System.out.println("Nurse updated successfully.");
            return true;
        }

        System.out.println("Nurse not found.");
        return false;
    }

    public boolean removeNurse() {
        System.out.println("Enter Nurse ID: ");
        String nId = scanner.nextLine();

        for (Nurses nurse: nursesList) {

            if (nurse.getNurseId().equals(nId)){

                nursesList.remove(nurse);
                System.out.println("Nurse removed successfully");
                return true;
            }
        }
        System.out.println("Nurse not found");
        return false;
    }

    public Nurses getNurseById() {
        System.out.println("Enter Nurse ID: ");
        String nId = scanner.nextLine();

        for (Nurses nurse: nursesList) {
            if (nurse.getNurseId().equals(nId)){
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

    public List<Nurses> getNurseByDepartment() {
        System.out.println("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        List<Nurses> result = new ArrayList<>();

        for (Nurses nurse: nursesList) {
            if (nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                nurse.displayInfo();
                result.add(nurse);
            }
        }
        return result;
    }

    public List<Nurses> getNursesByShift() {
        System.out.println("Enter shift: ");
        String shiftToDisplay = scanner.nextLine();

        List<Nurses> result = new ArrayList<>();

        for (Nurses nurse: nursesList) {
            if (nurse.getShift().equalsIgnoreCase(shiftToDisplay)) {
                nurse.displayInfo();
                result.add(nurse);
            }
        }
        return result;
    }

    public boolean handleDoctorMenu(Integer nurseOption){

        switch (nurseOption) {
            case 1 -> {
                addNurses();
            }
            case 2 -> {
                editNurse();
            }
            case 3 -> {
                removeNurse();
            }
            case 4 -> {
                getNurseById();
            }
            case 5 -> {
                displayAllNurses();
            }
            case 6 -> {
                getNurseByDepartment();
            }
            case 7 -> {
                getNursesByShift();
            }
            case 8 -> {
                return false;
            }
        }
        return true;
    }
}
