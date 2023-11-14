package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
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
	
	
	  private static final Logger logger = LogManager.getLogger(SCRTest.class);

	    public HomePage hp;
	    public OrganizationUnitDropDown oudd;
	    public jiviewsMainMenuItems jmmi;
	    public EmployeeSetupPage esp;
	    public RosterSetupPage rsp;
	    public SystemDefinationSCRPage scr;

	    @BeforeMethod
	    public void setup() throws Exception {
	        hp = new HomePage(driver);
	        oudd = new OrganizationUnitDropDown(driver);
	        jmmi = new jiviewsMainMenuItems(driver);
	        rsp = new RosterSetupPage(driver);
	        scr = new SystemDefinationSCRPage(driver);

	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setScheduleCreationRules();
	    }

	    @Test(priority = 1)
	    public void verifyCreateSCR() throws Exception {
	        captureScreenshot(driver, "SCRTest");
	        logger.info("Create SCR");

	        scr.setCreateSCR();
	        logger.info("Create a SCR is successful");
	    }

	    @Test(priority = 2)
	    public void verifyUpdateSCR() throws Exception {
	        captureScreenshot(driver, "SCRTest");
	        logger.info("Update SCR");

	        scr.setUpdateSCR();
	    }

	    @Test(priority = 3,  dependsOnMethods = "verifyUpdateSCR")
	    public void verifyDeactivateSCR() throws Exception {
	        captureScreenshot(driver, "SCRTest");
	        logger.info("Deactivate SCR");

	        scr.setDeactivateSCR();
	    }

	    @Test(priority = 4, dependsOnMethods = "verifyDeactivateSCR")
	    public void verifyReactivateSCR() throws Exception {
	        captureScreenshot(driver, "SCRTest");
	        logger.info("Reactive SCR");

	        scr.setReactivateSCR();
	    }
	
	    
	    
	    
	/*    private static final Logger logger = LogManager.getLogger(SCRTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public RosterSetupPage rsp; 
	public SystemDefinationSCRPage scr;

	@Test(priority = 1)
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

	@Test (priority = 2)//,dependsOnMethods = "verifyCreateSCR"  )
	public void verifyUpdateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Update SCR");
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
	@Test (priority = 3)//,dependsOnMethods = "verifyUpdateSCR"  )
	public void verifyDeactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Deactivate SCR");
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
		scr.setDeactivateSCR();
	}

	@Test (priority = 4)//,dependsOnMethods = "verifyDeactivateSCR" )
	public void verifyReactivateSCR() throws Exception {
		captureScreenshot(driver, "SCRTest");
		logger.info("Reactive SCR");
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
		scr.setReactivateSCR();
	}*/
}
