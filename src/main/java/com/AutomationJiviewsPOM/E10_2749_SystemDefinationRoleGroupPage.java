package com.AutomationJiviewsPOM;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class E10_2749_SystemDefinationRoleGroupPage {

	WebDriver driver ;
	public String timeStamp = LocalDateTime.now().toString();
	public Actions action;
	public Select select;
	public WebUtilities webUtility;
	public ExcelUtilities excelUtility;
	public E10_2749_SystemDefinationRoleGroupPage sdrg;


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
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='RoleGroup-list_next']")
	private WebElement nextPage;
	
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
	
	

	public E10_2749_SystemDefinationRoleGroupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
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

    public void performDeleteAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteRoleGroup);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		
		// Iterate through rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
//				scrollAndClick(driver, checkbox);
				checkbox.click();
				performDeleteAction();
				checkboxFound = true;
				break;
			}
		}

		// If no enabled checkbox found on the current page, go to the next page and try again
		if (!checkboxFound) {
			goToNextPageAndDelete();
		}
	}

	private void goToNextPageAndDelete() throws InterruptedException {
		try {
			scrollAndClick(driver, nextPage); // Click on the next page button
			scrollUp(driver);
			deleteRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page
			
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}
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
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        clickAddRoleGroup();
        enterRoleGroupName(roleGrpName);
        selectAvailableShiftBand();
        moveSingleAvailableSkillToSelected();
        clickBtnSaveRoleGroupDtls();
        clickNotificationPopup();
    }

    public void updateRolesGroup() throws Exception {
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 24, 7);

        clickBtnEdit();
        enterRoleGroupName(roleGrpName);
        selectAvailableShiftBand();
        moveSingleAvailableSkillToSelected();
        clickBtnSaveRoleGroupDtls();
//        clickNotificationPopup();
    }

    public void deactivateRoleGroup() throws Exception {

        deleteRowsWithEnabledCheckbox();
        clickBtnYes();
        clickNotificationPopup();
    }

    public void createRoleGrpWithoutAvailableRole() throws Exception {
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        clickAddRoleGroup();
        enterRoleGroupName(roleGrpName);
        clickBtnSaveRoleGroupDtls();
        clickNotificationPopup();
    }

    public void searchRoleGroup() throws Exception {
        String roleGrpName = excelUtility.readDataFromExcelFile("EmployeeTest", 23, 7);

        enterTxtSearch(roleGrpName);
    }

    public void createRoleGrpWithoutRoleGrpName() throws Exception {

        clickAddRoleGroup();
        Thread.sleep(1000);
        selectAvailableShiftBand();
        moveSingleAvailableSkillToSelected();
        clickBtnSaveRoleGroupDtls(); 
        assertTxtGrpNmRequired();
    }
    
}
