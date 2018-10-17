package com.example.threadin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.threadin.models.CountryModel;

@Repository
public interface CountryRepo extends JpaRepository<CountryModel, Long>{

	CountryModel findByNumCode(int numcode);
}
