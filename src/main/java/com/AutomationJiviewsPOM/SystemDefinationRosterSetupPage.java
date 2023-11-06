package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

//	public String timeStamp = LocalDateTime.now().toString();
	public String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss")).replace(" ", "_");

	Actions action= new Actions(driver);
	Select select;
	public ExcelUtilities excelUtility;
	public WebUtilities webUtility;
	public SystemDefinationRosterSetupPage sdrs;
	public String tampName ;
	public String tempDescription;
	public String noOfDay;
	public String noOfBlocks;

//	public  String gerateTmeStamp() {
//		Date date=new Date();
//		return date.toString().replace(" ", "_").replace(":", "_");
//	}
	
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

	@FindBy(xpath = "(//button[@type='button'])[9]")
	private WebElement editBtn;

	// Group A 
	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[1]")
	private WebElement rosterCreation1stDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[2]")
	private WebElement rosterCreation2ndDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[3]")
	private WebElement rosterCreation3rdDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[4]")
	private WebElement rosterCreation4thDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[5]")
	private WebElement rosterCreation5thDay;

	// Group B
	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[6]")
	private WebElement rosterCreation6thDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[7]")
	private WebElement rosterCreation7thDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[8]")
	private WebElement rosterCreation8thDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[9]")
	private WebElement rosterCreation9thDay;

	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[10]")
	private WebElement rosterCreation10thDay;

	//	// Employee 
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[11]")
	//	private WebElement rosterCreation11thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[15]")
	//	private WebElement rosterCreation12thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[19]")
	//	private WebElement rosterCreation13thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[23]")
	//	private WebElement rosterCreation14thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[27]")
	//	private WebElement rosterCreation15thDay;
	//
	//
	//	// Employee 2
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[4]")
	//	private WebElement rosterCreation16thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[8]")
	//	private WebElement rosterCreation17thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[12]")
	//	private WebElement rosterCreation18thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[16]")
	//	private WebElement rosterCreation19thDay;
	//
	//	@FindBy(xpath = "//div[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[20]")
	//	private WebElement rosterCreation20thDay;

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



	//	@FindBy(xpath = "//input[@id='dtPublishFrom1130']")
	@FindBy(xpath = "//table[@id='extract-shift-list']/tbody/tr/td[5]")
	private WebElement txtPublishFrom;

	@FindBy(xpath = "//div[@class='datepicker-days']/table/tbody/tr[2]/td[2]")
	//	@FindBy(xpath = "//table[@id='extract-shift-list']/tbody/tr[2]/td[5]")
	private WebElement dropDownCalenderRoster;

	
	// 13/Nov/2023 for 
	@FindBy(xpath = "//div[@class='datepicker-days']/table/tbody/tr[3]/td[2]")
	private WebElement dropDownCalenderRosterUp;

	@FindBy(xpath = "//table[@id=\"extract-shift-list\"]/tbody/tr/td[5]")
	private WebElement dropDownCalenderEmp;


	//	@FindBy(xpath = "//input[@id='txtNoOfBlocks1130']")
	@FindBy(xpath = "(//table[@id='extract-shift-list']/tbody/tr/td[6]/input)[1]")
	private WebElement txtNoOfBlock;

	@FindBy(xpath = "(//td[@class='sorting_1']/input)[1]")
	private WebElement checkBoxPublishRoster;

	@FindBy(xpath = "(//td[@class='sorting_1']/input)[2]")
	private WebElement checkBoxPublishRoster2;

	@FindBy(xpath = "//button[@id='btnSaveTemplateRoster']/span")
	private WebElement btnSaveTemplateRoster;

	@FindBy(xpath = "//button[text()='Publish Now']")
	private WebElement btnPublishNow;


	// Select By Employee Button 
	@FindBy(xpath = "//span[text()='By Employees']")
	private WebElement btnByEmp;

	//	(//td[@class=' select-checkbox']/input)[1]
	@FindBy(xpath = "//table[@id='template-roster-list']/tbody/tr[5]/td[1]/input")
	private WebElement checkBoxDeactive;

	@FindBy(xpath = "//button[@id='btnDeleteTemplateRoster']")
	private WebElement btnDeleteTemplateRoster;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//span[text()='Is Active?']")
	private WebElement checkBoxActive;

	public SystemDefinationRosterSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.excelUtility= new ExcelUtilities();
		this.webUtility= new WebUtilities();
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
	public void setAvailableSkillForSingleRoster() {
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByValue("113");	
	}
	// scroll down the page and select single Employee group from  availble Emp group
	public void setAvailableSkillForSingleEmp() {
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByValue("650");	
	}


	//move a singel Roaster/Emp from available Roaster/Emp group to selected roaster group 
	public void setAvailableSingleGroupMoveToSelectedGrp() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	public void setSaveBtn() {
		saveBtn.click();
	}
	public void setEditBtn() {
		action.moveToElement(editBtn).perform();
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

	public void setrosterCreation6thDay() {
		action.moveToElement(rosterCreation6thDay).perform();
		rosterCreation6thDay.click();
	}

	public void setrosterCreation7thDay() {
		action.moveToElement(rosterCreation7thDay).perform();
		rosterCreation7thDay.click();
	}
	public void setrosterCreation8thDay() {
		action.moveToElement(rosterCreation8thDay).perform();
		rosterCreation8thDay.click();
	}
	public void setrosterCreation9thDay() {
		action.moveToElement(rosterCreation9thDay).perform();
		rosterCreation9thDay.click();
	}
	public void setrosterCreation10thDay() {
		action.moveToElement(rosterCreation10thDay).perform();
		rosterCreation10thDay.click();
	}
	/*public void setrosterCreation11thDay() {
		action.moveToElement(rosterCreation11thDay).perform();
		rosterCreation11thDay.click();
	}
	public void setrosterCreation12thDay() {
		action.moveToElement(rosterCreation12thDay).perform();
		rosterCreation12thDay.click();
	}
	public void setrosterCreation13thDay() {
		action.moveToElement(rosterCreation13thDay).perform();
		rosterCreation13thDay.click();
	}
	public void setrosterCreation14thDay() {
		action.moveToElement(rosterCreation14thDay).perform();
		rosterCreation14thDay.click();
	}
	public void setrosterCreation15thDay() {
		action.moveToElement(rosterCreation15thDay).perform();
		rosterCreation15thDay.click();
	}
	public void setrosterCreation16thDay() {
		action.moveToElement(rosterCreation16thDay).perform();
		rosterCreation16thDay.click();
	}*/

	public void setBandCode() {
		action.moveToElement(bandCode).perform();
		bandCode.click();
	}

	public void setSelectBandCode() {
		action.moveToElement(selectBandCode).perform();
		selectBandCode.click();
	}
	public void setBtnSaveSelectShiftBandBtn() throws Exception {
		//		webUtility.visibilityOfElement(driver, btnSaveSelectShiftBandBtn);
		Thread.sleep(2000);
		btnSaveSelectShiftBandBtn.click();
	}


	public void setBtnAddEmployee() {
		action.moveToElement(btnAddEmployee).perform();
		btnAddEmployee.click();
	}
	// Select Emp name from available roster group
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
	public void setBtnPublishRosterPattern() throws InterruptedException {
		action.moveToElement(btnPublishRosterPattern).perform();
		Thread.sleep(2000);
		btnPublishRosterPattern.click();
	}
	public void setDropDownCalender() {
		txtPublishFrom.click();
		action.scrollToElement(dropDownCalenderRoster).perform();
		dropDownCalenderRoster.click();
	}

	public void setDropDownCalenderRosterUp() {
		txtPublishFrom.click();
		action.scrollToElement(dropDownCalenderRosterUp).perform();
		dropDownCalenderRosterUp.click();
	}
	public void setDropDownCalenderEmp() {
		txtPublishFrom.click();
		action.scrollToElement(dropDownCalenderEmp).perform();
		dropDownCalenderEmp.click();
	}
	public void setTxtNoOfBlock(String noOfBlocks) {
		txtNoOfBlock.sendKeys(noOfBlocks);
	}

	public void setCheckBoxPublishRoster() {
		checkBoxPublishRoster.click();
	}

	public void setCheckBoxPublishRoster2() {
		checkBoxPublishRoster2.click();
	}
	public void setBtnSaveTemplateRoster() {
		btnSaveTemplateRoster.click();
	}
	public void setBtnPublishNow() {
		btnPublishNow.click();
	}

	public void setBtnByEmp() {
		btnByEmp.click();
	}
	public void setCheckBoxDeactive() {
		checkBoxDeactive.click();
	}

	public void setBtnDeleteTemplateRoster() {
		action.moveToElement(btnDeleteTemplateRoster).perform();
		btnDeleteTemplateRoster.click();
	}
	public void setBtnYes() {
		btnYes.click();
	}
	public void setCheckBoxActive() {
		action.moveToElement(checkBoxActive).perform();
		checkBoxActive.click();
	}
	public void setCreateRoasterwithGroup() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);

		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setTemplateNameTxt(tampName+ " "+ timeStamp);
		Thread.sleep(2000);
		sdrs.setTempDescriptionTxt(tempDescription+ " "+ timeStamp);
		sdrs.setNoOfDayTxt(noOfDay);
		sdrs.setAvailableSkillForSingleRoster();
		sdrs.setAvailableSingleGroupMoveToSelectedGrp();
		sdrs.setSaveBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation1stDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation2ndDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation3rdDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setRosterCreation4thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setrosterCreation5thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		Thread.sleep(2000);
		sdrs.setBtnAddSaveRosterPattern();
		sdrs.setNotificationPopup();
		Thread.sleep(2000);

		sdrs.setBtnPublishRosterPattern() ;
		sdrs.setDropDownCalender();
		sdrs.setTxtNoOfBlock(noOfBlocks);
		sdrs.setCheckBoxPublishRoster();
		sdrs.setBtnSaveTemplateRoster();
		sdrs.setBtnPublishNow();

		// Add Employee
		//		sdrs.setBtnAddEmployee();
		//		Thread.sleep(2000);
		//		sdrs.setAvailableEmpTable();
		//		sdrs.setBtnMoveFromAvailable();
		//		sdrs.setBtnSaveRosterTemplateEmployee();
		//
		//		// Add Roster group
		//		Thread.sleep(2000);
		//		sdrs.setBtnAddRosterGroups();
		//		Thread.sleep(2000);
		//		sdrs.setAvailableRosterGroup();
		//		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		//		sdrs.setBtnSaveRosterTemplateRosterGroups();

		//		sdrs.setrosterCreation6thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);

		//		sdrs.setrosterCreation7thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation8thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation9thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation10thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation11thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation12thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation13thDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation14thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation15thDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//		
		//		sdrs.setrosterCreation16thDay();
		//		Thread.sleep(2000);
		//		sdrs.setBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
	}

	public void setCreateRoasterwithEmployee() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);

		sdrs.setAddBtn();
		Thread.sleep(1000);
		sdrs.setTemplateNameTxt(tampName+ " "+ timeStamp);
		Thread.sleep(1000);
		sdrs.setTempDescriptionTxt(tempDescription+ " "+ timeStamp);
		sdrs.setNoOfDayTxt(noOfDay);
		sdrs.setBtnByEmp();
		Thread.sleep(1000);
		sdrs.setAvailableSkillForSingleEmp();
		sdrs.setAvailableSingleGroupMoveToSelectedGrp();
		sdrs.setSaveBtn();



		Thread.sleep(5000);
		sdrs.setRosterCreation1stDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setRosterCreation2ndDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);

		sdrs.setRosterCreation3rdDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setRosterCreation4thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setrosterCreation5thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setBtnAddSaveRosterPattern();
		sdrs.setNotificationPopup();
		Thread.sleep(2000);
		sdrs.setBtnPublishRosterPattern() ;
		Thread.sleep(2000);
		sdrs.setDropDownCalender();
		sdrs.setTxtNoOfBlock(noOfBlocks);
		sdrs.setCheckBoxPublishRoster();
		sdrs.setBtnSaveTemplateRoster();
		sdrs.setBtnPublishNow();

	}
	public void setCreateRoasterwithRosterAndEmp() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		tampName = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 7);
		tempDescription = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 8);
		noOfDay = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 9);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 14, 10);

		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setTemplateNameTxt(tampName+ " "+ timeStamp);
		Thread.sleep(2000);
		sdrs.setTempDescriptionTxt(tempDescription+ " "+ timeStamp);
		sdrs.setNoOfDayTxt(noOfDay);
		sdrs.setAvailableSkillForSingleRoster();
		sdrs.setAvailableSingleGroupMoveToSelectedGrp();
		sdrs.setSaveBtn();

		sdrs.setRosterCreation1stDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation2ndDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();
		Thread.sleep(2000);

		sdrs.setRosterCreation3rdDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setRosterCreation4thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setrosterCreation5thDay();
		sdrs.setBandCode();
		sdrs.setSelectBandCode();
		sdrs.setBtnSaveSelectShiftBandBtn();

		//	Add Employee
		Thread.sleep(2000);
		sdrs.setBtnAddEmployee();
		Thread.sleep(5000);
		sdrs.setAvailableEmpTable();
		Thread.sleep(2000);
		sdrs.setBtnMoveFromAvailable();
		Thread.sleep(2000);
		sdrs.setBtnSaveRosterTemplateEmployee();

		//		Thread.sleep(2000);
		//		sdrs.setRosterCreation2ndDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//		Thread.sleep(2000);
		//
		//		sdrs.setRosterCreation3rdDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//
		//		sdrs.setRosterCreation4thDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		Thread.sleep(2000);
		//		sdrs.setBtnSaveSelectShiftBandBtn();
		//
		//		sdrs.setrosterCreation5thDay();
		//		sdrs.setBandCode();
		//		sdrs.setSelectBandCode();
		//		sdrs.setBtnSaveSelectShiftBandBtn();

		sdrs.setBtnAddSaveRosterPattern();
		sdrs.setNotificationPopup();
		Thread.sleep(2000);
		sdrs.setBtnPublishRosterPattern() ;
		sdrs.setDropDownCalender();
		sdrs.setTxtNoOfBlock(noOfBlocks);
		sdrs.setCheckBoxPublishRoster();
		sdrs.setBtnSaveTemplateRoster();
		sdrs.setBtnPublishNow();
	}



	public void setUpdateRoaster() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		noOfBlocks = excelUtility.readDataFromExcelFile("EmployeeTest", 15, 10);
		Thread.sleep(2000);
		sdrs.setEditBtn();
		sdrs.setBtnPublishRosterPattern() ;
		sdrs.setDropDownCalenderRosterUp();
		Thread.sleep(2000);
		sdrs.setTxtNoOfBlock(noOfBlocks);
		Thread.sleep(2000);
		sdrs.setCheckBoxPublishRoster();
		Thread.sleep(2000);
		sdrs.setBtnSaveTemplateRoster();
		Thread.sleep(2000);
		sdrs.setBtnPublishNow();
	}
	public void setDeactiveRoster() {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		sdrs.setCheckBoxDeactive();
		sdrs.setBtnDeleteTemplateRoster();
		sdrs.setBtnYes();
	}

	public void setReactiveRoster() throws InterruptedException {
		sdrs= new SystemDefinationRosterSetupPage(driver);
		Thread.sleep(2000);
		sdrs.setEditBtn();
		sdrs.setCheckBoxActive();
		sdrs.setBtnAddSaveRosterPattern();
	}
}
