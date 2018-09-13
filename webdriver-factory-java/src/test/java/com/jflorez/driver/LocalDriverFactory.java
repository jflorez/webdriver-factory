package com.jflorez.driver;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

public class LocalDriverFactory implements DriverFactory {

	private String browser;

	public LocalDriverFactory(String browser) {
		this.browser = browser;
	}

	@Override
	public WebDriver getDriver() throws Exception {

		Reflections reflections = new Reflections(WebDriver.class.getPackageName());
		Set<Class<? extends WebDriver>> subTypes = reflections.getSubTypesOf(WebDriver.class);
		return subTypes.stream()
				       .filter(e -> e.getName().contains(browser.toLowerCase()))
				       .findFirst()
				       .get()
				.getConstructor().newInstance();
	}

}
