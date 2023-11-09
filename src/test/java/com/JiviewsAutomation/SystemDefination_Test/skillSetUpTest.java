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
	    public void setUp() {
	        hp = new HomePage(driver);
	        oudd = new OrganizationUnitDropDown(driver);
	        jmmi = new jiviewsMainMenuItems(driver);
	        esp = new EmployeeSetupPage(driver);
	        sds = new SystemDefinationSkillSetupPage(driver);
	    }

	    @Test(priority = 1)
	    public void createNewSkill() throws Exception {
	        captureScreenshot(driver, "createNewSkill");
	        logger.info("Create a new Skill");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        sds.createNewSkill();
	        logger.info("A skill is created successfully ");
	    }

	    @Test(priority = 2)
	    public void updateSkill() throws Exception {
	        captureScreenshot(driver, "updateSkill");
	        logger.info("Update a Skill");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        sds.updateSkill();
	        logger.info("A skill is updated successfully ");
	    }

	    @Test(priority = 3)
	    public void deActivateSkill() throws Exception {
	        captureScreenshot(driver, "deActivateSkill");
	        logger.info("Deactivate a Skill");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        sds.deactivateSkill();
	        logger.info("A skill is deactivated successfully ");
	    }

	    @Test(priority = 4)
	    public void reactivateSkill() throws Exception {
	        captureScreenshot(driver, "reactivateSkill");
	        logger.info("Reactivate a Skill");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        sds.activateDeactivateSkill();
	        logger.info("A skill is reactivated successfully ");
	    }

	    @Test(priority = 5)
	    public void searchColumnsForSkill() throws Exception {
	        captureScreenshot(driver, "searchColumnsForSkill");
	        logger.info("Searching a skill");
	        hp.setOrgUnit();
	        oudd.setAutoOu();
	        jmmi.clickOnSystemDefination();
	        esp.setCreateSkill();
	        sds.setSearchColumns();
	        logger.info("Searching a skill is successful");
	    }
	
    
    
    // previous code 
    
    /*private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);
	//	public HomePage hp;
	//	public OrganizationUnitDropDown oudd;
	//	public jiviewsMainMenuItems jmmi;
	//	public EmployeeSetupPage esp;
	//	public SystemDefinationSkillSetupPage sds;
	private HomePage hp;
	private OrganizationUnitDropDown oudd;
	private jiviewsMainMenuItems jmmi;
	private EmployeeSetupPage esp;
	private SystemDefinationSkillSetupPage sds;

	@Test (priority = 1)
	public void createNewSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");

		logger.info("Create a new Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sds=new SystemDefinationSkillSetupPage(driver);


		logger.info("Create a new Skill");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		Thread.sleep(1000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(1000);
		esp.setCreateSkill();
		Thread.sleep(1000);
		sds.createNewSkill();
		logger.info("A skill is created successfully ");
	}

	@Test (priority = 2)//, dependsOnMethods = "createNewSkill")
	public void updateSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		logger.info("Update a Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sds=new SystemDefinationSkillSetupPage(driver);

		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateSkill();
		sds.updateSkill();
		logger.info("A skill is updated successfully ");
	}


	@Test (priority = 3)// , dependsOnMethods = "updateSkill")
	public void deActiveSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		logger.info("deactive a Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sds=new SystemDefinationSkillSetupPage(driver);

		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateSkill();
		Thread.sleep(1000);
		sds.deactivateSkill();
		logger.info("A skill is deactivate successfully ");
	}
	@Test (priority = 4)//, dependsOnMethods = "deActiveSkill")
	public void setReActiveSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		logger.info("ReActive a Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sds=new SystemDefinationSkillSetupPage(driver);

		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateSkill();
		Thread.sleep(1000);
		//		sds.setActivateDeactiveSkill();

		logger.info("A skill is reactivate successfully ");
	}

	@Test (priority = 5)//, dependsOnMethods =  "setReActiveSkill")
	public void searchColumnsForSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		logger.info("searching a skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sds=new SystemDefinationSkillSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateSkill();
		Thread.sleep(1000);
		sds.setSearchColumns();
		logger.info("searching a skill is successfull");
	}*/
}
