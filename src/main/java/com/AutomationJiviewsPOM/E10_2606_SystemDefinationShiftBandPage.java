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
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class E10_2606_SystemDefinationShiftBandPage  extends BaseClass{

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
	E10_2606_SystemDefinationShiftBandPage sb;

	@FindBy(id = "btnAddNew")
	private WebElement addBtn;

	@FindBy(id = "txtShtBandName")
	private WebElement shiftBandNameTxt;

	@FindBy (id = "txtShiftbandDesc")
	private WebElement descriptionTxt;

	@FindBy(id = "txtShiftBandCode")
	private WebElement bandCodeTxt;

	@FindBy(id = "select2-cmbShiftBandId-container") //span[@id='select2-cmbShiftBandId-container']
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

	@FindBy(xpath = "//span[text()='×']")
	private WebElement clearSearch;
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

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement editBtn;
	@FindBy(xpath = "//span[text()='IsActive?']")
	private WebElement checkIsActive;

	@FindBy(xpath = "//table[@id='shftband-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='shftband-list_next']")
	private WebElement nextPage;


	@FindBy(xpath = "//button[@id='btnDeleteshftband']")
	private WebElement btnDeleteshftband;

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

	public E10_2606_SystemDefinationShiftBandPage(WebDriver driver) {
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

	public void setShiftTpSearchCombiShift() throws InterruptedException {
		setShiftTpSearchOvertime();
		Thread.sleep(2000);
		setShiftBandTypeTxt();
//		clearSearch.click();
		Thread.sleep(3000);
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
	public void setAvailableSkillForSingleSkill() throws InterruptedException {
		Thread.sleep(2000);
		action.moveToElement(availableSkill).perform();
		select = new Select(availableSkill);
		select.selectByIndex(0);
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
	public void performDeleteAction() throws InterruptedException {
		//		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteshftband);
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

	//	public void setcheckBox() throws Exception  {
	//		webUtility.visibilityOfElement(driver, checkBox);
	//		checkBox.click();
	//	}
	public void setDeleteBtn() {
		btnDeleteshftband.click();
	}
	public void setClickYes() {
		clickYes.click();
	}
	public void clickonIsActive() {
		checkIsActive.click();	
	}
	public void setErrorShiftBandTxt() {

		String errorMsg = errorShiftBandTxt.getText();
		Reporter.log(errorMsg);
	}
	public void setErrorPopup() {
		errorPopup.click();
	}

	public void createShiftBand() throws Exception {
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 11);
		startRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 14);
		startRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 15);
		endRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 16);
		endRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 17);

		setAddBtn();
		setShiftBandName(shiftBandName, timeStamp);
		setDescriptionTxt(description, timeStamp);
		setBandCodeTxt(bandCode, timeStamp);
		setShiftBandTypeTxt();
		setSearchBox();
		setShiftTypeSearch();
		setColorTxt(colorCode);
		setShiftCounterTxt(shiftCounter);
		setStartTime();
		setSelectStartTime();
		setEndTime();
		setSelectEndTime();
		setStartRangeBegin(startRangeBeginT);
		setStartRangeEnd(startRangeEndT);
		setEndRangeBegin(endRangeBeginT);
		setEndRangeEnd(endRangeEndT);
		setBtnSave();
		setNotificationPopup();
	}
	public void updateShiftBand() throws Exception {
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 10, 9);

		setEditBtn();
		setShiftBandName(shiftBandName, timeStamp);
		setDescriptionTxt(description, timeStamp);
		setBandCodeTxt(bandCode, timeStamp);
		setBtnSave();
				setNotificationPopup();
	}

	public void deactiveShiftBand() throws Exception {

		deleteRowsWithEnabledCheckbox();
		setClickYes();
		setNotificationPopup();
	}

	public void reactivateShiftBand() throws Exception {

		setEditBtn();
		clickonIsActive();
		setBtnSave();
	}

	public void withoutShiftBandName() throws Exception {
		//		String shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 11);
		startRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 14);
		startRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 15);
		endRangeBeginT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 16);
		endRangeEndT = excelUtility.readDataFromExcelFile("EmployeeTest", 9, 17);

		setAddBtn();
		//		setShiftBandName(shiftBandName, timeStamp);
		setDescriptionTxt(description, timeStamp);
		setBandCodeTxt(bandCode, timeStamp);
		setShiftBandTypeTxt();
		setSearchBox();
		setShiftTypeSearch();
		setColorTxt(colorCode);
		setShiftCounterTxt(shiftCounter);
		setStartTime();
		setSelectStartTime();
		setEndTime();
		setSelectEndTime();
		setStartRangeBegin(startRangeBeginT);
		setStartRangeEnd(startRangeEndT);
		setEndRangeBegin(endRangeBeginT);
		setEndRangeEnd(endRangeEndT);
		setBtnSave();
		// need to get the error msg for this field 
		setErrorShiftBandTxt();
		//		setErrorPopup();

	}
	public void shiftBandTypeCombinationShift() throws Exception {
		shiftBandName = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 7);
		description = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 8);
		bandCode = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 9);
		colorCode = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 10);
		shiftCounter = excelUtility.readDataFromExcelFile("EmployeeTest", 11, 11);

		setAddBtn();
		setShiftBandName(shiftBandName, timeStamp);
		setDescriptionTxt(description, timeStamp);
		setBandCodeTxt(bandCode, timeStamp);
		setShiftBandTypeTxt();
		//		setSearchBox(); not required 
		setShiftTpSearchCombiShift();
		setColorTxt(colorCode);
		setShiftCounterTxt(shiftCounter);
		Thread.sleep(2000);
		setAvailableSkillForSingleSkill();
		Thread.sleep(1000);
		setAvailableSingleSkillMoveToSelectedSkill();
		setBtnSave();
		Thread.sleep(1000);
		setNotificationPopup();
	}
	public void shiftBandTypeOvertimeShift() throws Exception {
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

		setAddBtn();
		setShiftBandName(shiftBandName, timeStamp);
		setDescriptionTxt(description, timeStamp);
		setBandCodeTxt(bandCode, timeStamp);
		setShiftBandTypeTxt();
		setSearchBox();
		setShiftTpSearchOvertime();
		setColorTxt(colorCode);
		setShiftCounterTxt(shiftCounter);
		setStartTime();
		setSelectStartTime();
		setEndTime();
		setSelectEndTime();
		setOverTimeType();
		setSelectBoth();
		setOverTimeStartTxt(otStart);
		setOverTimeEndTxt(otEnd);

		setBtnSave();
		setNotificationPopup();
	}
}
