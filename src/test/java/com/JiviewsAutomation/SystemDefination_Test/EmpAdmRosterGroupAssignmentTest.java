package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmpAdmRosterGroupAssignmentPage;
import com.AutomationJiviewsPOM.EmployeeAdminstrationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class EmpAdmRosterGroupAssignmentTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(EmpAdmEmployeeProfileTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeAdminstrationPage empAdmin;
	private EmpAdmRosterGroupAssignmentPage rosterGrpAssignment;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtil.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empAdmin= new EmployeeAdminstrationPage(driver);
		rosterGrpAssignment= new  EmpAdmRosterGroupAssignmentPage(driver);
	
		homePage.setOrgUnit();
		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.setEmployeeAdministration();
		empAdmin.setRosterGroupAssignment();
	}
	@Test(priority = 1)
	public void verifyCreateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		logger.info("Creating Roster Group Assignment...");

		rosterGrpAssignment.createRosterGroupAssignment(fakeEmployee);
		logger.info("Roster Group Assignment creation is successful");
	}
	@Test(priority = 2)
	public void verifyUpdateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		logger.info("Updating Roster Group Assignment...");

		rosterGrpAssignment.updateRosterGroupAssignment(fakeEmployee);
		logger.info("Roster Group Assignment updated");
	}
	@Test(priority = 3)
	public void verifyDeleteRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		logger.info("Deleting Roster Group Assignment...");

		rosterGrpAssignment.deleteRosterGroupAssignment();
		logger.info("Roster Group Assignment deleted");
	}
	@Test(priority = 4)
	public void verifyReactivateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		logger.info("Deleting Roster Group Assignment...");
		
		rosterGrpAssignment.reactivateRosterGroupAssignmentx();
		logger.info("Roster Group Assignment reactivated");
	}
	
	@Test(priority = 5)
	public void verifyAddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		logger.info("Add Employees Non-Members to Members and remove from Members to Non-Member....");
		
		rosterGrpAssignment.AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember();
		logger.info("Succefully Add Employees Non-Members to Members and remove from Members to Non-Member");
	}
}
