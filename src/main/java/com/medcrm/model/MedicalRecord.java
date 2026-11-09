package com.medcrm.model;

import java.util.List;
import java.util.ArrayList;

public class MedicalRecord{
    //Data Members
    private final String recordID;
    private final Patient patient;
    private List<String> diagnosisList;
    private List<Appointment> visitHistory;

    //Constructor
    MedicalRecord(String recordID, Patient patient){
        this.recordID = recordID;
        this.patient = patient;
        this.diagnosisList = new ArrayList<>();
        this.visitHistory = new ArrayList<>();
    }

    //Setters
    public void setDiagnosisList(List<String> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }

    public void setVisitHistory(List<Appointment> visitHistory) {
        this.visitHistory = visitHistory;
    }

    //Getters
    public String getRecordID() {
        return recordID;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<String> getDiagnosisList() {
        return diagnosisList;
    }

    public List<Appointment> getVisitHistory() {
        return visitHistory;
    }

    //Methods
    public void addDiagnosis(String diagnosis){
        this.diagnosisList.add(diagnosis);
        System.out.println("Diagnosis added: " + diagnosis);
    }

    public void addAppointmentToHistory(Appointment appointment){
        this.visitHistory.add(appointment);
        System.out.println("Appointment added to history for " + patient.getName());
    }

    public List<Appointment> viewHistory(){
        return this.visitHistory;
    }

}
