package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Crane_Setup;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.Location_Definitions;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Crane_Setup_Test extends BaseClass {
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	
	Crane_Setup crane;
	
	
	@Test(priority = 1)
	public void setup() throws Exception {
		
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();
	
		crane = new Crane_Setup(driver);
		crane.systemSetup();
		crane.maritimeSetup();
		crane.craneSetup();
	}

	@Test(priority = 2)
	public void verifyCreateLocation() throws Exception {
		crane.createCrane();
	}

	@Test(priority = 3)
	public void verifyEditLocation() throws Exception {
		crane.editCrane();
	}

	@Test(priority = 4)
	public void verifyDeleteLocation() throws Exception {
		crane.deleteCrane();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		crane.reActivate();
	}

}