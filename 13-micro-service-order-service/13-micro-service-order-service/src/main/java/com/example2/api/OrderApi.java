package com.example2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example2.Order;
import com.example2.proxy.ProductApiProxy;

@RestController
@RequestMapping("/orders")
public class OrderApi {

@PostMapping("/{id}/{q}")	
public Order orderProduct(@PathVariable int id ,@PathVariable("q") int quantity) {
	
String url="http://localhost:8000/products/"+id;
RestTemplate template=new RestTemplate();
Order order=template.getForObject(url, Order.class);
order.setQuantity(quantity);
order.setPrice(order.getPrice()*quantity);
return order;
}

@Autowired
private ProductApiProxy proxy;

@PostMapping("/feign/{id}/{q}")
public Order orderProductFeign(@PathVariable int id,@PathVariable("q")  int quantity ){
	
	Order order=proxy.orderProduct(id);
	order.setQuantity(quantity);
	order.setPrice(order.getPrice()*quantity);
	return order;
	
}

	
	
}
