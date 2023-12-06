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
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class PublicHolidayTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(PublicHolidayTest.class);

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private SystemDefinationPublicHolidayPage publicHoliday;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		publicHoliday = new SystemDefinationPublicHolidayPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setPubicHoliday();
	}

	@Test(priority = 1)
	public void verifyCreatePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyCreatePublicHoliday");
		logger.info("Creating public holiday");

		publicHoliday.setCreatePublicHoliday(fakeEmployee);

		logger.info("Public holiday creation successful");
	}

	@Test(priority = 2)//, dependsOnMethods = "verifyCreatePublicHoliday")
	public void verifyUpdatePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyUpdatePublicHoliday");
		logger.info("Updating public holiday");

		publicHoliday.setUpdatePublicHoliday(fakeEmployee);

		logger.info("Public holiday update successful");
	}

	@Test(priority = 3)//, dependsOnMethods = "verifyUpdatePublicHoliday")
	public void verifyDeletePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyDeletePublicHoliday");
		logger.info("Deleting public holiday");

		publicHoliday.setDeactivatePublicHoliday(fakeEmployee);

		logger.info("Deactivate public holiday successful");
	}
}
