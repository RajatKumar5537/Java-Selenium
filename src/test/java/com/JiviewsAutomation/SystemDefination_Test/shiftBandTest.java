package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


public class shiftBandTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);
	
	@Test 
	public void verifyCreateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Create Shift Band Difinition");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);
		sb.createShiftBand();
	}
	
	@Test
	public void verifyUpdateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify update shiftBand");
		
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);
		sb.updateShiftBand();
	}
	
	@Test
	public void verifyDeactiveShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify Deactive Shift band");
		
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);
		sb.deactiveShiftBand();
	}
	@Test
	public void verifyWithoutShiftBandName() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify Without Shift Band Name");

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);
		sb.withoutShiftBandName();
	}
	@Test
	public void verifyWithCombinationShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify With Combination Shift");

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);	
		sb.shiftBandTypeCombinationShift();
		Thread.sleep(2000);	
	}
	@Test
	public void verifyWithOvertimeShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify With Overtime Shift");

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		Thread.sleep(2000);		
		sb.shiftBandTypeOvertimeShift();
	}

}

