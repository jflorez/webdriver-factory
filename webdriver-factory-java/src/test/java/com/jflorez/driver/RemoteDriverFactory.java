package com.jflorez.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory implements DriverFactory {

	
	private String gridURL;
	private Capabilities capabilities;

	public RemoteDriverFactory(String browser, String gridURL) {
		this.gridURL = gridURL;
		capabilities = DriverFactoryBuilder.getFactory(browser).getCapabilities();
	}

	@Override
	public WebDriver getDriver() {
		try {
			return new RemoteWebDriver(new URL(gridURL), capabilities);
		} catch (MalformedURLException  | IllegalArgumentException  | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Capabilities getCapabilities() {
		return capabilities;
	}

}
