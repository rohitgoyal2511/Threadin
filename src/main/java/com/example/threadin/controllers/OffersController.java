package com.example.threadin.controllers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.threadin.DTO.OffersDTO;
import com.example.threadin.DTO.ProspectDTO;
import com.example.threadin.models.OffersModel;
import com.example.threadin.services.OffersService;

@RestController
public class OffersController {
	
	@Autowired
	private OffersService offersService;
	
	@RequestMapping(value = "/offers",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Iterable<OffersModel>> getAllOffers(){
		Iterable<OffersModel> offersModel;
		
		offersModel = offersService.getAllOffers();
		
		return new ResponseEntity<Iterable<OffersModel>>(offersModel, HttpStatus.OK);
	}
 	
	@RequestMapping(value = "/offers/{email_id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Iterable<OffersModel>> getOffers(@PathVariable("email_id") String email_id){
		Iterable<OffersModel> offersModel;
		
		offersModel = offersService.getOffers(email_id);
		
		return new ResponseEntity<Iterable<OffersModel>>(offersModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/Offer",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> createOffer(@Valid @RequestBody OffersDTO offersDTO,BindingResult bindingResult){
				
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {			
			if(offersDTO.getHrEmailId() !=null) {
				if(offersService.isUserExist(offersDTO.getHrEmailId()) == false){
					return new ResponseEntity<>(Collections.singletonList("No such HR registered with us!!!"),
							HttpStatus.NOT_FOUND);
				}  else {
					offersService.createOffer(offersDTO);
					return new ResponseEntity<>("Created Successfully",HttpStatus.CREATED);
					}	
			}
		}
		return new ResponseEntity<>("Invalid request", HttpStatus.OK);
	}

}
