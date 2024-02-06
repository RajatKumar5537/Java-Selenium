package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2639_SystemDefinationSCRPage;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_2639_SCRTest extends BaseClass{


	private static final Logger logger = LogManager.getLogger(E10_2639_SCRTest.class);
	public HomePage homePage;
	public OrganizationUnitDropDown orgUnit;
	public jiviewsMainMenuItems jmMenuItem;
	public EmployeeSetupPage empSetup;
	public RosterSetupPage rosterSetup;
	public E10_2639_SystemDefinationSCRPage scr;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		rosterSetup = new RosterSetupPage(driver);
		scr = new E10_2639_SystemDefinationSCRPage(driver);

//		homePage.setOrgUnit();
//		orgUnit.clickOLMop();
		
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		Thread.sleep(2000);
		jmMenuItem.clickOnSystemDefination();
		Thread.sleep(2000);
		rosterSetup.setScheduleCreationRules();
	
	}

	@Test(priority = 1)
	public void E10_3131_VerifyCreateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("E10-3131 Create SCR");

		scr.setCreateSCR();
		logger.info("E10-3131 Create a SCR is successful");
	}

	@Test(priority = 2)
	public void E10_3132_VerifyUpdateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("E10-3132 Update SCR");

		scr.setUpdateSCR();
		logger.info("E10-3132 Update SCR is successful");
	}

	@Test(priority = 3) //,  dependsOnMethods = "E10_3132_VerifyUpdateSCR")
	public void E10_3133_VerifyDeactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("E10-3133 Deactivate SCR");

		scr.setDeactivateSCR();
		logger.info("E10-3133 Deactivate SCR is successful");
	}

	@Test(priority = 4, dependsOnMethods = "E10_3133_VerifyDeactivateSCR")
	public void E10_3134_VerifyReactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("E10-3134 Reactive SCR");

		scr.setReactivateSCR();
		logger.info("E10-3134 Reactive SCR is successful");
	}
}
