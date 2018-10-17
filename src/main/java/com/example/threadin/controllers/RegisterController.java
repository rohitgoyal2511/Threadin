/*package com.example.threadin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.threadin.DTO.UsersDTO;
import com.example.threadin.services.ProspectService;
import com.example.threadin.services.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private ProspectService prospectService;
	
	public ResponseEntity<Object> register(@Valid @RequestBody UsersDTO userDTO){
		
		if (userDTO != null) {
			if(registerService.isUserExist(userDTO.getEmailId()) == true) {
				return new ResponseEntity<>("Email id already exists", HttpStatus.CONFLICT);
			} else if("HR".equalsIgnoreCase(userDTO.getUserType())) {
			} else {
				prospectService.register(userDTO.getEmailId());
			}
		}
		return new ResponseEntity<>("Not a valid request", HttpStatus.BAD_REQUEST);
	}
}
*/