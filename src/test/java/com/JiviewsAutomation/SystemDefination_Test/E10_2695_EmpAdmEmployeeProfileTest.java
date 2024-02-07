package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2695_EmpAdmEmployeeProfilePage;
import com.AutomationJiviewsPOM.EmployeeAdminstrationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;
//Jira Item: E10_2695 - [Employee Administration] Employee Profile
public class E10_2695_EmpAdmEmployeeProfileTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_2695_EmpAdmEmployeeProfileTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeAdminstrationPage empAdmin;
	private E10_2695_EmpAdmEmployeeProfilePage empProfile;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empAdmin= new EmployeeAdminstrationPage(driver);
		empProfile= new  E10_2695_EmpAdmEmployeeProfilePage(driver);

//		homePage.setOrgUnit();
		
//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.setEmployeeAdministration();
		empAdmin.setEmployeeProfile();
	}


	@Test(priority = 1)
	public void E10_3135_VerifyCreateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3135 Creating Employee Profile...");

		
		empProfile.createEmpProfile(fakeEmployee);
		logger.info("E10-3135 Employee Profile creation successful");
	}
	@Test(priority =  2)
	public void E10_3136_VerifyUpdateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3136 Updating Employee Profile...");

		empProfile.updateEmpProfile(fakeEmployee);
		logger.info("E10-3136 Employee Profile updated successful");
	}
	@Test(priority = 3)
	public void E10_3137_VerifyDuplicateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3137 Duplicate Employee Profile...");

		empProfile.duplicateEmpProfile(fakeEmployee);
		logger.info("E10-3137 Employee Profile is successfully Duplicated ");
	}
	@Test(priority = 4) //, dependsOnMethods = "E10_3135_VerifyCreateEmpProfile")
	public void E10_3138_VerifyDeleteEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3138 Delete Employee Profile...");

		empProfile.deleteEmpProfile();
		logger.info("E10-3138 Employee Profile is successfully Ddeleted");	
	}
	@Test(priority = 5)
	public void E10_3145_VerifyreactivateEmpProfile() throws Exception{
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3145 Reactivate Employee profile...");
		
		empProfile.reactivateEmpProfile();
		logger.info("E10-3145 Employee profile is successfully reactivated");	
	}
	@Test(priority = 6)
	public void E10_3139_VerifySearchEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3139 Search Employee Profile...");

		empProfile.searchEmpProfile();
		logger.info("E10-3139 Employee Profile is successfully Searched");	
	}
	@Test(priority = 7)
	public void E10_3140_VerifysearchRosterGroup() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3140 Search RosterGroup...");

		empProfile.searchRosterGroup();
		logger.info("E10-3140 RosterGroup is successfully Searched");	
	}
	@Test(priority = 8)
	public void E10_3141_VerifysearchRoleGroup() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3141 Search Role Group...");

		empProfile.searchRoleGroup();
		logger.info("E10-3141 Role Group is successfully Searched");	
	}
	@Test(priority = 9)
	public void E10_3142_VerifysearchEmpStatus() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3142 Search Employee Status...");

		empProfile.searchEmpStatus();
		logger.info("E10-3142 Employee Status is successfully Searched");	
	}
	@Test(priority = 10)
	public void E10_3143_VerifyEmpNoInSearchBar() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3143 Search Employee number...");

		empProfile.enterEmpNoInSearchBar();
		logger.info("E10-3143 Employee is successfully Searched");	
	}
	@Test(priority = 11)
	public void E10_3144_VerifyTerminateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("E10-3144 Terminate Employee ...");

		empProfile.terminateEmpProfile(fakeEmployee);
		logger.info("E10-3144 Employee is successfully terminated");	
	}
}
