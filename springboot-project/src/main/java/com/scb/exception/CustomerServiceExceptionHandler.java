package com.scb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scb.dto.Status;

@ControllerAdvice
public class CustomerServiceExceptionHandler {

	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<Status> handle(CustomerServiceException e) {
		//logging the exception code will be here
		Status status = new Status();
		status.setStatus(false);
		status.setMessageIfAny(e.getMessage());
		
		return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);

	}
	
	
}
