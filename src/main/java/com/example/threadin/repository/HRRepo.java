package com.example.threadin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.threadin.models.HRModel;

@Repository
public interface HRRepo extends CrudRepository<HRModel, Long> {
	
	 HRModel findByEmailId(String email_id);
	 
	 boolean existsByEmailId(String email_id);
}
