package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3082_SystemDefinationSkillSetupPage;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


// Jira ID-: E10-3082 [System Definition] [Employee Setup] Skill
public class E10_3082_SkillSetUpTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(E10_3082_SkillSetUpTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeSetupPage empSetup;
	private E10_3082_SystemDefinationSkillSetupPage skillSetup;

//	@BeforeMethod
	@Test(priority = 0)
	public void setUp() throws Exception {
		
//		String homeUrl = configUtility.getCongigPropertyData("homeurl");
//		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empSetup = new EmployeeSetupPage(driver);
		skillSetup = new E10_3082_SystemDefinationSkillSetupPage(driver);

		//	        homePage.setOrgUnit();
		
		//			orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		empSetup.setCreateSkill();

	}

	@Test(priority = 1)
	public void E10_3083_VerifyCreateNewSkill() throws Exception {
		// Jira Item: E10-3083 - Create a new Skill
		captureScreenshot(driver, "createNewSkill");
		logger.info("Create a new Skill");

		skillSetup.createNewSkill(fakeEmployee);
		logger.info("A skill is created successfully ");
	}

	@Test(priority = 2) //, dependsOnMethods = "createNewSkill")

	public void E10_3084_VerifyUpdateSkill() throws Exception {
		// Jira Item: E10-3084
		captureScreenshot(driver, "updateSkill");
		logger.info("Update a Skill");

		skillSetup.updateSkill();
		logger.info("A skill is updated successfully ");
	}

	@Test(priority = 3) //, dependsOnMethods= "updateSkill")

	public void E10_3085_VerifyDeactivateSkill() throws Exception {
		// Jira Item: E10-3085
		captureScreenshot(driver, "deActivateSkill");
		logger.info("Deactivate a Skill");

		skillSetup.deactivateSkill();
		logger.info("A skill is deactivated successfully ");
	}

	@Test(priority = 4) //, dependsOnMethods ="deActivateSkill")
	
	public void E10_3086_VerifyReactivateSkill() throws Exception {
		// Jira Item: E10-3086
		captureScreenshot(driver, "reactivateSkill");
		logger.info("Reactivate a Skill");

		skillSetup.activateDeactivateSkill();
		logger.info("A skill is reactivated successfully ");
	}

	@Test(priority = 5)
	// Jira Item: E10-3087
	public void E10_3087_VerifySearchColumnsForSkill() throws Exception {
		captureScreenshot(driver, "searchColumnsForSkill");
		logger.info("Searching a skill");

		skillSetup.setSearchColumns();
		logger.info("Searching a skill is successful");
	}



}
