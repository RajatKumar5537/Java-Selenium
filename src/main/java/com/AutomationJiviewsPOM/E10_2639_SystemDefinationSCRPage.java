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

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class E10_2639_SystemDefinationSCRPage extends BaseClass{

	public String timeStamp = LocalDateTime.now().toString();
	public Actions action;
	public Select select;
	public WebUtilities webUtility;
	public ExcelUtilities excelUtility;
	public E10_2639_SystemDefinationSCRPage scr;

	@FindBy(xpath = "//button[@id='btnAddScheduleRule']")
	private WebElement btnAddScheduleRule;

	@FindBy(xpath = "//input[@id='txtScheduleRuleName']")
	private WebElement txtScheduleRuleName;

	@FindBy(xpath = "//input[@id='txtScheduleRuleDesc']")
	private WebElement txtScheduleRuleDesc;

	@FindBy(xpath = "//input[@id='txtValidFrom']")
	private WebElement txtValidFrom;

	@FindBy(xpath = "//input[@id='txtValidTo']")
	private WebElement txtValidTo;

	@FindBy(xpath =  "//input[@id='txtPeriodLength']")
	private WebElement txtPeriodLength;

	@FindBy(xpath = "//span[text()='IsActive?']")
	private WebElement chkIsActive;

	@FindBy(xpath = "//input[@id='txtShiftlengthMin']")
	private WebElement txtShiftlengthMin;

	@FindBy(xpath = "//input[@id='txtShiftlengthMax']")
	private WebElement txtShiftlengthMax;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOnMin']")
	private WebElement txtContDaysScheduleOnMin;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOnMax']")
	private WebElement txtContDaysScheduleOnMax;

	@FindBy(xpath = "//input[@id='txtDaysPerPeriodMin']")
	private WebElement txtDaysPerPeriodMin;

	@FindBy(xpath = "//input[@id='txtDaysPerPeriodMax']")
	private WebElement txtDaysPerPeriodMax;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOffMin']")
	private WebElement txtContDaysScheduleOffMin;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOffMax']")
	private WebElement txtContDaysScheduleOffMax;

	@FindBy(xpath = "//input[@id='txtTimePerPeriodMin']")
	private WebElement txtTimePerPeriodMin;

	@FindBy(xpath = "//input[@id='txtTimePerPeriodMax']")
	private WebElement txtTimePerPeriodMax;

	//Include Leave Option 
	@FindBy(xpath = "(//label[@class='custom-control custom-checkbox m-0'])[2]")
	private WebElement chkIsActive2;

	//Next button 
	@FindBy(xpath = "//button[@id='btnAddScheduleRuleShiftBands']")
	private WebElement btnAddScheduleRuleShiftBands;

	// After New Button 

	@FindBy(xpath = "//input[@id='txtContDaysOnMin']")
	private WebElement txtContDaysOnMin;

	@FindBy(xpath = "//input[@id='txtContDaysOnMax']")
	private WebElement txtContDaysOnMax;

	@FindBy(xpath = "//input[@id='txtContDaysOffMin']")
	private WebElement txtContDaysOffMin;

	@FindBy(xpath = "//input[@id='txtContDaysOffMax']")
	private WebElement txtContDaysOffMax;

	@FindBy(xpath = "//input[@id='txtShiftBandsPerPeriodMin']")
	private WebElement txtShiftBandsPerPeriodMin;

	@FindBy(xpath = "//input[@id='txtShiftBandsPerPeriodMax']")
	private WebElement txtShiftBandsPerPeriodMax;

	@FindBy(xpath = "//input[@id='txtMinHourRest']")
	private WebElement txtMinHourRest;

	// Available Shift Band table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableShiftBand;

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

	@FindBy(xpath = "//button[@id='btnSaveScheduleRulePeriod']")
	private WebElement btnSaveScheduleRulePeriod;

	@FindBy(xpath = "//button[@id='btnSaveScheduleCreationRule']")
	private WebElement btnSaveScheduleCreationRule;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement btnEdit;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//table[@id='ScheduleRule-list']/tbody/tr")
	private List<WebElement> row;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='ScheduleRule-list_next']")
	private WebElement nextPage;
	
	@FindBy(xpath = "(//tr[@role='row']/td/input)[1]")
	private WebElement checkBox;

	@FindBy(xpath = "//button[@id='btnDeleteScheduleRule']")
	private WebElement btnDeletePublicHlday;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	public E10_2639_SystemDefinationSCRPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
		this.excelUtility= new ExcelUtilities();
		this.webUtility= new WebUtilities(driver);
	}

	public void setBtnAddScheduleRule() {
		btnAddScheduleRule.click();
	}

	public void setTxtScheduleRuleName(String ruleName) throws InterruptedException {
		Thread.sleep(2000);
		txtScheduleRuleName.clear();
		txtScheduleRuleName.sendKeys(ruleName);
	}

	public void setTxtScheduleRuleDesc(String ruleDesc) {
		txtScheduleRuleDesc.clear();
		txtScheduleRuleDesc.sendKeys(ruleDesc);
	}

	public void setTxtValidFrom(String validFrom) {
		txtValidFrom.clear();
		txtValidFrom.sendKeys(validFrom);
		txtValidFrom.sendKeys(Keys.ENTER);
	}
	public void setTxtValidTo(String validTo) {
		txtValidTo.clear();
		txtValidTo.sendKeys(validTo);
	}
	public void setTxtPeriodLength(String periodLength) {
		txtPeriodLength.clear();
		txtPeriodLength.sendKeys(periodLength);
	}
	public void setChkIsActive() {
		action.scrollToElement(chkIsActive).perform();
		chkIsActive.click();
	}
	public void setTxtShiftlengthMin(String lengthMin) {
		txtShiftlengthMin.clear();
		txtShiftlengthMin.sendKeys(lengthMin);
		txtShiftlengthMin.sendKeys(Keys.ENTER);
	}
	public void setTxtShiftlengthMax(String lengthMax) {
		txtShiftlengthMax.clear();
		txtShiftlengthMax.sendKeys(lengthMax);
		txtShiftlengthMax.sendKeys(Keys.ENTER);
	}
	public void setTxtContDaysScheduleOnMin(String workDayMin) {
		txtContDaysScheduleOnMin.clear();
		txtContDaysScheduleOnMin.sendKeys(workDayMin);
	}
	public void setTxtContDaysScheduleOnMax(String workDayMax) {
		txtContDaysScheduleOnMax.clear();
		txtContDaysScheduleOnMax.sendKeys(workDayMax);
	}
	public void setTxtDaysPerPeriodMin(String dayPeriodMin) {
		txtDaysPerPeriodMin.clear();
		txtDaysPerPeriodMin.sendKeys(dayPeriodMin);
	}
	public void setTxtDaysPerPeriodMax(String dayPeriodMax) {
		txtDaysPerPeriodMax.clear();
		txtDaysPerPeriodMax.sendKeys(dayPeriodMax);
	}
	public void setTxtContDaysScheduleOffMin(String offDayMin) {
		txtContDaysScheduleOffMin.clear();
		txtContDaysScheduleOffMin.sendKeys(offDayMin);
	}
	public void setTxtContDaysScheduleOffMax(String offDayMax) {
		txtContDaysScheduleOffMax.clear();
		txtContDaysScheduleOffMax.sendKeys(offDayMax);
	}
	public void setTxtTimePerPeriodMin(String timePeriodMin) {
		txtTimePerPeriodMin.clear();
		txtTimePerPeriodMin.sendKeys(timePeriodMin);
	}
	public void setTxtTimePerPeriodMax(String timePeriodMax) {
		txtTimePerPeriodMax.clear();
		txtTimePerPeriodMax.sendKeys(timePeriodMax);
	}
	//Include Leave Option 
	public void setChkIsActive2() {
		chkIsActive2.click();
	}
	public void setBtnAddScheduleRuleShiftBands() {
		btnAddScheduleRuleShiftBands.click();
	}
	public void setTxtContDaysOnMin(String countDayMin) {
		txtContDaysOnMin.clear();
		txtContDaysOnMin.sendKeys(countDayMin);
	}
	public void setTxtContDaysOnMax(String countDayMax) {
		txtContDaysOnMax.clear();
		txtContDaysOnMax.sendKeys(countDayMax);
	}
	public void setTxtContDaysOffMin(String countOffMin) {
		txtContDaysOffMin.clear();
		txtContDaysOffMin.sendKeys(countOffMin);
	}
	public void setTxtContDaysOffMax(String countOffMax) {
		txtContDaysOffMax.clear();
		txtContDaysOffMax.sendKeys(countOffMax);
	}
	public void setTxtShiftBandsPerPeriodMin(String shiftBandMin) {
		txtShiftBandsPerPeriodMin.clear();
		txtShiftBandsPerPeriodMin.sendKeys(shiftBandMin);
	}
	public void setTxtShiftBandsPerPeriodMax(String shiftBandMax) {
		txtShiftBandsPerPeriodMax.clear();
		txtShiftBandsPerPeriodMax.sendKeys(shiftBandMax);
	}
	public void setTxtMinHourRest(String minHourRest) {
		txtMinHourRest.clear();
		txtMinHourRest.sendKeys(minHourRest);
		txtMinHourRest.sendKeys(Keys.ENTER);
	}
	public void setAvailableShiftBand() {
		action.scrollToElement(availableShiftBand).perform();
		//		availableShiftBand.click();
		select=new Select(availableShiftBand);
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
	public void setBtnSaveScheduleRulePeriod()  {
		btnSaveScheduleRulePeriod.click();
	}

	public void setBtnSaveScheduleCreationRule() throws Exception {
		webUtility.moveToElement(driver, btnSaveScheduleCreationRule);
		btnSaveScheduleCreationRule.click();
	}

	public void setBtnEdit() {
		webUtility.moveToElement(driver, btnEdit);
		btnEdit.click();
	}
	public void setNotificationPopup() {
		webUtility.moveToElement(driver, notificationPopup);
		notificationPopup.click();
	}
	public void setCheckbox() {
		//		webUtility.moveToElement(driver, checkBox);
		checkBox.click();
	}
	public void performDeleteAction() throws InterruptedException {
		//		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeletePublicHlday);
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
		
		
		
	public void setBtnDeletePublicHlday() {
		btnDeletePublicHlday.click();
	}
	public void setBtnYes() throws Exception {
		webUtility.visibilityOfElement(driver, btnYes);
		btnYes.click();
	}
	public void clickNotificationPopup() throws Exception {
		webUtility.moveToElement(driver, notificationPopup);
		notificationPopup.click();
	}
	public void setCreateSCR() throws Exception {
		timeStamp = LocalDateTime.now().toString();

//		String ruleName = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 7);
//		String ruleDesc = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 8);
		String validFrom = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 9);
		//		String validTo = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 10);
		String periodLength = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 11);
		String lengthMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 12);
		String lengthMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 13);
		String workDayMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 14);
		String workDayMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 15);
		String dayPeriodMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 16);
		String dayPeriodMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 17);
		String offDayMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 18);
		String offDayMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 19);
		String timePeriodMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 20);
		String timePeriodMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 21);
		// After Next button 
		String countDayMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 22);
		String countDayMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 23);
		String countOffMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 24);
		String countOffMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 25);
		String shiftBandMin = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 26);
		String shiftBandMax = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 27);
		String minHourRest = excelUtility.readDataFromExcelFile("EmployeeTest", 20, 28);

		setBtnAddScheduleRule();
//		setTxtScheduleRuleName(ruleName+ " "+ timeStamp);
		setTxtScheduleRuleName(fakeEmployee.getFirstName()+ System.currentTimeMillis());
		
//		setTxtScheduleRuleDesc(ruleDesc+ " "+ timeStamp);
		setTxtScheduleRuleDesc(fakeEmployee.getDescription()+ System.currentTimeMillis());
		
		setTxtValidFrom(validFrom);
		//		setTxtValidTo(validTo);
		setTxtPeriodLength(periodLength);
		setChkIsActive();
		setTxtShiftlengthMin(lengthMin);
		setTxtShiftlengthMax(lengthMax);
		setTxtContDaysScheduleOnMin(workDayMin);
		setTxtContDaysScheduleOnMax(workDayMax);
		setTxtDaysPerPeriodMin(dayPeriodMin);
		setTxtDaysPerPeriodMax(dayPeriodMax);
		setTxtContDaysScheduleOffMin(offDayMin);
		setTxtContDaysScheduleOffMax(offDayMax);
		setTxtTimePerPeriodMin(timePeriodMin);
		setTxtTimePerPeriodMax(timePeriodMax);
		//Include Leave Option 
		setChkIsActive2();
		//Next button 
		setBtnAddScheduleRuleShiftBands();
		setTxtContDaysOnMin(countDayMin);
		setTxtContDaysOnMax(countDayMax);
		setTxtContDaysOffMin(countOffMin);
		setTxtContDaysOffMax(countOffMax);
		setTxtShiftBandsPerPeriodMin(shiftBandMin);
		setTxtShiftBandsPerPeriodMax(shiftBandMax);
		setTxtMinHourRest(minHourRest);
		Thread.sleep(2000);
		setAvailableShiftBand();
		setSelectMoveSingle();
		setBtnSaveScheduleRulePeriod();
		Thread.sleep(2000);
		setBtnSaveScheduleCreationRule();
		clickNotificationPopup();
	}

	public void setUpdateSCR() throws Exception {
//		String ruleName = excelUtility.readDataFromExcelFile("EmployeeTest", 21, 7);
//		String ruleDesc = excelUtility.readDataFromExcelFile("EmployeeTest", 21, 8);


		setBtnEdit();
//		setTxtScheduleRuleName(ruleName+ " "+ timeStamp);
		setTxtScheduleRuleName(fakeEmployee.getFirstName()+ " " +System.currentTimeMillis());
		
//		setTxtScheduleRuleDesc(ruleDesc+ " "+ timeStamp);
		setTxtScheduleRuleDesc(fakeEmployee.getDescription()+ System.currentTimeMillis());
		Thread.sleep(1000);
		setBtnSaveScheduleCreationRule();
		clickNotificationPopup();

	}
	public void setDeactivateSCR() throws Exception {

		deleteRowsWithEnabledCheckbox();
		setBtnYes(); 
		
//		setCheckbox();
//		Thread.sleep(2000);
//		setBtnDeletePublicHlday();
//		setBtnYes();
		clickNotificationPopup();
	}

	public void setReactivateSCR() throws Exception {

		setBtnEdit();
		Thread.sleep(2000);
		setChkIsActive();
		Thread.sleep(1000);
		setBtnSaveScheduleCreationRule();
		clickNotificationPopup();
	}
}
