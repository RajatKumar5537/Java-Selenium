package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.ReconciliationParameterGroupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class ReconciliationParameterGroupTest extends BaseClass{

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	ReconciliationParameterGroupPage rPG;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		rPG = new ReconciliationParameterGroupPage(driver);
		rPG.clickTimeAndAttendance();
		rPG.clickToReconciliationParameterGroup();
	}

	@Test(priority = 2)
	public void verifyCreate() throws Exception {
		rPG.createAction();
	}

	@Test(priority = 3)
	public void verifyEdit() throws Exception {
		rPG.editAction();
	}

	@Test(priority = 4)
	public void verifyDelete() throws Exception {
		rPG.deleteAction();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		//rPG.reActivate();
		Reporter.log("reactive");
	}
}
