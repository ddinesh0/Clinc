package com.example.hms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
@EnableRetry
public class HospitalManagementSystemApplication implements CommandLineRunner,WebMvcConfigurer{

	private static final String[] REQUEST_METHOD_SUPPORTED= {"GET","POST","PUT","PATCH","DELETE","OPTIONS","HEAD"};
	
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOriginPatterns("*").allowedHeaders("*").allowedMethods(REQUEST_METHOD_SUPPORTED);
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world from command line runner");
		
		
		
	}

}
