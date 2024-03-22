package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_PublicHolidayPage;


public class SystemDefination_PublicHolidayPageTest extends BaseClass
{

	public SystemDefination_PublicHolidayPage publicHoliday;
	
	
	@Test(priority = 1)
	public void System_Defination_VerifyCreatePublicHoliday() throws Exception 
	{
		publicHoliday = new SystemDefination_PublicHolidayPage(driver);

		publicHoliday.createPublicHoliday();
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdatePublicHoliday() throws Exception 
	{
		publicHoliday.editPublicHoliday();
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeletePublicHoliday() throws Exception 
	{
		publicHoliday.deletePublicHoliday();
	}
}
