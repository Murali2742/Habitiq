package com.habitiq.habitiqserver.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habitiq.habitiqserver.model.Habit;
import com.habitiq.habitiqserver.model.HabitRequest;
import com.habitiq.habitiqserver.model.LoginRequest;
import com.habitiq.habitiqserver.model.RegistrationRequest;
import com.habitiq.habitiqserver.model.User;
import com.habitiq.habitiqserver.service.HabitService;
import com.habitiq.habitiqserver.service.LoginService;
import com.habitiq.habitiqserver.service.RegistrationService;

import jakarta.servlet.http.HttpServletRequest;

//RegistrationController.java
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RegistrationController {

 @Autowired
 private RegistrationService registrationService;
 
 @Autowired
 private HabitService habitService;
 
 @Autowired
 private LoginService loginService;
 
 private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

 
 
 @GetMapping("habits")
 public List<Habit> getHabits(@RequestParam String email) {
     return habitService.getHabitsByEmail(email);
 }
         
         
    
 



     @GetMapping("/current-user-email")
     public ResponseEntity<String> getCurrentUserEmail(HttpServletRequest request) {
         // Retrieve the user's email from the session
         String userEmail = "Murali";
         System.out.print("Hello email");
         // Return the user's email
         return ResponseEntity.ok(userEmail);
     }
 


 @PostMapping("/login")
 public ResponseEntity<?> login(HttpServletRequest request,@RequestBody LoginRequest loginRequest) {
     try {
         User user = loginService.authenticate(loginRequest);
         // Authentication successful, return user details or JWT token
         request.getSession().setAttribute("userEmail", loginRequest.getEmail());
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
 
 @PostMapping("/habit")
 public ResponseEntity<?> registerUser(@RequestBody HabitRequest request) {
     try {
    	 habitService.registerHabit(request);
         return ResponseEntity.ok("Registration successful");
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
     }
 }
 
 
 
}


