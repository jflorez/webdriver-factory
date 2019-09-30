package org.jflorez.automation.example.tests;

import java.util.concurrent.TimeUnit;

import org.jflorez.driver.DriverFactory;
import org.jflorez.driver.DriverFactoryBuilder;
import org.jflorez.environment.EnvironmentVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTestSuite {

	protected WebDriver driver;

	@BeforeEach
	public void setupTest() throws Exception {
		var gridUrl = EnvironmentVariables.getInstance().getGridURL();
		var browser = EnvironmentVariables.getInstance().getBrowser();
		var headless = EnvironmentVariables.getInstance().isHeadless();
		var implicitWait = EnvironmentVariables.getInstance().getImplicitWait();
		var url = EnvironmentVariables.getInstance().getEnvironment();
		
		driver = (gridUrl != null && !gridUrl.isBlank()) 
				? DriverFactoryBuilder.getFactory(browser, gridUrl).getDriver()
				: DriverFactoryBuilder.getFactory(browser).setHeadless(headless).getDriver();
		driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	@AfterEach
	public void cleanupSuite() {
		driver.quit();
	}

}
