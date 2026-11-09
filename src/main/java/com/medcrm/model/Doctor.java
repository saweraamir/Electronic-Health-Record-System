package com.medcrm.model;

import com.medcrm.repository.AppointmentRepository;
import com.medcrm.repository.PrescriptionRepository;
import com.medcrm.model.Prescription;
import com.medcrm.model.Prescription;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor extends User {
    private final String specialization;
    private final List<LocalDate> availableSlots;
    private final List<Patient> patientsList;

    public Doctor(String id, String name, String email, String plainPassword, String role, String specialization) {
        super(id, name, email, plainPassword, role);
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
        this.patientsList = new ArrayList<>();
    }

    public List<Appointment> viewAppointments(AppointmentRepository repo) {
        return repo.findAppointmentsByDoctorId(this.getId());
    }

    public Prescription writePrescription(Patient patient, PrescriptionRepository repo) {
        Scanner sc = new Scanner(System.in);
        List<String> meds = new ArrayList<>();

        System.out.println("Enter number of medicines:");
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            System.out.println("Enter medicine " + (i + 1) + ":");
            meds.add(sc.nextLine());
        }

        System.out.println("Enter additional notes:");
        String notes = sc.nextLine();

        Prescription prescription = new Prescription(patient, this, LocalDate.now(), meds, notes);
        repo.addPrescription(prescription);

        System.out.println("Prescription created successfully!");
        prescription.printPrescription();

        return prescription;
    }

    public String getSpecialization(){
        return specialization;
    }
    public List<LocalDate> getAvailableSlots(){
        return availableSlots;
    }
    public List <Patient> getPatientsList(){
        return patientsList;
    }
}
