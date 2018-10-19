package com.example.threadin.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class OffersDTO {

	private String organization;
	
	private String jobTitle;
	
	private String minWorkExp;
	
	private String maxWorkExp;
	
	private String location;
	
	private String ctc;
	
	private String offerLink;
	
	@Email
	private String hrEmailId;

	public OffersDTO() {
		super();
	}

	public OffersDTO(String organization, String jobTitle, String minWorkExp, String maxWorkExp, String location,
			String ctc, String offerLink, @Email String hrEmailId) {
		super();
		this.organization = organization;
		this.jobTitle = jobTitle;
		this.minWorkExp = minWorkExp;
		this.maxWorkExp = maxWorkExp;
		this.location = location;
		this.ctc = ctc;
		this.offerLink = offerLink;
		this.hrEmailId = hrEmailId;
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

	public String getHrEmailId() {
		return hrEmailId;
	}

	public void setHrEmailId(String hrEmailId) {
		this.hrEmailId = hrEmailId;
	}
	
}
