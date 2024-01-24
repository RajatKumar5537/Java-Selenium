package com.AutomationJiviewsPOM;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.FakeEmployee;
import com.AutomationJiviewsGeneric.configUtility;

public class E10_2910_EmployeeRosterV2Page extends BaseClass{
	public Actions actions = new Actions(driver);
	ExcelUtilities excelUtilities= new ExcelUtilities();

	@FindBy(xpath = "//input[@id='dtStartAndEnd']")
	private WebElement dateStartAndEnd;
	@FindBy(xpath = "(//input[@name='daterangepicker_start'])[2]")
	private WebElement selectStartDate;
	@FindBy(xpath = "(//input[@name='daterangepicker_end'])[2]")
	private WebElement selectEndDate;
	@FindBy(xpath = "//span[@id='select2-cmbRosterGroupBy-container']")
	private WebElement cmbRosterGroupBy;
	@FindBy(xpath = "//ul[@id='select2-cmbRosterGroupBy-results']/li")
	private WebElement selectRoleGroup;
	@FindBy(xpath = "(//button[text()='Apply'])[2]")
	private WebElement clickApply;

	@FindBy(xpath = "//button[@id='btnSearchEmployeeRoster']")
	private WebElement btnSearchEmployeeRoster;

	@FindBy(xpath = "//li[@id='btnFilterDiv']")
	private WebElement btnFilterDiv;
	@FindBy(xpath = "//div[@id='filterEmployee']/div")
	private WebElement filterEmployee;

	@FindBy(xpath = "//div[@id='filterRosterGroup']/div")
	private WebElement filterRosterGroup;
	@FindBy(xpath = "//ul[@id='select2-cmbReportRosterGroup-results']/li")
	private WebElement chooseRosterGroup;

	@FindBy(xpath = "//div[@id='filterRoleGroup']")
	private WebElement filterRoleGroup;
	@FindBy(xpath = "//li[contains(text(),'RTGO Operator')]")
	private WebElement chooseRoleGroup;

	@FindBy(xpath = "//div[@id='filterShiftBand']")
	private WebElement filterShiftBand;
	@FindBy(xpath = "//li[contains(text(),'1st  Shift')]")
	private WebElement chooseShiftBand;

	@FindBy(xpath = "//ul/span[@class='select2-selection__clear']")
	private List<WebElement> selectionClear;

	@FindBy(xpath = "//button[@id='filterSeachBtn']")
	private WebElement filterSeachBtn;
	@FindBy(xpath = "//button[@class='btn btn-default']")
	private WebElement btnHide;

	@FindBy(xpath = "//span[@id='btnExpandText']")
	private WebElement btnExpandDiv;
	@FindBy(xpath = "//span[@id='btnExpandText']")
	private WebElement btnExpandText;

	@FindBy(xpath = "(//div[@class='navbar-showhidecolumns nav-item dropdown show'])[2]")
	private WebElement columns;
	@FindBy(xpath = "//span[text()='EMPLOYEE']")
	private WebElement employee;
	@FindBy(xpath = "//span[text()='HOUR']")
	private WebElement hour;
	@FindBy(xpath = "//span[text()='ACT COST']")
	private WebElement actCost;
	@FindBy(xpath = "//span[text()='SHIFT']")
	private WebElement shift;
	@FindBy(xpath = "//span[text()='Day S1']")
	private WebElement dayS1;
	@FindBy(xpath = "//span[text()='Night S2']")
	private WebElement nightS2;
	@FindBy(xpath = "//span[text()='Office O']")
	private WebElement officeO;
	@FindBy(xpath = "//span[text()='QCDAY']")
	private WebElement qcDay;

	@FindBy(xpath = "//button[text()='Close']")
	private WebElement btnClose;
	@FindBy(xpath = "//button[text()='Reset']")
	private WebElement btnReset;

	@FindBy(xpath = "//span[@id='btnFullScreen']")
	private WebElement btnFullScreen;

	@FindBy(xpath = "//div[text()='OFF']")
	private WebElement emptyCell;
	@FindBy(xpath = "//span[text()='Create Shift']/..")
	private WebElement CreateShift;
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement txtShiftBand;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectResultsShiftBand;

	@FindBy(xpath = "//span[text()=' On Call ']")
	private WebElement onCallShift;

	@FindBy(xpath = "//span[@id='select2-cmbRoleName-container']")
	private WebElement txtRoleName;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement selectResultsRoleName;

	@FindBy(xpath = "//textarea[@id='txtShiftNotes']")
	private WebElement txtShiftNotes;
	@FindBy(xpath = "//button[@id='btnSelectShiftBand']") 
	private WebElement btnSelectShiftBand;
	@FindBy(xpath = "//div[text()='Shift created successfully']")
	private WebElement shiftCreatedSuccessfullyMsg;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//div[@class='cssShiftCard']") 
	private WebElement cssShiftCard;
	@FindBy(xpath = "//div[text()='HE']")
	private WebElement applyExcludeDeployment;
	@FindBy(xpath = "//div[text()='TI']")
	private WebElement applyTimeOff;

	@FindBy(xpath = "//span[text()='Copy']")
	private WebElement copyOption;

	@FindBy(xpath = "//span[text()='Paste']")
	private WebElement pasteOption;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "(//table[@class='tui-grid-table'])[5]/tbody/tr[2]")
	private WebElement sourceRow;
	@FindBy(xpath = "(//table[@class='tui-grid-table'])[5]/tbody/tr[4]")
	private WebElement destinationRow;

	@FindBy(xpath = "//div[@class='indicatorShift']")
	private WebElement callIndicatorShift;
	@FindBy(xpath = "//span[text()='Copy Special']/..")
	private WebElement copySpecial;
	@FindBy(xpath = "//span[text()='Copy with Both']/..")
	private WebElement copyWithOCRemarks;


	@FindBy(xpath = "//span[text()='Export']/..")
	private WebElement exportOption;
	@FindBy(xpath = "//span[text()='Text File']/..")
	private WebElement textFileOption;
	@FindBy(xpath = "//span[text()='Excel File']/..")
	private WebElement excelFileOption;

	@FindBy(xpath = "//div[text()='Data has been exported successfully ']")
	private WebElement dataExportedSuccessfullyMsg; 
	@FindBy(xpath = "//span[text()='Collapse Group']")
	private WebElement CollapseGroupOption;

	@FindBy(xpath = "//span[text()='Apply On Behalf']/..")
	private WebElement applyOnBehalfOption;

	@FindBy(xpath = "//span[text()='Apply Leave']/..")
	private WebElement applyLeaveOption;
	@FindBy(xpath = "//span[@id='select2-cmbExceptionType-container']")
	private WebElement leaveType;
	@FindBy(xpath = "//li[text()='Sick Leave']")
	private WebElement selectSickLeave;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	private WebElement selectEmergencyLeave;

	// Get Title:
	@FindBy(xpath = "//td[@class='tui-grid-cell tui-grid-cell-has-input tui-grid-cell-disabled tui-grid-cell-has-tree ']")
	private WebElement rightClickEmployee;
	@FindBy(xpath = "//span[text()='Employee Profile']/..")
	private WebElement employeeProfileOption;
	@FindBy(xpath = "//span[text()='Leave Profile']/..")
	private WebElement leaveProfileOption;
	@FindBy (xpath = "//span[text()='Approval Route']/..")
	private WebElement approvalRouteOption;

	@FindBy(xpath = "//input[@id='dtLeaveStartDate']")
	private WebElement dtLeaveStartDate;
	@FindBy(xpath = "//input[@id='dtLeaveEndDate']")
	private WebElement dtLeaveEndDate;
	@FindBy(xpath = "//input[@id='txtLeaveReferenceNo']")
	private WebElement txtLeaveReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtLeaveRemarks']")
	private WebElement txtLeaveRemarks;
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement btnNext;
	@FindBy(xpath = "//button[text()='Previous']")
	private WebElement btnPrevious;

	@FindBy(xpath = "//a[text()='Shift Count']")
	private WebElement tabShiftCount;
	@FindBy(xpath = "//a[text()='Leave Count']")
	private WebElement tabLeaveCount;
	@FindBy(xpath = "//a[text()='Required Resources']")
	private WebElement tabRequiredResources;
	@FindBy(xpath = "//a[text()='Shift Shortage']")
	private WebElement tabShiftShortage;

	@FindBy(xpath = "//td[@data-column-name='EmployeeSearch']")
	private List<WebElement> columnEmployeeSearch;

	@FindBy(xpath = "//span[text()='Apply Time off']")
	private WebElement applyTimeOffOption;
	@FindBy(xpath = "//input[@id='dtTimeOffDate']")
	private WebElement dtTimeOffDate;
	
	@FindBy(xpath = "//span[@id='select2-cmbTimeOffPeriod-container']")
	private WebElement txtTimeOffPeriod;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement chooseShiftStart;
	@FindBy(xpath = "//li[text()='Shift End']")
	private WebElement chooseShiftEnd;
	@FindBy(xpath = "//textarea[@id='txtTimeOffRemarks']")
	private WebElement txtTimeOffRemarks;

	//	@FindBy(xpath = "(//button[@id='btnAddAttachment'])[2]")
	//	private WebElement btnAddAttachment; not working button 

	@FindBy(xpath = "//button[@id='btnApplyTimeOff']")
	private WebElement btnApplyTimeOff;

	@FindBy(xpath = "//div[text()='Time Off Request Submitted Successfully']")
	private WebElement timeOffRequestSubmittedSuccessfullyMsg;

	@FindBy(xpath = "//span[text()='Apply Uncontrolled Leave']")
	private WebElement applyUncontrolledLeaveOption;
	@FindBy(xpath = "//span[@id='select2-cmbUCLExceptionType-container']")
	private WebElement txtUCLExceptionType;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement chooseUncontrolLeave;
	@FindBy(xpath = "//input[@id='txtUCLReferenceNo']")
	private WebElement txtUCLReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtUCLRemarks']")
	private WebElement txtUCLRemarks;
	@FindBy(xpath = "//button[@id='btnApplyUCL']")
	private WebElement btnApplyUCL;


	@FindBy(xpath = "//span[text()='Exclude Deployment']")
	private WebElement excludeDeploymentOption;
	@FindBy(xpath = "//span[@id='select2-cmbEDExceptionType-container']")
	private WebElement cmbEDExceptionType;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement chooseExcludeDeployment;
	@FindBy(xpath = "//input[@id='txtEDReferenceNo']")
	private WebElement txtEDReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtEDRemarks']")
	private WebElement txtEDRemarks;
	@FindBy(xpath = "//button[@id='btnApplyExcludeDeployment']")
	private WebElement btnApplyExcludeDeployment;
	@FindBy(xpath = "//div[text()='Exclude Deployment Exception Created Successfully']")
	private WebElement excludeDeploymentExceptionCreatedSuccessfullyMsg;



	public E10_2910_EmployeeRosterV2Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	public void clickStartAndEndDate() throws InterruptedException {
		Thread.sleep(4000);
		webUtility.ElementClickable(driver, dateStartAndEnd);
		dateStartAndEnd.click();
	}
	public void enterStartDate(String startDate) {
		selectStartDate.clear();
		selectStartDate.sendKeys(startDate);
		selectStartDate.sendKeys(Keys.ENTER);
	}
	public void enterEndDate(String endDate) {
		selectEndDate.clear();
		selectEndDate.sendKeys(endDate);
		selectEndDate.sendKeys(Keys.ENTER);
	}
	public void clickApply() {
		clickApply.click();
	}
	public void cmbRosterGroupBy() {
		webUtility.ElementClickable(driver, cmbRosterGroupBy);
		cmbRosterGroupBy.click();
		selectRoleGroup.click();
	}
	public void clickbtnSearchEmployeeRoster() {
		btnSearchEmployeeRoster.click();
	}
	public void clickBtnFilter() {
		webUtility.ElementClickable(driver, btnFilterDiv);
		btnFilterDiv.click();
	}
	public void enterEmployeeName() {
		filterEmployee.click();
	}
	public void chooseRosterGroup() { 
		filterRosterGroup.click();
		chooseRosterGroup.click();
	}
	public void chooseRoleGroup() {
		filterRoleGroup.click(); 
		chooseRoleGroup.click();
	}
	public void chooseShiftBand() {
		filterShiftBand.click();
		chooseShiftBand.click();
	}
	public void clickFilterSeachBtn() {
		filterSeachBtn.click();
	}
	public void disableSelectedFilters() {
		for (WebElement clear : selectionClear) {
			try {
				if (clear.isDisplayed()) {
					clear.click();
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}
	public void btnHide() {
		btnHide.click();
	}
	public void clickBtnExpand() {
		// Wait for the overlay to disappear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		btnExpandDiv.click();
	}
	public void selectColumns(String column) {
		columns.click();
		switch (column) {
		case "Disable":
			//	employee.click();
			//	hour.click();
			//	shift.click();
			actCost.click();
			dayS1.click();
			nightS2.click();
			officeO.click();
			webUtility.moveToElement(driver, qcDay);
			qcDay.click();
			break;	
		}
	}
	public void clickBtnClose() {
		btnClose.click();
	}
	public void clickBtnReset() {
		btnReset.click();
	}
	public void performBtnFullScreen() {
		webUtility.moveToElement(driver, btnFullScreen);
		btnFullScreen.click();
	}
	public void doubleClickEmptyCell(WebElement emptyCell) {
		webUtility.doubleClickOnElement(driver, emptyCell);
	}
	public void rightClickEmptyCell(WebElement emptyCell) {
		webUtility.rightClickOnElement(driver, emptyCell);
	}
	public void selectCreateShift() {
		CreateShift.click();
	}
	public void selectShiftBandCode() throws InterruptedException {
		webUtility.ElementClickable(driver, txtShiftBand);
		webUtility.moveToElement(driver, txtShiftBand);
		txtShiftBand.click();
	}
	public void selectResultsShiftBand(){
		selectResultsShiftBand.click();
	}
	public void selectOnCallShift() throws InterruptedException {
		//		webUtility.ElementClickable(driver, onCallShift);
		Thread.sleep(3000);
		webUtility.moveToElement(driver, onCallShift);
		onCallShift.click();
	}
	public void selectRoleName() {
		webUtility.ElementClickable(driver, txtRoleName);
		webUtility.moveToElement(driver, txtRoleName);
		txtRoleName.click();
	}
	public void selectResultsRoleName() {
		selectResultsRoleName.click();
	}
	public void enterShiftNotes(String shiftNote) {
		txtShiftNotes.clear();
		txtShiftNotes.sendKeys(shiftNote);
	}
	public void clickBtnSelectShiftBand() {
		//		webUtility.moveToElement(driver, btnSelectShiftBand);
		btnSelectShiftBand.click();
	}
	public void getShiftCreatedSuccessfullyMsg() {
		String actualResult = shiftCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Shift created successfully"));
	}
	public void clickShiftCardForCopy() {
		// Right-click on cssShiftCard
		webUtility.rightClickOnElement(driver, cssShiftCard);

	}



	public void performActionsIfConditionsMet() {
		try {
			// Check if applyExcludeDeployment and applyTimeOff are displayed
			boolean isExcludeDeploymentVisible = applyExcludeDeployment.isDisplayed();
			boolean isTimeOffVisible = applyTimeOff.isDisplayed();

			// Skip the cell if both applyExcludeDeployment and applyTimeOff are present
			if (isExcludeDeploymentVisible && isTimeOffVisible) {
				System.out.println("Skipping the cell as applyExcludeDeployment and applyTimeOff are present.");
			} else {
				// Check if cssShiftCard is visible
				if (cssShiftCard.isDisplayed()) {
					// cssShiftCard is visible, right-click on it
					webUtility.rightClickOnElement(driver, cssShiftCard);
					// Continue with additional actions if needed
				} else {
					// Handle the case where cssShiftCard is not visible
					System.out.println("cssShiftCard is not visible.");
				}
			}
		} catch (NoSuchElementException e) {
			// Handle the case where applyExcludeDeployment, applyTimeOff, or cssShiftCard is not found in the DOM
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	public void performCopy() {
		copyOption.click();
	}
	public void performPaste() {
		pasteOption.click();
	}
	public void clickBtnYes() {
		btnYes.click();
	}
	public void rightClickOnCallIndicatorShift() {
		webUtility.rightClickOnElement(driver, callIndicatorShift);
	}
	public void mouseHoverOnCopySpecial() {
		webUtility.moveToElement(driver, copySpecial);
	}
	public void clickCopyWithOCRemarks() {
		copyWithOCRemarks.click();
	}
	public void performCopyPasteAndConfirmForOnCallShift() throws InterruptedException {
		if (isElementPresent(callIndicatorShift)) {
			Thread.sleep(2000);
			rightClickOnCallIndicatorShift();
			Thread.sleep(1000);
			mouseHoverOnCopySpecial();
			clickCopyWithOCRemarks();
			rightClickEmptyCell(emptyCell);
			performPaste();
			clickBtnYes();
		} else {
			System.out.println("callIndicatorShift is not present.");
		}
	}

	// Method to check if an element is present
	private boolean isElementPresent(WebElement element) {
		try {
			// Attempt to find the element
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Element not found
			return false;
		}
	}
	public void mouseHoverExportOption() {
		webUtility.moveToElement(driver, exportOption);
	}
	public void clickTextFileOption() {
		textFileOption.click();
	}
	public void clickExcelFileOption() {
		excelFileOption.click();
	}
	public void getDataExportedSuccessfullyMsg() {
		String actualResult = dataExportedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Data has been exported successfully"));
	}
	public void clickNotificationPopup() throws Exception {
		//		Thread.sleep(1000);
		webUtility.moveToElement(driver, notificationPopup);
		notificationPopup.click();
	}
	public void clickCollapseGroupOption() {
		webUtility.moveToElement(driver, CollapseGroupOption);
		CollapseGroupOption.click();
	}

	// Method to get the title of a page opened in a new tab
	private String getTitleOfNewTab(WebElement elementToRightClick, WebElement optionToClick) throws InterruptedException {
		actions.contextClick(elementToRightClick).perform();
		optionToClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Get handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();
		String originalWindowHandle = driver.getWindowHandle();
		// Find the handle of the new window
		String newWindowHandle = "";
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(originalWindowHandle)) {
				newWindowHandle = windowHandle;
				break;
			}
		}
		// Switch to the new window
		driver.switchTo().window(newWindowHandle);
		// Wait for the title to be non-empty
		wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
		Thread.sleep(10000);
		// Get the title of the new window
		String pageTitle = driver.getTitle();
		// Close the new window
		driver.close();
		// Switch back to the original window
		driver.switchTo().window(originalWindowHandle);
		return pageTitle;
	}
	public void mouseHoverApplyOnBehalfOption() {
		webUtility.moveToElement(driver, applyOnBehalfOption);
	}
	public void clickonapplyLeaveOption() {
		applyLeaveOption.click();
	}
	public void enterLeaveType() {
		webUtility.ElementClickable(driver, leaveType);
		leaveType.click();
	}
	public void chooseSickLeave() {
		selectSickLeave.click();
	}
	public void chooseEmergencyLeave() {
		selectEmergencyLeave.click();
	}
	public void enterLeaveStartDate(String LeaveStartDate) {
		webUtility.ElementClickable(driver, dtLeaveStartDate);
		dtLeaveStartDate.clear();
		dtLeaveStartDate.sendKeys(LeaveStartDate);
		dtLeaveStartDate.sendKeys(Keys.ENTER);
	}
	public void enterLeaveEndDate(String LeaveEndDate) {
		dtLeaveEndDate.clear();
		dtLeaveEndDate.sendKeys(LeaveEndDate);
		dtLeaveEndDate.sendKeys(Keys.ENTER);
	}
	public void enterLeaveReferenceNo(String LeaveReferenceNo) {
		txtLeaveReferenceNo.clear();
		txtLeaveReferenceNo.sendKeys(LeaveReferenceNo);
	}
	public void enterLeaveRemarks(String LeaveRemarks) {
		webUtility.moveToElement(driver, txtLeaveRemarks);
		txtLeaveRemarks.clear();
		txtLeaveRemarks.sendKeys(LeaveRemarks);
	}
	public void clickBtnNext() {
		//		webUtility.moveToElement(driver, txtLeaveRemarks);
		//		btnNext.click();
		webUtility.scrollAndClick(driver, btnNext);
	}
	public void clickonBtnPrevious() {
		btnPrevious.click();
	}
	public void tabShiftCount() {
		webUtility.scrollAndClick(driver, tabShiftCount);
		//		tabShiftCount.click();
	}
	public void tabLeaveCount() {
		tabLeaveCount.click();
	}
	public void tabRequiredResources() {
		tabRequiredResources.click();
	}
	public void tabShiftShortage() {
		tabShiftShortage.click();
	}
	public void clickApplyTimeOffOption() {
		applyTimeOffOption.click();
	}
	public void enterTimeOffDate(String timeOff) {
		dtTimeOffDate.clear();
		dtTimeOffDate.sendKeys(timeOff);
		dtTimeOffDate.sendKeys(Keys.ENTER);
	}
	public void selectTxtTimeOffPeriod() {
		txtTimeOffPeriod.click();
	}
	public void chooseShiftStart() {
		chooseShiftStart.click();
	}
	public void chooseShiftEnd() {
		chooseShiftEnd.click();
	}
	public void enterTimeOffRemarks(String remark) {
		txtTimeOffRemarks.clear();
		txtTimeOffRemarks.sendKeys(remark);
	}
	public void clickApplyTimeOff() {
		webUtility.moveToElement(driver, btnApplyTimeOff);
		btnApplyTimeOff.click();
	}
	public void getTimeOffRequestSubmittedSuccessfullyMsg(){
		String actualResult = timeOffRequestSubmittedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Time Off Request Submitted Successfully"));
	}
	public void clickApplyUncontrolledLeaveOption() {
		applyUncontrolledLeaveOption.click();
	}
	public void selectUCLExceptionType() {
		txtUCLExceptionType.click();
	}
	public void chooseUncontrolLeave() {
		chooseUncontrolLeave.click();
	}
	public void enterUCLReferenceNo(String referenceNo) {
		txtUCLReferenceNo.clear();
		txtUCLReferenceNo.sendKeys(referenceNo);
	}
	public void enterUCLRemarks(String UCLRemarks) {
		txtUCLRemarks.clear();
		txtUCLRemarks.sendKeys(UCLRemarks);
	}
	public void clickBtnApplyUCL() {
		//		btnApplyUCL.click();
		webUtility.scrollAndClick(driver, btnApplyUCL);
	}

	public void clickExcludeDeploymentOption() {
		excludeDeploymentOption.click();
	}
	public void clickEDExceptionType() {
		cmbEDExceptionType.click();
	}
	public void chooseExcludeDeployment() {
		chooseExcludeDeployment.click();
	}
	public void enterEDReferenceNo(String referenceNo) {
		txtEDReferenceNo.sendKeys(referenceNo);
	}
	public void enterEDRemarks(String EDRemark) {
		txtEDRemarks.sendKeys(EDRemark);
	}
	public void clickBtnApplyExcludeDeployment() {
		btnApplyExcludeDeployment.click();
	}
	public void getexcludeDeploymentExceptionCreatedSuccessfullyMsg() { 
		String actualResult = excludeDeploymentExceptionCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Exclude Deployment Exception Created Successfully"));
	}




	// Jira Item: E10-2938 - Employee Roster V2 [Search by date]
	public void searchEmpRosterByDate(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
	}
	// Jira Item: E10-2939 - Employee Roster V2 [Search by filters]
	public void searchByFilters() {
		clickBtnFilter();
		//		chooseRosterGroup();
		//		chooseRoleGroup();
		chooseShiftBand();
		clickFilterSeachBtn();
	}
	// Jira Item: E10-2940 - Employee Roster V2 [Expand and Collapse rows]
	public void expandAndCollapseRows(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
	}
	// Jira Item: E10-2941 - Employee Roster V2 [Filter and reset columns]
	public void filterAndResetColumns(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
	}
	// Jira Item: E10-2942 - Employee Roster V2 [Expand and minimize full screen]
	public void performFullScreen(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		performBtnFullScreen();
		Thread.sleep(1000);
		performBtnFullScreen();
	}
	// Jira Item: E10-2943 - Employee Roster V2 [Double click on tab or right click and select create shift]
	public void performClickEmptyCellCreateShift(FakeEmployee fakeEmployee) throws Exception {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		enterShiftNotes(fakeEmployee.getDescription());
		Thread.sleep(2000);
		clickBtnSelectShiftBand();
		getShiftCreatedSuccessfullyMsg();
		clickNotificationPopup();
	}

	// Jira Item: E10-2944 - Employee Roster V2 [Copy single Cell and paste in new Cell]
	public void CopySingleCellAndPasteInNewCell(FakeEmployee fakeEmployee) throws Exception {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		enterShiftNotes(fakeEmployee.getDescription());
		clickBtnSelectShiftBand();
		getShiftCreatedSuccessfullyMsg();
		clickNotificationPopup();
		clickShiftCardForCopy();
		performCopy();
		Thread.sleep(1000);
		rightClickEmptyCell(emptyCell);
		performPaste();
		clickBtnYes();
	}
	// Jira Item: E10-2944 - Employee Roster V2 [Copy single and multiple row/column and paste in new row]
	public void CopySingleRowColumnAndPasteInNewRow(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		// Get the text from the source row
		String sourceRowText = sourceRow.getText();
		Reporter.log("Source Row Text: " + sourceRowText, true);
		// Create a StringSelection object to store the text
		StringSelection stringSelection = new StringSelection(sourceRowText);
		// Set the clipboard content
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Thread.sleep(1000);

		// Use Actions class to select the destination row
		Actions actions = new Actions(driver);
		actions.moveToElement(destinationRow).click().build().perform();

		// Use Robot to simulate keyboard shortcuts for paste
		try {
			Robot robot = new Robot();
			// Simulate CTRL + V for paste
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			Reporter.log("Pasted Content: " + destinationRow.getText(), true);
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
		//		Assert.assertEquals(destinationRow.getText(), sourceRowText, "Paste operation failed");

	}

	// Jira Item: E10-2945 - Employee Roster V2 [Right click ->Copy with Oncall, Remark and OC & Remarks]
	public void CopyWithOncallShift(FakeEmployee fakeEmployee) throws Exception{
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		Thread.sleep(2000);
		selectOnCallShift();
		enterShiftNotes(fakeEmployee.getDescription());
		clickBtnSelectShiftBand();
		Thread.sleep(2000);
		performCopyPasteAndConfirmForOnCallShift();
		getShiftCreatedSuccessfullyMsg();
//		clickNotificationPopup();
	}

	// Jira Item: E10-2946 - Employee Roster V2 [Right Click -> Export to Text and Excel]
	public void ExportToTextAndExcel(FakeEmployee fakeEmployee) throws Exception {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		Thread.sleep(8000);
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		rightClickEmptyCell(emptyCell);
		mouseHoverExportOption();
		clickTextFileOption();
		getDataExportedSuccessfullyMsg();
		clickNotificationPopup();
	}
	// Jira Item: E10-2947 - Employee Roster V2 [Right click -> Collapse group]
	public void CollapseRowByGroup(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		rightClickEmptyCell(emptyCell);
		clickCollapseGroupOption();
	}


	// Jira Item: E10-2949 - Employee Roster V2 [Right click on Employee and click copy and paste in Excel sheet]
	public void testCopyAndPasteToExcel(FakeEmployee fakeEmployee) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		// Step 1: Create a list to store the data
		List<String> allData = new ArrayList<>();

		// Step 2: Loop through each element, copy its text, and add to the list
		for (WebElement element : columnEmployeeSearch) {
			// Click on the WebElement to select it (if necessary)
			element.click();

			// Copy the selected text to the clipboard 
			String selectedText = element.getText();
			copyToClipboard(selectedText);

			// Add the text to the list
			allData.add(selectedText);
		}

		// Step 3: Use ExcelUtilities to paste data into a new sheet in Excel
		String newSheetName = "Employee";  // Set the new sheet name
		try {
			excelUtilities.writeDataToExcel("ExistingSheet", allData, newSheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Step 4: Verify that pasted data matches the original copied data
		try {
			boolean isDataMatching = excelUtilities.verifyDataInSheet(newSheetName, allData);
			// Assert or log based on the result
			Assert.assertTrue(isDataMatching, "Data doesn't match. Expected: " + allData);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Exception occurred while verifying data in Excel sheet: " + e.getMessage());
		}
	}
	public void copyToClipboard(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	// Jira Item: E10-2950 - Employee Roster V2 [Right click -> Employee Profile] 
	public void clickonEmployeeProfile(FakeEmployee fakeEmploye) throws InterruptedException, IOException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		Thread.sleep(2000);
		// Get the title of the new tab
		String employeeProfileTitle = getTitleOfNewTab(rightClickEmployee, employeeProfileOption);
		System.out.println("Actual Title is-: "+ employeeProfileTitle);
		// Get the expected title from configuration
		String empProfileTitle = configUtility.getCongigPropertyData("empProfileTitle");
		assertEquals(employeeProfileTitle, empProfileTitle, "Employee Profile Titles do not match");
	}
	// Jira Item: E10-2951 - Employee Roster V2 [Right click -> Leave Profile]
	public void clickonLeaveProfile(FakeEmployee fakeEmploye) throws InterruptedException, IOException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		// Get the title of the new tab
		String leaveProfileTitle = getTitleOfNewTab(rightClickEmployee, leaveProfileOption);
		Reporter.log("Actual Title is-: "+ leaveProfileTitle, true);
		// Get the expected title from configuration
		String empLeaveProfileTitle = configUtility.getCongigPropertyData("empLeaveProfileTitle");
		assertEquals(leaveProfileTitle, empLeaveProfileTitle, "Leave Profile Titles do not match");
	}
	// Jira Item: E10-2952 - Employee Roster V2 [ Right click -> Approval Route]
	public void clickonApprovalRoute(FakeEmployee fakeEmploye) throws InterruptedException, IOException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		// Get the title of the new tab
		String approvalRouteTitle = getTitleOfNewTab(rightClickEmployee, approvalRouteOption);
		System.out.println("Actual Title is -: " + approvalRouteTitle);
		// Get the expected title from configuration
		String empApprovalRouteTitle = configUtility.getCongigPropertyData("empApprovalRouteTitle");
		assertEquals(approvalRouteTitle, empApprovalRouteTitle, "Approval Route Titles do not match");
	}
	// Jira Item: E10-2954 - Employee Roster V2 [ Click Different tab in Summary]
	public void clickDifferentTabinSummary(FakeEmployee fakeEmploye) throws InterruptedException {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		webUtility.scrollDown(driver);
		tabShiftCount();
		webUtility.scrollDown(driver);
		tabLeaveCount();
		tabRequiredResources();
		tabShiftShortage();
	}
	// Jira Item: E10-3006 - Employee Roster V2 [Search Filter By Shift Band]
	public void searchByFiltersShiftBand() {
		clickBtnFilter();
		chooseShiftBand();
		clickFilterSeachBtn();
	}

	//	Jira Item: E10-2948 - Employee Roster V2 [Right click -> apply leave]
	public void applyOnBehalfApplyLeave(FakeEmployee fakeEmployee) throws Exception {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		rightClickEmptyCell(emptyCell);
		mouseHoverApplyOnBehalfOption();
		Thread.sleep(2000);
		clickonapplyLeaveOption();
		Thread.sleep(2000);
		enterLeaveType();
		chooseEmergencyLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFrom());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveTo());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		webUtility.scrollDown(driver);
//		clickBtnNext();

		// Admin does not have the Approver 



	}
	// Jira Item: E10-3038 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Time off 
	public void ApplyTimeOff(FakeEmployee fakeEmployee) throws Exception  {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		enterShiftNotes(fakeEmployee.getDescription());
		clickBtnSelectShiftBand();
		getShiftCreatedSuccessfullyMsg();
		clickNotificationPopup();		

		clickShiftCardForCopy();
		mouseHoverApplyOnBehalfOption();

		
		clickApplyTimeOffOption();
		
//		enterTimeOffDate(fakeEmployee.getTmrwDate()); not required
		Thread.sleep(3000);
		selectTxtTimeOffPeriod();
		chooseShiftStart();
		enterTimeOffRemarks(fakeEmployee.getRemarksLeave());
		//	@FindBy(xpath = "(//button[@id='btnAddAttachment'])[2]")
		//	private WebElement btnAddAttachment; ....................Not working button 

		clickApplyTimeOff();
		getTimeOffRequestSubmittedSuccessfullyMsg();
		clickNotificationPopup();
	}

	//	Jira Item: E10-3039 - Employee Roster V2  [Right Click] [Apply On Behalf] Apply Uncontrolled Leave
	public void ApplyUncontrolledLeave(FakeEmployee fakeEmployee) throws Exception {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		enterShiftNotes(fakeEmployee.getDescription());
		Thread.sleep(1000);
		clickBtnSelectShiftBand();
		getShiftCreatedSuccessfullyMsg();
		clickNotificationPopup();

		clickShiftCardForCopy();
		mouseHoverApplyOnBehalfOption();

		clickApplyUncontrolledLeaveOption();
		selectUCLExceptionType();
		chooseUncontrolLeave();
		enterUCLReferenceNo(fakeEmployee.getReferenceNo());
		enterUCLRemarks(fakeEmployee.getRemarksLeave());
		clickBtnApplyUCL();

	}
	//	Jira Item: E10-3040 - Employee Roster V2 [Right Click] [Apply On Behalf] Apply Exclude Deployment
	public void applyExcludeDeployment(FakeEmployee fakeEmployee) throws Exception  {
		clickStartAndEndDate();
		enterStartDate(fakeEmployee.getRosterStartDate());
		enterEndDate(fakeEmployee.getRosterEndDate());
		clickApply();
		cmbRosterGroupBy();
		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
		selectColumns("Disable");
		clickBtnClose();
		doubleClickEmptyCell(emptyCell);
		selectRoleName();
		selectResultsRoleName();
		selectShiftBandCode();
		selectResultsShiftBand();
		enterShiftNotes(fakeEmployee.getDescription());
		Thread.sleep(2000);
		clickBtnSelectShiftBand();
		getShiftCreatedSuccessfullyMsg();
		clickNotificationPopup();
		Thread.sleep(2000);
		clickShiftCardForCopy();
		//		performActionsIfConditionsMet();
		mouseHoverApplyOnBehalfOption();

		clickExcludeDeploymentOption();
		clickEDExceptionType();
		chooseExcludeDeployment();
		enterEDReferenceNo(fakeEmployee.getReferenceNo());
		enterEDRemarks(fakeEmployee.getRemarksLeave());
		clickBtnApplyExcludeDeployment();
		clickBtnYes();
//		getexcludeDeploymentExceptionCreatedSuccessfullyMsg();
		clickNotificationPopup();
	}
}
