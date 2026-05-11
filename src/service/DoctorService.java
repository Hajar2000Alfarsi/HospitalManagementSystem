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
    Scanner scanner = new Scanner();

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

        System.out.println("Doctor department Id: ");
        String departmentId = scanner.nextLine();

        System.out.println("Doctor consultation Fee: ");
        Double consultationFee = scanner.nextDouble();

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

    public boolean editDoctor(String doctorId, Doctors updatedDoctor) {
        for (int i = 0; i < doctorsList.size(); i++) {
            if (doctorsList.get(i).getDoctorId().equals(doctorId)) {
                doctorsList.set(i, updatedDoctor);

                System.out.println("Doctor updated successfully.");
                return true;
            }
        }
        System.out.println("Doctor not found.");
        return false;
    }

    public boolean removeDoctor(String doctorId){
        for (Doctors doctors: doctorsList) {

            if (doctors.getDoctorId().equals(doctorId)){

                doctorsList.remove(doctorId);
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
                return doctor;
            }
        }
        return null;
    }

    public void displayAllDoctors() {
        for (Doctors doctor: doctorsList) {
            doctor.displayInfo();
        }
    }

    public List<Doctors> getDoctorsBySpecialization(String specialization) {
        List<Doctors> result = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (doctor.getSpecialization() .equalsIgnoreCase(specialization)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public List<Doctors> getAvailableDoctors() {
        List<Doctors> availableDoctors = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (!doctor.getAvailableSlots().isEmpty()){
                availableDoctors.add(doctor);
            }
        }
        return availableDoctors;
    }
}
