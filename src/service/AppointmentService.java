package service;

import Entites.Appointments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentService {
    List<Appointments> appointmentsList = new ArrayList<>();

    public void addAppointments(Appointments appointment) {
        appointmentsList.add(appointment);
        System.out.println("appointment Added Successfully");
    }

    public boolean removeAppointments(String appointmentId) {
        for (Appointments appointment: appointmentsList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {

                appointmentsList.remove(appointment);
                return true;
            }
        }
        return false;
    }

    public List<Appointments> getAppointmentsByPatientId(String patientId) {
        List<Appointments> result = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (appointment.getPatientId().equals(patientId)) {
                result.add(appointment);
            }
        }
        return result;
    }

/*    public List<Appointments> getAppointmentsByDoctortId(String ) {
        List<Appointments> result = new ArrayList<>();

        for (Appointments appointment: appointmentsList) {
            if (appointment.getPatientId().equals(patientId)) {
                result.add(appointment);
            }
        }
        return result;
    }*/
}
