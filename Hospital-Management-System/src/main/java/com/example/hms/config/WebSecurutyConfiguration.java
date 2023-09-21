package com.example.hms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.hms.service.AdminService;
@Component
@Configuration
@EnableWebSecurity
public class WebSecurutyConfiguration extends WebSecurityConfigurerAdapter{
@Autowired
@Qualifier("customAdminDetailsService") 
private UserDetailsService userDetailservice;

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
AuthenticationProvider authenticationProvider()
{
	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
	provider.setUserDetailsService(userDetailservice);
	provider.setPasswordEncoder(new BCryptPasswordEncoder());	
	return provider;
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .cors().and()
        .csrf().disable()
        .authorizeRequests()
        .anyRequest().permitAll(); // Allow all requests without authentication or authorization
}

//protected void configre(HttpSecurity http) throws Exception
//{
//	http
//	.cors()
//	.and()
//	.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
//	.antMatchers(HttpMethod.OPTIONS).permitAll()
//	.anyRequest().authenticated();
//	antMatchers("/home")
//	.hasAuthority("ADMIN")
//	.antMatchers("/admin")//URL
//	.hasAnyAuthority("ADMIN")
//	.anyRequest()
//	.authenticated()
//	.and()
//	//.formLogin();
//.httpBasic();
//	//formLogin()
//	}
//private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl antMatchers(String string) {
//	// TODO Auto-generated method stub
//	return null;
//}
}

