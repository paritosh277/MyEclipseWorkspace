package com.streamapi.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {
	
	
	public static List<Employee> evaluateTaxUsers(String input){
		List<Employee> empList = DataBase.getEmployee();
		
		if(input.equalsIgnoreCase("tax")) {
			return empList.stream().filter(emp -> emp.getSalary()>50000).collect(Collectors.toList());
		}else {
			return empList.stream().filter(emp -> emp.getSalary()<=50000).collect(Collectors.toList());
		}
		
	
		
	}
	
	public static List<Employee> evaluateTaxUsers2(String input){
		List<Employee> empList = DataBase.getEmployee();
		
		
		
		return (input.equalsIgnoreCase("tax")) 
				? empList.stream().filter(emp -> emp.getSalary()>50000).collect(Collectors.toList())
				: empList.stream().filter(emp -> emp.getSalary()<=50000).collect(Collectors.toList());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(evaluateTaxUsers("tax"));
		System.out.println(evaluateTaxUsers2("non tax"));

	}

}
