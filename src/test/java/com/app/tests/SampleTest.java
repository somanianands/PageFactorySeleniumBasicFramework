package com.app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pageobjects.aol.AolLandingPage;

public class SampleTest extends BaseTest {

	// Test Case 1
	// 1. Using Firefox go to http://www.aol.com
	// 2. Verify ‘NEWS’, ‘SPORTS’ and ‘ENTERTAINMENT’ links/elements are present
	// on the page
	// 3. Then search for AOL Autos
	// 4. Verify that ‘Web’ and ‘Mail’ links/elements are present
	// 5. Then click on www.autoblog.com search result and verify that the
	// AutoBlog Logo is present on the resulting page

	@Test
	public void testCase1() {
		WebDriver driver = getDriverInstance();
		AolLandingPage aolLandingPage = new AolLandingPage(driver);
		Assert.assertTrue(aolLandingPage.getNewsLinkLabel().contains("NEWS"),
				"Page does not cotanin NEWS Link");
		Assert.assertTrue(aolLandingPage.getSportsLinkLabel()
				.contains("SPORTS"), "Page does not cotanin NEWS Link");
		Assert.assertTrue(
				aolLandingPage.getEntertainmentLinkLabel().contains(
						"ENTERTAINMENT"),
				"Page does not cotanin ENTERTAINMENT Link");
		Assert.assertTrue(aolLandingPage.setWebSearchInput("AOL Autos")
				.clickOnWebSearchButton().clickOnExactLink("www.autoblog.com")
				.isAutoBlogLogoExists(),
				"Page does not contains Auto Blog Logo");
	}

	// Test Case 2
	// 1. Using Firefox go to http:// www.aol.com
	// 2. Update the location([1]) to New York
	// 3. Then verify the location is updated correctly in [1]
	// 4. Then Go to the link WEATHER [2], and verify the weather page shows the
	// Weather for New York.

	@Test
	public void testCase2() {
		WebDriver driver = getDriverInstance();
		AolLandingPage aolLandingPage = new AolLandingPage(driver);
		Assert.assertTrue(aolLandingPage.clickOnSetWeather()
				.enterWeatherLocation("New York").getWeatherLocation()
				.toLowerCase().contains(("New York".toLowerCase())),
				"Page does not showing New York as Weather Location");
		Assert.assertTrue(aolLandingPage.clickOnWeatherLink().getLocationName()
				.toLowerCase().contains(("New York".toLowerCase())),
				"Page does not showing Weather of New York Location");
	}
}
