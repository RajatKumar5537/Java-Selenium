package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.Location_Definitions;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Location_Definitions_Test extends BaseClass {
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;

	Location_Definitions location;

	@Test(priority = 1)
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnSystemDefination();

		location = new Location_Definitions(driver);
		location.maritimeSetup();
		location.locationDefinitions();
	}

	@Test(priority = 2)
	public void verifyCreateLocation() throws Exception {
		location.createLocation();
	}

	@Test(priority = 3)
	public void verifyEditLocation() throws Exception {
		location.editLocation();
	}

	@Test(priority = 4)
	public void verifyDeleteLocation() throws Exception {
		location.deleteLocation();
	}

	@Test(priority = 5)
	public void verifyReActivate() throws Exception {
		location.reActivate();
	}

}
