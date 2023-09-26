
  package com.example.hms.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.hms.interceptor.GeneralInterceptor;
import com.example.hms.model.Admin;
@Component
@Primary
@Configuration

public class CustomAdminDetails implements WebMvcConfigurer,UserDetails{
	
	private Admin admin;
	 
  @Autowired
  GeneralInterceptor generalinter;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(generalinter);
	  
  }
  

public CustomAdminDetails(Admin admin) {
	super();
	this.admin=admin;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return Collections.singleton(new SimpleGrantedAuthority(admin.getDesignation()));
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return admin.getAdminPassword();
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return admin.getAdminEmailId();
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
 