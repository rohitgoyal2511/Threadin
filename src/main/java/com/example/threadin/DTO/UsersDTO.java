package com.example.threadin.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsersDTO {
	
	@NotNull
	@NotEmpty
	private String emailId;
	
	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;
	
	private String userType;
	
	private boolean status;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	
	
	
}
