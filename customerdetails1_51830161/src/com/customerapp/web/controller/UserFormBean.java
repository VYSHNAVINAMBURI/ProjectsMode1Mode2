package com.customerapp.web.controller;

import org.hibernate.validator.constraints.*;

public class UserFormBean {
	@NotEmpty(message="Email should not be blank")
	@Email(message="Email must be valid")

	private String email;
	@NotEmpty(message="Email should not be blank")
	private String password;
	
	
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
