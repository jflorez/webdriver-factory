package com.jflorez.driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jflorez.environment.EnvironmentVariables;


public class RemoteDriverFactory implements DriverFactory {

	private String browser = EnvironmentVariables.getInstance().getRemoteBrowser();
	
	@Override
	public WebDriver getDriver() throws Exception {
		
		String gridUrl = "";
		DesiredCapabilities capabilities = (DesiredCapabilities) DesiredCapabilities.class.getMethod(browser.toLowerCase()).invoke(null);
		return new RemoteWebDriver(new URL(gridUrl),capabilities);
	}

}
