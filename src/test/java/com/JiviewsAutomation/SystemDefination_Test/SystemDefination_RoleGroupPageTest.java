package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2749_SystemDefinationRoleGroupPage;

public class SystemDefination_RoleGroupPageTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(SystemDefination_RoleGroupPageTest.class.getName());
	public E10_2749_SystemDefinationRoleGroupPage roleGroup;
	
	@Test(priority = 1)
	public void SystemDefination_VerifyCreateRoleGroups() throws Exception 
	{
		logger.info("Starting test: SystemDefination_VerifyCreateRoleGroups");
		roleGroup = new E10_2749_SystemDefinationRoleGroupPage(driver);
		roleGroup.createRolesGroup();
		logger.info("Test SystemDefination_VerifyCreateRoleGroups is successful");
	}

	@Test(priority = 2)
	public void SystemDefination_VerifyUpdateRoleGroups() throws Exception 
	{
		logger.info("Starting test: SystemDefination_VerifyUpdateRoleGroups");
		roleGroup.updateRolesGroup();
		logger.info("Test SystemDefination_VerifyUpdateRoleGroups is successful");
	}

	@Test(priority = 3)
	public void SystemDefination_VerifyDeactivateRoleGroups() throws Exception 
	{
		logger.info("Starting test: SystemDefination_VerifyDeactivateRoleGroups");
		roleGroup.deactivateRoleGroup();
		logger.info("Test SystemDefination_VerifyDeactivateRoleGroups is successful");
	}
	
	@Test(priority = 4)
	public void SystemDefination_VerifyCreateRoleGrpWithoutAvailableRole() throws Exception 
	{
		logger.info("Starting test: SystemDefination_VerifyCreateRoleGrpWithoutAvailableRole");
		roleGroup.createRoleGrpWithoutAvailableRole();
		logger.info("Test SystemDefination_VerifyCreateRoleGrpWithoutAvailableRole is successful");
	}


	@Test(priority = 5)
	public void SystemDefination_VerifyCreateRoleGrpWithoutRoleGrpName() throws Exception 
	{
		logger.info("Starting test: SystemDefination_VerifyCreateRoleGrpWithoutRoleGrpName");
		roleGroup.createRoleGrpWithoutRoleGrpName();
		logger.info("Test SystemDefination_VerifyCreateRoleGrpWithoutRoleGrpName is successful");
	}
}
