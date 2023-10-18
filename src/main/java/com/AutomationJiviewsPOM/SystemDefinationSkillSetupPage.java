package com.AutomationJiviewsPOM;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.FileLib;


public class SystemDefinationSkillSetupPage extends BaseClass {
	
	public SystemDefinationSkillSetupPage sds;
	ExcelUtilities excelUtility= new ExcelUtilities();
	String timeStamp = LocalDateTime.now().toString();
	
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

	@FindBy(xpath = "//span[.='Is Active?']")
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
	}

	public void addBtn() {
		addBtn.click();
	}

	public void skillCode(String skillCodeData) {
		skillCode.clear();
		skillCode.sendKeys(skillCodeData);
	}

	public void skillDescription(String skillDescriptionData) {
		skillDescription.clear();
		skillDescription.sendKeys(skillDescriptionData);
	}

	public void sequence(String sequenceData) {
		sequence.clear();
		sequence.sendKeys(sequenceData);
	}

	public void coloreCode() {
		ColourCode.sendKeys("");
	}

	public void wageLevelCode(String wageLevelCodedata) {
		wageLevelCode.clear();
		wageLevelCode.sendKeys(wageLevelCodedata);
	}
	public void isActiveOption() {
		isActiveOption.click();

	}
	public void saveBtn() {
		saveBtn.click();
	}
	
	public void setNotificationPopup() {
		notificationPopup.click();
	}
	public void setEditBtn() {
		editBtn.click();
	}
	public void setcheckBox()  {
		checkBox.click();
	}

	public void setDeleteBtn() {
		clickDeleteBtn.click();
	}
	public void setClickYes() {
		clickYes.click();
	}

	public void setSearchColumn(String searchColumnsData) {
		searchColumns.clear();
		searchColumns.sendKeys(searchColumnsData);

	}


	public void setNewSkill() throws Exception {
//		FileLib f=new FileLib();
//		String skillCodeData = f.getExcelData("EmployeeTest", 3, 7);
//		String skillDescriptionData = f.getExcelData("EmployeeTest", 3, 8);
//		String sequenceData = f.getExcelData("EmployeeTest", 3, 9);
//		String wageLevelCodedata = f.getExcelData("EmployeeTest", 3, 11);

		
		
		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 8);
		String sequenceData =excelUtility.readDataFromExcelFile("EmployeeTest", 3, 9);
		String wageLevelCodedata = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 11);
		
		sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		sds.addBtn();
		String timeStamp = LocalDateTime.now().toString();
		driver.getWindowHandle();
		Thread.sleep(2000);
		sds.skillCode(skillCodeData+ " " + timeStamp);
		sds.skillDescription(skillDescriptionData+ " " + timeStamp);
		sds.sequence(sequenceData );
		sds.coloreCode();
		sds.wageLevelCode(wageLevelCodedata+ " " + timeStamp);
		//	sds.isActiveOption();

		Thread.sleep(2000);
		sds.saveBtn();
		sds.setNotificationPopup();
	}
	public void setUpdateSkill() throws Exception {
//		FileLib f=new FileLib();
		
//		String skillCodeData = f.getExcelData("EmployeeTest", 4, 7);
//		String setSkillDescData = f.getExcelData("EmployeeTest", 4, 8);
		//	String sequenceData = f.getExcelData("EmployeeTest", 4, 9);
		//	String wageLevelCodedata = f.getExcelData("EmployeeTest", 4, 11);
		
		String skillCodeData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 7);
		String skillDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 8);
//		String sequenceData =excelUtility.readDataFromExcelFile("EmployeeTest", 4, 9);
//		String wageLevelCodedata = excelUtility.readDataFromExcelFile("EmployeeTest", 4, 11);

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		sds.setEditBtn();
		sds.skillCode(skillCodeData + " " + timeStamp);
		sds.skillDescription(skillDescriptionData + " " + timeStamp);
		sds.saveBtn();
		sds.setNotificationPopup();

	}

	public void setDeactiveSkil() throws InterruptedException, EncryptedDocumentException, IOException {

		//		fileLib f=new fileLib();
		//		String skillCodeData = f.getExcelData("SkillData", 2, 5);


		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		//		here we just need to select the skill code, no need to pass anything 
		Thread.sleep(2000);
		sds.setcheckBox();

//				for(; ; ) {
//					try {
//						Thread.sleep(2000);
//						selectSkillCode.click();
//						break;
//					} catch (Exception e) {
//						Thread.sleep(2000);
//						clickNextBtn.click();
//					}
//				}
		sds.setDeleteBtn();
		sds.setClickYes();
		sds.setNotificationPopup();

	}
	public void setActivateDeactiveSkill() throws InterruptedException {

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		sds.setEditBtn();
		Thread.sleep(5000);
		sds.isActiveOption();
		Thread.sleep(5000);
		sds.saveBtn.click();
		Thread.sleep(5000);
		sds.setNotificationPopup();

	}

	public void setSearchColumns() throws Exception {
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
//		FileLib f=new FileLib();
		
//		String searchColumnsData = f.getExcelData("EmployeeTest", 3, 7);
		String searchColumnsData = excelUtility.readDataFromExcelFile("EmployeeTest", 3, 7);
		Thread.sleep(2000);
		sds.setSearchColumn(searchColumnsData);
		

	}
}
