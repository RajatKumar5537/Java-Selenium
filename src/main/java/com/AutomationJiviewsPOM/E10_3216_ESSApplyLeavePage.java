package com.AutomationJiviewsPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.configUtility;

public class E10_3216_ESSApplyLeavePage extends BaseClass{

	private HomePage homePage;
	private LoginPage loginPage;
	private jiviewsMainMenuItems jmMenuItem;
	private EmployeeKioskPage empKiosk;

	@FindBy(xpath = "(//div[text()='Apply Leave']/..)[3]")
	private WebElement applyLeave;

	@FindBy(xpath = "//span[@id='select2-cmbExceptionType-container']")
	private WebElement leaveType;
	@FindBy(xpath = "//li[text()='Sick Leave']")
	private WebElement selectSickLeave;
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

	public E10_3216_ESSApplyLeavePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.homePage=  new HomePage(driver);
		this.loginPage = new LoginPage(driver);
		this.jmMenuItem= new jiviewsMainMenuItems(driver);
		this.empKiosk = new EmployeeKioskPage(driver);
	}
	public void clickApplyLeave() {
		applyLeave.click();
	}
	public void enterLeaveType() {
		leaveType.click();
	}
	public void chooseSelectSickLeave() {
		selectSickLeave.click();
	}
	public void enterLeaveStartDate() {
		dtLeaveStartDate.clear();
	}
	public void enterLeaveEndDate() {
		dtLeaveEndDate.clear();
	}
	public void enterLeaveReferenceNo() {
		txtLeaveReferenceNo.clear();
	}
	public void enterLeaveRemarks() {
		txtLeaveRemarks.clear();
	}
	public void pressBtnNext() {
		btnNext.click();
	}
	public void E10_3225_LoginAsEmployeeApplyForLeave() throws InterruptedException, IOException {
		String un = configUtility.getCongigPropertyData("unEmp");
		String pwd = configUtility.getCongigPropertyData("pwdEmp");

		homePage.clickOnBtnLogout();
		loginPage.setLogin(un, pwd);
		//		Thread.sleep(8000);
		jmMenuItem.clickOnEmployeeSelfService();
		Thread.sleep(2000);
		empKiosk.clickEmployeeKiosk();
		clickApplyLeave();

	}
}
