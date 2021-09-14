package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	//Use @Inject as an experiment for entityManager

	@Override
	public List<Employee> findAll() {
		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//execute a query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return result list
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get a single employee by Id
		Employee employee = entityManager.find(Employee.class, theId);
		
		//return employee
		return employee;
	}

//	@Override
//	public void save(Employee theEmployee) {
//		// save or update the employee //if id==0 then save/insert or else update
//		Employee dbEmployee = entityManager.merge(theEmployee);
//		
//		//update with id from db....so we can get generated id for save/insert
//		dbEmployee.setId(dbEmployee.getId());
//
//	}
	
	@Override
	public Employee save(Employee theEmployee) {
		// save or update the employee //if id==0 then save/insert or else update
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db....so we can get generated id for save/insert
		dbEmployee.setId(dbEmployee.getId());
		
		return dbEmployee;

	}


	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
