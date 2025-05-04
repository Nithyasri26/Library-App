package com.example.advice;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<String> handle(Exception e) {
		System.out.println("Exception handled...");
		return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
 
