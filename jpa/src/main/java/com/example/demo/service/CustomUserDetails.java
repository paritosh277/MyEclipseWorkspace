package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;


//May be yeh DTO ho

public class CustomUserDetails<SimpleGrantedAuthorities> implements UserDetails {
	
	private User user;
	
	
	
	

//	public CustomUserDetails(User user) {
//		this.user = user;
//	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
////		return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
////				.collect(Collectors.toList());
//		
//		
//		Set<Role> roles = user.getRoles();
//		List<SimpleGrantedAuthorities> authorities = new ArrayList<>();
//		
//		for(Role role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//		
//		return authorities;
//	}
	
	
	public CustomUserDetails() {
		
	}
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}
	
	

	

	@Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	        Set<Role> roles = user.getRoles();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	         
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	         
	        return authorities;
	  }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isEnabled();
	}

}
