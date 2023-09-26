package com.example.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
	public List<Appointment> findByPatientId(int patientId);

}
