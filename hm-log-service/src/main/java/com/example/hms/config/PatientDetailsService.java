package com.example.hms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hms.model.Patient;
import com.example.hms.repository.PatientRepository;

@Service
public class PatientDetailsService implements UserDetailsService{
	@Autowired
	private PatientRepository patientrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Patient patient=patientrepo.findByEmailAndPassword(username, username);
		if(patient==null) {
			throw new UsernameNotFoundException("no user");
		}
		
		return new PatientPrinciple(patient);
	}

	
	

}
