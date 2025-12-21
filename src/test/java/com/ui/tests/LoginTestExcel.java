package com.ui.tests;

import static com.constants.Browser.EDGE;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;

public class LoginTestExcel {
	HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		homePage = new HomePage(EDGE, true);
	}

	
	@Test(description = "Verify Login Fuctionality", groups = { "e2e", "sanity" }, priority = 1, 
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider ="LoginTestExcelDataProvider")
	public void verifyLoginTest(User user) {
		logger.info("Started the login test");
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
		logger.info("The login test executed");
	}
}