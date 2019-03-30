package org.jflorez.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements DriverFactory {

	@Override
	public WebDriver getDriver() throws Exception {
		return new FirefoxDriver(getCapabilities());
	}

	@SuppressWarnings("unchecked")
	@Override
	public FirefoxOptions getCapabilities() throws Exception {
		FirefoxOptions options = new FirefoxOptions().addArguments("-width 1920","-height 1200");
		options.setHeadless(true);
		return options;
	}

}
