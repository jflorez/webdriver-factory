package org.jflorez.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface DriverFactory {
	
	public WebDriver getDriver() throws Exception;
	
	public Capabilities getCapabilities()  throws Exception;

}
