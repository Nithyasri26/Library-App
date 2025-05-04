package com.cg.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
	@Id
	private int empId;
	private String empName;
	@Embedded
	private Address address;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
