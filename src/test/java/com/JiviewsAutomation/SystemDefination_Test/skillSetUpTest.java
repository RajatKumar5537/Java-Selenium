package com.JiviewsAutomation.SystemDefination_Test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationSkillSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;



public class skillSetUpTest extends BaseClass{

	 private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);
	    private HomePage homePage;
	    private OrganizationUnitDropDown orgUnit;
	    private jiviewsMainMenuItems jmMenuItem;
	    private EmployeeSetupPage empSetup;
	    private SystemDefinationSkillSetupPage skillSetup;

	    @BeforeMethod
	    public void setUp() throws Exception {
	    	String homeUrl = configUtil.getCongigPropertyData("homeurl");
	    	driver.navigate().to(homeUrl);
	        homePage = new HomePage(driver);
	        orgUnit = new OrganizationUnitDropDown(driver);
	        jmMenuItem = new jiviewsMainMenuItems(driver);
	        empSetup = new EmployeeSetupPage(driver);
	        skillSetup = new SystemDefinationSkillSetupPage(driver);
	        
//	        homePage.setOrgUnit();
//			orgUnit.clickOLMop();
			homePage.setOrgUnit();
			orgUnit.setAutoOu();
	        jmMenuItem.clickOnSystemDefination();
	        empSetup.setCreateSkill();
	        
	    }

	    @Test(priority = 1)
	    public void createNewSkill() throws Exception {
	        captureScreenshot(driver, "createNewSkill");
	        logger.info("Create a new Skill");
	        
	        skillSetup.createNewSkill(fakeEmployee);
	        logger.info("A skill is created successfully ");
	    }

	    @Test(priority = 2) //, dependsOnMethods = "createNewSkill")
	    public void updateSkill() throws Exception {
	        captureScreenshot(driver, "updateSkill");
	        logger.info("Update a Skill");
	        
	        skillSetup.updateSkill();
	        logger.info("A skill is updated successfully ");
	    }

	    @Test(priority = 3) //, dependsOnMethods= "updateSkill")
	    public void deActivateSkill() throws Exception {
	        captureScreenshot(driver, "deActivateSkill");
	        logger.info("Deactivate a Skill");
	        
	        skillSetup.deactivateSkill();
	        logger.info("A skill is deactivated successfully ");
	    }

	    @Test(priority = 4) //, dependsOnMethods ="deActivateSkill")
	    public void reactivateSkill() throws Exception {
	        captureScreenshot(driver, "reactivateSkill");
	        logger.info("Reactivate a Skill");
	        
	        skillSetup.activateDeactivateSkill();
	        logger.info("A skill is reactivated successfully ");
	    }

	    @Test(priority = 5)
	    public void searchColumnsForSkill() throws Exception {
	        captureScreenshot(driver, "searchColumnsForSkill");
	        logger.info("Searching a skill");
	        
	        skillSetup.setSearchColumns();
	        logger.info("Searching a skill is successful");
	    }
	
    
    
}
