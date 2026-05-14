package service;

import Entites.Appointments;
import Entites.MedicalRecords;
import Entites.Nurses;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {
    public static List<MedicalRecords> medicalRecordsList = new ArrayList<>();

    public MedicalRecords addMedicalRecord(){
        System.out.println("Add new Medical Record ");

        System.out.println("record ID: ");
        //String recordId = scanner.nextLine();
        String recordId = HelperUtils.generateId("MR");
        System.out.println("Assigned ID to Medical record: " + recordId );

        /*System.out.println("Enter Patient ID: ");
        String patientId = scanner.nextLine();*/
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");

        /*System.out.println("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();*/
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");


        /*System.out.println("Enter visit Date: ");
        String visitDate = scanner.nextLine();
        LocalDate vd = LocalDate.parse(visitDate);*/
        LocalDate vd = InputHandler.getDateInput("Enter visit Date: ");

        /*System.out.println("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();*/
        String diagnosis = InputHandler.getStringInput("Enter diagnosis: ");

        /*System.out.println("Enter prescription: ");
        String prescription = scanner.nextLine();*/
        String prescription = InputHandler.getStringInput("Enter prescription: ");

        /*System.out.println("Enter test results: ");
        String testResults = scanner.nextLine();*/
        String testResults = InputHandler.getStringInput("Enter test results: ");

        /*System.out.println("Enter notes: ");
        String notes = scanner.nextLine();*/
        String notes = InputHandler.getStringInput("Enter notes: ");

        MedicalRecords medicalRecords = new MedicalRecords(recordId,patientId,vd,doctorId,diagnosis,prescription,testResults,notes);

        return medicalRecords;
    }

    public List<MedicalRecords> addMedicalRecords() {
        Boolean continueFlag = true;

        while (continueFlag) {
            medicalRecordsList.add(addMedicalRecord());
            System.out.println("Record Added Successfully");

            String input = InputHandler.getStringInput("Enter q to exit, press ENTER to continue: ");

            if (input.equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return medicalRecordsList;
    }


    public boolean editMedicalRecord(String recordId) {
        for (MedicalRecords medicalRecord: medicalRecordsList){
            if (HelperUtils.isNotNull(medicalRecord.getRecordId())
            && medicalRecord.getRecordId().equals(recordId)){
                /*System.out.println("Enter Updated patient ID: ");
                medicalRecord.setPatientId(scanner.nextLine());*/
                medicalRecord.setPatientId(InputHandler.getStringInput("Enter Updated patient ID: "));

                /*System.out.println("Enter Updated doctor ID: ");
                medicalRecord.setDoctorId(scanner.nextLine());*/
                medicalRecord.setDoctorId(InputHandler.getStringInput("Enter Updated doctor ID: "));

                /*System.out.println("Updated visit date: ");
                String visitDate = scanner.nextLine();
                LocalDate vd = LocalDate.parse(visitDate);*/
                LocalDate vd = InputHandler.getDateInput("Updated visit date: ");
                medicalRecord.setVisitDate(vd);

                /*System.out.println("Updated diagnosis: ");
                medicalRecord.setDiagnosis(scanner.nextLine());*/
                medicalRecord.setDiagnosis(InputHandler.getStringInput("Updated diagnosis: "));


                /*System.out.println("Updated prescription: ");
                medicalRecord.setPrescription(scanner.nextLine());*/
                medicalRecord.setPrescription(InputHandler.getStringInput("Updated prescription: "));


                /*System.out.println("Updated test result: ");
                medicalRecord.setTestResults(scanner.nextLine());*/
                medicalRecord.setTestResults(InputHandler.getStringInput("Updated test result: "));

                medicalRecord.setNotes(InputHandler.getStringInput("Updated notes: "));

            }
            System.out.println("Medical Record updated successfully.");
            return true;
        }

        System.out.println("Medical record not found.");
        return false;
    }

    public boolean removeMedicalRecords(String recordId) {
        for (MedicalRecords medicalRecord: medicalRecordsList) {

            if (HelperUtils.isNotNull(medicalRecord.getRecordId())
            && medicalRecord.getRecordId().equals(recordId)){

                medicalRecordsList.remove(medicalRecord);
                System.out.println("Medical record removed successfully");
                return true;
            }
        }
        System.out.println("Medical record not found");
        return false;
    }

    public void displayAllRecords(){
        if (HelperUtils.isNull(medicalRecordsList)) {
            System.out.println("No medical record available");
            return;
        }

        for (MedicalRecords medicalRecord: medicalRecordsList) {
            medicalRecord.displayInfo();
        }
    }


    public List<MedicalRecords> getRecordsByPatientId(String patientId) {
        List<MedicalRecords> patientMedicalRecord = new ArrayList<>();

        for (MedicalRecords medicalRecords: medicalRecordsList) {
            if (HelperUtils.isNotNull(medicalRecords.getPatientId())
            &&medicalRecords.getPatientId().equals(patientId)){
                medicalRecords.displayInfo();
                System.out.println("\n-------------------------------------------\n");
                patientMedicalRecord.add(medicalRecords);
            }
        }
        return patientMedicalRecord;
    }

    public List<MedicalRecords> getRecordsByDoctorId(String doctorId){
        List<MedicalRecords> doctorMedicalRecord =  new ArrayList<>();

        for (MedicalRecords medicalRecord: medicalRecordsList){
            if (HelperUtils.isNotNull(medicalRecord.getDoctorId())
            && medicalRecord.getDoctorId().equals(doctorId)){
                medicalRecord.displayInfo();
                System.out.println("\n-------------------------------------------\n");
                doctorMedicalRecord.add(medicalRecord);

            }
        }
        return doctorMedicalRecord;
    }

    public void displayPatientHistory(String patientId) {
        for (MedicalRecords medicalRecords: medicalRecordsList) {

            if (HelperUtils.isNotNull(medicalRecords.getRecordId())
                  &&  medicalRecords.getPatientId().equals(patientId)) {
                medicalRecords.displayInfo();
                System.out.println("\n-------------------------------------------\n");
            }
        }
    }


    public boolean handleMedicalRecordMenu(Integer MedicalRecordOption){

        switch (MedicalRecordOption) {
            case 1 -> {
                addMedicalRecords();
            }
            case 2 -> {
                displayAllRecords();
            }
            case 3 -> {
                String patientId = InputHandler.getStringInput("Patient ID: ");
                getRecordsByPatientId(patientId);
            }
            case 4 -> {
                String doctorId = InputHandler.getStringInput("Doctor ID: ");
                getRecordsByDoctorId(doctorId);
            }
            case 5 -> {
                String recordId = InputHandler.getStringInput("Record ID: ");
                editMedicalRecord(recordId);
            }
            case 6 -> {
                String recordId = InputHandler.getStringInput("Record ID: ");
                removeMedicalRecords(recordId);
            }
            case 7 -> {
                String patientId = InputHandler.getStringInput("Patient ID: ");
                displayPatientHistory(patientId);
            }
            default -> System.out.println("Invalid option");
        }
        return true;
    }

    @Override
    public void add(Object entity) {
        MedicalRecords medicalRecord = (MedicalRecords) entity;

        for (MedicalRecords r: medicalRecordsList) {
            if (r.getRecordId() != null
                    && r.getRecordId().equals(medicalRecord.getRecordId())) {
                System.out.println("Record already exists!");
                return;
            }
        }
        medicalRecordsList.add(medicalRecord);
        System.out.println("Record added successfully.");
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
