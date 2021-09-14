package com.streamapi.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.streamapi.example.DataBase;
import com.streamapi.example.Employee;

//Sort a list using Lambda

public class SortListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Customized Data Type
		
		List<Employee> empList = DataBase.getEmployee();
		
		System.out.println("Sort Employee List in Ascending Order on salary basis");
		
//		Collections.sort(empList, new SortBySalaryInAscending());
		
		Collections.sort(empList, (e1,e2) -> (int) (e1.getSalary()-e2.getSalary()));
		
		System.out.println(empList);
		
		System.out.println("Sort Employee List in Descending Order on name basis");
		
		Collections.sort(empList, new SortByNameInDescending());
		
		System.out.println(empList);
		
		System.out.println("Sort Employee List in Ascending Order on Department basis");
		
		Collections.sort(empList, new SortByDeptInAscending());
		
		System.out.println(empList);
		
		
		System.out.println("****************SORT A LIST USING LAMBDA************");
		
		System.out.println("ASCENDING SALARY BASIS METHOD 1");
		
		empList.stream().sorted(Comparator.comparing(emp -> emp.getSalary()))
		.forEach(System.out::println);
		
		System.out.println("DESCENDING SALARY BASIS METHOD 2");
		
		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
		.forEach(System.out::println);
		
		System.out.println("ASCENDING DEPT BASIS METHOD 2");
		
		empList.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);

	}

}



