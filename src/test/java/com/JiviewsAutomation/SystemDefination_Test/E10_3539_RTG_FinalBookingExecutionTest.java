package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_3539_RTG_FinalBookingPage;

public class E10_3539_RTG_FinalBookingExecutionTest extends BaseClass{

	private static final Logger logger = Logger.getLogger(E10_3539_RTG_FinalBookingExecutionTest.class.getName());
	private E10_3539_RTG_FinalBookingPage RTG_FinalBooking = new E10_3539_RTG_FinalBookingPage(driver);

	

	@Test(priority = 1)
	public void JS_860_VerifySearchRTGFinalBookingReport() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: verifySearchRTGFinalBookingReport");

		RTG_FinalBooking = new E10_3539_RTG_FinalBookingPage(driver);

		RTG_FinalBooking.E10_3540_SearchRTGFinalBookingReport();

		logger.info("Test verifySearchRTGFinalBookingReport is successful");
	}
	@Test(priority = 2)
	public void JS_861_VerifySearchByShowStandbyEmployees() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: searchByShowStandbyEmployees");

		RTG_FinalBooking.E10_3547_SearchByShowStandbyEmployees();
		logger.info("Test searchByShowStandbyEmployees is successful");
	}
	@Test(priority = 3)
	public void JS_862_VerifySearchByNonPrimarySkillDeployedEmployee() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: searchByNonPrimarySkillDeployedEmployee");

		RTG_FinalBooking.E10_3548_SearchByNonPrimarySkillDeployedEmployee();
		logger.info("Test searchByNonPrimarySkillDeployedEmployee is successful");
	}
	@Test(priority = 4)
	public void JS_863_VerifySearchByUnallocatedWork() throws Exception{
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: searchByUnallocatedWork");

		RTG_FinalBooking.E10_3549_SearchByUnallocatedWork();
		logger.info("Test searchByUnallocatedWork is successful");
	}
	@Test(priority = 5)
	public void JS_864_VerifySearchByOnCallList() throws Exception{
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: searchByOnCallList");

		RTG_FinalBooking.E10_3550_SearchByOnCallList();
		logger.info("Test searchByOnCallList is successful");
	}
	@Test(priority = 6)
	public void JS_865_VerifyDeployment() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: deployment");

		RTG_FinalBooking.E10_3551_Deployment();
		logger.info("Test deployment is successful");
	}

	@Test(priority = 7)
	public void JS_866_VerifyRecokeSignOff() throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: JS_866_VerifyRecokeSignOff");

		RTG_FinalBooking.JS_866_RevokeSignOff();
	}
	@Test(priority = 8)
	public void JS_867_VerifyBroadcastDeployment() throws Exception{
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: JS_867_VerifyBroadcastDeployment");

		RTG_FinalBooking.JS_867_BroadcastDeployment(); 

	}
	@Test(priority = 9)
	public void E10_3559_VerifySwapEmployeeAllocation() throws Exception{
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: JS_867_VerifyBroadcastDeployment");

		RTG_FinalBooking.E10_3559_SwapEmployeeAllocation();
	}
	@Test(priority = 10)
	public void E10_3561_VerifyAddEquipments() throws IOException, Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: E10_3561_VerifyAddEquipments");

		RTG_FinalBooking.E10_3561_AddEquipments();
	}
	@Test(priority = 11)
	public void E10_3563_VerifyAddWorkload() throws Exception{
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: E10_3563_VerifyAddWorkload");

		RTG_FinalBooking.E10_3563_AddWorkload();
		
		
	}
	@Test(priority = 12)
	public void E10_3564_VerifySwapEmployeeShift() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: E10_3564_VerifySwapEmployeeShift");

		RTG_FinalBooking.E10_3564_SwapEmployeeShift();
	}
	
	@Test(priority = 13)
	public void E10_3562_VerifyCreateOrAssignTask() throws Exception {
		captureScreenshot(driver, "E10_3539_RTG_FinalBookingExecutionTest");
		logger.info("Starting test: E10_3562_VerifyCreateOrAssignTask");

		RTG_FinalBooking.E10_3562_CreateOrAssignTask();
		
	}
}
