package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Admin;
import com.example.hms.model.Doctor;
import com.example.hms.model.Patient;
import com.example.hms.service.DoctorService;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@PostMapping("/post")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) throws Exception{
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctors()
	{
		return doctorService.getAlldoctors();
	}
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(id),HttpStatus.OK);
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int id,@RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(id, doctor),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeDoctor(@PathVariable("id") int id)
	{
		doctorService.removeDoctor(id);
		return new ResponseEntity<String>("Doctordetails Deleted Successfully",HttpStatus.OK);
	}
	

	 @PostMapping("/dlogin")
	 public ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctor){
		 Doctor d=doctorService.findByEmail(doctor.getEmail());
		 if(d!=null) {
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			String pass=doctor.getPassword();
			String stored=d.getPassword();
			System.out.println(stored);
			System.out.println(pass);
			if(bcrypt.matches(pass, stored)) {
				return ResponseEntity.ok(d);
			}
		 }
			 
		 return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		 
//		 @PostMapping("/plogin")
//		 public ResponseEntity<Patient> loginPatient(@RequestBody Patient patient) {
//			    Patient storedPatient = patientService.findByEmail(patient.getEmail());
//			    
//			    if (storedPatient != null) {
//			      BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//			      String providedPassword = patient.getPassword();
//			      String storedPassword = storedPatient.getPassword();
//			      
//			      if (bcrypt.matches(providedPassword, storedPassword)) {
//			        return ResponseEntity.ok(storedPatient);
//			      }
//			    }
//			    
//			    // Login failed
//			    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//			  }
		 
	 }
}
