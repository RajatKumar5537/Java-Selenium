package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;


public class ShiftBandTest extends BaseClass{
	 private static final Logger logger = LogManager.getLogger(ShiftBandTest.class);
	    private HomePage hp;
	    private OrganizationUnitDropDown oudd;
	    private jiviewsMainMenuItems jmmi;
	    private RosterSetupPage rsp;
	    private SystemDefinationShiftBandPage sb;

	    @BeforeMethod
	    public void setUp() {
	        hp = new HomePage(driver);
	        oudd = new OrganizationUnitDropDown(driver);
	        jmmi = new jiviewsMainMenuItems(driver);
	        rsp = new RosterSetupPage(driver);
	        sb = new SystemDefinationShiftBandPage(driver);
	    }

	    @Test(priority = 1)
	    public void testCreateShiftBand() throws Exception {
	        captureScreenshot(driver, "shiftBandTest");
	        logger.info("Create Shift Band Definition");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setCreateRoasterShiftBand();
	        sb.createShiftBand();
	    }

	    @Test(priority = 2)
	    public void testUpdateShiftBand() throws Exception {
	        captureScreenshot(driver, "shiftBandTest");
	        logger.info("Verify update shiftBand");
//	        driver.navigate().refresh();
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setCreateRoasterShiftBand();
	        sb.updateShiftBand();
	    }

	    @Test(priority = 3)
	    public void testDeactivateShiftBand() throws Exception {
	        captureScreenshot(driver, "shiftBandTest");
	        logger.info("Verify Deactivate Shift band");
//	        driver.navigate().refresh();
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setCreateRoasterShiftBand();
	        sb.deactiveShiftBand();
	    }

	    @Test(priority = 4)
	    public void testWithoutShiftBandName() throws Exception {
	        captureScreenshot(driver, "shiftBandTest");
	        logger.info("Verify Without Shift Band Name");
//	        driver.navigate().refresh();
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setCreateRoasterShiftBand();
	        sb.withoutShiftBandName();
	    }

//	    @Test(priority = 5)
//	    public void testWithCombinationShift() throws Exception {
//	        captureScreenshot(driver, "shiftBandTest");
//	        logger.info("Verify With Combination Shift");
////	        driver.navigate().refresh();
//	        hp.setOrgUnit();
//	        oudd.setAutoOu();
//	        jmmi.clickOnSystemDefination();
//	        rsp.setCreateRoasterShiftBand();
//	        sb.shiftBandTypeCombinationShift();
//	    }

	    @Test(priority = 5)
	    public void testWithOvertimeShift() throws Exception {
	        captureScreenshot(driver, "shiftBandTest");
	        logger.info("Verify With Overtime Shift");
//	        driver.navigate().refresh();
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        rsp.setCreateRoasterShiftBand();
	        sb.shiftBandTypeOvertimeShift();
	    }
	    
	    
	    
	
	/*private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	@Test 
	public void verifyCreateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("Create Shift Band Difinition");
		//		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		//		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		//		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);
		sb.createShiftBand();
	}

	@Test
	public void verifyUpdateShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify update shiftBand");
		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		////		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);
		sb.updateShiftBand();
	}

	@Test
	public void verifyDeactiveShiftBand() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify Deactive Shift band");
		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		////		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);
		sb.deactiveShiftBand();
	}
	@Test
	public void verifyWithoutShiftBandName() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify Without Shift Band Name");
		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		////		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);
		sb.withoutShiftBandName();
	}
	@Test
	public void verifyWithCombinationShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify With Combination Shift");
		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		////		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);	
		sb.shiftBandTypeCombinationShift();
	}
	@Test
	public void verifyWithOvertimeShift() throws Exception {
		captureScreenshot(driver, "shiftBandTest");
		logger.info("verify With Overtime Shift");
		driver.navigate().refresh();

		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		//		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		//		Thread.sleep(2000);
		rsp.setCreateRoasterShiftBand();
		//		Thread.sleep(2000);		
		sb.shiftBandTypeOvertimeShift();
	}*/

}

