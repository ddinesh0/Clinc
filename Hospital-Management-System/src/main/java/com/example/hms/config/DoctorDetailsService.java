package com.example.hms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hms.model.Doctor;
import com.example.hms.repository.DoctorRepository;


@Service
public class DoctorDetailsService implements UserDetailsService{
	
	@Autowired
	private DoctorRepository doctorrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Doctor doctor= doctorrepo.findByEmailAndPassword(username, username);
		
		if(doctor==null) {
			
			throw new UsernameNotFoundException("no user");
		}
		
		return new DoctorPrinciple(doctor);
	}

}
