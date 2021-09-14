package com.streamapi.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//primitive DataType
		List<Integer> list = new ArrayList<>(); 
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);
		
		System.out.println("List "+ list);
		System.out.println("TRADITIONAL WAY TO SORT A LIST IN ASCENDING ORDER");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("TRADITIONAL WAY TO SORT A LIST IN DESCENDING ORDER BY "
				+ "REVERSING THE ASCENDING ORDER LIST USING Collections.reverse()");
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("****ASCENDING STREAM********");
		
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("****DESCENDING STREAM********");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		

	}

}
