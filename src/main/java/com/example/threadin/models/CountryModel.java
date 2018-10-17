package com.example.threadin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "num_code")
	private int numCode;
	
	@Column(name = "alpha_2_code")
	private String alpha2Code;
	
	@Column(name = "alpha_3_code")
	private String alpha3Code;
	
	@Column(name = "en_short_name")
	private String enShortName;
	
	@Column(name = "nationality")
	private String nationality;

	public CountryModel() {
		super();
	}

	public CountryModel(long id, int numCode, String alpha2Code, String alpha3Code, String enShortName,
			String nationality) {
		super();
		this.id = id;
		this.numCode = numCode;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
		this.enShortName = enShortName;
		this.nationality = nationality;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumCode() {
		return numCode;
	}

	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public String getEnShortName() {
		return enShortName;
	}

	public void setEnShortName(String enShortName) {
		this.enShortName = enShortName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}	
}
