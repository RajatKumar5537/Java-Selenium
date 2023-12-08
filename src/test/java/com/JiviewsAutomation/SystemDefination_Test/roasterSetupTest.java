package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationRosterCreationPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class roasterSetupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(roasterSetupTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private SystemDefinationRosterCreationPage rosterCreation;


	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new SystemDefinationRosterCreationPage(driver);

		homePage.setOrgUnit();
		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();
	}
	@Test(priority = 1)
	public void verifyCreateRoasterWithGroup() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("Creating Roaster with Roster Group ...");

		Thread.sleep(2000);
		rosterCreation.setCreateRoasterwithGroup();
		logger.info("Create a Roster Pattern with Roster Group is successfull");
	}

	@Test(priority = 2)
	public void verifyCreateRoasterwithEmployee() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("Creating Roaster with Employee...");

		rosterCreation.setCreateRoasterwithEmployee();
		logger.info("Creating Roaster with Employee is successful");
	}

	@Test(priority = 3)
	public void verifyUpdateRoaster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		rosterCreation.setUpdateRoaster();
		logger.info("Update Roaster with Employee is successful");
		
	}
	@Test(priority = 4)//,dependsOnMethods = "verifyUpdateRoaster")
	public void verifyDeactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		rosterCreation.setDeactiveRoster();
		logger.info("Deactivate Roaster is successful");
	}
	@Test(priority = 5)//, dependsOnMethods = "verifyDeactiveRoster")
	public void verifyReactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		rosterCreation.setReactiveRoster();
		logger.info("Reactivate Roaster is successful");
	}
	@Test(priority = 6)
	public void verifyCreateRoasterWithGroupAndEmp() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		rosterCreation.setCreateRoasterwithRosterAndEmp();
		logger.info("Roaster with Roster Group and Employee is successful");
	}
	
//	@Test
//	public void verifyMoveAllAndPublishAll()throws Exception {
//		captureScreenshot(driver, "roasterSetupTest");
//
//		rosterCreation.setMoveAllAndPublishAll();
//		logger.info("Roaster with Roster Group and Employee is successful");	
//	}
}
