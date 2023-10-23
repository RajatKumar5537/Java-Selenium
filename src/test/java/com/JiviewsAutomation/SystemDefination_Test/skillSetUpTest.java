package com.JiviewsAutomation.SystemDefination_Test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationSkillSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;



public class skillSetUpTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	@Test (priority = 1)
	public void createNewSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");

		logger.info("Create a new Skill");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		Thread.sleep(1000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(1000);
		esp.setCreateSkill();
		Thread.sleep(1000);
		sds.setNewSkill();
		logger.info("A skill is created successfully ");

	}
	@Test (priority = 2, dependsOnMethods = "createNewSkill")
	public void updateSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		Thread.sleep(1000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(1000);
		esp.setCreateSkill();

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(1000);
		sds.setUpdateSkill();
	}


	@Test (priority = 3, dependsOnMethods = {"createNewSkill","updateSkill"})
	public void deActiveSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		Thread.sleep(1000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(1000);
		esp.setCreateSkill();

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(1000);
		sds.setDeactiveSkil();
	}
	@Test (priority = 4, dependsOnMethods = {"createNewSkill","updateSkill","deActiveSkill"})
	public void setReActiveSkill() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateSkill();
		Thread.sleep(2000);
		sds.setActivateDeactiveSkill();
	}
	@Test (priority = 5, dependsOnMethods = {"createNewSkill", "updateSkill", "deActiveSkill", "setReActiveSkill"})
	public void searchColumns() throws Exception {
		captureScreenshot(driver, "skillSetUpTest");
		logger.info("searching a skill");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		Thread.sleep(1000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(1000);
		esp.setCreateSkill();
		Thread.sleep(1000);
		sds.setSearchColumns();
		logger.info("searching a skill is successfull");
	}
}
