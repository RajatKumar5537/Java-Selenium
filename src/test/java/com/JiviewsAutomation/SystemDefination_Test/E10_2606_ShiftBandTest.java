package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2606_SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


public class E10_2606_ShiftBandTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_2606_ShiftBandTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private E10_2606_SystemDefinationShiftBandPage shiftBand;

	@BeforeMethod
	public void setUp() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		shiftBand = new E10_2606_SystemDefinationShiftBandPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
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
	public void E10_3115_VerifyCreateShiftBand() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10_3115 Create Shift Band Definition...");

		shiftBand.createShiftBand();
		logger.info("E10_3115 Create Shift Band Definition is successful");
	}

	@Test(priority = 2)
	public void E10_3116_VerifyUpdateShiftBand() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3116 Verify update shiftBand...");

		shiftBand.updateShiftBand();
		logger.info("E10-3116 Verify update shiftBand is successful");
	}

	@Test(priority = 3)
	public void E10_3117_VerifyDeactivateShiftBand() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3117 Verify Deactivate Shift band...");

		shiftBand.deactiveShiftBand();
		logger.info("E10-3117 Verify Deactivate Shift band is successful");
	}
	@Test(priority = 4)
	public void E10_3118_VerifyReactivateShiftBand() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3118 Verify Reactivate Shift band...");

		shiftBand.reactivateShiftBand();
		logger.info("E10-3118 Verify Reactivate Shift band is successful");
	}
	@Test(priority = 5)
	public void E10_3119_VerifyWithoutShiftBandName() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3119 Verify Without Shift Band Name...");

		shiftBand.withoutShiftBandName();
		logger.info("E10-3119 Verify Without Shift Band Name is successful");
	}

	@Test(priority = 6)
	public void E10_3120_VerifyWithCombinationShift() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3120 Verify With Combination Shift...");

		shiftBand.shiftBandTypeCombinationShift();
		logger.info("E10-3120 Verify With Combination Shift is successful");
	}

	@Test(priority = 7)
	public void E10_3121_VerifyWithOvertimeShift() throws Exception {
		captureScreenshot(driver, "E10_2606_ShiftBandTest");
		logger.info("E10-3121 Verify With Overtime Shift");

		shiftBand.shiftBandTypeOvertimeShift();
		logger.info("E10-3121 Verify With Overtime Shift is successful");
	}
}

