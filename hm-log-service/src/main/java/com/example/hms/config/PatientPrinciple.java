package com.example.hms.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.hms.model.Patient;
@Configuration
public class PatientPrinciple implements UserDetails{
	@Autowired
	private Patient patient;
	
	

	public PatientPrinciple(Patient patient) {
		super();
		this.patient = patient;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(patient.getRole()));
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return patient.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return patient.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
