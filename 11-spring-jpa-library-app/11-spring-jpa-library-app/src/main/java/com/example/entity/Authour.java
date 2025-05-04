package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Authour {
	
	@Id
private int authourId;
private String name;

public Authour(int authourId, String name) {
	super();
	this.authourId = authourId;
	this.name = name;
}

public Authour(){
	
}
public int getAuthourId() {
	return authourId;
}
public void setAuthourId(int authourId) {
	this.authourId = authourId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
