package com.AutomationJiviewsGeneric;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;





public class ListenerImplimentation extends BaseClass implements ITestListener{
	private static final Logger logger = LogManager.getLogger(ListenerImplimentation.class);
	private ExtentReports report;
	private ExtentTest test;
	
	public ListenerImplimentation() {
		new configUtility();

		try {
			report = ExtentReportManager.getInstance(); // Use the singleton instance
			report.setSystemInfo("OS", configUtility.getCongigPropertyData("windows"));
			report.setSystemInfo("Base Browser", configUtility.getCongigPropertyData("browser"));
			report.setSystemInfo("Base Url", configUtility.getCongigPropertyData("url"));
			logger.info("Extent Report Output Path: " + System.getProperty("extent.reporter.html.output"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		setupTest(methodName);

		/*	test = report.createTest(methodName);

		// Add author, category, and description to the test
		try {
			test.assignAuthor(congigUtiliy.getCongigPropertyData("author"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.assignCategory("Functional Test");
		test.info("Jivi Automation Test: Verifying user login functionality");*/
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		// Log test success
		test.pass("Test passed");
	}

	/*@Override
	public void onTestFailure(ITestResult result) {
		String res = result.getName();
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		//		File dest = new File("./ScreenShot/" + res + ".png");
		File dest = new File(System.getProperty("user.dir") + "/ScreenShot/" + res + ".png");
		logger.info("Screenshot destination path: " + dest.getAbsolutePath());
		try {
			FileUtils.copyFile(src, dest);
			logger.info("Screenshot captured and saved to: " + dest.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error capturing or saving screenshot:", e);
		}
		// Log test failure with a screenshot
		try {
			test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error attaching screenshot to the test report:", e);
		}

		// Update the path for attaching the screenshot
		String screenshotPath = "../ScreenShot/" + res + ".png";

		// Log test failure with a screenshot
		try {
			test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error attaching screenshot to the test report:", e);
		}
	}*/
	@Override
	public void onTestFailure(ITestResult result) {
	    String res = result.getName();
	    TakesScreenshot t = (TakesScreenshot) driver;
	    File src = t.getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir") + "/ScreenShot/" + res + ".png");
	    logger.info("Screenshot destination path: " + dest.getAbsolutePath());

	    try {
	        FileUtils.copyFile(src, dest);
	        logger.info("Screenshot captured and saved to: " + dest.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	        logger.error("Error capturing or saving screenshot:", e);
	    }

	    // Log test failure with a customized message
	    try {
	        // Get the exception message
	        String exceptionMessage = result.getThrowable().getMessage();
	        
	        // Get the exception type
	        String exceptionType = result.getThrowable().getClass().getSimpleName();
	        
	        // Get the line number where the exception occurred
	        int lineNumber = result.getThrowable().getStackTrace()[0].getLineNumber();

	        // Log a customized failure message to the extent report
	        String customFailureMessage = String.format("Test failed due to: %s (%s) at line %d",
	                exceptionMessage, exceptionType, lineNumber);
	        
	        test.fail(customFailureMessage,
	                MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
	    } catch (IOException e) {
	        e.printStackTrace();
	        logger.error("Error attaching screenshot to the test report:", e);
	    }
	}
	/*@Override
	public void onTestFailure(ITestResult result) {
	    String res = result.getName();
	    TakesScreenshot t = (TakesScreenshot) driver;
	    File src = t.getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir") + "/ScreenShot/" + res + ".png");
	    logger.info("Screenshot destination path: " + dest.getAbsolutePath());

	    try {
	        FileUtils.copyFile(src, dest);
	        logger.info("Screenshot captured and saved to: " + dest.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	        logger.error("Error capturing or saving screenshot:", e);
	    }

	    // Log test failure with a customized message
	    try {
	        // Get the exception message
	        String exceptionMessage = result.getThrowable().getMessage();

	        // Log a concise failure message to the extent report
	        String customFailureMessage = String.format("Test failed due to: %s", exceptionMessage);

	        // Attach the screenshot and log the failure
	        test.fail(customFailureMessage,
	                MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
	    } catch (IOException e) {
	        e.printStackTrace();
	        logger.error("Error attaching screenshot to the test report:", e);
	    }
	}*/



	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		setupTest(methodName);

		// Log test skipped with custom message or additional information
		test.skip("Test skipped - Method: " + methodName);

	}

	@Override
	public void onStart(ITestContext context) {

		String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		String reportFileName = "ExtentReport_" + timestamp + ".html";
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("./ExtentReport/" + reportFileName);

		report = ExtentReportManager.getInstance(); // Use the singleton instance

		report.attachReporter(htmlreport); 		// Attach the HTML reporter to the existing report instance

		// Set the configuration for the report
		htmlreport.config().setTheme(Theme.DARK); // Set the dark theme
		htmlreport.config().setDocumentTitle("Jivi Automation Test Report");
		htmlreport.config().setReportName("End-to-End Test Report for Jivi Modules");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	private void setupTest(String methodName) {
		test = report.createTest(methodName);

		try {
			test.assignAuthor(configUtility.getCongigPropertyData("author"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.assignCategory("Functional Test");
		test.info("Jivi Automation Test: Verifying user login functionality");
	}


}
