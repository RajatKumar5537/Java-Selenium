package com.AutomationJiviewsPOM;


import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.ReusableComponent;


public class E10_2608_SystemDefinationRosterCreationPage{
	public WebDriver driver; 
	ReusableComponent Rc;

	public ExcelUtilities excelUtility;
	public String tampName ;
	public String noOfDay;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // System Definitions

	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[2]")
	WebElement ulApplicationMenu; // Roster Setup

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[2]/li")
	List<WebElement> sideNavMenu; // Roster Creation


	@FindBy(xpath = "//div[text()='Roster Setup']/..")
	WebElement RoasterSetup;
	@FindBy(xpath = "//div[text()='Roster Creation']/..")
	WebElement rosterCreation;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement txtSearch;

	@FindBy(xpath = "//button[@id='btnAddNewTemplateRoster']")
	WebElement addBtn;

	@FindBy(id = "txtTemplateName")
	WebElement templateNameTxt;

	@FindBy(id = "txtTemplateDesc")
	WebElement tempDescriptionTxt;

	@FindBy(id = "txtNumberOfDays")
	WebElement noOfDayTxt;

	// Using for select Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement availableSkill;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle; 

	//	select for move multiple skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	WebElement selectMoveAll;

	// here it will select a skill from Seleceted Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	WebElement selectedSkill;

	//	select for move single skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	WebElement removeSelectedSkillSingle;

	//	select for move multiple skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	WebElement removeSelectedSkillAll;


	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement editBtn;

	// Group A 
	@FindBy(xpath = "(//div[text()='Off']/..)[1]")
	WebElement rosterCreation1stDay;

	@FindBy(xpath = "//div[@class='scheduler_default_matrix']/div/div")
	List<WebElement> rosterCreationDays;
	@FindBy(xpath = "//div[@style='text-align:center']")
	List<WebElement> rosterCreationDaysFillUp;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div/div/div/div/div/div")
	List<WebElement> fillCells;
	@FindBy(xpath = "//div[text()='Off']/..")
	List<WebElement> emptyCells;

	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	WebElement 	bandCode;

	// in Band code search box need the select one shift from drop down box
	@FindBy(xpath = "(//li[contains(text(),'1st  Shift ')])[2]")
	WebElement selectBandCode;

	@FindBy(xpath = "//button[@id='btnSelectShiftBand']")
	WebElement btnSaveSelectShiftBandBtn;

	@FindBy(xpath = "//button[@id='btnAddSaveRosterPattern']/span")
	WebElement btnAddSaveRosterPattern;

	@FindBy(xpath = "//button[@id='btnAddEmployee']/span")
	WebElement btnAddEmployee;

	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement availableEmpTable;

	@FindBy(xpath = "(//button[@class='btn move btn-default'])[1]")
	WebElement btnMoveFromAvailable;

	@FindBy(xpath = "//button[@id='btnSaveRosterTemplateEmployee']/span")
	WebElement btnSaveRosterTemplateEmployee;

	@FindBy(xpath = "//button[@id='btnAddRosterGroups']/span")
	WebElement btnAddRosterGroups;

	@FindBy(xpath = "//button[@id='btnSaveRosterTemplateRosterGroups']")
	WebElement btnSaveRosterTemplateRosterGroups;

	@FindBy(xpath = "//button[@id='btnPublishRosterPattern']")
	WebElement btnPublishRosterPattern;


	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBoxPublishRoster;
	//	@FindBy(xpath = "//input[@id='dtPublishFrom1130']")
	@FindBy(xpath = "//input[@class='form-control form-label-sm bootstrap-datepicker roster-pattern-from']")
	WebElement txtPublishFrom;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[9]")
	WebElement publishFromDate;

	//	@FindBy(xpath = "//input[@id='txtNoOfBlocks1130']")
	@FindBy(xpath = "//input[@class='form-control roster-pattern-blocks']")
	WebElement txtNoOfBlock;

	//	@FindBy(xpath = "(//td[@class='sorting_1']/input)[1]")
	//	WebElement checkBoxPublishRoster;

	@FindBy(xpath = "//table[@id='extract-shift-list']/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	List<WebElement> checkBoxPublishRosterMulti;


	@FindBy(xpath = "//table[@id='template-roster-list']/tbody/tr")
	List<WebElement> row;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(xpath = "//li[@id='skill-list_next']")
	WebElement nextPage;


	@FindBy(xpath = "(//td[@class='sorting_1']/input)[2]")
	WebElement checkBoxPublishRoster2;

	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']")
	WebElement btnSaveTemplateRoster;

	@FindBy(xpath = "//button[@class='swal2-cancel swal2-styled']")
	WebElement btnPublishNow;




	// Select By Employee Button 
	@FindBy(xpath = "//span[text()='By Employees']")
	WebElement btnByEmp;

	//	(//td[@class=' select-checkbox']/input)[1]
	@FindBy(xpath = "//table[@id='template-roster-list']/tbody/tr/td/input")
	WebElement checkBoxDeactive;

	@FindBy(xpath = "//button[@id='btnDeleteTemplateRoster']")
	WebElement btnDeleteTemplateRoster;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;

	@FindBy(xpath = "//span[text()='Is Active?']")
	WebElement checkBoxActive;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//button[@id='btnCloseRosterPattern']")
	WebElement btnCloseRosterPattern;

	@FindBy(xpath = "//div[text()='Shift extraction process completed successfully']")
	WebElement shiftExtractionProcessCompletedSuccessfullyMsg; 
	@FindBy(xpath = "//div[text()='Template Roster updated successfully']")
	WebElement templateRosterUpdatedSuccessfullyMsg; // Update & Reactivate 
	@FindBy(xpath = "//div[text()='Template Roster']")
	WebElement rosterDeleteMsg;





	public E10_2608_SystemDefinationRosterCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		this.Rc= new ReusableComponent(driver);
		this.excelUtility= new ExcelUtilities();
	}

	public void enterEmptyCell(int daysToAdd, int totalRows, int columnsPerRow) throws Exception 
	{
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
					Rc.explicitWait(emptyCell, "clickable");
					emptyCell.click();

					Rc.moveToElement(bandCode);
					bandCode.click();
					Rc.moveToElement(selectBandCode);
					selectBandCode.click();
					Thread.sleep(2000);
					btnSaveSelectShiftBandBtn.click();

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


	public void setCreateRoasterwithGroup() throws Exception 
	{
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		tampName = Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Roster Creation", "Roster Creation is not clicked");
		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();
		Rc.explicitWait(templateNameTxt, "visible");
		templateNameTxt.clear();
		templateNameTxt.sendKeys(tampName);
		tempDescriptionTxt.clear();
		tempDescriptionTxt.sendKeys(Rc.description);
		noOfDayTxt.clear();
		noOfDayTxt.sendKeys(noOfDay);
		Rc.scrollToElement(availableSkill);
		Rc.selectByIndex(availableSkill, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		saveBtn.click();
		enterEmptyCell(6,2,7);
		Rc.moveToElement(btnAddSaveRosterPattern);
		btnAddSaveRosterPattern.click();
		String actualResult = templateRosterUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Template Roster updated successfully"));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishRosterPattern, "clickable");
		Rc.moveToElement(btnPublishRosterPattern);
		btnPublishRosterPattern.click();
		Rc.explicitWait(checkBoxPublishRoster, "clickable");
		checkBoxPublishRoster.click();
		Rc.explicitWait(txtPublishFrom, "clickable");
		txtPublishFrom.click();
		publishFromDate.click();
		Rc.explicitWait(txtNoOfBlock, "visible");
		txtNoOfBlock.sendKeys(Rc.randomInt);
		btnSaveTemplateRoster.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishNow, "clickable");
		btnPublishNow.click();
		String rosterCreateSuccessful = shiftExtractionProcessCompletedSuccessfullyMsg.getText();
		Assert.assertTrue(rosterCreateSuccessful.contains("Shift extraction process completed successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Rc.explicitWait(btnCloseRosterPattern, "clickable");
		btnCloseRosterPattern.click();

	}
	
	public void setCreateRoasterwithEmployee() throws Exception 
	{

		tampName = Rc.firstName;

		addBtn.click();
		Rc.explicitWait(templateNameTxt, "visible");
		templateNameTxt.clear();
		templateNameTxt.sendKeys(tampName);
		tempDescriptionTxt.clear();
		tempDescriptionTxt.sendKeys(Rc.description);
		noOfDayTxt.clear();
		noOfDayTxt.sendKeys(noOfDay);
		btnByEmp.click();
		Thread.sleep(2000);
		Rc.explicitWait(availableSkill, "visible");
		Rc.scrollToElement(availableSkill);
		Rc.selectByIndex(availableSkill, 1);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		saveBtn.click();
		enterEmptyCell(6,3,7);
		Rc.explicitWait(btnAddSaveRosterPattern, "clickable");
		Rc.moveToElement(btnAddSaveRosterPattern);
		btnAddSaveRosterPattern.click();
		String actualResult = templateRosterUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Template Roster updated successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishRosterPattern, "clickable");
		btnPublishRosterPattern.click();
		Rc.explicitWait(checkBoxPublishRoster, "clickable");
		checkBoxPublishRoster.click();
		Rc.explicitWait(txtPublishFrom, "clickable");
		txtPublishFrom.click();
		publishFromDate.click();
		Rc.explicitWait(txtNoOfBlock, "visible");
		txtNoOfBlock.sendKeys(Rc.randomInt);
		btnSaveTemplateRoster.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishNow, "clickable");
		btnPublishNow.click();
		String rosterCreateSuccessful = shiftExtractionProcessCompletedSuccessfullyMsg.getText();
		Assert.assertTrue(rosterCreateSuccessful.contains("Shift extraction process completed successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Rc.explicitWait(btnCloseRosterPattern, "clickable");
		btnCloseRosterPattern.click();
	}


	public void setUpdateRoaster() throws Exception 
	{
		Rc.explicitWait(editBtn, "visible");
		txtSearch.clear();
		txtSearch.sendKeys(tampName);
		Rc.explicitWait(editBtn, "clickable");
		editBtn.click();
		Rc.explicitWait(btnPublishRosterPattern, "clickable");
		btnPublishRosterPattern.click();
		Rc.explicitWait(checkBoxPublishRoster, "clickable");
		checkBoxPublishRoster.click();
		Rc.explicitWait(txtPublishFrom, "clickable");
		txtPublishFrom.click();
		publishFromDate.click();
		Rc.explicitWait(txtNoOfBlock, "visible");
		txtNoOfBlock.sendKeys(Rc.randomInt);
		btnSaveTemplateRoster.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishNow, "clickable");
		btnPublishNow.click();
		String rosterCreateSuccessful = shiftExtractionProcessCompletedSuccessfullyMsg.getText();
		Assert.assertTrue(rosterCreateSuccessful.contains("Shift extraction process completed successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Rc.explicitWait(btnCloseRosterPattern, "clickable");
		btnCloseRosterPattern.click();
	}

	public void setDeactiveRoster() throws Exception 
	{

		Rc.explicitWait(editBtn, "visible");
		txtSearch.clear();
		txtSearch.sendKeys(tampName);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.explicitWait(btnDeleteTemplateRoster, "clickable");
		btnDeleteTemplateRoster.click();
		btnYes.click();
		String actualResult = rosterDeleteMsg.getText();
		Assert.assertTrue(actualResult.contains("Template Roster"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void setReactiveRoster() throws InterruptedException 
	{
		Thread.sleep(2000);
		Rc.explicitWait(editBtn, "visible");
		txtSearch.clear();
		txtSearch.sendKeys(tampName);
		Rc.moveToElement(editBtn);
		editBtn.click();
		Rc.moveToElement(checkBoxActive);
		checkBoxActive.click();
		Rc.moveToElement(btnAddSaveRosterPattern);
		btnAddSaveRosterPattern.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Thread.sleep(3000);
		Rc.explicitWait(btnCloseRosterPattern, "clickable");
		btnCloseRosterPattern.click();
	}

	public void setCreateRoasterwithRosterAndEmp() throws Exception 
	{
		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();
		Rc.explicitWait(templateNameTxt, "visible");
		templateNameTxt.clear();
		templateNameTxt.sendKeys(Rc.name);
		tempDescriptionTxt.clear();
		tempDescriptionTxt.sendKeys(Rc.description);
		noOfDayTxt.clear();
		noOfDayTxt.sendKeys(noOfDay);
		Rc.scrollToElement(availableSkill);
		Rc.selectByIndex(availableSkill, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		saveBtn.click();
		Rc.moveToElement(btnAddEmployee);
		btnAddEmployee.click();
		Thread.sleep(2000);
		Rc.moveToElement(availableEmpTable);
		Rc.selectByIndex(availableEmpTable, 0);
		Rc.moveToElement(btnMoveFromAvailable);
		btnMoveFromAvailable.click();
		Rc.explicitWait(btnSaveRosterTemplateEmployee, "clickable");
		btnSaveRosterTemplateEmployee.click();	
		enterEmptyCell(6,3,7);
		Rc.moveToElement(btnAddSaveRosterPattern);
		btnAddSaveRosterPattern.click();
		String actualResult = templateRosterUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Template Roster updated successfully"));
		Rc.moveToElement(notificationPopup);
		notificationPopup.click();
		Thread.sleep(2000);
		Rc.explicitWait(btnPublishRosterPattern, "clickable");
		btnPublishRosterPattern.click();
		Rc.explicitWait(checkBoxPublishRoster, "clickable");
		checkBoxPublishRoster.click();
		Rc.explicitWait(txtPublishFrom, "clickable");
		txtPublishFrom.click();
		publishFromDate.click();
		Rc.explicitWait(txtNoOfBlock, "visible");
		txtNoOfBlock.sendKeys(Rc.randomInt);
		btnSaveTemplateRoster.click();
		Thread.sleep(1000);
		Rc.explicitWait(btnPublishNow, "clickable");
		btnPublishNow.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Rc.explicitWait(btnCloseRosterPattern, "clickable");
		btnCloseRosterPattern.click();

	}
}


