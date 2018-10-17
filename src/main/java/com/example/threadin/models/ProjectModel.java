package com.example.threadin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="projects")
public class ProjectModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="discription")
	@Size(min=200,max=1000)
	private String discription;

	public ProjectModel() {
		super();
	}

	public ProjectModel(long id, String title, @Size(min = 200, max = 1000) String discription) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}	
}
