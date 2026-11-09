package com.medcrm.repository;
import com.medcrm.model.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionRepository {
    private final List<Prescription> prescriptions = new ArrayList<>();

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Prescription> getPrescriptionsByPatientName(String patientName) {
        List<Prescription> result = new ArrayList<>();
        for (Prescription p : prescriptions) {
            if (p.getPatient().getName().equalsIgnoreCase(patientName)) {
                result.add(p);
            }
        }
        return result;
    }


}

