package com.habitiq.habitiqserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitiq.habitiqserver.model.HabitRequest;
import com.habitiq.habitiqserver.model.RegistrationRequest;
import com.habitiq.habitiqserver.model.User;
import com.habitiq.habitiqserver.model.Habit;
import com.habitiq.habitiqserver.repository.HabitRepository;
import com.habitiq.habitiqserver.repository.UserRepository;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;
    
    public List<Habit> getHabitsByEmail(String email) {
        return habitRepository.findByEmail(email);
    }

    public void registerHabit(HabitRequest request) {
        // Perform validation and save user data to the database
    	try {
    		
    		System.out.print("hey im here");
    		Habit habit = new Habit();
    		habit.setEmail(request.getEmail());
    		habit.setHabit(request.getHabit());
    		habitRepository.save(habit);
    		
    		
    		
    	}
    	
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	
    }
}
