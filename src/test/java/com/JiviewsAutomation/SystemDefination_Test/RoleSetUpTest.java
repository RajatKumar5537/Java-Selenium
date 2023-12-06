package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class RoleSetUpTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(RoleSetUpTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	public EmployeeSetupPage empSetup;
	public SystemDefinationRoleSetupPage roleSetup;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empSetup = new EmployeeSetupPage(driver);
		roleSetup = new SystemDefinationRoleSetupPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		empSetup.setCreateRole();
	}
//	@AfterMethod
//	public void tearDown() throws IOException {
//		String homeUrl = configUtil.getCongigPropertyData("homeurl");
//		driver.navigate().to(homeUrl);
//	}

	@Test(priority = 1)
	public void verifyCreateNewRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("Create a new Skill");

		roleSetup.setCreateNewRole();
		logger.info("verify Create a new role is successful");
	}

	@Test(priority = 2)
	public void verifyUpdateRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setUpdateRole();
		logger.info("Verify Update Role successful");
	}

	@Test(priority = 3)//, dependsOnMethods = "verifyUpdateRole")
	public void verifyDeactiveRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setDeactiveRole();
		logger.info("Verify Deactive Role is successful");
	}

	@Test(priority = 4, dependsOnMethods = "verifyDeactiveRole")
	public void verifyReactiveRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setReactiveRole();
		logger.info("Verify Reactive Role is successful");
	}

	@Test(priority = 5)
	public void verifyCreateRoleWithAllAvailableSkill()throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setCreateNewRoleWithAllAvailableSkill();
		logger.info("Verify create a role with all available skill");
	}

	@Test(priority = 6)
	public void verifyDisselectAllAvailableSkill() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setDisselectAllAvailableSkill();
		logger.info("Verify disselect all available skill");
	}

	@Test  (priority = 7)
	public void verifySearchColumnsForRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setSearchColumnsForRole();
		logger.info("verify Search Columns For Role is successfull");
	}

	@Test (priority = 8)
	public void verifyCreateNewRoleWithoutRoleCode() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setCreateNewRoleWithoutRoleCode();
		logger.info("verify create new role without role code");
	}

	@Test (priority = 9)
	public void verifyCreateNewRoleWithoutRoleDescription() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setCreateNewRoleWithoutRoleDescription();
		logger.info("verify create new role without role description");
	}
	@Test (priority = 10)
	public void verifyCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setCreateNewRoleWithoutSecondarySkillEmpty();
		logger.info("verify Create New Role Without Secondary Skill Empty is successfull");
	}
	@Test (priority = 11)
	public void verifyDisselectSingleSkillFromSelectedSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setDisSelectSingleSkillFromSelectedSkill();
		logger.info("verify Disselect Single Skill From Selected Skill is successfull");
	}
	@Test(priority = 12)
	public void verifyCreateNewRoleWithoutPriarySkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");

		roleSetup.setCreateNewRoleWithoutPriarySkill();
		logger.info("verify create new role without priary skill");
	}

}
