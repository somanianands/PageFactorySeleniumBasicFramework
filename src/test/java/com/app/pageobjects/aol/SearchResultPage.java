package com.app.pageobjects.aol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.pageobjects.BasePage;
import com.app.pageobjects.autoblog.AutoBlogLandingPage;

public class SearchResultPage extends BasePage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		logger.info("On Search Result Page");
	}

	final static Logger logger = LoggerFactory
			.getLogger(SearchResultPage.class);

	@FindBy(xpath = "//div[@id='nav_cont']//div[contains(text(),'Web')]")
	private WebElement webLink;

	@FindBy(xpath = "//ul[@content='hat_links']//a[@id='mail']")
	private WebElement mailLink;

	public boolean isMailLinkExists() {
		return isElementDisplayed(mailLink);
	}

	public boolean isWebLinkExists() {
		return isElementDisplayed(webLink);
	}

	public AutoBlogLandingPage clickOnExactLink(String link) {
		logger.info("Searching for Exact Link : " + link);
		List<WebElement> autoblogLinks = driver.findElements(By
				.xpath("//ul[@content='ALGO']/li//span[@dir='ltr']"));
		int i = 1;
		for (WebElement element : autoblogLinks) {
			if (element.getText().contentEquals(link)) {
				driver.findElement(
						By.xpath("//ul[@content='ALGO']/li[" + i
								+ "]//a[@class='find']")).click();
			}
			i++;
		}
		return new AutoBlogLandingPage(driver);
	}
}