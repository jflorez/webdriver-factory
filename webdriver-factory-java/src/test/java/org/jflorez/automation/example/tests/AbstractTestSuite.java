package org.jflorez.automation.example.tests;

import java.util.concurrent.TimeUnit;

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
		
		driver = (gridUrl != null && !gridUrl.isBlank()) 
				? DriverFactoryBuilder.getFactory(browser, gridUrl).getDriver()
				: DriverFactoryBuilder.getFactory(browser).getDriver();
		driver.manage().timeouts().implicitlyWait(EnvironmentVariables.getInstance().getImplicitWait(),
				TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(EnvironmentVariables.getInstance().getEnvironment());
	}

	@AfterEach
	public void cleanupSuite() {
		driver.quit();
	}

}
