package com.jflorez.driver;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.reflections.Reflections;

public class LocalDriverFactory implements DriverFactory {

	private String browser;
	private Capabilities capabilities;

	public LocalDriverFactory(String browser) {
		this.browser = browser;
		try {
			capabilities = (DesiredCapabilities) DesiredCapabilities.class
					.getMethod(browser.toLowerCase()).invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public WebDriver getDriver() {
		Reflections reflections = new Reflections(WebDriver.class.getPackageName());
		Set<Class<? extends WebDriver>> subTypes = reflections.getSubTypesOf(WebDriver.class);
		try {
			/**
			 * Here I use the deprecated constructor that receives an instance of Capabilities. 
			 * This class and method are used when no implementations of a given browser factory exist.
			 * 
			 * Ideally each browser supported by the automation solution would have its own factory class so
			 * that class can use the correct browser options object
			 */
			return subTypes.stream()
					       .filter(e -> e.getName().contains(browser.toLowerCase()))
					       .findFirst()
					       .get()
					.getConstructor(Capabilities.class).newInstance(capabilities);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Capabilities getCapabilities() {
		return capabilities;
	}
	

}
