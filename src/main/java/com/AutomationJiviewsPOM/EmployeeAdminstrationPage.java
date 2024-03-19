package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

public class EmployeeAdminstrationPage {

	WebDriver driver ;
	WebUtilities webUtility;
	
	
	@FindBy(xpath = "//div[text()='Employee']/..")
	private WebElement employee;
	
	@FindBy(xpath ="//div[text()='Employee Profile']/.." )
	private WebElement employeeProfile;
	@FindBy(xpath = "//div[text()='Roster Group Assignment']/..")
	private WebElement rosterGroupAssignment;
	
	
	
	public EmployeeAdminstrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.webUtility= new WebUtilities(driver);
	}
	
	public void clickEmployee() {
		webUtility.ElementClickable(driver, employee);
		employee.click();
	}
	public void clickEmployeeProfile() {
		webUtility.ElementClickable(driver, employeeProfile);
		employeeProfile.click();
	}
	public void clickonRosterGroupAssignment() {
		rosterGroupAssignment.click();
	}
	
	
	public void setEmployeeProfile() {
//		clickEmployee();
		clickEmployeeProfile();
	}
	public void setRosterGroupAssignment() {
		clickEmployee();
		clickonRosterGroupAssignment();
	}
}
