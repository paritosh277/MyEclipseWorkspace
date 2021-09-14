package com.example.DTODemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTODemo.entity.Location;
import com.example.DTODemo.repository.LocationRepository;
import com.example.DTODemo.repository.UserRepository;


@Service
public class LocationServiceImpl implements LocationService {
	
	private LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImpl(LocationRepository thelocationRepository) {
		this.locationRepository = thelocationRepository;
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Location findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
