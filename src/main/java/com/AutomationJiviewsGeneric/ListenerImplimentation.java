package com.AutomationJiviewsGeneric;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
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

	ExtentReports report;
	ExtentTest test;
	FileLib fileLib;
	configUtility congigUtiliy;

	public ListenerImplimentation() {
//		fileLib = new FileLib();
		congigUtiliy= new configUtility();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String method = result.getMethod().getMethodName();
		test = report.createTest(method);

		// Add author, category, and description to the test
		try {
			test.assignAuthor(congigUtiliy.getCongigPropertyData("author"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.assignCategory("Functional Test");
		test.info("Skill Module Test: Verifying user login functionality");
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
		// Log test skipped
		test.skip("Test skipped");
	}

	@Override
	public void onStart(ITestContext context) {

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String reportFileName = "ExtentReport_" + timestamp + ".html";
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("./ExtentReport/" + reportFileName);
		report = new ExtentReports();

		// Attach the HTML reporter to the report
		report.attachReporter(htmlreport);

		// Set the configuration for the report
		htmlreport.config().setTheme(Theme.DARK); // Set the dark theme
		htmlreport.config().setDocumentTitle("Skill Module Test Report");
		htmlreport.config().setReportName("End-to-End Test Report for Skill Module");

		try {
			report.setSystemInfo("OS", congigUtiliy.getCongigPropertyData("windows"));
			report.setSystemInfo("Base Browser", congigUtiliy.getCongigPropertyData("browser"));
			report.setSystemInfo("Base Url", congigUtiliy.getCongigPropertyData("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
