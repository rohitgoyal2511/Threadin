package com.example.threadin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.threadin.models.ProspectModel;

@Repository
public interface ProspectRepo extends CrudRepository<ProspectModel, Long>{
	
	ProspectModel findByEmailId(String email_id);

}
