package com.example.demo.pkg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;

@Component
public class ProductService {
	
	List<Product> products=new ArrayList<>();
	
	{
	products.add(new Product(101,"pen",20, LocalDate.of(2025,2,1)));
	products.add(new Product(102,"bottle",30, LocalDate.of(2025,4,3)));
	products.add(new Product(103,"Airpods",50, LocalDate.of(2025,9,5)));
	products.add(new Product(104,"phone",70, LocalDate.of(2025,5,1)));
	products.add(new Product(105,"whiteboard",90, LocalDate.of(2025,2,8)));
	}	
	
	public List<Product> allProducts(){
		return products;
		
	}

}
