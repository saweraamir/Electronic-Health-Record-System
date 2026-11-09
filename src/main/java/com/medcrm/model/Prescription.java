package com.medcrm.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Prescription{
    //Data Members
    private final String prescriptionID;
    private static int counter = 1;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDate dateIssued;
    private List<String> medicineList;
    private String notes;

    //Constructor
    Prescription( Patient patient, Doctor doctor, LocalDate dateIssued, List<String> medicineList, String notes){
        this.prescriptionID = "LAT23"+counter++;
        this.patient = patient;
        this.doctor = doctor;
        this.dateIssued = dateIssued;
        this.medicineList = medicineList;
        this.notes = notes;
    }

    //Setters
    public void setMedicineList(List<String> medicineList) {
        this.medicineList = medicineList;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //Getters
    public String getPrescriptionID() {
        return prescriptionID;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public List<String> getMedicineList() {
        return medicineList;
    }

    public String getNotes() {
        return notes;
    }

    //Methods
    public void updateNotes(String newNote){
        if(this.notes == null || this.notes.isEmpty()){
            this.notes = newNote;
        } else{
            this.notes = this.notes + "\n" + newNote;
        }

        System.out.println("Notes updated successfully!");
    }

    public void printPrescription(){
        System.out.println("~~~~~~~~~~~~~Prescription~~~~~~~~~~~");
        System.out.println("Prescription ID: " + prescriptionID);
        System.out.println("Doctor name: "+ doctor);
        System.out.println("Patient name: "+ patient);
        System.out.println("Date issued: "+ dateIssued);
        System.out.println("Medicine list: ");
        for(String medicine: medicineList){
            System.out.println("- "+medicine);
        }

        System.out.println("Notes: "+ notes);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
