package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {

	
	private int pid;
	private String prodName;
	private float price;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate manufactureDate;
	
	public Product(int pid, String prodName, float price, LocalDate manufactureDate) {
		super();
		this.pid = pid;
		this.prodName = prodName;
		this.price = price;
		this.manufactureDate = manufactureDate;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	
}
