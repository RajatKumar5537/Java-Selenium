package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Equipment_Setup;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Equipment_Setup_Test extends BaseClass {
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	Equipment_Setup equipmentSetup;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		equipmentSetup = new Equipment_Setup(driver);
		equipmentSetup.maritimeSetup();
		equipmentSetup.clickOnEquipment();
	}

	@Test(priority = 2)
	public void verifyCreateLocation() throws Exception {
		equipmentSetup.createEquipmentSetup();
	}

	@Test(priority = 3)
	public void verifyEditLocation() throws Exception {
		equipmentSetup.editEquipmentSetup();
	}

	@Test(priority = 4)
	public void verifyDeleteLocation() throws Exception {
		equipmentSetup.deleteEquipmentSetup();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		equipmentSetup.reActivate();
	}

}
