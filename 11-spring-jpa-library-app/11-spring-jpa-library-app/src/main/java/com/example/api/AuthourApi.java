package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Authour;
import com.example.entity.Book;
import com.example.service.AuthourService;

@RestController
@RequestMapping("/authours")
public class AuthourApi {
	@Autowired
	private AuthourService authourService;
	@PostMapping
	public  ResponseEntity<Authour> addAuthour( @RequestBody Authour a){
		return new ResponseEntity<Authour>( authourService.addAuthourService(a), HttpStatus.CREATED) ;
	}
	
	@GetMapping
	public List<Authour> allAuthours( ){
		return authourService.allAuthoursService();
	}
	@GetMapping("/{id}")
	public Authour searchById( @PathVariable("id") int id){
		return authourService.searchByIdService(id);
	}
	@GetMapping("/search")
	public ResponseEntity<List<Authour>>  searchByAuthourName(@RequestParam("name") String name ){
		List<Authour> list=authourService.searchByAuthourNameService(name);
	   if(list.size()!=0)
		   return new ResponseEntity<>(list, HttpStatus.OK);
	   else
		   return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/searchBooks/{authourId}")
	public List<Book> findByAuthour(@PathVariable("authourId") int authourId){
		 return authourService.findByAuthourService(authourId);

	}
}
