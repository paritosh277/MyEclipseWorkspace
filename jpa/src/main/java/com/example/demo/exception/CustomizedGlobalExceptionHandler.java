package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestController is the base annotation for classes that handle REST operations.

//@ControllerAdvice - It handles exceptions globally. It allows you to use the same ExceptionHandler
//for multiple controllers

//@ExceptionHandler - Spring Annotation that provides a mechanism to treat exceptions that are thrown
//during execution of handlers (Controller Operations).

//Spring Boot's built in exception class ResponseEntityExceptionHandler has multiple methods 
//that you can override to customize the exception handling further.


@RestController
@ControllerAdvice
public class CustomizedGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	//Handling Global Exception
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//Handling Specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, 
			WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().getFieldError().getDefaultMessage());
		
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
//				ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> customValidationErrorHandling(MethodArgumentNotValidException ex){
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
//				ex.getBindingResult().getFieldError().getDefaultMessage());
//		
//
//		
//		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
//	}
	
}
