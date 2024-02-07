package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2749_SystemDefinationRoleGroupPage;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_2749_RoleGroupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_2749_RoleGroupTest.class);

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeSetupPage empSetup;
	private E10_2749_SystemDefinationRoleGroupPage roleGroup;

	@BeforeMethod
	public void setUp() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empSetup = new EmployeeSetupPage(driver);
		roleGroup = new E10_2749_SystemDefinationRoleGroupPage(driver);

		
		//        homePage.setOrgUnit();
		//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		empSetup.setCreateRoleGroups();
	}

	@Test(priority = 1)
	public void E10_3122_VerifyCreateRoleGroups() throws Exception {
		captureScreenshot(driver, "RoleGroupTest");
		logger.info("E10-3122 Create Role Group...");
		
		roleGroup.createRolesGroup();
		logger.info("E10-3122 Create Role Group is successful");
	}

	@Test(priority = 2)
	public void E10_3123_VerifyUpdateRoleGroups() throws Exception {
		captureScreenshot(driver, "RoleGroupTest");
		logger.info("E10-3123 Update Role Group");

		roleGroup.updateRolesGroup();
		logger.info("E10-3123 Update Role Group is successful");
	}

	@Test(priority = 3)
	public void E10_3124_VerifyDeactivateRoleGroups() throws Exception {
		captureScreenshot(driver, "RoleGroupTest");
		logger.info("E10-3124 Deactivate Role Group...");

		roleGroup.deactivateRoleGroup();
		logger.info("E10-3124 Deactivate Role Group is successful");
	}

	@Test(priority = 4)
	public void E10_3125_VerifyCreateRoleGrpWithoutAvailableRole() throws Exception {
		captureScreenshot(driver, "RoleGroupTest");
		logger.info("E10-3125 Create role group without available role Group...");

		roleGroup.createRoleGrpWithoutAvailableRole();
		logger.info("E10-3125 Create role group without available role Group is successful");
	}

	@Test(priority = 5)
	public void E10_3126_VerifySearchRoleGroup() throws Exception {
		logger.info("E10-3126 Create role group without available role Group...");

		roleGroup.searchRoleGroup();
		logger.info("E10-3126 Create role group without available role Group is successful");
	}

	@Test(priority = 6)
	public void E10_3127_VerifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
		captureScreenshot(driver, "RoleGroupTest");
		logger.info("E10-3127 Create role group without role group name...");

		roleGroup.createRoleGrpWithoutRoleGrpName();
		logger.info("E10-3127 Create role group without role group name is successful");

	}
}
