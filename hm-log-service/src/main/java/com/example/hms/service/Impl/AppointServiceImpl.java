package com.example.hms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.exception.ResourceNotFoundException;
import com.example.hms.model.Appointment;
import com.example.hms.model.Patient;
import com.example.hms.repository.AppointmentRepository;
import com.example.hms.service.AppointmentService;
import com.example.hms.service.PatientService;


@Service
public class AppointServiceImpl implements AppointmentService{
	@Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientService patientService;
	@Override
	public Appointment addAppointment(Appointment appointment, int id, int patientId) {
		Patient patient=patientService.getPatientById(patientId);
		//appointment.setPatientName(appointment.getPatientName());
		appointment.setAge(appointment.getAge());
		//appointment.setContactno(appointment.getContactno());
		appointment.setDates(appointment.getDates());
		appointment.setDisease(appointment.getDisease());
		appointment.setPatient(patient);
				
	return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment, int id) {
		Appointment appointment1=getAppointmentById(id);
		//appointment1.setPatientName(appointment.getPatientName());
		appointment1.setAge(appointment.getAge());
		//appointment1.setContactno(appointment.getContactno());
		appointment1.setDates(appointment.getDates());
		appointment1.setDisease(appointment.getDisease());
		appointmentRepository.save(appointment1);
		return appointment1;
	}

	
	@Override
	public List<Appointment> getAppointmentByPatientId(int patientId) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByPatientId(patientId);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public void deleteAppointment(int id) {
        appointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("appointment", "id", id));
        appointmentRepository.deleteById(id);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Appointment","id",id));
	}

	
	
	
}
