package com.jflorez.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements DriverFactory {
	
	private ChromeOptions options;
	
	public ChromeDriverFactory() {
		options = new ChromeOptions();
		options.addArguments("test-type");
        options.addArguments("disable-infobars");
	}
	

	@Override
	public WebDriver getDriver() {
        return new ChromeDriver(options);
	}


	@Override
	public Capabilities getCapabilities() {
		return options;
	}
}
