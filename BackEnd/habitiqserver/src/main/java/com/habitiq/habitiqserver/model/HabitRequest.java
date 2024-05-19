package com.habitiq.habitiqserver.model;

public class HabitRequest {
	
	private String email;
	private String habit;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHabit() {
		return habit;
	}
	
	public void setHabit(String habit) {
		this.habit = habit;
	}

}
