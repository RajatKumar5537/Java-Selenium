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

	private static final Logger logger = LogManager.getLogger(E10_3216_ESSApplyLeaveTest.class);

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
	public void E10_3225_Verify_EmployeeKiosk_ApplyForLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3225 EmployeeKiosk_Apply For Leave...");

		applyLeave.E10_3225_EmployeeKiosk_ApplyForLeave(fakeEmployee);	
		logger.info("E10_3225 EmployeeKiosk_Apply For Leave is successful");
	}
	@Test
	public void E10_3226_Verify_EmployeeKiosk_ViewCalendarCheckShiftDetails() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3226_Verify_EmployeeKiosk_ViewCalendarCheckShiftDetails...");
		
		applyLeave.E10_3226_EmployeeKiosk_ViewCalendarCheckShiftDetails();
		logger.info("E10_3226_Verify_EmployeeKiosk_ViewCalendarCheckShiftDetails is successful");
	}
	@Test
	public void E10_3227_Verify_EmployeeKiosk_LeaveRecords() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3227_Verify_EmployeeKiosk_LeaveRecords...");
		
		applyLeave.E10_3227_EmployeeKiosk_LeaveRecords();
		logger.info("E10_3227_Verify_EmployeeKiosk_LeaveRecords is successful");
	}
	@Test
	public void E10_3228_Verify_EmployeeKiosk_MyleaveProfile() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3228_Verify_EmployeeKiosk_MyleaveProfile...");
		
		applyLeave.E10_3228_EmployeeKiosk_MyleaveProfile();	
		logger.info("E10_3228_Verify_EmployeeKiosk_MyleaveProfile is successful");
	}
	@Test
	public void E10_3229_Verify_ApproverKiosk_ApproveLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3229_Verify_ApproverKiosk_ApproveLeave...");
		
		applyLeave.E10_3229_ApproverKiosk_ApproveLeave();
		logger.info("E10_3229_Verify_ApproverKiosk_ApproveLeave is successful");
	}
	@Test
	public void E10_3230_Verify_ApproverKiosk_CancelApproveleave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3230_Verify_ApproverKiosk_CancelApproveleave...");
		
		applyLeave.E10_3230_ApproverKiosk_CancelApproveleave();
		logger.info("E10_3230_Verify_ApproverKiosk_CancelApproveleave is successful");
	}
}
