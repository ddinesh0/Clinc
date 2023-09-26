package com.example.hms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.model.Medicine;
import com.example.hms.repository.MedicineRepository;
import com.example.hms.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	@Autowired
    private MedicineRepository medicineRepository;
	@Override
	public List<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine updateMedicine(int medicineId, Medicine medicine) {
		// TODO Auto-generated method stub
		Medicine medicine1=getMedicineById(medicineId);
		medicine1.setDiscripttion(medicine1.getDiscripttion());
		medicine1.setMedicineCompany(medicine1.getMedicineCompany());
		medicine1.setMedicineCompositon(medicine1.getMedicineCompositon());
		medicine1.setMedicineDose(medicine1.getMedicineDose());
		medicine1.setMedicineCost(medicine1.getMedicineCost());
		return medicineRepository.save(medicine1);
	}

	
	@Override
	public void deleteMedicine(int medicineId) {
		// TODO Auto-generated method stub
		Medicine medicine=getMedicineById(medicineId);
		medicineRepository.deleteById(medicine.getMedicineId());
	}

	@Override
	public Medicine getMedicineById(int medicineId) {
		// TODO Auto-generated method stub
		Medicine medicine=getMedicineById(medicineId);
		return medicineRepository.findById(medicineId).get();
	}

}
