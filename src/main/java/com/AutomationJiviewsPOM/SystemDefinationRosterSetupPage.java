package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;

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

	// it is from Seleceted Skill Table 
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

	
	// select off button 
	@FindBy(xpath = "//div[@id=\"dpRosterPattern\"]/div[3]/div[3]/div/div[2]/div[1]")
	private WebElement unselectableBtn;
	
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement 	bandCode;
	
	
	// in Band code search box need the select one shift from drop down box
	@FindBy(xpath = "(//li[contains(text(),'1st  Shift ')])[1]")
	private WebElement selectBandCode;
	
	@FindBy(xpath = "//button[@id='btnSelectShiftBand']")
	private WebElement saveSelectShiftBandBtn;
	
	public SystemDefinationRosterSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.excelUtility= new ExcelUtilities();
	}

	public void setAddBtn() {
		addBtn.click();
	}

	public void setTemplateNameTxt() {
		templateNameTxt.sendKeys("7 days pattern_02");
	}

	public void setTempDescriptionTxt() {
		tempDescriptionTxt.sendKeys("7 days pattern Description");
	}
	public void setNoOfDayTxt() {
		noOfDayTxt.sendKeys("7");
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

	public void setUnselectableBtn() throws Exception {
//		webUtility.visibilityOfElement(driver, unselectableBtn);
		action.moveToElement(unselectableBtn).perform();
		unselectableBtn.click();
	}
	
	public void setBandCode() {
		action.moveToElement(bandCode).perform();
		bandCode.click();
	}
	
	public void setSelectBandCode() {
		action.moveToElement(selectBandCode).perform();
		selectBandCode.click();
	}
	public void setSaveSelectShiftBandBtn() {
		saveSelectShiftBandBtn.click();
	}
	public void setCreateRoaster() throws Exception {
		sdrs= new SystemDefinationRosterSetupPage(driver);

		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setTemplateNameTxt();
		Thread.sleep(2000);
		sdrs.setTempDescriptionTxt();
		sdrs.setNoOfDayTxt();
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBtn();
//		Thread.sleep(2000);
//		sdrs.setEditBtn();
		Thread.sleep(2000);
		sdrs.setUnselectableBtn();
		Thread.sleep(2000);
		sdrs.setBandCode();
		Thread.sleep(2000);
		sdrs.setSelectBandCode();
		Thread.sleep(2000);
		sdrs.setSaveSelectShiftBandBtn();
	}
}
