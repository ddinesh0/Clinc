package com.example.hms.service;

import java.util.List;

import com.example.hms.model.Medicine;

public interface MedicineService {
	public List<Medicine> getAllMedicines();
	public Medicine saveMedicine(Medicine medicine);
    public Medicine updateMedicine(int medicineId, Medicine medicine);
    public void deleteMedicine(int medicineId);
    public Medicine getMedicineById(int medicineId);
}
