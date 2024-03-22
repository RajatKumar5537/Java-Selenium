package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.SystemDefination_RolePage;


public class System_Defination_RolePageTest extends BaseClass
{

	SystemDefination_RolePage roleSetup;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateNewRole() throws Exception 
	{
		roleSetup = new SystemDefination_RolePage(driver);
		roleSetup.createNewRole();
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdateRole() throws Exception
	{
		roleSetup.editRole();
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeactiveRole() throws Exception
	{
		roleSetup.deleteRole();
	}

	@Test(priority = 4)
	public void System_Defination_VerifyReactiveRole() throws Exception
	{
		roleSetup.reactiveRole();
	}

}
