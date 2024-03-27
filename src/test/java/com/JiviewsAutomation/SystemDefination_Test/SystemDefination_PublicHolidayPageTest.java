package com.JiviewsAutomation.SystemDefination_Test;



import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_PublicHolidayPage;


public class SystemDefination_PublicHolidayPageTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(SystemDefination_PublicHolidayPageTest.class.getName());
	public SystemDefination_PublicHolidayPage publicHoliday;


	@Test(priority = 1)
	public void System_Defination_VerifyCreatePublicHoliday() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreatePublicHoliday");
		publicHoliday = new SystemDefination_PublicHolidayPage(driver);
		publicHoliday.createPublicHoliday();
		logger.info("Test System_Defination_VerifyCreatePublicHoliday is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdatePublicHoliday() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyUpdatePublicHoliday");
		publicHoliday.editPublicHoliday();
		logger.info("Test System_Defination_VerifyUpdatePublicHoliday is successful");
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeletePublicHoliday() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyDeletePublicHoliday");
		publicHoliday.deletePublicHoliday();
		logger.info("Test System_Defination_VerifyDeletePublicHoliday is successful");
	}
}
