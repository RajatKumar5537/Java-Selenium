package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2909_EmpAdmRosterGroupAssignmentPage;

public class E10_2909_EmpAdmRosterGroupAssignmentTest extends BaseClass{

	public E10_2909_EmpAdmRosterGroupAssignmentPage rosterGrpAssignment;

	@Test(priority = 1)
	public void E10_2911_VerifyCreateRosterGroupAssignment() throws Exception 
	{
		rosterGrpAssignment= new  E10_2909_EmpAdmRosterGroupAssignmentPage(driver);
		rosterGrpAssignment.createRosterGroupAssignment();
	}

	@Test(priority = 2)
	public void E10_2912_VerifyUpdateRosterGroupAssignment() throws Exception 
	{
		rosterGrpAssignment.updateRosterGroupAssignment();
	}

	@Test(priority = 3)
	public void E10_2913_VerifyDeleteRosterGroupAssignment() throws Exception 
	{
		rosterGrpAssignment.deleteRosterGroupAssignment();
	}

	@Test(priority = 4)
	public void E10_2921_VerifyReactivateRosterGroupAssignment() throws Exception 
	{
		rosterGrpAssignment.reactivateRosterGroupAssignmentx();
	}

//	@Test(priority = 5)
//	public void E10_2923_VerifyAddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception 
//	{
//		rosterGrpAssignment.AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember();
//	}
}
