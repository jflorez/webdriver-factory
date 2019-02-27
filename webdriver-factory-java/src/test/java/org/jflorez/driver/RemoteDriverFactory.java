package org.jflorez.driver;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory implements DriverFactory {
	
	private String browser;
	private String gridUrl;
	
	public RemoteDriverFactory(String browser, String gridUrl) {
		this.browser = browser;
		this.gridUrl = gridUrl;
	}

	@Override
	public WebDriver getDriver() throws Exception {
		return new RemoteWebDriver(new URL(gridUrl),getCapabilities());
	}

	@Override
	public Capabilities getCapabilities() throws Exception {
		return DriverFactoryBuilder.getFactory(browser).getCapabilities();
	}

}
