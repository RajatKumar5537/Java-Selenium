package com.JiviewsAutomation.SystemDefination_Test;


import java.io.IOException;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2910_EmployeeRosterV2Page;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.WorkforceSchedulingPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

// Jira Item: E10_2910 - Employee Roster V2
public class E10_2910_WorkforceEmployeeRosterV2Test extends BaseClass{
//	private static final // logger // logger = LogManager.get// logger(E10_2910_WorkforceEmployeeRosterV2Test.class);
	private HomePage homePage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private WorkforceSchedulingPage wfScheduling;
	private E10_2910_EmployeeRosterV2Page empRosterV2;

	@Test(priority = 0)
	public void setup() throws Exception {
//		String homeUrl = configUtility.getCongigPropertyData("homeurl");
//		driver.navigate().to(homeUrl);
	
		homePage = new HomePage(driver);
		orgUnit = new OrganizationUnitDropDown(driver);
		jmMenuItem = new jiviewsMainMenuItems(driver);
		wfScheduling= new WorkforceSchedulingPage(driver);
		empRosterV2= new  E10_2910_EmployeeRosterV2Page(driver);

		Thread.sleep(2000);
		homePage.setOrgUnit();		
		orgUnit.setAutoOu();
//		Thread.sleep(5000);
		jmMenuItem.setSelectWorkforceScheduling(); 
//		Thread.sleep(2000);
//		wfScheduling.setEmployeeRosterV2();
	}
	@Test(priority = 1)
	public void E10_2938_VerifySearchEmpRosterByDate() throws Exception {
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Searching Employee Roster By Date...");
		

		empRosterV2.searchEmpRosterByDate(fakeEmployee);
		// logger.info("Search Employee Roster By Date is successful");
	}

	@Test(priority = 2)//, dependsOnMethods = "verifySearchByFilters")
	public void E10_2940_VerifyExpandAndCollapseRows() throws IOException, InterruptedException {
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Expanding And Collapsing Rows...");

		empRosterV2.expandAndCollapseRows(fakeEmployee);
		// logger.info("Expand And Collapse Rows is successful");
	}
	
	@Test(priority = 3)
	public void E10_2941_VerifyFilterAndResetColumns() throws IOException, InterruptedException {
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Filtering And Resetting Columns...");

		empRosterV2.filterAndResetColumns(fakeEmployee);
		// logger.info("Filter And Reset Columns is successful");
	}

	@Test(priority = 5)
	public void E10_2942_VerifyPerformFullScreen() throws IOException, InterruptedException {
		// Jira Item: E10-2942 - Employee Roster V2 [Expand and minimize full screen]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Expand and minimize full screen...");

		empRosterV2.performFullScreen(fakeEmployee);
		// logger.info("Perform Expand and minimize full screen is successful");
	}

	@Test(priority = 6)
	public void E10_2943_VerifyPerformCreateShift() throws Exception {
		// Jira Item: E10-2943 - Employee Roster V2 [Double click on tab or right click and select create shift]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Double click on tab or right click and select create shift in an Empty Cell...");

		empRosterV2.performClickEmptyCellCreateShift(fakeEmployee);
		// logger.info("Perform Double click on tab or right click and select create shift in an Empty Cell is successful");
	}

	@Test(priority = 7)
	public void E10_2944_verifyCopySingleCellAndPasteInNewCell() throws Exception {
		// Jira Item: E10-2944 - Employee Roster V2 [Copy single and multiple row/column and paste in a new row]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Double click on tab or right click and select create shift in an Empty Cell...");

		empRosterV2.CopySingleCellAndPasteInNewCell(fakeEmployee);
		// logger.info("Perform Double click on tab or right click and select create shift in an Empty Cell is successful");	
	}
	@Test(priority = 8)
	public void E10_2945_VerifyCopyWithOncallShift() throws Exception {
		// Jira Item: E10-2945 - Employee Roster V2 [Right click -> Copy with Oncall, Remark and OC & Remarks]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Copy with Oncall Shift...");

		empRosterV2.CopyWithOncallShift(fakeEmployee);
		// logger.info("Copy with Oncall Shift is successful");
	}
//	@Test(priority = 8)
//	public void E10_2944_VerifyCopySingleRowColumnAndPasteInNewRow() throws IOException, InterruptedException {
//		// Jira Item: E10-2944 - Employee Roster V2 [Copy single and multiple row/column and paste in new row]
//		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
//		// logger.info("verifyCopySingleRowColumnAndPasteInNewRow...");
//
//		empRosterV2.CopySingleRowColumnAndPasteInNewRow(fakeEmployee);
//		// logger.info("verifyCopySingleRowColumnAndPasteInNewRow is successful");
//	}

	@Test(priority = 9)
	public void E10_2946_VerifyExportToTextAndExcel() throws Exception {
		// Jira Item: E10-2946 - Employee Roster V2 [Right Click -> Export to Text and Excel]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Export to Text and Excel...");

		empRosterV2.ExportToTextAndExcel(fakeEmployee);
		// logger.info("Export to Text and Excel is successful");
	}

	
/*
	@Test(priority = 11)
	public void E10_2948_VerifyApplyOnBehalfApplyLeave() throws Exception {
		// Jira Item: E10-2948 - Employee Roster V2 [Right click -> Apply On Behalf Apply leave]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply leave...");

		empRosterV2.applyOnBehalfApplyLeave(fakeEmployee);
		// logger.info("Apply On Behalf Apply leave is successful");
	}
	
	@Test(priority = 12)
	public void E10_2949_VerifyTestCopyAndPasteToExcel() throws IOException, InterruptedException {
		// Jira Item: E10-2949 - Employee Roster V2 [Right click on Employee and click copy and paste in Excel sheet]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Right click on Employee and click copy and paste in Excel sheet...");

		empRosterV2.testCopyAndPasteToExcel(fakeEmployee);
		// logger.info("Right click on Employee and click copy and paste in Excel sheet is successful");
	}
	
	@Test(priority = 13)
	public void E10_2950_VerifyOpenNewTabEmployeeProfile() throws Exception {
		// Jira Item: E10-2950 - Employee Roster V2 [Right click -> Employee Profile]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
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
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
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
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
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
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Click Different tab in Summary...");

		empRosterV2.clickDifferentTabinSummary(fakeEmployee);
		// logger.info("Click Different tab in Summary is successful");
	}
	@Test(priority = 17)
	public void E10_3006_VerifysearchByFiltersShiftBand() throws Exception {
		// Jira Item: E10-3006 - Employee Roster V2 [Search Filter By Shift Band]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Click Different tab in Summary...");

		empRosterV2.searchByFiltersShiftBand();
		// logger.info("Click Different tab in Summary is successful");	
	}


	@Test(priority = 18)
	public void E10_3039_VerifyApplyUncontrolledLeave() throws Exception {
		//	Jira Item: E10-3039 - Employee Roster V2  [Right Click] [Apply On Behalf] Apply Uncontrolled Leave
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Uncontrolled Leave ...");

		empRosterV2.ApplyUncontrolledLeave(fakeEmployee);
		// logger.info("Apply On Behalf Apply Uncontrolled Leave is successful");
	}
	@Test(priority = 19)
	public void E10_3040_VerifyApplyExcludeDeployment() throws Exception {
		//	Jira Item: E10-3040 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Exclude Deployment
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Uncontrolled Leave ...");

		empRosterV2.applyExcludeDeployment(fakeEmployee);
		// logger.info("Apply On Behalf Apply Uncontrolled Leave is successful");
	}
	@Test(priority = 20)
	public void E10_3038_VerifyApplyOnBehalApplyTimeOff() throws Exception {
		// Jira Item: E10-3038 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Time off 
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Apply On Behalf Apply Time off ...");

		empRosterV2.ApplyTimeOff(fakeEmployee);
		// logger.info("Apply On Behalf Apply Time off  is successful");
	}
	
	*/
	@Test(priority = 10) //keep it in last 
	public void E10_2947_VerifyExpandAndCollapseGroup() throws Exception {
		// Jira Item: E10-2947 - Employee Roster V2 [Right click -> Expand and Collapse group]
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Performing Expand and Collapse Group...");

		empRosterV2.CollapseRowByGroup(fakeEmployee);
		// logger.info("Expand and Collapse Group is successful");
	}
	@Test(priority = 21) //keep it in last 
	public void E10_2939_VerifySearchByFilters() throws IOException, InterruptedException {
		captureScreenshot(driver, "WorkforceEmployeeRosterV2Test");
		// logger.info("Searching Employee Roster By Filters...");

		empRosterV2.searchByFilters();
		// logger.info("Search Employee Roster By Filters is successful");
	}
}
