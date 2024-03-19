package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.ReusableComponent;
import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class Equipment_Setup {
	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String equipmentSetupName;
	WebDriver driver;
	ReusableComponent Rc;
	WebUtilities  webUtility= new WebUtilities(driver);
	
	
	//this is for add Equipment
@FindBy(id="lblSelectedParent")
private WebElement systemSetup;

@FindBy(xpath="//span[.='System Definitions']")
private WebElement systemDefinitions;

@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
private WebElement maritimeSetup;

@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Equipment Setup']")
private WebElement equipmentSetup;

@FindBy(xpath="//button[@id='btnAddNewEquipments']")
private WebElement addButton;

@FindBy(xpath="//span/span[text()='Equipment Types']")
private WebElement clickEquipmentSetup;

@FindBy(xpath="//ul[@id='select2-cmbEquipmentType-results']/li[1]")
private WebElement selectEquipmentSetup;

@FindBy(xpath="//input[@id='txtEquipmentName']")
private WebElement equipmentName;

@FindBy(id="txtEquipmentDesc")
private WebElement enterEquipmentDescription;

@FindBy(xpath="//span[@id='select2-cmbLocationId-container']")
private WebElement clickOnLocation;

@FindBy(xpath="//ul[@id='select2-cmbLocationId-results']/li[1]")
private WebElement selectLocation;




@FindBy(xpath="(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
private WebElement cancel;

@FindBy(xpath="//button[@id='btnSaveEquipmentDeatils']")
private WebElement saveEquipmentSetupDetails;


@FindBy(xpath="//div[text()='Equipments created successfully']")
private WebElement validateSuccessfullyCreatedMessage;

//this is for edit Equipment

@FindBy(xpath="//input[@type='search']")
private WebElement search;

@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
private WebElement clickOnEdit;

@FindBy(xpath="//div[text()='Equipments updated successfully']")
private WebElement validateSuccessfullyUpdatedMessage;

//this is for delete created Equipment
@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
private WebElement clickOnCheckBox;

@FindBy(id="btnDeleteEquipments")
private WebElement deleteEquipmentSetupButton;


@FindBy(xpath="//button[.='No']")
private WebElement validateNoButton;

@FindBy(xpath="//button[.='Yes']")
private WebElement clickOnYesButton;

@FindBy(xpath="//div[.='Selected Equipments Deleted Successfully.']")
private WebElement validateSuccessfullyDeletedMessage;

@FindBy(xpath="//span[@class='custom-control-label']")
private WebElement isActiveCheckBox;


@FindBy(className = "toast-close-button")
private WebElement notificationPopup;
//perform action on elements
	
	

public Equipment_Setup(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
	this.Rc= new ReusableComponent(driver);
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

public void maritimeSetup() throws InterruptedException{
	webUtility.ElementClickable(driver, maritimeSetup);
	maritimeSetup.click();
}
public void clickOnEquipment(){
	webUtility.ElementClickable(driver, equipmentSetup);
	equipmentSetup.click();
}
public void createEquipmentSetup() throws Exception
{
	Rc.explicitWait(addButton, "clickble");
	addButton.click();
	fakeData=new Faker();
	equipmentSetupName=fakeData.name().fullName();
	Rc.explicitWait(clickEquipmentSetup,"clickble");
	clickEquipmentSetup.click();
	selectEquipmentSetup.click();
	equipmentName.sendKeys(equipmentSetupName);
	enterEquipmentDescription.sendKeys("jiviTesting");
	clickOnLocation.click();
	selectLocation.click();
	cancel.isDisplayed();
	saveEquipmentSetupDetails.click();
	closeNotificationPopup();
	}
public void editEquipmentSetup() throws Exception
{
	Rc.explicitWait(search,"clicklble");
	search.sendKeys(equipmentSetupName);
	clickOnEdit.click();
	equipmentSetupName=equipmentSetupName+"JIVI";
	equipmentName.sendKeys(equipmentSetupName);
    saveEquipmentSetupDetails.click();
	closeNotificationPopup();
	}
public void deleteEquipmentSetup() throws Exception
{
	Rc.explicitWait(search, "visible");
	search.clear();
	search.sendKeys(equipmentSetupName);
	clickOnCheckBox.click();
	deleteEquipmentSetupButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	closeNotificationPopup();
	}
public void reActivate() throws InterruptedException
{
	Rc.explicitWait(search, "visible");
	search.clear();
	search.sendKeys(equipmentSetupName);
	clickOnEdit.click();
	Rc.explicitWait(isActiveCheckBox, "clickble");
	isActiveCheckBox.click();
	saveEquipmentSetupDetails.click();
	}
}
