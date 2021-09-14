package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public void EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
//	@GetMapping("/employees/{employeeId}")
//	public Employee getEmployee(@PathVariable int employeeId) {
//		Employee theEmployee =  employeeService.findById(employeeId);
//		
//		if(theEmployee == null) {
//			throw new RuntimeException("Employee Id Not Found- "+ employeeId );
//		}
//		
//		return theEmployee;
//	}
	
	@GetMapping("/employees/{employeeId}")
	@ApiOperation(value = "Find Employee By Id",
		notes = "Provide an employee id to find specific employee",
		response = Employee.class)
	public Employee getEmployee(@ApiParam(value = "employeeID value for the employee you need to retrieve", required = true)
		@PathVariable int employeeId) {
		Employee theEmployee =  employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new ResourceNotFoundException("Employee Id Not Found- "+ employeeId );
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	//@PostMapping("/employees")
	//public Employee addEmployee(@RequestBody Employee theEmployee) {
		//If user pass an id in JSON....then set id to 0
		//this is to force a save of new item instead of update
		
		//theEmployee.setId(0);
		//employeeService.save(theEmployee);
		
		//return theEmployee;
	//}
	
	
	//@Valid annotation -> Spring boot REST API validation
	
	//Earlier 200 status code was returned, now 201
	
	//Enhancing POST Method to return correct HTTP Status code and location.
	@PostMapping("/addemployees")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee theEmployee) {
		//If user pass an id in JSON....then set id to 0
		//this is to force a save of new item instead of update
		
		theEmployee.setId(0);
		Employee savedEmployee = employeeService.save(theEmployee);
		
		
		// Uri of the new resource we have created
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{employeeId}")
				.buildAndExpand(savedEmployee.getId()).toUri();
		
		
		
		return ResponseEntity.created(location).build();
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee) ;
 //return Response.status(Response.Status.CREATED).entity("Data Population for " + populateDataProcessType + " process successfully initiated.")
                //.type(MediaType.TEXT_PLAIN).build();
	}
	
	
	// add mapping for PUT /employees - update existing employee
	@PutMapping("/updateemployees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/deleteemployees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee Id Not Found- "+ employeeId );
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	
}
