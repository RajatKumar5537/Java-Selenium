package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class EmployeeAdminstrationPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Employee']/..")
	private WebElement employee;
	
	@FindBy(xpath ="//div[text()='Employee Profile']/.." )
	private WebElement employeeProfile;
	@FindBy(xpath = "//div[text()='Roster Group Assignment']/..")
	private WebElement rosterGroupAssignment;
	
	
	
	public EmployeeAdminstrationPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickEmployee() {
		webUtility.ElementClickable(driver, employee);
		employee.click();
	}
	public void clickEmployeeProfile() {
		employeeProfile.click();
	}
	public void clickonRosterGroupAssignment() {
		rosterGroupAssignment.click();
	}
	
	
	public void setEmployeeProfile() {
		clickEmployee();
		clickEmployeeProfile();
	}
	public void setRosterGroupAssignment() {
		clickEmployee();
		clickonRosterGroupAssignment();
	}
}
