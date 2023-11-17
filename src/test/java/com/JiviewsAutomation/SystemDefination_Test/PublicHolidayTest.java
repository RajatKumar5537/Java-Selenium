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
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class PublicHolidayTest extends BaseClass{

	 private static final Logger logger = LogManager.getLogger(PublicHolidayTest.class);

	    private HomePage hp;
	    private OrganizationUnitDropDown oudd;
	    private jiviewsMainMenuItems jmmi;
	    private RosterSetupPage rsp;
	    private SystemDefinationPublicHolidayPage sdph;

	    @BeforeMethod
	    public void setup() throws Exception {
	        hp = new HomePage(driver);
	        oudd = new OrganizationUnitDropDown(driver);
	        jmmi = new jiviewsMainMenuItems(driver);
	        rsp = new RosterSetupPage(driver);
	        sdph = new SystemDefinationPublicHolidayPage(driver);

	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setPubicHoliday();
	    }

	    @Test(priority = 1)
	    public void verifyCreatePublicHoliday() throws Exception {
	        captureScreenshot(driver, "verifyCreatePublicHoliday");
	        logger.info("Creating public holiday");

	        sdph.setCreatePublicHoliday();

	        logger.info("Public holiday creation successful");
	    }

	    @Test(priority = 2)//, dependsOnMethods = "verifyCreatePublicHoliday")
	    public void verifyUpdatePublicHoliday() throws Exception {
	        captureScreenshot(driver, "verifyUpdatePublicHoliday");
	        logger.info("Updating public holiday");

	        sdph.setUpdatePublicHoliday();

	        logger.info("Public holiday update successful");
	    }

	    @Test(priority = 3)//, dependsOnMethods = "verifyUpdatePublicHoliday")
	    public void verifyDeletePublicHoliday() throws Exception {
	        captureScreenshot(driver, "verifyDeletePublicHoliday");
	        logger.info("Deleting public holiday");

	        sdph.setDeactivatePH();

	        logger.info("Deactivate public holiday successful");
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	/*private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public RosterSetupPage rsp;
	public SystemDefinationPublicHolidayPage sdph;

	@Test(priority = 1)
	public void verifyCreatePublicHoliday() throws Exception {
		captureScreenshot(driver, "publicHolidayTest");

		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdph= new SystemDefinationPublicHolidayPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setPubicHoliday();
		sdph.setCreatePublicHoliday();
		logger.info("Create a public holiday is successfull");
	}
	
	@Test (priority = 2)//, dependsOnMethods = "verifyCreatePublicHoliday")
	public void verifyUpdatePublicHoliday() throws Exception {
		captureScreenshot(driver, "publicHolidayTest");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdph= new SystemDefinationPublicHolidayPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setPubicHoliday();
		sdph.setUpdatePublicHoliday();
		
		logger.info("Update public holiday is successfull");
	}
	
	
	@Test (priority = 3)//, dependsOnMethods = "verifyUpdatePublicHoliday")
	public void verifyDeletePublicHoliday() throws Exception {
		captureScreenshot(driver, "publicHolidayTest");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		rsp= new RosterSetupPage(driver);
		sdph= new SystemDefinationPublicHolidayPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		rsp.setPubicHoliday();
		sdph.setDeactivatePH();
		
		logger.info("Deactivate public holiday is successfull");
	}*/
}
