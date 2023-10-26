package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


public class RoaserSetupTest extends BaseClass{

	@Test 
	public void verifyCreateShiftBand() throws Exception {

		System.out.println("Create Shift Band Difinition");
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
		System.out.println("Create Shift Band Difinition");
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
		System.out.println("Create Shift Band Difinition");
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
		System.out.println("Create Shift Band Difinition");
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
		System.out.println("Create Shift Band Difinition");
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
		System.out.println("Create Shift Band Difinition");
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

