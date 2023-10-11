package com.JiviewsAutomation.SystemDefination_TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;
import com.AutomationJiviews_SystemDefination_POM.SystemDefinationSkillSetupPage;


public class skillSetUpTestScript extends com.AutomationJiviewsGeneric.BaseClass{

	
	
	@Test
	public void createNewSkill() throws InterruptedException, EncryptedDocumentException, IOException {

		HomePage hp= new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateSkill();
		Thread.sleep(2000);
		sds.setNewSkill();

	}
	

	@Test
	public void deActiveSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateSkill();
		
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		sds.setDeactiveSkil();
	}
	@Test
	public void setReActiveSkill() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);

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
	@Test
	public void searchColumns() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateSkill();
		Thread.sleep(2000);
		sds.setSearchColumns();
	}
	@Test
	public void updateSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateSkill();

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		sds.setUpdateSkill();
	}
}
