package service;

import Entites.Departments;
import Entites.EmergencyPatient;
import Entites.Patients;
import Utils.InputHandler;

import java.time.LocalDate;

public class ReportService {
    private AppointmentService appointmentService;
    private DoctorService doctorService;
    private DepartmentService departmentService;
    private MedicalRecordService medicalRecordService;
    private PatientService patientService;

    public void dailyAppointmentsReport(LocalDate date){
        appointmentService.displayAppointments(date);
    }

    public void doctorPerformanceReport(String doctorId) {
        System.out.println("--------Doctor Performance Report---------");

        int appointments = appointmentService.getAppointmentsByDoctorId(doctorId).size();
        int records = medicalRecordService.getRecordsByDoctorId(doctorId).size();

        System.out.println("Toatal Appointment: " + appointments);
        System.out.println("Medical Records: " +records);
    }

    public void departmentOccupancyReport(String departmentId){
        Departments department = departmentService.getDepartmentById(departmentId);

        System.out.println("------Department Occupancy Report-------------");

        System.out.println("Department: " + department.getDepartmentName());
        System.out.println("Doctors: " + department.getDoctors().size());
        System.out.println("Nurses: " + department.getNurses().size());
        System.out.println("Available beds: " + department.getAvailableBeds());
    }

    public void patientStatistics(String patientId) {
        int appointments = appointmentService.getAppointmentsByPatientId(patientId).size();
        int records = medicalRecordService.getRecordsByPatientId(patientId).size();

        System.out.println("---------Patient Statistics-------------  ");
        System.out.println("Appointments: " + appointments);
        System.out.println("Medical Records: " + records);
    }

    public void emergencyCasesReport(){
        System.out.println("-----Emergency Cases Report-------");

        boolean found = false;

        for (Patients patient : patientService.patientsList) {
            if (patient instanceof EmergencyPatient){
                EmergencyPatient emergencyPatient = (EmergencyPatient) patient;

                emergencyPatient.displayInfo();

                found = true;
            }
        }
        if (!found){
            System.out.println("No emergency cases found");
        }
    }

    public boolean handleReportMenu(Integer reportOption) {

        switch (reportOption) {
            case 1 -> {
                LocalDate date = InputHandler.getDateInput("Eneter date: ");
                dailyAppointmentsReport(date);
            }
            case 2 -> {
                String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
                doctorPerformanceReport(doctorId);
            }
            case 3 -> {
                String departmentId = InputHandler.getStringInput("Enter Department name:");
                departmentOccupancyReport(departmentId);
            }
            case 4 -> {
                String patientId = InputHandler.getStringInput("Enter Patient ID: ");
                patientStatistics(patientId);
            }
            case 5 -> {
                emergencyCasesReport();
            }
            default -> System.out.println("Invalid option");
        }
        return true;
    }

}
