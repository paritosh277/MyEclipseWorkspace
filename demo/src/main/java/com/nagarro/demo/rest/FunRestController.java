package com.nagarro.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
//Use Shift+Ctrl+O to fix the imports 
@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World ! Time on server is"+ LocalDateTime.now();
	}

}
