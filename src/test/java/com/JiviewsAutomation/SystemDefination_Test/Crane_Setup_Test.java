package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Crane_Setup;

public class Crane_Setup_Test extends BaseClass 
{
	
	private static final Logger logger = Logger.getLogger(Berth_Setup_Test.class.getName());
	public Crane_Setup crane;
	

	@Test(priority = 1)
	public void verifyCreateLocation() throws Exception 
	{
		logger.info("Starting test: verifyCreateLocation");
		crane = new Crane_Setup(driver);
		crane.createCrane();
		logger.info("Test verifyCreateLocation is successful");
	}

	@Test(priority = 2)
	public void verifyEditLocation() throws Exception 
	{
		logger.info("Starting test: verifyEditLocation");
		crane.editCrane();
		logger.info("Test verifyEditLocation is successful");
	}

	@Test(priority = 3)
	public void verifyDeleteLocation() throws Exception 
	{
		logger.info("Starting test: verifyDeleteLocation");
		crane.deleteCrane();
		logger.info("Test verifyDeleteLocation is successful");
	}

	@Test(priority = 4)
	public void verifyReActivate() throws Exception 
	{
		logger.info("Starting test: verifyReActivate");
		crane.reActivate();
		logger.info("Test verifyReActivate is successful");
	}

}
