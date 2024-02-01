package com.AutomationJiviewsPOM;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;
import com.AutomationJiviewsGeneric.configUtility;

public class E10_3216_ESSApplyLeavePage extends BaseClass{

	private HomePage homePage;
	private LoginPage loginPage;
	private OrganizationUnitDropDown orgUnit;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeKioskPage empKiosk;
	public Actions action;
	public Select select;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li[2]")
	private WebElement click_OLM;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/ApplyLeave']/a/div") 
	private WebElement applyLeave;

	@FindBy(xpath = "//span[@id='select2-cmbExceptionType-container']")
	private WebElement leaveType;
	@FindBy(xpath = "//li[text()='Annual Leave']")
	private WebElement selectAnnualLeave;
	@FindBy(xpath = "//li[text()='Sick Leave L']")
	private WebElement selectSickLeave;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	private WebElement selectEmergencyLeave;
	@FindBy(xpath = "//li[text()='Hospitalization leave']")
	private WebElement selectHospitalizationLeave;
	@FindBy(xpath = "//li[text()='Marriage leave']")
	private WebElement selectMarriageLeave;
	@FindBy(xpath = "//li[text()='Paternity leave']")
	private WebElement selectPaternityLeave;
	@FindBy(xpath = "//li[text()='Maternity leave']")
	private WebElement selectMaternityLeave;




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
	@FindBy(xpath = "//button[@id='btnAddAttachment']")
	private WebElement btnAddAttachment;
	@FindBy(xpath = "(//button[@id='btnAddAttachment'])[2]")
	private WebElement btnAddAttachmentBehalf;

	@FindBy(xpath = "(//input[@id='fileToUpload'])[2]") 
	private WebElement btnFileToUpload;
	@FindBy(xpath = "//button[text()='Upload']")
	private WebElement btnUpload;
	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement btnFinish;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/Calendar']/a")
	private WebElement viewCalender;
	@FindBy(xpath = "//h5[@id=\"screenHeader\"]/text()")
	private WebElement titleCalender;


	@FindBy(xpath = "//li[@data-menu-link='SelfService/MyLeaveProfile']/a")
	private WebElement MyLeaveProfile;
	@FindBy(xpath = "//li[@data-menu-link='SelfService/LeaveRecords']/a")
	private WebElement LeaveRecords;
	@FindBy(xpath = "//li[@data-menu-link='SelfService/ApplyLeave/ApplyTimeOffIndex']/a")
	private WebElement ApplyTimeOffIndex;
	@FindBy(xpath = "//li[@data-menu-link='Approvers/ApplyOnBehalf']/a")
	private WebElement ApplyOnBehalf;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/Transactions/PendingTransactionsIndex']/a")
	private WebElement approveLeave;
	@FindBy(xpath = "//input[@id='dtStartAndEnd']")
	private WebElement dtStartAndEnd;
	@FindBy(xpath = "//span[@id='select2-cmbLeaveType-container']")
	private WebElement cmbLeaveType;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	private WebElement emergencyLeave;
	@FindBy(xpath = "//button[@id='btnSearchLeaveList']")
	private WebElement btnSearchLeaveList;

	@FindBy(xpath = "//table[@id='pending-leave-transactions-list']/tbody/tr") 
	private List<WebElement> pendingForApprovalRows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//button[@id='btnApproveAllLeave']")
	private WebElement btnApproveAllLeave;
	@FindBy(xpath = "//textarea[@id='txtApproveRejectAllRemarks']")
	private WebElement txtApproveRejectAllRemarks;
	@FindBy(xpath = "//button[@id='btnSaveRemarks']")
	private WebElement btnSaveRemarks;
	@FindBy(xpath = "//button[@id='btnRejectAllLeave']")
	private WebElement btnRejectAllLeave;


	@FindBy(xpath = "//table[@id='pending-leave-cancel-list']/tbody/tr") 
	private List<WebElement> pendingCancelApprovalRows;
	@FindBy(xpath = "//button[@id='btnApproveAllCancelLeave']")
	private WebElement btnApproveAllCancelLeave;


	@FindBy(xpath = "//li[@data-menu-link='Transactions/CancelApprovedLeaves']")
	private WebElement cancelApprovedLeaves;
	@FindBy(xpath = "//span[@id='select2-cmbCancelLeaveEmpNumber-container']")
	private WebElement cmbCancelLeaveEmpNumber;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchFiled;

	@FindBy(xpath = "//button[@id='btnSearchLeaveApplications']")
	private WebElement btnSearchLeaveApplications;

	//	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel'])[1]")
	//	private WebElement btnCancleLeave;

	@FindBy(xpath = "//table[@id='emp-leave-records-list']/tbody/tr")
	private List<WebElement> leaveRecordsRows;
	@FindBy(xpath = "//table[@id='emp-leave-records-list']/tbody/tr/td//button[@data-original-title='Cancel']")
	private List<WebElement> btnLeaveRecordsCancel;
	@FindBy(xpath = "//li[@id='emp-leave-records-list_next']")
	private WebElement btnNextPage;

	@FindBy(xpath = "//select[@name='emp-leave-records-list_length']")
	private WebElement leaveRecordList;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel']" )
	private WebElement btnCancle;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	//	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel']")
	//	private WebElement btnCancle;





	@FindBy(xpath = "//input[@id='dtTimeOffDate']")
	private WebElement dtTimeOffDate;
	@FindBy(xpath = "//span[@id='select2-cmbTimeOffPeriod-container']")
	private WebElement cmbTimeOffPeriod;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectTimePeriod;
	@FindBy(xpath = "//label[@class='form-check form-check-inline']")
	private WebElement checkBox;
	@FindBy(xpath = "//textarea[@id='txtTimeOffRemarks']" )
	private WebElement txtTimeOffRemarks;
	//	@FindBy(xpath = "//button[@id='btnAddAttachment']")
	//	private WebElement btnAddAttachment;
	@FindBy(xpath = "//button[@id='btnApplyTimeOff']")
	private WebElement btnApplyTimeOff;

	@FindBy(xpath = "//input[@id='txtSearchEmployee']")
	private WebElement txtSearchEmployee;
	@FindBy(xpath = "//button[@id='btnSearchEmployee']")
	private WebElement btnSearchEmployee;

	@FindBy(xpath = "//button[@data-original-title='Apply Leave']")
	private WebElement ApplyLeaveOnBehalf;
	@FindBy(xpath = "//button[@data-original-title='Apply Time Off']")
	private WebElement ApplyTimeOffOnBehalf;

	@FindBy(xpath = "//button[@data-original-title='Apply for Uncontrolled Leave']")
	private WebElement ApplyforUncontrolledLeave;
	@FindBy(xpath = "//span[@id='select2-cmbUCLExceptionType-container']")
	private WebElement UCLExceptionType;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchLeaveType;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement chooseLeaveType;
	@FindBy(xpath = "//input[@id='dtUCLDate']")
	private WebElement dtUCLDate;
	@FindBy(xpath = "//input[@id='txtUCLReferenceNo']")
	private WebElement txtUCLReferenceNo;
	@FindBy(xpath = "//textarea[@id='txtUCLRemarks']")
	private WebElement txtUCLRemarks;
	@FindBy(xpath = "//button[@id='btnApplyUCL']")
	private WebElement btnApplyUCL;

	@FindBy(xpath = "//span[@id='select2-cmbPanelClinicName-container']")
	private WebElement PanelClinicName;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement selectPanelClinicName;


	@FindBy(xpath = "//div[text()='Leave Application Submitted Successfully']")  
	private WebElement LeaveApplicationSubmittedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Leave Cancelled Successfully']")
	private WebElement LeaveCancelledSuccessfullyMsg;


	@FindBy(xpath =  "//li[@data-menu-link='SelfService/UncontrolledLeave/UncontrolledLeaveIndex']")
	private WebElement UncontrolledLeave;
	@FindBy(xpath = "//span[@id='select2-cmbUCLExceptionType-container']")
	private WebElement cmbUCLExceptionType;
	@FindBy(xpath = "//li[@role='treeitem']")
	private WebElement chooseLeaveTypeUCL;
	@FindBy(xpath = "//div[text()='UnControlled Leave Application Submitted Successfuly']")
	private WebElement UnControlledLeaveApplicationSubmittedSuccessfulyMsg;
	// Not Required 
	//	@FindBy(xpath = "//button[@id='btnApplyUCL']")
	//	private WebElement btnApplyUCL;
	//	@FindBy(xpath = "//input[@id='dtUCLDate']")
	//	private WebElement dtUCLDate;
	//	@FindBy(xpath = "//input[@id='txtUCLReferenceNo']")
	//	private WebElement txtUCLReferenceNo;
	//	@FindBy(xpath = "//textarea[@id='txtUCLRemarks']")
	//	private WebElement txtUCLRemarks;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/UncontrolledLeave/UploadUCLDocumentIndex']")
	private WebElement UploadUCLDocumentIndex;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1 view']")
	private WebElement btnUCLview;
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement btnSave;
	// Not Required 
	//	@FindBy(xpath = "//button[@id='btnAddAttachment']")
	//	private WebElement btnAddAttachment;
	//	@FindBy(xpath = "(//input[@id='fileToUpload'])[2]") 
	//	private WebElement btnFileToUpload;
	//	@FindBy(xpath = "//button[text()='Upload']")
	//	private WebElement btnUpload;
	@FindBy(xpath = "//li[@data-menu-link='SelfService/UncontrolledLeave/ManageUCLDocumentIndex']")
	private WebElement ManageUCLDocumentIndex;
	@FindBy(xpath = "//input[@id='dtStartEnd']")
	private WebElement dtStartEnd;
	@FindBy(xpath = "//input[@name='daterangepicker_start']")
	private WebElement dateRangePicker_Start;
	@FindBy(xpath = "//input[@name='daterangepicker_end']")
	private WebElement dateRangePicker_End;
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement btnApply;

	@FindBy(xpath = "//span[@id='select2-cmbEmployeeList-container']")
	private WebElement employeeNumber;
	@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	private WebElement searchEmployee;
	@FindBy(xpath = "//button[@id='btnSearchLeaveList']")
	private WebElement btnSearchLeaveListUCL;


	@FindBy(xpath = "//li[@data-menu-link='SelfService/RescheduleMessage']")
	private WebElement RescheduleLeave;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1 view']")
	private WebElement RescheduleLeaveView;
	@FindBy(xpath = "//button[@id='btnEditRescheduleLeave']")
	private WebElement btnEditRescheduleLeave;


	@FindBy(xpath = "//div[text()='MC,HP,UML,UNREC only can be applied on Public Holiday']")
	private WebElement publicHolidayCannotBeApplyMsg;
	@FindBy(xpath = "//div[text()='You have applied more leave than entitled leave']")
	private WebElement YouHaveAppliedMoreLeaveThanEntitledLeaveMsg;
	@FindBy(xpath = "//div[text()='Leave To has no Shift for you to apply leave,']")
	private WebElement LeaveToHasNoShiftForYouToApplyLeaveMsg;


	@FindBy(xpath = "//div[text()='Employee Setup']/..")
	private WebElement empSetup;
	@FindBy(xpath = "//div[text()='ESS Workflow Setup']/..")
	private WebElement essWorkflowSetup;
	@FindBy(xpath = "//div[text()='Approval Routing Definition']/..")
	private WebElement approvalRoutingDefinition;

	//	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1'])[7]")
	//	private WebElement editBtn;
	//	@FindBy(xpath = "//div[text()='ESS Workflow Setup']/..")
	//	private WebElement ESSWorkflowSetup;
	//	@FindBy(xpath = "//div[text()='Approval Routing Definition']/..")
	//	private WebElement ApprovalRoutingDefinition;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchBar;
	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement editBtnRoute;
	@FindBy(xpath = "//span[text()='Any One To Approve']")
	private WebElement checkBoxAnyOneToApprove;
	@FindBy(xpath = "(//span[text()='×'])[2]")
	private WebElement removeApprover;
	@FindBy(xpath = "//button[@id='btnSaveWorkflowRouteDeatils']")
	private WebElement btnSaveWorkflowRouteDeatils;
	@FindBy(xpath = "//div[text()='Route updated successfully']")
	private WebElement RouteUpdatedSuccessfullyMsg;

	@FindBy(xpath = "//button[@id='btnAddLevel']")
	private WebElement btnAddLevel;
	@FindBy(xpath = "//span[@id='select2-cmbLevel2Approver1-container']")
	private WebElement Level2Approver1;


	public E10_3216_ESSApplyLeavePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.homePage=  new HomePage(driver);
		this.loginPage = new LoginPage(driver);
		this.orgUnit = new OrganizationUnitDropDown(driver);
		this.jmMenuItem= new jiviewsMainMenuItems(driver);
		this.empKiosk = new EmployeeKioskPage(driver);
		this.action= new Actions(driver);
	}
	public void clickApplyLeave() {
		webUtility.ElementClickable(driver, applyLeave);
		applyLeave.click();
	}
	public void enterLeaveType() {
		webUtility.ElementClickable(driver, leaveType);
		leaveType.click();
	}
	public void chooseAnnualLeave(){
		selectAnnualLeave.click();
	}
	public void chooseSickLeave() {
		selectSickLeave.click();
	}
	public void chooseEmergencyLeave() {
		selectEmergencyLeave.click();
	}
	public void chooseHospitalizationLeave() {
		selectHospitalizationLeave.click();
	}
	public void chooseMarriageLeave() {
		selectMarriageLeave.click();
	}
	public void choosePaternityLeave() {
		selectPaternityLeave.click();
	}
	public void chooseMaternityLeave() {
		selectMaternityLeave.click();
	}
	public void enterLeaveStartDate(String startDate) {
		dtLeaveStartDate.clear();
		dtLeaveStartDate.sendKeys(startDate);
		dtLeaveStartDate.sendKeys(Keys.ENTER);
	}
	public void enterLeaveEndDate(String endDate) throws InterruptedException {
		dtLeaveEndDate.clear();

		dtLeaveEndDate.sendKeys(endDate);
		//		dtLeaveEndDate.sendKeys(Keys.ENTER);
	}
	public void enterLeaveReferenceNo(String referenceNo) {
		txtLeaveReferenceNo.clear();
		txtLeaveReferenceNo.sendKeys(referenceNo);
	}
	public void enterLeaveRemarks(String remark) {
		txtLeaveRemarks.clear();
		txtLeaveRemarks.sendKeys(remark);
	}
	public void pressBtnNext() {
		webUtility.ElementClickable(driver, btnNext);
		btnNext.click();
	}
	public void clickBtnAddAttachment() {
		webUtility.ElementClickable(driver, btnAddAttachment);
		btnAddAttachment.click();
	}
	public void clickbtnAddAttachmentBehalf() {
		webUtility.ElementClickable(driver, btnAddAttachmentBehalf);
		btnAddAttachmentBehalf.click();
	}
	public void selectFileToUpload() {
		File file= new File(".\\src\\test\\resources\\TestData\\Jiviews Team.jpg");
		String  absolutePath = file.getAbsolutePath();
		btnFileToUpload.sendKeys(absolutePath);
	}
	public void clickBtnUpload() {
		btnUpload.click();
	}
	public void clickBtnFinish() {
		webUtility.ElementClickable(driver, btnFinish);
		btnFinish.click();
	}


	public void clickViewCalender() {
		viewCalender.click();
	}
	public void clickMyLeaveProfile() {
		MyLeaveProfile.click();
	}
	public void clickLeaveRecords() {
		LeaveRecords.click();
	}
	public void clickApproveLeave() {
		webUtility.ElementClickable(driver, approveLeave);
		approveLeave.click();
	}
	public void clickStartAndEnd() {
		dtStartAndEnd.click();
	}
	public void clickLeaveType() {
		webUtility.ElementClickable(driver, cmbLeaveType);
		cmbLeaveType.click();
	}
	public void selectEmergencyLeave() {
		emergencyLeave.click();
	}
	public void clickBtnSearchLeaveList() {
		btnSearchLeaveList.click();
	}

	public void clickBtnApproveAllLeave() {
		btnApproveAllLeave.click();
	}

	public void clickCancelApprovedLeaves() {
		cancelApprovedLeaves.click();
	}
	public void clickCancelLeaveEmpNumber() {
		//		webUtility.ElementClickable(driver, cmbCancelLeaveEmpNumber);
		//		cmbCancelLeaveEmpNumber.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait until the button is clickable
		WebElement cancleLeave = wait.until(ExpectedConditions.elementToBeClickable(cmbCancelLeaveEmpNumber));

		// Click the button
		cancleLeave.click();
	}
	public void enterSearchFiled(String empId) {
		searchFiled.clear();
		searchFiled.sendKeys(empId);
		searchFiled.sendKeys(Keys.ENTER);
	}
	public void clickBtnSearchLeaveApplications() {
		btnSearchLeaveApplications.click();
	}
	public void performCancelAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnLeaveRecordsCancel.get(0)); // Assuming you want to click the first cancel button
				break;
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void cancelLeaveRecordWithEnabledBtn() throws InterruptedException {
		boolean leaveRecordFound = false;
		// Check if there are any leave records
		if (!leaveRecordsRows.isEmpty() && !btnLeaveRecordsCancel.isEmpty()) {
			// Iterate through rows
			for (int i = 0; i < leaveRecordsRows.size(); i++) {
				// Check if the current index is within the bounds of the list
				if (i < btnLeaveRecordsCancel.size()) {
					WebElement leaveRecord = btnLeaveRecordsCancel.get(i);
					if (leaveRecord.isDisplayed()) {
						leaveRecord.click();
						leaveRecordFound = true;
						break;
					}
				}
			}
		}

		// If no enabled cancel button found on the current page, go to the next page and try again
		if (!leaveRecordFound) {
			boolean nextPageAvailable = goToNextPage();

			if (nextPageAvailable) {
				cancelLeaveRecordWithEnabledBtn(); // Recursive call to check for cancel buttons on the next page
			}
		}


	}
	private boolean goToNextPage() throws InterruptedException {
		try {
			// Check if the "Next Page" button is displayed
			if (isElementVisible(btnNextPage)) {
				scrollAndClick(driver, btnNextPage); // Click on the next page button
				//				scrollUp(driver);
				return true; // Return true indicating that the next page is available
			}
		} catch (ElementNotInteractableException e) {
			// Handle the exception if necessary
		}
		return false;
	}

	// Additional method to check if an element is visible
	private boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	// Method to perform scroll-up action
	private void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");

	}
	public void clickBtnYes() {
		//		webUtility.moveToElement(driver, btnYes);
		btnYes.click();
	}
	public void clickNotificationPopup() throws Exception {
		webUtility.ElementClickable(driver, notificationPopup);
		notificationPopup.click();
	}
	public void getLeaveCancelledSuccessfullyMsg() {
		String actualResult =LeaveCancelledSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Leave Cancelled Successfully"));
	}
	public void performPendingApprovalAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnApproveAllLeave);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void pendingForApprovalRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		for (int i = 0; i < pendingForApprovalRows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
				checkbox.click();
				performPendingApprovalAction();
				checkboxFound = true;
				break;
			}
		}
	}
	public void scrollAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		element.click();
	}
	public void enterTxtApproveRejectAllRemarks(String remark) {
		txtApproveRejectAllRemarks.clear();
		txtApproveRejectAllRemarks.sendKeys(remark);
	}
	public void clickBtnSaveRemarks() {
		btnSaveRemarks.click();
	}
	public void clickBtnRejectAllLeave() {
		btnRejectAllLeave.click();
	}
	public void performRejectLeaveAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnRejectAllLeave);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void rejectLeaveRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		for (int i = 0; i < pendingForApprovalRows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
				checkbox.click();
				performRejectLeaveAction();
				checkboxFound = true;
				break;
			}
		}
	}
	public void performPendingCancelApprovalAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnApproveAllCancelLeave);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void pendingCancelApprovalRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		for (int i = 0; i < pendingCancelApprovalRows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
				checkbox.click();
				performPendingCancelApprovalAction();
				checkboxFound = true;
				break;
			}
		}
	}

	public void clickOn_OLM() {
		webUtility.ElementClickable(driver, click_OLM);
		click_OLM.click();
	}
	public void clickApplyTimeOffIndex() {
		ApplyTimeOffIndex.click();
	}
	public void enterTimeOffDate(String timeOff) {
		dtTimeOffDate.clear();
		dtTimeOffDate.sendKeys(timeOff);
		dtTimeOffDate.sendKeys(Keys.ENTER);
	}
	public void clickCmbTimeOffPeriod() {
		cmbTimeOffPeriod.click();
	}
	public void selectTimePeriod() {
		selectTimePeriod.click();
	}
	public void selectCheckBox() {
		checkBox.click();
	}
	public void enterTimeOffRemarks(String remarks) {
		txtTimeOffRemarks.clear();
		txtTimeOffRemarks.sendKeys(remarks);
	}
	public void clickApplyTimeOff() {
		btnApplyTimeOff.click();
	}
	public void clickApplyOnBehalf() {
		ApplyOnBehalf.click();
	}
	public void enterSearchEmployee() {
		webUtility.ElementClickable(driver, txtSearchEmployee);
		txtSearchEmployee.clear();
		txtSearchEmployee.sendKeys("33128455");
		//		txtSearchEmployee.sendKeys(Keys.ENTER);	
	}
	public void clickSearchEmployee() {
		webUtility.moveToElement(driver, btnSearchEmployee);
		btnSearchEmployee.click();
	}
	public void clickApplyLeaveOnBehalf() {

		ApplyLeaveOnBehalf.click();
	}
	public void clickApplyTimeOffOnBehalf() {
		ApplyTimeOffOnBehalf.click();
	}

	public void clickApplyforUncontrolledLeave() {
		ApplyforUncontrolledLeave.click();
	}
	public void clickSearchLeaveType() {
		searchLeaveType.click();
	}
	public void clickchooseLeaveType() {
		chooseLeaveType.click();
	}
	public void clickUCLDate(String UCLDate) {
		dtUCLDate.clear();
		dtUCLDate.sendKeys(UCLDate);
		dtUCLDate.sendKeys(Keys.ENTER);
	}
	public void entertxtUCLReferenceNo(String referenceNo) {
		txtUCLReferenceNo.clear();
		txtUCLReferenceNo.sendKeys(referenceNo);
	}
	public void entertxtUCLRemarks(String remark) {
		txtUCLRemarks.clear();
		txtUCLRemarks.sendKeys(remark);
	}
	public void clickBtnApplyUCL() {
		btnApplyUCL.click();
	}
	public void selectPanelClinicName() {
		PanelClinicName.click();
	}
	public void choosePanelClinicName() {
		selectPanelClinicName.click();
	}

	public void getLeaveApplicationSubmittedSuccessfullyMsg() {
		//		String actualResult =LeaveApplicationSubmittedSuccessfullyMsg.getText();
		//		Assert.assertTrue(actualResult.contains("Leave Application Submitted Successfully"));
		//	    int maxWaitSeconds = 10;
		WebElement leaveApplicationMsg = new WebDriverWait(driver, Duration.ofSeconds(120))
				.until(ExpectedConditions.visibilityOf(LeaveApplicationSubmittedSuccessfullyMsg));
		// Get the text after the element is present
		String actualResult = leaveApplicationMsg.getText();
		// Assert the text contains the expected message
		Assert.assertTrue(actualResult.contains("Leave Application Submitted Successfully"));

	}

	public void clickUncontrolledLeave() {
		webUtility.ElementClickable(driver, UncontrolledLeave);
		UncontrolledLeave.click();
	}
	public void clickUCLExceptionType() {
		webUtility.ElementClickable(driver, cmbUCLExceptionType);
		cmbUCLExceptionType.click();
	}
	public void chooseLeaveTypeUCL() {
		chooseLeaveTypeUCL.click();
	}
	public void getUnControlledLeaveApplicationSubmittedSuccessfulyMsg() { 
		String actualResult =UnControlledLeaveApplicationSubmittedSuccessfulyMsg.getText();
		Assert.assertTrue(actualResult.contains("UnControlled Leave Application Submitted Successfuly"));
	}

	public void clickUploadUCLDocumentIndex() {
		UploadUCLDocumentIndex.click();
	}
	public void clickBtnUCLview() {
		btnUCLview.click();
	}
	public void clickManageUCLDocumentIndex() {
		ManageUCLDocumentIndex.click();
	}
	public void clickDateStartEnd() {
		dtStartEnd.click();
	}
	public void enterDateRangePicker_Start(String startDate) {
		dateRangePicker_Start.clear();
		dateRangePicker_Start.sendKeys(startDate);
		dateRangePicker_Start.sendKeys(Keys.ENTER);	
	}
	public void enterDateRangePicker_End(String endDate) {
		dateRangePicker_End.clear();
		dateRangePicker_End.sendKeys(endDate);
		dateRangePicker_End.sendKeys(Keys.ENTER);
	}
	public void clickBtnApply() {
		btnApply.click();
	}

	public void employeeNumber() {
		employeeNumber.click();
	}
	public void performSearchEmployee(String empNo) {
		searchEmployee.clear();
		searchEmployee.sendKeys(empNo);
		searchEmployee.sendKeys(Keys.ENTER);
	}
	public void clickBtnSearchLeaveListUCL() {
		btnSearchLeaveListUCL.click();
	}
	public void clickLeaveRecordList() {
		//		leaveRecordList.click();
		action.moveToElement(leaveRecordList).perform();
		select = new Select(leaveRecordList);
		select.selectByValue("100");
	}
	public void clickBtnCancle() {
		btnCancle.click();
	}

	public void getpublicHolidayCannotBeApplyMsg() { 
		String actualResult =publicHolidayCannotBeApplyMsg.getText();
		Assert.assertTrue(actualResult.contains("MC,HP,UML,UNREC only can be applied on Public Holiday"));
	}
	public void getYouHaveAppliedMoreLeaveThanEntitledLeaveMsg() {
		String actualResult =YouHaveAppliedMoreLeaveThanEntitledLeaveMsg.getText();
		Assert.assertTrue(actualResult.contains("You have applied more leave than entitled leave"));
	}
	public void getLeaveToHasNoShiftForYouToApplyLeaveMsg() {
		String actualResult =LeaveToHasNoShiftForYouToApplyLeaveMsg.getText();
		Assert.assertTrue(actualResult.contains("Leave To has no Shift for you to apply leave,"));
	}

	public void clickEmpSetup() {
		webUtility.ElementClickable(driver, empSetup);
		empSetup.click();
	}
	public void clickEssWorkflowSetup() {
		//		webUtility.scrollAndClick(driver, essWorkflowSetup);
		webUtility.ElementClickable(driver, essWorkflowSetup);
		essWorkflowSetup.click();
	}

	public void clickApprovalRoutingDefinition() {
		approvalRoutingDefinition.click();
	}
	public void enterRouteSearch() {
		searchBar.clear();
		searchBar.sendKeys("Route B");
	}
	public void clickEditBtn() {
		editBtnRoute.click();
	}
	public void verifyCheckBoxAnyOneToApproveIsEnabled() {
		if (checkBoxAnyOneToApprove.isEnabled()) {
			checkBoxAnyOneToApprove.click();
			System.out.println("Checkbox is enabled and has been clicked.");
		} else {
			System.out.println("Checkbox is not enabled.");
		}
	}
	public void verifyCheckBoxAnyOneToApproveIsNotEnabled() {
		if (!checkBoxAnyOneToApprove.isEnabled()) {
			webUtility.ElementClickable(driver, checkBoxAnyOneToApprove);
			checkBoxAnyOneToApprove.click();
			System.out.println("Checkbox is enabled and has been clicked.");
		} else {
			System.out.println("Checkbox is not enabled.");
		}
	}
	public void clickBtnSaveWorkflowRouteDeatils() {
		webUtility.moveToElement(driver, btnSaveWorkflowRouteDeatils);
		btnSaveWorkflowRouteDeatils.click();
	} 
	public void getRouteUpdatedSuccessfullyMsg() {
		String actualResult =RouteUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Route updated successfully"));
	}


	public void E10_3225_EmployeeKiosk_ApplyForLeave(FakeEmployee fakeEmployee) throws Exception {
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();


	}

	public void E10_3226_EmployeeKiosk_ViewCalendarCheckShiftDetails() throws Exception{
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		//		Thread.sleep(8000);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickViewCalender();
		Thread.sleep(2000);
		// Get the title of the new window
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Calendar - JiViews";
		// Compare the actual title with the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected title");
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();
	}


	public void E10_3227_EmployeeKiosk_LeaveRecords() throws Exception{
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		Thread.sleep(5000);
		// Get the title of the new window
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Leave Records - JiViews";
		Thread.sleep(2000);		// Compare the actual title with the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected title");
		//		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();
	}
	public void E10_3228_EmployeeKiosk_MyleaveProfile()throws Exception{
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickMyLeaveProfile();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();
	}
	public void E10_3229_ApproverKiosk_ApproveLeave(FakeEmployee fakeEmployee)throws Exception{
		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();


		//		homePage.clickOnBtnLogout();
	}
	public void E10_3230_ApproverKiosk_CancelApproveleave(FakeEmployee fakeEmployee) throws Exception {
		String un = configUtility.getCongigPropertyData("unApprover");
		String pwd = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();

		Thread.sleep(3000);
		clickCancelApprovedLeaves();
		clickCancelLeaveEmpNumber();
		Thread.sleep(2000);
		enterSearchFiled("33128455");
		clickBtnSearchLeaveApplications();
		///////////////////////////////////////////////////check it proper for Approver 
		//				cancleLeaveRecordWithEnabledBtn();
		//		cancelLeaveRecordWithEnabledBtn();
		clickBtnCancle();
		clickBtnYes();
		clickNotificationPopup();

		//		homePage.clickOnBtnLogout();
	}
	public void E10_3231_ApplyLeaveAndCancleTheLeaveBeforeApproval(FakeEmployee fakeEmployee)throws Exception {
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		clickNotificationPopup();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();
		Thread.sleep(2000);
		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate("19/01/2024");
		//		fakeEmployee.getLeaveFromDate()
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("19/01/2024"); 
		//		fakeEmployee.getLeaveEndDate()
		pressBtnNext();
		Thread.sleep(3000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		driver.navigate().to(homeUrl);
		clickNotificationPopup();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickLeaveRecords();
		Thread.sleep(2000);
		//		clickBtnCancleLeave();
		clickLeaveRecordList();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();

	}
	public void E10_3232_CancelApprovedLeave_ApproverApprovedCancelLeave(FakeEmployee fakeEmployee) throws Exception{

		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());

		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(4000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		//		Approver approve Leave 

		String un = configUtility.getCongigPropertyData("unApprover");
		String pwd = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickBtnSaveRemarks();
		Thread.sleep(2000);
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();

		// Employee Cancle Leave 

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();

		//		Approver approve cancle leave 

		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();

		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickBtnSaveRemarks();
		Thread.sleep(2000);
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		//		homePage.clickOnBtnLogout(); 

		/*String unApprover2 = configUtility.getCongigPropertyData("unApprover2");
		String pwdApprover2 = configUtility.getCongigPropertyData("pwdApprover2");

		homePage.clickOnBtnLogout(); 
		loginPage.setLogin(unApprover2, pwdApprover2);

//		clickNotificationPopup();
		Thread.sleep(5000);
		homePage.setOrgUnit();
		Thread.sleep(2000);
		clickOn_OLM();

		jmMenuItem.clickOnEmployeeSelfService();
		empKiosk.clickApproverKiosk(); 

		clickNotificationPopup();

		Thread.sleep(2000);
		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickBtnSaveRemarks();
		Thread.sleep(2000);
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		homePage.clickOnBtnLogout(); */

	}

	public void E10_3233_ReapplyRejectedLeave_RejectAppovedCancelLeave(FakeEmployee fakeEmployee) throws Exception{
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());

		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();

		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();

		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 
		clickNotificationPopup();

		clickApproveLeave();
		Thread.sleep(2000);

		rejectLeaveRowsWithEnabledCheckbox();
		//		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		Thread.sleep(2000);
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		homePage.clickOnBtnLogout();
	}
	public void E10_3234_ReapplyCancelledLeave_CancelApprovedLeave(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();

		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		clickNotificationPopup();

		//		Thread.sleep(5000);
		clickCancelApprovedLeaves();
		clickCancelLeaveEmpNumber();
		enterSearchFiled("33128455");
		clickBtnSearchLeaveApplications();
		//		clickBtnCancleLeave();
		cancelLeaveRecordWithEnabledBtn(); 
		clickBtnYes();
		clickNotificationPopup();

		homePage.clickOnBtnLogout();
	}
	public void E10_3235_ReapplyCancelledApprovedLeave(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void E10_3248_PreventLeaveOverlaps(FakeEmployee fakeEmployee) throws Exception{
		//1. System should not allow to apply leave again when there is pending leave or approved leave on same date.
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

	}

	public void E10_3249_DeductLeaveOnApproval() {
		//	2. After approved the leave, leave balance should be deducted in my leave profile screen

	}
	public void E10_3250_AddLeaveOnCancellation() {
		//	3. After cancelled the approved leave, leave balance should be added in my leave profile screen.

	}
	public void E10_3251_RequireAllApprovers() {
		//	4. All approver should approve the leave when disabled the check box on Any one to approve

	}


	public void E10_3218_ApplyTimeOff(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyTimeOffIndex();
		enterTimeOffDate(fakeEmployee.getTmrwDate());
		Thread.sleep(3000);
		clickCmbTimeOffPeriod();
		selectTimePeriod();
		selectCheckBox();
		enterTimeOffRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		clickApplyTimeOff();

		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();
	}
	public void E10_3213_ApplyOnBehalf(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);

		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyOnBehalf();
		enterSearchEmployee();
		Thread.sleep(2000);
		clickSearchEmployee();
		Thread.sleep(2000);
		clickApplyLeaveOnBehalf();
		Thread.sleep(2000);
		enterLeaveType();
		chooseSickLeave();
		enterLeaveStartDate("05/01/2024");
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("05/01/2024"); // fakeEmployee.getLeaveEndDate()
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();

				clickBtnFinish();
				clickNotificationPopup();

		//	--------------------------------------------------------------------------------------------------------	


		driver.navigate().to(homeUrl);		
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyOnBehalf();
		enterSearchEmployee();
		Thread.sleep(2000);
		clickSearchEmployee();

		clickApplyTimeOffOnBehalf();
		enterTimeOffDate(fakeEmployee.getTmrwDate());
		Thread.sleep(3000);
		clickCmbTimeOffPeriod();
		selectTimePeriod();
		selectCheckBox();
		enterTimeOffRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickbtnAddAttachmentBehalf();
		//		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		clickApplyTimeOff();
		clickNotificationPopup();
		//		--------------------------------------------------------------------------------------------------------
		/*driver.navigate().to(homeUrl);		
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyOnBehalf();

		enterSearchEmployee();
//		Thread.sleep(2000);
		clickSearchEmployee();
		clickApplyforUncontrolledLeave();

		Thread.sleep(2000);
		clickUCLExceptionType();
		Thread.sleep(2000);
		clickSearchLeaveType();
		clickchooseLeaveType();
		clickUCLDate(fakeEmployee.getTmrwDate());
		entertxtUCLReferenceNo(fakeEmployee.getReferenceNo());
		entertxtUCLRemarks(fakeEmployee.getRemarksLeave());
		clickBtnApplyUCL();*/
		//		homePage.clickOnBtnLogout();
	}

	public void E10_3222_ApplyLeaveP2(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");

		// Apply Hospitalization Leave as Employee 
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseHospitalizationLeave();
		enterLeaveStartDate("09/01/2024");
		Thread.sleep(2000);
		enterLeaveEndDate("09/01/2024");
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		Thread.sleep(2000);
		selectPanelClinicName();
		choosePanelClinicName();
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		
		pressBtnNext();
		Thread.sleep(4000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		//		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		//		Approver Approve apply Hospitalization Leave ..........................................



		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);
		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		//		Employee Cancel approved Hospitalization Leave ..........................................  

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		clickLeaveRecordList();
		Thread.sleep(2000);
		//		clickBtnCancleLeave();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();



		//		Approver Approve Cancel  Hospitalization Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		// Apply Marriage Leave as Employee..........................................

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseMarriageLeave();
		enterLeaveStartDate("11/01/2024");
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("11/01/2024");
		pressBtnNext();
		Thread.sleep(3000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();


		//		Approver Approve apply Marriage Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);
		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		//		Employee Cancel approved Marriage Leave ..........................................  

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		Thread.sleep(2000);
		//		clickBtnCancleLeave();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();



		//		Approver Approve Cancel  Marriage Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		// Apply Paternity Leave as Employee..........................................

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		choosePaternityLeave();
		enterLeaveStartDate("14/01/2024");
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("14/01/2024");
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		//		Approver approve apply Paternity Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);
		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		//		Employee Cancel approved Paternity Leave ..........................................  

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		
		Thread.sleep(2000);
		//		clickBtnCancleLeave();
		clickLeaveRecordList();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();



		//		Approver Approve Cancel  Paternity Leave ..........................................

		Thread.sleep(2000);
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();



		// Apply Maternity Leave as Employee..........................................

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseMaternityLeave();
		enterLeaveStartDate("02/01/2024");
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("02/01/2024");
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		//		Approver approve apply Maternity Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);
		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		//		Employee Cancel approved Maternity Leave ..........................................  

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		Thread.sleep(2000);
		clickLeaveRecordList();
		cancelLeaveRecordWithEnabledBtn();
		clickBtnYes();
		Thread.sleep(2000);
		getLeaveCancelledSuccessfullyMsg();
		clickNotificationPopup();



		//		Approver Approve Cancel  Maternity Leave ..........................................

		Thread.sleep(2000);
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickApproveLeave();
		Thread.sleep(2000);

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();
	}

	public  void E10_3219_ApplyForUncontrolledLeave(FakeEmployee fakeEmployee) throws Exception {
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		String homeUrl = configUtility.getCongigPropertyData("homeurl");
		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickNotificationPopup();
		Thread.sleep(3000);
		clickUncontrolledLeave();
		Thread.sleep(2000);
		clickUCLExceptionType();
		chooseLeaveTypeUCL();

		clickUCLDate("23/01/2024");
		entertxtUCLReferenceNo(fakeEmployee.getReferenceNo());
		entertxtUCLRemarks(fakeEmployee.getRemarksLeave());
		clickBtnApplyUCL();
		getUnControlledLeaveApplicationSubmittedSuccessfulyMsg();
		clickNotificationPopup();


		//		E10_3221	[Employee Self Service] [Employee Kiosk] Upload UCL Document

		driver.navigate().to(homeUrl);		
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickNotificationPopup();


		clickUploadUCLDocumentIndex();
		clickBtnUCLview();
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		//		E10_3220	[Employee Self Service] [Employee Kiosk] Manage UCL Document

		Thread.sleep(2000);
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk(); 

		clickManageUCLDocumentIndex();
		clickDateStartEnd();
		enterDateRangePicker_Start(fakeEmployee.getRosterStartDate());
		enterDateRangePicker_End(fakeEmployee.getRosterEndDate());
		clickBtnApply();
		employeeNumber();

		performSearchEmployee("33128455");
		clickBtnSearchLeaveListUCL();
		clickBtnUCLview();

		//		homePage.clickOnBtnLogout();
	}
	private String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(formatter);
	}
	public void E10_3223_RescheduleLeave(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		String unApprover = configUtility.getCongigPropertyData("unApprover");
		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();


		clickApplyLeave();
		enterLeaveType();
		chooseAnnualLeave();
		// write logic for apply Annual leave for 6 days 
		// Set the range to 6 days
		int range = 6;

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Generate random start date within the range
		LocalDate startDate = currentDate.plusDays(new Random().nextInt(range));
		// Generate end date within the same range
		LocalDate endDate = startDate.plusDays(new Random().nextInt(range));

		enterLeaveStartDate(formatDate(startDate));
		enterLeaveEndDate(formatDate(endDate));
		//						enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//						enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();


		//		Approver Approve apply Annual Leave ..........................................


		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApprover, pwdApprover);

		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();

		clickApproveLeave();
		Thread.sleep(2000);
		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();

	}
	public void E10_3252_SingleApproverForRejection(FakeEmployee fakeEmployee) throws Exception{
		//	5. One approver is enough when reject the leave when disabled the check box on Any one to approve
		//		String unEmp = configUtility.getCongigPropertyData("unEmp");
		//		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		//		homePage.clickOnBtnLogout();
		//		loginPage.setLogin(unEmp, pwdEmp);
		//		jmMenuItem.clickOnSystemDefination();

		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();

	}
	public void E10_3442_ApplyLeaveOnPublicHoliday() throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseAnnualLeave();
		enterLeaveStartDate("22-01-2024");
		//		Thread.sleep(5000);
		//		enterLeaveEndDate("22-01-2024"); Not update the End date thatswhy i am entering the end date after remark 
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(5000);
		enterLeaveEndDate("22-01-2024");
		pressBtnNext();
		getpublicHolidayCannotBeApplyMsg();

		clickNotificationPopup();
	}
	public void E10_3443_ShiftlessEmployeeApplyPublicHolidayLeave()throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseAnnualLeave();
		enterLeaveStartDate("26-01-2024");
		//	enterLeaveEndDate("22-01-2024"); Not update the End date thatswhy i am entering the end date after remark 
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("26-01-2024");
		pressBtnNext();
		getLeaveToHasNoShiftForYouToApplyLeaveMsg(); 
		clickNotificationPopup();
	}
	public void E10_3444_NoPublicHolidayLeaveOnTheFollowingDayWithAssignedShift() throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyLeave();
		enterLeaveType();
		chooseAnnualLeave();
		enterLeaveStartDate("27-01-2024");
		//	enterLeaveEndDate("22-01-2024"); Not update the End date thatswhy i am entering the end date after remark 
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate("27-01-2024");
		pressBtnNext();

		getpublicHolidayCannotBeApplyMsg();
		clickNotificationPopup();
	}

	public void E10_3445_ApplyUnpaidLeave ()  throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		//		clickApplyLeave();
		//		enterLeaveType();
		//		chooseAnnualLeave();
		//		enterLeaveStartDate("27-01-2024");
		//		//	enterLeaveEndDate("22-01-2024"); Not update the End date thatswhy i am entering the end date after remark 
		//		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		//		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		//		Thread.sleep(2000);
		//		enterLeaveEndDate("27-01-2024");
		//		pressBtnNext();
		//
		//		getpublicHolidayCannotBeApplyMsg();
		//		clickNotificationPopup();
	}


	public void E10_3448_EnableTheAnyOneCanApprove() throws Exception{

		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void E10_3446_MultipleApproverApproveTheLeave(FakeEmployee fakeEmployee) throws Exception{

		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		Thread.sleep(2000);
		enterRouteSearch();
		clickEditBtn();
		Thread.sleep(2000);
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
		//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(3000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup(); 

		String unApr3 = configUtility.getCongigPropertyData("unApprover3");
		String pwdApr3 = configUtility.getCongigPropertyData("pwdApprover3");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr3, pwdApr3);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup(); 


	}
	public void E10_3447_RejectLeaveWithOneApprover (FakeEmployee fakeEmployee) throws Exception{

		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();
	}
	public void E10_3448EnableTheAnyOneCanApprove(FakeEmployee fakeEmployee) throws Exception{
		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();
	}
	public void E10_3449_LevelAndLevel2_AllApproverApproveTheLeave(FakeEmployee fakeEmployee) throws Exception{
		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();

	}
	public void  E10_3450_Level1ApproveAndLevel2_AnyOneOfApproverRejectTheLeave(FakeEmployee fakeEmployee) throws Exception{
		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();

	}
	public void  E10_3451_Level1ApproveRejectTheLeaveSystemShouldNotAskForLevel2Permission(FakeEmployee fakeEmployee) throws Exception{
		clickEmpSetup();
		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		enterRouteSearch();
		clickEditBtn();
		verifyCheckBoxAnyOneToApproveIsNotEnabled();
		clickBtnSaveWorkflowRouteDeatils();
		getRouteUpdatedSuccessfullyMsg();
		clickNotificationPopup();


		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseSickLeave();
		Thread.sleep(2000);
		enterLeaveStartDate(fakeEmployee.getLeaveFromDate());
//		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getLeaveEndDate());
		pressBtnNext();
		Thread.sleep(5000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		getLeaveApplicationSubmittedSuccessfullyMsg();
		clickNotificationPopup();

		String unApr = configUtility.getCongigPropertyData("unApprover");
		String pwdApr = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unApr, pwdApr);
		clickNotificationPopup();
		Thread.sleep(2000);
		homePage.setOrgUnit();
		clickOn_OLM();
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		Thread.sleep(2000);

		clickApproveLeave();
		Thread.sleep(2000);

		pendingForApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		clickBtnSaveRemarks();
		clickBtnYes();
		clickNotificationPopup();

	}
	public void E10_3469_CompensationLeave() {

	}

	public void E10_3470_UnrecordLeave(FakeEmployee fakeEmployee) throws Exception {
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		Thread.sleep(2000);
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		//		clickNotificationPopup();
//				Thread.sleep(2000);
		clickUncontrolledLeave();
		Thread.sleep(2000);
		clickUCLExceptionType();
		chooseLeaveTypeUCL();
		clickUCLDate("26/01/2024");
		entertxtUCLReferenceNo(fakeEmployee.getReferenceNo());
		entertxtUCLRemarks(fakeEmployee.getRemarksLeave());
		// Verify that the btnApplyUCL is not displayed on the screen
		assertFalse(btnApplyUCL.isDisplayed());
	}

}
