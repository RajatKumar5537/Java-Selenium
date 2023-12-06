package com.JiviewsAutomation.SystemDefination_Test;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


public class ShiftBandTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(ShiftBandTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private SystemDefinationShiftBandPage shiftBand;

	@BeforeMethod
	public void setUp() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		shiftBand = new SystemDefinationShiftBandPage(driver);

		homePage.setOrgUnit();
		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setCreateRoasterShiftBand();

	}
	//	@AfterMethod
	//	public void tearDown() throws IOException {
	//		// Add logic to navigate back to the home URL
	//		String homeUrl = configUtil.getCongigPropertyData("homeurl");
	//		driver.navigate().to(homeUrl);
	//	}
	@Test(priority = 1)
	public void testCreateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Create Shift Band Definition");

		shiftBand.createShiftBand();
	}

	@Test(priority = 2)
	public void testUpdateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify update shiftBand");

		shiftBand.updateShiftBand();
	}

	@Test(priority = 3)
	public void testDeactivateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify Deactivate Shift band");

		shiftBand.deactiveShiftBand();
	}
	@Test(priority = 4)
	public void testReactivateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify Reactivate Shift band");

		shiftBand.reactivateShiftBand();
	}
	@Test(priority = 5)
	public void testWithoutShiftBandName() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify Without Shift Band Name");

		shiftBand.withoutShiftBandName();
	}

	@Test(priority = 6)
	public void testWithCombinationShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify With Combination Shift");

		shiftBand.shiftBandTypeCombinationShift();
	}

	@Test(priority = 7)
	public void testWithOvertimeShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Verify With Overtime Shift");

		shiftBand.shiftBandTypeOvertimeShift();
	}
}

