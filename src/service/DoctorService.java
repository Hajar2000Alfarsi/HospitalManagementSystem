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

public class DoctorService implements Manageable, Searchable {
        public static List<Doctors> doctorsList = new ArrayList<>();
        List<String> availableSlots = new ArrayList<>();
        List<String> assignedPatients = new ArrayList<>();

        PatientService patientService = new PatientService();
        //private DepartmentService departmentService = new DepartmentService();

        private DepartmentService departmentService;

        public DoctorService() {
            this.departmentService = departmentService;
        }

        public Doctors addDoctor() {
            System.out.println("Add new Doctor");

            System.out.println("Doctor ID: ");
            //String doctorId = scanner.nextLine();
            String doctorId = HelperUtils.generateId("Dr.");
            System.out.println("Assigned ID to Doctor: " + doctorId );

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

            /*System.out.println("Doctor specialization: ");
            String specialization = scanner.nextLine();*/
            String specialization = InputHandler.getStringInput("Specialization: ");

            /*System.out.println("Doctor qualification: ");
            String qualification = scanner.nextLine();*/
            String qualification = InputHandler.getStringInput("Qualification: ");

            /*System.out.println("Doctor experience Years: ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine();*/
            int experienceYears = InputHandler.getIntInput("Experience Years: ");

            /*System.out.println("Doctor department Id: ");
            String departmentId = scanner.nextLine();*/
            String departmentId = InputHandler.getStringInput("Department ID: ");

            /*System.out.println("Doctor consultation Fee: ");
            Double consultationFee = scanner.nextDouble();
            scanner.nextLine();*/
            double consultationFee = InputHandler.getDoubleInput("Consultation Fee: ");

            Doctors doctors = new Doctors(civilId, firstName, lastName, dob, gender, phoneNumber, email, address, doctorId, assignedPatients, availableSlots, consultationFee, departmentId, experienceYears, qualification, specialization);
            return doctors;
        }


    public void addSurgeon() {

        String civilId = InputHandler.getStringInput("Civil ID: ");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("DOB: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");

        String doctorId = HelperUtils.generateId("SUR");
        String departmentId = InputHandler.getStringInput("Department ID: ");

        double fee = InputHandler.getDoubleInput("Fee: ");
        int exp = InputHandler.getIntInput("Experience: ");

        String qualification = InputHandler.getStringInput("Qualification: ");
        String specialization = "Surgeon";

        Surgeon doctor =  new Surgeon(
                civilId, firstName, lastName, dob, gender,
                phone, email, address,
                doctorId,
                new ArrayList<>(),
                new ArrayList<>(),
                fee,
                departmentId,
                exp,
                qualification,
                specialization,
                0,
                new ArrayList<>(),
                true
        );
        doctorsList.add(doctor);
    }


    public void addConsultant() {

        String civilId = InputHandler.getStringInput("Civil ID: ");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("DOB: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");

        String doctorId = HelperUtils.generateId("CON");
        String departmentId = InputHandler.getStringInput("Department ID: ");

        double fee = InputHandler.getDoubleInput("Fee: ");
        int exp = InputHandler.getIntInput("Experience: ");

        String qualification = InputHandler.getStringInput("Qualification: ");

        Consultant doctor = new Consultant(
                civilId, firstName, lastName, dob, gender,
                phone, email, address,
                doctorId,
                new ArrayList<>(),
                new ArrayList<>(),
                fee,
                departmentId,
                exp,
                qualification,
                "Consultant",
                new ArrayList<>(),
                true,
                30
        );
        doctorsList.add(doctor);
    }


    public void addGeneralPractitioner() {

        String civilId = InputHandler.getStringInput("Civil ID: ");
        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");
        LocalDate dob = InputHandler.getDateInput("DOB: ");
        String gender = InputHandler.getStringInput("Gender: ");
        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");
        String address = InputHandler.getStringInput("Address: ");

        String doctorId = HelperUtils.generateId("GP");
        String departmentId = InputHandler.getStringInput("Department ID: ");

        double fee = InputHandler.getDoubleInput("Fee: ");
        int exp = InputHandler.getIntInput("Experience: ");

        String qualification = InputHandler.getStringInput("Qualification: ");

        GeneralPractitioner doctor = new GeneralPractitioner(
                civilId, firstName, lastName, dob, gender,
                phone, email, address,
                doctorId,
                new ArrayList<>(),
                new ArrayList<>(),
                fee,
                departmentId,
                exp,
                qualification,
                "GP",
                true,
                true,
                true
        );
        doctorsList.add(doctor);
    }

        public List<Doctors> addDoctors() {
            Boolean continueFlag = true;

            while (continueFlag) {
                doctorsList.add(addDoctor());
                System.out.println("Doctor Added Successfully");

                String input = InputHandler.getStringInput("Press ENTER to continue or type q to quit");

                if (input.equalsIgnoreCase("q")) {
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


        public boolean editDoctor(String doctorId) {
            for (Doctors doctor: doctorsList){
                if (HelperUtils.isNotNull(doctor.getDoctorId())
                && doctor.getDoctorId().equals(doctorId)){
                    doctor.setId(InputHandler.getStringInput("Enter Updated Civil ID: "));

                    doctor.setFirstName(InputHandler.getStringInput("Enter First Name: "));

                    doctor.setLastName(InputHandler.getStringInput("Enter Last Name: "));

                    LocalDate dob = InputHandler.getDateInput("Updated DOB: ");
                    doctor.setDateOfBirth(dob);

                    doctor.setGender(InputHandler.getStringInput("Gender: "));

                    doctor.setPoneNumber(InputHandler.getStringInput("Phone: "));

                    doctor.setEmail(InputHandler.getStringInput("Email: "));

                    doctor.setAddress(InputHandler.getStringInput("Address: "));

                    doctor.setSpecialization(InputHandler.getStringInput("Specialization: "));

                    doctor.setQualification(InputHandler.getStringInput("Qualification: "));

                    int experienceYears = InputHandler.getIntInput("Experience Years: ");
                    doctor.setExperienceYears(experienceYears);

                    String departmentId = InputHandler.getStringInput("Department ID: ");
                    doctor.setDepartmentId(departmentId);

                    double fee = InputHandler.getDoubleInput("Consultation Fee: ");
                    doctor.setConsultationFee(fee);

                    System.out.println("Doctor updated successfully.");
                    return true;
                }
            }

            System.out.println("Doctor not found.");
            return false;
        }

        public boolean removeDoctor(String doctorId){
            Doctors toRemove = null;

            for (Doctors doctor: doctorsList) {

                if (HelperUtils.isNotNull(doctor.getDoctorId())
                && doctor.getDoctorId().equals(doctorId)){
                    toRemove = doctor;
                    break;
                }
            }

            if (toRemove != null) {
                doctorsList.remove(toRemove);
                System.out.println("Doctor removed successfully");
                return true;
            }
            System.out.println("Doctor not found");
            return false;
        }


        public Doctors getDoctorById(String doctorId) {

            for (Doctors doctor: doctorsList) {
                if (HelperUtils.isNotNull(doctor.getDoctorId())
                && doctor.getDoctorId().equals(doctorId)){
                    doctor.displayInfo();
                    System.out.println("\n-------------------------------------------\n");
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
                System.out.println("\n-------------------------------------------\n");
            }
        }


        //Override displayDoctors()
        public void displayDoctors(){
            displayAllDoctors();
        }


        public List<Doctors> getDoctorsBySpecialization(String specialization) {
            List<Doctors> result = new ArrayList<>();

            for (Doctors doctor: doctorsList) {
                if (HelperUtils.isNotNull(doctor.getSpecialization())
                && doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                    doctor.displayInfo();
                    System.out.println("\n-------------------------------------------\n");
                    result.add(doctor);
                }
            }
            return result;
        }



        //Overload displayDoctors by specialization
        public void displayDoctors(String specialization){
            List<Doctors> doctorBySpecialization = getDoctorsBySpecialization(specialization);

            if (doctorBySpecialization.isEmpty()) {
                System.out.println("No doctors found.");
                return;
            }

            for (Doctors doctor: doctorBySpecialization) {
                doctor.displayInfo();
                System.out.println("\n-------------------------------------------\n");
            }
        }


        public List<Doctors> getAvailableDoctors() {
            List<Doctors> availableDoctors = new ArrayList<>();

            for (Doctors doctor: doctorsList) {
                if (HelperUtils.isNotNull(doctor.getAvailableSlots())) {
                    availableDoctors.add(doctor);
                }
            }

            for (Doctors d: availableDoctors){
                d.displayInfo();
                System.out.println("\n-------------------------------------------\n");
            }
            return availableDoctors;
        }

        //Display Doctor by departmentID
        public void displayDoctors(String departmentId, boolean showAvailableOnly){
            Departments departments = departmentService.getDepartmentById(departmentId);

            if (HelperUtils.isNotNull(departments)) {
                System.out.println("Department not found.");
                return;
            }

            List<Doctors> doctors = departments.getDoctors();

            if (HelperUtils.isNotNull(departments)) {
                System.out.println("No doctors in this department.");
                return;
            }

            boolean found = false;

            for (Doctors doctor: doctors) {
                if (HelperUtils.isNotNull(departments)) continue;

                boolean isAvailable = doctor.getAvailableSlots() != null
                        && !doctor.getAvailableSlots().isEmpty();

                //If not  doctor available continue
                if (showAvailableOnly && !isAvailable) {
                    continue;
                }

                doctor.displayInfo();
                System.out.println("\n-------------------------------------------\n");
                found = true;
            }

            if (!found) {
                System.out.println("No doctors match the criteria.");
            }
        }



        public boolean handleDoctorMenu(Integer doctorOption){

            switch (doctorOption) {
                case 1 -> {
                    addDoctors();
                }
                case 2 -> {
                    addSurgeon();
                }
                case 3 -> {
                    addConsultant();
                }
                case 4 -> {
                    addGeneralPractitioner();
                }
                case 5 -> {
                    displayAllDoctors();
                }
                case 6 -> {
                    String specialization = InputHandler.getStringInput("Specialization: ");
                    getDoctorsBySpecialization(specialization);
                }
                case 7 -> {
                    getAvailableDoctors();
                }
                case 8 -> {
                    String doctorId = InputHandler.getStringInput("Doctor ID: ");
                    String patientId = InputHandler.getStringInput("Patient ID: ");
                   assignPatient(doctorId, patientId);
                }
                case 9 -> {
                    String doctorId = InputHandler.getStringInput("Doctor ID: ");
                    editDoctor(doctorId);
                }
                case 10 -> {
                    String doctorId = InputHandler.getStringInput("Doctor ID: ");
                    removeDoctor(doctorId);
                }
                default -> System.out.println("Invalid option");
            }
            return true;
        }

        @Override
        public void add(Object entity) {
            Doctors doctor = (Doctors) entity;

            for (Doctors d: doctorsList) {
                if (d.getDoctorId() != null
                        && d.getDoctorId().equals(doctor.getDoctorId())) {
                    System.out.println("Doctor already exists!");
                    return;
                }
            }
            doctorsList.add(doctor);
            System.out.println("Doctor added successfully.");
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
