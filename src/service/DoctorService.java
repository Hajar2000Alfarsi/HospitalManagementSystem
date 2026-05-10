package service;

import Entites.Doctors;
import Entites.Patients;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private static List<Doctors> doctorsList = new ArrayList<>();

    public void addDoctor(Doctors doctor) {
        doctorsList.add(doctor);
        System.out.println("Doctor Added Successfully");
    }

    public boolean editDoctor(String doctorId, Doctors updatedDoctor) {
        for (int i = 0; i < doctorsList.size(); i++) {
            if (doctorsList.get(i).getDoctorId().equals(doctorId)) {
                doctorsList.set(i, updatedDoctor);

                System.out.println("Doctor updated successfully.");
                return true;
            }
        }
        return false;
    }

    public boolean removeDoctor(String doctorId){
        for (Doctors doctors: doctorsList) {

            if (doctors.getDoctorId().equals(doctorId)){

                doctorsList.remove(doctorId);
                System.out.println("Doctor removed successfully");
                return true;
            }
        }
        System.out.println("Doctor not found");
        return false;
    }

    public Doctors getDoctorById(String doctorId) {
        for (Doctors doctor: doctorsList) {
            if (doctor.getDoctorId().equals(doctorId)){
                return doctor;
            }
        }
        return null;
    }

    public void displayAllDoctors() {
        for (Doctors doctor: doctorsList) {
            doctor.displayInfo();
        }
    }

    public List<Doctors> getDoctorsBySpecialization(String specialization) {
        List<Doctors> result = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (doctor.getSpecialization() .equalsIgnoreCase(specialization)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public List<Doctors> getAvailableDoctors() {
        List<Doctors> availableDoctors = new ArrayList<>();

        for (Doctors doctor: doctorsList) {
            if (!doctor.getAvailableSlots().isEmpty()){
                availableDoctors.add(doctor);
            }
        }
        return availableDoctors;
    }
}
