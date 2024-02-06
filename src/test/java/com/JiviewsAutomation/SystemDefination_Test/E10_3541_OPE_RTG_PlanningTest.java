package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;
import com.AutomationJiviewsPOM.E10_3541_OPE_RTG_PlanningPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.WorkloadPlanningPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class E10_3541_OPE_RTG_PlanningTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(E10_3147_WorkloadPlannerTest.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems menuItem;
	private WorkloadPlanningPage workloadPlanning;
	private E10_3541_OPE_RTG_PlanningPage rtgPlanner;

	@BeforeMethod
	public void setup() throws Exception {
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);

		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		menuItem = new jiviewsMainMenuItems(driver);
		workloadPlanning= new WorkloadPlanningPage(driver);
		rtgPlanner= new E10_3541_OPE_RTG_PlanningPage(driver);
//		rtgPlanner= new E10_3541_OPE_RTG_PlanningPage(driver);
		Thread.sleep(2000);
		homePage.setOrgUnit();
		Thread.sleep(2000);
		orgUnit.setAutoOu();
		Thread.sleep(2000);
		menuItem.clickOnOperationPlanningExecution();
		workloadPlanning.clickOnRTGPlanning();
	}
	@Test(priority = 1)
	public void E10_3542_Verify_SearchRecord() throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3542_Verify_SearchRecord...");

		rtgPlanner.E10_3542_SearchRecord();
		logger.info("E10_3542_Verify_SearchRecord is successful");
	}
	@Test (priority = 2)
	public void E10_3543_Verify_AddEqipment() throws Exception {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3543_AddEqipment...");

		rtgPlanner.E10_3543_AddEqipment();
		logger.info("E10_3543_AddEqipment is successful");
		
	}
	@Test (priority = 3)
	public void E10_3544_Verify_EquipmentSummery () throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3544_VerifyEquipmentSummery...");

		rtgPlanner.E10_3544_VerifyEquipmentSummery();
		logger.info("E10_3544_VerifyEquipmentSummery is successful");
		
	}
	@Test (priority = 4)
	public void E10_3545_Verify_SkillSummery ()  throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3546_RTGSignOff...");

		rtgPlanner.E10_3545_VerifySkillSummery();
		logger.info("E10_3546_RTGSignOff is successful");
		
	}
	@Test (priority = 5)
	public void E10_3546_Verify_RTGSignOff()  throws InterruptedException, IOException {
		captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
		logger.info("E10_3546_RTGSignOff...");

		rtgPlanner.E10_3546_RTGSignOff();
		logger.info("E10_3546_RTGSignOff is successful");
		
	}
}
