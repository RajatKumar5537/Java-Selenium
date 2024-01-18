package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class EmployeeKioskPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Employee Kiosk']/..")
	private WebElement employeeKiosk;
	
	@FindBy(xpath = "//div[text()='Apply Leave']/..")
	private WebElement applyLeave;
	
	@FindBy(xpath = "//div[text()='Approver Kiosk']/..")
	private WebElement approverKiosk;
	
	
	public EmployeeKioskPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void clickEmployeeKiosk() {
		employeeKiosk.click();	
	}
	public void clickApplyLeave() {
		applyLeave.click();
	}
	public void clickApproverKiosk() {
		webUtility.moveToElement(driver, approverKiosk);
		approverKiosk.click();
	}
	public void clickOnApplyLeave() {
		clickEmployeeKiosk();
		clickApplyLeave();
	}
	
}
