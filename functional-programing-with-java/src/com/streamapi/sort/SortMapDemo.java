package com.streamapi.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<>();
		map.put("four", 4);
		map.put("eight", 8);
		map.put("ten", 10);
		map.put("seven", 7);
		
		
		map.entrySet().stream().forEach(System.out::println);
		
		System.out.println("*******************");
		
		//Sort the map using Java 8 by Key
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("*************");
		
		//Sort the map using Java 8 by value
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

	}

}
