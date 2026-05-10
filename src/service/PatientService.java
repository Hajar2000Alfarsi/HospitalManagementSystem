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
