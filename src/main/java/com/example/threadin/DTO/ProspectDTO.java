package com.example.threadin.DTO;

import java.util.Set;

import com.example.threadin.models.AddressModel;
import com.example.threadin.models.CollegeModel;
import com.example.threadin.models.InternshipModel;
import com.example.threadin.models.ProjectModel;
import com.example.threadin.models.ProspectModel;
import com.example.threadin.models.WorkDetailsModel;

public class ProspectDTO {
	
	private ProspectModel prospect;
	
	private Set<AddressModel> address;
	
	private Set<ProjectModel> project;
	
	private Set<InternshipModel> internship;
	
	private Set<WorkDetailsModel> workDetails;
	
	private Set<CollegeModel> colleges;

	public ProspectDTO() {
		super();
	}

	public ProspectDTO(ProspectModel prospect, Set<AddressModel> address, Set<ProjectModel> project,
			Set<InternshipModel> internship, Set<WorkDetailsModel> workDetails, Set<CollegeModel> colleges) {
		super();
		this.prospect = prospect;
		this.address = address;
		this.project = project;
		this.internship = internship;
		this.workDetails = workDetails;
		this.colleges = colleges;
	}

	public ProspectModel getProspect() {
		return prospect;
	}

	public void setProspect(ProspectModel prospect) {
		this.prospect = prospect;
	}

	public Set<AddressModel> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressModel> address) {
		this.address = address;
	}

	public Set<ProjectModel> getProject() {
		return project;
	}

	public void setProject(Set<ProjectModel> project) {
		this.project = project;
	}

	public Set<InternshipModel> getInternship() {
		return internship;
	}

	public void setInternship(Set<InternshipModel> internship) {
		this.internship = internship;
	}

	public Set<WorkDetailsModel> getWorkDetails() {
		return workDetails;
	}

	public void setWorkDetails(Set<WorkDetailsModel> workDetails) {
		this.workDetails = workDetails;
	}

	public Set<CollegeModel> getColleges() {
		return colleges;
	}

	public void setColleges(Set<CollegeModel> colleges) {
		this.colleges = colleges;
	}
	
	}
