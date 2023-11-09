package com.AutomationJiviewsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class EmployeeSetupPage extends BaseClass{

	public EmployeeSetupPage empSetPage;

	@FindBy(xpath = "//div[text()='Employee Setup']/..")
	private WebElement empSetup;

	@FindBy(xpath = "//div[text()='Skills']/..")
	private WebElement skill;

	@FindBy(xpath = "//div[text()='Roles']")
	private WebElement role;

	@FindBy(xpath = "//div[text()='Role Groups']/..")
	private WebElement rolesGroup;

	@FindBy(xpath = "//div[text()='Percentage Configuration']")
	private WebElement percentageConfiguration;

	public EmployeeSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setEmpSetup() {
		webUtility.ElementClickable(driver, empSetup);
		empSetup.click();
	}
	public void setSkill() {
		skill.click();
	}
	public void setRole() {
		role.click();
	}
	public void setRolesGroup() {
		rolesGroup.click();
	}
	public void setPercentageConfiguration() {
		percentageConfiguration.click();
	}

	// it will create a new skill 
	public void setCreateSkill() throws InterruptedException {
		empSetPage= new EmployeeSetupPage(driver);

		empSetPage.setEmpSetup();
		empSetPage.setSkill();

	}

	public void setCreateRole() {
		empSetPage= new EmployeeSetupPage(driver);
		empSetPage.setEmpSetup();
		empSetPage.setRole();
	}

	public void setCreateRoleGroups() {
		empSetPage= new EmployeeSetupPage(driver);
		empSetPage.setEmpSetup();
		empSetPage.setRolesGroup();
	}
	public void setCreatePercentageConfiguration() {
		empSetPage= new EmployeeSetupPage(driver);
		empSetPage.setEmpSetup();
		empSetPage.setPercentageConfiguration();
	}
}
