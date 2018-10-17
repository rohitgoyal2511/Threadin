package com.example.threadin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressModel {
	
	public enum AddressType{
		PERMANENT (0), PRESENT (1);
		
		private int value;
		
		AddressType(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		public void setValue(int value){
			this.value = value;
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="house_no")
	private String houseNo;
	
	@Column(name="city")
	private String city;
	
	@Column(name="district")
	private String district;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="type_of_address")
	
	private AddressType addressType;

	public AddressModel() {
		super();
	}

	public AddressModel(long id, String houseNo, String city, String district, String pincode, AddressType addressType){
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.city = city;
		this.district = district;
		this.pincode = pincode;
		this.addressType = addressType;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}
