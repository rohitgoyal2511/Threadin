package com.example.threadin.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.threadin.DTO.ProspectDTO;
import com.example.threadin.models.AddressModel;
import com.example.threadin.models.CollegeModel;
import com.example.threadin.models.InternshipModel;
import com.example.threadin.models.ProjectModel;
import com.example.threadin.models.ProspectModel;
import com.example.threadin.models.WorkDetailsModel;
import com.example.threadin.repository.CountryRepo;
import com.example.threadin.repository.ProspectRepo;

@Service
@Transactional
public class ProspectService {

	@Autowired
	private ProspectRepo prospectRepo;

	@Autowired
	private CountryRepo countryRepo;
	public ProspectModel isUserExist(ProspectModel prospect) {
		return prospectRepo.findByEmailId(prospect.getEmailId());
	}
	
	public void register(String emailId) {
		ProspectModel prospectModel = null;
		prospectModel.setEmailId(emailId);
		prospectRepo.save(prospectModel);
	}

	public ProspectModel getProspect(String email_id) {
		ProspectModel prospectModel;
		prospectModel = prospectRepo.findByEmailId(email_id);
		if(prospectModel != null) {
			if (prospectModel.getCountryCode() != null) {
				String country = countryRepo.findByNumCode(Integer.parseInt(prospectModel.getCountryCode()))
						.getNationality();
				prospectModel.setCountryCode(country);
			}
		}
		return prospectModel;
	}

	public void setProspect(ProspectDTO prospectDTO) {
		ProspectModel prospect = prospectDTO.getProspect();	
		
		if (prospectDTO.getAddress() != null) {
			Set<AddressModel> addresses = new HashSet<>();
			for (AddressModel address : prospectDTO.getAddress()) {
				//address.setProspectModel(prospect);
				addresses.add(address);	
			}
			prospect.setAddressModel(addresses);
		}
		
		if (prospectDTO.getProject() != null) {
			Set<ProjectModel> projects = new HashSet<>();
			for (ProjectModel project : prospectDTO.getProject()) {
				projects.add(project);	
			}
			prospect.setProjectModel(projects);
		}
		
		if (prospectDTO.getInternship() != null) {
			Set<InternshipModel> internships = new HashSet<>();
			for (InternshipModel internship : prospectDTO.getInternship()) {
				internships.add(internship);	
			}
			prospect.setInternshipModel(internships);
		}
		
		if(prospectDTO.getWorkDetails() != null) {
			Set<WorkDetailsModel> workDetails = new HashSet<>();
			for (WorkDetailsModel workDetail : prospectDTO.getWorkDetails()) {
				workDetails.add(workDetail);	
			}
			prospect.setWorkDetailsModel(workDetails);
		}
		
		if(prospectDTO.getColleges() != null) {
			Set<CollegeModel> colleges = new HashSet<>();
			for (CollegeModel college : prospectDTO.getColleges()) {
				colleges.add(college);
			}
			prospect.setCollegeModel(colleges);
		}		
		prospectRepo.save(prospect);
	}

	public ProspectModel updateProspect(@Valid ProspectDTO prospectDTO) {
		ProspectModel prospect = prospectDTO.getProspect();
		String email_id = prospectDTO.getProspect().getEmailId();
		ProspectModel existing = prospectRepo.findByEmailId(email_id);
		
		copyNonNullProperties(prospect, existing);
		
		existing = setProspectDepends(prospectDTO, existing);
		
		// AddressModel address = existing.getAddressModel().iterator().next();
		
		prospectRepo.save(existing);
		return existing;
	}	
	
	public static ProspectModel setProspectDepends(ProspectDTO prospectDTO, ProspectModel prospect) {

		if (prospectDTO.getAddress() != null) {				
			 prospect.getAddressModel().removeAll(prospect.getAddressModel());
			 prospect.getAddressModel().addAll(prospectDTO.getAddress());		 
		}
		
		if (prospectDTO.getProject() != null) {
			prospect.getProjectModel().removeAll(prospect.getProjectModel());
			prospect.getProjectModel().addAll(prospectDTO.getProject());
		}
		
		if (prospectDTO.getInternship() != null) {
			prospect.getInternshipModel().removeAll(prospect.getInternshipModel());
			prospect.getInternshipModel().addAll(prospectDTO.getInternship());
		}
		
		if(prospectDTO.getWorkDetails() != null) {	
			prospect.getWorkDetailsModel().removeAll(prospect.getWorkDetailsModel());
			prospect.getWorkDetailsModel().addAll(prospectDTO.getWorkDetails());
		}
		
		if(prospectDTO.getColleges() != null) {
			prospect.getCollegeModel().removeAll(prospect.getCollegeModel());
			prospect.getCollegeModel().removeAll(prospectDTO.getColleges());
		}

		return prospect;
	}
	
	public static void copyNonNullProperties(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
}
