package com.AutomationJiviewsPOM;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
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

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;


public class E10_2608_SystemDefinationRosterCreationPage extends BaseClass{

	public String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss")).replace(" ", "_");
	Actions action= new Actions(driver);
	Select select;
	public ExcelUtilities excelUtility;
	public WebUtilities webUtility;
	public E10_2608_SystemDefinationRosterCreationPage sdrs;
	public String tampName ;
	public String tempDescription;
	public String noOfDay;
	public String noOfBlocks;

	@FindBy(xpath = "//div[text()='Roster Setup']/..")
	private WebElement RoasterSetup;
	@FindBy(xpath = "//div[text()='Roster Creation']/..")
	private WebElement rosterCreation;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement txtSearch;
	
	@FindBy(xpath = "//button[@id='btnAddNewTemplateRoster']")
	private WebElement addBtn;

	@FindBy(id = "txtTemplateName")
	private WebElement templateNameTxt;

	@FindBy(id = "txtTemplateDesc")
	private WebElement tempDescriptionTxt;

	@FindBy(id = "txtNumberOfDays")
	private WebElement noOfDayTxt;

	// Using for select Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableSkill;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle; 

	//	select for move multiple skill from available skill table to Selected skiil table 
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


	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement editBtn;

	// Group A 
	@FindBy(xpath = "(//div[text()='Off']/..)[1]")
	private WebElement rosterCreation1stDay;

	@FindBy(xpath = "//div[@class='scheduler_default_matrix']/div/div")
	private List<WebElement> rosterCreationDays;
	@FindBy(xpath = "//div[@style='text-align:center']")
	private List<WebElement> rosterCreationDaysFillUp;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div/div/div/div/div/div")
	private List<WebElement> fillCells;
	@FindBy(xpath = "//div[text()='Off']/..")
	private List<WebElement> emptyCells;

	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement 	bandCode;

	// in Band code search box need the select one shift from drop down box
	@FindBy(xpath = "(//li[contains(text(),'1st  Shift ')])[2]")
	private WebElement selectBandCode;

	@FindBy(xpath = "//button[@id='btnSelectShiftBand']")
	private WebElement btnSaveSelectShiftBandBtn;

	@FindBy(xpath = "//button[@id='btnAddSaveRosterPattern']/span")
	private WebElement btnAddSaveRosterPattern;

	@FindBy(xpath = "//button[@id='btnAddEmployee']/span")
	private WebElement btnAddEmployee;

	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableEmpTable;

	@FindBy(xpath = "(//button[@class='btn move btn-default'])[1]")
	private WebElement btnMoveFromAvailable;

	@FindBy(xpath = "//button[@id='btnSaveRosterTemplateEmployee']/span")
	private WebElement btnSaveRosterTemplateEmployee;

	@FindBy(xpath = "//button[@id='btnAddRosterGroups']/span")
	private WebElement btnAddRosterGroups;

	@FindBy(xpath = "//button[@id='btnSaveRosterTemplateRosterGroups']")
	private WebElement btnSaveRosterTemplateRosterGroups;

	@FindBy(xpath = "//div[text()='Template Roster updated successfully']")
	private WebElement templateRosterUpdatedSuccessfullyMsg;

	@FindBy(xpath = "//button[@id='btnPublishRosterPattern']")
	private WebElement btnPublishRosterPattern;



	//	@FindBy(xpath = "//input[@id='dtPublishFrom1130']")
	@FindBy(xpath = "//input[@class='form-control form-label-sm bootstrap-datepicker roster-pattern-from']")
	private WebElement txtPublishFrom;

	//	@FindBy(xpath = "//input[@id='txtNoOfBlocks1130']")
	@FindBy(xpath = "//input[@class='form-control roster-pattern-blocks']")
	private WebElement txtNoOfBlock;

	//	@FindBy(xpath = "(//td[@class='sorting_1']/input)[1]")
	//	private WebElement checkBoxPublishRoster;

	@FindBy(xpath = "//table[@id='extract-shift-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkBoxPublishRosterMulti;
	
	
	@FindBy(xpath = "//table[@id='template-roster-list']/tbody/tr")
	private List<WebElement> row;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='skill-list_next']")
	private WebElement nextPage;


	@FindBy(xpath = "(//td[@class='sorting_1']/input)[2]")
	private WebElement checkBoxPublishRoster2;

	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']")
	private WebElement btnSaveTemplateRoster;

	@FindBy(xpath = "//button[text()='Publish Now']")
	private WebElement btnPublishNow;
	@FindBy(xpath = "//div[text()='Shift extraction process completed successfully']")
	private WebElement shiftExtractionProcessCompletedSuccessfullyMsg;


	// Select By Employee Button 
	@FindBy(xpath = "//span[text()='By Employees']")
	private WebElement btnByEmp;

	//	(//td[@class=' select-checkbox']/input)[1]
	@FindBy(xpath = "//table[@id='template-roster-list']/tbody/tr/td/input")
	private WebElement checkBoxDeactive;

	@FindBy(xpath = "//button[@id='btnDeleteTemplateRoster']")
	private WebElement btnDeleteTemplateRoster;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//span[text()='Is Active?']")
	private WebElement checkBoxActive;

	@FindBy(xpath = "//div[text()='Template Roster updated successfully']")
	private WebElement rosterUpdateNotification;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	public E10_2608_SystemDefinationRosterCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.excelUtility= new ExcelUtilities();
		this.webUtility= new WebUtilities(driver);
	}

	public void setAddBtn() {
//		webUtility.ElementClickable(driver, addBtn);
//		addBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAddNewTemplateRoster")));
		element.click();

	}

	public void setTemplateNameTxt(String tampName) throws InterruptedException {
		Thread.sleep(2000);
		templateNameTxt.clear();
		templateNameTxt.sendKeys(tampName);
	}

	public void setTempDescriptionTxt(String tempDescription) {
		tempDescriptionTxt.clear();
		tempDescriptionTxt.sendKeys(tempDescription);
	}
	public void setNoOfDayTxt(String noOfDay) {
		noOfDayTxt.clear();
		noOfDayTxt.sendKeys(noOfDay);
	}
	// scroll down the page and select single roster group from  availble roaster group
	public void setAvailableSkillForSingleRoster() {
		action.scrollToElement(availableSkill).perform();
		//		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByIndex(0);	
		//		select.selectByVisibleText("8689");
	}
	// scroll down the page and select single Employee group from  availble Emp group
	public void setAvailableSkillForSingleEmp() {
		action.scrollToElement(availableSkill).perform();
		//		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByIndex(1);	
	}
	//move a singel Roaster/Emp from available Roaster/Emp group to selected roaster group 
	public void setAvailableSingleGroupMoveToSelectedGrp() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}
	public void setSelectMoveAll() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveAll.click();
	}
	public void setSaveBtn() {
		saveBtn.click();
	}
	public void setEditBtn() {
		action.moveToElement(editBtn).perform();
		editBtn.click();
	}

	public void setRosterCreation1stDay() {
		action.moveToElement(rosterCreation1stDay).perform();
		rosterCreation1stDay.click();
	}

	public void setBandCode() throws InterruptedException {
		//		Thread.sleep(2000);
		action.moveToElement(bandCode).perform();
		bandCode.click();
	}
	public void setSelectBandCode() {
		action.moveToElement(selectBandCode).perform();
		selectBandCode.click();
	}
	public void setBtnSaveSelectShiftBandBtn() throws Exception {
		//		webUtility.visibilityOfElement(driver, btnSaveSelectShiftBandBtn);
		Thread.sleep(2000);
		btnSaveSelectShiftBandBtn.click();
	}
	public void setBtnAddEmployee() {
		action.moveToElement(btnAddEmployee).perform();
		btnAddEmployee.click();
	}
	// Select Emp name from available roster group
	public void setAvailableEmpTable() throws InterruptedException {
		Thread.sleep(2000);
		action.moveToElement(availableEmpTable).perform();
		//		availableEmpTable.click();
		select= new Select(availableEmpTable);
		select.selectByIndex(0);
	}

	public void setBtnMoveFromAvailable() {
		action.moveToElement(btnMoveFromAvailable).perform();
		btnMoveFromAvailable.click();
	}
	public void setBtnSaveRosterTemplateEmployee() {
		btnSaveRosterTemplateEmployee.click();	
	}

	public void setBtnAddRosterGroups() {
		action.moveToElement(btnAddRosterGroups).perform();
		btnAddRosterGroups.click();
	}

	// Select Roster Group B from available roster group
	public void setAvailableRosterGroup() {
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByIndex(0);	
	}

	public void setBtnSaveRosterTemplateRosterGroups() {
		btnSaveRosterTemplateRosterGroups.click();
	}

	public void getTemplateRosterUpdatedSuccessfullyMsg() {
		String actualResult = templateRosterUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Template Roster updated successfully"));
	}

	public void setBtnAddSaveRosterPattern() {
		webUtility.moveToElement(driver, btnAddSaveRosterPattern);
		btnAddSaveRosterPattern.click();
	}
	public void setBtnPublishRosterPattern() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(btnPublishRosterPattern));
		Actions action = new Actions(driver);
		action.moveToElement(button).perform();
		button.click();

	}

	public void setDropDownCalenderRosterUp(String PublishFrom) {
		txtPublishFrom.clear();
		txtPublishFrom.sendKeys(PublishFrom);
		txtPublishFrom.sendKeys(Keys.ENTER);
	}
	public void setTxtNoOfBlock(String noOfBlocks) {
		txtNoOfBlock.sendKeys(noOfBlocks);
	}

	public void setCheckBoxPublishRoster2() {
		checkBoxPublishRoster2.click();
	}
	public void setBtnSaveTemplateRoster() {
		btnSaveTemplateRoster.click();
	}
	public void setBtnPublishNow() {
		btnPublishNow.click();
	}

	public void setBtnByEmp() {
		btnByEmp.click();
	}
	public void setCheckBoxDeactive() {
		checkBoxDeactive.click();
	}

	public void setBtnDeleteTemplateRoster() {
		action.moveToElement(btnDeleteTemplateRoster).perform();
		btnDeleteTemplateRoster.click();
	}
	public void setBtnYes() {
		btnYes.click();
	}
	public void setCheckBoxActive() {
		action.moveToElement(checkBoxActive).perform();
		checkBoxActive.click();
	}
	public void enterEmptyCell(int daysToAdd, int totalRows, int columnsPerRow) throws Exception {
		int totalCells = emptyCells.size();

		try {
			for (int i = 0; i < totalCells; i++) {
				WebElement emptyCell = emptyCells.get(i);
				String off = emptyCell.getText();

				// Calculate the column index based on the current iteration
				double columnIndex = (double) i % columnsPerRow;

				// Calculate the row index based on the current iteration
				int rowIndex = i / columnsPerRow;

				// Check if the current cell is within the specified days to add and within the valid rows
				if ((int) columnIndex < daysToAdd && rowIndex < totalRows && off.equalsIgnoreCase("Off") && emptyCell.isEnabled()) {
					// Perform actions if "Off" and the cell is enabled
					Thread.sleep(2000);
					emptyCell.click();
					setBandCode();
					setSelectBandCode();
					setBtnSaveSelectShiftBandBtn();
				} else {
					// Perform actions if not "Off" or the cell is disabled
					emptyCell.sendKeys(Keys.ENTER);
				}
			}
		} catch (Exception e) {
			// Handle the exception, log it, or take appropriate action
			e.printStackTrace();
		}
	}

	public void performActionsOnCheckboxes() {
		// Check if the first checkbox is enabled
		if (checkBoxPublishRosterMulti.size() > 0 && isElementEnabled(checkBoxPublishRosterMulti.get(0))) {
			// Check the first checkbox if it's not already checked
			if (!checkBoxPublishRosterMulti.get(0).isSelected()) {
				checkBoxPublishRosterMulti.get(0).click();
			}
			// Check if setDropDownCalenderRosterUp is enabled
			if (isElementEnabled(txtPublishFrom)) {
				setDropDownCalenderRosterUp(fakeEmployee.getRosterPublishDate());
			}
			// Check if setTxtNoOfBlock is enabled
			if (isElementEnabled(txtNoOfBlock)) {
				setTxtNoOfBlock(noOfBlocks);
			}
		}

		// Perform save actions after processing the first checkbox
		setBtnSaveTemplateRoster();
		setBtnPublishNow();
	}
	// Function to check if an element is enabled
	private boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}
	public void getShiftExtractionProcessCompletedSuccessfullyMsg() { // Shift extraction process completed successfully
		String actualResult = shiftExtractionProcessCompletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Shift extraction process completed successfully"));

	}
	public void clickNotificationPopup() throws Exception {
		Thread.sleep(1000);
		action.moveToElement(notificationPopup).perform();
		notificationPopup.click();
	}
	public void performDeleteAction() throws InterruptedException {
		//		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteTemplateRoster);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;

		// Iterate through rows
		for (int i = 0; i < row.size(); i++) {
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
			scrollAndClick(driver, nextPage);
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
	
	public void clickRosterCreation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(rosterCreation));
		targetElement.click();
//		rosterCreation.click();
	}
	public void enterNameSearch(String TempName) {
		txtSearch.click();
		txtSearch.sendKeys(TempName);
	}
	
	String TemplateName ;
	public void setCreateRoasterwithGroup() throws Exception {
		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);

		RoasterSetup.click();
		Thread.sleep(1000);
//		rosterCreation.click();
		clickRosterCreation();
		
		Thread.sleep(3000);
		setAddBtn();
		TemplateName = tampName+ " "+ System.currentTimeMillis();
		setTemplateNameTxt(TemplateName);
		setTempDescriptionTxt(tempDescription+ " "+ System.currentTimeMillis());
		setNoOfDayTxt(noOfDay);
		setAvailableSkillForSingleRoster();
		setAvailableSingleGroupMoveToSelectedGrp();
		setSaveBtn();
		enterEmptyCell(6,2,7);
		Thread.sleep(2000);
		setBtnAddSaveRosterPattern();
		getTemplateRosterUpdatedSuccessfullyMsg();
		clickNotificationPopup();
		Thread.sleep(2000);
		// Add Employee
		//				setBtnAddEmployee();
		//				Thread.sleep(2000);
		//				setAvailableEmpTable();
		//				setBtnMoveFromAvailable();
		//				setBtnSaveRosterTemplateEmployee();
		//
		// Add Roster group
		//				Thread.sleep(2000);
		//				setBtnAddRosterGroups();
		//				Thread.sleep(2000);
		//				setAvailableRosterGroup();
		//				setAvailableSingleSkillMoveToSelectedSkill();
		//				setBtnSaveRosterTemplateRosterGroups();

		setBtnPublishRosterPattern() ;
		performActionsOnCheckboxes();
		clickNotificationPopup();
	}
	public void setCreateRoasterwithEmployee() throws Exception {
		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);
	
//		RoasterSetup.click();
		Thread.sleep(1000);
//		rosterCreation.click();
		clickRosterCreation();
		setAddBtn();
		Thread.sleep(1000);
		
		TemplateName = tampName+ " "+ System.currentTimeMillis();
		setTemplateNameTxt(TemplateName);

		setTemplateNameTxt(tampName+ " "+ System.currentTimeMillis());
		setTempDescriptionTxt(tempDescription+ " "+ System.currentTimeMillis());
		setNoOfDayTxt(noOfDay);
		setBtnByEmp();
		Thread.sleep(2000);
		setAvailableSkillForSingleEmp();
		setAvailableSingleGroupMoveToSelectedGrp();
		setSaveBtn();
		enterEmptyCell(6,3,7);
		Thread.sleep(2000);
		setBtnAddSaveRosterPattern();
		getTemplateRosterUpdatedSuccessfullyMsg();
		clickNotificationPopup();
		
		setBtnPublishRosterPattern();
		performActionsOnCheckboxes();
		clickNotificationPopup();

	}
	public void setCreateRoasterwithRosterAndEmp() throws Exception {
		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);
	
//		RoasterSetup.click();
		Thread.sleep(5000);
//		rosterCreation.click();
		clickRosterCreation();
		Thread.sleep(5000);
		setAddBtn();
		Thread.sleep(1000);
		setTemplateNameTxt(tampName+ " "+ System.currentTimeMillis());
		setTempDescriptionTxt(tempDescription+ " "+ System.currentTimeMillis());
		setNoOfDayTxt(noOfDay);
		setAvailableSkillForSingleRoster();
		setAvailableSingleGroupMoveToSelectedGrp();
		setSaveBtn();
		//		enterEmptyCell(6,3,7);
		//	Add Employee
		clickNotificationPopup();
		Thread.sleep(2000);
		setBtnAddEmployee();
		Thread.sleep(2000);
		setAvailableEmpTable();
		setBtnMoveFromAvailable();
		setBtnSaveRosterTemplateEmployee();

		enterEmptyCell(6,3,7);

		setBtnAddSaveRosterPattern();
		getTemplateRosterUpdatedSuccessfullyMsg();
		clickNotificationPopup();
		
		setBtnPublishRosterPattern();
		performActionsOnCheckboxes();
		getShiftExtractionProcessCompletedSuccessfullyMsg();
		clickNotificationPopup();
	}



	public void setUpdateRoaster() throws Exception {
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 15, 10);
		//		Thread.sleep(2000);
//		RoasterSetup.click();
		Thread.sleep(1000);
//		rosterCreation.click();
		clickRosterCreation();
		
//		enterNameSearch(TemplateName);
		
		setEditBtn();
		setBtnPublishRosterPattern() ;
		performActionsOnCheckboxes();
		clickNotificationPopup();
	}
	public void setDeactiveRoster() throws Exception {
//		setCheckBoxDeactive();
//		setBtnDeleteTemplateRoster();
		
//		RoasterSetup.click();
		Thread.sleep(1000);
//		rosterCreation.click();
		clickRosterCreation();
		
//		enterNameSearch(TemplateName);
		deleteRowsWithEnabledCheckbox();
		setBtnYes();
		clickNotificationPopup();
	}

	public void setReactiveRoster() throws InterruptedException {
//		RoasterSetup.click();
		Thread.sleep(1000);
//		rosterCreation.click();
		clickRosterCreation();
//		enterNameSearch(TemplateName);
		Thread.sleep(2000);
		setEditBtn();
		setCheckBoxActive();
		setBtnAddSaveRosterPattern();
	}

}


