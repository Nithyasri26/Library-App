package com.cg.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	private String ifscCode;
	private String bankName;
	private String branch;
	@OneToMany(mappedBy="bank", fetch = FetchType.LAZY) //default it only loads the necessary details, this one is recommended to use
	//@OneToMany(mappedBy="bank, fetch=FetchType.EARLY) // it loads every details
	private List<BankCustomer> customer;
	
	public List<BankCustomer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<BankCustomer> customer) {
		this.customer = customer;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	

}
