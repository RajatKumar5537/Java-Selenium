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

public class E10_2639_SystemDefinationSCRPage 
{

	WebDriver driver; 
	ReusableComponent Rc ;
	public ExcelUtilities excelUtility;
	String ruleName;

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
	List<WebElement> sideNavMenu; // Schedule Creation Rules

	@FindBy(xpath = "//button[@id='btnAddScheduleRule']")
	WebElement btnAddScheduleRule;

	@FindBy(xpath = "//input[@id='txtScheduleRuleName']")
	WebElement txtScheduleRuleName;

	@FindBy(xpath = "//input[@id='txtScheduleRuleDesc']")
	WebElement txtScheduleRuleDesc;

	@FindBy(xpath = "//input[@id='txtValidFrom']")
	WebElement txtValidFrom;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[10]")
	WebElement calender;

	@FindBy(xpath = "//input[@id='txtValidTo']")
	WebElement txtValidTo;

	@FindBy(xpath =  "//input[@id='txtPeriodLength']")
	WebElement txtPeriodLength;


	@FindBy(xpath = "//span[text()='IsActive?']")
	WebElement chkIsActive;

	@FindBy(xpath = "//input[@id='txtShiftlengthMin']")
	WebElement txtShiftlengthMin;

	@FindBy(xpath = "//input[@id='txtShiftlengthMax']")
	WebElement txtShiftlengthMax;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOnMin']")
	WebElement txtContDaysScheduleOnMin;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOnMax']")
	WebElement txtContDaysScheduleOnMax;

	@FindBy(xpath = "//input[@id='txtDaysPerPeriodMin']")
	WebElement txtDaysPerPeriodMin;

	@FindBy(xpath = "//input[@id='txtDaysPerPeriodMax']")
	WebElement txtDaysPerPeriodMax;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOffMin']")
	WebElement txtContDaysScheduleOffMin;

	@FindBy(xpath = "//input[@id='txtContDaysScheduleOffMax']")
	WebElement txtContDaysScheduleOffMax;

	@FindBy(xpath = "//input[@id='txtTimePerPeriodMin']")
	WebElement txtTimePerPeriodMin;

	@FindBy(xpath = "//input[@id='txtTimePerPeriodMax']")
	WebElement txtTimePerPeriodMax;

	//Include Leave Option 
	@FindBy(xpath = "(//label[@class='custom-control custom-checkbox m-0'])[2]")
	WebElement chkIsActive2;

	//Next button 
	@FindBy(xpath = "//button[@id='btnAddScheduleRuleShiftBands']")
	WebElement btnAddScheduleRuleShiftBands;

	// After New Button 

	@FindBy(xpath = "//input[@id='txtContDaysOnMin']")
	WebElement txtContDaysOnMin;

	@FindBy(xpath = "//input[@id='txtContDaysOnMax']")
	WebElement txtContDaysOnMax;

	@FindBy(xpath = "//input[@id='txtContDaysOffMin']")
	WebElement txtContDaysOffMin;

	@FindBy(xpath = "//input[@id='txtContDaysOffMax']")
	WebElement txtContDaysOffMax;

	@FindBy(xpath = "//input[@id='txtShiftBandsPerPeriodMin']")
	WebElement txtShiftBandsPerPeriodMin;

	@FindBy(xpath = "//input[@id='txtShiftBandsPerPeriodMax']")
	WebElement txtShiftBandsPerPeriodMax;

	@FindBy(xpath = "//input[@id='txtMinHourRest']")
	WebElement txtMinHourRest;

	// Available Shift Band table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement availableShiftBand;

	// select for single Arrow -> move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle; 

	//		select for move multiple skill from available skill table to Selected skiil table 
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

	@FindBy(xpath = "//button[@id='btnSaveScheduleRulePeriod']")
	WebElement btnSaveScheduleRulePeriod;

	@FindBy(xpath = "//button[@id='btnSaveScheduleCreationRule']")
	WebElement btnSaveScheduleCreationRule;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchBar;
	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1'])[1]")
	WebElement btnEdit;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//table[@id='ScheduleRule-list']/tbody/tr")
	List<WebElement> row;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='ScheduleRule-list_next']")
	WebElement nextPage;

	@FindBy(xpath = "(//tr[@role='row']/td/input)[1]")
	WebElement checkBox;

	@FindBy(xpath = "//button[@id='btnDeleteScheduleRule']")
	WebElement btnDeletePublicHlday;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;

	@FindBy(xpath = "//div[text()='Schedule Creation Rules created successfully.']")
	WebElement scrCreatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Schedule Creation Rules details updated successfully.']")
	WebElement scrUpdatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Schedule Creation Rule deleted successfully']")
	WebElement scrDeletedSuccessfullyMsg;



	public E10_2639_SystemDefinationSCRPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Rc= new ReusableComponent(driver);
		this.excelUtility= new ExcelUtilities();
	}


	public void createSCR() throws Exception 
	{
		ruleName = Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Schedule Creation Rules", "Schedule Creation Rules is not clicked");



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

		

		btnAddScheduleRule.click();
		Thread.sleep(2000);
		Rc.explicitWait(txtScheduleRuleName, "visibility");
		txtScheduleRuleName.clear();
		txtScheduleRuleName.sendKeys(ruleName);
		txtScheduleRuleDesc.clear();
		txtScheduleRuleDesc.sendKeys(Rc.description);
		txtValidFrom.click();
		calender.click();
		txtPeriodLength.clear();
		txtPeriodLength.sendKeys(periodLength);
		txtShiftlengthMin.clear();
		txtShiftlengthMin.sendKeys(lengthMin);
		txtShiftlengthMin.sendKeys(Keys.ENTER);
		txtShiftlengthMax.clear();
		txtShiftlengthMax.sendKeys(lengthMax);
		txtShiftlengthMax.sendKeys(Keys.ENTER);
		txtContDaysScheduleOnMin.clear();
		txtContDaysScheduleOnMin.sendKeys(workDayMin);
		txtContDaysScheduleOnMax.clear();
		txtContDaysScheduleOnMax.sendKeys(workDayMax);
		txtDaysPerPeriodMin.clear();
		txtDaysPerPeriodMin.sendKeys(dayPeriodMin);
		txtDaysPerPeriodMax.clear();
		txtDaysPerPeriodMax.sendKeys(dayPeriodMax);
		txtContDaysScheduleOffMin.clear();
		txtContDaysScheduleOffMin.sendKeys(offDayMin);
		txtContDaysScheduleOffMax.clear();
		txtContDaysScheduleOffMax.sendKeys(offDayMax);
		txtTimePerPeriodMin.clear();
		txtTimePerPeriodMin.sendKeys(timePeriodMin);
		txtTimePerPeriodMax.clear();
		txtTimePerPeriodMax.sendKeys(timePeriodMax);
		chkIsActive2.click();
		//Next button 
		btnAddScheduleRuleShiftBands.click();
		txtContDaysOnMin.clear();
		txtContDaysOnMin.sendKeys(countDayMin);
		txtContDaysOnMax.clear();
		txtContDaysOnMax.sendKeys(countDayMax);
		txtContDaysOffMin.clear();
		txtContDaysOffMin.sendKeys(countOffMin);
		txtContDaysOffMax.clear();
		txtContDaysOffMax.sendKeys(countOffMax);
		txtShiftBandsPerPeriodMin.clear();
		txtShiftBandsPerPeriodMin.sendKeys(shiftBandMin);
		txtShiftBandsPerPeriodMax.clear();
		txtShiftBandsPerPeriodMax.sendKeys(shiftBandMax);
		txtMinHourRest.clear();
		txtMinHourRest.sendKeys(minHourRest);
		txtMinHourRest.sendKeys(Keys.ENTER);
		Rc.scrollToElement(availableShiftBand);
		Rc.selectByIndex(availableShiftBand, 1);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		btnSaveScheduleRulePeriod.click();
		Thread.sleep(3000);
		//		Rc.explicitWait(btnSaveScheduleCreationRule, "clickable");
		Rc.moveToElement(btnSaveScheduleCreationRule);
		btnSaveScheduleCreationRule.click();
		Rc.explicitWait(scrCreatedSuccessfullyMsg, "visible");
		String actualResult = scrCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Schedule Creation Rules created successfully."));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void setUpdateSCR() throws Exception 
	{
		ruleName = Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(searchBar, "visible");
		searchBar.clear();
		searchBar.sendKeys(ruleName);
		Rc.explicitWait(btnEdit, "clickable");
		btnEdit.click();
		Thread.sleep(2000);
		Rc.explicitWait(txtScheduleRuleName, "visible");
		txtScheduleRuleName.clear();
		txtScheduleRuleName.sendKeys(ruleName);
		Rc.explicitWait(txtScheduleRuleDesc, "visible");
		txtScheduleRuleDesc.clear();
		txtScheduleRuleDesc.sendKeys(Rc.description);
		Rc.moveToElement(btnSaveScheduleCreationRule);
		btnSaveScheduleCreationRule.click();
		Rc.explicitWait(scrUpdatedSuccessfullyMsg, "visible");
		String actualResult = scrUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Schedule Creation Rules details updated successfully."));
		Rc.explicitWait(notificationPopup, "visible");
		notificationPopup.click();


	}
	public void setDeactivateSCR() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(searchBar, "visible");
		searchBar.clear();
		searchBar.sendKeys(ruleName);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.explicitWait(btnDeletePublicHlday, "clickable");
		btnDeletePublicHlday.click();
		Rc.explicitWait(btnYes, "clickable");
		btnYes.click(); 
		Rc.explicitWait(scrDeletedSuccessfullyMsg, "visible");
		String actualResult = scrDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Schedule Creation Rule deleted successfully"));
		Rc.explicitWait(notificationPopup, "visible");
		notificationPopup.click();

	}

	public void setReactivateSCR() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(searchBar, "visible");
		searchBar.clear();
		searchBar.sendKeys(ruleName);
		Rc.explicitWait(btnEdit, "clickable");
		btnEdit.click();
		Thread.sleep(2000);
		Rc.explicitWait(chkIsActive, "clickable");
		chkIsActive.click();
		Rc.explicitWait(btnSaveScheduleCreationRule, "clickable");
		btnSaveScheduleCreationRule.click();
		Rc.explicitWait(scrUpdatedSuccessfullyMsg, "visible");
		String actualResult = scrUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Schedule Creation Rules details updated successfully."));
		Rc.explicitWait(notificationPopup, "visible");
		notificationPopup.click();

	}
}
