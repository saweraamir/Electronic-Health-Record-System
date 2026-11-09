package com.medcrm.repository;

import com.medcrm.model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> findAppointmentsByDoctorId(String doctorId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appt : appointments) {
            if (appt.getDoctorId().equals(doctorId)) {
                result.add(appt);
            }
        }
        return result;
    }


}
