package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2695_EmpAdmEmployeeProfilePage;

public class E10_2695_EmpAdmEmployeeProfileTest extends BaseClass
{

	public  E10_2695_EmpAdmEmployeeProfilePage empProfile;

	@Test(priority = 1)
	public void E10_3135_VerifyCreateEmpProfile() throws Exception 
	{
		empProfile= new  E10_2695_EmpAdmEmployeeProfilePage(driver);
		empProfile.createEmpProfile();
	}

	@Test(priority = 6)
	public void E10_3137_VerifyDuplicateEmpProfile() throws Exception 
	{
		empProfile.duplicateEmpProfile();
	}
	
	@Test(priority =  2)
	public void E10_3136_VerifyUpdateEmpProfile() throws Exception 
	{
		empProfile.updateEmpProfile();
	}


	@Test(priority = 3)
	public void E10_3138_VerifyDeleteEmpProfile() throws Exception 
	{
		empProfile.deleteEmpProfile();
	}

	@Test(priority = 4)
	public void E10_3145_VerifyreactivateEmpProfile() throws Exception
	{
		empProfile.reactivateEmpProfile();
	}

	@Test(priority = 5)
	public void E10_3144_VerifyTerminateEmpProfile() throws Exception 
	{
		empProfile.terminateEmpProfile();
	}


	@Test(priority = 7)
	public void E10_3142_VerifysearchEmpStatus() throws Exception 
	{
		empProfile.searchEmpStatus();
	}

	@Test(priority = 8)
	public void E10_3139_VerifySearchEmpProfile() throws Exception 
	{
		empProfile.searchEmpProfile();
	}

	@Test(priority = 9)
	public void E10_3140_VerifysearchRosterGroup() throws Exception 
	{
		empProfile.searchRosterGroup();
	}

	@Test(priority = 10)
	public void E10_3141_VerifysearchRoleGroup() throws Exception 
	{
		empProfile.searchRoleGroup();
	}


}
