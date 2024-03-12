package com.JiviewsAutomation.SystemDefination_Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3216_ESSApplyLeavePage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.LoginPage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_3216_ESSApplyLeaveTest extends BaseClass{

//	private static final // logger // logger = LogManager.get// logger(E10_3216_ESSApplyLeaveTest.class);

	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	//	private EmployeeKioskPage empKiosk;
	private E10_3216_ESSApplyLeavePage applyLeave;
	@BeforeMethod
	public void setup() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		//		empKiosk = new EmployeeKioskPage(driver);
		applyLeave= new E10_3216_ESSApplyLeavePage(driver);

		homePage.setOrgUnit();
		orgUnit.setAutoOu();
		
		//	jmMenuItem.clickSystemDefination();
		//		empKiosk.clickOnApplyLeave();
	}
	@AfterMethod
	public void logoutAfterTestMethod() {
		try {
			Thread.sleep(5000);
			homePage.clickOnBtnLogout();
			String unAdmin = configUtility.getCongigPropertyData("username");
			String pwdAdmin = configUtility.getCongigPropertyData("password");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setLogin(unAdmin, pwdAdmin);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Test(priority = 1)
	public void E10_3226_Verify_EmployeeKiosk_ViewCalendarCheckShiftDetails() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3226_Verify_EmployeeKiosk_View Calendar Check Shift Details...");

		applyLeave.E10_3226_EmployeeKiosk_ViewCalendarCheckShiftDetails();
		// logger.info("E10_3226_Verify_EmployeeKiosk_View Calendar Check Shift Details is successful");
	}
	@Test(priority = 2)
	public void E10_3227_Verify_EmployeeKiosk_LeaveRecords() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3227_Verify_EmployeeKiosk_Leave Records...");

		applyLeave.E10_3227_EmployeeKiosk_LeaveRecords();
		// logger.info("E10_3227_Verify_EmployeeKiosk_Leave Records is successful");
	}
	@Test(priority = 3)
	public void E10_3228_Verify_EmployeeKiosk_MyleaveProfile() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3228_Verify_EmployeeKiosk_My leave Profile...");

		applyLeave.E10_3228_EmployeeKiosk_MyleaveProfile();	
		// logger.info("E10_3228_Verify_EmployeeKiosk_My leave Profile is successful");
	}
	@Test(priority = 4)
	public void E10_3225_Verify_EmployeeKiosk_ApplyForLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3225 EmployeeKiosk_Apply For Leave...");

		applyLeave.E10_3225_EmployeeKiosk_ApplyForLeave(fakeEmployee);	
		// logger.info("E10_3225 EmployeeKiosk_Apply For Leave is successful");
	}

	@Test(priority = 5) //, dependsOnMethods = "E10_3225_Verify_EmployeeKiosk_ApplyForLeave")
	public void E10_3229_Verify_ApproverKiosk_ApproveLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3229_Verify_ApproverKiosk_Approve Leave...");

		applyLeave.E10_3229_ApproverKiosk_ApproveLeave(fakeEmployee);
		// logger.info("E10_3229_Verify_ApproverKiosk_Approve Leave is successful");
	}
	@Test(priority = 6)
	public void E10_3230_Verify_ApproverKiosk_CancelApproveleave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3230_Verify_ApproverKiosk_Cancel Approve leave...");

		applyLeave.E10_3230_ApproverKiosk_CancelApproveleave(fakeEmployee);
		// logger.info("E10_3230_Verify_ApproverKiosk_Cancel Approve leave is successful");
	}
	@Test(priority = 7)
	public void E10_3231_Verify_ApplyLeaveAndCancleTheLeaveBeforeApproval() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3231_Apply Leave And Cancle The Leave Before Approval...");

		applyLeave.E10_3231_ApplyLeaveAndCancleTheLeaveBeforeApproval(fakeEmployee);
		// logger.info("E10_3231_Apply Leave And Cancle The Leave Before Approval is successful");
	}

	@Test(priority = 8)
	public void E10_3232_Verify_CancelApprovedLeave_ApproverApprovedCancelLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3232_Verify_Cancel Approved Leave_Approver Approved Cancel Leave...");

		applyLeave.E10_3232_CancelApprovedLeave_ApproverApprovedCancelLeave(fakeEmployee);
		// logger.info("E10_3232_Verify_Cancel Approved Leave_Approver Approved Cancel Leave is successful");
	}

	
	/*
	@Test(priority = 9)
	public void E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave...");

		applyLeave.E10_3233_ReapplyRejectedLeave_RejectAppovedCancelLeave(fakeEmployee);
		String unAdmin = configUtility.getCongigPropertyData("username");
		String pwdAdmin = configUtility.getCongigPropertyData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(unAdmin, pwdAdmin);
		// logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave is successful");

	}

//	public void E10_3234_Verify_ReapplyCancelledLeave_CancelApprovedLeave() throws Exception {
//		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
//		// logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave...");
//
//		applyLeave.E10_3234_ReapplyCancelledLeave_CancelApprovedLeave(fakeEmployee);
//		String unAdmin = configUtility.getCongigPropertyData("username");
//		String pwdAdmin = configUtility.getCongigPropertyData("password");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.setLogin(unAdmin, pwdAdmin);
//		// logger.info("E10_3233_Verify_ReapplyRejectedLeave_RejectAppovedCancelLeave is successful");
//	}

//	public void E10_3235_Verify_ReapplyCancelledApprovedLeave()throws Exception  {
//		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
//		// logger.info("E10_3235_Verify_ReapplyCancelledApprovedLeave...");
//
//
//		applyLeave.E10_3235_ReapplyCancelledApprovedLeave(fakeEmployee);
//		String unAdmin = configUtility.getCongigPropertyData("username");
//		String pwdAdmin = configUtility.getCongigPropertyData("password");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.setLogin(unAdmin, pwdAdmin);
//		// logger.info("E10_3235_Verify_ReapplyCancelledApprovedLeave is successful");
//	}*/

	@Test(priority = 10)
	public void E10_3218_Verify_ApplyTimeOff() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3218_ApplyTimeOff...");

		applyLeave.E10_3218_ApplyTimeOff(fakeEmployee);
		// logger.info("E10_3218_ApplyTimeOff is successful");
	}

	@Test(priority = 11)
	public void E10_3213_Verify_ApplyOnBehalf() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3213_ApplyOnBehalf...");

		applyLeave.E10_3213_ApplyOnBehalf(fakeEmployee);
		// logger.info("E10_3213_ApplyOnBehalf is successful");
	}
	@Test(priority = 12)
	public void E10_3219_Verify_ApplyForUncontrolledLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3219_Verify_ApplyForUncontrolledLeave...");

		applyLeave.E10_3219_ApplyForUncontrolledLeave(fakeEmployee);

		// logger.info("E10_3219_Verify_ApplyForUncontrolledLeave is successful");
	}
	@Test(priority = 13)
	public void E10_3222_Verify_ApplyLeaveP2() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3213_ApplyOnBehalf...");

		applyLeave.E10_3222_ApplyLeaveP2(fakeEmployee);

		// logger.info("E10_3216_ESSApplyLeaveTest is successful");
	}


	//	@Test (priority = 14)
	//	public void E10_3223_Verify_RescheduleLeave() throws Exception {
	//		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
	//		// logger.info("E10_3223_Verify_RescheduleLeave...");
	//
	//		applyLeave.E10_3223_RescheduleLeave(fakeEmployee);
	//
	//		// logger.info("E10_3223_Verify_RescheduleLeave is successful");
	//	}

	@Test(priority = 15)
	public void E10_3442_Verify_ApplyLeaveOnPublicHoliday() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3442_Verify_ApplyLeaveOnPublicHoliday...");

		applyLeave.E10_3442_ApplyLeaveOnPublicHoliday(fakeEmployee);
		// logger.info("E10_3442_Verify_ApplyLeaveOnPublicHoliday is successful");
	}

	@Test (priority = 16)
	public void E10_3443_Verify_ShiftlessEmployeeApplyPublicHolidayLeave()throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3443_Verify_ShiftlessEmployeeApplyPublicHolidayLeave...");


		applyLeave.E10_3443_ShiftlessEmployeeApplyPublicHolidayLeave(fakeEmployee);
		// logger.info("E10_3443_Verify_ShiftlessEmployeeApplyPublicHolidayLeave is successful");
	}

	@Test(priority = 17)
	public void E10_3444_Verify_NoPublicHolidayLeaveOnTheFollowingDayWithAssignedShift() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3444_NoPublicHolidayLeaveOnTheFollowingDayWithAssignedShift...");

		applyLeave.E10_3444_NoPublicHolidayLeaveOnTheFollowingDayWithAssignedShift(fakeEmployee);
		// logger.info("E10_3444_NoPublicHolidayLeaveOnTheFollowingDayWithAssignedShift is successful");
	}
	/*@Test(priority = 18)
	public void E10_3445_Verify_ApplyUnpaidLeave() throws Exception {
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3445_ApplyUnpaidLeave...");
		
		applyLeave.E10_3445_ApplyUnpaidLeave();
		// logger.info("E10_3445_ApplyUnpaidLeave is successful");
	}

	@Test(priority = 19)
	public void E10_3446_Verify_MultipleApproverApproveTheLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3446_MultipleApproverApproveTheLeave...");

		jmMenuItem.clickOnSystemDefination();
		applyLeave.E10_3446_MultipleApproverApproveTheLeave(fakeEmployee);
		// logger.info("E10_3446_MultipleApproverApproveTheLeave is successful");
	}
	@Test(priority = 20)
	public void E10_3447_Verify_RejectLeaveWithOneApprover() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3447_Verify_RejectLeaveWithOneApprover...");
		
		
		applyLeave.E10_3447_RejectLeaveWithOneApprover(fakeEmployee);
		// logger.info("E10_3447_Verify_RejectLeaveWithOneApprover is successful");
	}
	@Test(priority = 21)
	public void E10_3448_Verify_EnableTheAnyOneCanApprove() throws Exception{
		//		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		//		driver.navigate().to(homeUrl);
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3448_Verify_EnableTheAnyOneCanApprove...");

		jmMenuItem.clickOnSystemDefination();
		applyLeave.E10_3448_EnableTheAnyOneCanApprove(); 
		// logger.info("E10_3448_Verify_EnableTheAnyOneCanApprove is successful");
	}

	@Test(priority = 22)
	public void E10_3449_Verify_LevelAndLevel2_AllApproverApproveTheLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3449_Verify_LevelAndLevel2_AllApproverApproveTheLeave...");
		
		applyLeave.E10_3449_LevelAndLevel2_AllApproverApproveTheLeave(fakeEmployee);
		// logger.info("E10_3449_Verify_LevelAndLevel2_AllApproverApproveTheLeave is successful");
	}
	@Test(priority = 23)
	public void E10_3450_Verify_Level1ApproveAndLevel2_AnyOneOfApproverRejectTheLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3449_Verify_LevelAndLevel2_AllApproverApproveTheLeave...");
		
		applyLeave.E10_3450_Level1ApproveAndLevel2_AnyOneOfApproverRejectTheLeave(fakeEmployee);
		// logger.info("E10_3449_Verify_LevelAndLevel2_AllApproverApproveTheLeave is successful");
	}
	@Test(priority = 24)
	public void E10_3451_Verify_Level1ApproveRejectTheLeaveSystemShouldNotAskForLevel2Permission() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3451_Verify_Level1ApproveRejectTheLeaveSystemShouldNotAskForLevel2Permission...");
		
		applyLeave.E10_3451_Level1ApproveRejectTheLeaveSystemShouldNotAskForLevel2Permission(fakeEmployee);
		// logger.info("E10_3451_Verify_Level1ApproveRejectTheLeaveSystemShouldNotAskForLevel2Permission is successful");
	}
//	@Test(priority = 25)
//	public void E10_3469_Verify_CompensationLeave() throws Exception{
//		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
//		// logger.info("E10_3469_Verify_CompensationLeave...");
//		
//		applyLeave.E10_3469_CompensationLeave();
//		// logger.info("E10_3469_Verify_CompensationLeave is successful");
//	}*/
	
	@Test(priority = 26)
	public void E10_3470_Verify_UnrecordLeave() throws Exception{
		captureScreenshot(driver, "E10_3216_ESSApplyLeaveTest");
		// logger.info("E10_3470_Verify_UnrecordLeave...");

		applyLeave.E10_3470_UnrecordLeave(fakeEmployee);
		// logger.info("E10_3470_Verify_UnrecordLeave is successful");
	}
}
