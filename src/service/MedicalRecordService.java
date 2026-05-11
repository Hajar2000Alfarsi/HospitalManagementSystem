package service;

import Entites.MedicalRecords;
import Entites.Nurses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
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

    public boolean removeMedicalRecords(String recordId) {
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

    public List<MedicalRecords> getRecordsByPatientId(String patientId) {
        List<MedicalRecords> result = new ArrayList<>();

        for (MedicalRecords medicalRecord: medicalRecordsList) {
            if (medicalRecord.getPatientId().equals(patientId)){
                result.add(medicalRecord);
            }
        }
        return result;
    }

    public List<MedicalRecords> getRecordsByDoctorId(String doctorId){
        List<MedicalRecords> result =  new ArrayList<>();

        for (MedicalRecords medicalRecord: medicalRecordsList){
            if (medicalRecord.getDoctorId().equals(doctorId)){
                result.add(medicalRecord);
            }
        }
        return result;
    }

    public void displayPatientHistory(String patientId) {
        List<MedicalRecords> patientRecords = getRecordsByPatientId(patientId);

        for (MedicalRecords patientRecord: patientRecords) {
            patientRecord.displayInfo();
        }
    }

}
