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
import com.example.threadin.models.ProspectModel;
import com.example.threadin.services.ProspectService;

@RestController
public class ProspectController {

	@Autowired
	private ProspectService prospectService;
	
	@RequestMapping(value="/Prospect/{email_id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ProspectModel> getProspect(@PathVariable("email_id") String email_id){
		ProspectModel prospect = new ProspectModel();
		prospect = prospectService.getProspect(email_id);
		if(prospect != null)
				return new ResponseEntity<>(prospect,HttpStatus.OK);
		else
			return new ResponseEntity<>(prospect,HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(value="/Prospect",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> setProspect(@Valid @RequestBody ProspectDTO prospectDTO,BindingResult bindingResult){
				
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {			
			if(prospectDTO.getProspect() !=null) {
				if(prospectService.isUserExist(prospectDTO.getProspect()) !=null){
					return new ResponseEntity<>(Collections.singletonList("Email address already registered with us"),
							HttpStatus.CONFLICT);
				}  else {
						prospectService.setProspect(prospectDTO);
						return new ResponseEntity<>("Created Successfully",HttpStatus.CREATED);
					}	
			}
		}
		return new ResponseEntity<>("Invalid request", HttpStatus.OK);
	}
	
	@RequestMapping(value="/Prospect",method=RequestMethod.PUT)
	@ResponseBody
	public  ResponseEntity<Object> updateProspect(@Valid @RequestBody ProspectDTO prospectDTO,BindingResult bindingResult){
				
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {			
			if(prospectDTO.getProspect() !=null) {
				if(prospectService.isUserExist(prospectDTO.getProspect()) ==null){
					return new ResponseEntity<>(Collections.singletonList("Email Address not register with us!!!"),
							HttpStatus.NOT_FOUND);
				}  else {
						prospectService.updateProspect(prospectDTO);
						return new ResponseEntity<>("updated Successfully",HttpStatus.CREATED);
					}	
			}
		}
		return new ResponseEntity<>("Invalid request", HttpStatus.OK);
	}
	
	
	
	/*@RequestMapping(value="/Address",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> setAddress(@Valid @RequestBody AddressModel address,BindingResult bindingResult){
					prospectService.setAddress(address);
					return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/Project",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> setProject(@Valid @RequestBody ProjectModel project,BindingResult bindingResult){
					prospectService.setProject(project);
					return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/Internship",method=RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> setInternship(@Valid @RequestBody InternshipModel internship,BindingResult bindingResult){
					prospectService.setInternship(internship);
					return new ResponseEntity<>(HttpStatus.CREATED);
	}
	*/
	
}
