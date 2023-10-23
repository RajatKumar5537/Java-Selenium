package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.SystemDefinationShiftBandPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class RoaserSetup extends BaseClass{



	@Test 
	public void createShiftBandDefinition() throws Exception {

		System.out.println("Create Shift Band Difinition");
		HomePage hp=new HomePage(driver);
		OrganizationUnitDropDown oudd= new OrganizationUnitDropDown(driver);
		jiviewsMainMenuItems jmmi= new jiviewsMainMenuItems(driver);
//		EmployeeSetupPage esp=new EmployeeSetupPage(driver);
		RosterSetupPage rsp= new RosterSetupPage(driver);
		SystemDefinationShiftBandPage sb= new SystemDefinationShiftBandPage(driver);

		hp.setOrgUnit();
		oudd.setOLMop();
		jmmi.clickOnSystemDefination();
		rsp.setCreateRoasterShiftBand();
		sb.createShiftBandDefinition();




	}
}

