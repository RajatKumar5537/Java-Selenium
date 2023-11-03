package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationRosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class roasterSetupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public RosterSetupPage rsp;
	public SystemDefinationRosterSetupPage sdrs;
	


	@Test
	public void verifyCreateRoasterWithGroup() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setRosterCreation();
		sdrs.setCreateRoasterwithGroup();
		logger.info("Create a Roster Pattern with Roster Group is successfull");
	}

	@Test
	public void verifyCreateRoasterwithEmployee() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		rsp.setRosterCreation();
		sdrs.setCreateRoasterwithEmployee();

	}


	// We can do it later............... 
	//	@Test
	//	public void verifyCreateRoasterWithGroupAndEmp() throws Exception {
	//		captureScreenshot(driver, "roasterSetupTest");
	//
	//		hp=new HomePage(driver);
	//		oudd= new OrganizationUnitDropDown(driver);
	//		jmmi= new jiviewsMainMenuItems(driver);
	//		rsp= new RosterSetupPage(driver);
	//		sdrs= new SystemDefinationRosterSetupPage(driver);
	//
	//		hp.setOrgUnit();
	//		oudd.setAutoOu();
	//		jmmi.clickOnSystemDefination();
	//		rsp.setRosterCreation();
	//		sdrs.setCreateRoasterwithRosterAndEmp();
	//	}

	@Test
	public void verifyUpdateRoaster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		rsp.setRosterCreation();
		sdrs.setUpdateRoaster();
	}
	@Test
	public void verifyDeactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		rsp.setRosterCreation();
		sdrs.setDeactiveRoster();
	}
	@Test(dependsOnMethods = "verifyDeactiveRoster")
	public void verifyReactiveRoster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		rsp.setRosterCreation();
		sdrs.setReactiveRoster();
	}
}
