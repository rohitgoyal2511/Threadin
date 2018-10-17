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

import com.example.threadin.DTO.ProspectDTO;
import com.example.threadin.models.HRModel;
import com.example.threadin.services.HRService;


@RestController
public class HRController {
	
	@Autowired
	private HRService hrService;
	
	@RequestMapping(value="/HR/{email_id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HRModel> getHR(@PathVariable("email_id") String email_id){
		HRModel hr = new HRModel();
		 hr = hrService.getHR(email_id);
		if(hr != null)
				return new ResponseEntity<>(hr,HttpStatus.OK);
		else
			return new ResponseEntity<>(hr,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/HR",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> setHR(@Valid @RequestBody HRModel hr,BindingResult bindingResult){
				
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {			
			if(hr.getEmailId() !=null) {
				if(hrService.isUserExist(hr.getEmailId()) == true){
					return new ResponseEntity<>(Collections.singletonList("Email address already registered with us"),
							HttpStatus.CONFLICT);
				}  else {
						hrService.setHR(hr);
						return new ResponseEntity<>("Created Successfully",HttpStatus.CREATED);
					}	
			}
		}
		return new ResponseEntity<>("Invalid request", HttpStatus.OK);
	}
	
	@RequestMapping(value="/HR",method=RequestMethod.PUT)
	@ResponseBody
	public  ResponseEntity<Object> updateHR(@Valid @RequestBody HRModel hr,BindingResult bindingResult){
				
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {	
			if(hr.getEmailId() !=null) {
				if(hrService.isUserExist(hr.getEmailId()) == false){
					return new ResponseEntity<>(Collections.singletonList("Email Address not register with us!!!"),
							HttpStatus.NOT_FOUND);
				}  else {
						hrService.updateHR(hr);
						return new ResponseEntity<>("updated Successfully",HttpStatus.CREATED);
					}	
			}
		return new ResponseEntity<>("Invalid request", HttpStatus.OK);
		}
	}

}
