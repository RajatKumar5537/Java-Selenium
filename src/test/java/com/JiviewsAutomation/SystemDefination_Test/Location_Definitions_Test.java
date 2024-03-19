package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.Location_Definitions;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class Location_Definitions_Test extends BaseClass {
	
	Location_Definitions location;

	

	@Test(priority = 1)
	public void verifyCreateLocation() throws Exception {
		location=new Location_Definitions(driver);
		location.createLocation();
	}

	@Test(priority = 2)
	public void verifyEditLocation() throws Exception {
		location.editLocation();
	}

	@Test(priority = 3)
	public void verifyDeleteLocation() throws Exception {
		location.deleteLocation();
	}

	@Test(priority = 4)
	public void verifyReActivate() throws Exception {
		location.reActivate();
	}

}
