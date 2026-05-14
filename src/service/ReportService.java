package service;

import Entites.Departments;

import java.time.LocalDate;

public class ReportService {
    private AppointmentService appointmentService;
    private DoctorService doctorService;
    private DepartmentService departmentService;
    private MedicalRecordService medicalRecordService;

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

    }




}
