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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;




public class ListenerImplimentation extends BaseClass implements ITestListener{

//	private static final // logger // logger = LogManager.get// logger(ListenerImplimentation.class);
	private ExtentReports report;
	private ExtentTest test;

	public ListenerImplimentation() {
		new configUtility();
		try {
			report = ExtentReportManager.getInstance(); // Use the singleton instance
			report.setSystemInfo("OS", System.getProperty("os.name"));
			report.setSystemInfo("Java Version", System.getProperty("java.version"));
			report.setSystemInfo("Base Url", configUtility.getCongigPropertyData("url"));
			// logger.info("Extent Report Output Path: " + System.getProperty("extent.reporter.html.output"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		setupTest(methodName, result.getTestContext()); // Pass the ITestContext to setupTest

		// Log test start with a label
		logWithLabel("Test Start", "Starting test: " + methodName, ExtentColor.BLUE);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Log test success
		test.pass("Test passed");

	}


	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File dest = new File(System.getProperty("user.dir") + "/ScreenShot/" + testName + "_" + timestamp + ".png");
		
		// After updating the path to use ArtifactStagingDirectory, 
		// I am not able to retrieve the screenshots in the Azure Pipeline.
		// File dest = new File("$(Build.ArtifactStagingDirectory)/ScreenShot/" + testName + "_" + timestamp + ".png");


		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		// logger.info("Screenshot destination path: " + dest.getAbsolutePath());

		try {
			FileUtils.copyFile(src, dest);
			// logger.info("Screenshot captured and saved to: " + dest.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			// logger.error("Error capturing or saving screenshot:", e);
		}
		// Log paths for debugging
		// logger.info("Working Directory: " + System.getProperty("user.dir"));
		// logger.info("Screenshot Path: " + dest.getAbsolutePath());
		// Log additional failure details to console
		// logger.error("Exception Stack Trace:", result.getThrowable());

		// Extract line number from the stack trace
		StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
		int lineNumber = -1; // Default value if not found

		for (StackTraceElement element : stackTrace) {
			String className = element.getClassName();
			if (className.startsWith("com.JiviewsAutomation.SystemDefination_Test") || className.startsWith("com.AutomationJiviewsPOM")) {
				lineNumber = element.getLineNumber();
				break;
			}
		}
		test.log(Status.FAIL, "Test Failed at Line " + lineNumber + " - Check screenshot and error message below:",
				MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build())
		.fail(MarkupHelper.createCodeBlock(result.getThrowable().getMessage()));
		// Log additional failure details to console
		// logger.error("Exception Stack Trace:", result.getThrowable());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		setupTest(methodName, result.getTestContext());

		// Log test skipped with custom message or additional information
		String skipMessage = "Test skipped - Method: " + methodName;

		// Check if there is a throwable (exception) associated with the skipped test
		if (result.getThrowable() != null) {
			skipMessage += " - Reason: " + result.getThrowable().getMessage();

			// Log the exception message within a code block
			String codeBlock = MarkupHelper.createCodeBlock(result.getThrowable().getMessage()).getMarkup();
			test.log(Status.SKIP, codeBlock);
		} else {
			// Log the skip status to extent report
			test.log(Status.SKIP, skipMessage);
		}
	}

	@Override
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		String suiteName = context.getSuite().getName();
		String testName = context.getCurrentXmlTest().getName();
		String reportFileName = "ExtentReport_" + timestamp + ".html";
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/" + reportFileName);
		report = ExtentReportManager.getInstance(); // Use the singleton instance
		report.attachReporter(spark); // Attach the HTML reporter to the existing report instance

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Test Report - Suite: " + suiteName + ", Test: " + testName);

		String buildName = "Build Release-: V 4.24.00.161";
		String reportName = "Automation Test Report - " + buildName;
		spark.config().setReportName(reportName);

		// Configure the order of views
		spark.viewConfigurer().viewOrder()
		.as(new ViewName[] { 
				ViewName.DASHBOARD, 
				ViewName.TEST, 
				ViewName.CATEGORY, 
				ViewName.AUTHOR, 
//				ViewName.DEVICE, 
//				ViewName.EXCEPTION, 
//				ViewName.LOG 
		}).apply();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	private void setupTest(String methodName, ITestContext context) {
		test = report.createTest(methodName);
		try {
			test.assignAuthor(configUtility.getCongigPropertyData("author"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Assign author and category tags based on suite and test names
		String suiteName = context.getSuite().getName();
		String testName = context.getCurrentXmlTest().getName();
		test.assignCategory(suiteName, testName);
		test.assignDevice("Web Application");
		test.info("Jivi Automation Test: Verifying user login functionality");
	}


	// Helper method to add a log with a label
	private void logWithLabel(String label, String details, ExtentColor color) {
		String logMessage = String.format("%s: %s", label, details);
		test.log(Status.INFO, MarkupHelper.createLabel(logMessage, color).getMarkup());
	}

}
