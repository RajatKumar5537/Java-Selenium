package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.T_And_A_Exception_Code;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class T_And_A_Exception_Code_Test extends BaseClass {
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	T_And_A_Exception_Code tAndA;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		tAndA = new T_And_A_Exception_Code(driver);
		tAndA.clickTimeAndAttendance();
		tAndA.clicktAndAExceptionCodes();
	}

	@Test(priority = 2)
	public void verifyValidations() throws Exception {
		tAndA.validationTAndA();
	}
}
