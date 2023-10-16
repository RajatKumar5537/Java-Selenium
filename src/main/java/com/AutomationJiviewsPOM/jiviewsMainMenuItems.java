package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class jiviewsMainMenuItems extends BaseClass{
	@FindBy(xpath = "//span[text()='SYSTEM SETUP']/..")
	private WebElement mainMenu;

	@FindBy(xpath = "//span[text()='System Setup']/..")
	private WebElement selectSystemSetup;

	@FindBy(xpath = "//span[text()='System Definitions']/..")
	private WebElement selectSystemDefination;

	@FindBy(xpath = "//span[text()='Employee Administration']/..")
	private WebElement selectEmployeeAdministration;

	@FindBy(xpath = "//span[text()='Workforce Scheduling']/..")
	private WebElement selectWorkforceScheduling;

	@FindBy(xpath = "//span[text()='Employee Self Service']/..")
	private WebElement selectEmployeeSelfService;

	@FindBy(xpath = "//span[text()='Operation Planning & Execution']/..")
	private WebElement selectOperationPlanningExecution;

	@FindBy(xpath = "//span[text()='Time & Attendance']/..")
	private WebElement selectTimeAttendance;

	@FindBy(xpath = "//span[text()='Reports']/..")
	private WebElement selectReports;
	
	@FindBy(xpath = "//span[text()='Dashboard']/..")
	private WebElement selectDashboard;


	public jiviewsMainMenuItems(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void  setMainMenu() {
		mainMenu.click();
	}

	public void setSelectSystemSetup() {
		selectSystemSetup.click();
	}
	public void setSelectSystemDefination() {
		selectSystemDefination.click();
	}
	public void setSelectEmployeeAdministration() {
		selectEmployeeAdministration.click();
	}
	public void setSelectWorkforceScheduling() {
		selectWorkforceScheduling.click();
	}

	public void setSelectEmployeeSelfService() {
		selectEmployeeSelfService.click();
	}
	public void setSelectOperationPlanningExecution() {
		selectOperationPlanningExecution.click();
	}
	public void setSelectTimeAttendance() {
		selectTimeAttendance.click();
	}

	public void setSelectReports() {
		selectReports.click();
	}
	
	public void setSelectDashboard() {
		selectDashboard.click();
	}

	public void clickOnSystemDefination() throws InterruptedException {
		
		jiviewsMainMenuItems jmmi=new jiviewsMainMenuItems(driver);
		Thread.sleep(2000);
		jmmi.setMainMenu();
		Thread.sleep(2000);
		jmmi.setSelectSystemDefination();
	}
}
