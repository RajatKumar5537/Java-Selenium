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
	public void verifyCreateRoaster() throws Exception {
		captureScreenshot(driver, "roasterSetupTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdrs= new SystemDefinationRosterSetupPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setRosterCreation();
		Thread.sleep(2000);
		sdrs.setCreateRoaster();
		logger.info("A roaster is created successfully ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
