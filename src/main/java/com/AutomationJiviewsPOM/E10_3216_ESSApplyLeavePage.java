package com.AutomationJiviewsPOM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li[2]")
	private WebElement click_OLM;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/ApplyLeave']/a/div") 
	private WebElement applyLeave;

	@FindBy(xpath = "//span[@id='select2-cmbExceptionType-container']")
	private WebElement leaveType;
	@FindBy(xpath = "//li[text()='Sick Leave']")
	private WebElement selectSickLeave;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	private WebElement selectEmergencyLeave;
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

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel']")
	private WebElement btnCancleLeave;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel']")
	private WebElement btnCancle;
	@FindBy(xpath = "//div[text()='Leave Cancelled Successfully']")
	private WebElement LeaveCancelledSuccessfullyMsg;


	@FindBy(xpath = "//div[text()='ESS Workflow Setup']/..")
	private WebElement essWorkflowSetup;
	@FindBy(xpath = "//div[text()='Approval Routing Definition']/..")
	private WebElement approvalRoutingDefinition;
	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1'])[7]")
	private WebElement editBtn;
	@FindBy(xpath = "//span[text()='Any One To Approve']")
	private WebElement checkBoxAnyOneToApprove;

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

	public E10_3216_ESSApplyLeavePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.homePage=  new HomePage(driver);
		this.loginPage = new LoginPage(driver);
		this.orgUnit = new OrganizationUnitDropDown(driver);
		this.jmMenuItem= new jiviewsMainMenuItems(driver);
		this.empKiosk = new EmployeeKioskPage(driver);
	}
	public void clickApplyLeave() {
		webUtility.ElementClickable(driver, applyLeave);
		applyLeave.click();
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
	public void enterLeaveStartDate(String startDate) {
		dtLeaveStartDate.clear();
		dtLeaveStartDate.sendKeys(startDate);
		dtLeaveStartDate.sendKeys(Keys.ENTER);
	}
	public void enterLeaveEndDate(String endDate) {
		dtLeaveEndDate.clear();
		dtLeaveEndDate.sendKeys(endDate);
		dtLeaveEndDate.sendKeys(Keys.ENTER);
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
		webUtility.ElementClickable(driver, cmbCancelLeaveEmpNumber);
		cmbCancelLeaveEmpNumber.click();
	}
	public void enterSearchFiled(String empId) {
		searchFiled.clear();
		searchFiled.sendKeys(empId);
		searchFiled.sendKeys(Keys.ENTER);
	}
	public void clickBtnSearchLeaveApplications() {
		btnSearchLeaveApplications.click();
	}
	public void clickBtnCancleLeave() {
		webUtility.ElementClickable(driver, btnCancleLeave);
		btnCancleLeave.click();
	}
	public void clickBtnYes() {
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
	public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
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

	public void clickEssWorkflowSetup() {
		webUtility.ElementClickable(driver, essWorkflowSetup);
		essWorkflowSetup.click();
	}
	public void clickApprovalRoutingDefinition() {
		approvalRoutingDefinition.click();
	}
	public void clickEditBtn() {
		editBtn.click();
	}
	public void clickCheckBoxAnyOneToApprove() {
		checkBoxAnyOneToApprove.click();
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
		txtSearchEmployee.clear();
		txtSearchEmployee.sendKeys("33128455");
		//		txtSearchEmployee.sendKeys(Keys.ENTER);	
	}
	public void clickSearchEmployee() {
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
		//						enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//						enterLeaveEndDate(fakeEmployee.getTmrwDate());
		//		 enterLeaveStartDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		//		 enterLeaveEndDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		//		 enterLeaveStartDate("28-12-2023");
		//		 enterLeaveEndDate("28-12-2023");
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();

		E10_3229_ApproverKiosk_ApproveLeave(fakeEmployee);

		//		String unApprover = configUtility.getCongigPropertyData("unApprover");
		//		String pwdApprover = configUtility.getCongigPropertyData("pwdApprover");
		//
		//		homePage.clickOnBtnLogout();
		//		loginPage.setLogin(unApprover, pwdApprover);
		//		clickNotificationPopup();
		//		Thread.sleep(2000);
		//		homePage.setOrgUnit();
		//		clickOn_OLM();
		//		jmMenuItem.clickOnEmployeeSelfService();
		//		Thread.sleep(2000);
		//		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		//		Thread.sleep(2000);
		//
		//		clickApproveLeave();
		//		Thread.sleep(2000);
		//
		//		pendingForApprovalRowsWithEnabledCheckbox();
		//		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		//		Thread.sleep(2000);
		//		clickBtnSaveRemarks();
		//		Thread.sleep(2000);
		//		clickBtnYes();
		//		Thread.sleep(2000);
		//		clickNotificationPopup();
		//
		//
		//		homePage.clickOnBtnLogout();

		E10_3230_ApproverKiosk_CancelApproveleave(fakeEmployee);
		//		
		//		String un = configUtility.getCongigPropertyData("unApprover");
		//		String pwd = configUtility.getCongigPropertyData("pwdApprover");
		//
		//		homePage.clickOnBtnLogout();
		//		loginPage.setLogin(un, pwd);
		//		clickNotificationPopup();
		//		Thread.sleep(2000);
		//		homePage.setOrgUnit();
		//		clickOn_OLM();
		//		jmMenuItem.clickOnEmployeeSelfService();
		//		Thread.sleep(2000);
		//		empKiosk.clickApproverKiosk();
		//		clickNotificationPopup();
		//
		//		//		Thread.sleep(5000);
		//		clickCancelApprovedLeaves();
		//		clickCancelLeaveEmpNumber();
		//		enterSearchFiled("33128455");
		//		clickBtnSearchLeaveApplications();
		//		clickBtnCancleLeave();
		//		clickBtnYes();
		//		clickNotificationPopup();
		//
		//		homePage.clickOnBtnLogout();

	}

	public void E10_3226_EmployeeKiosk_ViewCalendarCheckShiftDetails() throws IOException, InterruptedException{
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

		homePage.clickOnBtnLogout();
	}


	public void E10_3227_EmployeeKiosk_LeaveRecords() throws IOException, InterruptedException{
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
		// Compare the actual title with the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected title");


		homePage.clickOnBtnLogout();
	}
	public void E10_3228_EmployeeKiosk_MyleaveProfile()throws IOException, InterruptedException{
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickMyLeaveProfile();

		homePage.clickOnBtnLogout();
	}
	public void E10_3229_ApproverKiosk_ApproveLeave(FakeEmployee fakeEmployee)throws Exception{
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
		clickNotificationPopup();
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


		homePage.clickOnBtnLogout();
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
		clickNotificationPopup();

		//		Thread.sleep(5000);
		clickCancelApprovedLeaves();
		clickCancelLeaveEmpNumber();
		enterSearchFiled("33128455");
		clickBtnSearchLeaveApplications();
		clickBtnCancleLeave();
		clickBtnYes();
		clickNotificationPopup();

		homePage.clickOnBtnLogout();
	}
	public void E10_3231_ApplyLeaveAndCancleTheLeaveBeforeApproval(FakeEmployee fakeEmployee)throws Exception {
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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(3000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		clickNotificationPopup();


		clickLeaveRecords();
		clickBtnCancleLeave();
		clickBtnYes();
		clickNotificationPopup();
		homePage.clickOnBtnLogout();

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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		//		 enterLeaveStartDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		//		 enterLeaveEndDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		//		 enterLeaveStartDate("28-12-2023");
		//		 enterLeaveEndDate("28-12-2023");
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
		clickNotificationPopup();
		//		homePage.clickOnBtnLogout();

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
		clickNotificationPopup();
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

		//		homePage.clickOnBtnLogout();

		String unEmp1 = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp1 = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp1, pwdEmp1);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickLeaveRecords();
		clickBtnCancleLeave();
		clickBtnYes();
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

		pendingCancelApprovalRowsWithEnabledCheckbox();
		enterTxtApproveRejectAllRemarks(fakeEmployee.getRemarksLeave());
		Thread.sleep(2000);
		clickBtnSaveRemarks();
		Thread.sleep(2000);
		clickBtnYes();
		Thread.sleep(2000);
		clickNotificationPopup();


		homePage.clickOnBtnLogout(); 

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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
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
		clickBtnCancleLeave();
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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
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
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		pressBtnNext();
		clickBtnFinish();
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
	public void E10_3252_SingleApproverForRejection(FakeEmployee fakeEmployee) throws Exception{
		//	5. One approver is enough when reject the leave when disabled the check box on Any one to approve
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");
		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnSystemDefination();

		clickEssWorkflowSetup();
		clickApprovalRoutingDefinition();
		clickEditBtn();
		clickCheckBoxAnyOneToApprove();
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
	}
	public void E10_3213_ApplyOnBehalf(FakeEmployee fakeEmployee) throws Exception{
		String unEmp = configUtility.getCongigPropertyData("unEmp");
		String pwdEmp = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(unEmp, pwdEmp);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyOnBehalf();
		enterSearchEmployee();
		Thread.sleep(2000);
		clickSearchEmployee();
		clickApplyLeaveOnBehalf();

		enterLeaveType();
		chooseSickLeave();
		//		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		//		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		pressBtnNext();
		Thread.sleep(2000);
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		 
		//		clickBtnFinish();
		//		clickNotificationPopup();

		//	--------------------------------------------------------------------------------------------------------	

		String homeUrl = configUtility.getCongigPropertyData("homeurl");
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
		//		--------------------------------------------------------------------------------------------------------
		driver.navigate().to(homeUrl);		
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();

		clickApplyOnBehalf();
		enterSearchEmployee();
		Thread.sleep(2000);
		clickSearchEmployee();

		clickApplyforUncontrolledLeave();
		clickSearchLeaveType();
		clickchooseLeaveType();
		clickUCLDate(fakeEmployee.getTmrwDate());
		entertxtUCLReferenceNo(fakeEmployee.getReferenceNo());
		entertxtUCLRemarks(fakeEmployee.getRemarksLeave());
		clickBtnApplyUCL();
	}


}
