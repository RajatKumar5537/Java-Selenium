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
}
