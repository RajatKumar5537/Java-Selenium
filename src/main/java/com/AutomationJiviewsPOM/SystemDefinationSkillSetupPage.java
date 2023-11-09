package com.AutomationJiviewsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;


public class SystemDefinationSkillSetupPage extends BaseClass {

	//	String timeStamp = LocalDateTime.now().toString();
	public SystemDefinationSkillSetupPage sds;
	//	public ExcelUtilities excelUtility;
	//	public WebUtilities webUtility;

	@FindBy(xpath = "//button[@id='btnAddSkill']")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@id='txtSkillCode']")
	private WebElement skillCode;

	@FindBy(id="txtSkillCodeDescription")
	private WebElement skillDescription;

	@FindBy(id = "txtSequence")
	private WebElement sequence;

	@FindBy(id = "txtColourCode")
	private WebElement ColourCode;

	@FindBy(id = "txtFixedRanking")
	private WebElement wageLevelCode;

	@FindBy(xpath = "//span[text()='Is Active?']")
	private WebElement isActiveOption;

	@FindBy(id = "btnSaveSkill")
	private WebElement saveBtn;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement editBtn;

	@FindBy(id = "btnDeleteSkill")
	private WebElement clickDeleteBtn;

	@FindBy(xpath = "//button[.='Yes']")
	private WebElement clickYes;

	@FindBy(xpath =  "(//input[@type='checkbox'])[2]")
	private WebElement checkBox;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchColumns;

	public SystemDefinationSkillSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//		this.webUtility= new WebUtilities(driver);
		//		this.excelUtility= new ExcelUtilities();
	}

	//	public void addBtn() throws Exception {
	//		webUtility.visibilityOfElement(driver, addBtn);
	//		addBtn.click();
	//	}
	//
	//	public void skillCode(String skillCodeData, String timeStamp) throws Exception {
	//		webUtility.visibilityOfElement(driver,skillCode);
	//		skillCode.clear();
	//		skillCode.sendKeys(skillCodeData + " " + timeStamp);
	//	}
	//
	//
	//	public void skillDescription(String skillDescriptionData, String timeStamp) {
	//		skillDescription.clear();
	//		skillDescription.sendKeys(skillDescriptionData + " "+ timeStamp);
	//	}
	//
	//	public void sequence(String sequenceData) {
	//		sequence.clear();
	//		sequence.sendKeys(sequenceData);
	//	}
	//
	//	public void coloreCode() {
	//		ColourCode.sendKeys("");
	//	}
	//
	//	public void wageLevelCode(String wageLevelCodedata, String timeStamp) {
	//		wageLevelCode.clear();
	//		wageLevelCode.sendKeys(wageLevelCodedata+ " "+ timeStamp);
	//	}
	//	public void isActiveOption() {
	//		isActiveOption.click();
	//
	//	}
	//	public void saveBtn() throws Exception {
	//		webUtility.visibilityOfElement(driver,saveBtn);
	//		saveBtn.click();
	//	}
	//
	//	public void setNotificationPopup() throws Exception {
	//		webUtility.visibilityOfElement(driver, notificationPopup);
	//		notificationPopup.click();
	//	}
	//	public void setEditBtn() throws Exception {
	//		webUtility.visibilityOfElement(driver, editBtn);
	//		editBtn.click();
	//	}
	//	public void setcheckBox() throws Exception  {
	//		webUtility.visibilityOfElement(driver, checkBox);
	//		checkBox.click();
	//	}
	//
	//	public void setDeleteBtn() {
	//		clickDeleteBtn.click();
	//	}
	//	public void setClickYes() {
	//		clickYes.click();
	//	}
	//
	//	public void setSearchColumn(String searchColumnsData) throws Exception {
	//		webUtility.visibilityOfElement(driver, searchColumns);
	//		searchColumns.clear();
	//		searchColumns.sendKeys(searchColumnsData);
	//
	//	}
	public void clickAddBtn() throws Exception {
		webUtility.visibilityOfElement(driver, addBtn);
		addBtn.click();
	}

	public void enterSkillCode(String skillCodeData) throws Exception {
		webUtility.visibilityOfElement(driver, skillCode);
		skillCode.clear();
		skillCode.sendKeys(skillCodeData + " " + timeStamp);
	}

	public void enterSkillDescription(String skillDescriptionData) {
		skillDescription.clear();
		skillDescription.sendKeys(skillDescriptionData + " " + timeStamp);
	}

	public void enterSequence(String sequenceData) {
		sequence.clear();
		sequence.sendKeys(sequenceData);
	}

	public void enterWageLevelCode(String wageLevelCodedata) {
		wageLevelCode.clear();
		wageLevelCode.sendKeys(wageLevelCodedata + " " + timeStamp);
	}

	public void clickIsActiveOption() {
		isActiveOption.click();
	}

	public void clickSaveBtn() throws Exception {
		webUtility.visibilityOfElement(driver, saveBtn);
		saveBtn.click();
	}

	public void closeNotificationPopup() throws Exception {
		webUtility.visibilityOfElement(driver, notificationPopup);
		notificationPopup.click();
	}

	public void clickEditBtn() throws Exception {
		webUtility.visibilityOfElement(driver, editBtn);
		editBtn.click();
	}

	public void checkCheckBox() throws Exception {
		webUtility.visibilityOfElement(driver, checkBox);
		checkBox.click();
	}

	public void clickDeleteBtn() {
		clickDeleteBtn.click();
	}

	public void clickYes() {
		clickYes.click();
	}

	public void enterSearchColumns(String searchColumnsData) throws Exception {
		webUtility.visibilityOfElement(driver, searchColumns);
		searchColumns.clear();
		searchColumns.sendKeys(searchColumnsData);
	}
	public void createNewSkill() throws Exception {
		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 8);
		String sequenceData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 9);
		String wageLevelCodedata = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 11);

		sds = new SystemDefinationSkillSetupPage(driver);
		sds.clickAddBtn();
		sds.enterSkillCode(skillCodeData);
		sds.enterSkillDescription(skillDescriptionData);
		sds.enterSequence(sequenceData);
		sds.enterWageLevelCode(wageLevelCodedata);
		sds.clickIsActiveOption();
		sds.clickSaveBtn();
		sds.closeNotificationPopup();
	}

	public void updateSkill() throws Exception {
		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 8);

		sds = new SystemDefinationSkillSetupPage(driver);
		sds.clickEditBtn();
		sds.enterSkillCode(skillCodeData);
		sds.enterSkillDescription(skillDescriptionData);
		sds.clickSaveBtn();
		sds.closeNotificationPopup();
	}

	public void deactivateSkill() throws Exception {
		sds = new SystemDefinationSkillSetupPage(driver);
		sds.checkCheckBox();
		sds.clickDeleteBtn();
		sds.clickYes();
		sds.closeNotificationPopup();
	}

	public void activateDeactivateSkill() throws Exception {
		sds = new SystemDefinationSkillSetupPage(driver);
		sds.clickEditBtn();
		Thread.sleep(1000);
		sds.clickIsActiveOption();
		sds.clickSaveBtn();
		sds.closeNotificationPopup();
	}

	public void setSearchColumns() throws Exception {
		String searchColumnsData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		sds = new SystemDefinationSkillSetupPage(driver);
		sds.enterSearchColumns(searchColumnsData);
	}

	/*
	public void setNewSkill() throws Exception {

		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 8);
		String sequenceData =excelUtility.readDataFromExcelFile("EmployeeTest", 3, 9);
		String wageLevelCodedata = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 11);
		sds=new SystemDefinationSkillSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		sds.addBtn();
		driver.getWindowHandle();
		sds.skillCode(skillCodeData,timeStamp);
		sds.skillDescription(skillDescriptionData, timeStamp);
		sds.sequence(sequenceData );
		sds.coloreCode();
		sds.wageLevelCode(wageLevelCodedata,timeStamp);
		sds.saveBtn();
		sds.setNotificationPopup();
	}
	public void setUpdateSkill() throws Exception {

		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 8);

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		sds.setEditBtn();
		driver.getWindowHandle();
		sds.skillCode(skillCodeData, timeStamp);
		sds.skillDescription(skillDescriptionData ,timeStamp);
		sds.saveBtn();
		sds.setNotificationPopup();

	}

	public void setDeactiveSkil() throws Exception {

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		//		Here we just need to select the skill code from search bar, no need to pass anything 
		sds.setcheckBox();
		sds.setDeleteBtn();
		sds.setClickYes();
		sds.setNotificationPopup();

	}
	public void setActivateDeactiveSkill() throws Exception {

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		sds.setEditBtn();
		Thread.sleep(1000);
		sds.isActiveOption();
		sds.saveBtn();
		sds.setNotificationPopup();

	}

	public void setSearchColumns() throws Exception {
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		String searchColumnsData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		sds.setSearchColumn(searchColumnsData);
	}
	 */

}
