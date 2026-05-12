package service;

import Entites.Appointments;
import Entites.MedicalRecords;
import Entites.Patients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    List<Appointments> appointmentsList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Appointments addAppointment() {
        System.out.println("Add new Appointment ");

        System.out.println("Enter Appointment ID: ");
        String appointmentId = scanner.nextLine();

        System.out.println("Enter patient ID: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter doctor ID: ");
        String doctorId = scanner.nextLine();

        System.out.println("Appointment date: ");
        String appointmentDate = scanner.nextLine();
        LocalDate ad = LocalDate.parse(appointmentDate);

        System.out.println("Appointment time: ");
        String appointmentTime = scanner.nextLine();

        System.out.println("status: ");
        String status = scanner.nextLine();

        System.out.println("Reason: ");
        String reason = scanner.nextLine();

        System.out.println("Notes: ");
        String notes = scanner.nextLine();

        Appointments appointments = new Appointments(appointmentId,doctorId,patientId,ad,appointmentTime,status,reason,notes);
        return appointments;
    }

    public List<Appointments> addAppointments() {
        Boolean continueFlag = true;

        while (continueFlag) {
            appointmentsList.add(addAppointment());
            System.out.println("Appointment Added Successfully");

            System.out.println("Enter q to exit, press ENTER to continue for more patient");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return appointmentsList;
    }


    //Overload create appointment with minimal info
    public void createAppointment(String patientId, String doctorId, LocalDate date) {
        Appointments appointment = new Appointments();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setStatus("Scheduled");

        appointmentsList.add(appointment);

        System.out.println("Appointment created");
    }


    //Overload create appointment with minimal info with time
    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointments appointment = new Appointments();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        appointment.setStatus("Scheduled");

        appointmentsList.add(appointment);

        System.out.println("Appointment created");
    }


    //Overload create appointment using object
    public void createAppointment(Appointments appointment) {
        appointmentsList.add(appointment);

        System.out.println("Appointment created");
    }

    public boolean editAppointment() {

        System.out.println("Enter Appointment ID: ");
        String aId = scanner.nextLine();

        for (Appointments appointment: appointmentsList){
            if (appointment.getAppointmentId().equals(aId)){
                System.out.println("Enter Updated patient ID: ");
                appointment.setPatientId(scanner.nextLine());

                System.out.println("Enter Updated doctor ID: ");
                appointment.setDoctorId(scanner.nextLine());

                System.out.println("Updated Appointment date: ");
                String appointmentDate = scanner.nextLine();
                LocalDate ad = LocalDate.parse(appointmentDate);
                appointment.setAppointmentDate(ad);

                System.out.println("Updated appointment time: ");
                appointment.setAppointmentTime(scanner.nextLine());

                System.out.println("Updated status: ");
                appointment.setStatus(scanner.nextLine());

                System.out.println("Updated Reason: ");
                appointment.setReason(scanner.nextLine());

                System.out.println("Updated notes: ");
                appointment.setNotes(scanner.nextLine());

            }
            System.out.println("Appointment updated successfully.");
            return true;
        }

        System.out.println("Appointment not found.");
        return false;
    }

    public boolean removeAppointments() {
        System.out.println("Enter appointment ID: ");
        String aId = scanner.nextLine();

        for (Appointments appointment: appointmentsList) {
            if (appointment.getAppointmentId().equals(aId)) {
                appointmentsList.remove(appointment);
                System.out.println("Appointment removed successfully");
                return true;
            }
        }
        System.out.println("Appointment not found");
        return false;
    }

    public List<Appointments> getAppointmentsByPatientId() {
        System.out.println("Enter Patient ID: ");
        String pId = scanner.nextLine();

        List<Appointments> patientAppointment = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (appointment.getPatientId().equals(pId)){
                appointment.displayInfo();
                patientAppointment.add(appointment);
                return patientAppointment;
            }
        }
        return null;
    }


    public List<Appointments> getAppointmentsByDoctorId(){
        System.out.println("Enter Doctor ID: ");
        String dId = scanner.nextLine();

        List<Appointments> doctorAppointment =  new ArrayList<>();

        for (Appointments appointment: appointmentsList){
            if (appointment.getDoctorId().equals(dId)){
                appointment.displayInfo();
                doctorAppointment.add(appointment);
                return doctorAppointment;
            }
        }
        return null;
    }

    public List<Appointments> getRecordsByDate() {
        System.out.println("Enter appointment date: ");
        String dId = scanner.nextLine();

        List<Appointments> dateAppointment = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (appointment.getDoctorId().equals(dId)){
                appointment.displayInfo();
                dateAppointment.add(appointment);
                return dateAppointment;
            }
        }
        return null;
    }

    public void rescheduleAppointment(){
        System.out.println("Enter appointment ID: ");
        String aId = scanner.nextLine();

        for (Appointments appointment: appointmentsList){
            if (appointment.getAppointmentId().equals(aId)){
                System.out.println("Enter new Date: ");
                String appointmentDate = scanner.nextLine();
                LocalDate ad = LocalDate.parse(appointmentDate);
                appointment.setAppointmentDate(ad);

                System.out.println("Enter new time: ");
                appointment.setAppointmentTime(scanner.nextLine());
            }
        }
    }

    public void cancelAppointment() {
        System.out.println("Enter appointment ID: ");
        String aId = scanner.nextLine();

        for (Appointments appointment: appointmentsList){
            if (appointment.getAppointmentId().equals(aId)) {
                appointment.setStatus("Canceled");
            }
        }
    }

    public boolean handleAppointmentMenu(Integer appointmentOption){

        switch (appointmentOption) {
            case 1 -> {
                addAppointments();
            }
            case 2 -> {
                editAppointment();
            }
            case 3 -> {
                removeAppointments();
            }
            case 4 -> {
                getAppointmentsByPatientId();
            }
            case 5 -> {
                getAppointmentsByDoctorId();
            }
            case 6 -> {
                getRecordsByDate();
            }
            case 7 -> {
                rescheduleAppointment();
            }
            case 8 -> {
                cancelAppointment();
            }
            case 9 -> {
                System.out.println("Exit");
                return false;
            }
        }
        return true;
    }
}
