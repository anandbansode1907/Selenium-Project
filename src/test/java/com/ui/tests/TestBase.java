package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		logger.info("HomePage of the website");
		homePage = new HomePage(EDGE, true);
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
}