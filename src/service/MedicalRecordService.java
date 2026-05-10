package service;

import Entites.MedicalRecords;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService {
    public static List<MedicalRecords> medicalRecordsList = new ArrayList<>();

    public void addMedicalRecords(MedicalRecords records){
        medicalRecordsList.add(records);
        System.out.println("Medical Records Added Successfully");
    }

    public boolean removeMedicalRecords(String recordId) {
        for (MedicalRecords medicalRecord: medicalRecordsList) {
            if (medicalRecord.getRecordId().equals(recordId)){
                medicalRecordsList.remove(recordId);
                System.out.println("Medical Record removed successfully");
                return true;
            }
        }
        return false;
    }
}
