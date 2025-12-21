package com.ui.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;

public class TestListener implements ITestListener {

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	private static final Logger logger = Logger.getLogger(TestListener.class);
	// private static final Logger logger1 = (Logger)
	// LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("Test Suite started");
		ExtentReporterUtility.setupSparkReporter("report.html");

	}

	public void onTestStart(ITestResult result) {
		logger.info("Started " + result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		// extentTest = extentReports.createTest(result.getMethod().getMethodName());
		ExtentReporterUtility.createExentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Passed " + result.getMethod().getMethodName());
		logger.info("Passed " + result.getMethod().getDescription());
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " Passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Failed " + result.getMethod().getMethodName());
		logger.error("Failed " + result.getMethod().getDescription());
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " Failed");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		Object testClass = result.getInstance();		
		BrowserUtility browserUtilty = ((TestBase) testClass).getInstance();
		logger.info("Capturing screenshot for failed test");
		String screenShotPath = browserUtilty.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the html file");
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenShotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn("Skipped " + result.getMethod().getMethodName());
		logger.info("Skipped " + result.getMethod().getDescription());
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " Skipped");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite finished");
		ExtentReporterUtility.flushReport();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("onTestFailedButWithinSuccessPercentage");
	}
}