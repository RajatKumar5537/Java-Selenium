package com.AutomationJiviewsPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ReusableComponent;

public class E10_2909_EmpAdmRosterGroupAssignmentPage  
{

	WebDriver driver ;
	ReusableComponent Rc ;
	String RosterGroupname;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // Employee Administration

	@FindBy(xpath = "//ul[@id='ulApplicationMenu']/li/a")
	WebElement ulApplicationMenu; // Employee

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[2]/li")
	List<WebElement> sideNavMenu; // Employee Profile

	@FindBy(xpath = "//div[text()='Roster Group Assignment']/..")
	WebElement rosterGroupAssignment;

	@FindBy(xpath = "//button[@id='btnAddRosterGroup']")
	WebElement btnAddRosterGroup;
	@FindBy(xpath = "//input[@id='txtRosterGroupname']")
	WebElement txtRosterGroupname;
	@FindBy(xpath = "//input[@id='txtRosterGroupDesc']")
	WebElement txtRosterGroupDesc;
	@FindBy(xpath = "//input[@id='txtRemarks']")
	WebElement txtRemarks;

	@FindBy(xpath = "//table[@id='availableEmpListDataTable']")
	WebElement availableEmpListDataTable;
	@FindBy(xpath = "//td[@class='align-middle py-3']")
	List<WebElement> checkboxesMembers;;

	@FindBy(xpath = "//table[@id='RosterGroup-list']/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//li[@id='RosterGroup-list_next']")
	WebElement nextPage;

	@FindBy(xpath = "(//td[@class='font-weight-bold align-middle py-3'])[1]")
	WebElement clickonAlignMiddle;
	@FindBy(xpath = "//a[@data-item='AddSelected']")
	WebElement addSelectedItem;
	@FindBy(xpath = "//button[@id='btnSaveRosterGroup']")
	WebElement btnSaveRosterGroup;
	@FindBy(xpath = "//div[text()='Roster Group Created Successfully.']")
	WebElement rosterGroupCreatedSuccessfullyMsg;
	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement btnEdit;
	@FindBy(xpath = "//div[text()='Roster Group Updated SuccessFully.']")
	WebElement rosterGroupUpdatedSuccessFullyMsg;
	@FindBy(xpath = "//div[text()='Successfully moved employee(s) to current Roster Group']")
	WebElement SuccessfullyMovedEmployeeToCurrentRosterGroup;

	@FindBy(xpath = "//button[@id='btnDeleteRosterGroup']")
	WebElement btnDeleteRosterGroup;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;
	@FindBy(xpath = "//div[text()='Selected RosterGroup deleted successfully.']")
	WebElement rosterGroupDeletedSuccessfullyMsg;

	@FindBy(xpath = "//span[text()='IsActive?']")
	WebElement checkBoxIsActive;
	@FindBy(xpath = "//tbody[@id='currentRosterGroupTableBody']/tr//td[@class='align-middle py-3']")
	List<WebElement> checkboxNonMembers;
	@FindBy(xpath = "(//td[@class='font-weight-bold align-middle py-3'])[2]")
	WebElement clickonAlignMiddleRemove;

	@FindBy(xpath = "//a[@data-item='RemoveSelected']")
	WebElement removeSelectedItem;

	@FindBy(xpath = "//span[@id='select2-cmbRosterPattern-container']")
	WebElement selectRosterPattern;

	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement chooseRosterPattern;

	@FindBy(xpath = "//button[@id='btnSubmitChanges']")
	WebElement btnSubmitChanges;
	@FindBy(xpath = "//button[@id='btnCloseRosterPattern']")
	WebElement btnCloseRosterPattern;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement txtSearch;

	public E10_2909_EmpAdmRosterGroupAssignmentPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver= driver ;
		this.Rc= new ReusableComponent(driver);

	}


	public void enableCheckboxesMember(int count) 
	{
		// The logic for selecting the required number of employees has to be move.
		for (int i = 0; i < count && i < checkboxesMembers.size(); i++) {
			checkboxesMembers.get(i).click();
		}
	}

	public void enableCheckboxNonMembers(int count) 
	{
		// The logic for selecting the required number of employees has to be move.
		for (int i = 0; i < count && i < checkboxNonMembers.size(); i++) {
			checkboxNonMembers.get(i).click();
		}
	}

	public void createRosterGroupAssignment() throws Exception 
	{
		RosterGroupname = Rc.name;
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "Employee Administration", "Employee Administration is not clicked");
		Rc.explicitWait(rosterGroupAssignment, "clickable");
		rosterGroupAssignment.click();
		Rc.explicitWait(btnAddRosterGroup, "clickable");
		btnAddRosterGroup.click();
		Rc.explicitWait(txtRosterGroupname, "visible");
		txtRosterGroupname.clear();
		txtRosterGroupname.sendKeys(RosterGroupname);
		txtRosterGroupDesc.clear();
		txtRosterGroupDesc.sendKeys(Rc.description);
		txtRemarks.clear();
		txtRemarks.sendKeys(Rc.description);
		Rc.scrollDown();
		enableCheckboxesMember(2);
		Rc.scrollUp();
		Rc.moveToElement(clickonAlignMiddle);
		clickonAlignMiddle.click();
		addSelectedItem.click();
		Rc.scrollDown();
		Rc.moveToElement(btnSaveRosterGroup);
		btnSaveRosterGroup.click();
		String actualResult = rosterGroupCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Roster Group Created Successfully."));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
	}


	public void updateRosterGroupAssignment() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visible");
		txtSearch.clear();
		txtSearch.clear();
		txtSearch.sendKeys(RosterGroupname);
		btnEdit.click();
		Rc.explicitWait(txtRosterGroupname, "visible");
		txtRosterGroupname.clear();
		txtRosterGroupname.sendKeys(RosterGroupname+ System.currentTimeMillis());
		txtRosterGroupDesc.clear();
		txtRosterGroupDesc.sendKeys(Rc.description);
		txtRemarks.clear();
		txtRemarks.sendKeys(Rc.description);
		Rc.explicitWait(btnSaveRosterGroup, "clickable");
		Rc.moveToElement(btnSaveRosterGroup);
		btnSaveRosterGroup.click();
		String actualResult = rosterGroupUpdatedSuccessFullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Roster Group Updated SuccessFully."));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
	}

	public void deleteRosterGroupAssignment() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visible");
		txtSearch.clear();
		txtSearch.sendKeys(RosterGroupname);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.moveToElement(btnDeleteRosterGroup);
		btnDeleteRosterGroup.click();
		Rc.explicitWait(btnYes, "clickable");
		btnYes.click();
		Rc.explicitWait(rosterGroupDeletedSuccessfullyMsg, "visible");
		String actualResult = rosterGroupDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Selected RosterGroup deleted successfully."));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
	}

	public void reactivateRosterGroupAssignmentx() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visible");
		txtSearch.clear();
		txtSearch.sendKeys(RosterGroupname);
		Rc.explicitWait(btnEdit, "clickable");
		btnEdit.click();
		Thread.sleep(2000);
		Rc.explicitWait(checkBoxIsActive, "clickable");
		checkBoxIsActive.click();
		Rc.moveToElement(btnSaveRosterGroup);
		btnSaveRosterGroup.click();
		Rc.explicitWait(rosterGroupUpdatedSuccessFullyMsg, "visible");
		String actualResult = rosterGroupUpdatedSuccessFullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Roster Group Updated SuccessFully."));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
	}

	public void AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(txtSearch, "visible");
		txtSearch.clear();
		txtSearch.sendKeys("Darell Morissette");
		btnEdit.click();
		Rc.explicitWait(txtRosterGroupDesc, "visible");
		txtRosterGroupDesc.clear();
		txtRosterGroupDesc.sendKeys(Rc.description);
		txtRemarks.clear();
		txtRemarks.sendKeys(Rc.description);
		Rc.scrollDown();
		enableCheckboxesMember(1);
		Rc.scrollUp();
		Rc.moveToElement(clickonAlignMiddle);
		clickonAlignMiddle.click();
		addSelectedItem.click();
		btnYes.click();
		enableCheckboxNonMembers(1);
		clickonAlignMiddleRemove.click();
		removeSelectedItem.click();
		Rc.scrollDown();
		Rc.moveToElement(btnSaveRosterGroup);
		btnSaveRosterGroup.click();
		Rc.moveToElement(selectRosterPattern);
		selectRosterPattern.click();
		chooseRosterPattern.click();
		Rc.explicitWait(btnSubmitChanges, "clickable");
		btnSubmitChanges.click();
		Rc.explicitWait(SuccessfullyMovedEmployeeToCurrentRosterGroup, "visible");
		String actualResult = SuccessfullyMovedEmployeeToCurrentRosterGroup.getText();
		Assert.assertTrue(actualResult.contains("Successfully moved employee(s) to current Roster Group"));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
	}
}
