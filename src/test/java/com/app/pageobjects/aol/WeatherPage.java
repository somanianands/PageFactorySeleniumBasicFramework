package com.app.pageobjects.aol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.pageobjects.BasePage;

public class WeatherPage extends BasePage {

	public WeatherPage(WebDriver driver) {
		super(driver);
		logger.info("On Weather Page");
	}
	
	final static Logger logger = LoggerFactory
			.getLogger(WeatherPage.class);

	@FindBy(xpath = "//form[@id='location-form']/div[@class='location']/span[@class='swappable-location-name']")
	private WebElement locationName;

	public String getLocationName() {
		return locationName.getText();
	}

}