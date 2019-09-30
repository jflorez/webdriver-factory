package org.jflorez.driver;

import org.jflorez.driver.support.CustomWebDriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public abstract class AbstractDriverFactory implements DriverFactory {
	
	protected boolean headless = true;
	
	public WebDriver getDriver() {
		return new EventFiringWebDriver(buildDriver()).register(new CustomWebDriverEventListener());
	}
	
	protected abstract WebDriver buildDriver();
	
	public DriverFactory setHeadless(boolean isHeadless) {
		this.headless = isHeadless;
		return this;
	}
}
