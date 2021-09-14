package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

//https://github.com/in28minutes/spring-master-class/blob/master/00-framework-tool-introductions
//	/04.Mockito-Introduction-In-5-Steps/src/test/java/com/in28minutes/mockito/mockitodemo/ListTest.java
//github link

public class SomeBusinessMockTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		
		int result = businessImpl.findTheGreatestFromAllData();
		
		assertEquals(24, result);
	}
	
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}

}
