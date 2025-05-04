package com.cg.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class Address {
	
	private String doorNo;
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getPlaceName() {
		return placeName;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", placeName=" + placeName + ", pincode=" + pincode + "]";
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	private String placeName;
	private int pincode;
	

}
