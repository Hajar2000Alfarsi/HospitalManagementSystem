package service;

import Entites.MedicalRecords;
import Entites.Nurses;
import Interface.Manageable;
import Interface.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {
    static List<MedicalRecords> medicalRecordsList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public MedicalRecords addMedicalRecord(){
        System.out.println("Add new Medical Record ");

        System.out.println("Enter record ID: ");
        String recordId = scanner.nextLine();

        System.out.println("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();

        System.out.println("Enter visit Date: ");
        String visitDate = scanner.nextLine();
        LocalDate vd = LocalDate.parse(visitDate);

        System.out.println("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter prescription: ");
        String prescription = scanner.nextLine();

        System.out.println("Enter test results: ");
        String testResults = scanner.nextLine();

        System.out.println("Enter notes: ");
        String notes = scanner.nextLine();

        MedicalRecords medicalRecords = new MedicalRecords(recordId,patientId,vd,doctorId,diagnosis,prescription,testResults,notes);

        return medicalRecords;
    }

    public List<MedicalRecords> addMedicalRecords() {
        Boolean continueFlag = true;

        while (continueFlag) {
            medicalRecordsList.add(addMedicalRecord());
            System.out.println("Record Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return medicalRecordsList;
    }


    public boolean editMedicalRecord() {
        System.out.println("Enter record ID: ");
        String rId = scanner.nextLine();

        for (MedicalRecords medicalRecord: medicalRecordsList){
            if (medicalRecord.getRecordId().equals(rId)){
                System.out.println("Enter Updated patient ID: ");
                medicalRecord.setPatientId(scanner.nextLine());

                System.out.println("Enter Updated doctor ID: ");
                medicalRecord.setDoctorId(scanner.nextLine());

                System.out.println("Updated visit date: ");
                String visitDate = scanner.nextLine();
                LocalDate vd = LocalDate.parse(visitDate);
                medicalRecord.setVisitDate(vd);

                System.out.println("Updated diagnosis: ");
                medicalRecord.setDiagnosis(scanner.nextLine());

                System.out.println("Updated prescription: ");
                medicalRecord.setPrescription(scanner.nextLine());

                System.out.println("Updated test result: ");
                medicalRecord.setTestResults(scanner.nextLine());

                System.out.println("Updated notes: ");
                medicalRecord.setNotes(scanner.nextLine());

            }
            System.out.println("Medical Record updated successfully.");
            return true;
        }

        System.out.println("Medical record not found.");
        return false;
    }

    public boolean removeMedicalRecords() {
        System.out.println("Enter record ID: ");
        String rId = scanner.nextLine();

        for (MedicalRecords medicalRecord: medicalRecordsList) {

            if (medicalRecord.getRecordId().equals(rId)){

                medicalRecordsList.remove(medicalRecord);
                System.out.println("Medical record removed successfully");
                return true;
            }
        }
        System.out.println("Medical record not found");
        return false;
    }

    public List<MedicalRecords> getRecordsByPatientId() {
        System.out.println("Enter Patient ID: ");
        String pId = scanner.nextLine();

        List<MedicalRecords> patientMedicalRecord = new ArrayList<>();

        for (MedicalRecords medicalRecords: medicalRecordsList) {
            if (medicalRecords.getPatientId().equals(pId)){
                medicalRecords.displayInfo();
                patientMedicalRecord.add(medicalRecords);
                return patientMedicalRecord;
            }
        }
        return null;
    }

    public List<MedicalRecords> getRecordsByDoctorId(){
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        List<MedicalRecords> doctorMedicalRecord =  new ArrayList<>();

        for (MedicalRecords medicalRecord: medicalRecordsList){
            if (medicalRecord.getDoctorId().equals(dId)){
                medicalRecord.displayInfo();
                doctorMedicalRecord.add(medicalRecord);
                return doctorMedicalRecord;
            }
        }
        return null;
    }

    public void displayPatientHistory() {
        System.out.println("Enter Patient ID: ");
        String pId = scanner.nextLine();

        for (MedicalRecords medicalRecords: medicalRecordsList) {

            if (medicalRecords.getPatientId().equals(pId)) {
                medicalRecords.displayInfo();
            }
        }
    }


    public boolean handleMedicalRecordMenu(Integer MedicalRecordOption){

        switch (MedicalRecordOption) {
            case 1 -> {
                addMedicalRecords();
            }
            case 2 -> {
                editMedicalRecord();
            }
            case 3 -> {
                removeMedicalRecords();
            }
            case 4 -> {
                getRecordsByPatientId();
            }
            case 5 -> {
                getRecordsByDoctorId();
            }
            case 6 -> {
                displayPatientHistory();
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
