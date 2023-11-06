package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationPublicHolidayPage;
import com.AutomationJiviewsPOM.SystemDefinationSCRPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class SCRTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public RosterSetupPage rsp; //setScheduleCreationRules()
	public SystemDefinationSCRPage scr;
	
	@Test
	public void verifyCreateSCR ()throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Create SCR");
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		scr= new SystemDefinationSCRPage(driver);
		
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setScheduleCreationRules();
		scr.setCreateSCR();
		
		logger.info("Create a SCR is successfull");
	}
	
	@Test(dependsOnMethods = "verifyCreateSCR"  )
	public void verifyUpdateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Create SCR");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		scr= new SystemDefinationSCRPage(driver);
		
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setScheduleCreationRules();
		scr.setUpdateSCR();
	}
	@Test(dependsOnMethods = "verifyUpdateSCR"  )
	public void verifyDelectSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Create SCR");
		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		scr= new SystemDefinationSCRPage(driver);
		
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setScheduleCreationRules();
		scr.setDeleteSCR();
	}
}
