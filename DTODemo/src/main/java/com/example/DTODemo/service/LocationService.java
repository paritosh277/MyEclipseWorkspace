package com.example.DTODemo.service;

import java.util.List;

import com.example.DTODemo.entity.Location;
import com.example.DTODemo.entity.User;

public interface LocationService {
	
	public List<Location> findAll();
	
	public Location findById(Long id);
	
	public Location save(Location location);
	
	public void deleteById(Long id);

}
