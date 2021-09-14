package com.example.demo.dao;


import com.example.demo.entity.User;

public interface UserDAO {
	
	public User save(User theUser);
	
	public User findByUsername(String username);

}
