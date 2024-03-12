package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2909_EmpAdmRosterGroupAssignmentPage;
import com.AutomationJiviewsPOM.EmployeeAdminstrationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_2909_EmpAdmRosterGroupAssignmentTest extends BaseClass{
//	private static final // logger // logger = LogManager.get// logger(E10_2909_EmpAdmRosterGroupAssignmentTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeAdminstrationPage empAdmin;
	private E10_2909_EmpAdmRosterGroupAssignmentPage rosterGrpAssignment;

	@BeforeMethod
	
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empAdmin= new EmployeeAdminstrationPage(driver);
		rosterGrpAssignment= new  E10_2909_EmpAdmRosterGroupAssignmentPage(driver);
	
		homePage.setOrgUnit();
		
		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.setEmployeeAdministration();
		empAdmin.setRosterGroupAssignment();
	}
	@Test(priority = 1)
	public void E10_2911_VerifyCreateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		// logger.info("E10-2911 Creating Roster Group Assignment...");

		rosterGrpAssignment.createRosterGroupAssignment(fakeEmployee);
		// logger.info("E10-2911 Roster Group Assignment creation is successful");
	}
	@Test(priority = 2)
	public void E10_2912_VerifyUpdateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		// logger.info("E10-2912 Updating Roster Group Assignment...");

		rosterGrpAssignment.updateRosterGroupAssignment(fakeEmployee);
		// logger.info("E10-2912 Roster Group Assignment successful updated");
	}
	@Test(priority = 3)
	public void E10_2913_VerifyDeleteRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		// logger.info("E10-2913 Deleting Roster Group Assignment...");

		rosterGrpAssignment.deleteRosterGroupAssignment();
		// logger.info("E10-2913 Roster Group Assignment deleted");
	}
	@Test(priority = 4)
	public void E10_2921_VerifyReactivateRosterGroupAssignment() throws Exception {
		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
		// logger.info("E10-2921 Deleting Roster Group Assignment...");
		
		rosterGrpAssignment.reactivateRosterGroupAssignmentx();
		// logger.info("E10-2921 Roster Group Assignment reactivated");
	}
	
//	@Test(priority = 5)
//	public void E10_2923_VerifyAddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception {
//		captureScreenshot(driver, "EmpAdmRosterGroupAssignmentTest");
//		// logger.info("E10-2923 Add Employees Non-Members to Members and remove from Members to Non-Member....");
//		
//		rosterGrpAssignment.AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember();
//		// logger.info("E10-2923 Succefully Add Employees Non-Members to Members and remove from Members to Non-Member");
//	}
}
