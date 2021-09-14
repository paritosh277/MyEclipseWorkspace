package com.example.DTODemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTODemo.dto.UserLocationDTO;
import com.example.DTODemo.dto.UserLocationDTO2;
import com.example.DTODemo.entity.Location;
import com.example.DTODemo.entity.User;
import com.example.DTODemo.service.LocationService;
import com.example.DTODemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserDetailsController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;
	
//	@Autowired
//	public  UserDetailsController(UserService theUserService) {
//		this.userService = theUserService;
//	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		System.out.println(userService.findAll());
		
		//Note -> This will give only user details. no location details
		return userService.findAll();
	}
	
	
	//DTO*************************************************************************************
	
	@GetMapping("/userslocDTO")
	public List<UserLocationDTO> getAllUsersLocation(){
		return userService.getAllUsersLocation();
	}
	
	
	//DTO 2ndMethod BMW ***********************************************************************
	
	@GetMapping("/userslocDTOBMW")
	public List<UserLocationDTO2> getAllUsersLocationUsingBMWDTO(){
		return userService.getAllUsersLocationUsingBMWDTO();
	}
	
	@GetMapping("/locations")
	public List<Location> findAllLocations(){
		
		//Note -> This will give location and user details.
		
		return locationService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable Long userId) {
		User theUser =  userService.findById(userId);
		
		if(theUser==null) {
			throw new RuntimeException("User Id Not found "+ userId);
		}
		
		return theUser;
	}

}
