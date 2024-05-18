package com.habitiq.habitiqserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habitiq.habitiqserver.model.LoginRequest;
import com.habitiq.habitiqserver.model.RegistrationRequest;
import com.habitiq.habitiqserver.model.User;
import com.habitiq.habitiqserver.service.LoginService;
import com.habitiq.habitiqserver.service.RegistrationService;

//RegistrationController.java
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RegistrationController {

 @Autowired
 private RegistrationService registrationService;
 
 @Autowired
 private LoginService loginService;
 
 private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

 
 
 @GetMapping("/hello")
 public String Hello() {
    logger.info("inside");
       
         return "Hello";
    
 }
 


 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
     try {
         User user = loginService.authenticate(loginRequest);
         // Authentication successful, return user details or JWT token
         return ResponseEntity.ok("Login successful");
     } catch (UsernameNotFoundException | BadCredentialsException e) {
         // Authentication failed
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
     }
 }

 @PostMapping("/register")
 public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
     try {
         registrationService.registerUser(request);
         return ResponseEntity.ok("Registration successful");
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
     }
 }
}


