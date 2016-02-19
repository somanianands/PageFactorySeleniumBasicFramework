package com.framework.core.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Utils {

	final static Logger logger = LoggerFactory.getLogger(Utils.class);

	public static void moveToNewWindows(WebDriver driver, String windowTitle) {
		boolean windowExists = false;
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(windowTitle)) {
				windowExists = true;
				logger.info(windowTitle
						+ " Title window exists, Switched to new window");
				break;
			}
		}
		if (!windowExists) {
			Assert.fail(windowTitle + " Title window not exists");
		}
	}
}
