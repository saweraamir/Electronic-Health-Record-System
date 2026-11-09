package com.medcrm.model;

import java.time.LocalDate;

class Bill{
    //Data Members
    private final String billID;
    private final Patient patient;
    private double amount;
    private final LocalDate dateIssued;
    private boolean isPaid;

    //Constructor
    Bill(String billID, Patient patient, double amount){
        this.billID = billID;
        this.patient = patient;
        this.amount = amount;
        this.dateIssued = LocalDate.now();
        this.isPaid = false;
    }

    //Setter
    public void setAmount(double amount) {
        this.amount = amount;
    }

    //Getters
    public String getBillID() {
        return billID;
    }

    public Patient getPatient() {
        return patient;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public boolean isPaid() {
        return isPaid;
    }

    //Methods
    public void markAsPaid() {
        if (!isPaid) {
            this.isPaid = true;
            System.out.println("The bill has been paid.");
        } else {
            System.out.println("The bill is already paid.");
        }
    }

    public void printBillDetails() {
        System.out.println("Bill ID: " + billID);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Amount: " + amount);
        System.out.println("Date Issued: " + dateIssued);
        System.out.println("Paid: " + (isPaid ? "Yes" : "No"));
    }

}
