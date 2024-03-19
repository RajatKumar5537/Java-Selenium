package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;

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
	public static final Logger logger = Logger.getLogger(E10_2606_ShiftBandTest.class.getName());
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
		Thread.sleep(2000);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		Thread.sleep(2000);
		
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setCreateRoasterShiftBand();

	}
	@Test(priority = 1)
	public void E10_3115_VerifyCreateShiftBand() throws Exception {

		shiftBand.createShiftBand();
	}

	@Test(priority = 2)
	public void E10_3116_VerifyUpdateShiftBand() throws Exception {

		shiftBand.updateShiftBand();
	}

	@Test(priority = 3)
	public void E10_3117_VerifyDeactivateShiftBand() throws Exception {
		logger.info("E10-3117 Verify Deactivate Shift band...");

		shiftBand.deactiveShiftBand();
		logger.info("E10-3117 Verify Deactivate Shift band is successful");
	}
	@Test(priority = 4)
	public void E10_3118_VerifyReactivateShiftBand() throws Exception {
		logger.info("E10-3118 Verify Reactivate Shift band...");

		shiftBand.reactivateShiftBand();
		logger.info("E10-3118 Verify Reactivate Shift band is successful");
	}
	@Test(priority = 5)
	public void E10_3119_VerifyWithoutShiftBandName() throws Exception {
		logger.info("E10-3119 Verify Without Shift Band Name...");

		shiftBand.withoutShiftBandName();
		logger.info("E10-3119 Verify Without Shift Band Name is successful");
	}

	@Test(priority = 6)
	public void E10_3120_VerifyWithCombinationShift() throws Exception {
		logger.info("E10-3120 Verify With Combination Shift...");

		shiftBand.shiftBandTypeCombinationShift();
		
		logger.info("E10-3120 Verify With Combination Shift is successful");
	}

	@Test(priority = 7)
	public void E10_3121_VerifyWithOvertimeShift() throws Exception {
		logger.info("E10-3121 Verify With Overtime Shift");

		shiftBand.shiftBandTypeOvertimeShift();
		logger.info("E10-3121 Verify With Overtime Shift is successful");
	}
}

