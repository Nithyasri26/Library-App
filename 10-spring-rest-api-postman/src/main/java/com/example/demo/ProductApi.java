package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.pkg.ProductService;
@RestController
@RequestMapping("/products")
public class ProductApi {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/test")
//	@ResponseBody
	
	public String testApi() {
		System.out.println("hello");
		return "<font color=red size=20>HAD UR LUNCH?</font>";
	}
	@GetMapping("/sample")
	public Product sampleProduct() {
		return new Product(101,"pen",50, LocalDate.of(2025, 4,9));
		
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return service.allProducts();
		
	}
	@GetMapping("/{prodId}")
	public Product searchById(@PathVariable("prodId") int pid) {
		List<Product> products=service.allProducts();
		return products.stream().filter(p->p.getPid()==pid).findFirst().orElse(null);
		
	}
	@PostMapping
	public Product addNewProduct(@RequestBody Product p) {
		List<Product> products=service.allProducts();
		products.add(p);
		return p;
	}
	
	}


