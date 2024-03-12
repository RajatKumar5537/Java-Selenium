package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_3539_OperationPlanningExecutionPage;

public class E10_3539_OperationPlanningExecutionTest extends BaseClass{
//	private static final // logger // logger = LogManager.get// logger(E10_3539_OperationPlanningExecutionTest.class);
    private E10_3539_OperationPlanningExecutionPage operationPlanning;
   
    private void instantiateOperationPlanningPage() {
        if (operationPlanning == null) {
            operationPlanning = new E10_3539_OperationPlanningExecutionPage(driver);
        }
    }
    
    @Test(priority = 1)
    public void verifySearchRTGFinalBookingReport() throws Exception {
        captureScreenshot(driver, "E10_3539_OperationPlanningExecutionTest");
        // logger.info("Starting test: verifySearchRTGFinalBookingReport");

        operationPlanning = new E10_3539_OperationPlanningExecutionPage(driver);
        operationPlanning.E10_3540_SearchRTGFinalBookingReport();

        // logger.info("Test verifySearchRTGFinalBookingReport is successful");
    }
    @Test(priority = 2)
    public void searchByShowStandbyEmployees() {
        instantiateOperationPlanningPage();
        operationPlanning.E10_3547_SearchByShowStandbyEmployees();
    }
    @Test(priority = 3)
    public void searchByNonPrimarySkillDeployedEmployee() {
        instantiateOperationPlanningPage();
        operationPlanning.E10_3548_SearchByNonPrimarySkillDeployedEmployee();
    }
    @Test(priority = 4)
    public void searchByUnallocatedWork() {
        instantiateOperationPlanningPage();
        operationPlanning.E10_3549_SearchByUnallocatedWork();
    }
    @Test(priority = 5)
    public void searchByOnCallList() {
        instantiateOperationPlanningPage();
        operationPlanning.E10_3550_SearchByOnCallList();
    }
    @Test(priority = 6)
    public void deployment() throws InterruptedException {
        instantiateOperationPlanningPage();
        operationPlanning.E10_3551_Deployment();
    }
  
}
