package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductApi {
	@Autowired
	private ProductService service;
	
	@GetMapping("/{id}")
	public Product searchById(@PathVariable int id) {
		return service.allProducts().stream().filter(p->p.getProdId()==id).findFirst().get();
	}

}
