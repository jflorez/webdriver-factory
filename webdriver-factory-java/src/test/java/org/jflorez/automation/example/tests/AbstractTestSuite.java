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
		String gridUrl = EnvironmentVariables.getGridURL();
		String browser = EnvironmentVariables.getBrowser();
		String url = EnvironmentVariables.getEnvironment();
		int implicitWait = EnvironmentVariables.getImplicitWait();
		DriverFactory driverFactory = (gridUrl != null && !gridUrl.isBlank()) ? DriverFactoryBuilder.getFactory(browser, gridUrl) : DriverFactoryBuilder.getFactory(browser);
		
		driver = driverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	@AfterEach
	public void cleanupSuite() {
		driver.quit();
	}

}
