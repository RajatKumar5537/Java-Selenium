package com.AutomationJiviewsPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ReusableComponent;

public class E10_2749_SystemDefinationRoleGroupPage 
{

	public WebDriver driver ;
	public ReusableComponent Rc ;
	public String roleGrpName;



	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // System Definitions

	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[1]")
	WebElement ulApplicationMenu; // Employee Setup

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[1]/li")
	List<WebElement> sideNavMenu; // Role Groups



	@FindBy(id = "btnAddRoleGroup")
	private WebElement btnAddRoleGroup;

	@FindBy(xpath = "//input[@id='txtRoleGroupName']")
	private WebElement txtRoleGroupName;

	// Available Roles table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableRoles;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle; 

	//		select for move multiple skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	// here it will select a skill from Seleceted Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement selectedSkill;

	//	select for move single skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	private WebElement removeSelectedSkillSingle;

	//	select for move multiple skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	private WebElement removeSelectedSkillAll;

	@FindBy(xpath = "//button[@id='btnSaveRoleGroupDtls']")
	private WebElement btnSaveRoleGroupDtls;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement btnEdit;

	@FindBy(xpath = "//table[@id='RoleGroup-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//li[@id='RoleGroup-list_next']")
	private WebElement nextPage;

	@FindBy(xpath = "//button[@id='btnDeleteRoleGroup']")
	private WebElement btnDeleteRoleGroup;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//label[text()='Role Group Name is required']")
	private WebElement txtGrpNmRequired;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement txtSearch;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//div[text()='Role Group created successfully']")
	WebElement roleGroupCreatedSuccessfullyMsg;

	@FindBy(xpath = "//div[text()='Role Group updated successfully']")
	WebElement roleGroupUpdatedSuccessfullyMsg;

	@FindBy(xpath = "//div[text()='Selected Shift Band Type deleted successfully.']")
	WebElement shiftBandTypeDeletedSuccessfullyMsg;


	public E10_2749_SystemDefinationRoleGroupPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
		this.Rc= new ReusableComponent(driver);
	}

	public void createRolesGroup() throws Exception 
	{
		roleGrpName = Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "visibility");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicking");
		Rc.explicitWait(dvApplicationMenuItems, "visibility");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicking");
		Rc.explicitWait(ulApplicationMenu, "visibility");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Role Groups", "Role Groups is not clicking");
		btnAddRoleGroup.click();
		Thread.sleep(2000);
		Rc.explicitWait(txtRoleGroupName, "visibility");
		txtRoleGroupName.clear();
		txtRoleGroupName.sendKeys(roleGrpName + " " + System.currentTimeMillis());
		Rc.scrollToElement(availableRoles);
		Rc.selectByIndex(availableRoles, 1);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		btnSaveRoleGroupDtls.click();
		String actualResult = roleGroupCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Group created successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void updateRolesGroup() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visibility");
		txtSearch.clear();
		txtSearch.sendKeys(roleGrpName);
		Rc.explicitWait(btnEdit, "clickable");
		btnEdit.click();
		Rc.explicitWait(txtRoleGroupName, "visibility");
		txtRoleGroupName.clear();
		txtRoleGroupName.sendKeys(roleGrpName + " " + System.currentTimeMillis());
		Rc.scrollToElement(availableRoles);
		Rc.selectByIndex(availableRoles, 1);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		btnSaveRoleGroupDtls.click();
		String actualResult = roleGroupUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Group updated successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void deactivateRoleGroup() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visibility");
		txtSearch.clear();
		txtSearch.sendKeys(roleGrpName);
		Thread.sleep(2000);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.explicitWait(btnDeleteRoleGroup, "clickable");
		btnDeleteRoleGroup.click();
		Rc.explicitWait(btnYes, "clickable");
		btnYes.click();
		String actualResult = shiftBandTypeDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Selected Shift Band Type deleted successfully."));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void createRoleGrpWithoutAvailableRole() throws Exception 
	{

		roleGrpName = Rc.firstName;
		Thread.sleep(2000);
		Rc.explicitWait(btnAddRoleGroup, "clickable");
		btnAddRoleGroup.click();
		Thread.sleep(2000);
		Rc.explicitWait(txtRoleGroupName, "visibility");
		txtRoleGroupName.clear();
		txtRoleGroupName.sendKeys(roleGrpName + " " + System.currentTimeMillis());
		Rc.moveToElement(btnSaveRoleGroupDtls);
		btnSaveRoleGroupDtls.click();
		String actualResult = roleGroupCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Group created successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();


	}


	public void createRoleGrpWithoutRoleGrpName() throws Exception 
	{

		roleGrpName = Rc.name;

		btnAddRoleGroup.click();
		Thread.sleep(2000);
		Rc.explicitWait(availableRoles, "visibility");
		Rc.scrollToElement(availableRoles);
		Rc.selectByIndex(availableRoles, 1);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		btnSaveRoleGroupDtls.click();
		String actualResult = txtGrpNmRequired.getText();
		Assert.assertTrue(actualResult.contains("Role Group Name is required"));

	}

}
