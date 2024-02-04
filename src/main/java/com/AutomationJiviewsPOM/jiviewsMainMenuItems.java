package com.AutomationJiviewsPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

import io.netty.handler.timeout.TimeoutException;

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
//		webUtility.ElementClickable(driver, mainMenu);
//		mainMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mainMenu));
        element.click();
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
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectWorkforceScheduling));

		        Actions actions = new Actions(driver);
		        actions.moveToElement(element).click().perform();
		    } catch (TimeoutException e) {
		        System.out.println("Timeout waiting for the element to be clickable.");
		    } catch (Exception e) {
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		    }
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
