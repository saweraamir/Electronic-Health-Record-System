package com.medcrm.repository;
import com.medcrm.model.Appointment;
import com.medcrm.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepository {

    private List <MedicalRecord> records = new ArrayList<>();
    public void addMedicalRecord(MedicalRecord medicalRecord){
        records.add(medicalRecord);


    }

    public List<MedicalRecord> findMedicalRecordById(String recordID){
        List <MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord rec: records) {
            if (rec.getRecordID().equals(recordID)) {
                result.add(rec);
            }
        }
        return result;


    }

}
