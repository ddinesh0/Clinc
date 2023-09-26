package com.example.hms.config;

import java.util.Collection;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.hms.model.Doctor;

@Configuration
public class DoctorPrinciple implements UserDetails{

	@Autowired
	private Doctor doctor;
	
	
	
	public DoctorPrinciple(Doctor doctor) {
		super();
		this.doctor = doctor;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(doctor.getDesignation()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
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
