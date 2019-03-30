package org.jflorez.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements DriverFactory {

	@Override
	public WebDriver getDriver() throws Exception {
        return new ChromeDriver(getCapabilities());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChromeOptions getCapabilities() {
		return new ChromeOptions()
		.addArguments("--headless", 
				      "--disable-gpu", 
				      "--window-size=1920,1200",
				      "--ignore-certificate-errors")
		.setExperimentalOption("w3c", true); 
	}

}
