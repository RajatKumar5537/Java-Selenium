package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleGroupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class RoleGroupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(RoleGroupTest.class);

    private HomePage homePage;
    private OrganizationUnitDropDown orgUnit;
    private jiviewsMainMenuItems jmMenuItem;
    private EmployeeSetupPage empSetup;
    private SystemDefinationRoleGroupPage roleGroup;

    @BeforeMethod
    public void setUp() throws Exception {
    	String homeUrl = configUtil.getCongigPropertyData("homeurl");
    	driver.navigate().to(homeUrl);
        homePage = new HomePage(driver);
        orgUnit = new OrganizationUnitDropDown(driver);
        jmMenuItem = new jiviewsMainMenuItems(driver);
        empSetup = new EmployeeSetupPage(driver);
        roleGroup = new SystemDefinationRoleGroupPage(driver);

//        homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
        jmMenuItem.clickOnSystemDefination();
        empSetup.setCreateRoleGroups();
    }

    @Test(priority = 1)
    public void verifyCreateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create Role Group");

        roleGroup.createRolesGroup();
    }

    @Test(priority = 2)
    public void verifyUpdateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Update Role Group");

        roleGroup.updateRolesGroup();
    }

    @Test(priority = 3)
    public void verifyDeactivateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Deactivate Role Group");

        roleGroup.deactivateRoleGroup();
    }

    @Test(priority = 4)
    public void verifyCreateRoleGrpWithoutAvailableRole() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create role group without available role Group");

        roleGroup.createRoleGrpWithoutAvailableRole();
    }

    @Test(priority = 5)
    public void verifySearchRoleGroup() throws Exception {
        logger.info("Create role group without available role Group");

        roleGroup.searchRoleGroup();
    }

    @Test(priority = 6)
    public void verifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create role group without role group name");

        roleGroup.createRoleGrpWithoutRoleGrpName();
    }
	
	
}
