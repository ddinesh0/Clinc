package com.example.hms.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hms.exception.ResourceNotFoundException;
import com.example.hms.model.Patient;
import com.example.hms.model.Patient_view;
import com.example.hms.repository.PatientRepository;
import com.example.hms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private Patient patient;
  
  @Scheduled(fixedDelay = 3600000) 
  public void performScheduledTask() {
      System.out.println("Scheduled task executed");
  }
	@Override
	public Patient savePatient(Patient patient) throws Exception {
		if(patient!=null) 
		{
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			String enPassWrd=bcrypt.encode(patient.getPassword());
			patient.setPassword(enPassWrd);
			return patientRepository.save(patient);
		}
		else {
			 throw new Exception("User Already Exists");
		}
		
	}
	@Override
	public List<Patient> getAllpatient() {
		return patientRepository.findAll();
	}
	@Override
	public Patient getPatientById(int id) {
		return patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("patient","id",id));
	}

	@Override
	public Patient updatePatient(int id, Patient patient) {
		Patient patient1=getPatientById(id);
		patient1.setName(patient.getName());
		patient1.setAddress(patient.getAddress());
		patient1.setCity(patient.getCity());
		patient1.setContactno(patient.getContactno());
		patient1.setDob(patient.getDob());
		patient1.setCountry(patient.getCountry());
		patient1.setEmail(patient.getEmail());
		patient1.setPassword(patient.getPassword());
		patient1.setState(patient.getState());
		patient1.setGender(patient.getGender());
		patient1.setRole(patient.getRole());
		
		return patientRepository.save(patient1);
	}
	@Override
	public void removePatient(int id) {
		patientRepository.deleteById(id);
	}
	@Override
	public Patient getById(int patientId) {
		return patientRepository.findById(patientId).get();
	}
	
	  @Retryable(value = {IOException.class, TimeoutException.class}, maxAttempts = 3)
	@Override
	public Patient loginPatient(Patient patient) throws IOException,TimeoutException{
		  BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		    String encodedPassword = bcrypt.encode(patient.getPassword());
		    patient.setPassword(encodedPassword);
		return patientRepository.findByEmailAndPassword(patient.getEmail(),patient.getPassword());
	}
	  @Recover
	  public String recover() {
		  return "Please try after sometime";
	  }
	
	@Override
	public Patient getPatientByEmail(Patient patient) {
		return patientRepository.findByEmail(patient.getEmail());
	}
	@Override
	public Patient findByEmail(String email) {
		
		return patientRepository.findByEmail(email);
	}

	


}
