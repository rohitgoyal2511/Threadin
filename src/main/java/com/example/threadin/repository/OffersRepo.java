package com.example.threadin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.threadin.models.OffersModel;

@Repository
public interface OffersRepo extends CrudRepository<OffersModel, Long> {

}
