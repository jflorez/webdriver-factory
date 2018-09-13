package com.jflorez.automation.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import com.jflorez.driver.DriverFactoryBuilder;
import com.jflorez.environment.EnvironmentVariables;



public abstract class AbstractTestSuite {
	
	protected  WebDriver driver;
	
	

	@BeforeEach
	public void setupTest() {
		driver = DriverFactoryBuilder.getFactory(EnvironmentVariables.getInstance().getBrowser()).getDriver();
		driver.manage().timeouts().implicitlyWait(EnvironmentVariables.getInstance().getImplicitWait(),TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(EnvironmentVariables.getInstance().getEnvironment());
	}

	@AfterEach
	public void cleanupSuite() {
		driver.quit();
	}

}
