import Utils.MenuMessages;
import service.DoctorService;
import service.PatientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
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
                case 8 -> {
                    System.out.println("Exit");
                    continueFlag = false;
                }
                default -> System.out.println("Select a choice from the list");
            }
        }

    }
}