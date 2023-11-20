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
	private configUtility congigUtiliy;

	public ListenerImplimentation() {
		congigUtiliy= new configUtility();

		try {
			report = ExtentReportManager.getInstance(); // Use the singleton instance
			report.setSystemInfo("OS", congigUtiliy.getCongigPropertyData("windows"));
			report.setSystemInfo("Base Browser", congigUtiliy.getCongigPropertyData("browser"));
			report.setSystemInfo("Base Url", congigUtiliy.getCongigPropertyData("url"));
			logger.info("Extent Report Output Path: " + System.getProperty("extent.reporter.html.output"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);

		// Add author, category, and description to the test
		try {
			test.assignAuthor(congigUtiliy.getCongigPropertyData("author"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.assignCategory("Functional Test");
		test.info("Jivi Automation Test: Verifying user login functionality");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Log test success
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String res = result.getName();
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/" + res + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Log test failure with a screenshot
		try {
			test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		try {
			test.assignAuthor(congigUtiliy.getCongigPropertyData("author"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		test.assignCategory("Functional Test");
		test.info("Jivi Automation Test: Verifying user login functionality");

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



}
