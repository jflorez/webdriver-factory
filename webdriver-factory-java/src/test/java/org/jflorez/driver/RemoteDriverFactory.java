package org.jflorez.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory extends AbstractDriverFactory {
	
	private String browser;
	private String gridUrl;
	
	public RemoteDriverFactory(String browser, String gridUrl) {
		this.browser = browser;
		this.gridUrl = gridUrl;
	}

	@Override
	protected WebDriver buildDriver() {
		try {
			return new RemoteWebDriver(new URL(gridUrl),getCapabilities());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Capabilities getCapabilities() {
		return DriverFactoryBuilder.getFactory(browser).setHeadless(headless).getCapabilities();
	}

}
