package com.jflorez.driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteDriverFactory implements DriverFactory {
	
	private String browser;
	private String gridURL;

	public RemoteDriverFactory(String browser, String gridURL) {
		this.browser = browser;
		this.gridURL = gridURL;
	}
	
	@Override
	public WebDriver getDriver() throws Exception {
		
		DesiredCapabilities capabilities = (DesiredCapabilities) DesiredCapabilities.class.getMethod(browser.toLowerCase()).invoke(null);
		return new RemoteWebDriver(new URL(gridURL),capabilities);
	}

}
