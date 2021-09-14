package com.example.demo.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	private UserService userService;
	
	@Autowired
	public void AdminController(UserService theUserService) {
		userService = theUserService;
	}
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/admin/add")
	public ResponseEntity<String> addUserByAdmin(@RequestBody User theUser) {
		
		theUser.setId(0);
		
		String pwd = theUser.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		theUser.setPassword(encryptPwd);
		User savedUser = userService.save(theUser);
		
		return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);

	}

}
