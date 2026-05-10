package service;

import Entites.Doctors;
import Entites.Nurses;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    private static List<Nurses> nursesList = new ArrayList<>();

    public void addNurse(Nurses nurses) {
        nursesList.add(nurses);
        System.out.println("Nurse Added Successfully");
    }

    public boolean editNurse(String nurseId, Nurses updateNurse) {
        for (int i = 0; i < nursesList.size(); i++) {
            if (nursesList.get(i).getNurseId().equals(nurseId)){
                nursesList.set(i, updateNurse);
                System.out.println("Nurse updated successfully.");
                return true;
            }
        }
        System.out.println("Nurse not found.");
        return false;
    }

    public boolean removeNurse(String nurseId) {
        for (Nurses nurse: nursesList) {
            if (nurse.getNurseId().equals(nurseId)) {
                nursesList.remove(nurse);
                System.out.println("Nurse removed successfully");
                return true;
            }
        }
        System.out.println("Nurse not found");
        return false;
    }

    public Nurses getNurseById(String nurseId) {
        for (Nurses nurse: nursesList) {
            if (nurse.getNurseId().equals(nurseId)) {
                return nurse;
            }
        }
        return null;
    }

    public void displayAllNurses() {
        for (Nurses nurses: nursesList) {
            nurses.displayInfo();
        }
    }

    public List<Nurses> getNurseByDepartment(String departmentId) {
        List<Nurses> result = new ArrayList<>();

        for (Nurses nurses: nursesList) {
            if (nurses.getDepartmentId().equals(departmentId)) {
                result.add(nurses);
            }
        }
        return result;
    }

    public List<Nurses> getNursesByShift(String shift) {
        List<Nurses> result = new ArrayList<>();

        for (Nurses nurse: nursesList) {
            if (nurse.getShift().equalsIgnoreCase(shift)) {
                result.add(nurse);
            }
        }
        return result;
    }

}
