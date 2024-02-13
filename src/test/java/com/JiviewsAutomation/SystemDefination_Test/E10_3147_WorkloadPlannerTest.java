package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3147_WorkloadPlannerPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.WorkloadPlanningPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_3147_WorkloadPlannerTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_3147_WorkloadPlannerTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems menuItem;
	private WorkloadPlanningPage workloadPlanning;
	private E10_3147_WorkloadPlannerPage workloadPlanner;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		menuItem = new jiviewsMainMenuItems(driver);
		workloadPlanning= new WorkloadPlanningPage(driver);
		workloadPlanner= new E10_3147_WorkloadPlannerPage(driver);

	
		homePage.setOrgUnit();
		Thread.sleep(2000);
		orgUnit.setAutoOu();
		Thread.sleep(2000);
		menuItem.clickOnOperationPlanningExecution();
		workloadPlanning.clickOnWorkloadPlanner();
	}


	@Test(priority = 1)
	public void E10_3211_Verify_CreateVesselScheduleTableView() throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3211 Create Vessel Schedule with Table view...");

		workloadPlanner.E10_3211_CreateVesselScheduleTableView(fakeEmployee);
		logger.info("E10_3211_Create a Vessel Schedule with Table view is successful");
	}
	@Test(priority = 2)
	public void E10_3181_Verify_GenerateEquipments() throws Exception {
		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
		logger.info("E10_3181 Generate Equipment...");

		workloadPlanner.E10_3181_GenerateEquipments(fakeEmployee);	
		logger.info("E10_3181 Generate Equipment is successful");
	}
	@Test(priority = 3)
	public void E10_3182_VerifyPlanningSignoff()  throws Exception{
		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
		logger.info("E10_3182 Planning Signoff...");

		workloadPlanner.E10_3182_PlanningSignoff(fakeEmployee);
		logger.info("E10_3182 Planning Signoff is successful");
	}
	@Test(priority = 4)
	public void E10_3174_VerifyDeleteVesselSchedule() throws IOException, InterruptedException {
		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
		logger.info("E10_3174 Delete Vessel Schedule...");

		workloadPlanner.E10_3174_DeleteVesselSchedule(fakeEmployee);
		logger.info("E10_3174_Delete a Vessel Schedule is successful");
	}
	//	@Test(priority = 1) //  Time Line View 
	//	public void E10_3154_VerifyCreateVesselSchedule() throws Exception {
	//		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
	//		logger.info("E10_3154 Create Vessel Schedule with timeline view...");
	//		
	//		workloadPlanner.E10_3154_CreateVesselSchedule(fakeEmployee);
	//		logger.info("E10_3154_Create a Vessel Schedule is successful");
	//	}
	//	@Test(priority = 1)  // selecting for Crane option is not displaying 
	//	public void E10_3173_VerifyUpdateVesselSchedule() throws InterruptedException, IOException {
	//		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
	//		logger.info("E10_3173 Update Vessel Schedule...");
	//		
	//		
	//		workloadPlanner.E10_3173_UpdateVesselSchedule();
	//		logger.info("E10_3173_Update a Vessel Schedule is successful");
	//	}

	//	@Test
	//	public void E10_3175_VerifyCreateCraneSchedule() throws InterruptedException, IOException {
	//		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
	//		logger.info("E10_3175 Create Crane Schedule...");
	//		
	//		workloadPlanner.E10_3175_CreateCraneSchedule();
	//	}
	//	@Test
	//	public void E10_3178_VerifyCreateEquipmentSchedule()  throws Exception{
	//		captureScreenshot(driver, "E10_3147_WorkloadPlannerTest");
	//		logger.info("E10_3178 Create Equipment Schedule...");
	//		
	//		workloadPlanner.E10_3178_CreateEquipmentSchedule();
	//	}

}
