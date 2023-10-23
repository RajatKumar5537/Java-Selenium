package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class roleSetUpTest extends BaseClass{

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public SystemDefinationRoleSetupPage sdrs;

	@Test
	public void verifyCreateNewRole() throws Exception {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setOLMop();
		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
		Thread.sleep(2000);
		esp.setCreateRole();
		sdrs.setCreateNewRole();
	}

	/*@Test(priority = 2)

	public void verifyUpdateRole() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setUpdateRole();
	}

	@Test(priority = 3)
	public void verifyDeactiveRole() throws InterruptedException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDeactiveRole();
	}

	@Test(priority = 4)

	public void verifyReactiveRole() throws InterruptedException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setReactiveRole();
	}

	@Test(priority = 5)
	public void verifyCreateRoleWithAllAvailableSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithAllAvailableSkill();
	}

	@Test(priority = 6)
	public void verifyDisselectAllAvailableSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDisselectAllAvailableSkill();
	}

	@Test(priority = 7)
	public void verifyCreateNewRoleWithoutPriarySkill() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutPriarySkill();
	}
	@Test(priority = 8)
	public void verifyCreateNewRoleWithoutRoleName() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutRoleName();
	}

	@Test(priority = 9)
	public void verifyCreateNewRoleWithoutRoleDescription() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutRoleDescription();
	}
	@Test(priority = 10)
	public void verifyCreateNewRoleWithoutSecondarySkillEmpty() throws EncryptedDocumentException, IOException, InterruptedException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutSecondarySkillEmpty();
	}
	@Test(priority = 11)
	public void verifyDisselectSingleSkillFromSelectedSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDisSelectSingleSkillFromSelectedSkill();
	}
	@Test(priority = 12)
	public void verifySearchColumnsForRole() throws InterruptedException, EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setSearchColumnsForRole();
	}*/
}
