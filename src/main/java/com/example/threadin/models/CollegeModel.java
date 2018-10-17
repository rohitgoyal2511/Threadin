package com.example.threadin.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colleges")
public class CollegeModel {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name="course")
	private String course;
	
	@Column(name="university")
	private String university;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	public CollegeModel() {
		super();
	}

	public CollegeModel(long id, String collegeName, String course, String university, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.course = course;
		this.university = university;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
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
