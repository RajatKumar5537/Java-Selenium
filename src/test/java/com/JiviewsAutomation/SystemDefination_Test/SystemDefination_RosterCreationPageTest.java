package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2608_SystemDefinationRosterCreationPage;

public class SystemDefination_RosterCreationPageTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(SystemDefination_RosterCreationPageTest.class.getName());
	public E10_2608_SystemDefinationRosterCreationPage rosterCreation;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateRoasterWithGroup() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateRoasterWithGroup");
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);
		rosterCreation.setCreateRoasterwithGroup();
		logger.info("Test System_Defination_VerifyCreateRoasterWithGroup is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyCreateRoasterwithEmployee() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateRoasterwithEmployee");
		rosterCreation.setCreateRoasterwithEmployee();
		logger.info("Test System_Defination_VerifyCreateRoasterwithEmployee is successful");
	}

	@Test(priority = 3)
	public void System_Defination_VerifyUpdateRoaster() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyUpdateRoaster");
		rosterCreation.setUpdateRoaster();
		logger.info("Test System_Defination_VerifyUpdateRoaster is successful");
	}

	@Test(priority = 4)
	public void System_Defination_VerifyDeactiveRoster() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyDeactiveRoster");
		rosterCreation.setDeactiveRoster();
		logger.info("Test System_Defination_VerifyDeactiveRoster is successful");
	}

	@Test(priority = 5)
	public void System_Defination_verifyReactiveRoster() throws Exception 
	{
		logger.info("Starting test: System_Defination_verifyReactiveRoster");
		rosterCreation.setReactiveRoster();
		logger.info("Test System_Defination_verifyReactiveRoster is successful");
	}

	//	@Test(priority = 6)
	//	public void System_Defination_VerifyCreateRoasterWithGroupAndEmp() throws Exception 
	//	{
	//	logger.info("Starting test: System_Defination_VerifyCreateRoasterWithGroupAndEmp");
	//		rosterCreation.setCreateRoasterwithRosterAndEmp();
	//	logger.info("Test System_Defination_VerifyCreateRoasterWithGroupAndEmp is successful");
	//	}

}


