package com.example.threadin.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.threadin.DTO.OffersDTO;
import com.example.threadin.models.HRModel;
import com.example.threadin.models.OffersModel;
import com.example.threadin.repository.HRRepo;
import com.example.threadin.repository.OffersRepo;

@Service
public class OffersService {
	
	@Autowired
	private OffersRepo offersRepo;
	
	@Autowired
	private HRRepo hrRepo;

	public boolean isUserExist(String hrEmailId) {
		return hrRepo.existsByEmailId(hrEmailId);
	}
	
	public Iterable<OffersModel> getAllOffers() {
		return offersRepo.findAll();
	}
	
	public Iterable<OffersModel> getOffers(String email_id) {
		return hrRepo.findByEmailId(email_id).getOffers();
	}

	public void createOffer(@Valid OffersDTO offersDTO) {
		OffersModel offer=new OffersModel();
		
		String hrEmailId = offersDTO.getHrEmailId();
		HRModel hr = hrRepo.findByEmailId(hrEmailId);
		
		offer.setJobTitle(offersDTO.getJobTitle());
		offer.setLocation(offersDTO.getLocation());
		offer.setOfferLink(offersDTO.getOfferLink());
		offer.setOrganization(offersDTO.getOrganization());
		offer.setMinWorkExp(offersDTO.getMinWorkExp());
		offer.setMaxWorkExp(offersDTO.getMaxWorkExp());
		offer.setCtc(offersDTO.getCtc());
		offer.setHrModel(hr);
		
		offersRepo.save(offer);		
	}

	



	
}
