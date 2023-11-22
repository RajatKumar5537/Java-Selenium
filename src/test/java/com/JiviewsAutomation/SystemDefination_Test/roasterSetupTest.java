package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationRosterCreationPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class roasterSetupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private SystemDefinationRosterCreationPage rosterCreation;
	

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new SystemDefinationRosterCreationPage(driver);
		
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();
	}
	@Test(priority = 1)
	public void verifyCreateRoasterWithGroup() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("Creating Roaster with Employee...");
		
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


	// We can do it later............... 
	//	@Test
	//	public void verifyCreateRoasterWithGroupAndEmp() throws Exception {
	//		captureScreenshot(driver, "roasterSetupTest");
	//
	//		homePage=new HomePage(driver);
	//		orgUnit= new OrganizationUnitDropDown(driver);
	//		jmMenuItem= new jiviewsMainMenuItems(driver);
	//		rosterSetup= new RosterSetupPage(driver);
	//		rosterCreation= new SystemDefinationRosterSetupPage(driver);
	//
	//		homePage.setOrgUnit();
	//		orgUnit.setAutoOu();
	//		jmMenuItem.clickOnSystemDefination();
	//		rosterSetup.setRosterCreation();
	//		rosterCreation.setCreateRoasterwithRosterAndEmp();
	//	}

	@Test(priority = 3)
	public void verifyUpdateRoaster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		
		rosterCreation.setUpdateRoaster();
	}
	@Test(priority = 4)//,dependsOnMethods = "verifyUpdateRoaster")
	public void verifyDeactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		rosterCreation.setDeactiveRoster();
	}
	@Test(priority = 5)//, dependsOnMethods = "verifyDeactiveRoster")
	public void verifyReactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		
		rosterCreation.setReactiveRoster();
	}
}
