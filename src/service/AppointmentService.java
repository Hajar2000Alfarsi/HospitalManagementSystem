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


}
