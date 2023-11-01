package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class SystemDefinationRosterSetupPage extends BaseClass{

	String timeStamp = LocalDateTime.now().toString();
	Actions action= new Actions(driver);
	Select select;
	public ExcelUtilities excelUtility;
	public WebUtilities webUtility;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public SystemDefinationRosterSetupPage sdrs;
	public String tampName ;
	public String tempDescription;
	public String noOfDay;

	@FindBy(id = "btnAddNewTemplateRoster")
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

	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement editBtn;


	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[1]")
	private WebElement rosterCreation1stDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[2]")
	private WebElement rosterCreation2ndDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[3]")
	private WebElement rosterCreation3rdDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[4]")
	private WebElement rosterCreation4thDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[5]")
	private WebElement rosterCreation5thDay;

	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement 	bandCode;


	// in Band code search box need the select one shift from drop down box
	@FindBy(xpath = "(//li[contains(text(),'1st  Shift ')])[1]")
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
	private WebElement notificationPopup;
	
	@FindBy(xpath = "//button[@id='btnPublishRosterPattern']/span")
	private WebElement btnPublishRosterPattern;

	@FindBy(xpath = "//input[@id='dtPublishFrom1130']")
	private WebElement txtPublishFrom;

	@FindBy(xpath = "//div[@class='datepicker-days']/table/tbody/tr[2]/td[2]")
	private WebElement dropDownCalender;

	@FindBy(xpath = "//input[@id='txtNoOfBlocks1130']")
	private WebElement txtNoOfBlock;
	
	@FindBy(xpath = "//td[@class='sorting_1']/input")
	private WebElement checkBoxPublishRoster;
	
	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']/span")
	private WebElement btnSaveTemplateRoster;

	@FindBy(xpath = "//button[text()='Publish Now']")
	private WebElement btnPublishNow;
	
	public SystemDefinationRosterSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.excelUtility= new ExcelUtilities();
	}

	public void setAddBtn() {
		addBtn.click();
	}

	public void setTemplateNameTxt(String tampName) {
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
	public void setAvailableSkillForSingleSkill() {
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByValue("113");	
	}


	//move a singel skill from available roaster group to selected roaster group 
	public void setAvailableSingleSkillMoveToSelectedSkill() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	public void setSaveBtn() {
		saveBtn.click();
	}
	public void setEditBtn() {
		editBtn.click();
	}

	public void setRosterCreation1stDay() {
		action.moveToElement(rosterCreation1stDay).perform();
		rosterCreation1stDay.click();
	}

	public void setRosterCreation2ndDay() {
		action.moveToElement(rosterCreation2ndDay).perform();
		rosterCreation2ndDay.click();
	}

	public void setRosterCreation3rdDay() {
		action.moveToElement(rosterCreation3rdDay).perform();
		rosterCreation3rdDay.click();
	}

	public void setRosterCreation4thDay() {
		action.moveToElement(rosterCreation4thDay).perform();
		rosterCreation4thDay.click();
	}
	public void setrosterCreation5thDay() {
		action.moveToElement(rosterCreation5thDay).perform();
		rosterCreation5thDay.click();
	}
	public void setBandCode() {
		action.moveToElement(bandCode).perform();
		bandCode.click();
	}

	public void setSelectBandCode() {
		action.moveToElement(selectBandCode).perform();
		selectBandCode.click();
	}
	public void setBtnSaveSelectShiftBandBtn() {
		btnSaveSelectShiftBandBtn.click();
	}


	public void setBtnAddEmployee() {
		action.moveToElement(btnAddEmployee).perform();
		btnAddEmployee.click();
	}

	public void setAvailableEmpTable() {
		action.moveToElement(availableEmpTable).perform();
		availableEmpTable.click();
		select= new Select(availableEmpTable);
		select.selectByValue("650");
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
		select.selectByValue("114");	
	}

	public void setBtnSaveRosterTemplateRosterGroups() {
		btnSaveRosterTemplateRosterGroups.click();
	}
	
	public void setNotificationPopup() {
		action.moveToElement(notificationPopup).perform();
		notificationPopup.click();
	}

	public void setBtnAddSaveRosterPattern() {
		btnAddSaveRosterPattern.click();
	}
	public void setBtnPublishRosterPattern() {
		action.moveToElement(btnPublishRosterPattern).perform();
		btnPublishRosterPattern.click();
	}
	public void setDropDownCalender() {
		txtPublishFrom.click();
		action.scrollToElement(dropDownCalender).perform();
		dropDownCalender.click();
	}
	public void setTxtNoOfBlock() {
		txtNoOfBlock.sendKeys("2");
	}

	public void setCheckBoxPublishRoster() {
		checkBoxPublishRoster.click();
	}
	public void setBtnSaveTemplateRoster() {
		btnSaveTemplateRoster.click();
	}
	public void setBtnPublishNow() {
		btnPublishNow.click();
	}
	
	public void setCreateRoaster() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);

		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setTemplateNameTxt(tampName+ " "+ timeStamp);
		Thread.sleep(2000);
		sdrs.setTempDescriptionTxt(tempDescription+ " "+ timeStamp);
		sdrs.setNoOfDayTxt(noOfDay);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation1stDay();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation2ndDay();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation3rdDay();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setRosterCreation4thDay();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setrosterCreation5thDay();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		// Add Employee
		sdrs.setBtnAddEmployee();
		Thread.sleep(2000);
		sdrs.setAvailableEmpTable();
		sdrs.setBtnMoveFromAvailable();
		sdrs.setBtnSaveRosterTemplateEmployee();

		// Add Roster group
		Thread.sleep(2000);
		sdrs.setBtnAddRosterGroups();
		Thread.sleep(2000);
		sdrs.setAvailableRosterGroup();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setBtnSaveRosterTemplateRosterGroups();
		Thread.sleep(2000);
		sdrs.setBtnAddSaveRosterPattern();
		sdrs.setNotificationPopup();
		Thread.sleep(2000);
		sdrs.setBtnPublishRosterPattern() ;
		sdrs.setDropDownCalender();
		sdrs.setTxtNoOfBlock();
		sdrs.setCheckBoxPublishRoster();
		sdrs.setBtnSaveTemplateRoster();
		sdrs.setBtnPublishNow();
	}






	public void setUpdateRoaster() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		sdrs.setEditBtn();

	}
}
