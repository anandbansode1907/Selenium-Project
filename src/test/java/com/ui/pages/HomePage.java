package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

public final class HomePage extends BrowserUtility {
	//goToWebsite(readProperty(QA, "URL"));
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA));	
		maximizeWindow();
	}

	public LoginPage goToLoginPage() { // page functions
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}