package com.AutomationJiviewsPOM;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;

public class E10_2909_EmpAdmRosterGroupAssignmentPage extends BaseClass {
	Select select;
	public Actions action;
	HomePage homePage = new HomePage(driver);
	OrganizationUnitDropDown orgUnit = new OrganizationUnitDropDown(driver);
	jiviewsMainMenuItems jmMenuItem = new jiviewsMainMenuItems(driver);
	RosterSetupPage rosterSetup = new RosterSetupPage(driver);;
	E10_2608_SystemDefinationRosterCreationPage rosterCreation = new E10_2608_SystemDefinationRosterCreationPage(driver);
	EmployeeAdminstrationPage empAdmin = new EmployeeAdminstrationPage(driver);

	@FindBy(xpath = "//button[@id='btnAddRosterGroup']")
	private WebElement btnAddRosterGroup;
	@FindBy(xpath = "//input[@id='txtRosterGroupname']")
	private WebElement txtRosterGroupname;
	@FindBy(xpath = "//input[@id='txtRosterGroupDesc']")
	private WebElement txtRosterGroupDesc;
	@FindBy(xpath = "//input[@id='txtRemarks']")
	private WebElement txtRemarks;

	@FindBy(xpath = "//table[@id='availableEmpListDataTable']")
	private WebElement availableEmpListDataTable;
	@FindBy(xpath = "//td[@class='align-middle py-3']")
	private List<WebElement> checkboxesMembers;;

	@FindBy(xpath = "//table[@id='RosterGroup-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxesForDlt;
	@FindBy(xpath = "//li[@id='RosterGroup-list_next']")
	private WebElement nextPage;

	@FindBy(xpath = "(//td[@class='font-weight-bold align-middle py-3'])[1]")
	private WebElement clickonAlignMiddle;
	@FindBy(xpath = "//a[@data-item='AddSelected']")
	private WebElement addSelectedItem;
	@FindBy(xpath = "//button[@id='btnSaveRosterGroup']")
	private WebElement btnSaveRosterGroup;
	@FindBy(xpath = "//div[text()='Roster Group Created Successfully.']")
	private WebElement rosterGroupCreatedSuccessfullyMsg;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement btnEdit;
	@FindBy(xpath = "//div[text()='Roster Group Updated SuccessFully.']")
	private WebElement rosterGroupUpdatedSuccessFullyMsg;
	@FindBy(xpath = "//div[text()='Successfully moved employee(s) to current Roster Group']")
	private WebElement SuccessfullyMovedEmployeeToCurrentRosterGroup;

	@FindBy(xpath = "//button[@id='btnDeleteRosterGroup']")
	private WebElement btnDeleteRosterGroup;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(xpath = "//div[text()='Selected RosterGroup deleted successfully.']")
	private WebElement rosterGroupDeletedSuccessfullyMsg;

	@FindBy(xpath = "//span[text()='IsActive?']")
	private WebElement checkBoxIsActive;
	@FindBy(xpath = "//tbody[@id='currentRosterGroupTableBody']/tr//td[@class='align-middle py-3']")
	private List<WebElement> checkboxNonMembers;
	@FindBy(xpath = "(//td[@class='font-weight-bold align-middle py-3'])[2]")
	private WebElement clickonAlignMiddleRemove;

	@FindBy(xpath = "//a[@data-item='RemoveSelected']")
	private WebElement removeSelectedItem;

	@FindBy(xpath = "//span[@id='select2-cmbRosterPattern-container']")
	private WebElement selectRosterPattern;

	@FindBy(xpath = "//li[contains(text(),'2323')]")
	private WebElement chooseRosterPattern;

	@FindBy(xpath = "//button[@id='btnSubmitChanges']")
	private WebElement btnSubmitChanges;
	@FindBy(xpath = "//button[@id='btnCloseRosterPattern']")
	private WebElement btnCloseRosterPattern;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement txtSearch;

	public E10_2909_EmpAdmRosterGroupAssignmentPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
	}

	public void clickBtnAddRosterGroup() {
		webUtility.ElementClickable(driver, btnAddRosterGroup);
		btnAddRosterGroup.click();
	}

	public void enterTxtRosterGroupname(String RosterGroupname) {
		txtRosterGroupname.clear();
		txtRosterGroupname.sendKeys(RosterGroupname);
		// Print the value of txtRosterGroupname
		String RosterGroupName = txtRosterGroupname.getAttribute("value");
		Reporter.log("Entered Roster Group Name: " + RosterGroupName, true);
	}

	public void enterTxtRosterGroupDesc(String RosterGroupDesc) {
		txtRosterGroupDesc.clear();
		txtRosterGroupDesc.sendKeys(RosterGroupDesc);
	}

	public void enterTxtRemarks(String Remarks) {
		txtRemarks.clear();
		txtRemarks.sendKeys(Remarks);
	}

	public void performAvailableEmpListDataTable() {
		webUtility.moveToElement(driver, availableEmpListDataTable);
	}

	public void enableCheckboxesMember(int count) {
		for (int i = 0; i < count && i < checkboxesMembers.size(); i++) {
			checkboxesMembers.get(i).click();
		}
	}

	public void enableCheckboxNonMembers(int count) {
		for (int i = 0; i < count && i < checkboxNonMembers.size(); i++) {
			checkboxNonMembers.get(i).click();
		}
	}

	public void clickonAlignMiddleSelect() {
		clickonAlignMiddle.click();
	}

	public void clickonAddSelectedItem() {
		addSelectedItem.click();
	}

	public void clickonAlignMiddleRemove() {
		clickonAlignMiddleRemove.click();
	}

	public void clickonRemoveSelectedItem() {
		removeSelectedItem.click();
	}

	public void clickonBtnSaveRosterGroup() {
		webUtility.scrollAndClick(driver, btnSaveRosterGroup);
	}

	public void clickBtnEdit() {
		btnEdit.click();
	}

	public void performDeleteAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				webUtility.scrollAndClick(driver, btnDeleteRosterGroup);
				break;
			} catch (ElementClickInterceptedException e) {
			}
		}
	}

	public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxesForDlt.get(i);
			if (checkbox.isEnabled()) {
				// scrollAndClick(driver, checkbox);
				checkbox.click();
				performDeleteAction();
				checkboxFound = true;
				break;
			}
		}
		if (!checkboxFound) {
			goToNextPageAndDelete();
		}
	}

	private void goToNextPageAndDelete() throws InterruptedException {
		try {
			webUtility.scrollAndClick(driver, nextPage);
			// scrollAndClick(driver, nextPage);
			webUtility.scrollUp(driver);
			// scrollUp(driver);
			deleteRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page

		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}

	public void enableCheckBoxIsActive() throws InterruptedException {
		checkBoxIsActive.click();

	}

	public void reactivateRowsWithEnabledCheckbox() throws Exception {
		boolean checkboxFound = false;
		// Iterate through rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxesForDlt.get(i);
			if (!checkbox.isEnabled()) {
				clickBtnEdit();
				Thread.sleep(2000);
				enableCheckBoxIsActive();
				clickonBtnSaveRosterGroup();
				checkRosterGroupUpdatedSuccessFullyMsg();
				clickNotificationPopup();
				checkboxFound = true;
				break;
			}
		}

		// If no enabled checkbox found on the current page, go to the next page and try
		// again
		if (!checkboxFound) {
			goToNextPageAndReactivate();
		}
	}

	private void goToNextPageAndReactivate() throws Exception {
		try {
			webUtility.scrollAndClick(driver, nextPage);
			webUtility.scrollUp(driver);
			reactivateRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}

	public void clickonBtnYes() {
		btnYes.click();
	}

	public void clickonBtnCloseRosterPattern() {
		btnCloseRosterPattern.click();
	}

	public void clickNotificationPopup() throws Exception {
		Thread.sleep(1000);
		action.moveToElement(notificationPopup).perform();
		notificationPopup.click();
	}

	public void enterTxtSearch() {
		txtSearch.sendKeys("2323");
	}

	public void clickonSelectRosterPattern() {
		// selectRosterPattern.click();
		action.moveToElement(selectRosterPattern).perform();
		selectRosterPattern.click();
		// select= new Select(selectRosterPattern);
		// select.selectByIndex(0);
		chooseRosterPattern.click();
	}

	public void clickonBtnSubmitChanges() {
		btnSubmitChanges.click();
	}

	public void checkRosterGroupCreatedSuccessfullyMsg() {
		String actualResult = rosterGroupCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Roster Group Created Successfully."));
	}

	public void checkRosterGroupUpdatedSuccessFullyMsg() {
		String actualResult = rosterGroupUpdatedSuccessFullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Roster Group Updated SuccessFully."));
	}

	public void checkRosterGroupDeletedSuccessfullyMsg() {
		String actualResult = rosterGroupDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Selected RosterGroup deleted successfully."));
	}

	public void checkSuccessfullyMovedEmployeeToCurrentRosterGroup() {
		String actualResult = SuccessfullyMovedEmployeeToCurrentRosterGroup.getText();
		Assert.assertTrue(actualResult.contains("Successfully moved employee(s) to current Roster Group"));
	}

	public void createRosterGroupAssignment(FakeEmployee fakeEmployee) throws Exception {
		Thread.sleep(2000);
		clickBtnAddRosterGroup();
		enterTxtRosterGroupname(fakeEmployee.getRosterGroupName());
		enterTxtRosterGroupDesc(fakeEmployee.getRosterGroupDescription());
		enterTxtRemarks(fakeEmployee.getDescription());
		// Scroll down to make sure the checkbox is in view
		webUtility.scrollDown(driver);

		// performAvailableEmpListDataTable();
		enableCheckboxesMember(2);
		webUtility.scrollUp(driver);
		clickonAlignMiddleSelect();
		clickonAddSelectedItem();
		// Scroll down before clicking on Save Roster Group
		webUtility.scrollDown(driver);
		clickonBtnSaveRosterGroup();
		checkRosterGroupCreatedSuccessfullyMsg();
		clickNotificationPopup();
	}

	String timestamp = new SimpleDateFormat("HHmmss").format(new Date(0));

	public void updateRosterGroupAssignment(FakeEmployee fakeEmployee) throws Exception {
		clickBtnEdit();
		enterTxtRosterGroupname(fakeEmployee.getRosterGroupName() + timestamp);
		enterTxtRosterGroupDesc(fakeEmployee.getRosterGroupDescription());
		enterTxtRemarks(fakeEmployee.getDescription());
		clickonBtnSaveRosterGroup();
		checkRosterGroupUpdatedSuccessFullyMsg();
		clickNotificationPopup();
	}

	public void deleteRosterGroupAssignment() throws Exception {
		deleteRowsWithEnabledCheckbox();
		clickonBtnYes();
		checkRosterGroupDeletedSuccessfullyMsg();
		clickNotificationPopup();
	}

	public void reactivateRosterGroupAssignmentx() throws Exception {
		reactivateRowsWithEnabledCheckbox();
		// clickonBtnSaveRosterGroup();
	}

	public void AddEmployeesNonMembersToMembersAndRemoveFromMembersToNonMember() throws Exception {
		/*
		 * create a new Roster Group and save 
		 * 
		 * clickBtnAddRosterGroup();
		 * enterTxtRosterGroupname(fakeEmployee.getRosterGroupName());
		 * enterTxtRosterGroupDesc(fakeEmployee.getRosterGroupDescription());
		 * enterTxtRemarks(fakeEmployee.getDescription()); // Scroll down to make sure
		 * the checkbox is in view webUtility.scrollDown(driver); //
		 * performAvailableEmpListDataTable(); enableCheckboxesMember(2);
		 * webUtility.scrollUp(driver); clickonAlignMiddleSelect();
		 * clickonAddSelectedItem(); // Scroll down before clicking on Save Roster Group
		 * webUtility.scrollDown(driver); clickonBtnSaveRosterGroup();
		 * clickNotificationPopup();
		 * 
		 * set the Roster pattern for newly created Roster group 
		 * 
		 * driver.navigate().refresh(); homePage.setOrgUnit(); orgUnit.clickOLMop();
		 * homePage.setOrgUnit(); orgUnit.setAutoOu();
		 * jmMenuItem.clickOnSystemDefination(); rosterSetup.setRosterCreation();
		 * rosterCreation.setCreateRoasterwithGroup(); clickNotificationPopup();
		 * driver.navigate().refresh(); homePage.setOrgUnit(); orgUnit.clickOLMop();
		 * homePage.setOrgUnit(); orgUnit.setAutoOu();
		 * jmMenuItem.setEmployeeAdministration(); empAdmin.setRosterGroupAssignment();
		 */

		enterTxtSearch();
		clickBtnEdit();
		// enterTxtRosterGroupname(fakeEmployee.getRosterGroupName());
		enterTxtRosterGroupDesc(fakeEmployee.getRosterGroupDescription());
		enterTxtRemarks(fakeEmployee.getDescription());
		webUtility.scrollDown(driver);
		enableCheckboxesMember(1);
		webUtility.scrollUp(driver);
		clickonAlignMiddleSelect();
		clickonAddSelectedItem();
		clickonBtnYes();
		enableCheckboxNonMembers(1);
		clickonAlignMiddleRemove();
		clickonRemoveSelectedItem();
		webUtility.scrollDown(driver);
		clickonBtnSaveRosterGroup();
		clickonSelectRosterPattern();
		clickonBtnSubmitChanges();
		checkSuccessfullyMovedEmployeeToCurrentRosterGroup();
		clickNotificationPopup();

	}
}
