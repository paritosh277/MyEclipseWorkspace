package com.example.DTODemo.service;

import java.util.List;

import com.example.DTODemo.dto.UserLocationDTO;
import com.example.DTODemo.dto.UserLocationDTO2;
import com.example.DTODemo.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
	
	
	
	//DTO
	public List<UserLocationDTO> getAllUsersLocation();
	
	//DTO - BMW
	public List<UserLocationDTO2> getAllUsersLocationUsingBMWDTO();

}
