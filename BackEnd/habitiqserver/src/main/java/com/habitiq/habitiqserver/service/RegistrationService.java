package com.habitiq.habitiqserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitiq.habitiqserver.model.RegistrationRequest;
import com.habitiq.habitiqserver.model.User;
import com.habitiq.habitiqserver.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegistrationRequest request) {
        // Perform validation and save user data to the database
    	try {
    		
    		System.out.print("hey im here");
            User user = new User();
            user.setEmail(request.getEmail());
            // Hash the password before saving it
            user.setPassword((request.getPassword()));
            user.setConpassword(request.getConpassword());
            userRepository.save(user);
    		
    	}
    	
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	
    }
}