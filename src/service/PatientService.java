package service;

import Entites.Appointments;
import Entites.MedicalRecords;
import Entites.Patients;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Manageable, Searchable {
    //Static List to store all patients
     static List<Patients> patientsList = new ArrayList<>();
     List<MedicalRecords> medicalRecordsList = new ArrayList<>();
     List<Appointments> appointmentsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Patients addPatient(){

        System.out.println("Add new Patient ");

        /*System.out.println("Patient ID: ");
        String patientId = scanner.nextLine();*/
        String patientId = HelperUtils.generateId("PAT");

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

       /* System.out.println("Gender: ");
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

       /* System.out.println("Blood Group: ");
        String bloodGroup = scanner.nextLine();*/
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");

        /*System.out.println("Enter allergies separated by commas: ");
        String inputAllergies = scanner.nextLine();*/
        String inputAllergies = InputHandler.getStringInput("Allergies: ");

        List<String> allergies = new ArrayList<>();
        for (String allergy: inputAllergies.split(",")) {
            allergies.add(allergy.trim());
        }

       /* System.out.println("Emergency Contact: ");
        String emergencyContact = scanner.nextLine();*/
        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");

        /*System.out.println("Registration Date");
        String registrationDate = scanner.nextLine();
        LocalDate rd = LocalDate.parse(registrationDate);*/
        LocalDate rd = InputHandler.getDateInput("Registration Date: ");

        /*System.out.println("Insurance Id: ");
        String insuranceId = scanner.nextLine();*/
        String insuranceId = InputHandler.getStringInput("Insurance Id: ");

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


    //addPatient(String firstName, String lastName, String phone) - minimal info
    public void addPatient(String firstName, String lastName, String phone){
        Patients patient = new Patients();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPoneNumber(phone);

        patientsList.add(patient);

        System.out.println("Patient added successfully.");
    }


    //addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) - with blood group
    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patients patient = new Patients();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);

        patientsList.add(patient);

        System.out.println("Patient added successfully.");
    }


    //addPatient(Patient patient) - full object
    public void addPatient(Patients patient) {
        patientsList.add(patient);

        System.out.println("Full patient object added.");
    }


    //searchPatients(String keyword) - search by any field
    public List<Patients> searchPatients(String keyword) {
        List<Patients> matchedPatient = new ArrayList<>();

        for (Patients patient: patientsList) {
            if (patient.getPatientId().toLowerCase().contains(keyword.toLowerCase())
            || patient.getFirstName().toLowerCase().contains(keyword.toLowerCase())
            || patient.getLastName().toLowerCase().contains(keyword.toLowerCase())
            || patient.getPoneNumber().toLowerCase().contains(keyword.toLowerCase())
            || patient.getBloodGroup().toLowerCase().contains(keyword.toLowerCase())
            || patient.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                matchedPatient.add(patient);
            }
        }
        return matchedPatient;
    }


    //searchPatients(String firstName, String lastName) - search by name
    public List<Patients> searchPatients(String firstName, String lastName) {
        List<Patients> matchedPatient = new ArrayList<>();

        for (Patients patient: patientsList) {
            if (patient.getFirstName().equalsIgnoreCase(firstName)
            && patient.getLastName().equalsIgnoreCase(lastName)) {
                matchedPatient.add(patient);
            }
        }
        return matchedPatient;
    }


    public boolean editPatient(String patientId) {
        for (Patients patient: patientsList){
            if (patient.getPatientId().equals(patientId)){
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

    public boolean removePatient(String patientId) {
        for (Patients patient: patientsList) {
            if (HelperUtils.isNotNull(patient.getPatientId())
             && patient.getPatientId().equals(patientId)) {
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
            if (HelperUtils.isNotNull(patient.getPatientId())
             && patient.getPatientId().equals(patientId)) {
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


    //displayPatients() - display all
    public void displayPatients() {
        displayAllPatients();
    }


    //displayPatients(String filter) - display filtered by criteria
    public void displayPatients(String filter) {
        if (filter == null || filter.isEmpty()) {
            System.out.println("Filter is empty.");
            return;
        }

        String search = filter.toLowerCase();
        boolean found = false;

        for (Patients patient: patientsList) {
            //If this value empty ignore and continue
            if (HelperUtils.isNull(patient)) continue;

            boolean matches = (patient.getPatientId().toLowerCase().contains(search)
                    || patient.getFirstName().toLowerCase().contains(search)
                    || patient.getLastName().toLowerCase().contains(search)
                    || patient.getPoneNumber().toLowerCase().contains(search)
                    || patient.getGender().toLowerCase().contains(search)
                    || patient.getEmail().toLowerCase().contains(search));

            if (matches) {
                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found for: " + filter);
        }

    }


    //displayPatients(int limit) - display limited number
    public void displayPatients(int limit) {
        if (limit <= 0) {
            System.out.println("Invalid limit value.");
            return;
        }

        int count = 0;

        for (Patients patient: patientsList) {
            if (HelperUtils.isNull(patient)) continue;

            patient.displayInfo();
            System.out.println("_______________________________");

            count++;

            if (count >= limit){
                break;
            }
        }
    }

    public void searchPatientsByName(String name) {
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
                System.out.println("Enter Patient ID: ");
                String pId = scanner.nextLine();
                editPatient(pId);
            }
            case 3 -> {
                System.out.println("Enter patient ID: ");
                String pId = scanner.nextLine();

                removePatient(pId);
            }
            case 4 -> {
                System.out.println("Enter patient ID: ");
                String pId = scanner.nextLine();

                getPatientById(pId);
            }
            case 5 -> {
                displayAllPatients();
            }
            case 6 -> {
                System.out.println("Enter patient Name: ");
                String name = scanner.nextLine();
                searchPatientsByName(name);
            }
            case 7 -> {
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
