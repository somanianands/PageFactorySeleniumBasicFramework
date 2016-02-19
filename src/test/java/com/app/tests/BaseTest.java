package com.app.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.core.DriverConfig;

public class BaseTest {

	WebDriver driver;

	final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

	public WebDriver getDriverInstance() {
		return driver;
	}

	@BeforeMethod
	public void createDriverInstance() {
		driver = DriverConfig.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Opening Browser");
		driver.get("http://www.aol.com");
	}

	@AfterMethod
	public void closeDriverInstance() {
		logger.info("Closing Browser");
		DriverConfig.closeDriver();
	}

}
