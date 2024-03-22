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

public class E10_2606_SystemDefinationShiftBandPage  
{

	WebDriver driver ;
	ReusableComponent Rc;
	String shiftBandName ;
	String colorCode;
	String bandCode;
	String otStart;
	String otEnd;
	public ExcelUtilities excelUtility;
	
	
	
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
	List<WebElement> sideNavMenu; // Shift Band Definition

	@FindBy(id = "btnAddNew")
	WebElement addBtn;

	@FindBy(id = "txtShtBandName")
	WebElement shiftBandNameTxt;

	@FindBy (id = "txtShiftbandDesc")
	WebElement descriptionTxt;

	@FindBy(id = "txtShiftBandCode")
	WebElement bandCodeTxt;

	@FindBy(id = "select2-cmbShiftBandId-container") //span[@id='select2-cmbShiftBandId-container']
	WebElement shiftBandTypeTxt;

	@FindBy(className  ="select2-search__field")
	WebElement searchTxt;

	@FindBy(xpath = "//li[text()='Normal Shift']")
	WebElement shiftType;

	@FindBy(className = "select2-search__field")
	WebElement searchBox;

	// inside searchbox we have to select one shift type
	@FindBy(xpath = "//li[text()='Normal Shift']") 
	WebElement shiftTypeSearch;

	@FindBy(xpath = "//span[text()='×']")
	WebElement clearSearch;
	@FindBy(xpath = "//li[text()='Combination Shift']")
	WebElement shiftTpSearchCombiShift;

	@FindBy(xpath = "//li[text()='Overtime Shift']")
	WebElement shiftTpSearchOvertime;

	@FindBy(id = "txtColorCode")
	WebElement colorTxt;

	@FindBy(xpath = "//input[@id='txtShiftCounter']")
	WebElement shiftCounterTxt;

	//  Using for select from Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement availableSkill;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle;

	@FindBy(xpath = "//input[@id='txtStartTime']")
	WebElement startTime;
	@FindBy(xpath = "//li[text()='07:00']")
	WebElement selectStartTime;

	@FindBy(xpath = "//input[@id='txtEndTime']")
	WebElement endTime;
	@FindBy(xpath = "(//li[text()='19:00'])[2]")
	WebElement selectEndTime;


	@FindBy(xpath = "//input[@id='txtStartRangeBegin']")
	WebElement startRangeBegin;
	@FindBy(xpath = "(//li[text()='06:59'])[3]")
	WebElement startRangeBeginTime;

	@FindBy(xpath = "//input[@id='txtStartRangeEnd']")
	WebElement startRangeEnd;	


	@FindBy(xpath = "//input[@name='endRangeBegin']")
	WebElement endRangeBegin;
	@FindBy(xpath = "(//li[text()='19:01'])[5]")
	WebElement endRangeBeginTime;

	@FindBy(xpath = "//input[@name='endRangeEnd']")
	WebElement endRangeEnd;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//button[@id='btnSaveshiftbandDtls']") 
	WebElement btnSaveshiftbandDtls;

	// Edit ........................................................

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement editBtn;
	@FindBy(xpath = "//span[text()='IsActive?']")
	WebElement checkIsActive;

	@FindBy(xpath = "//table[@id='shftband-list']/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//li[@id='shftband-list_next']")
	WebElement nextPage;


	@FindBy(xpath = "//button[@id='btnDeleteshftband']")
	WebElement btnDeleteshftband;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement clickYes;

	@FindBy(id = "txtShtBandName-error")
	WebElement errorShiftBandTxt;

	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement errorPopup;

	@FindBy(xpath = "//span[@id='select2-cmbOverTimeType-container']")
	WebElement overTimeType;

	@FindBy(xpath = "//li[text()='Both']")
	WebElement selectBoth;

	@FindBy(xpath = "//input[@id='txtOverTimeStart']")
	WebElement overTimeStartTxt;
	@FindBy(xpath = "//li[text()='20:00']")
	WebElement overTimeStart;

	@FindBy(xpath = "//input[@id='txtOverTimeEnd']")
	WebElement overTimeEndTxt;
	@FindBy(xpath = "(//li[text()='05:00'])[2]")
	WebElement overTimeEnd;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchBar;

	@FindBy(xpath = "//div[text()='Shift Band created successfully']")
	WebElement shiftBandCreatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Shift Band updated successfully']")
	WebElement shiftBandUpdatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='ShiftBand deleted successfully.']")
	WebElement shiftBandDeletedSuccessfullyMsg;


	@FindBy(xpath = "//label[@id='txtShtBandName-error']")
	WebElement shiftBandNameError;

	@FindBy(xpath = "//button[@data-original-title='Cancel']")
	WebElement btnCancle;


	public E10_2606_SystemDefinationShiftBandPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		this.Rc= new ReusableComponent(driver);
		this.excelUtility= new ExcelUtilities();

	}


	public void createShiftBand() throws Exception 
	{

		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 10);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 9);
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Shift Band Definition", "Shift Band Definition is not clicked");


		shiftBandName = Rc.name;

		addBtn.click();

		Rc.explicitWait(shiftBandNameTxt, "visible");	
		shiftBandNameTxt.clear();
		shiftBandNameTxt.sendKeys(Rc.name);
		descriptionTxt.clear();
		descriptionTxt.sendKeys(Rc.description);
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(bandCode +System.currentTimeMillis());
		shiftBandTypeTxt.click();
		Rc.moveToElement(searchBox);
		Rc.explicitWait(shiftTypeSearch, "clickable");
		Rc.moveToElement(shiftTypeSearch);
		shiftTypeSearch.click();
		colorTxt.clear();
		colorTxt.sendKeys(colorCode);
		colorTxt.sendKeys(Keys.ENTER);
		Rc.explicitWait(shiftCounterTxt, "visible");
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(Rc.randomInt);
		Rc.moveToElement(startTime);
		startTime.clear();
		Rc.moveToElement(selectStartTime);
		selectStartTime.click();
		endTime.click();
		selectEndTime.click();
		Rc.moveToElement(startRangeBegin);
		startRangeBegin.click();
		startRangeBeginTime.click();
		startRangeEnd.isDisplayed();
		Rc.moveToElement(endRangeBegin);
		endRangeBegin.isDisplayed();
		endRangeEnd.isDisplayed();
		Rc.moveToElement(btnSaveshiftbandDtls);
		btnSaveshiftbandDtls.click();
		Rc.explicitWait(shiftBandCreatedSuccessfullyMsg, "visible");
		String actualResult = shiftBandCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Shift Band created successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}
	public void updateShiftBand() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(searchBar, "visible");
		searchBar.sendKeys(shiftBandName);
		Rc.explicitWait(editBtn, "clickable");
		editBtn.click();
		Rc.explicitWait(shiftBandNameTxt, "visible");	
		shiftBandNameTxt.clear();
		shiftBandNameTxt.sendKeys(Rc.name);
		descriptionTxt.clear();
		descriptionTxt.sendKeys(Rc.description);
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(bandCode +System.currentTimeMillis());
		shiftBandTypeTxt.click();
		Rc.moveToElement(searchBox);
		Rc.explicitWait(shiftTypeSearch, "clickable");
		Rc.moveToElement(shiftTypeSearch);
		shiftTypeSearch.click();
		colorTxt.clear();
		colorTxt.sendKeys(colorCode);
		colorTxt.sendKeys(Keys.ENTER);
		Rc.explicitWait(shiftCounterTxt, "visible");
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(Rc.randomInt);
		Rc.moveToElement(startTime);
		startTime.clear();
		Rc.moveToElement(selectStartTime);
		selectStartTime.click();
		endTime.click();
		selectEndTime.click();
		Rc.moveToElement(startRangeBegin);
		startRangeBegin.click();
		startRangeBeginTime.click();
		startRangeEnd.isDisplayed();
		Rc.moveToElement(endRangeBegin);
		endRangeBegin.isDisplayed();
		endRangeEnd.isDisplayed();
		Rc.moveToElement(btnSaveshiftbandDtls);
		btnSaveshiftbandDtls.click(); 
		Rc.explicitWait(shiftBandUpdatedSuccessfullyMsg, "visible");
		String actualResult = shiftBandUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Shift Band updated successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void deactiveShiftBand() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(editBtn, "visible");
		searchBar.clear();
		searchBar.sendKeys(shiftBandName);
		checkBox.click();
		Rc.explicitWait(btnDeleteshftband, "clickable");
		btnDeleteshftband.click();
		Rc.explicitWait(clickYes, "clickable");
		clickYes.click();
		Rc.explicitWait(shiftBandDeletedSuccessfullyMsg, "visible");
		String actualResult = shiftBandDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("ShiftBand deleted successfully."));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void reactivateShiftBand() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(editBtn, "visible");
		searchBar.clear();
		searchBar.sendKeys(shiftBandName);
		Rc.explicitWait(editBtn, "clickable");
		editBtn.click();
		Rc.explicitWait(checkIsActive, "clickable");
		checkIsActive.click();	
		Rc.explicitWait(btnSaveshiftbandDtls, "clickable");
		btnSaveshiftbandDtls.click();
		Rc.explicitWait(shiftBandUpdatedSuccessfullyMsg, "visible");
		String actualResult = shiftBandUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Shift Band updated successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void withoutShiftBandName() throws Exception {
		shiftBandName = Rc.name;

		addBtn.click();

		//		Rc.explicitWait(shiftBandNameTxt, "visible");	
		//		shiftBandNameTxt.clear();
		//		shiftBandNameTxt.sendKeys(Rc.name);
		descriptionTxt.clear();
		descriptionTxt.sendKeys(Rc.description);
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(Rc.name);
		shiftBandTypeTxt.click();
		Rc.moveToElement(searchBox);
		Rc.explicitWait(shiftTypeSearch, "clickable");
		Rc.moveToElement(shiftTypeSearch);
		shiftTypeSearch.click();
		Rc.explicitWait(shiftCounterTxt, "visible");
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(Rc.randomInt);
		Rc.moveToElement(startTime);
		startTime.clear();
		Rc.moveToElement(selectStartTime);
		selectStartTime.click();
		btnSaveshiftbandDtls.click();
		Rc.explicitWait(shiftBandNameError, "visible");
		String actualResult = shiftBandNameError.getText();
		Assert.assertTrue(actualResult.contains("ShiftBand Name Is Required"));
		btnCancle.click();
		
	}
	
	public void shiftBandTypeCombinationShift() throws Exception 
	{
		Rc.explicitWait(addBtn, "clickable");	
		addBtn.click();

		Rc.explicitWait(shiftBandNameTxt, "visible");	
		shiftBandNameTxt.clear();
		shiftBandNameTxt.sendKeys(Rc.name + " Jivi");
		descriptionTxt.clear();
		descriptionTxt.sendKeys(Rc.description);
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(Rc.name);
		shiftBandTypeTxt.click();
		Rc.moveToElement(shiftTpSearchOvertime);
		shiftTpSearchOvertime.click();
		Thread.sleep(2000);
		shiftBandTypeTxt.click();
		Thread.sleep(3000);
		Rc.moveToElement(shiftTpSearchCombiShift);
		shiftTpSearchCombiShift.click();
		colorTxt.clear();
		colorTxt.sendKeys(colorCode);
		colorTxt.sendKeys(Keys.ENTER);
		Rc.explicitWait(shiftCounterTxt, "visible");
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(Rc.randomInt);
		Thread.sleep(2000);
		Rc.moveToElement(availableSkill);
		Rc.selectByIndex(availableSkill, 0);
		Thread.sleep(2000);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		Rc.explicitWait(btnSaveshiftbandDtls, "clickable");
		btnSaveshiftbandDtls.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}
	public void shiftBandTypeOvertimeShift() throws Exception 
	{
		otStart = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 18);
		otEnd = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 19);
		Thread.sleep(2000);
		Rc.explicitWait(addBtn, "clickable");	
		addBtn.click();
		Rc.explicitWait(shiftBandNameTxt, "visible");	
		shiftBandNameTxt.clear();
		shiftBandNameTxt.sendKeys(Rc.firstName);
		descriptionTxt.clear();
		descriptionTxt.sendKeys(Rc.description);
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(Rc.name);
		shiftBandTypeTxt.click();
		Rc.moveToElement(searchBox);
		Rc.moveToElement(shiftTpSearchOvertime);
		shiftTpSearchOvertime.click();
		colorTxt.clear();
		colorTxt.sendKeys(colorCode);
		colorTxt.sendKeys(Keys.ENTER);
		Rc.explicitWait(shiftCounterTxt, "visible");
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(Rc.randomInt);
		Rc.moveToElement(startTime);
		startTime.clear();
		Rc.moveToElement(selectStartTime);
		selectStartTime.click();
		Rc.moveToElement(endTime);
		endTime.clear();
		Rc.moveToElement(selectEndTime);
		selectEndTime.click();
		Rc.moveToElement(overTimeType);
		overTimeType.click();
		Rc.moveToElement(selectBoth);
		selectBoth.click();
		overTimeStartTxt.clear();
		//		overTimeStart.click();
		overTimeStartTxt.sendKeys(otStart);
		overTimeStartTxt.sendKeys(Keys.ENTER);
		overTimeEndTxt.clear();
		//		overTimeEnd.click();
		overTimeEndTxt.sendKeys(otEnd);
		overTimeEndTxt.sendKeys(Keys.ENTER);
		Rc.explicitWait(btnSaveshiftbandDtls, "clickable");
		btnSaveshiftbandDtls.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}
}
