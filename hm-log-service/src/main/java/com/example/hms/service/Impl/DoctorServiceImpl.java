package com.example.hms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hms.exception.ResourceNotFoundException;
import com.example.hms.model.Doctor;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.service.DoctorService;
@Service
public  class DoctorServiceImpl implements DoctorService{
     @Autowired
     DoctorRepository doctorRepository;
	@Override
	public Doctor saveDoctor(Doctor doctor) throws Exception {
		if(doctor!=null) 
		{
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			String enPassWrd=bcrypt.encode(doctor.getPassword());
			doctor.setPassword(enPassWrd);
			return doctorRepository.save(doctor);
		}
		else {
			 throw new Exception("User Already Exists");
		}
	}
	@Override
	public List<Doctor> getAlldoctors() {
		return doctorRepository.findAll();
	}
	@Override
	public Doctor getDoctorById(int id)  {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
	}
	@Override
	public Doctor loginDoctor(Doctor doctor) {
		  BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	    String encodedPassword = bcrypt.encode(doctor.getPassword());
	    doctor.setPassword(encodedPassword);
	    System.out.println("en");
	    System.out.println(encodedPassword);
		return doctorRepository.findByEmailAndPassword(doctor.getEmail(),doctor.getPassword());
	}
	@Override
	public Doctor updateDoctor(int id, Doctor doctor) {
		Doctor doctor1=getDoctorById(id);
		doctor1.setFirstName(doctor.getFirstName());
		doctor1.setLastName(doctor.getLastName());
		doctor1.setContactno(doctor.getContactno());
		doctor1.setDepartment(doctor.getEmail());
		doctor1.setExperience(doctor.getExperience());
		doctor1.setQualification(doctor.getQualification());
		doctor1.setPassword(doctor.getPassword());
		return doctorRepository.save(doctor1);
	}
	@Override
	public void removeDoctor(int id) {
     doctorRepository.deleteById(id);
	}
	
	@Override
	public Doctor findByEmail(String email) {
		// TODO Auto-generated method stub
		return doctorRepository.findByEmail(email);
	}
}
