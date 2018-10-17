/*package com.example.threadin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.threadin.DTO.UsersDTO;
import com.example.threadin.models.UsersModel;
import com.example.threadin.repository.RegisterRepo;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepo registerRepo;
	
	public boolean isUserExist(String emailId) {
		return registerRepo.existsByEmailId(emailId);
	}
	
	public void register(UsersDTO userDTO){
		UsersModel user = null;
		user.setEmail_id(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());
		user.setStatus(userDTO.isStatus());
		user.setUserType(userDTO.getUserType());
		registerRepo.save(user);
	}


}
*/