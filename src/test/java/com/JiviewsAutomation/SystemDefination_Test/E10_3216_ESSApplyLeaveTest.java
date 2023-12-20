package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3216_ESSApplyLeavePage;
import com.AutomationJiviewsPOM.EmployeeKioskPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.RosterSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_3216_ESSApplyLeaveTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(E10_2638_PublicHolidayTest.class);

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeKioskPage empKiosk;
	private E10_3216_ESSApplyLeavePage applyLeave;
	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empKiosk = new EmployeeKioskPage(driver);
		applyLeave= new E10_3216_ESSApplyLeavePage(driver);

		homePage.setOrgUnit();
		orgUnit.clickOLMop();
		//		homePage.setOrgUnit();
		//		orgUnit.setAutoOu();
		jmMenuItem.clickOnEmployeeSelfService();
//		empKiosk.clickOnApplyLeave();
	}
	@Test
	public void E10_3225_VerifyLoginAsEmployeeApplyForLeave() throws InterruptedException, IOException {

		//		homePage.clickOnBtnLogout();
		applyLeave.E10_3225_LoginAsEmployeeApplyForLeave();	
	}
}
