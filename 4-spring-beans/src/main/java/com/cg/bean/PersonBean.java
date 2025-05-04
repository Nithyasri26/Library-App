package com.cg.bean;

public class PersonBean {
	private String name;
	private String address;
	
	public PersonBean(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
public void display() {
	System.out.println(name+" "+address);
}

}
