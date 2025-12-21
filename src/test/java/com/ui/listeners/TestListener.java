package com.ui.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;


public class TestListener implements ITestListener{
	
	private static final Logger logger = Logger.getLogger(TestListener.class);
	//private static final Logger logger1 = (Logger) LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("Test Suite started");
	}

	public void onTestStart(ITestResult result) {
		logger.info("Started " + result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(result.getMethod().getGroups());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Passed " + result.getMethod().getMethodName());
		logger.info("Passed " + result.getMethod().getDescription());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Failed " + result.getMethod().getMethodName());
		logger.error("Failed " + result.getMethod().getDescription());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Skipped " + result.getMethod().getMethodName());
		logger.info("Skipped " + result.getMethod().getDescription());
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite finished");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("onTestFailedButWithinSuccessPercentage");
		
	}

}
