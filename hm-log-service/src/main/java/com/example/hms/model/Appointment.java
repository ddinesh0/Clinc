package com.example.hms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private String patientName;
	private int age;
	//private long contactno;
	//@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	private String dates;
	private String disease;
	@ManyToOne
	private Patient patient;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	/*
	 * public String getPatientName() { return patientName; }
	 * 
	 * public void setPatientName(String patientName) { this.patientName =
	 * patientName; }
	 */
	 
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	

	

	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}



}
