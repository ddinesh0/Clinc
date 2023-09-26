package com.example.hms.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Doctor;
import com.example.hms.model.Patient;
import com.example.hms.model.Patient_view;
import com.example.hms.service.PatientService;
//import com.example.hms.service.Patient_viewService;
import com.example.hms.service.Impl.PatientServiceImpl;


@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	@Autowired
//	private Patient_viewService viewservice;
	
	 private PatientServiceImpl myScheduledTask = new PatientServiceImpl();
	 
	 public void ScheduleController(PatientServiceImpl myScheduledTask) {
	        this.myScheduledTask = myScheduledTask;
	 }
	        
	@PostMapping
	public ResponseEntity<Patient>savePatient(@RequestBody Patient patient) throws Exception{
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	 @PostMapping("/plogin")
	 public ResponseEntity<Patient> loginPatient(@RequestBody Patient patient) {
		    Patient storedPatient = patientService.findByEmail(patient.getEmail());
		    
		    if (storedPatient != null) {
		      BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		      String providedPassword = patient.getPassword();
		      String storedPassword = storedPatient.getPassword();
		      
		      if (bcrypt.matches(providedPassword, storedPassword)) {
		        return ResponseEntity.ok(storedPatient);
		      }
		    }
		    
		    // Login failed
		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		  }
	
	@GetMapping("/patient")
	public List<Patient> getAllPatient()
	{
		return patientService.getAllpatient();
	}
//    @PostMapping("/login")
//    public ResponseEntity<Patient> loginPatient(@RequestBody Patient patient)
//    {
//    	return new ResponseEntity<Patient>(patientService.loginPatient(patient),HttpStatus.OK);
//    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id, @RequestBody Patient patient )
    {
    	return new ResponseEntity<Patient>(patientService.updatePatient(id, patient),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id)
    {
    	System.out.println(id);
    	return new ResponseEntity<Patient>(patientService.getPatientById(id),HttpStatus.OK);
    }
  
    @DeleteMapping("{id}")
	public ResponseEntity<String> removepatient(@PathVariable("id") int id)
	{
		patientService.removePatient(id);
		return new ResponseEntity<String>("patientdetails Deleted Successfully",HttpStatus.OK);
	}
    
//    @GetMapping("/users")
//    public List<Patient_view> getAllUsers() {
//        return viewservice.getAllUsersFromView();
//    }
}
