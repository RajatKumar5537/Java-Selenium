package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.JS_980_StackersPlanningPage;

public class JS_980_StackersPlanningTest extends BaseClass{

	private static final Logger logger = Logger.getLogger(JS_980_StackersPlanningTest.class.getName());
	private JS_980_StackersPlanningPage stackerPlanning = new JS_980_StackersPlanningPage(driver);

	

	@Test(priority = 1)
	public void JS_981_VerifySearch() throws Exception {
		captureScreenshot(driver, "JS_980_StackersPlanningTest");
		logger.info("Starting test: JS_981_VerifySearch");

		stackerPlanning = new JS_980_StackersPlanningPage(driver);

		stackerPlanning.JS_981_Search();

		logger.info("Test JS_981_VerifySearch is successful");
	}
	
	
	@Test(priority = 2)
	public void JS_982_AddStackers() throws InterruptedException {
		
		stackerPlanning.JS_982_AddStackers();
	}
}
