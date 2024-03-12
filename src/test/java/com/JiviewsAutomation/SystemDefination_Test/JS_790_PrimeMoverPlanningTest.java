package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.JS_790_PrimeMoverPlanning;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.WorkloadPlanningPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class JS_790_PrimeMoverPlanningTest extends BaseClass{

	private static final Logger logger = Logger.getLogger(JS_790_PrimeMoverPlanningTest.class.getName());
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems menuItem;
	private WorkloadPlanningPage workloadPlanning;
	private JS_790_PrimeMoverPlanning PMPLanning;



	//	@BeforeMethod
	@Test(priority = 0)
	public void setUp() throws Exception {

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		menuItem = new jiviewsMainMenuItems(driver);
		workloadPlanning= new WorkloadPlanningPage(driver);
		PMPLanning= new JS_790_PrimeMoverPlanning(driver);
		//		rtgPlanner= new E10_3541_OPE_RTG_PlanningPage(driver);



		homePage.setOrgUnit();
		orgUnit.clickOLMop();
		menuItem.clickOnOperationPlanningExecution();
	}

	@Test(priority = 1)
	public void JS_915_VerifySearchRecord() throws Exception {
		captureScreenshot(driver, "JS_790_PrimeMoverPlanningTest");
		logger.info("Starting test: createPrimeMoverPlanning...");

		workloadPlanning.clickPrimeMoverPlanning();
		PMPLanning.JS_915_SearchRecord();

		logger.info("Test createPrimeMoverPlanning executed successfully.");
	}

	@Test(priority = 2)
	public void JS_916_VerifyAddLocation() throws Exception {
		captureScreenshot(driver, "JS_790_PrimeMoverPlanningTest");
		logger.info("Starting test: JS_916_VerifyAddLocation...");


		PMPLanning.JS_916_AddLocation();

		logger.info("Test createPrimeMoverPlanning executed successfully.");
	}
	@Test(priority = 3)
	public void JS_917_VerifyEquipmentSummery() throws IOException {
		captureScreenshot(driver, "JS_790_PrimeMoverPlanningTest");
		logger.info("Starting test: JS_917_VerifyEquipmentSummery...");

		PMPLanning.JS_917_VerifyEquipmentSummery();
	}

	@Test(priority = 4)
	public void JS_918_VerifySkillSummery() throws IOException {
		captureScreenshot(driver, "JS_790_PrimeMoverPlanningTest");
		logger.info("Starting test: JS_918_VerifySkillSummery...");

		PMPLanning.JS_918_VerifySkillSummery();
	}
}
