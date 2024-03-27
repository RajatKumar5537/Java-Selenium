package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2639_SystemDefinationSCRPage;

public class System_Defination_SCRTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(System_Defination_SCRTest.class.getName());
	public E10_2639_SystemDefinationSCRPage scr;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateSCR() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateSCR");
		scr= new E10_2639_SystemDefinationSCRPage(driver);
		scr.createSCR();
		logger.info("Test System_Defination_VerifyCreateSCR is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdateSCR() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyUpdateSCR");
		scr.setUpdateSCR();
		logger.info("Test System_Defination_VerifyUpdateSCR is successful");
	}

	@Test(priority = 3) 
	public void System_Defination_VerifyDeactivateSCR() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyDeactivateSCR");
		scr.setDeactivateSCR();
		logger.info("Test System_Defination_VerifyDeactivateSCR is successful");
	}

	@Test(priority = 4)
	public void System_Defination_VerifyReactivateSCR() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyReactivateSCR");
		scr.setReactivateSCR();
		logger.info("Test System_Defination_VerifyReactivateSCR is successful");
	}
}
