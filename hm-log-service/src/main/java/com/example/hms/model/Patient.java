package com.example.hms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient")
	private int id;
	
	private String name;
	private String email;
	private String contactno;
	private String password;
	private String dob;
	private String gender;
	private String country;
	private String state;
	private String role;
	private String city;
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="patientId")
	@JsonIgnore
    private List<Appointment> appointment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", contactno=" + contactno + ", password="
				+ password + ", dob=" + dob + ", gender=" + gender + ", country=" + country + ", state=" + state
				+ ", role=" + role + ", city=" + city + ", address=" + address + ", appointment=" + appointment + "]";
	}
	
	
	
}
