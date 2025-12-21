package com.ui.tests;

import static com.constants.Browser.EDGE;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTestCSV {
	HomePage homePage;

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		homePage = new HomePage(EDGE);
	}

	
	@Test(description = "Verify Login Fuctionality", groups = { "e2e", "sanity" }, priority = 1, 
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider ="LoginTestCSVDataProvider")
	public void verifyLoginTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
	}
}