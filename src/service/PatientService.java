package service;

import Entites.Patients;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    //Static List to store all patients
    private static List<Patients> patientsList = new ArrayList<>();

    public void addPatient(Patients patients){
        patientsList.add(patients);
        System.out.println("Patient Added Successfully");
    }
}
