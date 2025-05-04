package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {
    @Autowired
	private Environment env;
	
	List<Product> products=new ArrayList<>();
	
	public List<Product> allProducts(){
		
		String port=env.getProperty("local.server.port");
		
		products.add(new Product(111,"Dosa",120,port));
		products.add(new Product(102,"Burger",170,port));
		products.add(new Product(103,"Meals",220,port));
		products.add(new Product(104,"Biriyani",300,port));
		products.add(new Product(105,"FriedRice",250,port));
		return products;
	}
}
