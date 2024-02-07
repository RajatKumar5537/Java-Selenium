package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3089_SystemDefinationRoleSetupPage;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_3089_RoleSetUpTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(E10_3089_RoleSetUpTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeSetupPage empSetup;
	private E10_3089_SystemDefinationRoleSetupPage roleSetup;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empSetup = new EmployeeSetupPage(driver);
		roleSetup = new E10_3089_SystemDefinationRoleSetupPage(driver);

		//		homePage.setOrgUnit();
		//		orgUnit.clickOLMop();
		
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		empSetup.setCreateRole();
	}

	@Test(priority = 1)
	public void E10_3090_VerifyCreateNewRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3090_ Create a new Skill...");

		roleSetup.setCreateNewRole();
		logger.info("E10_3090_ Verify Create a new role is successful");
	}

	@Test(priority = 2)
	public void E10_3091_VerifyUpdateRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3091_ Update a Skill...");

		roleSetup.setUpdateRole();
		logger.info("E10-3091_Verify Update Role successful");
	}

	@Test(priority = 3)//, dependsOnMethods = "verifyUpdateRole")
	public void E10_3092_VerifyDeactiveRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3092_ Deactivate a Skill...");

		roleSetup.setDeactiveRole();
		logger.info("E10-3092 Verify Deactive Role is successful");
	}

	@Test(priority = 4, dependsOnMethods = "E10_3092_VerifyDeactiveRole")
	public void E10_3093_VerifyReactiveRole() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3093_ Reactive a Skill...");

		roleSetup.setReactiveRole();
		logger.info("E10-3093 Verify Reactive Role is successful");
	}

	@Test(priority = 5)
	public void E10_3094_VerifyCreateRoleWithAllAvailableSkill()throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3094_Create a role with all available skill... ");

		roleSetup.setCreateNewRoleWithAllAvailableSkill();
		logger.info("E10-3094 Verify create a role with all available skill");
	}

	@Test(priority = 6)
	public void E10_3095_VerifyDisselectAllAvailableSkill() throws Exception{
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10_3095_Verify disselect all available skill...");

		roleSetup.setDisselectAllAvailableSkill();
		logger.info("E10_3095_Verify disselect all available skill is successful");
	}

	@Test  (priority = 7)
	public void E10_3099_verifySearchColumnsForRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3099 Verify Search Columns For Role...");

		roleSetup.setSearchColumnsForRole();
		logger.info("E10-3099 Verify Search Columns For Role is successfull");
	}

	@Test (priority = 8)
	public void E10_3100_verifyCreateNewRoleWithoutRoleCode() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3100 Verify create new role without role code...");

		roleSetup.setCreateNewRoleWithoutRoleCode();
		logger.info("E10-3100 Verify create new role without role code is successfull");
	}

	@Test (priority = 9)
	public void E10_3101_VerifyCreateNewRoleWithoutRoleDescription() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3101 Verify create new role without role description...");

		roleSetup.setCreateNewRoleWithoutRoleDescription();
		logger.info("E10-3101 Verify create new role without role description is successfull");
	}
	@Test (priority = 10)
	public void E10_3102_verifyCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3102 Verify Create New Role Without Secondary Skill Empty...");

		roleSetup.setCreateNewRoleWithoutSecondarySkillEmpty();
		logger.info("E10-3102 Verify Create New Role Without Secondary Skill Empty is successfull");
	}
	@Test (priority = 11)
	public void E10_3103_VerifyDisselectSingleSkillFromSelectedSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3103 Verify Disselect Single Skill From Selected Skill...");

		roleSetup.setDisSelectSingleSkillFromSelectedSkill();
		logger.info("E10-3103 Verify Disselect Single Skill From Selected Skill is successfull");
	}
	@Test(priority = 12)
	public void E10_3104_VerifyCreateNewRoleWithoutPriarySkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("E10-3104 Verify create new role without priary skill...");
		
		roleSetup.setCreateNewRoleWithoutPriarySkill();
		logger.info("E10-3104 Verify create new role without priary skill is successfull");
	}

}
