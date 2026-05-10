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

}
