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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="offers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@Column(name="min_work_exp",nullable= true)
	private String minWorkExp;
	
	@NotBlank
	@Column(name="max_work_exp", nullable= true)
	private String maxWorkExp;
	
	@Column(name="location")
	private String location;
	
	@Column(name="ctc", nullable= true)
	private String ctc;
	
	@Column(name="offer_link", nullable= true)
	private String offerLink;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hr_id",nullable=false)	
	private HRModel hrModel;

	public OffersModel() {
		super();
	}

	public OffersModel(long jobId, @NotBlank String organization, String jobTitle, @NotBlank String minWorkExp,
			@NotBlank String maxWorkExp, String location, String ctc, String offerLink, HRModel hrModel) {
		super();
		this.jobId = jobId;
		this.organization = organization;
		this.jobTitle = jobTitle;
		this.minWorkExp = minWorkExp;
		this.maxWorkExp = maxWorkExp;
		this.location = location;
		this.ctc = ctc;
		this.offerLink = offerLink;
		this.hrModel = hrModel;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMinWorkExp() {
		return minWorkExp;
	}

	public void setMinWorkExp(String minWorkExp) {
		this.minWorkExp = minWorkExp;
	}

	public String getMaxWorkExp() {
		return maxWorkExp;
	}

	public void setMaxWorkExp(String maxWorkExp) {
		this.maxWorkExp = maxWorkExp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getOfferLink() {
		return offerLink;
	}

	public void setOfferLink(String offerLink) {
		this.offerLink = offerLink;
	}
	
	@JsonIgnore
	public HRModel getHrModel() {
		return hrModel;
	}

	public void setHrModel(HRModel hrModel) {
		this.hrModel = hrModel;
	}
	
}
