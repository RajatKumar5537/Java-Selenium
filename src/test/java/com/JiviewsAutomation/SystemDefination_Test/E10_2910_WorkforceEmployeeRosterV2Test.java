package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2910_EmployeeRosterV2Page;

public class E10_2910_WorkforceEmployeeRosterV2Test extends BaseClass
{

	public  E10_2910_EmployeeRosterV2Page empRosterV2;

	@Test(priority = 1)
	public void E10_2938_VerifySearchEmpRosterByDate() throws Exception 
	{
		empRosterV2= new  E10_2910_EmployeeRosterV2Page(driver);
		empRosterV2.searchEmpRosterByDate();
	}

	@Test(priority = 2)
	public void E10_2940_VerifyExpandAndCollapseRows() throws InterruptedException 
	{

		empRosterV2.expandAndCollapseRows();
	}

	@Test(priority = 3)
	public void E10_2941_VerifyFilterAndResetColumns() throws  InterruptedException 
	{

		empRosterV2.filterAndResetColumns();
	}

	@Test(priority = 5)
	public void E10_2942_VerifyPerformFullScreen() throws  InterruptedException 
	{

		empRosterV2.performFullScreen();
	}

	//	@Test(priority = 6)
	//	public void E10_2943_VerifyPerformCreateShift() throws Exception {
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		 logger.info("Performing Double click on tab or right click and select create shift in an Empty Cell...");
	//
	//		empRosterV2.performClickEmptyCellCreateShift(fakeEmployee);
	//		 logger.info("Perform Double click on tab or right click and select create shift in an Empty Cell is successful");
	//	}

	//	@Test(priority = 7)
	//	public void E10_2944_verifyCopySingleCellAndPasteInNewCell() throws Exception {
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		 logger.info("Performing Double click on tab or right click and select create shift in an Empty Cell...");
	//
	//		empRosterV2.CopySingleCellAndPasteInNewCell(fakeEmployee);
	//		 logger.info("Perform Double click on tab or right click and select create shift in an Empty Cell is successful");	
	//	}
	//	@Test(priority = 8)
	//	public void E10_2945_VerifyCopyWithOncallShift() throws Exception {
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		 logger.info("Performing Copy with Oncall Shift...");
	//
	//		empRosterV2.CopyWithOncallShift(fakeEmployee);
	//		 logger.info("Copy with Oncall Shift is successful");
	//	}
	//	@Test(priority = 8)
	//	public void E10_2944_VerifyCopySingleRowColumnAndPasteInNewRow() throws IOException, InterruptedException {
	//		// Jira Item: E10-2944 - Employee Roster V2 [Copy single and multiple row/column and paste in new row]
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		// logger.info("verifyCopySingleRowColumnAndPasteInNewRow...");
	//
	//		empRosterV2.CopySingleRowColumnAndPasteInNewRow(fakeEmployee);
	//		// logger.info("verifyCopySingleRowColumnAndPasteInNewRow is successful");
	//	}

	//	@Test(priority = 9)
	//	public void E10_2946_VerifyExportToTextAndExcel() throws Exception {
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		 logger.info("Performing Export to Text and Excel...");
	//
	//		empRosterV2.ExportToTextAndExcel(fakeEmployee);
	//		 logger.info("Export to Text and Excel is successful");
	//	}


	/*
	@Test(priority = 11)
	public void E10_2948_VerifyApplyOnBehalfApplyLeave() throws Exception {
		// Jira Item: E10-2948 - Employee Roster V2 [Right click -> Apply On Behalf Apply leave]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply leave...");

		empRosterV2.applyOnBehalfApplyLeave(fakeEmployee);
		// logger.info("Apply On Behalf Apply leave is successful");
	}

	@Test(priority = 12)
	public void E10_2949_VerifyTestCopyAndPasteToExcel() throws IOException, InterruptedException {
		// Jira Item: E10-2949 - Employee Roster V2 [Right click on Employee and click copy and paste in Excel sheet]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Right click on Employee and click copy and paste in Excel sheet...");

		empRosterV2.testCopyAndPasteToExcel(fakeEmployee);
		// logger.info("Right click on Employee and click copy and paste in Excel sheet is successful");
	}

	@Test(priority = 13)
	public void E10_2950_VerifyOpenNewTabEmployeeProfile() throws Exception {
		// Jira Item: E10-2950 - Employee Roster V2 [Right click -> Employee Profile]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Employee Profile...");

		try {
			empRosterV2.clickonEmployeeProfile(fakeEmployee);
			// logger.info("Performing Employee Profile is successful");
		} catch (Exception e) {
			// logger.error("Error occurred during Performing Employee Profile: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 14)
	public void E10_2951_VerifyOpenNewTabLeaveProfile() throws Exception {
		// Jira Item: E10-2951 - Employee Roster V2 [Right click -> Leave Profile]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Leave Profile...");

		try {
			empRosterV2.clickonLeaveProfile(fakeEmployee);
			// logger.info("Performing Employee Leave is successful");
		} catch (Exception e) {
			// logger.error("Error occurred during Performing Employee Leave: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 15)
	public void E10_2952_VerifyOpenNewTabApprovalRoute() throws Exception {
		// Jira Item: E10-2952 - Employee Roster V2 [Right click -> Approval Route]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Approval Route...");

		try {
			empRosterV2.clickonApprovalRoute(fakeEmployee);
			// logger.info("Performing Approval Route is successful");
		} catch (Exception e) {
			// logger.error("Error occurred during Performing Approval Route: " + e.getMessage());
			throw e;
		}
	}
	@Test(priority = 16)
	public void E10_2954_VerifyClickDifferentTabinSummary() throws IOException, InterruptedException {
		// Jira Item: E10-2954 - Employee Roster V2 [ Click Different tab in Summary]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Click Different tab in Summary...");

		empRosterV2.clickDifferentTabinSummary(fakeEmployee);
		// logger.info("Click Different tab in Summary is successful");
	}
	@Test(priority = 17)
	public void E10_3006_VerifysearchByFiltersShiftBand() throws Exception {
		// Jira Item: E10-3006 - Employee Roster V2 [Search Filter By Shift Band]
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Click Different tab in Summary...");

		empRosterV2.searchByFiltersShiftBand();
		// logger.info("Click Different tab in Summary is successful");	
	}


	@Test(priority = 18)
	public void E10_3039_VerifyApplyUncontrolledLeave() throws Exception {
		//	Jira Item: E10-3039 - Employee Roster V2  [Right Click] [Apply On Behalf] Apply Uncontrolled Leave
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Uncontrolled Leave ...");

		empRosterV2.ApplyUncontrolledLeave(fakeEmployee);
		// logger.info("Apply On Behalf Apply Uncontrolled Leave is successful");
	}
	@Test(priority = 19)
	public void E10_3040_VerifyApplyExcludeDeployment() throws Exception {
		//	Jira Item: E10-3040 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Exclude Deployment
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Uncontrolled Leave ...");

		empRosterV2.applyExcludeDeployment(fakeEmployee);
		// logger.info("Apply On Behalf Apply Uncontrolled Leave is successful");
	}
	@Test(priority = 20)
	public void E10_3038_VerifyApplyOnBehalApplyTimeOff() throws Exception {
		// Jira Item: E10-3038 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Time off 
		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Time off ...");

		empRosterV2.ApplyTimeOff(fakeEmployee);
		// logger.info("Apply On Behalf Apply Time off  is successful");
	}

	 */
	//	@Test(priority = 10) //keep it in last 
	//	public void E10_2947_VerifyExpandAndCollapseGroup() throws Exception {
	//		// Jira Item: E10-2947 - Employee Roster V2 [Right click -> Expand and Collapse group]
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		// logger.info("Performing Expand and Collapse Group...");
	//
	//		empRosterV2.CollapseRowByGroup(fakeEmployee);
	//		// logger.info("Expand and Collapse Group is successful");
	//	}
	//	@Test(priority = 21) //keep it in last 
	//	public void E10_2939_VerifySearchByFilters() throws IOException, InterruptedException {
	//		//captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
	//		// logger.info("Searching Employee Roster By Filters...");
	//
	//		empRosterV2.searchByFilters();
	//		// logger.info("Search Employee Roster By Filters is successful");
	//	}
}
