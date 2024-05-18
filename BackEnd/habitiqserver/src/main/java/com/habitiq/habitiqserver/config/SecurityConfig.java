package com.habitiq.habitiqserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	 public void configure (HttpSecurity http) throws Exception {
	       http.csrf().disable().authorizeRequests()
	        .requestMatchers("/").permitAll()
	        .requestMatchers(HttpMethod.POST,"/newuser").permitAll()
	        .requestMatchers(HttpMethod.POST, "/login").permitAll()
	        .requestMatchers(HttpMethod.POST,"/newuser/*").permitAll()
	        .requestMatchers(HttpMethod.GET,"/master/*").permitAll()
	         .requestMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
	        .anyRequest().authenticated();
	    }
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	

   
}

