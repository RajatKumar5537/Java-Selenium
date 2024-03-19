package com.JiviewsAutomation.SystemDefination_Test;

import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_3539_RTG_FinalBookingPage;
import com.AutomationJiviewsPOM.JS_763_PMFinalBookingReportPage;

public class JS_763_PMFinalBookingReportTest extends BaseClass{

	public static final Logger logger = Logger.getLogger(E10_3539_RTG_FinalBookingExecutionTest.class.getName());
	public JS_763_PMFinalBookingReportPage PM_FinalBooking = new JS_763_PMFinalBookingReportPage(driver);
	public E10_3539_RTG_FinalBookingPage rtg = new E10_3539_RTG_FinalBookingPage(driver);


	@Test(priority = 0)
	public void setup() throws Exception {
		PM_FinalBooking = new JS_763_PMFinalBookingReportPage(driver);
		rtg = new E10_3539_RTG_FinalBookingPage(driver);

		rtg.selectOrgUnit();
		rtg.selectOLMop();
		rtg.selectMainMenu();
		rtg.selectOperationPlanningExecution();
		rtg.selectWorkloadPlanning();
		rtg.selectWorkforceExecution();
	}

	@Test(priority = 1)
	public void JS_VerifySearchPMFinalBookingReport() throws Exception {
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: JS_VerifySearchPMFinalBookingReport");


		PM_FinalBooking.E10_SearchPMFinalBookingReport();
		logger.info("Test JS_VerifySearchPMFinalBookingReport is successful");
	}

	@Test(priority = 2)
	public void JS_VerifySearchByShowStandbyEmployees() throws Exception {
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: searchByShowStandbyEmployees");

		PM_FinalBooking.E10_SearchByShowStandbyEmployees();
		logger.info("Test searchByShowStandbyEmployees is successful");
	}

	@Test(priority = 3)
	public void JS_862_VerifySearchByNonPrimarySkillDeployedEmployee() throws Exception {
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: searchByNonPrimarySkillDeployedEmployee");

		PM_FinalBooking.E10_SearchByNonPrimarySkillDeployedEmployee();
		logger.info("Test searchByNonPrimarySkillDeployedEmployee is successful");
	}
	@Test(priority = 4)
	public void JS_863_VerifySearchByUnallocatedWork() throws Exception{
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: searchByUnallocatedWork");

		PM_FinalBooking.E10_SearchByUnallocatedWork();
		logger.info("Test searchByUnallocatedWork is successful");
	}
	@Test(priority = 5)
	public void JS_864_VerifySearchByOnCallList() throws Exception{
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: searchByOnCallList");

		PM_FinalBooking.E10_SearchByOnCallList();
		logger.info("Test searchByOnCallList is successful");
	}

	@Test(priority = 6)
	public void E10_VerifyDeployment()throws Exception{
		//captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: E10_VerifyDeployment");

		PM_FinalBooking.E10_Deployment();
		logger.info("Test E10_VerifyDeployment is successful");
	}
	@Test(priority = 7)
	public void JS_VerifyRevokeSignOff() throws Exception {
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: JS_VerifyRevokeSignOff");

		PM_FinalBooking.JS_RevokeSignOff();
		logger.info("Test JS_VerifyRevokeSignOff is successful");
	}
	@Test(priority = 8)
	public void JS_VerifyBroadcastDeployment() throws Exception{
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: JS_VerifyRevokeSignOff");

		PM_FinalBooking.JS_BroadcastDeployment();
		logger.info("Test JS_VerifyRevokeSignOff is successful");

	}
	@Test(priority = 9)
	public void E10_VerifySwapEmployeeAllocation() throws Exception{
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: JS_VerifyRevokeSignOff");

		PM_FinalBooking.E10_SwapEmployeeAllocation();
		logger.info("Test JS_VerifyRevokeSignOff is successful");
	}


	@Test(priority = 12)
	public void E10_SwapEmployeeShift() throws Exception{
		//captureScreenshot(driver, "JS_763_PMFinalBookingReportTest");
		logger.info("Starting test: E10_SwapEmployeeShift");

		PM_FinalBooking.E10_SwapEmployeeShift();
		logger.info("Test E10_SwapEmployeeShift is successful");
	}
	
//	@Test(priority = 10)
//
//	public void E10_VerifyAddEquipments() throws Exception {
//		//captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
//		logger.info("Starting test: E10_AddEquipments");
//
//		PM_FinalBooking.E10_AddEquipments();
//		logger.info("Test E10_AddEquipments is successful");
//	}
//	@Test(priority = 11)
//	public void E10_VerifyAddWorkload() throws Exception {
//		//captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
//		logger.info("Starting test: E10_AddWorkload");
//
//		PM_FinalBooking.E10_AddWorkload();
//		logger.info("Test E10_AddWorkload is successful");
//	}
//	@Test(priority = 13)
//	public void E10_CreateOrAssignTask() throws Exception {
//		//captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
//		logger.info("Starting test: E10_CreateOrAssignTask");
//
//		PM_FinalBooking.E10_CreateOrAssignTask();
//		logger.info("Test E10_CreateOrAssignTask is successful");
//	}
}
