package com.dailycodebuffer.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.userservice.VO.Department;
import com.dailycodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailycodebuffer.userservice.entity.User;
import com.dailycodebuffer.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		System.out.println(user);
		//To get a department there is a another microservice so we need to call the
		//department microservice and get the department object from there
		
		//http://localhost:9002/api/departments/
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/departments/"+
		user.getDepartmentId(), Department.class);
		
		System.out.println(department);
		
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
