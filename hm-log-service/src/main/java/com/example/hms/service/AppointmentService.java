package com.example.hms.service;

import java.util.List;

import com.example.hms.model.Appointment;



public interface AppointmentService  {
  Appointment addAppointment(Appointment appointment, int id, int patientId);
  Appointment updateAppointment(Appointment appointment, int id);
  List<Appointment> getAppointmentByPatientId(int patientId);
  List<Appointment>getAllAppointments();
  void deleteAppointment(int id);
  public Appointment getAppointmentById(int id);
	
}
