package com.example.hms.service;

import java.util.List;

import com.example.hms.model.Doctor;

public interface DoctorService {
 public Doctor saveDoctor(Doctor doctor) throws Exception;

public List<Doctor> getAlldoctors();

public Doctor getDoctorById(int id);

public Doctor loginDoctor(Doctor doctor);

public Doctor updateDoctor(int id, Doctor doctor);
public void removeDoctor(int id);



public Doctor findByEmail(String email);
}
