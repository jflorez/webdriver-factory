package org.jflorez.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface DriverFactory {
	
	public WebDriver getDriver() throws Exception;
	public <T extends Capabilities> T getCapabilities()  throws Exception;

}
