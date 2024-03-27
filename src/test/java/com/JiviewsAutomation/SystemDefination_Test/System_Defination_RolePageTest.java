package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_RolePage;


public class System_Defination_RolePageTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(System_Defination_RolePageTest.class.getName());
	public SystemDefination_RolePage roleSetup;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateNewRole() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateNewRole");
		roleSetup = new SystemDefination_RolePage(driver);
		roleSetup.createNewRole();
		logger.info("Test System_Defination_VerifyCreateNewRole is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdateRole() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyUpdateRole");
		roleSetup.editRole();
		logger.info("Test System_Defination_VerifyUpdateRole is successful");
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeactiveRole() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyDeactiveRole");
		roleSetup.deleteRole();
		logger.info("Test System_Defination_VerifyDeactiveRole is successful");
	}

	@Test(priority = 4)
	public void System_Defination_VerifyReactiveRole() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyReactiveRole");
		roleSetup.reactiveRole();
		logger.info("Test System_Defination_VerifyReactiveRole is successful");
	}

}
