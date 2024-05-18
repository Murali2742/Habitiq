package com.habitiq.habitiqserver.model;

public class RegistrationRequest {
	 private String email;
	 private String password;
	 private String conpassword;
	 // Getters and setters
	 
	 public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		 public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}
	 

	}
