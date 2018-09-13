package com.jflorez.automation.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SampleTests extends AbstractTestSuite{

	@Test
	public void sampleSeleniumTest1() {
		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium webdriver");
		driver.findElement(By.name("btnK")).click();
		assertEquals("Selenium WebDriver", driver.findElement(By.linkText("Selenium WebDriver")));
	}
	
}
