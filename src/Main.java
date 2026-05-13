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
        DepartmentService departmentService = new DepartmentService(doctorService);


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
                        if (patientOption == 10) break;

                        patientService.handlePatientMenu(patientOption);
                    }
                }

                case 2 -> {
                    Boolean doctorMenuContinue = true;
                    while (doctorMenuContinue){
                        System.out.println(MenuMessages.DOCTOR_MENU_MESSAGE);

                        Integer doctorOption = scanner.nextInt();
                        if (doctorOption == 11) break;

                        doctorService.handleDoctorMenu(doctorOption);
                    }
                }

                case 3 -> {
                    Boolean nurseMenuContinue = true;
                    while (nurseMenuContinue){
                        System.out.println(MenuMessages.NURSE_MENU_MESSAGE);

                        Integer nurseOption = scanner.nextInt();
                        if (nurseOption == 8) break;

                        nurseService.handleNurseMenu(nurseOption);
                    }
                }

                case 4 -> {
                    Boolean AppointmentMenuContinue = true;
                    while (AppointmentMenuContinue){
                        System.out.println(MenuMessages.APPOINTMENT_MENU_MESSAGE);

                        Integer appointmentOption = scanner.nextInt();
                        if (appointmentOption == 10) break;

                        appointmentService.handleAppointmentMenu(appointmentOption);
                    }
                }

                case 5 -> {
                    Boolean MedicalRecordMenuContinue = true;
                    while (MedicalRecordMenuContinue){
                        System.out.println(MenuMessages.MEDICAL_RECORD_MENU_MESSAGE);

                        Integer medicalRecordOption = scanner.nextInt();
                        if (medicalRecordOption == 8) break;

                        medicalRecordService.handleMedicalRecordMenu(medicalRecordOption);
                    }
                }

                case 6 -> {
                    Boolean departmentMenuContinue = true;
                    while (departmentMenuContinue){
                        System.out.println(MenuMessages.Department_MENU_MESSAGE);

                        Integer departmentOption = scanner.nextInt();
                        if (departmentOption == 8) break;

                        departmentService.handleDepartmentMenu(departmentOption);
                    }
                }

                case 8 -> {
                    Boolean reportsStatisticsContinue = true;
                    while (reportsStatisticsContinue){
                        System.out.println(MenuMessages.REPORT_AND_STATICS_MENU_MESSAGE);

                        Integer reportsStatisticsOption = scanner.nextInt();
                        if (reportsStatisticsOption == 6) break;

                        departmentService.handleDepartmentMenu(reportsStatisticsOption);
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