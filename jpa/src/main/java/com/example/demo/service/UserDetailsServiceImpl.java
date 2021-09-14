package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("UserDetailsServiceImpl");
		User user = userDAO.findByUsername(username);
		System.out.println("UserDetailsServiceImpl 2");
//		System.out.println(user);
		
		CustomUserDetails userDetails = null;
		
		if(user != null) {
//			userDetails = new CustomUserDetails(user);
			
			System.out.println("UserDetailsServiceImpl 3");
			
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		}else {
			
			System.out.println("UserDetailsServiceImpl 4");
			throw new UsernameNotFoundException("User not exist with name : "+ username);
		}
		
		return  userDetails;
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		System.out.println("UserDetailsServiceImpl");
//		User user = userRepository.findByUsername(username);
//		System.out.println("UserDetailsServiceImpl 2");
////		System.out.println(user);
//		System.out.println("UserDetailsServiceImpl 2.1");
//		
//		CustomUserDetails userDetails = null;
//		System.out.println("UserDetailsServiceImpl 2.2");
//		
//		if(user != null) {
////			userDetails = new CustomUserDetails(user);
//			
//			System.out.println("UserDetailsServiceImpl 3");
//			
//			userDetails = new CustomUserDetails();
//			userDetails.setUser(user);
////			System.out.println(userDetails.getUser());
//		}else {
//			
//			System.out.println("UserDetailsServiceImpl 4");
//			throw new UsernameNotFoundException("User not exist with name : "+ username);
//		}
//		
//		return  userDetails;
//	}
	
	
	

}
