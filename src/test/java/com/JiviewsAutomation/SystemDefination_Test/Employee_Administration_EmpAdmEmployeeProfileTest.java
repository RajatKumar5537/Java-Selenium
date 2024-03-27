package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2695_EmpAdmEmployeeProfilePage;

public class Employee_Administration_EmpAdmEmployeeProfileTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(Employee_Administration_EmpAdmEmployeeProfileTest.class.getName());
	public  E10_2695_EmpAdmEmployeeProfilePage empProfile;

	@Test(priority = 1)
	public void Employee_Administration_VerifyCreateEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyCreateEmpProfile");
		empProfile= new  E10_2695_EmpAdmEmployeeProfilePage(driver);
		empProfile.createEmpProfile();
		logger.info("Test Employee_Administration_VerifyCreateEmpProfile is successful");
	}

	@Test(priority = 6)
	public void Employee_Administration_VerifyDuplicateEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyDuplicateEmpProfile");
		empProfile.duplicateEmpProfile();
		logger.info("Test Employee_Administration_VerifyDuplicateEmpProfile is successful");
	}
	
	@Test(priority =  2)
	public void Employee_Administration_VerifyUpdateEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyUpdateEmpProfile");
		empProfile.updateEmpProfile();
		logger.info("Test Employee_Administration_VerifyUpdateEmpProfile is successful");
	}


	@Test(priority = 3)
	public void Employee_Administration_VerifyDeleteEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyDeleteEmpProfile");
		empProfile.deleteEmpProfile();
		logger.info("Test Employee_Administration_VerifyDeleteEmpProfile is successful");
	}

	@Test(priority = 4)
	public void Employee_Administration_VerifyreactivateEmpProfile() throws Exception
	{
		logger.info("Starting test: Employee_Administration_VerifyreactivateEmpProfile");
		empProfile.reactivateEmpProfile();
		logger.info("Test Employee_Administration_VerifyreactivateEmpProfile is successful");
	}

	@Test(priority = 5)
	public void Employee_Administration_VerifyTerminateEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifyTerminateEmpProfile");
		empProfile.terminateEmpProfile();
		logger.info("Test Employee_Administration_VerifyTerminateEmpProfile is successful");
	}


	@Test(priority = 7)
	public void Employee_Administration_VerifysearchEmpStatus() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifysearchEmpStatus");
		empProfile.searchEmpStatus();
		logger.info("Test Employee_Administration_VerifysearchEmpStatus is successful");
	}

	@Test(priority = 8)
	public void Employee_Administration_VerifySearchEmpProfile() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifySearchEmpProfile");
		empProfile.searchEmpProfile();
		logger.info("Test Employee_Administration_VerifySearchEmpProfile is successful");
	}

	@Test(priority = 9)
	public void Employee_Administration_VerifysearchRosterGroup() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifysearchRosterGroup");
		empProfile.searchRosterGroup();
		logger.info("Test Employee_Administration_VerifysearchRosterGroup is successful");
	}

	@Test(priority = 10)
	public void Employee_Administration_VerifysearchRoleGroup() throws Exception 
	{
		logger.info("Starting test: Employee_Administration_VerifysearchRoleGroup");
		empProfile.searchRoleGroup();
		logger.info("Test Employee_Administration_VerifysearchRoleGroup is successful");
	}


}
