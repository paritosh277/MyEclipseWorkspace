package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2);
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, list.size());
		assertEquals(3, list.size());
		
	}

}
