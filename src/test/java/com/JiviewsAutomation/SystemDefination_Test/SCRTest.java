package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationPublicHolidayPage;
import com.AutomationJiviewsPOM.SystemDefinationSCRPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class SCRTest extends BaseClass{


	private static final Logger logger = LogManager.getLogger(SCRTest.class);
	public HomePage homePage;
	public OrganizationUnitDropDown orgUnit;
	public jiviewsMainMenuItems jmMenuItem;
	public EmployeeSetupPage empSetup;
	public RosterSetupPage rosterSetup;
	public SystemDefinationSCRPage scr;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		scr = new SystemDefinationSCRPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setScheduleCreationRules();
	}

	@Test(priority = 1)
	public void testCreateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Create SCR");

		scr.setCreateSCR();
		logger.info("Create a SCR is successful");
	}

	@Test(priority = 2)
	public void testUpdateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Update SCR");

		scr.setUpdateSCR();
	}

	@Test(priority = 3,  dependsOnMethods = "testUpdateSCR")
	public void testDeactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Deactivate SCR");

		scr.setDeactivateSCR();
	}

	@Test(priority = 4, dependsOnMethods = "testDeactivateSCR")
	public void testReactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Reactive SCR");

		scr.setReactivateSCR();
	}
}
