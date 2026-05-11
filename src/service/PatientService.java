package service;

import Entites.Appointments;
import Entites.Billing;
import Entites.MedicalRecords;
import Entites.Patients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    //Static List to store all patients
     static List<Patients> patientsList = new ArrayList<>();
     List<MedicalRecords> medicalRecordsList = new ArrayList<>();
     List<Appointments> appointmentsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Patients addPatient(){

        System.out.println("Add new Patient ");

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

        System.out.println("Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.println("Blood Group: ");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter allergies separated by commas: ");
        String inputAllergies = scanner.nextLine();
        List<String> allergies = new ArrayList<>();
        for (String allergy: inputAllergies.split(",")) {
            allergies.add(allergy.trim());
        }

        System.out.println("Emergency Contact: ");
        String emergencyContact = scanner.nextLine();

        System.out.println("Registration Date");
        String registrationDate = scanner.nextLine();
        LocalDate rd = LocalDate.parse(dateOfBirth);

        System.out.println("Insurance Id: ");
        String insuranceId = scanner.nextLine();

        Patients patients1 = new Patients(civilId, firstName, lastName, dob, gender, phoneNumber, email, address, patientId, medicalRecordsList, appointmentsList, insuranceId, emergencyContact, rd, allergies, bloodGroup);

        return patients1;
    }

    public List<Patients> addPatients() {
        Boolean continueFlag = true;

        while (continueFlag) {
            patientsList.add(addPatient());
            System.out.println("Patient Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return patientsList;
    }

    public boolean editPatient() {

        System.out.println("Enter Patient ID: ");
        String pId = scanner.nextLine();

        for (Patients patient: patientsList){
            if (patient.getPatientId().equals(pId)){
                System.out.println("Enter Updated Civil ID: ");
                patient.setId(scanner.nextLine());

                System.out.println("Enter Updated First Name: ");
                patient.setFirstName(scanner.nextLine());

                System.out.println("Enter Updated Last Name: ");
                patient.setLastName(scanner.nextLine());

                System.out.println("Updated Date Of Birth: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate dob = LocalDate.parse(dateOfBirth);
                patient.setDateOfBirth(dob);

                System.out.println("Updated Gender: ");
                patient.setGender(scanner.nextLine());

                System.out.println("Updated Phone Number: ");
                patient.setPoneNumber(scanner.nextLine());

                System.out.println("Updated Email: ");
                patient.setEmail(scanner.nextLine());

                System.out.println("Updated Address: ");
                patient.setAddress(scanner.nextLine());

                System.out.println("Updated Blood Group: ");
                patient.setBloodGroup(scanner.nextLine());

                System.out.println("Enter Updated allergies separated by commas: ");
                String inputAllergies = scanner.nextLine();
                List<String> allergies = new ArrayList<>();
                for (String allergy: inputAllergies.split(",")) {
                    allergies.add(allergy.trim());
                }

                System.out.println("Updated Emergency Contact: ");
                patient.setEmergencyContact(scanner.nextLine());

                System.out.println("Updated Registration Date");
                String registrationDate = scanner.nextLine();
                LocalDate rd = LocalDate.parse(dateOfBirth);
                patient.setRegistrationDate(rd);

                System.out.println("Updated Insurance Id: ");
                patient.setInsuranceId(scanner.nextLine());

            }
            System.out.println("Patient updated successfully.");
            return true;
        }

        System.out.println("Patient not found.");
        return false;
    }

    public boolean removePatient() {
        System.out.println("Enter patient ID: ");
        String pId = scanner.nextLine();

        for (Patients patient: patientsList) {
            if (patient.getPatientId().equals(pId)) {
                patientsList.remove(patient);
                System.out.println("Patient removed successfully");
                return true;
            }
        }
        System.out.println("Patient not found");
        return false;
    }

    public Patients getPatientById() {
        System.out.println("Enter patient ID: ");
        String pId = scanner.nextLine();

        for (Patients patient: patientsList) {
            if (patient.getPatientId().equals(pId)) {
                patient.displayInfo();
                return patient;
            }
        }
        return null;
    }

    public void displayAllPatients() {
        if (patientsList.isEmpty()) {
            System.out.println("No Patient added");
            return;
        }

        for (Patients patient: patientsList) {
            patient.displayInfo();
        }
    }

    public void searchPatientsByName() {
        System.out.println("Enter patient Name: ");
        String name = scanner.nextLine();
        for (Patients patient: patientsList) {
            String fullname = patient.getFirstName() + patient.getLastName();

            if (fullname.toLowerCase().contains(name.toLowerCase())) {
                patient.displayInfo();
                return;
            }
        }
        System.out.println("Patient Not found");
    }

    public boolean handlePatientMenu(Integer patientOption){

        switch (patientOption) {
            case 1 -> {
                addPatients();
            }
            case 2 -> {
                editPatient();
            }
            case 3 -> {
                removePatient();
            }
            case 4 -> {
                getPatientById();
            }
            case 5 -> {
                displayAllPatients();
            }
            case 6 -> {
                searchPatientsByName();
            }
            case 7 -> {
                return false;
            }
        }
        return true;
    }
}
