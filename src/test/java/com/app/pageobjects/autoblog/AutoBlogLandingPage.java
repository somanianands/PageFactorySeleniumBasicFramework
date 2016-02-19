package com.app.pageobjects.autoblog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.core.utils.Utils;

public class AutoBlogLandingPage {

	public AutoBlogLandingPage(WebDriver driver) {
		Utils.moveToNewWindows(driver,
				"Autoblog - We Obsessively Cover the Auto Industry");
		PageFactory.initElements(driver, this);
		logger.info("On AutoBlog Landing Page");
	}

	final static Logger logger = LoggerFactory
			.getLogger(AutoBlogLandingPage.class);

	@FindBy(xpath = "//img[@src='http://www.blogsmithmedia.com/www.autoblog.com/v/220a8473f28e22ba1a5601253021cd03574e021c/img/logos/autoblog.svg']")
	private WebElement autoBlogLogo;

	public boolean isAutoBlogLogoExists() {
		return autoBlogLogo.isDisplayed();
	}

}