package com.habitiq.habitiqserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.habitiq.habitiqserver.model.LoginRequest;
import com.habitiq.habitiqserver.model.User;
import com.habitiq.habitiqserver.repository.UserRepository;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    

    public User authenticate(LoginRequest loginRequest) {
    	  User user = userRepository.findByEmail(loginRequest.getEmail())
                  .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + loginRequest.getEmail()));
    	  
    	  if (user.getPassword().equals(loginRequest.getPassword())) {
    		  return user;
              
          }
    	  else {
    		  throw new BadCredentialsException("Invalid password");
    	  }
    
        } 
    
}
