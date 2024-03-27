package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Crane_Setup;

public class Crane_Setup_Test extends BaseClass 
{
	
	private static final Logger logger = Logger.getLogger(Crane_Setup_Test.class.getName());
	public Crane_Setup crane;
	

	@Test(priority = 1)
	public void verifyCreateCrane() throws Exception 
	{
		logger.info("Starting test: verifyCreateCrane");
		crane = new Crane_Setup(driver);
		crane.createCrane();
		logger.info("Test verifyCreateCrane is successful");
	}

	@Test(priority = 2)
	public void verifyEditCrane() throws Exception 
	{
		logger.info("Starting test: verifyEditCrane");
		crane.editCrane();
		logger.info("Test verifyEditCrane is successful");
	}

	@Test(priority = 3)
	public void verifyDeleteCrane() throws Exception 
	{
		logger.info("Starting test: verifyDeleteCrane");
		crane.deleteCrane();
		logger.info("Test verifyDeleteCrane is successful");
	}

	@Test(priority = 4)
	public void verifyReactivate() throws Exception 
	{
		logger.info("Starting test: verifyReactivate");
		crane.reActivate();
		logger.info("Test verifyReactivate is successful");
	}

}
