package com.jflorez.driver;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {
	
	public WebDriver getDriver() throws Exception;

}
