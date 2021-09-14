package com.nagarro.basicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;


import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.Assert;
//import junit.framework.Assert;

//import static junit.framework.Assert;

public class WebTest {

	public static void main(String[] args) throws Exception{
		 ChromeDriver driver = new ChromeDriver(new ChromeOptions());

	        driver.navigate().to("https://example.testproject.io/web/");

	        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
	        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
	        driver.findElement(By.cssSelector("#login")).click();

	        boolean passed = driver.findElement(By.cssSelector("#logout")).isDisplayed();
	        
	        Assert.assertEquals(true, passed);
	        if (passed) {
	            System.out.println("Test Passed");
	        } else {
	            System.out.println("Test Failed");
	        }
	        
	      

	        driver.quit();

	}

}
