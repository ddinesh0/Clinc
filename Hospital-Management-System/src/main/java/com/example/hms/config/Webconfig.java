package com.example.hms.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class Webconfig extends WebMvcAutoConfiguration{
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")//Replace with your HTML page URL
                .allowedMethods("GET", "POST")
                .allowCredentials(true);
    }
	 @Bean
	  public RetryTemplate retryTemplate() {
	    RetryTemplate retryTemplate = new RetryTemplate();

	    // Configure the backoff policy
	    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
	    backOffPolicy.setBackOffPeriod(1000); // 1 second backoff period
	    retryTemplate.setBackOffPolicy(backOffPolicy);

	    // Configure the retry policy
	    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
	    retryPolicy.setMaxAttempts(3); // Maximum number of retry attempts
	    retryTemplate.setRetryPolicy(retryPolicy);

	    return retryTemplate;
	  }

}
