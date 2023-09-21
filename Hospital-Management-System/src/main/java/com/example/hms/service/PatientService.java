package com.example.hms.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.retry.annotation.Retryable;

import com.example.hms.model.Patient;
import com.example.hms.model.Patient_view;

import org.springframework.retry.annotation.Backoff;

public interface PatientService {
public Patient savePatient(Patient patient) throws Exception;
public List<Patient> getAllpatient();
public Patient getPatientById(int id);
public Patient updatePatient(int id, Patient patient);
public void removePatient(int id);
public Patient getById(int patientId);
public Patient loginPatient(Patient patient) throws IOException, TimeoutException;
public Patient getPatientByEmail(Patient patient);
public Patient findByEmail(String email);
public void performScheduledTask();

}
