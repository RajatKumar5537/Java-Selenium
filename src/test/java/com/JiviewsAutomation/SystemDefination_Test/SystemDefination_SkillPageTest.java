package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_SkillPage;



public class SystemDefination_SkillPageTest extends BaseClass{
	
	SystemDefination_SkillPage skillPage;
	
	@Test(priority = 1)
	public void System_Defination_VerifyCreateNewSkill() throws Exception {
		skillPage = new SystemDefination_SkillPage(driver);
		
		skillPage.createNewSkill();
	}

	@Test(priority = 2) 
	public void System_Defination_VerifyUpdateSkill() throws Exception 
	{

		skillPage.editSkill();
	}

	@Test(priority = 3) 
	public void System_Defination_VerifyDeactivateSkill() throws Exception 
	{

		skillPage.deleteSkill();
	}

	@Test(priority = 4) 
	public void System_Defination_VerifyReactivateSkill() throws Exception 
	{

		skillPage.reactivateSkill();
	}

	@Test(priority = 5)
	public void System_Defination_VerifySearchColumnsForSkill() throws Exception 
	{
		skillPage.searchColumns();
	}



}
