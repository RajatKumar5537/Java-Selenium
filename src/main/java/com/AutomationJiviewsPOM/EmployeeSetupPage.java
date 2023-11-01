package com.AutomationJiviewsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class EmployeeSetupPage extends BaseClass{
	
	public EmployeeSetupPage empSetPage;

	@FindBy(xpath = "//div[text()='Employee Setup']/..")
	private WebElement EmpSetup;
	
	@FindBy(xpath = "//div[text()='Skills']/..")
	private WebElement skill;
	
	@FindBy(xpath = "//div[text()='Roles']")
	private WebElement role;
	
	@FindBy(xpath = "//div[text()='Role Groups']")
	private WebElement rolesGroup;
	
	@FindBy(xpath = "//div[text()='Percentage Configuration']")
	private WebElement percentageConfiguration;
	
	public EmployeeSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
/*	public void setEmpSetup() throws Exception {
		webUtility.visibilityOfElement(driver, EmpSetup);
		EmpSetup.click();
	}
	public void setSkill() throws Exception {
		webUtility.visibilityOfElement(driver, skill);
		skill.click();
	}
	
	public void setRole() throws Exception {
		webUtility.visibilityOfElement(driver, role);
		role.click();
	}
	// it will create a new skill 
	public void setCreateSkill() throws Exception {
		empSetPage = new EmployeeSetupPage(driver);
		empSetPage.setEmpSetup();
		empSetPage.setSkill();
	}
	
	public void setCreateRole() throws Exception {
		empSetPage = new EmployeeSetupPage(driver);
		empSetPage.setEmpSetup();
		empSetPage.setRole();
	}

	public void setPercentageConfiguration() {
		empSetPage = new EmployeeSetupPage(driver);
		EmpSetup.click();
		percentageConfiguration.click();
	}*/
	
	
	// it will create a new skill 
	public void setCreateSkill() throws InterruptedException {
		Thread.sleep(2000);
		EmpSetup.click();
//		Thread.sleep(2000);
		skill.click();
	}
	
	public void setCreateRole() {
		EmpSetup.click();
		role.click();
	}
	
	public void setCreateRoleGroups() {
		EmpSetup.click();
		rolesGroup.click();
	}
	public void setPercentageConfiguration() {
		EmpSetup.click();
		percentageConfiguration.click();
	}
}
