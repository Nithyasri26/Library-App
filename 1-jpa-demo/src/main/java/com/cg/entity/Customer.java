package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
@Table(name="Customer_detais")  //optional
@Entity
public class Customer {
	@Id

	
	private int CustId;
	@Column(name="name", length=45) //optional
	private String custName;
	private String address;
	
	@Column(name="contactNo",unique=true) //optional
	private long phno;
	
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
