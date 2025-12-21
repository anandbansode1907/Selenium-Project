package com.ui.tests;

import static com.constants.Browser.EDGE;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility; 

import org.apache.logging.log4j.Logger;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest {
	HomePage homePage;
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		homePage = new HomePage(EDGE);
	}
	
	@Test(description = "Verify Login Fuctionality", groups = { "e2e", "sanity" }, priority = 1, 
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider ="LoginTestDataProvider") 
	//retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void verifyLoginTest(User user) {	
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
	
	}
}