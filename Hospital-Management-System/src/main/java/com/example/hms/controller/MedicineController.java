package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Medicine;
import com.example.hms.service.MedicineService;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	@PostMapping
	public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine){
		return new ResponseEntity<Medicine>(medicineService.saveMedicine(medicine),HttpStatus.CREATED);
	}
	@GetMapping("/medicines")
	List<Medicine> getAllMedicines(){
		return medicineService.getAllMedicines();
	}
	@GetMapping("{medicineId}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable ("medicineId") int medicineId){
		return new ResponseEntity<Medicine>(medicineService.getMedicineById(medicineId),HttpStatus.OK);
	}
	@PutMapping("{medicineId}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable("medicineId") int medicineId,@RequestBody Medicine medicine){
		return new ResponseEntity<Medicine>(medicineService.updateMedicine(medicineId, medicine),HttpStatus.OK);
	}
	@DeleteMapping("{medicineId}")
	public ResponseEntity<String> deleteMedicine(@PathVariable("medicineId") int medicineId){
		return new ResponseEntity<String>("medicine deleted Successfully",HttpStatus.OK);

}
}
