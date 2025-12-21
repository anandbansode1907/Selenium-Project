package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Invalid Browser name, please select Chrome or  Edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());

		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
		maximizeWindow();
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		webElement.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement webElement = driver.get().findElement(locator);
		webElement.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		return webElement.getText();
	}

	public String takeScreenShot(String name) {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH--mm--ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name +"  " + timeStamp + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenShotdata = screenshot.getScreenshotAs(OutputType.FILE);

		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotdata, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}