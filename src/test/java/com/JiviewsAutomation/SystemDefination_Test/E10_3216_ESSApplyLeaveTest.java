package com.JiviewsAutomation.SystemDefination_Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3216_ESSApplyLeavePage;
import com.AutomationJiviewsPOM.EmployeeKioskPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.LoginPage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
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
//		beforeTestMethod();


		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		empKiosk = new EmployeeKioskPage(driver);
		applyLeave= new E10_3216_ESSApplyLeavePage(driver);

		//		homePage.setOrgUnit();
		//		orgUnit.clickOLMop();
		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		jmMenuItem.clickOnEmployeeSelfService();
		//		empKiosk.clickOnApplyLeave();
	}
	@Test(priority = 1)
	public void E10_3225_Verify_EmployeeKiosk_ApplyForLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3225 EmployeeKiosk_Apply For Leave...");

		applyLeave.E10_3225_EmployeeKiosk_ApplyForLeave(fakeEmployee);	
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3225 EmployeeKiosk_Apply For Leave is successful");
	}
	@Test
	public void E10_3226_Verify_EmployeeKiosk_ViewCalendarCheckShiftDetails() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3226_Verify_EmployeeKiosk_View Calendar Check Shift Details...");

		applyLeave.E10_3226_EmployeeKiosk_ViewCalendarCheckShiftDetails();
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3226_Verify_EmployeeKiosk_View Calendar Check Shift Details is successful");
	}
	@Test
	public void E10_3227_Verify_EmployeeKiosk_LeaveRecords() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3227_Verify_EmployeeKiosk_Leave Records...");

		applyLeave.E10_3227_EmployeeKiosk_LeaveRecords();
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3227_Verify_EmployeeKiosk_Leave Records is successful");
	}
	@Test
	public void E10_3228_Verify_EmployeeKiosk_MyleaveProfile() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3228_Verify_EmployeeKiosk_My leave Profile...");

		applyLeave.E10_3228_EmployeeKiosk_MyleaveProfile();	
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3228_Verify_EmployeeKiosk_My leave Profile is successful");
	}
	@Test(priority = 2) //, dependsOnMethods = "E10_3225_Verify_EmployeeKiosk_ApplyForLeave")
	public void E10_3229_Verify_ApproverKiosk_ApproveLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3229_Verify_ApproverKiosk_Approve Leave...");

		applyLeave.E10_3229_ApproverKiosk_ApproveLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3229_Verify_ApproverKiosk_Approve Leave is successful");
	}
	@Test
	public void E10_3230_Verify_ApproverKiosk_CancelApproveleave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3230_Verify_ApproverKiosk_Cancel Approve leave...");

		applyLeave.E10_3230_ApproverKiosk_CancelApproveleave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3230_Verify_ApproverKiosk_Cancel Approve leave is successful");
	}
	@Test
	public void E10_3231_Veridy_ApplyLeaveAndCancleTheLeaveBeforeApproval() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3231_Apply Leave And Cancle The Leave Before Approval...");

		applyLeave.E10_3231_ApplyLeaveAndCancleTheLeaveBeforeApproval(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3231_Apply Leave And Cancle The Leave Before Approval is successful");
	}

	@Test
	public void E10_3232_Verify_CancelApprovedLeave_ApproverApprovedCancelLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3232_Verify_Cancel Approved Leave_Approver Approved Cancel Leave...");

		applyLeave.E10_3232_CancelApprovedLeave_ApproverApprovedCancelLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3232_Verify_Cancel Approved Leave_Approver Approved Cancel Leave is successful");
	}
	@Test
	public void E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave...");

		applyLeave.E10_3233_ReapplyRejectedLeave_RejectAppovedCancelLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave is successful");

	}

	public void E10_3234_Verify_ReapplyCancelledLeave_CancelApprovedLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave...");

		applyLeave.E10_3234_ReapplyCancelledLeave_CancelApprovedLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave is successful");
	}

	public void E10_3235_Verify_ReapplyCancelledApprovedLeave()throws Exception  {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3235_Verify_ReapplyCancelledApprovedLeave...");


		applyLeave.E10_3235_ReapplyCancelledApprovedLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		logger.info("E10_3235_Verify_ReapplyCancelledApprovedLeave is successful");
	}
	
	@Test
	public void E10_3218_Verify_ApplyTimeOff() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3218_ApplyTimeOff...");
		
		applyLeave.E10_3218_ApplyTimeOff(fakeEmployee);
	}
	
	@Test
	public void E10_3213_Verify_ApplyOnBehalf() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		logger.info("E10_3213_ApplyOnBehalf...");
		
		applyLeave.E10_3213_ApplyOnBehalf(fakeEmployee);
	}
}
