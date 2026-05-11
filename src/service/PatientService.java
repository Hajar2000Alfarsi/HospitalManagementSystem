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

            System.out.println("Enter q to exit, press ENTER to continue for more doctors");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return patientsList;
    }

    public boolean editPatient(String patientId, Patients updatedPatient) {
        for (int i = 0; i < patientsList.size(); i++){
            if (patientsList.get(i).getPatientId().equals(patientId)) {
                patientsList.set(i,updatedPatient);

                System.out.println("Patient updated successfully.");
                return true;
            }
        }
        System.out.println("Patient not found.");
        return false;
    }

    public boolean removePatient(String patientId) {
        for (Patients patient: patientsList) {
            if (patient.getPatientId().equals(patientId)) {
                patientsList.remove(patient);
                System.out.println("Patient removed successfully");
                return true;
            }
        }
        System.out.println("Patient not found");
        return false;
    }

    public Patients getPatientById(String patientId) {
        for (Patients patient: patientsList) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }

    public void displayAllPatients() {
        if (patientsList == null) {
            return;
        }

        for (Patients patient: patientsList) {
            patient.displayInfo();
        }
    }

    public List<Patients> searchPatientsByName(String name) {
        List<Patients> result = new ArrayList<>();

        for (Patients patient: patientsList) {
            String fullname = patient.getFirstName() + patient.getLastName();

            if (fullname.toLowerCase().contains(name.toLowerCase())) {
                result.add(patient);
            }
        }
        return result;
    }
}
