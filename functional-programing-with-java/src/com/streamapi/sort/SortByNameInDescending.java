package com.streamapi.sort;

import java.util.Comparator;

import com.streamapi.example.Employee;

public class SortByNameInDescending implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e2.getName().compareTo(e1.getName());
	}

}
