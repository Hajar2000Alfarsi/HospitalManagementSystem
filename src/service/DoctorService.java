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
    PatientService patientService = new PatientService();

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


    //overload addDoctor(String name, String specialization, String phone)
    public void addDoctor(String name, String specialization, String phone) {
        Doctors doctor = new Doctors();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPoneNumber(phone);

        doctorsList.add(doctor);

        System.out.println("Doctor added (basic info)");
    }


    // overload addDoctor(String name, String specialization, String phone, double consultationFee)
    public void addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctors doctor = new Doctors();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctorsList.add(doctor);

        System.out.println("Doctor added with fee");
    }

    //addDoctor(Doctor doctor) full object
    public void addDoctor(Doctors doctor){
        doctorsList.add(doctor);

        System.out.println("Doctor object added");
    }


    //overload assignPatient by ID's
    public void assignPatient(String doctorId, String patientId) {
        Doctors doctor = getDoctorById(doctorId);
        Patients patient = patientService.getPatientById(patientId);

        if (doctor != null && patient != null) {
            doctor.getAssignedPatients().add(patientId);
            System.out.println("Patient assigned");
        }
    }


    //overload assignPatient by object
    public void assignPatient(Doctors doctor, Patients patient){
        //If user write empty value
        if (doctor == null || patient == null) return;

        doctor.getAssignedPatients().add(patient.getPatientId());
        System.out.println("Patient assigned");
    }


    //overload assignPatient by bulk assignment
    public void assignPatient(String doctorId, List<String> patientIds){
        Doctors doctor = getDoctorById(doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found");
            return;
        }

        for (String patientId:patientIds) {
            Patients patient = patientService.getPatientById(patientId);

            if (patient != null) {
                doctor.getAssignedPatients().add(patientId);
            } else {
                System.out.println("Patient not found: " + patientId);
            }
        }
        System.out.println("Bulk assignment completed");
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

    public Doctors getDoctorById(String doctorId) {

        for (Doctors doctor: doctorsList) {
            if (doctor.getDoctorId().equals(doctorId)){
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
                System.out.println("Enter Doctor ID: ");
                String dId = scanner.nextLine();
                getDoctorById(dId);
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
