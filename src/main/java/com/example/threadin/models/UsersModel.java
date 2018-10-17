package com.example.threadin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class UsersModel extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Email
	@NotBlank
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "user_status")
	private boolean status;
	
	public UsersModel() {
		super();
		this.status = false;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
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
	
	
}
