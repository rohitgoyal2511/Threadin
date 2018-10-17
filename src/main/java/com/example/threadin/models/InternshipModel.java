package com.example.threadin.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="internships")
public class InternshipModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="discription")
	private String discription;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email_id",nullable=false)	
	private ProspectModel prospectModel;*/
	
	public InternshipModel() {
		super();
	}

	public InternshipModel(long id, String organizationName, String discription, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.organizationName = organizationName;
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
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
