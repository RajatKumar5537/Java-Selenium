package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class WorkforceSchedulingPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Scheduling']/..")
	private WebElement Scheduling;
	@FindBy(xpath = "//div[text()='Employee Roster V2']/..")
	private WebElement EmployeeRosterV2;
	
	public WorkforceSchedulingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickScheduling() {
		Scheduling.click();
	}
	public void clickEmployeeRosterV2() {
		EmployeeRosterV2.click();
	}
	
	
	public void setEmployeeRosterV2() {
		clickScheduling();
		clickEmployeeRosterV2();
	}
}
