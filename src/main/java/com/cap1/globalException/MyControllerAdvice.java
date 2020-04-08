package com.cap1.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cap1.exception.IdNotFoundException;
import com.cap1.exception.IncorrectIdException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(IdNotFoundException.class) 
	public ResponseEntity<String> employeeNotFound(IdNotFoundException e){ 
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(IncorrectIdException.class)
	public ResponseEntity<String> wrongId(IncorrectIdException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
