package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationPublicHolidayPage;
import com.AutomationJiviewsPOM.SystemDefinationSCRPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class SCRTest extends BaseClass{


	private static final Logger logger = LogManager.getLogger(SCRTest.class);
	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public RosterSetupPage rsp;
	public SystemDefinationSCRPage scr;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		hp = new HomePage(driver);
		oudd = new OrganizationUnitDropDown(driver);
		jmmi = new jiviewsMainMenuItems(driver);
		rsp = new RosterSetupPage(driver);
		scr = new SystemDefinationSCRPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setScheduleCreationRules();
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
