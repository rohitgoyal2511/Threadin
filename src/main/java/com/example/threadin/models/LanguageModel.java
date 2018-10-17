package com.example.threadin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class LanguageModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="language")
	private String language;
	
	public LanguageModel() {
		super();
	}

	public LanguageModel(long id, String code, String language) {
		super();
		this.id = id;
		this.code = code;
		this.language = language;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
