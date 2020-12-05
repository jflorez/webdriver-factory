package org.jflorez.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory extends AbstractDriverFactory {

	@Override
	protected WebDriver buildDriver() {
        return new ChromeDriver(getCapabilities());
	}

	@Override
	public ChromeOptions getCapabilities() {
		return new ChromeOptions()
		.setHeadless(this.headless)
		.addArguments("--disable-gpu", 
				      "--window-size=1920,1200",
				      "--ignore-certificate-errors")
		.setExperimentalOption("w3c", true); 
	}

}
