package com.app.pageobjects.aol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.pageobjects.BasePage;

public class AolLandingPage extends BasePage {

	public AolLandingPage(WebDriver driver) {
		super(driver);
		logger.info("On AOL Landing Page");
	}

	final static Logger logger = LoggerFactory.getLogger(AolLandingPage.class);

	@FindBy(xpath = "//div[@class='topTitle']/a[@id='ghnav-news']")
	private WebElement newsLink;

	@FindBy(xpath = "//div[@class='topTitle']/a[@id='ghnav-sports']")
	private WebElement sportsLink;

	@FindBy(xpath = "//div[@class='topTitle']/a[@id='ghnav-entertainment']")
	private WebElement entertainmentLink;

	@FindBy(xpath = "//div[@class='topTitle']/a[@id='ghnav-weather']")
	private WebElement weatherLink;

	@FindBy(id = "aol-header-query")
	private WebElement webSearchInputField;

	@FindBy(id = "aol-header-search-button")
	private WebElement webSearchButton;

	@FindBy(id = "weatheredit")
	private WebElement weatherLocation;

	@FindBy(id = "wz")
	private WebElement weatherLocationInputField;

	@FindBy(id = "weathersubmit")
	private WebElement weatherSubmitIcon;

	public AolLandingPage setWebSearchInput(String searchFor) {
		logger.info("Enter Search String as " + searchFor);
		webSearchInputField.clear();
		webSearchInputField.sendKeys(searchFor);
		return this;
	}

	public SearchResultPage clickOnWebSearchButton() {
		logger.info("Clicking on Web Search");
		webSearchButton.click();
		return new SearchResultPage(driver);
	}

	public AolLandingPage clickOnSetWeather() {
		logger.info("Clicking on SET WEATHER");
		weatherLocation.click();
		return this;
	}

	public AolLandingPage enterWeatherLocation(String location) {
		logger.info("Enter Location " + location);
		weatherLocationInputField.clear();
		weatherLocationInputField.sendKeys(location);
		logger.info("Clicking on Weather Search Icon ");
		weatherSubmitIcon.click();
		return this;
	}

	public String getWeatherLocation() {
		return weatherLocation.getText();
	}

	public WeatherPage clickOnWeatherLink() {
		logger.info("Clicking on Weather Link ");
		weatherLink.click();
		return new WeatherPage(driver);
	}

	public String getNewsLinkLabel() {
		return newsLink.getText();
	}

	public String getSportsLinkLabel() {
		return sportsLink.getText();
	}

	public String getEntertainmentLinkLabel() {
		return entertainmentLink.getText();
	}
}