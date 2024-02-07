package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2608_SystemDefinationRosterCreationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_2608_RoasterSetupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_2608_RoasterSetupTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private RosterSetupPage rosterSetup;
	private E10_2608_SystemDefinationRosterCreationPage rosterCreation;


//	@BeforeMethod
//	public void setup() throws Exception {
//		String homeUrl = configUtility.getCongigPropertyData("homeurl");
//		driver.navigate().to(homeUrl);
//		homePage=new HomePage(driver);
//		orgUnit= new OrganizationUnitDropDown(driver);
//		jmMenuItem= new jiviewsMainMenuItems(driver);
//		rosterSetup= new RosterSetupPage(driver);
//		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);
//
//		Thread.sleep(2000);
//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
//		jmMenuItem.clickOnSystemDefination();
//		rosterSetup.setRosterCreation();
//	}
	@Test(priority = 1)
	public void E10_2697_VerifyCreateRoasterWithGroup() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("E10-2697 Creating Roaster with Roster Group ...");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

		Thread.sleep(2000);
		homePage.setOrgUnit();
		Thread.sleep(2000);
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		Thread.sleep(2000);
		rosterCreation.setCreateRoasterwithGroup();
		logger.info("E10-2697 Create a Roster Pattern with Roster Group is successfull");
	}

	@Test(priority = 2)
	public void E10_2698_VerifyCreateRoasterwithEmployee() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("E10-2698 Creating Roaster with Employee...");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		rosterCreation.setCreateRoasterwithEmployee();
		logger.info("E10-2698 Creating Roaster with Employee is successful");
	}

	@Test(priority = 3)
	public void E10_2738_VerifyUpdateRoaster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		logger.info("E10-2738 Update Roaster with Employee...");

		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.clickOLMop();
//		Thread.sleep(2000);
//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		rosterCreation.setUpdateRoaster();
		logger.info("E10-2738 Update Roaster with Employee is successful");

	}
	@Test(priority = 4)
	public void E10_3151_VerifyDeactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.clickOLMop();
//		Thread.sleep(2000);
//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		rosterCreation.setDeactiveRoster();
		logger.info("Deactivate Roaster is successful");
	}
	@Test(priority = 5)
	public void E10_3152_verifyReactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.clickOLMop();
//		Thread.sleep(2000);
//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		rosterCreation.setReactiveRoster();
		logger.info("Reactivate Roaster is successful");
	}
	@Test(priority = 6)
	public void E10_3153_VerifyCreateRoasterWithGroupAndEmp() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage=new HomePage(driver);
		orgUnit= new OrganizationUnitDropDown(driver);
		jmMenuItem= new jiviewsMainMenuItems(driver);
		rosterSetup= new RosterSetupPage(driver);
		rosterCreation= new E10_2608_SystemDefinationRosterCreationPage(driver);

//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.clickOLMop();
//		Thread.sleep(2000);
//		homePage.setOrgUnit();
//		Thread.sleep(2000);
//		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		rosterSetup.setRosterCreation();

		rosterCreation.setCreateRoasterwithRosterAndEmp();
		logger.info("Roaster with Roster Group and Employee is successful");
	}
	
}
