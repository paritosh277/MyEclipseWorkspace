package com.in28minutes.mockito.mockitodemo;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	//constructor dependency injection
	public SomeBusinessImpl(DataService theDataService) {
		this.dataService = theDataService;
	}
	
	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		
		int greatest = Integer.MIN_VALUE;
		
		for(int num: data) {
			if(num>greatest) {
				greatest = num;
			}
		}
		
		return greatest;
	}

}
