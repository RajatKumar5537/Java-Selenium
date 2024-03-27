package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Location_Definitions;

public class Location_Definitions_Test extends BaseClass 
{
	private static final Logger logger = Logger.getLogger(Location_Definitions_Test.class.getName());
	Location_Definitions location;

	@Test(priority = 1)
	public void verifyCreateLocation() throws Exception 
	{
		logger.info("Starting test: verifyCreateLocation");
		location=new Location_Definitions(driver);
		location.createLocation();
		logger.info("Test verifyCreateLocation is successful");
	}

	@Test(priority = 2)
	public void verifyEditLocation() throws Exception 
	{
		logger.info("Starting test: verifyEditLocation");
		location.editLocation();
		logger.info("Test verifyEditLocation is successful");
	}

	@Test(priority = 3)
	public void verifyDeleteLocation() throws Exception 
	{
		logger.info("Starting test: verifyDeleteLocation");
		location.deleteLocation();
		logger.info("Test verifyDeleteLocation is successful");
	}

	@Test(priority = 4)
	public void verifyReActivate() throws Exception 
	{
		logger.info("Starting test: verifyReActivate");
		location.reActivate();
		logger.info("Test verifyReActivate is successful");
	}

}
