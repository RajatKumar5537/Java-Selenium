package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.Overtime_Definitions;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Overtime_Definitions_Test extends BaseClass{

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	Overtime_Definitions overTime;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		overTime = new Overtime_Definitions(driver);
		overTime.clickTimeAndAttendance();
		overTime.clickToOvertimeDefinitions();
	}
	
	@Test(priority = 2)
	public void verifyCreate() throws Exception {
		overTime.createAction();
	}

	@Test(priority = 3)
	public void verifyEdit() throws Exception {
		overTime.editAction();
	}

	@Test(priority = 4)
	public void verifyDelete() throws Exception {
		overTime.deleteAction();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		overTime.reActivate();
	}
}
