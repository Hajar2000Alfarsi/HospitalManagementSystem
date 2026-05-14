package service;

import java.time.LocalDate;

public class ReportService {
    private AppointmentService appointmentService;
    private DoctorService doctorService;
    private DepartmentService departmentService;
    private MedicalRecordService medicalRecordService;

    public void dailyAppointmentsReport(LocalDate date){
        appointmentService.displayAppointments(date);
    }



}
