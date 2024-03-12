package com.JiviewsAutomation.SystemDefination_Test;

import java.io.IOException;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_3541_OPE_RTG_PlanningPage;

public class E10_3541_OPE_RTG_PlanningTest extends BaseClass{

	private static final Logger logger = Logger.getLogger(E10_3541_OPE_RTG_PlanningTest.class.getName());
	private E10_3541_OPE_RTG_PlanningPage rtgPlanner;

	@Test(priority = 1)
	public void E10_3542_Verify_SearchRecord() throws InterruptedException, IOException {
//	    captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
//	    logger.info("Starting test: E10_3542_Verify_SearchRecord...");
	  
		rtgPlanner= new E10_3541_OPE_RTG_PlanningPage(driver);
	    
	    
	    
	    rtgPlanner.E10_3542_SearchRecord();
	    
	    logger.info("Test E10_3542_Verify_SearchRecord executed successfully.");
	}

	@Test (priority = 2)
	public void E10_3543_Verify_AddEquipment() throws Exception {
	    captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
	    logger.info("Starting test: E10_3543_Verify_AddEquipment...");
	    
	    rtgPlanner.E10_3543_AddEqipment();
	    
	    logger.info("Test E10_3543_Verify_AddEquipment executed successfully.");
	}

	@Test (priority = 3)
	public void E10_3544_Verify_EquipmentSummary() throws InterruptedException, IOException {
	    captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
	    logger.info("Starting test: E10_3544_Verify_EquipmentSummary...");
	    
	    rtgPlanner.clickonEquipmentSummary();
	    
	    logger.info("Test E10_3544_Verify_EquipmentSummary executed successfully.");
	}

	@Test (priority = 4)
	public void E10_3545_Verify_SkillSummary()  throws InterruptedException, IOException {
	    captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
	    logger.info("Starting test: E10_3545_Verify_SkillSummary...");
	    
	    rtgPlanner.E10_3545_VerifySkillSummery();
	    
	    logger.info("Test E10_3545_Verify_SkillSummary executed successfully.");
	}

	@Test (priority = 5)
	public void E10_3546_Verify_RTGSignOff()  throws InterruptedException, IOException {
	    captureScreenshot(driver, "E10_3211_WorkloadPlannerTest");
	    logger.info("Starting test: E10_3546_Verify_RTGSignOff...");
	    
	    rtgPlanner.E10_3546_RTGSignOff();
	    
	    logger.info("Test E10_3546_Verify_RTGSignOff executed successfully.");
	}



}
