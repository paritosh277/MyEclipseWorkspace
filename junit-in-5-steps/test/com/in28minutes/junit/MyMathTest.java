package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {

	//assetEquals, assertTrue, assertFalse, assertNull, assertNotNull, assertArrayEquals
	
	
//	The code marked @Before is executed before each test, 
//	while @BeforeClass runs once before the entire test fixture. 
//	If your test class has ten tests, @Before code will be executed ten times,
//	but @BeforeClass will be executed only once.
	
//	@Before -> Execute before each test method. Used with non-static method.
//	@BeforeClass -> Execute before all test methods of the class are executed. Used with static method
//	@After -> Execute after each test method. Used with non-static method.
//	@AfterClass -> Execute after all test methods in the current class. Used with static method. 
	
	//IN Junit5
//	@Before = @BeforeEach
//	@BeforeClass = @BeforeAll
//	@After = @AfterEach
//	@AfterClass = @AfterAll
	
	MyMath myMath = new MyMath();
	
	@BeforeEach
	public void before() {
		System.out.println("BeforeEach");
	}
	
	@AfterEach
	public void after() {
		System.out.println("AfterEach");
	}
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("After All");
	}
	
	@Test
	public void sum_with_3numbers() {
		//Absence of failure is success
//		fail("Not yet implemented");
		System.out.println("Test 1");
		
		int[] arr = {1,2,3};
		
		int sum = myMath.sum(arr);
		
		assertEquals(6, sum);
	}
	
	@Test
	public void sum_with_1number() {
		System.out.println("Test 2");
		
		int[] arr = {2};
		
		int sum = myMath.sum(arr);
		
		assertEquals(2, sum);
	}

}
