package com.jflorez.automation.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleTests extends AbstractTestSuite{

	@Test
	public void sampleSeleniumTest1() {
		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium webdriver");
		driver.findElement(By.name("btnK")).click();
		var element = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Selenium WebDriver")));
		assertEquals("Selenium WebDriver", element.getText());
	}
	
}
