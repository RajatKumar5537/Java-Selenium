package com.AutomationJiviewsPOM;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.ReusableComponent;
import com.AutomationJiviewsGeneric.WebUtilities;

public class E10_2749_SystemDefinationRoleGroupPage {

	public WebDriver driver ;
	ReusableComponent Rc ;

	public String timeStamp = LocalDateTime.now().toString();
	public Actions action ;
	public Select select;
	public WebUtilities webUtility;
	public ExcelUtilities excelUtility;
	public E10_2749_SystemDefinationRoleGroupPage sdrg;
	String roleGrpName;



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


	public E10_2749_SystemDefinationRoleGroupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
		this.Rc= new ReusableComponent(driver);


		this.excelUtility= new ExcelUtilities();
		this.action= new Actions(driver);
		this.webUtility= new WebUtilities(driver);
	}
	public void clickAddRoleGroup() {
		btnAddRoleGroup.click();
	}

	public void enterRoleGroupName(String roleGrpName) {
		webUtility.ElementClickable(driver, txtRoleGroupName);
		txtRoleGroupName.clear();
		txtRoleGroupName.sendKeys(roleGrpName + " " + timeStamp);
	}

	public void selectAvailableShiftBand() {
		action.scrollToElement(availableRoles).perform();
		select = new Select(availableRoles);
		select.selectByIndex(1);
	}

	public void moveSingleAvailableSkillToSelected() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	public void moveAllAvailableSkillsToSelected() {
		selectMoveAll.click();
	}

	public void clickSelectedSkill() {
		selectedSkill.click();
	}

	public void removeSelectedSkillSingle() {
		removeSelectedSkillSingle.click();
	}

	public void removeSelectedSkillAll() {
		removeSelectedSkillAll.click();
	}

	public void clickBtnEdit() {
		webUtility.moveToElement(driver, btnEdit);
		btnEdit.click();
	}

	public void clickBtnSaveRoleGroupDtls() {
		webUtility.moveToElement(driver, btnSaveRoleGroupDtls);
		btnSaveRoleGroupDtls.click();
	}

	public void performDeleteAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteRoleGroup);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	//	public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
	//		boolean checkboxFound = false;
	//
	//		// Iterate through rows
	//		for (int i = 0; i < rows.size(); i++) {
	////			WebElement checkbox = checkboxes.get(i);
	////			if (checkbox.isEnabled()) {
	////				//				scrollAndClick(driver, checkbox);
	////				checkbox.click();
	//				performDeleteAction();
	//				checkboxFound = true;
	//				break;
	////			}
	//		}
	//
	//		// If no enabled checkbox found on the current page, go to the next page and try again
	//		if (!checkboxFound) {
	//			goToNextPageAndDelete();
	//		}
	//	}
	//
	//	private void goToNextPageAndDelete() throws InterruptedException {
	//		try {
	//			scrollAndClick(driver, nextPage); // Click on the next page button
	//			scrollUp(driver);
	//			deleteRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page
	//
	//		} catch (ElementClickInterceptedException e) {
	//			// Handle the exception if necessary
	//		}
	//	}
	// Method to perform scroll-up action
	private void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -150)"); // Adjust the scroll distance as needed
	}
	public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		element.click();
	}
	public void clickBtnDeleteRoleGroup() {
		btnDeleteRoleGroup.click();
	}

	public void clickBtnYes() {
		btnYes.click();
	}

	public void clickNotificationPopup() throws Exception {
		webUtility.ElementClickable(driver, notificationPopup);
		notificationPopup.click();
	}

	public void assertTxtGrpNmRequired() {
		String actualResult = txtGrpNmRequired.getText();
		Assert.assertTrue(actualResult.contains("Role Group Name is required"));
	}

	public void enterTxtSearch(String roleGrpName) {
		txtSearch.sendKeys(roleGrpName);
		txtSearch.sendKeys(Keys.ENTER);
	}

	public void createRolesGroup() throws Exception 
	{

		Rc.explicitWait(dvOrgUnitDropdown, "visibility");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicking");
		Rc.explicitWait(dvApplicationMenuItems, "visibility");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicking");
		Rc.explicitWait(ulApplicationMenu, "visibility");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Role Groups", "Role Groups is not clicking");


		roleGrpName = Rc.name;

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
		Rc.explicitWait(txtSearch, "visibility");
		Thread.sleep(2000);
		txtSearch.clear();
		txtSearch.sendKeys(roleGrpName);


		//    	webUtility.moveToElement(driver, btnEdit);
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
		Rc.explicitWait(txtSearch, "visibility");
		Thread.sleep(2000);
		txtSearch.clear();
		txtSearch.sendKeys(roleGrpName);
		Thread.sleep(2000);
		Rc.explicitWait(checkBox, "visibility");
		checkBox.click();
		btnDeleteRoleGroup.click();
		btnYes.click();

		String actualResult = shiftBandTypeDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Selected Shift Band Type deleted successfully."));

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void createRoleGrpWithoutAvailableRole() throws Exception 
	{

		roleGrpName = Rc.firstName;

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

		//		Rc.explicitWait(txtRoleGroupName, "visibility");
		//		txtRoleGroupName.clear();
		//		txtRoleGroupName.sendKeys(roleGrpName + " " + System.currentTimeMillis());
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
