package service;

import Entites.Appointments;
import Entites.Departments;
import Entites.MedicalRecords;
import Entites.Patients;
import Interface.Appointable;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppointmentService implements Manageable, Searchable, Appointable {
    List<Appointments> appointmentsList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Appointments addAppointment() {
        System.out.println("Add new Appointment ");

        //String appointmentId = scanner.nextLine();
        String appointmentId = HelperUtils.generateId("APP");
        System.out.println("Assigned ID to Appointment: " + appointmentId );

        /*System.out.println("Enter patient ID: ");
        String patientId = scanner.nextLine();*/
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");

        /*System.out.println("Enter doctor ID: ");
        String doctorId = scanner.nextLine();*/
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");


        /*System.out.println("Appointment date: ");
        String appointmentDate = scanner.nextLine();
        LocalDate ad = LocalDate.parse(appointmentDate);*/
        LocalDate ad = InputHandler.getDateInput("Appointment Date: ");

        /*System.out.println("Appointment time: ");
        String appointmentTime = scanner.nextLine();*/
        String appointmentTime = InputHandler.getStringInput("Appointment Time: ");

        /*System.out.println("status: ");
        String status = scanner.nextLine();*/
        String status = InputHandler.getStringInput("Status: ");

        /*System.out.println("Reason: ");
        String reason = scanner.nextLine();*/
        String reason = InputHandler.getStringInput("Reason: ");

        /*System.out.println("Notes: ");
        String notes = scanner.nextLine();*/
        String notes = InputHandler.getStringInput("Notes: ");

        Appointments appointments = new Appointments(appointmentId,doctorId,patientId,ad,appointmentTime,status,reason,notes);
        return appointments;
    }

    public List<Appointments> addAppointments() {
        Boolean continueFlag = true;

        while (continueFlag) {
            appointmentsList.add(addAppointment());
            System.out.println("Appointment Added Successfully");

            String input = InputHandler.getStringInput("Enter q to exit, press ENTER to continue: ");

            if (input.equalsIgnoreCase("q")) {
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

    public boolean editAppointment(String appointmentId) {

        for (Appointments appointment: appointmentsList){
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
            && appointment.getAppointmentId().equals(appointmentId)){
                /*System.out.println("Enter Updated patient ID: ");
                appointment.setPatientId(scanner.nextLine());*/
                appointment.setPatientId(InputHandler.getStringInput("Enter Updated Patient ID: "));

                /*System.out.println("Enter Updated doctor ID: ");
                appointment.setDoctorId(scanner.nextLine());*/
                appointment.setDoctorId(InputHandler.getStringInput("Enter Updated Doctor ID: "));

                /*System.out.println("Updated Appointment date: ");
                String appointmentDate = scanner.nextLine();
                LocalDate ad = LocalDate.parse(appointmentDate);
                appointment.setAppointmentDate(ad);*/
                LocalDate ad = InputHandler.getDateInput("Updated Appointment Date: ");
                appointment.setAppointmentDate(ad);

                /*System.out.println("Updated appointment time: ");
                appointment.setAppointmentTime(scanner.nextLine());*/
                appointment.setAppointmentTime(InputHandler.getStringInput("Updated Appointment Time: "));

                /*System.out.println("Updated status: ");
                appointment.setStatus(scanner.nextLine());*/
                appointment.setStatus(InputHandler.getStringInput("Updated Status: "));

                /*System.out.println("Updated Reason: ");
                appointment.setReason(scanner.nextLine());*/
                appointment.setReason(InputHandler.getStringInput("Updated Reason: "));

               /* System.out.println("Updated notes: ");
                appointment.setNotes(scanner.nextLine());*/
                appointment.setNotes(InputHandler.getStringInput("Updated Notes: "));

            }
            System.out.println("Appointment updated successfully.");
            return true;
        }

        System.out.println("Appointment not found.");
        return false;
    }

    public boolean removeAppointments(String appointmentId) {

        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentId().equals(appointmentId)) {
                appointmentsList.remove(appointment);
                System.out.println("Appointment removed successfully");
                return true;
            }
        }
        System.out.println("Appointment not found");
        return false;
    }

    public List<Appointments> getAppointmentsByPatientId(String patientID) {

        List<Appointments> patientAppointment = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNotNull(appointment.getPatientId())
                    && appointment.getPatientId().equals(patientID)){
                appointment.displayInfo();
                patientAppointment.add(appointment);
                return patientAppointment;
            }
        }
        return null;
    }


    public List<Appointments> getAppointmentsByDoctorId(String doctorId){

        List<Appointments> doctorAppointment =  new ArrayList<>();

        for (Appointments appointment: appointmentsList){
            if (HelperUtils.isNotNull(appointment.getDoctorId())
                    && appointment.getDoctorId().equals(doctorId)){
                appointment.displayInfo();
                doctorAppointment.add(appointment);
                return doctorAppointment;
            }
        }
        return null;
    }

    public List<Appointments> getRecordsByDate(LocalDate date) {

        List<Appointments> dateAppointment = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentDate().equals(date)){
                appointment.displayInfo();
                dateAppointment.add(appointment);
                return dateAppointment;
            }
        }
        return null;
    }

    public void rescheduleAppointment(String appointmentId){

        for (Appointments appointment: appointmentsList){
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentId().equals(appointmentId)){
               /* System.out.println("Enter new Date: ");
                String appointmentDate = scanner.nextLine();
                LocalDate ad = LocalDate.parse(appointmentDate);*/
                LocalDate ad = InputHandler.getDateInput("Enter New Date: ");
                appointment.setAppointmentDate(ad);

               /* System.out.println("Enter new time: ");
                appointment.setAppointmentTime(scanner.nextLine());*/
                appointment.setAppointmentTime(InputHandler.getStringInput("Enter New Time: "));

                System.out.println("Appointment Rescheduled Successfully");
                return;
            }
        }
        System.out.println("Appointment not found");
    }

    public void completeAppointment(String appointmentId){
        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNull(appointment.getAppointmentId())){
                System.out.println("Appointment not found");
                return;
            }

            appointment.setStatus("Completed");
        }
    }

    public void displayUpcomingAppointments(){
        if (HelperUtils.isNull(appointmentsList)) {
            System.out.println("Appointment not found");
            return;
        }

        for (Appointments appointment: appointmentsList){
            if (appointment.getAppointmentDate().isAfter(LocalDate.now())) {
                appointment.displayInfo();
            }
        }
    }

    public void cancelAppointment(String appointmentId) {

        for (Appointments appointment: appointmentsList){
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setStatus("Canceled");
                System.out.println("Appointment canceled successfully");
                return;
            }
        }
        System.out.println("Appointment not found");
    }


    @Override
    public void scheduleAppointment(Appointments appointment) {
        for (Appointments p: appointmentsList) {
            if (p.getAppointmentId().endsWith(appointment.getAppointmentId())) {
                System.out.println("Appointments already exist");
                return;
            }
            appointmentsList.add(appointment);
        }
    }

    /*@Override
    public void cancelAppointment(String appointmentId) {

    }*/

    //Overload reschedule Appointment by appointment ID and new Date
    public void rescheduleAppointment(String appointmentId, LocalDate newDate){
        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setAppointmentDate(newDate);
                appointment.setStatus("Rescheduled");

                System.out.println("Appointment rescheduled (date only)");
                return;
            }
        }
    }


    //Overload reschedule Appointment by appointment ID, new Date, new time
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        for (Appointments appointment: appointmentsList) {
            if (HelperUtils.isNotNull(appointment.getAppointmentId())
                    && appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
                appointment.setStatus("Rescheduled");

                System.out.println("Appointment rescheduled (date and time)");
                return;
            }
        }
    }


    //Overload reschedule Appointment by appointment ID, new Date, new time, reason
    public void rescheduleAppointment(Appointments appointment, LocalDate newDate, String newTime, String reason){
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setStatus("Rescheduled");
        appointment.setNotes(reason);

        System.out.println("Appointment rescheduled with reason: " + reason);
    }

    //display all appointment
    public void displayAllAppointment(){
        if (HelperUtils.isNull(appointmentsList)) {
            System.out.println("No Appointment");
            return;
        }

        for (Appointments appointment: appointmentsList){
            appointment.displayInfo();
        }
    }

    //Overload display appointments by date
    public void displayAppointments(LocalDate date) {
        for (Appointments appointment : appointmentsList) {

            if (HelperUtils.isNotNull(appointment.getAppointmentDate())
                    && appointment.getAppointmentDate().equals(date)) {
                appointment.displayInfo();
            }
        }
    }


    //Overload display appointments based on doctor and start date and end date
    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        for (Appointments appointment : appointmentsList) {
            boolean haveDoctor = appointment.getDoctorId().equals(doctorId);

            //Check data at the range
            boolean inRange = (appointment.getAppointmentDate().isEqual(startDate)
                            || appointment.getAppointmentDate().isAfter(startDate))
                            &&
                              (appointment.getAppointmentDate().isEqual(endDate)
                              || appointment.getAppointmentDate().isBefore(endDate));

            if (haveDoctor && inRange){
                appointment.displayInfo();
            }
        }
    }

    public boolean handleAppointmentMenu(Integer appointmentOption){

        switch (appointmentOption) {
            case 1 -> {
                addAppointments();
            }
            case 2 -> {
                displayAllAppointment();
            }
            case 3 -> {
                String patientId = InputHandler.getStringInput("Enter Patient ID: ");
                getAppointmentsByPatientId(patientId);
            }
            case 4 -> {
                String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
                getAppointmentsByDoctorId(doctorId);
            }
            case 5 -> {
                LocalDate date = InputHandler.getDateInput("Enter Date: ");
                getRecordsByDate(date);
            }
            case 6 -> {
                String appointmentId = InputHandler.getStringInput("Enter Appointment ID: ");
                rescheduleAppointment(appointmentId);
            }
            case 7 -> {
                String appointmentId = InputHandler.getStringInput("Enter Appointment ID: ");
                cancelAppointment(appointmentId);
            }
            case 8 -> {
                String appointmentId = InputHandler.getStringInput("Enter Appointment ID: ");
                completeAppointment(appointmentId);
            }
            case 9 -> {
                displayUpcomingAppointments();
            }
        }
        return true;
    }

    @Override
    public void add(Object entity) {
        Appointments appointments = (Appointments) entity;

        for (Appointments a: appointmentsList) {
            if (a.getAppointmentId() != null
                    && a.getAppointmentId().equals(appointments.getAppointmentId())) {
                System.out.println("appointment already exists!");
                return;
            }
            appointmentsList.add(appointments);
            System.out.println("appointment added successfully.");
        }
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
