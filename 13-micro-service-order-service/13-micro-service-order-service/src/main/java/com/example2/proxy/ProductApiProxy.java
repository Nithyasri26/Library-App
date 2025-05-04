package com.example2.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example2.Order;

@FeignClient(name="x", url="http://localhost:8000")
public interface ProductApiProxy {
	@GetMapping("/products/{id}")
	Order orderProduct(@PathVariable int id);

}
