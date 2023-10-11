package com.AzurePOM;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AzureGeneric.BaseClass;
import com.AzureGeneric.FileLib;


public class SystemDefinationSkillSetupPage extends BaseClass {
	@FindBy(xpath = "//button[@id='btnAddSkill']")
	WebElement addBtn;

	@FindBy(xpath = "//input[@id='txtSkillCode']")
	WebElement skillCode;

	@FindBy(id="txtSkillCodeDescription")
	WebElement skillDescription;

	@FindBy(id = "txtSequence")
	WebElement sequence;

	@FindBy(id = "txtColourCode")
	WebElement ColourCode;

	@FindBy(id = "txtFixedRanking")
	WebElement wageLevelCode;

	@FindBy(xpath = "//span[.='Is Active?']")
	WebElement isActiveOption;

	@FindBy(id = "btnSaveSkill")
	WebElement saveBtn;
	
	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	WebElement editBtn;

	@FindBy(id = "btnDeleteSkill")
	WebElement clickDeleteBtn;

	@FindBy(xpath = "//button[.='Yes']")
	WebElement clickYes;

	@FindBy(xpath =  "(//input[@type='checkbox'])[2]")
	WebElement checkBox;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchColumns;

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


	public void setNewSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		FileLib f=new FileLib();
		String skillCodeData = f.getExcelData("EmployeeTest", 3, 7);
		String skillDescriptionData = f.getExcelData("EmployeeTest", 3, 8);
		String sequenceData = f.getExcelData("EmployeeTest", 3, 9);
		String wageLevelCodedata = f.getExcelData("EmployeeTest", 3, 11);

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
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
	public void setUpdateSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		FileLib f=new FileLib();
		String timeStamp = LocalDateTime.now().toString();
		String skillCodeData = f.getExcelData("EmployeeTest", 4, 7);
		String setSkillDescData = f.getExcelData("EmployeeTest", 4, 8);
		//	String sequenceData = f.getExcelData("EmployeeTest", 4, 9);
		//	String wageLevelCodedata = f.getExcelData("EmployeeTest", 4, 11);

		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		Thread.sleep(2000);
		sds.setEditBtn();
		sds.skillCode(skillCodeData + " " + timeStamp);
		sds.skillDescription(setSkillDescData + " " + timeStamp);
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

	public void setSearchColumns() throws EncryptedDocumentException, IOException, InterruptedException {
		SystemDefinationSkillSetupPage sds=new SystemDefinationSkillSetupPage(driver);
		FileLib f=new FileLib();
		String searchColumnsData = f.getExcelData("EmployeeTest", 3, 7);
		Thread.sleep(2000);
		sds.setSearchColumn(searchColumnsData);
		

	}
}
