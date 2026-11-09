package com.medcrm.model;

import java.time.LocalDate;
import com.medcrm.model.Doctor;

public class Appointment{
    //Data Members
    private final String appointmentId;
    private final Patient patient;
    private Doctor doctor;
    private LocalDate dateTime;
    private AppointmentStatus status;
    private String bookedDoctorId;
    private static int counter = 1;
    //Constructor
    Appointment(Patient patient, Doctor doctor, LocalDate dateTime, AppointmentStatus status){
        this.appointmentId= "APPT" + counter++;
        this.patient=patient;
        this.doctor=doctor;
        this.dateTime=dateTime;
        this.status=status;
    }

    //Setters
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    //Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    //Methods
    public void reschedule(LocalDate newTime){
        this.dateTime=newTime;
        this.status=AppointmentStatus.RESCHEDULED;
        System.out.println("Appointment has been rescheduled to "+newTime);
    }

    public void cancel(){
        this.status = AppointmentStatus.CANCELLED;
        System.out.println("Appointment has been cancelled.");
    }

    public void notifyUser(){

        System.out.println("Notification: Appointment for " + patient.getName() +" with Dr. " + doctor.getName() + " on " + dateTime + " is " + status + ".");
    }

    public String getDoctorId(){
        bookedDoctorId = doctor.getId();
        return bookedDoctorId;

    }

}
