package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_3082_SystemDefinationSkillSetupPage;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;



public class E10_3082_SkillSetUpTest extends BaseClass{

	private static final Logger logger = Logger.getLogger(E10_3082_SkillSetUpTest.class.getName());
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
		captureScreenshot(driver, "createNewSkill");
		logger.info("Create a new Skill");

		skillSetup.createNewSkill(fakeEmployee);
		logger.info("A skill is created successfully ");
	}

	@Test(priority = 2) //, dependsOnMethods = "createNewSkill")

	public void E10_3084_VerifyUpdateSkill() throws Exception {
		captureScreenshot(driver, "updateSkill");
		logger.info("Update a Skill");

		skillSetup.updateSkill(fakeEmployee);
		logger.info("A skill is updated successfully ");
	}

	@Test(priority = 3) //, dependsOnMethods= "updateSkill")

	public void E10_3085_VerifyDeactivateSkill() throws Exception {
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
	public void E10_3087_VerifySearchColumnsForSkill() throws Exception {
		captureScreenshot(driver, "searchColumnsForSkill");
		logger.info("Searching a skill");

		skillSetup.setSearchColumns();
		logger.info("Searching a skill is successful");
	}



}
