package com.example.threadin.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="work_details")
public class WorkDetailsModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="role")
	private String role;
	
	@Column(name="discription")
	@Size(min=100,max=1000)
	private String discription;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	public WorkDetailsModel() {
		super();
	}

	public WorkDetailsModel(long id, String organization, String role, @Size(min = 100, max = 1000) String discription,
			Date startDate, Date endDate) {
		super();
		this.id = id;
		this.organization = organization;
		this.role = role;
		this.discription = discription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
}
