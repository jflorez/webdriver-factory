package org.jflorez.automation.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleTests extends AbstractTestSuite {

	@Test
	public void sampleSeleniumTest1() {
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		driver.findElement(By.name("btnK")).click();
		var linkLocator = By.linkText("Selenium WebDriver");
		new WebDriverWait(driver, 60).until(d -> d.findElement(linkLocator).isDisplayed());
		assertEquals("Selenium WebDriver", driver.findElement(linkLocator).getText());
	}

}
