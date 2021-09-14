package com.example.DTODemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTODemo.dto.UserLocationDTO;
import com.example.DTODemo.dto.UserLocationDTO2;
import com.example.DTODemo.entity.Location;
import com.example.DTODemo.entity.User;
import com.example.DTODemo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository, ModelMapper theModelMapper) {
		this.userRepository = theUserRepository;
		this.modelMapper = theModelMapper;
	}
	
//	@Autowired
//	private ModelMapper modelMapper;

	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> result =  userRepository.findById(id);
		
		User theUser = null;
		 if(result.isPresent()) {
			 theUser = result.get();
		 }else {
			 throw new RuntimeException("Did not found user id- "+id);
		 }
		 
		 return theUser;
	}
	
//	@Override
//	@Transactional
//	public List<Location> findById(Long id) {
//		// TODO Auto-generated method stub
//		Optional<User> result =  userRepository.findById(id);
//		
//		
//		 
//		 return result.get().getLocation();
//	}

	@Override
	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}
	
	//DTO

	@Override
	public List<UserLocationDTO> getAllUsersLocation() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		
//		return (userRepository.findAll()).stream().map(this::convertEntityToUserLocationDTO)
//		.collect(Collectors.toList());
		
		//1st Method - > Using simple converter
		
//		return(users.stream().map(user -> convertEntityToUserLocationDTO(user))
//				.collect(Collectors.toList()));
		
		//2nd Method - > Using Model Mapper
		return(users.stream().map(user -> convertEntityToUserLocationDTOUsingModelMapper(user))
				.collect(Collectors.toList()));
	}
	
	
	
	@Override
	public List<UserLocationDTO2> getAllUsersLocationUsingBMWDTO() {
		// TODO Auto-generated method stub
		
		List<User> users = userRepository.findAll();
		return(users.stream().map(user -> convertEntityToUserLocationDTOUsingBMWModelMapper(user))
				.collect(Collectors.toList()));
		
	}

	private UserLocationDTO convertEntityToUserLocationDTO(User user) {
		UserLocationDTO userlocationDTO = new UserLocationDTO();
		
		userlocationDTO.setUserId(user.getId());
		
		userlocationDTO.setUsername(user.getUsername());
		
//		userlocationDTO.setLatitude(user.getLocation().getLatitude());
		
		Location location = user.getLocation();
		
//		userlocationDTO.setLatitude(location.getLatitude());
//		
//		userlocationDTO.setLongitude(location.getLongitude());
		
		userlocationDTO.setPlace(location.getPlace());
		
		return userlocationDTO;
	}
	
	//Convert Entity to DTO using ModelMapper
	private UserLocationDTO convertEntityToUserLocationDTOUsingModelMapper(User user) {
		System.out.println("ModelMapper Check 1");
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		UserLocationDTO userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
		
		return userLocationDTO;
	}
	
	//Convert Entity to DTO using BMW ModelMapper
	
	private UserLocationDTO2 convertEntityToUserLocationDTOUsingBMWModelMapper(User user) {
		System.out.println("ModelMapper Check 2");
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		UserLocationDTO2 userLocationDTO2 = modelMapper.map(user, UserLocationDTO2.class);
		
		return userLocationDTO2;
	}
	
	
	
	
	
	

}
