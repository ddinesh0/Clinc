package com.example.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Appointment;
import com.example.hms.model.Doctor;
import com.example.hms.model.Patient;
import com.example.hms.service.AppointmentService;
import com.example.hms.service.DoctorService;
import com.example.hms.service.PatientService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
    @PostMapping("/{id}/{patientId}")
    public ResponseEntity<Appointment>addAppointment(@PathVariable int id,@PathVariable int patientId,@RequestBody Appointment appointment){
    	return new ResponseEntity<Appointment>(appointmentService.addAppointment(appointment, id, patientId),HttpStatus.CREATED);
    }
	@PutMapping("{id}")
	public ResponseEntity<Appointment>updateAppointment(@PathVariable("id") int id, @RequestBody Appointment appointment)
	{
		return new ResponseEntity<Appointment>(appointmentService.updateAppointment(appointment, id),HttpStatus.OK);
    }
	@GetMapping("/appointment")
	public List<Appointment> getAllAppointments()
	{
		return appointmentService.getAllAppointments(); 
	}
	
}
