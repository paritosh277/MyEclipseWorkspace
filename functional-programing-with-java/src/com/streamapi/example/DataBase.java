package com.streamapi.example;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	public static List<Employee> getEmployee(){
		List<Employee> empList = new ArrayList();
		
		empList.add(new Employee(1, "Rohit", "CSE", 66000));
		empList.add(new Employee(2, "Kishan", "IT", 90000));
		empList.add(new Employee(3, "Pandya", "COA", 50000));
		empList.add(new Employee(4, "Surya", "ML", 40000));
		empList.add(new Employee(5, "Boult", "AI", 12000));
		
		return empList;
	}

}
