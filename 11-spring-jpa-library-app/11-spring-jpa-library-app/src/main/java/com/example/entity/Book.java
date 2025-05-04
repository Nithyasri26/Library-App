package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue
private int bookId;
	
private String bookName;
@Enumerated(EnumType.STRING)
private Genre genre;
private float cost;
private int stock;


public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public Genre getGenre() {
	return genre;
}
public void setGenre(Genre genre) {
	this.genre = genre;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public Authour getAuthour() {
	return authour;
}
public void setAuthour(Authour authour) {
	this.authour = authour;
}
@ManyToOne
@JoinColumn(name="authourId")
private Authour authour;
public Book(){
	
}

 }
