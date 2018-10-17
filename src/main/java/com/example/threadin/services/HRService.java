package com.example.threadin.services;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.threadin.models.HRModel;
import com.example.threadin.repository.HRRepo;	

@Service
public class HRService {
	
	@Autowired
	private HRRepo hrRepo;
	
	public boolean isUserExist(String email_id) {
		return hrRepo.existsByEmailId(email_id);
	}

	public HRModel getHR(String email_id) {
		return hrRepo.findByEmailId(email_id);
	}

	public void setHR(HRModel hr) {
		hrRepo.save(hr);
	}

	public void updateHR(@Valid HRModel hr) {
		HRModel existing = hrRepo.findByEmailId(hr.getEmailId());
		copyNonNullProperties(hr, existing);
		hrRepo.save(existing);
		
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
