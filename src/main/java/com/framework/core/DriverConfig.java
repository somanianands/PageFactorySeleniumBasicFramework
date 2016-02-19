package com.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		driver = new FirefoxDriver();
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
	}
}
