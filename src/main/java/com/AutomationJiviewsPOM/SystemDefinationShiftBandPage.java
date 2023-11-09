package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;
import com.mongodb.diagnostics.logging.Logger;

public class SystemDefinationShiftBandPage  extends BaseClass{

	Actions action= new Actions(driver);
	Select select;
	public ExcelUtilities excelUtility;
	public WebUtilities webUtility;
	public String shiftBandName;
	public String description ;
	public String bandCode;
	public String colorCode;
	public String shiftCounter;
	public String startRangeBeginT;
	public String startRangeEndT;
	public String endRangeBeginT;
	public String endRangeEndT;
	public String otStart;
	public String otEnd;
	public String timeStamp = LocalDateTime.now().toString();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SystemDefinationShiftBandPage sb;

	@FindBy(id = "btnAddNew")
	private WebElement addBtn;

	@FindBy(id = "txtShtBandName")
	private WebElement shiftBandNameTxt;

	@FindBy (id = "txtShiftbandDesc")
	private WebElement descriptionTxt;

	@FindBy(id = "txtShiftBandCode")
	private WebElement bandCodeTxt;

	@FindBy(id = "select2-cmbShiftBandId-container")
	private WebElement shiftBandTypeTxt;

	@FindBy(className  ="select2-search__field")
	private WebElement searchTxt;

	@FindBy(xpath = "//li[text()='Normal Shift']")
	private WebElement shiftType;

	@FindBy(className = "select2-search__field")
	private WebElement searchBox;

	// inside searchbox we have to select one shift type
	@FindBy(xpath = "//li[text()='Normal Shift']") 
	private WebElement shiftTypeSearch;

	@FindBy(xpath = "//li[text()='Combination Shift']")
	private WebElement shiftTpSearchCombiShift;

	@FindBy(xpath = "//li[text()='Overtime Shift']")
	private WebElement shiftTpSearchOvertime;

	@FindBy(id = "txtColorCode")
	private WebElement colorTxt;

	@FindBy(xpath = "//input[@id='txtShiftCounter']")
	private WebElement shiftCounterTxt;

	//  Using for select from Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableSkill;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle;

	@FindBy(xpath = "//input[@id='txtStartTime']")
	private WebElement startTime;

	@FindBy(xpath = "//li[text()='07:00']")
	private WebElement selectStartTime;

	@FindBy(xpath = "//input[@id='txtEndTime']")
	private WebElement endTime;

	@FindBy(xpath = "(//li[text()='19:00'])[2]")
	private WebElement selectEndTime;


	@FindBy(xpath = "//input[@id='txtStartRangeBegin']")
	private WebElement startRangeBegin;

	@FindBy(xpath = "//input[@id='txtStartRangeEnd']")
	private WebElement startRangeEnd;	


	@FindBy(xpath = "//input[@name='endRangeBegin']")
	private WebElement endRangeBegin;

	@FindBy(xpath = "//input[@name='endRangeEnd']")
	private WebElement endRangeEnd;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//button[@id='btnSaveshiftbandDtls']")
	WebElement btnSaveshiftbandDtls;

	// Edit ........................................................

		@FindBy(xpath = "(//button[@type='button'])[5]")
		private WebElement editBtn;
	
		@FindBy(xpath =  "(//input[@type='checkbox'])[2]")
		private WebElement checkBox;
	
		@FindBy(xpath = "//button[@id='btnDeleteshftband']")
		private WebElement clickDeleteBtn;
	
		@FindBy(xpath = "//button[text()='Yes']")
		private WebElement clickYes;
	
		@FindBy(id = "txtShtBandName-error")
		private WebElement errorShiftBandTxt;
	
		@FindBy(xpath = "//button[@class='toast-close-button']")
		private WebElement errorPopup;
	
		@FindBy(xpath = "//span[@id='select2-cmbOverTimeType-container']")
		private WebElement overTimeType;
	
		@FindBy(xpath = "//li[text()='Both']")
		private WebElement selectBoth;
	
		@FindBy(xpath = "//input[@id='txtOverTimeStart']")
		private WebElement overTimeStartTxt;
	
		@FindBy(xpath = "//input[@id='txtOverTimeEnd']")
		private WebElement overTimeEndTxt;

	public SystemDefinationShiftBandPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webUtility= new WebUtilities(driver);
		this.excelUtility= new ExcelUtilities();
	}

	public void setAddBtn() {
		addBtn.click();
	}

	public void setShiftBandName(String shiftBandName, String timeStamp) throws Exception {
		webUtility.visibilityOfElement(driver,shiftBandNameTxt);
		shiftBandNameTxt.clear();
		shiftBandNameTxt.sendKeys(shiftBandName+ " " + timeStamp);
	}
	public void setDescriptionTxt(String description, String timeStamp) {
		descriptionTxt.clear();
		descriptionTxt.sendKeys(description+ " " + timeStamp);
	}
	public void setBandCodeTxt(String bandCode, String timeStamp) {
		bandCodeTxt.clear();
		bandCodeTxt.sendKeys(bandCode+  " " + timeStamp);
	}
	public void setShiftBandTypeTxt() {
		shiftBandTypeTxt.click();
	}
	public void setSearchBox() {
		action.moveToElement(searchBox).perform();
	}
	public void setShiftTypeSearch() {
		action.moveToElement(shiftTypeSearch).perform();
		shiftTypeSearch.click();
	}

	public void setShiftTpSearchCombiShift() {
		action.moveToElement(shiftTpSearchCombiShift).perform();
		shiftTpSearchCombiShift.click();
	}

	public void setShiftTpSearchOvertime() {
		action.moveToElement(shiftTpSearchOvertime).perform();
		shiftTpSearchOvertime.click();
	}

	public void setColorTxt(String colorCode) {
		colorTxt.clear();
		colorTxt.sendKeys(colorCode);
		colorTxt.sendKeys(Keys.ENTER);
	}

	public void setShiftCounterTxt(String shiftCounter) throws Exception {
		webUtility.visibilityOfElement(driver,shiftCounterTxt);
		shiftCounterTxt.clear();
		shiftCounterTxt.sendKeys(shiftCounter);
	}

	// scroll down the page and select single skill from  availble skill
	public void setAvailableSkillForSingleSkill() {
		action.scrollToElement(availableSkill).perform();
		//		availableShiftBand.click();
		select=new Select(availableSkill);
		select.selectByIndex(1);
	}
	//	move skill from available skills to selected skill for single role  
	public void setAvailableSingleSkillMoveToSelectedSkill() {
		webUtility.moveToElement(driver, selectMoveSingle);
		selectMoveSingle.click();
	}

	public void setStartTime() {
		action.moveToElement(startTime).perform();
		startTime.clear();
	}

	public void setSelectStartTime() {

		js.executeScript("arguments[0].scrollIntoView(true);",selectStartTime);
		selectStartTime.click();
	}

	public void setEndTime() {
		action.moveToElement(endTime).perform();
		endTime.clear();
	}

	public void setSelectEndTime() {
		js.executeScript("arguments[0].scrollIntoView(true);",selectEndTime);
		selectEndTime.click();
	}

	public void setStartRangeBegin(String startRangeBeginT) {
		action.moveToElement(startRangeBegin).perform();
		startRangeBegin.clear();
		startRangeBegin.sendKeys(startRangeBeginT);
		startRangeBegin.sendKeys(Keys.ENTER);
	}
	public void setStartRangeEnd(String startRangeEndT) {
		action.moveToElement(startRangeEnd).perform();
		startRangeEnd.clear();
		startRangeEnd.sendKeys(startRangeEndT);
		startRangeEnd.sendKeys(Keys.ENTER);
	}

	public void setEndRangeBegin(String endRangeBeginT) {
		action.moveToElement(endRangeBegin).perform();
		endRangeBegin.clear();
		endRangeBegin.sendKeys(endRangeBeginT);
		endRangeBegin.sendKeys(Keys.ENTER);
	}
	public void setEndRangeEnd(String endRangeEndT) {
		action.moveToElement(endRangeEnd).perform();
		endRangeEnd.clear();
		endRangeEnd.sendKeys(endRangeEndT);
		endRangeEnd.sendKeys(Keys.ENTER);
	}

	public void setOverTimeType() {
		action.moveToElement(overTimeType).perform();
		overTimeType.click();
	}

	public void setSelectBoth() {
		action.moveToElement(selectBoth).perform();
		selectBoth.click();
	}

	public void setOverTimeStartTxt(String otStart) {
		overTimeStartTxt.clear();
		overTimeStartTxt.sendKeys(otStart);
		overTimeStartTxt.sendKeys(Keys.ENTER);
	}
	public void setOverTimeEndTxt(String otEnd) {
		overTimeEndTxt.clear();
		overTimeEndTxt.sendKeys(otEnd);
		overTimeEndTxt.sendKeys(Keys.ENTER);
	}
	public void setBtnSave() {
		btnSaveshiftbandDtls.click();
	}

	public void setNotificationPopup() throws Exception {
		webUtility.visibilityOfElement(driver, notificationPopup);
		notificationPopup.click();
	}

	public void setEditBtn() throws Exception {
		webUtility.visibilityOfElement(driver, editBtn);
		editBtn.click();
	}
	public void setcheckBox() throws Exception  {
		webUtility.visibilityOfElement(driver, checkBox);
		checkBox.click();
	}
	public void setDeleteBtn() {
		clickDeleteBtn.click();
	}
	public void setClickYes() {
		clickYes.click();
	}

	public void setErrorShiftBandTxt() {

		String errorMsg = errorShiftBandTxt.getText();
		Reporter.log(errorMsg);
	}
	public void setErrorPopup() {
		errorPopup.click();
	}

	public void createShiftBand() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 11);
		startRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 14);
		startRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 15);
		endRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 16);
		endRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 17);

		sb.setAddBtn();
		sb.setShiftBandName(shiftBandName, timeStamp);
		sb.setDescriptionTxt(description, timeStamp);
		sb.setBandCodeTxt(bandCode, timeStamp);
		sb.setShiftBandTypeTxt();
		sb.setSearchBox();
		sb.setShiftTypeSearch();
		sb.setColorTxt(colorCode);
		sb.setShiftCounterTxt(shiftCounter);
		sb.setStartTime();
		sb.setSelectStartTime();
		sb.setEndTime();
		sb.setSelectEndTime();
		sb.setStartRangeBegin(startRangeBeginT);
		sb.setStartRangeEnd(startRangeEndT);
		sb.setEndRangeBegin(endRangeBeginT);
		sb.setEndRangeEnd(endRangeEndT);
		sb.setBtnSave();
		sb.setNotificationPopup();
	}
	public void updateShiftBand() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 9);

		sb.setEditBtn();
		sb.setShiftBandName(shiftBandName, timeStamp);
		sb.setDescriptionTxt(description, timeStamp);
		sb.setBandCodeTxt(bandCode, timeStamp);
		sb.setBtnSave();
		sb.setNotificationPopup();
	}

	public void deactiveShiftBand() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);

		sb.setcheckBox();
		sb.setDeleteBtn();
		sb.setClickYes();
		sb.setNotificationPopup();
	}

	public void withoutShiftBandName() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);
		//		String shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 11);
		startRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 14);
		startRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 15);
		endRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 16);
		endRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 17);
		
		sb.setAddBtn();
		//		sb.setShiftBandName(shiftBandName, timeStamp);
		sb.setDescriptionTxt(description, timeStamp);
		sb.setBandCodeTxt(bandCode, timeStamp);
		sb.setShiftBandTypeTxt();
		sb.setSearchBox();
		sb.setShiftTypeSearch();
		sb.setColorTxt(colorCode);
		sb.setShiftCounterTxt(shiftCounter);
		sb.setStartTime();
		sb.setSelectStartTime();
		sb.setEndTime();
		sb.setSelectEndTime();
		sb.setStartRangeBegin(startRangeBeginT);
		sb.setStartRangeEnd(startRangeEndT);
		sb.setEndRangeBegin(endRangeBeginT);
		sb.setEndRangeEnd(endRangeEndT);
		sb.setBtnSave();
		// need to get the error msg for this field 
		sb.setErrorShiftBandTxt();
		//		sb.setErrorPopup();

	}
	public void shiftBandTypeCombinationShift() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 11);
		
		sb.setAddBtn();
		sb.setShiftBandName(shiftBandName, timeStamp);
		sb.setDescriptionTxt(description, timeStamp);
		sb.setBandCodeTxt(bandCode, timeStamp);
		sb.setShiftBandTypeTxt();
		sb.setSearchBox();
		sb.setShiftTpSearchCombiShift();
		sb.setColorTxt(colorCode);
		sb.setShiftCounterTxt(shiftCounter);
		Thread.sleep(500);
		sb.setAvailableSkillForSingleSkill();
		sb.setAvailableSingleSkillMoveToSelectedSkill();
		sb.setBtnSave();
		sb.setNotificationPopup();
	}
	public void shiftBandTypeOvertimeShift() throws Exception {
		sb= new SystemDefinationShiftBandPage(driver);
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 11);
		startRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 14);
		startRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 15);
		//		String endRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 16);
		//		String endRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 17);
		otStart = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 18);
		otEnd = excelUtility.readDataFromExcelFile("EmployeeTest", 12, 19);

		sb.setAddBtn();
		sb.setShiftBandName(shiftBandName, timeStamp);
		sb.setDescriptionTxt(description, timeStamp);
		sb.setBandCodeTxt(bandCode, timeStamp);
		sb.setShiftBandTypeTxt();
		sb.setSearchBox();
		sb.setShiftTpSearchOvertime();
		sb.setColorTxt(colorCode);
		sb.setShiftCounterTxt(shiftCounter);
		sb.setStartTime();
		sb.setSelectStartTime();
		sb.setEndTime();
		sb.setSelectEndTime();
		//		sb.setStartRangeBegin(startRangeBeginT);
		//		sb.setStartRangeEnd(startRangeEndT);
		//		sb.setEndRangeBegin(endRangeBeginT);
		//		sb.setEndRangeEnd(endRangeEndT);
		sb.setOverTimeType();
		sb.setSelectBoth();
		sb.setOverTimeStartTxt(otStart);
		sb.setOverTimeEndTxt(otEnd);

		sb.setBtnSave();
		sb.setNotificationPopup();
	}
}
