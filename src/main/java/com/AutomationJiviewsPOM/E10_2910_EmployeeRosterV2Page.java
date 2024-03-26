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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.FakeEmployee;
import com.AutomationJiviewsGeneric.ReusableComponent;
import com.AutomationJiviewsGeneric.WebUtilities;
import com.AutomationJiviewsGeneric.configUtility;

import io.netty.handler.timeout.TimeoutException;

public class E10_2910_EmployeeRosterV2Page 
{
	WebDriver driver ;
	ReusableComponent Rc ;
	public Actions actions;
	WebUtilities webUtility;
	ExcelUtilities excelUtilities ;

	
	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // Workforce Scheduling

	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[2]")
	WebElement ulApplicationMenu; // Roster Setup

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[2]/li")
	List<WebElement> sideNavMenu; // Schedule Creation Rules
	
	
	
	@FindBy(xpath = "//span[text()='Workforce Scheduling']/..")
	WebElement selectWorkforceScheduling;
	@FindBy(xpath = "//div[text()='Scheduling']/..")
	WebElement Scheduling;
	@FindBy(xpath = "//div[text()='Employee Roster V2']/..")
	WebElement EmployeeRosterV2;
	
	
	
	@FindBy(id = "dtStartAndEnd")
	WebElement dateStartAndEnd;
//	@FindBy(xpath = "//input[@class='input-mini form-control active']")
	@FindBy(xpath = "((//table[@class='table-condensed'])[1]/tbody/tr/td)[10]")
	WebElement selectStartDate;
//	@FindBy(xpath = "(//input[@name='daterangepicker_end'])[2]") or ((//table[@class='table-condensed'])[2]/tbody/tr/td)[29]
	@FindBy(xpath = "((//table[@class='table-condensed'])[1]/tbody/tr/td)[17]")
	WebElement selectEndDate;
	
	
	
	@FindBy(xpath = "//span[@id='select2-cmbRosterGroupBy-container']")
	WebElement cmbRosterGroupBy;
	@FindBy(xpath = "//ul[@id='select2-cmbRosterGroupBy-results']/li")
	WebElement selectRoleGroup;
	@FindBy(xpath = "(//button[text()='Apply'])[2]")
	WebElement clickApply;

	@FindBy(xpath = "//button[@id='btnSearchEmployeeRoster']")
	WebElement btnSearchEmployeeRoster;

	@FindBy(xpath = "//li[@id='btnFilterDiv']")
	WebElement btnFilterDiv;
	@FindBy(xpath = "//div[@id='filterEmployee']/div")
	WebElement filterEmployee;

	@FindBy(xpath = "//div[@id='filterRosterGroup']/div")
	WebElement filterRosterGroup;
	@FindBy(xpath = "//ul[@id='select2-cmbReportRosterGroup-results']/li")
	WebElement chooseRosterGroup;

	@FindBy(xpath = "//div[@id='filterRoleGroup']")
	WebElement filterRoleGroup;
	@FindBy(xpath = "//li[contains(text(),'RTGO Operator')]")
	WebElement chooseRoleGroup;

	@FindBy(xpath = "//div[@id='filterShiftBand']")
	WebElement filterShiftBand;
	@FindBy(xpath = "(//ul[@class='select2-results__options']/li)[2]")
	WebElement chooseShiftBand;

	@FindBy(xpath = "//ul/span[@class='select2-selection__clear']")
	List<WebElement> selectionClear;

	@FindBy(xpath = "//button[@id='filterSeachBtn']")
	WebElement filterSeachBtn;
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement btnHide;

	@FindBy(xpath = "//span[@id='btnExpandText']")
	WebElement btnExpandDiv;
	@FindBy(xpath = "//span[@id='btnExpandText']")
	WebElement btnExpandText;

	@FindBy(xpath = "(//div[@class='card-header-elements ml-auto']/div)[2]")
	WebElement columns;
	@FindBy(xpath = "//span[text()='EMPLOYEE']")
	WebElement employee;
	@FindBy(xpath = "//span[text()='HOUR']")
	WebElement hour;
	@FindBy(xpath = "//span[text()='ACT COST']")
	WebElement actCost;
	@FindBy(xpath = "//span[text()='SHIFT']")
	WebElement shift;
	@FindBy(xpath = "//span[text()='Day S1']")
	WebElement dayS1;
	@FindBy(xpath = "//span[text()='Night S2']")
	WebElement nightS2;
	@FindBy(xpath = "//span[text()='Office O']")
	WebElement officeO;
	@FindBy(xpath = "//span[text()='QCDAY']")
	WebElement qcDay;

	@FindBy(xpath = "//button[text()='Close']")
	WebElement btnClose;
	@FindBy(xpath = "//button[text()='Reset']")
	WebElement btnReset;

	@FindBy(xpath = "//span[@id='btnFullScreen']")
	WebElement btnFullScreen;

	@FindBy(xpath = "//div[text()='OFF']")
	WebElement emptyCell;
	@FindBy(xpath = "//span[text()='Create Shift']/..")
	WebElement CreateShift;
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	WebElement txtShiftBand;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement selectResultsShiftBand;

	@FindBy(xpath = "//span[text()=' On Call ']")
	WebElement onCallShift;

	@FindBy(xpath = "//span[@id='select2-cmbRoleName-container']")
	WebElement txtRoleName;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement selectResultsRoleName;

	@FindBy(xpath = "//textarea[@id='txtShiftNotes']")
	WebElement txtShiftNotes;
	@FindBy(xpath = "//button[@id='btnSelectShiftBand']") 
	WebElement btnSelectShiftBand;
	@FindBy(xpath = "//div[text()='Shift created successfully']")
	WebElement shiftCreatedSuccessfullyMsg;
	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//div[@class='cssShiftCard']") 
	WebElement cssShiftCard;
	@FindBy(xpath = "//div[text()='HE']")
	WebElement applyExcludeDeployment;
	@FindBy(xpath = "//div[text()='TI']")
	WebElement applyTimeOff;

	@FindBy(xpath = "//span[text()='Copy']")
	WebElement copyOption;

	@FindBy(xpath = "//span[text()='Paste']")
	WebElement pasteOption;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;

	@FindBy(xpath = "(//table[@class='tui-grid-table'])[5]/tbody/tr[2]")
	WebElement sourceRow;
	@FindBy(xpath = "(//table[@class='tui-grid-table'])[5]/tbody/tr[4]")
	WebElement destinationRow;

	@FindBy(xpath = "//div[@class='indicatorShift']")
	WebElement callIndicatorShift;
	@FindBy(xpath = "//span[text()='Copy Special']/..")
	WebElement copySpecial;
	@FindBy(xpath = "//span[text()='Copy with Both']/..")
	WebElement copyWithOCRemarks;


	@FindBy(xpath = "//span[text()='Export']/..")
	WebElement exportOption;
	@FindBy(xpath = "//span[text()='Text File']/..")
	WebElement textFileOption;
	@FindBy(xpath = "//span[text()='Excel File']/..")
	WebElement excelFileOption;

	@FindBy(xpath = "//div[text()='Data has been exported successfully ']")
	WebElement dataExportedSuccessfullyMsg; 
	@FindBy(xpath = "//span[text()='Collapse Group']")
	WebElement CollapseGroupOption;

	@FindBy(xpath = "//span[text()='Apply On Behalf']/..")
	WebElement applyOnBehalfOption;

	@FindBy(xpath = "//span[text()='Apply Leave']/..")
	WebElement applyLeaveOption;
	@FindBy(xpath = "//span[@id='select2-cmbExceptionType-container']")
	WebElement leaveType;
	@FindBy(xpath = "//li[text()='Sick Leave']")
	WebElement selectSickLeave;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	WebElement selectEmergencyLeave;

	// Get Title:
	@FindBy(xpath = "//td[@class='tui-grid-cell tui-grid-cell-has-input tui-grid-cell-disabled tui-grid-cell-has-tree ']")
	WebElement rightClickEmployee;
	@FindBy(xpath = "//span[text()='Employee Profile']/..")
	WebElement employeeProfileOption;
	@FindBy(xpath = "//span[text()='Leave Profile']/..")
	WebElement leaveProfileOption;
	@FindBy (xpath = "//span[text()='Approval Route']/..")
	WebElement approvalRouteOption;

	@FindBy(xpath = "//input[@id='dtLeaveStartDate']")
	WebElement dtLeaveStartDate;
	@FindBy(xpath = "//input[@id='dtLeaveEndDate']")
	WebElement dtLeaveEndDate;
	@FindBy(xpath = "//input[@id='txtLeaveReferenceNo']")
	WebElement txtLeaveReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtLeaveRemarks']")
	WebElement txtLeaveRemarks;
	@FindBy(xpath = "//button[text()='Next']")
	WebElement btnNext;
	@FindBy(xpath = "//button[text()='Previous']")
	WebElement btnPrevious;

	@FindBy(xpath = "//a[text()='Shift Count']")
	WebElement tabShiftCount;
	@FindBy(xpath = "//a[text()='Leave Count']")
	WebElement tabLeaveCount;
	@FindBy(xpath = "//a[text()='Required Resources']")
	WebElement tabRequiredResources;
	@FindBy(xpath = "//a[text()='Shift Shortage']")
	WebElement tabShiftShortage;

	@FindBy(xpath = "//td[@data-column-name='EmployeeSearch']")
	List<WebElement> columnEmployeeSearch;

	@FindBy(xpath = "//span[text()='Apply Time off']")
	WebElement applyTimeOffOption;
	@FindBy(xpath = "//input[@id='dtTimeOffDate']")
	WebElement dtTimeOffDate;

	@FindBy(xpath = "//span[@id='select2-cmbTimeOffPeriod-container']")
	WebElement txtTimeOffPeriod;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement chooseShiftStart;
	@FindBy(xpath = "//li[text()='Shift End']")
	WebElement chooseShiftEnd;
	@FindBy(xpath = "//textarea[@id='txtTimeOffRemarks']")
	WebElement txtTimeOffRemarks;

	//	@FindBy(xpath = "(//button[@id='btnAddAttachment'])[2]")
	//	WebElement btnAddAttachment; not working button 

	@FindBy(xpath = "//button[@id='btnApplyTimeOff']")
	WebElement btnApplyTimeOff;

	@FindBy(xpath = "//div[text()='Time Off Request Submitted Successfully']")
	WebElement timeOffRequestSubmittedSuccessfullyMsg;

	@FindBy(xpath = "//span[text()='Apply Uncontrolled Leave']")
	WebElement applyUncontrolledLeaveOption;
	@FindBy(xpath = "//span[@id='select2-cmbUCLExceptionType-container']")
	WebElement txtUCLExceptionType;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement chooseUncontrolLeave;
	@FindBy(xpath = "//input[@id='txtUCLReferenceNo']")
	WebElement txtUCLReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtUCLRemarks']")
	WebElement txtUCLRemarks;
	@FindBy(xpath = "//button[@id='btnApplyUCL']")
	WebElement btnApplyUCL;


	@FindBy(xpath = "//span[text()='Exclude Deployment']")
	WebElement excludeDeploymentOption;
	@FindBy(xpath = "//span[@id='select2-cmbEDExceptionType-container']")
	WebElement cmbEDExceptionType;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement chooseExcludeDeployment;
	@FindBy(xpath = "//input[@id='txtEDReferenceNo']")
	WebElement txtEDReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtEDRemarks']")
	WebElement txtEDRemarks;
	@FindBy(xpath = "//button[@id='btnApplyExcludeDeployment']")
	WebElement btnApplyExcludeDeployment;
	@FindBy(xpath = "//div[text()='Exclude Deployment Exception Created Successfully']")
	WebElement excludeDeploymentExceptionCreatedSuccessfullyMsg;



	public E10_2910_EmployeeRosterV2Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver; 
		this.Rc= new ReusableComponent(driver);
		
		this.webUtility= new WebUtilities(driver);
		this.excelUtilities= new ExcelUtilities();
		this.actions = new Actions(driver);
	}
	public void clickStartAndEndDate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dtStartAndEnd']")));
		Thread.sleep(5000);
		element.clear();
		Thread.sleep(5000);
		element.click();
	}
	public void enterStartDate(String startDate) {
//		selectStartDate.clear();
//		selectStartDate.sendKeys(startDate);
		selectStartDate.click();
//		selectStartDate.sendKeys(Keys.ENTER);
	}
	public void enterEndDate(String endDate) {
//		selectEndDate.clear();
		selectEndDate.click();
//		selectEndDate.sendKeys(endDate);
//		selectEndDate.sendKeys(Keys.ENTER);
	}
	public void clickApply() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Apply'])[2]")));
	    applyButton.click();
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		WebElement btnFilterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='btnFilterDiv']")));
		btnFilterElement.click();
	}
	public void enterEmployeeName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement btnFilterDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='filterEmployee']/div")));
		btnFilterDiv.click();
//				filterEmployee.click();
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
		try {
			// Wait for the overlay to disappear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
			// Scroll into view and click using JavaScript
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", btnExpandDiv);
			executor.executeScript("arguments[0].click();", btnExpandDiv);
		} catch (TimeoutException e) {
			System.out.println("Timeout waiting for the overlay to disappear or click operation. Check your conditions or adjust the wait duration.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	public void selectColumns(String column) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='navbar-showhidecolumns nav-item dropdown']")));
		dropdownElement.click();
		
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
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		    wait.until(ExpectedConditions.elementToBeClickable(emptyCell));
		webUtility.doubleClickOnElement(driver, emptyCell);
	}
	public void rightClickEmptyCell(WebElement emptyCell) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		    wait.until(ExpectedConditions.elementToBeClickable(emptyCell));
		    webUtility.rightClickOnElement(driver, emptyCell);
//		webUtility.rightClickOnElement(driver, emptyCell);
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
	boolean isElementPresent(WebElement element) {
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
//		webUtility.moveToElement(driver, CollapseGroupOption);
//		CollapseGroupOption.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blockUI blockOverlay")));
		wait.until(ExpectedConditions.elementToBeClickable(CollapseGroupOption));
		CollapseGroupOption.click();

	}
	String getTitleOfNewTab(WebElement elementToRightClick, WebElement optionToClick) throws InterruptedException {
		actions.contextClick(elementToRightClick).perform();
		optionToClick.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();
		String originalWindowHandle = driver.getWindowHandle();

		// Find the handle of the new window
		String newWindowHandle = windowHandles.stream()
				.filter(handle -> !handle.equals(originalWindowHandle))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("New window handle not found"));
		// Switch to the new window
		driver.switchTo().window(newWindowHandle);
		// Wait for the page title to be non-empty
		wait.until((ExpectedCondition<Boolean>) webDriver ->
		!webDriver.getTitle().isEmpty());
		Thread.sleep(8000);
		String pageTitle = driver.getTitle();
		driver.close();
		driver.switchTo().window(originalWindowHandle);
		return pageTitle;
	}

	String getTitleOfNewTabWithAlertPopup(WebElement elementToRightClick, WebElement optionToClick) throws InterruptedException {
		actions.contextClick(elementToRightClick).perform();
		optionToClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for the new window to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();
		String originalWindowHandle = driver.getWindowHandle();
		// Find the handle of the new window
		String newWindowHandle = windowHandles.stream()
				.filter(handle -> !handle.equals(originalWindowHandle))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("New window handle not found"));
		// Switch to the new window
		driver.switchTo().window(newWindowHandle);
		//	    // Check if an alert is present
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert text: " + alert.getText());
			alert.accept(); // Close the alert
		} catch (TimeoutException e) {
		}
		// Wait for the page title to be non-empty
		wait.until((ExpectedCondition<Boolean>) webDriver ->
		!webDriver.getTitle().isEmpty());
		Thread.sleep(8000);
		String pageTitle = driver.getTitle();
		driver.close();
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
	public void searchEmpRosterByDate() throws InterruptedException 
	{
        Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "Workforce Scheduling", "Workforce Scheduling is not clicked");
		
		Scheduling.isDisplayed();
		EmployeeRosterV2.click();
		
		Rc.explicitWait(dateStartAndEnd, "visible");
		dateStartAndEnd.clear();
		dateStartAndEnd.click();
		Rc.explicitWait(selectStartDate, "clickable");
		selectStartDate.click();
		selectEndDate.click();
		
		clickApply.click();
		
		
		Rc.explicitWait(cmbRosterGroupBy, "clickable");
		cmbRosterGroupBy.click();
		selectRoleGroup.click();
		
		btnSearchEmployeeRoster.click();
		
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
	}
	public void searchByFilters() throws InterruptedException 
	{
		Rc.explicitWait(btnFilterDiv, "clickable");
		btnFilterDiv.click();
		Rc.explicitWait(filterShiftBand, "clickable");
		filterShiftBand.click();
		chooseShiftBand.click();
		
		filterSeachBtn.click();
		
//		Thread.sleep(2000);
//		clickBtnFilter();
//		chooseShiftBand();
//		clickFilterSeachBtn();
	}
	public void expandAndCollapseRows() throws InterruptedException 
	{
		
		btnExpandDiv.click();
		
//		clickBtnExpand();
	}
	
	public void filterAndResetColumns() throws InterruptedException 
	{
		
		columns.click();
		actCost.click();
		dayS1.click();
		nightS2.click();
		officeO.click();
		Rc.moveToElement(qcDay);
		qcDay.click();
		
		Rc.explicitWait(btnClose, "clickable");
		btnClose.click();
//		selectColumns("Disable");
//		clickBtnClose();
	}
	public void performFullScreen() throws InterruptedException 
	{
		Rc.moveToElement(btnFullScreen);
		btnFullScreen.click();
		
		Rc.explicitWait(btnFullScreen, "clickable");
		Rc.moveToElement(btnFullScreen);
		btnFullScreen.click();
		
//		performBtnFullScreen();
//		Thread.sleep(1000);
//		performBtnFullScreen();
	}
	public void performClickEmptyCellCreateShift(FakeEmployee fakeEmployee) throws Exception 
	{
		emptyCell.click();
		
		
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
		//		selectColumns("Disable");
		//		clickBtnClose();
//		doubleClickEmptyCell(emptyCell);
//		selectRoleName();
//		selectResultsRoleName();
//		selectShiftBandCode();
//		selectResultsShiftBand();
//		enterShiftNotes(fakeEmployee.getDescription());
//		clickBtnSelectShiftBand();
//		getShiftCreatedSuccessfullyMsg();
//		clickNotificationPopup();
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		Thread.sleep(8000);
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		rightClickEmptyCell(emptyCell);
		mouseHoverExportOption();
		clickTextFileOption();
		getDataExportedSuccessfullyMsg();
		clickNotificationPopup();
	}
	// Jira Item: E10-2947 - Employee Roster V2 [Right click -> Collapse group]
	public void CollapseRowByGroup(FakeEmployee fakeEmployee) throws InterruptedException {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		rightClickEmptyCell(emptyCell);
		clickCollapseGroupOption();
	}


	// Jira Item: E10-2949 - Employee Roster V2 [Right click on Employee and click copy and paste in Excel sheet]
	public void testCopyAndPasteToExcel(FakeEmployee fakeEmployee) throws InterruptedException {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
		
		clickBtnExpand();
		// Step 1: Create a list to store the data
		List<String> allData = new ArrayList<>();

		// Step 2: Loop through each element, copy its text, and add to the list
		for (WebElement element : columnEmployeeSearch) {
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		Thread.sleep(2000);
		// Get the title of the new tab
		String employeeProfileTitle = getTitleOfNewTabWithAlertPopup(rightClickEmployee, employeeProfileOption);
		System.out.println("Actual Title is-: "+ employeeProfileTitle);
		// Get the expected title from configuration
		String empProfileTitle = configUtility.getCongigPropertyData("empProfileTitle");
		assertEquals(employeeProfileTitle, empProfileTitle, "Employee Profile Titles do not match");
	}
	// Jira Item: E10-2951 - Employee Roster V2 [Right click -> Leave Profile]
	public void clickonLeaveProfile(FakeEmployee fakeEmploye) throws InterruptedException, IOException {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		Thread.sleep(2000);
		// Get the title of the new tab
		String leaveProfileTitle = getTitleOfNewTab(rightClickEmployee, leaveProfileOption);
		Reporter.log("Actual Title is-: "+ leaveProfileTitle, true);
		// Get the expected title from configuration
		String empLeaveProfileTitle = configUtility.getCongigPropertyData("empLeaveProfileTitle");
		assertEquals(leaveProfileTitle, empLeaveProfileTitle, "Leave Profile Titles do not match");
	}
	// Jira Item: E10-2952 - Employee Roster V2 [ Right click -> Approval Route]
	public void clickonApprovalRoute(FakeEmployee fakeEmploye) throws InterruptedException, IOException {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		Thread.sleep(2000);
		// Get the title of the new tab
		String approvalRouteTitle = getTitleOfNewTab(rightClickEmployee, approvalRouteOption);
		System.out.println("Actual Title is -: " + approvalRouteTitle);
		// Get the expected title from configuration
		String empApprovalRouteTitle = configUtility.getCongigPropertyData("empApprovalRouteTitle");
		assertEquals(approvalRouteTitle, empApprovalRouteTitle, "Approval Route Titles do not match");
	}
	// Jira Item: E10-2954 - Employee Roster V2 [ Click Different tab in Summary]
	public void clickDifferentTabinSummary(FakeEmployee fakeEmploye) throws InterruptedException {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
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
		mouseHoverApplyOnBehalfOption();


		clickApplyTimeOffOption();

		//		enterTimeOffDate(fakeEmployee.getTmrwDate()); not required
		Thread.sleep(3000);
		selectTxtTimeOffPeriod();
		chooseShiftStart();
		enterTimeOffRemarks(fakeEmployee.getRemarksLeave());
		//	@FindBy(xpath = "(//button[@id='btnAddAttachment'])[2]")
		//	WebElement btnAddAttachment; ....................Not working button 
		Thread.sleep(3000);
		clickApplyTimeOff();
		getTimeOffRequestSubmittedSuccessfullyMsg();
		clickNotificationPopup();
	}

	//	Jira Item: E10-3039 - Employee Roster V2  [Right Click] [Apply On Behalf] Apply Uncontrolled Leave
	public void ApplyUncontrolledLeave(FakeEmployee fakeEmployee) throws Exception {
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
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
//		clickStartAndEndDate();
//		enterStartDate(fakeEmployee.getRosterStartDate());
//		enterEndDate(fakeEmployee.getRosterEndDate());
//		clickApply();
//		cmbRosterGroupBy();
//		clickbtnSearchEmployeeRoster();
//		clickBtnExpand();
//		selectColumns("Disable");
//		clickBtnClose();
		
		
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
