package com.jflorez.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements DriverFactory {

	FirefoxOptions firefoxOptions;

	public FirefoxDriverFactory() {
		firefoxOptions = new FirefoxOptions();
	}

	@Override
	public WebDriver getDriver() throws Exception {
		return new FirefoxDriver(firefoxOptions);
	}

}
