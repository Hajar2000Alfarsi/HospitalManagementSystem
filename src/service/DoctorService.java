package service;

import Entites.Doctors;
import Entites.Patients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static List<Doctors> doctorsList = new ArrayList<>();
    List<String> availableSlots = new ArrayList<>();
    List<String> assignedPatients = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Doctors addDoctor() {
        System.out.println("Add new Doctor");

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

        System.out.println("Doctor ID: ");
        String doctorId = scanner.nextLine();

        System.out.println("Doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Doctor qualification: ");
        String qualification = scanner.nextLine();

        System.out.println("Doctor experience Years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Doctor department Id: ");
        String departmentId = scanner.nextLine();

        System.out.println("Doctor consultation Fee: ");
        Double consultationFee = scanner.nextDouble();
        scanner.nextLine();

        Doctors doctors = new Doctors(civilId, firstName, lastName, dob, gender, phoneNumber, email, address, doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
        return doctors;
    }

    public List<Doctors> addDoctors() {
        Boolean continueFlag = true;

        while (continueFlag) {
            doctorsList.add(addDoctor());
            System.out.println("Doctor Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return doctorsList;
    }

    public boolean editDoctor() {
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        for (Doctors doctor: doctorsList){
            if (doctor.getDoctorId().equals(dId)){
                System.out.println("Enter Updated Civil ID: ");
                doctor.setId(scanner.nextLine());

                System.out.println("Enter Updated First Name: ");
                doctor.setFirstName(scanner.nextLine());

                System.out.println("Enter Updated Last Name: ");
                doctor.setLastName(scanner.nextLine());

                System.out.println("Updated Date Of Birth: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate dob = LocalDate.parse(dateOfBirth);
                doctor.setDateOfBirth(dob);

                System.out.println("Updated Gender: ");
                doctor.setGender(scanner.nextLine());

                System.out.println("Updated Phone Number: ");
                doctor.setPoneNumber(scanner.nextLine());

                System.out.println("Updated Email: ");
                doctor.setEmail(scanner.nextLine());

                System.out.println("Updated Address: ");
                doctor.setAddress(scanner.nextLine());

                System.out.println("Doctor specialization: ");
                doctor.setSpecialization(scanner.nextLine());

                System.out.println("Doctor qualification: ");
                doctor.setQualification(scanner.nextLine());

                System.out.println("Doctor experience Years: ");
                doctor.setExperienceYears(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Doctor department Id: ");
                doctor.setDoctorId(scanner.nextLine());

                System.out.println("Doctor consultation Fee: ");
                doctor.setConsultationFee(scanner.nextDouble());
                scanner.nextLine();
            }
            System.out.println("Doctor updated successfully.");
            return true;
        }

        System.out.println("Doctor not found.");
        return false;
    }

    public boolean removeDoctor(){
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        for (Doctors doctors: doctorsList) {

            if (doctors.getDoctorId().equals(dId)){

                doctorsList.remove(doctors);
                System.out.println("Doctor removed successfully");
                return true;
            }
        }
        System.out.println("Doctor not found");
        return false;
    }

    public Doctors getDoctorById() {
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        for (Doctors doctor: doctorsList) {
            if (doctor.getDoctorId().equals(dId)){
                doctor.displayInfo();
                return doctor;
            }
        }
        return null;
    }

    public void displayAllDoctors() {
        if (doctorsList.isEmpty()) {
            System.out.println("No Doctor added");
            return;
        }

        for (Doctors doctor: doctorsList) {
            doctor.displayInfo();
            System.out.println("\n");
        }
    }

    public List<Doctors> getDoctorsBySpecialization() {
        System.out.println("Enter specialization: ");
        String specialization = scanner.nextLine();

        List<Doctors> result = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (doctor.getSpecialization() .equalsIgnoreCase(specialization)) {
                doctor.displayInfo();
                result.add(doctor);
            }
        }
        return result;
    }

    public List<Doctors> getAvailableDoctors() {
        List<Doctors> availableDoctors = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (!doctor.getAvailableSlots().isEmpty()){
                doctor.displayInfo();
                availableDoctors.add(doctor);
            }
        }
        return availableDoctors;
    }

    public boolean handleDoctorMenu(Integer doctorOption){

        switch (doctorOption) {
            case 1 -> {
                addDoctors();
            }
            case 2 -> {
                editDoctor();
            }
            case 3 -> {
                removeDoctor();
            }
            case 4 -> {
                getDoctorById();
            }
            case 5 -> {
                displayAllDoctors();
            }
            case 6 -> {
                getDoctorsBySpecialization();
            }
            case 7 -> {
                getAvailableDoctors();
            }
            case 8 -> {
                return false;
            }
        }
        return true;
    }
}
