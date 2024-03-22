package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2608_SystemDefinationRosterCreationPage;

public class SystemDefination_RosterCreationPageTest extends BaseClass
{
	E10_2608_SystemDefinationRosterCreationPage rosterCreation;



	@Test(priority = 1)
	public void E10_2697_VerifyCreateRoasterWithGroup() throws Exception 
	{
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

		rosterCreation.setCreateRoasterwithGroup();
	}

	@Test(priority = 2)
	public void E10_2698_VerifyCreateRoasterwithEmployee() throws Exception 
	{
		rosterCreation.setCreateRoasterwithEmployee();
	}

	@Test(priority = 3)
	public void E10_2738_VerifyUpdateRoaster() throws Exception 
	{
		rosterCreation.setUpdateRoaster();
	}

	@Test(priority = 4)
	public void E10_3151_VerifyDeactiveRoster() throws Exception 
	{
		rosterCreation.setDeactiveRoster();
	}

	@Test(priority = 5)
	public void E10_3152_verifyReactiveRoster() throws Exception 
	{
		rosterCreation.setReactiveRoster();
	}

//	@Test(priority = 6)
//	public void E10_3153_VerifyCreateRoasterWithGroupAndEmp() throws Exception 
//	{
//		rosterCreation.setCreateRoasterwithRosterAndEmp();
//	}

}


