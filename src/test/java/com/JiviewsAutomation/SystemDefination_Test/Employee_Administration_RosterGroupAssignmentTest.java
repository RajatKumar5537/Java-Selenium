package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2909_EmpAdmRosterGroupAssignmentPage;

public class Employee_Administration_RosterGroupAssignmentTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(Employee_Administration_RosterGroupAssignmentTest.class.getName());
	public E10_2909_EmpAdmRosterGroupAssignmentPage rosterGrpAssignment;

	@Test(priority = 1)
	public void Employee_Administration_VerifyCreateRosterGroupAssignment() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyCreateRosterGroupAssignment");
		rosterGrpAssignment= new  E10_2909_EmpAdmRosterGroupAssignmentPage(driver);
		rosterGrpAssignment.createRosterGroupAssignment();
		logger.info("Test Employee_Administration_VerifyCreateRosterGroupAssignment is successful");
	}

	@Test(priority = 2)
	public void Employee_Administration_VerifyUpdateRosterGroupAssignment() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyUpdateRosterGroupAssignment");
		rosterGrpAssignment.updateRosterGroupAssignment();
		logger.info("Test Employee_Administration_VerifyUpdateRosterGroupAssignment is successful");
	}

	@Test(priority = 3)
	public void Employee_Administration_VerifyDeleteRosterGroupAssignment() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyDeleteRosterGroupAssignment");
		rosterGrpAssignment.deleteRosterGroupAssignment();
		logger.info("Test Employee_Administration_VerifyDeleteRosterGroupAssignment is successful");
	}

	@Test(priority = 4)
	public void Employee_Administration_VerifyReactivateRosterGroupAssignment() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyReactivateRosterGroupAssignment");
		rosterGrpAssignment.reactivateRosterGroupAssignmentx();
		logger.info("Test Employee_Administration_VerifyReactivateRosterGroupAssignment is successful");
	}

	@Test(priority = 5)
	public void Employee_Administration_VerifyAddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyAddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember");
		rosterGrpAssignment.AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember();
	}
}
