package com.example.threadin.DTO;

public class AddressDTO {

	private String houseNo;
	
	private String city;
	
	private String district;
	
	private String pincode;
	
	private int addressType;
	
	private String emailId;

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

	public int getAddressType() {
		return addressType;
	}

	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
