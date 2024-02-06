package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_2909_EmpAdmRosterGroupAssignmentPage;
import com.AutomationJiviewsPOM.EmployeeAdminstrationPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.Maritime_Setup;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;
import com.aventstack.extentreports.model.Report;

public class Maritime_Setup_Test extends BaseClass {
	private static final Logger logger = LogManager.getLogger(E10_2909_EmpAdmRosterGroupAssignmentTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeAdminstrationPage empAdmin;
	private E10_2909_EmpAdmRosterGroupAssignmentPage rosterGrpAssignment;
	
	Maritime_Setup obj;

	@Test(priority = 0)
	public void setup() throws Exception {
//		String homeUrl = configUtility.getCongigPropertyData("homeurl");
//		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
		

	}

	//@Test(priority = 0)
//	public void clickOnSystemSetup() throws InterruptedException
//	{
//		Reporter.log("this is fortest :"+obj, 0);
//		obj.systemSetup();
//	}
//	@Test(priority = 2)
//	public void clickOnEnterBerthDescription()
//	{
//		obj.enterBerthDescription();
//	}
	@Test(priority = 1)
	public void clickOnMaritimeSetup() throws InterruptedException
	{
		obj=new Maritime_Setup(driver);
		obj.maritimeSetup();
		obj.birthSetup();
	}
	//@Test(priority = 4)
//	public void clickOnBirthSetup()
//	{
//		
//	}
	@Test(priority = 2)
	public void verifyCreateBerth()
	{
		obj.createBerth();
	}
	@Test(priority = 3)
	public void verifyEditBerth()
	{
		obj.editBerth();
	}
	@Test(priority = 4)
	public void verifyDeleteBerth()
	{
		obj.deleteBerth();
	}
	@Test(priority = 5)
	public void verifyReActivate()
	{
		obj.reActivate();
	}
	
	
}
