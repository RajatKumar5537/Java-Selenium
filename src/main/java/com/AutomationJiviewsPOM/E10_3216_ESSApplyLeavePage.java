package com.AutomationJiviewsPOM;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;
import com.AutomationJiviewsGeneric.configUtility;

public class E10_3216_ESSApplyLeavePage extends BaseClass{

	private HomePage homePage;
	private LoginPage loginPage;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeKioskPage empKiosk;


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


	@FindBy(xpath = "//li[@data-menu-link='SelfService/Calendar']/a")
	private WebElement viewCalender;
	@FindBy(xpath = "//li[@data-menu-link='SelfService/MyLeaveProfile']/a")
	private WebElement MyLeaveProfile;
	@FindBy(xpath = "//li[@data-menu-link='SelfService/LeaveRecords']/a")
	private WebElement LeaveRecords;

	@FindBy(xpath = "//li[@data-menu-link='SelfService/Transactions/PendingTransactionsIndex']")
	private WebElement approveLeave;
	@FindBy(xpath = "//input[@id='dtStartAndEnd']")
	private WebElement dtStartAndEnd;
	@FindBy(xpath = "//span[@id='select2-cmbLeaveType-container']")
	private WebElement cmbLeaveType;
	@FindBy(xpath = "//li[text()='Emergency Leave']")
	private WebElement emergencyLeave;
	@FindBy(xpath = "//button[@id='btnSearchLeaveList']")
	private WebElement btnSearchLeaveList;

	@FindBy(xpath = "//button[@id='btnApproveAllLeave']")
	private WebElement btnApproveAllLeave;


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


	public E10_3216_ESSApplyLeavePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.homePage=  new HomePage(driver);
		this.loginPage = new LoginPage(driver);
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
		btnNext.click();
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
		webUtility.moveToElement(driver, btnCancleLeave);
		btnCancleLeave.click();
	}
	public void clickBtnYes() {
		btnYes.click();
	}
	public void clickNotificationPopup() throws Exception {
		webUtility.visibilityOfElement(driver, notificationPopup);
		notificationPopup.click();
	}


	public void E10_3225_EmployeeKiosk_ApplyForLeave(FakeEmployee fakeEmployee) throws InterruptedException, IOException {
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		//		Thread.sleep(8000);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

		enterLeaveType();
		chooseEmergencyLeave();
		enterLeaveStartDate(fakeEmployee.getTmrwDate());
		Thread.sleep(2000);
		enterLeaveEndDate(fakeEmployee.getTmrwDate());
		enterLeaveReferenceNo(fakeEmployee.getReferenceNo());
		enterLeaveRemarks(fakeEmployee.getRemarksLeave());
		//		pressBtnNext();
		
		homePage.clickOnBtnLogout();
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
	public void E10_3229_ApproverKiosk_ApproveLeave()throws Exception{
		String un = configUtility.getCongigPropertyData("unApprover");
		String pwd = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		clickNotificationPopup();

		clickApproveLeave();
		clickLeaveType();
		selectEmergencyLeave();
		clickBtnSearchLeaveList();
		
		homePage.clickOnBtnLogout();
	}
	public void E10_3230_ApproverKiosk_CancelApproveleave() throws Exception {
		String un = configUtility.getCongigPropertyData("unApprover");
		String pwd = configUtility.getCongigPropertyData("pwdApprover");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickApproverKiosk();
		clickNotificationPopup();

		//		Thread.sleep(5000);
		clickCancelApprovedLeaves();
		clickCancelLeaveEmpNumber();
		enterSearchFiled("1005");
		clickBtnSearchLeaveApplications();
		clickBtnCancleLeave();
		//		clickBtnYes();
		
		
		homePage.clickOnBtnLogout();
	}

}
