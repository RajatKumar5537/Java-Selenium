package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Equipment_Type;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.Location_Definitions;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Equipment_Type_Test extends BaseClass {
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	Equipment_Type equipment;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		equipment = new Equipment_Type(driver);
		equipment.maritimeSetup();
		equipment.clickOnEquipment();
	}

	@Test(priority = 2)
	public void verifyCreateLocation() throws Exception {
		equipment.createEquipment();
	}

	@Test(priority = 3)
	public void verifyEditLocation() throws Exception {
		equipment.editEquipment();
	}

	@Test(priority = 4)
	public void verifyDeleteLocation() throws Exception {
		equipment.deleteEquipment();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		equipment.reActivate();
	}

}
