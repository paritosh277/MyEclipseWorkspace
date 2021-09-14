package com.streamapi.sort;

import java.util.Comparator;

import com.streamapi.example.Employee;

public class SortBySalaryInAscending implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return (int) (e1.getSalary() - e2.getSalary());
	}

}
