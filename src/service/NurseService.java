package service;

import Entites.Nurses;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    private static List<Nurses> nursesList = new ArrayList<>();

    public void addNurse(Nurses nurses) {
        nursesList.add(nurses);
        System.out.println("Nurse Added Successfully");
    }
}
