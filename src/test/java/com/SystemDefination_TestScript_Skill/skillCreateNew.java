package com.SystemDefination_TestScript_Skill;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.AzureGeneric.BaseClass;
import com.AzurePOM.EmployeeSetupPage;
import com.AzurePOM.HomePage;
import com.AzurePOM.OrganizationUnitDropDown;
import com.AzurePOM.SystemDefinationSkillSetupPage;
import com.AzurePOM.jiviewsMainMenuItems;


public class skillCreateNew extends BaseClass{
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
}
