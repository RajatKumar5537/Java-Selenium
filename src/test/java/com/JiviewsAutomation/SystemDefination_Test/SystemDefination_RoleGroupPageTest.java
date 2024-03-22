package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2749_SystemDefinationRoleGroupPage;

public class SystemDefination_RoleGroupPageTest extends BaseClass
{

	public E10_2749_SystemDefinationRoleGroupPage roleGroup;
	
	@Test(priority = 1)
	public void E10_3122_VerifyCreateRoleGroups() throws Exception 
	{
		roleGroup = new E10_2749_SystemDefinationRoleGroupPage(driver);

		roleGroup.createRolesGroup();
	}

	@Test(priority = 2)
	public void E10_3123_VerifyUpdateRoleGroups() throws Exception 
	{
		roleGroup.updateRolesGroup();
	}

	@Test(priority = 3)
	public void E10_3124_VerifyDeactivateRoleGroups() throws Exception 
	{
		roleGroup.deactivateRoleGroup();
	}
	
	@Test(priority = 4)
	public void E10_3125_VerifyCreateRoleGrpWithoutAvailableRole() throws Exception 
	{
		roleGroup.createRoleGrpWithoutAvailableRole();
	}


	@Test(priority = 5)
	public void E10_3127_VerifyCreateRoleGrpWithoutRoleGrpName() throws Exception 
	{
		roleGroup.createRoleGrpWithoutRoleGrpName();

	}
}
