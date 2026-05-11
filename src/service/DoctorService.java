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

    public boolean editDoctor(String doctorId) {
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        for (Doctors doctor: doctorsList){
            if (doctor.getDoctorId().equals(dId)){
                System.out.println("Enter Updated Civil ID: ");
                doctor.setDoctorId(scanner.nextLine());

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

                System.out.println("Doctor department Id: ");
                doctor.setDoctorId(scanner.nextLine());

                System.out.println("Doctor consultation Fee: ");
                doctor.setConsultationFee(scanner.nextDouble());
            }
            System.out.println("Doctor updated successfully.");
            return true;
        }

        System.out.println("Doctor not found.");
        return false;
    }

    public boolean removeDoctor(String doctorId){
        System.out.println("Enter patient ID: ");
        String pId = scanner.nextLine();

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
