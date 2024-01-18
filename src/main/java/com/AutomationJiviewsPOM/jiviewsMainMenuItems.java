package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

public class jiviewsMainMenuItems extends BaseClass{

	WebUtilities webUtility;

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
		super();
		PageFactory.initElements(driver, this);
		this.webUtility= new WebUtilities(driver);
	}

	public void  clickMainMenu() {
		webUtility.ElementClickable(driver, mainMenu);
		mainMenu.click();
	}

	public void clickSystemDefination() {
		webUtility.ElementClickable(driver, selectSystemDefination);
		selectSystemDefination.click();
	}

	public void clickEmployeeAdministration() {
		webUtility.ElementClickable(driver, selectEmployeeAdministration);
		selectEmployeeAdministration.click();
	}
	public void clickWorkforceScheduling() {
		webUtility.ElementClickable(driver, selectWorkforceScheduling);
		selectWorkforceScheduling.click();
	}
	public void clickSelectOperationPlanningExecution() {
		webUtility.ElementClickable(driver, selectOperationPlanningExecution);
		selectOperationPlanningExecution.click();
	}
	public void clickSelectEmployeeSelfService() {
		webUtility.ElementClickable(driver, selectEmployeeSelfService);
		selectEmployeeSelfService.click();
	}


	public void clickOnSystemDefination()  {
		clickMainMenu();
		clickSystemDefination();
	}
	public void setEmployeeAdministration() {
		clickMainMenu();
		clickEmployeeAdministration();
	}
	public void setSelectWorkforceScheduling() throws InterruptedException {
		clickMainMenu();
//		Thread.sleep(2000);
		clickWorkforceScheduling();
	}
	public void clickOnOperationPlanningExecution() {
		clickMainMenu();
		clickSelectOperationPlanningExecution();
	}
	public void clickOnEmployeeSelfService() {
		clickMainMenu();
		clickSelectEmployeeSelfService();
	}
}
