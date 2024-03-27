package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_SkillPage;



public class SystemDefination_SkillPageTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(SystemDefination_SkillPageTest.class.getName());
	public SystemDefination_SkillPage skillPage;
	
	@Test(priority = 1)
	public void System_Defination_VerifyCreateNewSkill() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateNewSkill");
		skillPage = new SystemDefination_SkillPage(driver);
		skillPage.createNewSkill();
		logger.info("Test System_Defination_VerifyCreateNewSkill is successful");
	}

	@Test(priority = 2) 
	public void System_Defination_VerifyUpdateSkill() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyUpdateSkill");
		skillPage.editSkill();
		logger.info("Test System_Defination_VerifyUpdateSkill is successful");
	}

	@Test(priority = 3) 
	public void System_Defination_VerifyDeactivateSkill() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyDeactivateSkill");
		skillPage.deleteSkill();
		logger.info("Test System_Defination_VerifyDeactivateSkill is successful");
	}

	@Test(priority = 4) 
	public void System_Defination_VerifyReactivateSkill() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyReactivateSkill");
		skillPage.reactivateSkill();
		logger.info("Test System_Defination_VerifyReactivateSkill is successful");
	}

	@Test(priority = 5)
	public void System_Defination_VerifySearchColumnsForSkill() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifySearchColumnsForSkill");
		skillPage.searchColumns();
		logger.info("Test System_Defination_VerifySearchColumnsForSkill is successful");
	}



}
