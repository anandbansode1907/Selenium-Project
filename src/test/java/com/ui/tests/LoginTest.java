package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {	
	
	@Test(description = "Verify Login Fuctionality", groups = { "e2e", "sanity" }, priority = 1, 
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider ="LoginTestDataProvider") 
	//retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void verifyLoginTest(User user) {	
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Jatin Sharma");
	
	}
}