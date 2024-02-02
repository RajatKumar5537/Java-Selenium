package com.JiviewsAutomation.SystemDefination_Test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2638_SystemDefinationPublicHolidayPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_2638_PublicHolidayTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(E10_2638_PublicHolidayTest.class);

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private E10_2638_SystemDefinationPublicHolidayPage publicHoliday;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		publicHoliday = new E10_2638_SystemDefinationPublicHolidayPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setPubicHoliday();
	}

	@Test(priority = 1)
	public void E10_3128_VerifyCreatePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyCreatePublicHoliday");
		logger.info("E10-3128 Creating public holiday");

		publicHoliday.setCreatePublicHoliday(fakeEmployee);

		logger.info("E10-3128 Public holiday creation successful");
	}

	@Test(priority = 2)//, dependsOnMethods = "verifyCreatePublicHoliday")
	public void E10_3129_VerifyUpdatePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyUpdatePublicHoliday");
		logger.info("E10-3129 Updating public holiday");

		publicHoliday.setUpdatePublicHoliday(fakeEmployee);

		logger.info("E10-3129 Public holiday update successful");
	}

	@Test(priority = 3)//, dependsOnMethods = "verifyUpdatePublicHoliday")
	public void E10_3130_VerifyDeletePublicHoliday() throws Exception {
		captureScreenshot(driver, "verifyDeletePublicHoliday");
		logger.info("E10-3130 Deleting public holiday");

		publicHoliday.setDeactivatePublicHoliday(fakeEmployee);

		logger.info("E10-3130 Deactivate public holiday successful");
	}
}
