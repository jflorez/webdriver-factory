package com.jflorez.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements DriverFactory {

	FirefoxOptions firefoxOptions;

	public FirefoxDriverFactory() {
		firefoxOptions = new FirefoxOptions();
	}

	@Override
	public WebDriver getDriver() {
		return new FirefoxDriver(firefoxOptions);
	}

	@Override
	public Capabilities getCapabilities() {
		return firefoxOptions;
	}

}
