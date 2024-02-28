package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class Overtime_Definitions {
	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String name;
	WebDriver driver;
	WebUtilities  webUtility= new WebUtilities(driver);
	
	
	//this is for add Equipment
@FindBy(id="lblSelectedParent")
private WebElement systemSetup;

@FindBy(xpath="//span[.='System Definitions']")
private WebElement systemDefinitions;

@FindBy(xpath="//a[@class='sidenav-link sidenav-toggle']/div[text()='Time & Attendance']")
private WebElement timeAndAttendance;

@FindBy(xpath="//a[@class='sidenav-link']/div[text()='Overtime Definitions']")
private WebElement overtimeDefinitions;

//this is for create 

@FindBy(xpath="//button[@id='btnAddOvertimeSettings']")
private WebElement addButton;

@FindBy(xpath="//input[@id='txtOvertimeName']")
private WebElement overtimeName;

@FindBy(xpath="//input[@id='txtOvertimeDescription']")
private WebElement overtimeDescription;

@FindBy(xpath="//span[@id='select2-cmbOvertimePeriodUnit-container']")
private WebElement clickResetType;

@FindBy(xpath="(//ul[@id='select2-cmbOvertimePeriodUnit-results']/li)[1]")
private WebElement selectResetType;

@FindBy(xpath="//input[@id='txtRoundUpGranularity']")
private WebElement roundUpMinute;

@FindBy(xpath="//input[@id='txtOvertimePeriodLength']")
private WebElement overtimeStartsAfterHours;

@FindBy(xpath="//input[@id='txtMaxDailyOTHours']")
private WebElement maximumDailyOvertimeHours;

@FindBy(xpath="//span[text()='Approval Required?']")
private WebElement approvalRequireCheckBox;

@FindBy(xpath="//span[text()='Allow Day & Night Overtime Settings']")
private WebElement dayAndNightOvertimeSettingCheckBox;
     

                  //day and night type setting
@FindBy(xpath="//button[@id='btnAddDayNightOTSettings']")
private WebElement dayAndNightOvertimeSettingAddButton;

@FindBy(xpath="//span[@id='select2-cmbDayNightType-container']")
private WebElement clickDayAndNightType;

@FindBy(xpath="(//ul[@id='select2-cmbDayNightType-results']/li)[1]")
private WebElement selectDayAndNightType;

@FindBy(xpath="//input[@id='tmDayNightStartTime']")
private WebElement startTime;

@FindBy(xpath="//input[@id='tmDayNightEndTime']")
private WebElement endTime;

@FindBy(xpath="//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1 save']")
private WebElement saveButtonOFOvertimeButton;

@FindBy(xpath="//button[@class='btn btn-sm btn-outline-danger icon-btn mx-1 cancel']")
private WebElement cancelButtonOFOvertimeButton;


//==============================================================================


@FindBy(xpath="(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
private WebElement cancelButton;

@FindBy(xpath="//button[@id='btnSaveOvertimeSettings']")
private WebElement saveButton;


@FindBy(xpath="//div[text()='Overtime Setting Created Successfully']")
private WebElement validateSuccessfullyCreatedMessage;



//this is for edit Equipment

@FindBy(xpath="//input[@type='search']")
private WebElement search;

@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
private WebElement clickOnEdit;

@FindBy(xpath="(//table/tbody/tr/td/button)[2]")
private WebElement viewEmployeesButton;

@FindBy(xpath="//div[text()='Overtime Setting Updated Successfully']")
private WebElement validateSuccessfullyUpdatedMessage;

//this is for delete created 
@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
private WebElement clickOnCheckBox;

@FindBy(xpath="//button[@id='btnDeleteOvertimeSettings']")
private WebElement deleteButton;


@FindBy(xpath="//button[.='No']")
private WebElement validateNoButton;

@FindBy(xpath="//button[.='Yes']")
private WebElement clickOnYesButton;

@FindBy(xpath="//div[.='Overtime Settings Deleted Successfully']")
private WebElement validateSuccessfullyDeletedMessage;

@FindBy(xpath="//span[text()='Is Active?']")
private WebElement isActiveCheckBox;
//=============================================================================================


// PDF and excel

@FindBy(xpath="//button[@class='btn btn-secondary buttons-excel buttons-html5 btn-sm mr-1']")
private WebElement excel;

@FindBy(xpath="//button[@class='btn btn-secondary buttons-pdf buttons-html5 btn-sm mr-1']")
private WebElement pdf;




//=============================================================================================

// Available  table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableCrane;

	// select for single Arrow -> move RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle; 

	//		select for move multiple RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;
//perform action on elements
	
	

public Overtime_Definitions(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
	
	this.action= new Actions(driver);
	this.webUtility= new WebUtilities(driver);
}


public void closeNotificationPopup() throws Exception {
	webUtility.visibilityOfElement(driver, notificationPopup);
	notificationPopup.click();
}

public void systemSetup() throws InterruptedException{
	systemSetup.click();
}

public void clickTimeAndAttendance() throws InterruptedException{
	webUtility.ElementClickable(driver,timeAndAttendance );
	timeAndAttendance.click();
}
public void clickToOvertimeDefinitions(){
	webUtility.ElementClickable(driver,overtimeDefinitions );
	overtimeDefinitions.click();
}
public void createAction() throws Exception
{
	Thread.sleep(5000);
	addButton.click();
	fakeData=new Faker();
	name=fakeData.name().fullName();
	
	Thread.sleep(2000);
	overtimeName.sendKeys(name);
	overtimeDescription.sendKeys("this is for testing");
	clickResetType.click();
	selectResetType.click();
	roundUpMinute.sendKeys("30");	
	
	overtimeStartsAfterHours.sendKeys("17:00");
	maximumDailyOvertimeHours.sendKeys("02");
	
	approvalRequireCheckBox.click();
	dayAndNightOvertimeSettingCheckBox.click();
	
	dayAndNightOvertimeSettingAddButton.click();
	clickDayAndNightType.click();
	selectDayAndNightType.click();
	startTime.clear();
	startTime.sendKeys("18:00");
	endTime.clear();
	endTime.sendKeys("20:00");
    saveButtonOFOvertimeButton.isDisplayed();
    cancelButtonOFOvertimeButton.isDisplayed();
	cancelButton.isDisplayed();
	saveButton.click();
	closeNotificationPopup();
	}
public void editAction() throws Exception
{
	Thread.sleep(3000);
	search.sendKeys(name);
	clickOnEdit.click();
	Thread.sleep(2000);
	name=name+"JIVI";
	viewEmployeesButton.isDisplayed();
	overtimeName.clear();
	overtimeName.sendKeys(name);
    saveButton.click();
	closeNotificationPopup();
	}
public void deleteAction() throws Exception
{
	Thread.sleep(3000);
	search.clear();
	search.sendKeys(name);
	clickOnCheckBox.click();
	deleteButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	closeNotificationPopup();
	}
public void reActivate() throws InterruptedException
{
	Thread.sleep(3000);
	search.clear();
	search.sendKeys(name);
	clickOnEdit.click();
	Thread.sleep(3000);
	isActiveCheckBox.click();
	saveButton.click();
	}
}
