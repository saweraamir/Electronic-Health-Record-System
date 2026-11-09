package com.medcrm.model;

import com.medcrm.repository.AppointmentRepository;
import com.medcrm.repository.MedicalRecordRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Patient extends User {

    private MedicalRecord medicalHistory;
    private List<Appointment> appointments;

    public Patient(String id, String name, String email, String plainPassword, String role) {
        super(id, name, email, plainPassword, role);
    }

    public Appointment bookAppointment(List<Doctor> availableDoctors, AppointmentRepository repo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Available Doctors:");
        for (int i = 0; i < availableDoctors.size(); i++) {
            Doctor doc = availableDoctors.get(i);
            System.out.println((i + 1) + ". " + doc.getName() + " (" + doc.getSpecialization() + ")");
        }

        System.out.print("Select doctor (1-" + availableDoctors.size() + "): ");
        int docIndex = Integer.parseInt(sc.nextLine()) - 1;
        Doctor selectedDoctor = availableDoctors.get(docIndex);

        List<LocalDate> slots = selectedDoctor.getAvailableSlots();
        if (slots.isEmpty()) {
            System.out.println("No available slots for this doctor.");
            return null;
        }

        System.out.println("Available slots for Dr. " + selectedDoctor.getName() + ":");
        for (int i = 0; i < slots.size(); i++) {
            System.out.println((i + 1) + ". " + slots.get(i));
        }

        System.out.print("Choose slot (1-" + slots.size() + "): ");
        int slotIndex = Integer.parseInt(sc.nextLine()) - 1;
        LocalDate chosenSlot = slots.get(slotIndex);

        Appointment newAppointment = new Appointment(this, selectedDoctor, chosenSlot, AppointmentStatus.SCHEDULED);
        appointments.add(newAppointment);
        selectedDoctor.getPatientsList().add(this);  // Optional
        selectedDoctor.getAvailableSlots().remove(chosenSlot); // Remove booked slot

        repo.addAppointment(newAppointment);  // Save to repository

        System.out.println("Appointment booked successfully with Dr. " + selectedDoctor.getName() + " on " + chosenSlot);

        return newAppointment;
    }

    public List<MedicalRecord> viewPrescriptions(MedicalRecordRepository repo) {
        return repo.findMedicalRecordById(this.medicalHistory.getRecordID());
    }
}



