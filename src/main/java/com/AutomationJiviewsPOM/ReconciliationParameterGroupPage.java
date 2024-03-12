package com.AutomationJiviewsPOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class ReconciliationParameterGroupPage {

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

@FindBy(xpath="//a[@class='sidenav-link']/div[text()='Reconciliation Parameter Group']")
private WebElement reconciliationParameterGroup;

//this is for create 

@FindBy(xpath="//button[@id='btnAddRecon']")
private WebElement addButton;

@FindBy(xpath="//input[@id='txtRPGName']")
private WebElement RPGName;

@FindBy(xpath="//input[@id='txtRPGDescription']")
private WebElement RPGDescription;

@FindBy(xpath="//span[@id='select2-cmbClockingIndicationMethod-container']")
private WebElement clickOnClockingIdentificationMethod;

@FindBy(xpath="(//ul[@id='select2-cmbClockingIndicationMethod-results']/li)[1]")
private WebElement selectClockingIdentificationMethod;


//this is for time Recognition Boundary
@FindBy(xpath="//input[@id='txtReconShiftInEarly']")
private WebElement clickOnRecognitionBoundary_EarlyIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[2]")
private WebElement selectRecognitionBoundary_EarlyIn;

@FindBy(xpath="//input[@id='txtReconShiftInLate']")
private WebElement clickOnRecognitionBoundary_LateIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[3]")
private WebElement selectRecognitionBoundary_LateIn;

@FindBy(xpath="//input[@id='txtReconShiftOutEarly']")
private WebElement clickOnRecognitionBoundary_EarlyOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[4]")
private WebElement selectRecognitionBoundary_EarlyOut;

@FindBy(xpath="//input[@id='txtReconShiftOutLate']")
private WebElement clickOnRecognitionBoundary_LateOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[5]")
private WebElement selectRecognitionBoundary_LateOut;

//this is for time Reconciliation Granularity

@FindBy(xpath="//input[@id='txtEarlyInGranularity']")
private WebElement clickOnReconciliationGranularity_EarlyIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[2]")
private WebElement selectReconciliationGranularity_EarlyIn;

@FindBy(xpath="//input[@id='txtLateInGranularity']")
private WebElement clickOnReconciliationGranularity_LateIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[3]")
private WebElement selectReconciliationGranularity_LateIn;

@FindBy(xpath="//input[@id='txtEarlyOutGranularity']")
private WebElement clickOnReconciliationGranularity_EarlyOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[4]")
private WebElement selectReconciliationGranularity_EarlyOut;

@FindBy(xpath="//input[@id='txtLateOutGranularity']")
private WebElement clickOnReconciliationGranularity_LateOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[5]")
private WebElement selectReconciliationGranularity_LateOut;

//this is for time Reconcile To Planned

@FindBy(xpath="//input[@id='txtEarlyInReConcileToPlan']")
private WebElement clickOnReconcileToPlanned_EarlyIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[2]")
private WebElement selectReconcileToPlanned_EarlyIn;

@FindBy(xpath="//input[@id='txtLateInReConcileToPlan']")
private WebElement clickOnReconcileToPlanned_LateIn;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[3]")
private WebElement selectReconcileToPlanned_LateIn;

@FindBy(xpath="//input[@id='txtEarlyOutReConcileToPlan']")
private WebElement clickOnReconcileToPlanned_EarlyOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[4]")
private WebElement selectReconcileToPlanned_EarlyOut;

@FindBy(xpath="//input[@id='txtLateOutReConcileToPlan']")
private WebElement clickOnReconcileToPlanned_LateOut;

@FindBy(xpath="(//ul[@class='ui-timepicker-list']/li)[5]")
private WebElement selectReconcileToPlanned_LateOut;
 
//drag and drop

@FindBy(xpath="(//select[@id='bootstrap-duallistbox-nonselected-list_']/option)[1]")
private WebElement selectAvilableRool;

@FindBy(xpath="(//select[@id='bootstrap-duallistbox-nonselected-list_']/option)[3]")
private WebElement editSelectAvilableRool;

@FindBy(xpath="//button[@class='btn move btn-default']")
private WebElement moveSelectedButton;



//==============================================================================


@FindBy(xpath="(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
private WebElement cancelButton;

@FindBy(xpath="//button[@id='btnSaveReconciliation']")
private WebElement saveButton;


@FindBy(xpath="//div[text()='Reconciliation Created Successfully']")
private WebElement validateSuccessfullyCreatedMessage;

//this is for edit Equipment

@FindBy(xpath="//input[@type='search']")
private WebElement search;

@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
private WebElement clickOnEdit;

@FindBy(xpath="//div[text()='Reconciliation UpdatedSuccessfully']")
private WebElement validateSuccessfullyUpdatedMessage;

//this is for delete created 
@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
private WebElement clickOnCheckBox;

@FindBy(xpath="//button[@id='btnDeleteRecon']")
private WebElement deleteButton;


@FindBy(xpath="//button[.='No']")
private WebElement validateNoButton;

@FindBy(xpath="//button[.='Yes']")
private WebElement clickOnYesButton;

@FindBy(xpath="//div[.='Selected Reconciliation Parameter Group Deleted Successfully']")
private WebElement validateSuccessfullyDeletedMessage;

@FindBy(xpath="//span[@class='custom-control-label']")
private WebElement isActiveCheckBox;
//=============================================================================================


//pdf and excel

@FindBy(xpath="//button[@class='btn btn-secondary buttons-excel buttons-html5 btn-sm mr-1']")
private WebElement excel;

@FindBy(xpath="//button[@class='btn btn-secondary buttons-pdf buttons-html5 btn-sm mr-1']")
private WebElement pdf;




//=============================================================================================

// Available Crane table 
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
	
	

public ReconciliationParameterGroupPage(WebDriver driver) {
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
public void clickToReconciliationParameterGroup(){
	webUtility.ElementClickable(driver,reconciliationParameterGroup );
	reconciliationParameterGroup.click();
}
public void createAction() throws Exception
{
	Thread.sleep(3000);
	addButton.click();
	fakeData=new Faker();
	name=fakeData.name().fullName();
	Thread.sleep(2000);
	
	webUtility.moveToElement(driver,RPGName );
	RPGName.sendKeys(name);
	webUtility.moveToElement(driver,RPGDescription );
	RPGDescription.sendKeys("this is for testing");
	clickOnClockingIdentificationMethod.click();
	selectClockingIdentificationMethod.click();
	
	
	//time
	clickOnRecognitionBoundary_EarlyIn.clear();
	clickOnRecognitionBoundary_EarlyIn.sendKeys("08:00");;
	
	
	clickOnRecognitionBoundary_LateIn.clear();
	clickOnRecognitionBoundary_LateIn.sendKeys("09:00");
	
	
	clickOnRecognitionBoundary_EarlyOut.clear();
	clickOnRecognitionBoundary_EarlyOut.sendKeys("16:00");;

	
	clickOnRecognitionBoundary_LateOut.clear();
	clickOnRecognitionBoundary_LateOut.sendKeys("22:00");
	
	   //=============================
	webUtility.moveToElement(driver,clickOnReconciliationGranularity_EarlyIn );
	clickOnReconciliationGranularity_EarlyIn.clear();
	clickOnReconciliationGranularity_EarlyIn.sendKeys("07:00");
	
	webUtility.moveToElement(driver,clickOnReconciliationGranularity_LateIn );
	clickOnReconciliationGranularity_LateIn.clear();
	clickOnReconciliationGranularity_LateIn.sendKeys("11:00");
	
	clickOnReconciliationGranularity_EarlyOut.clear();
	clickOnReconciliationGranularity_EarlyOut.sendKeys("15:00");
	
	clickOnReconciliationGranularity_LateOut.clear();
	clickOnReconciliationGranularity_LateOut.sendKeys("21:00");
	   //============================
	
	webUtility.moveToElement(driver,clickOnReconcileToPlanned_EarlyIn );
	clickOnReconcileToPlanned_EarlyIn.clear();
	clickOnReconcileToPlanned_EarlyIn.sendKeys("06:00");
	
	
	webUtility.moveToElement(driver,clickOnReconcileToPlanned_LateIn );
	clickOnReconcileToPlanned_LateIn.clear();
	clickOnReconcileToPlanned_LateIn.sendKeys("10:00");
	
	webUtility.moveToElement(driver,clickOnReconcileToPlanned_EarlyOut );
	clickOnReconcileToPlanned_EarlyOut.clear();
	clickOnReconcileToPlanned_EarlyOut.sendKeys("15:00");
	
	clickOnReconcileToPlanned_LateOut.clear();
	clickOnReconcileToPlanned_LateOut.sendKeys("20:00");
	
	//drag and drop
	webUtility.moveToElement(driver,selectAvilableRool );
	selectAvilableRool.click();
	moveSelectedButton.click();
	
	
	
	cancelButton.isDisplayed();
	
	webUtility.moveToElement(driver,saveButton );
	saveButton.click();
	closeNotificationPopup();
	}
public void editAction() throws Exception
{
	Thread.sleep(3000);
	search.sendKeys(name);
	clickOnEdit.click();
	//name=name+"JIVI";
	Thread.sleep(3000);
	editSelectAvilableRool.click();
	moveSelectedButton.click();
	
	//RPGName.sendKeys(name);
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
