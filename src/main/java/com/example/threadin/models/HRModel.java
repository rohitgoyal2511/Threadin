package com.example.threadin.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="hr")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HRModel extends AuditModel {

	 enum Gender{
			MALE (0), FEMALE (1), OTHER (2);
			
			private int value;
			
			Gender(int value) {
				this.value = value;
			}
			
			public int getValue(){
				return value;
			}
		}
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	 
	@Email
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="dob")
	@Past
	private Date dob;
	
	@Column(name = "mobile_no")
	private String[] mobile;
	
	@Column(name="profile_pic")
	private byte[] pic;
	
	@NotBlank
	@Column(name="organization")
	private String organization;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="about_us_link")
	private String aboutUs;

	public HRModel() {
		super();
	}

	public HRModel(long id, String name, @Email String emailId, Gender gender, Date dob, String[] mobile, byte[] pic,
			@NotBlank String organization, String designation, String aboutUs) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.pic = pic;
		this.organization = organization;
		this.designation = designation;
		this.aboutUs = aboutUs;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String[] getMobile() {
		return mobile;
	}

	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
}
