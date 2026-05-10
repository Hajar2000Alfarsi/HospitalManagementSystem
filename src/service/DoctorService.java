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
}
