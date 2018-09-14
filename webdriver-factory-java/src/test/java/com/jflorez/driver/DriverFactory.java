package com.jflorez.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface DriverFactory {
	
	public WebDriver getDriver();
	
	public Capabilities getCapabilities();

}
