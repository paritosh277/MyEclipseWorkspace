package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Implemention Exception Handling - 404 Resource Not Found

//@ResponseStatus -> Our error responses are always giving us the HTTP status 500 instead of a more
//descriptive status code. To address this we can annotate our Exception with @ResponseStatus
//and pass in the desired HTTP response status.

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
