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
	    private HomePage hp;
	    private OrganizationUnitDropDown oudd;
	    private jiviewsMainMenuItems jmmi;
	    private EmployeeSetupPage esp;
	    private SystemDefinationSkillSetupPage sds;

	    @BeforeMethod
	    public void setUp() throws Exception {
	    	String homeUrl = configUtil.getCongigPropertyData("homeurl");
	    	driver.navigate().to(homeUrl);
	        hp = new HomePage(driver);
	        oudd = new OrganizationUnitDropDown(driver);
	        jmmi = new jiviewsMainMenuItems(driver);
	        esp = new EmployeeSetupPage(driver);
	        sds = new SystemDefinationSkillSetupPage(driver);
	        
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        
	    }

	    @Test(priority = 1)
	    public void createNewSkill() throws Exception {
	        captureScreenshot(driver, "createNewSkill");
	        logger.info("Create a new Skill");
	        
	        sds.createNewSkill();
	        logger.info("A skill is created successfully ");
	    }

	    @Test(priority = 2, dependsOnMethods = "createNewSkill")
	    public void updateSkill() throws Exception {
	        captureScreenshot(driver, "updateSkill");
	        logger.info("Update a Skill");
	        
	        sds.updateSkill();
	        logger.info("A skill is updated successfully ");
	    }

	    @Test(priority = 3, dependsOnMethods= "updateSkill")
	    public void deActivateSkill() throws Exception {
	        captureScreenshot(driver, "deActivateSkill");
	        logger.info("Deactivate a Skill");
	        
	        sds.deactivateSkill();
	        logger.info("A skill is deactivated successfully ");
	    }

	    @Test(priority = 4, dependsOnMethods ="deActivateSkill")
	    public void reactivateSkill() throws Exception {
	        captureScreenshot(driver, "reactivateSkill");
	        logger.info("Reactivate a Skill");
	        
	        sds.activateDeactivateSkill();
	        logger.info("A skill is reactivated successfully ");
	    }

	    @Test(priority = 5)
	    public void searchColumnsForSkill() throws Exception {
	        captureScreenshot(driver, "searchColumnsForSkill");
	        logger.info("Searching a skill");
	        
	        sds.setSearchColumns();
	        logger.info("Searching a skill is successful");
	    }
	
    
    
}
