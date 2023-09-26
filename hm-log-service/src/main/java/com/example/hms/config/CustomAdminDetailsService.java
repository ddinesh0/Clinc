
package com.example.hms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hms.model.Admin;
import com.example.hms.repository.AdminRepository;

@Service
public class CustomAdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin=adminRepository.findByAdminEmailIdAndAdminPassword(username, username);//connecting to database by using adminrepository	
		if(admin==null)
		{
			throw new UsernameNotFoundException("User Not Found");
			
		}
		return new CustomAdminDetails(admin);
	}

	
		
	}

	




