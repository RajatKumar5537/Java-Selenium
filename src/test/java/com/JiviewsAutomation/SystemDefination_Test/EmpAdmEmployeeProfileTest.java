package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmpAdmEmployeeProfilePage;
import com.AutomationJiviewsPOM.EmployeeAdminstrationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class EmpAdmEmployeeProfileTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(EmpAdmEmployeeProfileTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeAdminstrationPage empAdmin;
	private EmpAdmEmployeeProfilePage empProfile;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empAdmin= new EmployeeAdminstrationPage(driver);
		empProfile= new  EmpAdmEmployeeProfilePage(driver);

		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.setEmployeeAdministration();
		empAdmin.setEmployeeProfile();
	}


	@Test(priority = 1)
	public void verifyCreateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Creating Employee Profile...");

		empProfile.createEmpProfile(fakeEmployee);
		logger.info("Employee Profile creation successful");
	}
	@Test(priority =  2)
	public void verifyUpdateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Updating Employee Profile...");

		empProfile.updateEmpProfile(fakeEmployee);
		logger.info("Employee Profile updated");
	}
	@Test(priority = 3)
	public void verifyDuplicateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Duplicate Employee Profile...");

		empProfile.duplicateEmpProfile(fakeEmployee);
		logger.info("Employee Profile is successfully Duplicated ");
	}
	@Test(priority = 4, dependsOnMethods = "verifyCreateEmpProfile")
	public void verifyDeleteEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Delete Employee Profile...");

		empProfile.deleteEmpProfile();
		logger.info("Employee Profile is successfully Ddeleted");	
	}
	@Test(priority = 5)
	public void verifySearchEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Search Employee Profile...");

		empProfile.searchEmpProfile();
		logger.info("Employee Profile is successfully Searched");	
	}
	@Test(priority = 6)
	public void verifysearchRosterGroup() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Search RosterGroup...");

		empProfile.searchRosterGroup();
		logger.info("RosterGroup is successfully Searched");	
	}
	@Test(priority = 7)
	public void verifysearchRoleGroup() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Search Role Group...");

		empProfile.searchRoleGroup();
		logger.info("Role Group is successfully Searched");	
	}
	@Test(priority = 8)
	public void verifysearchEmpStatus() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Search Employee Status...");

		empProfile.searchEmpStatus();
		logger.info("Employee Status is successfully Searched");	
	}
	@Test(priority = 9)
	public void verifyEmpNoInSearchBar() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Search Employee number...");

		empProfile.enterEmpNoInSearchBar();
		logger.info("Employee is successfully Searched");	
	}
	@Test(priority = 10)
	public void verifyTerminateEmpProfile() throws Exception {
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Terminate Employee ...");

		empProfile.terminateEmpProfile();
		logger.info("Employee is successfully terminated");	
	}
	@Test(priority = 11)
	public void verifyreactivateEmpProfile() throws Exception{
		captureScreenshot(driver, "EmpAdmEmployeeProfileTest");
		logger.info("Reactivate Employee profile...");
		
		empProfile.reactivateEmpProfile();
		logger.info("Employee profile is successfully reactivated");	
	}
}
