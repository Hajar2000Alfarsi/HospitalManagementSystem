import Entites.MedicalRecords;
import Entites.Nurses;
import Utils.MenuMessages;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        AppointmentService appointmentService = new AppointmentService();

        Scanner scanner = new Scanner(System.in);

        Boolean continueFlag = true;

        while (continueFlag) {
            System.out.println(MenuMessages.MAIN_MENU_MESSAGE);
            Integer option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    Boolean patientMenuContinue = true;
                    while (patientMenuContinue){
                        System.out.println(MenuMessages.PATIENT_MENU_MESSAGE);
                        Integer patientOption = scanner.nextInt();

                        patientService.handlePatientMenu(patientOption);
                    }
                }

                case 2 -> {
                    Boolean doctorMenuContinue = true;
                    while (doctorMenuContinue){
                        System.out.println(MenuMessages.DOCTOR_MENU_MESSAGE);
                        Integer doctorOption = scanner.nextInt();

                        doctorService.handleDoctorMenu(doctorOption);
                    }
                }

                case 3 -> {
                    Boolean nurseMenuContinue = true;
                    while (nurseMenuContinue){
                        System.out.println(MenuMessages.NURSE_MENU_MESSAGE);
                        Integer nurseOption = scanner.nextInt();

                        nurseService.handleNurseMenu(nurseOption);
                    }
                }

                case 4 -> {
                    Boolean MedicalRecordMenuContinue = true;
                    while (MedicalRecordMenuContinue){
                        System.out.println(MenuMessages.MEDICAL_RECORD_MENU_MESSAGE);
                        Integer medicalRecordOption = scanner.nextInt();

                        medicalRecordService.handleMedicalRecordMenu(medicalRecordOption);
                    }
                }

                case 5 -> {
                    Boolean AppointmentMenuContinue = true;
                    while (AppointmentMenuContinue){
                        System.out.println(MenuMessages.APPOINTMENT_MENU_MESSAGE);
                        Integer appointmentOption = scanner.nextInt();

                        appointmentService.handleAppointmentMenu(appointmentOption);
                    }
                }

                case 8 -> {
                    System.out.println("Exit");
                    continueFlag = false;
                }
                default -> System.out.println("Select a choice from the list");
            }
        }

    }
}