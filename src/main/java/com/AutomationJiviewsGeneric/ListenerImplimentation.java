package com.AutomationJiviewsGeneric;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerImplimentation extends BaseClass implements ITestListener{
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stu
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String res = result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+res+".png");
		try {
			FileUtils.copyFile(src,dest);
		} 
		catch (Exception e) {

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	//@Override
	//public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	//}

	@Override
	public void onStart(ITestContext context) {
	
//		ExtentSparkReporter htmlreporter=new ExtentSparkReporter("./ExtentReport/report.html");
//		report=new ExtentReports();
//		report.attachReporter(htmlreporter);
//		report.setSystemInfo("OS", "Windows");
//	    report.setSystemInfo("Reporter Name", "Rajat");
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		report.flush();
		//ITestListener.super.onFinish(context);
	}

}
