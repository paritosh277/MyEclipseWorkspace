package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	
	//This is Constructor based dependency injection
	//Helps in preventing NullPointerExceptions
	//Preventing errors in tests and simplifies writing unit tests
	
	//@Autowired annotation on setter methods to get rid of the <property> element in XML configuration file.
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

//	@Override
//	@Transactional
//	public void save(Employee theEmployee) {
//		// TODO Auto-generated method stub
//		employeeDAO.save(theEmployee);
//
//	}
	
	
	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.save(theEmployee);
		return employee;

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);

	}

}
