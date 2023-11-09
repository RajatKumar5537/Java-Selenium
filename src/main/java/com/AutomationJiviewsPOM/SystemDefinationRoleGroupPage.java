package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class SystemDefinationRoleGroupPage extends BaseClass{

	public String timeStamp = LocalDateTime.now().toString();
	public Actions action;
	public Select select;
	public WebUtilities webUtility;
	public ExcelUtilities excelUtility;
	public SystemDefinationRoleGroupPage sdrg;


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

	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1'])[2]")
	private WebElement btnEdit;

	@FindBy(xpath = "(//tr[@role='row']/td/input)[2]")
	private WebElement checkBox;

	@FindBy(xpath = "//button[@id='btnDeleteRoleGroup']")
	private WebElement btnDeleteRoleGroup;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//label[text()='Role Group Name is required']")
	private WebElement txtGrpNmRequired;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement txtSearch;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	public SystemDefinationRoleGroupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
		this.excelUtility= new ExcelUtilities();
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

    public void clickCheckbox() {
        checkBox.click();
    }

    public void clickBtnDeleteRoleGroup() {
        btnDeleteRoleGroup.click();
    }

    public void clickBtnYes() {
        btnYes.click();
    }

    public void clickNotificationPopup() throws Exception {
        action.moveToElement(notificationPopup).perform();
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

    public void createRolesGroup() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        sdrg.clickAddRoleGroup();
        sdrg.enterRoleGroupName(roleGrpName);
        sdrg.selectAvailableShiftBand();
        sdrg.moveSingleAvailableSkillToSelected();
        sdrg.clickBtnSaveRoleGroupDtls();
        sdrg.clickNotificationPopup();
    }

    public void updateRolesGroup() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 24, 7);

        sdrg.clickBtnEdit();
        sdrg.enterRoleGroupName(roleGrpName);
        Thread.sleep(1000);
        sdrg.clickBtnSaveRoleGroupDtls();
        sdrg.clickNotificationPopup();
    }

    public void deactivateRoleGroup() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);

        sdrg.clickCheckbox();
        sdrg.clickBtnDeleteRoleGroup();
        sdrg.clickBtnYes();
        sdrg.clickNotificationPopup();
    }

    public void createRoleGrpWithoutAvailableRole() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        sdrg.clickAddRoleGroup();
        sdrg.enterRoleGroupName(roleGrpName);
        sdrg.clickBtnSaveRoleGroupDtls();
        sdrg.clickNotificationPopup();
    }

    public void searchRoleGroup() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        sdrg.enterTxtSearch(roleGrpName);
    }

    public void createRoleGrpWithoutRoleGrpName() throws Exception {
        sdrg = new SystemDefinationRoleGroupPage(driver);

        sdrg.clickAddRoleGroup();
        Thread.sleep(1000);
        sdrg.selectAvailableShiftBand();
        sdrg.moveSingleAvailableSkillToSelected();
        sdrg.clickBtnSaveRoleGroupDtls();
        sdrg.assertTxtGrpNmRequired();
    }
    
    /*
	public void setBtnAddRoleGroup() {
		btnAddRoleGroup.click();
	}
	public void setTxtRoleGroupName(String roleGrpName)  { 
		webUtility.ElementClickable(driver, txtRoleGroupName);
		txtRoleGroupName.clear();
		txtRoleGroupName.sendKeys(roleGrpName+" "+ timeStamp);;
	}
	public void setAvailableShiftBand() {
		//		action.scrollToElement(availableRoles).perform();
		//		//availableShiftBand.click();
		//		select=new Select(availableRoles);
		//		select.selectByValue("109");

		action.scrollToElement(availableRoles).perform();
		select = new Select(availableRoles);
		//		List<WebElement> options = select.getOptions();
		//		// Generate a random index between 0 and the number of options minus 1
		//		Random rand = new Random();
		//		int randomIndex = rand.nextInt(options.size());
		// Select the option at the random index
		select.selectByIndex(1);
	}
	public void setSelectMoveSingle() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}
	public void setSelectMoveAll() {
		selectMoveAll.click();
	}
	public void setSelectedSkill() {
		selectedSkill.click();
	}
	public void setRemoveSelectedSkillSingle() {
		removeSelectedSkillSingle.click();
	}
	public void setRemoveSelectedSkillAll() {
		removeSelectedSkillAll.click();
	}

	public void setBtnEdit() {
		webUtility.moveToElement(driver, btnEdit);
		btnEdit.click();
	}
	public void setBtnSaveRoleGroupDtls() {
		webUtility.moveToElement(driver, btnSaveRoleGroupDtls);
		btnSaveRoleGroupDtls.click();
	}
	public void setCheckbox() {
		checkBox.click();
	}
	public void setBtnDeleteRoleGroup() {
		btnDeleteRoleGroup.click();
	}
	public void setbtnYes() {
		btnYes.click();
	}
	public void setNotificationPopup() throws Exception {
		//		webUtility.visibilityOfElement(driver, notificationPopup);
		action.moveToElement(notificationPopup).perform();
		notificationPopup.click();
	}

	public void setTxtGrpNmRequired() {
		String actualResult = txtGrpNmRequired.getText();
		Assert.assertTrue(actualResult.contains("Role Group Name is required"));
	}
	public void setTxtSearch(String roleGrpName) {
		txtSearch.sendKeys(roleGrpName);
		txtSearch.sendKeys(Keys.ENTER);
	}

	public void setCreateRolesGroup() throws Exception  {
		sdrg= new SystemDefinationRoleGroupPage(driver);
		String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

		sdrg.setBtnAddRoleGroup();
		sdrg.setTxtRoleGroupName(roleGrpName);
		sdrg.setAvailableShiftBand();
		sdrg.setSelectMoveSingle();
		sdrg.setBtnSaveRoleGroupDtls();
		sdrg.setNotificationPopup();

	}

	public void setUpdateRolesGroup() throws Exception {
		sdrg= new SystemDefinationRoleGroupPage(driver);
		String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 24, 7);
		//		sdrg.setNotificationPopup();
		sdrg.setBtnEdit();
		sdrg.setTxtRoleGroupName(roleGrpName);
		Thread.sleep(1000);
		sdrg.setBtnSaveRoleGroupDtls();
		sdrg.setNotificationPopup();
	}
	public void setDeactivateRoleGroup() throws Exception {
		sdrg= new SystemDefinationRoleGroupPage(driver);

		//		sdrg.setNotificationPopup();
		sdrg.setCheckbox();
		sdrg.setBtnDeleteRoleGroup();
		sdrg.setbtnYes();
		sdrg.setNotificationPopup();
	}
	public void setCreateRoleGrpWithoutAvailableRole() throws Exception {
		sdrg= new SystemDefinationRoleGroupPage(driver);
		String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

		sdrg.setBtnAddRoleGroup();
		sdrg.setTxtRoleGroupName(roleGrpName);
		sdrg.setBtnSaveRoleGroupDtls();
		sdrg.setNotificationPopup();

	}
	public void setSearchRoleGroup() throws Exception {
		sdrg= new SystemDefinationRoleGroupPage(driver);
		String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

		//		sdrg.setNotificationPopup();
		sdrg.setTxtSearch(roleGrpName);
	}


	public void setCreateRoleGrpWithoutRoleGrpName() throws Exception {
		sdrg= new SystemDefinationRoleGroupPage(driver);

		//		sdrg.setNotificationPopup();
		sdrg.setBtnAddRoleGroup();
		Thread.sleep(1000);
		sdrg.setAvailableShiftBand();
		sdrg.setSelectMoveSingle();
		sdrg.setBtnSaveRoleGroupDtls();
		sdrg.setTxtGrpNmRequired();
	}*/
}
