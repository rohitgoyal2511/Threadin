package com.example.threadin.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="offers")
public class OffersModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_id")
	private long jobId;
	
	@NotBlank
	@Column(name="organization")
	private String organization;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@NotBlank
	@Column(name="work_exp")
	private String workExp;
	
	@Column(name="location")
	private String location;
	
	@Column(name="ctc")
	private String ctc;
	
	@Column(name="offer_link")
	private String offerLink;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email_id",nullable=false)	
	private HRModel hrModel;
	
	
}
