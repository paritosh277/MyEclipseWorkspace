package com.streamapi.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.streamapi.example.Employee;

public class SortMapDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Employee, Integer> employeeMap = new HashMap<>();
		
		employeeMap.put(new Employee(176, "Hrithik", "CSE", 60000), 60);
		
		employeeMap.put(new Employee(388, "Bikash", "AI", 30000), 70);
		
		employeeMap.put(new Employee(255, "Aamir", "DA", 89000), 50);
		
		employeeMap.put(new Employee(420, "Salman", "IT", 40000), 90);
		
		System.out.println(employeeMap);
		
		System.out.println("Sort the employeeMap by key by salary in ascending");
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing
				(Employee :: getSalary))).forEach(System.out::println);
		
		System.out.println("Sort the employeeMap by key by name in descending");
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing
				(Employee :: getName).reversed())).forEach(System.out::println);
		
		

	}

}
