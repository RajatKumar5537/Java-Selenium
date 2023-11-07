package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleGroupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class roleGroupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public SystemDefinationRoleGroupPage sdrg;
	
	@Test(priority = 1)
	public void verifyCreateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create Role Group");
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRolesGroup();
	}
	@Test //(priority = 2)
	public void verifyUpdateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Update Role Group");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setUpdateRolesGroup();
	}
	
	@Test //(priority = 3)
	public void verifyDeactivateRoleGroups() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Deactivate Role Group");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setDeactivateRoleGroup();
	}
	
	@Test //(priority = 4)
	public void verifyCreateRoleGrpWithoutAvailableRole() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without available role Group");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRoleGrpWithoutAvailableRole();
	}
	
	@Test //(priority = 5)
	public void verifySearchRoleGroup() throws Exception {
		logger.info("Create role group without available role Group");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setSearchRoleGroup();
	}
	@Test //(priority = 6)
	public void verifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without role group name");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRoleGrpWithoutRoleGrpName();
	}
}
