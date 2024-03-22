package com.AutomationJiviewsPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ReusableComponent;

public class SystemDefination_RolePage {


	WebDriver driver ;
	ReusableComponent Rc;
	Actions action;
	Select select;
	String roleNameData;

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
	List<WebElement> sideNavMenu; // Roles

	// ********** Role Locator *****

	@FindBy(xpath = "//button[@id='btnAddNew']/span")
	WebElement addBtn;

	@FindBy(xpath = "//input[@id='txtRoleName']")
	WebElement roleName;

	@FindBy(xpath = "//input[@id='txtRoleDescription']")
	WebElement roleDescription;

	@FindBy(xpath = "//input[@id='txtPrepareTime']")
	WebElement preparationTime;

	@FindBy(xpath = "//input[@id='txtDePreparetime']")
	WebElement depreparationTime;

	@FindBy(xpath = "//span[@id='select2-cmbPrimarySkillId-container']")
	WebElement selectPrimarySkillId; 

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement searchField;

	@FindBy(xpath = "(//li[contains(text(),'Auto')])[1]")
	WebElement selectSkillCode;

	@FindBy(xpath = "//input[@id='txtRolePrioritySeq']")
	WebElement roleWaightage;

	// it is from Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement availableSkill;

	// select for move signle skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle;

	//	select for move multiple skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	WebElement selectMoveAll;

	// it is from Seleceted Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	WebElement selectedSkill;

	//	select for move single skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	WebElement removeSelectedSkillSingle;

	//	select for move multiple skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	WebElement removeSelectedSkillAll;

	@FindBy(xpath = "//button[@id='btnSaveRolesDetails']/span")
	WebElement saveBTN;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement editBTN;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//li[@id='roles-list_next']")
	WebElement nextPage;



	@FindBy(xpath = "//button[@id='btnDeleteRoles']")
	WebElement btnDelete;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement clickYes;

	@FindBy(xpath = "//span[@class='custom-control-label']")
	WebElement isActive;

	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
	WebElement cancelBTN;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchColumns;

	@FindBy(xpath = "//th[text()='Role Name']")
	WebElement chanegRoleName;

	@FindBy(xpath = "//div[text()='Role Created Successfully']")
	WebElement roleCreatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Role Updated Successfully.']")
	WebElement roleUpdatedSuccessfullyMsg;
	@FindBy(xpath = "//label[text()='Role Code is reqired']")
	WebElement roleCodeErrorMsg;
	@FindBy(xpath = "//label[text()='Primary Skill is required']")
	WebElement primarySkillErrorMsg;
	@FindBy(xpath = "//label[text()='Role Description is required']")
	WebElement roleDescriptionErrorMsg;
	
	//  ****** Constructor ******
	public SystemDefination_RolePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver ;
		this.Rc= new ReusableComponent(driver);
		this.action=new Actions(driver);
	}



	public void createNewRole() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Roles", "Roles is not clicked");

		roleNameData =Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();
		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);
		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);
		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);
		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);
		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();
		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();
		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);
		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
		action.moveToElement(saveBTN).perform();
		saveBTN.click();
		Rc.explicitWait(roleCreatedSuccessfullyMsg, "clickable");
		String actualResult = roleCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Created Successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void editRole() throws Exception 
	{
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(roleNameData);
		Rc.explicitWait(editBTN, "clickable");
		editBTN.click();
//		action.moveToElement(roleName).perform();
//		Rc.explicitWait(roleName, "clickable");
//		roleName.clear();
//		roleName.sendKeys(Rc.name);
//		roleDescription.clear();
//		roleDescription.sendKeys(Rc.description);
//		preparationTime.clear();
//		preparationTime.sendKeys(Rc.randomInt);
//		depreparationTime.clear();
//		depreparationTime.sendKeys(Rc.randomInt);
//		action.moveToElement(selectPrimarySkillId).perform();
//		selectPrimarySkillId.click();
//		action.scrollToElement(selectSkillCode).perform();
//		selectSkillCode.click();
		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);
		action.moveToElement(saveBTN).perform();
		saveBTN.click();
		Rc.explicitWait(roleUpdatedSuccessfullyMsg, "visibility");
		String actualResult = roleUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Updated Successfully."));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void deleteRole() throws InterruptedException 
	{
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(roleNameData);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.explicitWait(btnDelete, "clickable");
		btnDelete.click();
		Rc.explicitWait(clickYes, "clickable");
		clickYes.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void reactiveRole() throws InterruptedException 
	{
		Thread.sleep(2000);
		Rc.explicitWait(editBTN, "clickable");
		editBTN.click();
		Rc.explicitWait(isActive, "clickable");
		isActive.click();
		action.moveToElement(saveBTN).perform();
		saveBTN.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void setCreateNewRoleWithoutPriarySkill() throws Exception 
	{

		roleNameData =Rc.name;
		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();
		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);
		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);
		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);
		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		//		*** Without Primary Skill ***
		//		selectPrimarySkillId.click();
		//		action.scrollToElement(selectSkillCode).perform();
		//		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);

		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(primarySkillErrorMsg, "visibility");
		String actualResult = primarySkillErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Primary Skill is required"));

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();


	}


	public void setCreateNewRoleWithoutRoleCode() throws Exception {
		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		//		*** Without Role Name ***
		//		Rc.explicitWait(roleName, "clickable");
		//		roleName.clear();
		//		roleName.sendKeys(roleNameData);

		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);

		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(roleCodeErrorMsg, "visibility");
		String actualResult = roleCodeErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Code is reqired"));

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}
	public void setCreateNewRoleWithoutRoleDescription() throws Exception {

		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);

		//		*** Without role Description ***
		//		roleDescription.clear();
		//		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);

		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(roleDescriptionErrorMsg, "visibility");
		String actualResult = roleDescriptionErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Description is required"));

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();


	}
	public void setCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {


		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);

		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);

		action.moveToElement(saveBTN).perform();
		saveBTN.click();


		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();


	}
	// All Availble skiil should move to secondary skill
	public void setCreateNewRoleWithAllAvailableSkill() throws Exception {

		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);

		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		availableSkill.click();

		action.moveToElement(selectMoveAll).perform();
		selectMoveAll.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();


	}
	public void setDisSelectSingleSkillFromSelectedSkill() throws Exception {

		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);

		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(1);

		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();

		action.scrollToElement(selectedSkill).perform();
		select = new Select(selectedSkill);
		select.selectByIndex(1);

		action.moveToElement(removeSelectedSkillSingle).perform();
		removeSelectedSkillSingle.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void setDisselectAllAvailableSkill() throws Exception {
		roleNameData =Rc.name;

		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();

		Rc.explicitWait(roleName, "clickable");
		roleName.clear();
		roleName.sendKeys(roleNameData);

		roleDescription.clear();
		roleDescription.sendKeys(Rc.description);

		preparationTime.clear();
		preparationTime.sendKeys(Rc.randomInt);

		depreparationTime.clear();
		depreparationTime.sendKeys(Rc.randomInt);

		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();

		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();

		roleWaightage.clear();
		roleWaightage.sendKeys(Rc.randomInt);

		action.scrollToElement(availableSkill).perform();
		availableSkill.click();

		action.moveToElement(selectMoveAll).perform();
		selectMoveAll.click();

		action.moveToElement(removeSelectedSkillAll).perform();
		removeSelectedSkillAll.click();

		action.moveToElement(saveBTN).perform();
		saveBTN.click();

		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void setSearchColumnsForRole() throws Exception {

		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(roleNameData);


	}
}
