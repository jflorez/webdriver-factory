package org.jflorez.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory extends AbstractDriverFactory {

	@Override
	protected WebDriver buildDriver() {
		return new FirefoxDriver(getCapabilities());
	}

	@Override
	public FirefoxOptions getCapabilities() {
		FirefoxOptions options = new FirefoxOptions().addArguments("-width 1920","-height 1200");
		options.setHeadless(this.headless);
		return options;
	}

}
