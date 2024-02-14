package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.github.javafaker.Faker;

public class Location_Definitions extends BaseClass{
	public Select select;
	public Actions action;
	public Faker fakeData;
	public String locationName;
	
	
	//generic locators which we have to use
	@FindBy(xpath="//input[@id='txtLocationName']")
	private WebElement locationNames;

	@FindBy(xpath="//span[@role='presentation']")
	private WebElement locationType;
	
	@FindBy(xpath="//ul/li[text()='YARD']")
	private WebElement selectLocationType;
	
	@FindBy(xpath="//input[@id='txtLocationDesc']")
	private WebElement locationDescription;

	@FindBy(xpath="//button[@id='btnSaveLocationsDeatils']/../button[1]")
	private WebElement cancel;

	@FindBy(xpath="//button[@id='btnSaveLocationsDeatils']")
	private WebElement saveLocationDetails;
	
	
	//this is for add berth
@FindBy(id="lblSelectedParent")
private WebElement systemSetup;

@FindBy(xpath="//span[.='System Definitions']")
private WebElement systemDefinitions;

@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
private WebElement maritimeSetup;

@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Location Definitions']")
private WebElement locationDefinitions;

@FindBy(xpath="//button[@id='btnAddNewLocations']")
private WebElement addButton;


@FindBy(xpath="//div[.=' Created Successfully']")
private WebElement validateSuccessfullyCreatedMessage;

//this is for edit Location

@FindBy(xpath="//input[@type='search']")
private WebElement search;

@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
private WebElement clickOnEdit;

@FindBy(xpath="//div[.=' Updated Successfully.']")
private WebElement validateSuccessfullyUpdatedMessage;

//this is for delete created berth
@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
private WebElement clickOnCheckBox;

@FindBy(xpath="//button[@id='btnDeleteLocations']")
private WebElement deleteLocationButton;

@FindBy(xpath="//button[.='No']")
private WebElement validateNoButton;

@FindBy(xpath="//button[.='Yes']")
private WebElement clickOnYesButton;

@FindBy(xpath="//div[.='Berth deleted successfully']")
private WebElement validateSuccessfullyDeletedMessage;

@FindBy(xpath="//span[@class='custom-control-label']")
private WebElement isActiveCheckBox;


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
	
	

public Location_Definitions(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver= driver;
	this.action= new Actions(driver);
}

public void selectAvailableShiftBand() {
	action.scrollToElement(availableCrane).perform();
	select = new Select(availableCrane);
	select.selectByIndex(0);
}

public void moveSingleAvailableSkillToSelected() {
	action.moveToElement(selectMoveSingle).perform();
	selectMoveSingle.click();
}
public void closeNotificationPopup() throws Exception {
	webUtility.visibilityOfElement(driver, notificationPopup);
	notificationPopup.click();
}

public void systemSetup() throws InterruptedException{
	systemSetup.click();
}
//public void enterBerthDescription(){
//	enterBerthDescription.click();
//}
public void maritimeSetup() throws InterruptedException{
	webUtility.ElementClickable(driver, maritimeSetup);
	maritimeSetup.click();
}
public void locationDefinitions(){
	
	locationDefinitions.click();
}
public void createLocation() throws Exception
{
	Thread.sleep(3000);
	addButton.click();
	fakeData=new Faker();
	locationName=fakeData.name().fullName();
	Thread.sleep(2000);
	locationNames.sendKeys(locationName);
	locationType.click();
	selectLocationType.click();
	locationDescription.sendKeys("this is For Testing");

	
	cancel.isDisplayed();
	saveLocationDetails.click();
	closeNotificationPopup();
	}
public void editLocation() throws Exception
{
	Thread.sleep(3000);
	search.sendKeys(locationName);
	clickOnEdit.click();
    locationNames.clear();
    locationName=locationName+"JIVI";
    locationNames.sendKeys(locationName);
    saveLocationDetails.click();
	closeNotificationPopup();
	}
public void deleteLocation() throws Exception
{
	Thread.sleep(3000);
	search.clear();
	search.sendKeys(locationName);
	clickOnCheckBox.click();
	deleteLocationButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	closeNotificationPopup();
	}
public void reActivate() throws InterruptedException
{
	Thread.sleep(3000);
	search.clear();
	search.sendKeys(locationName);
	clickOnEdit.click();
	Thread.sleep(3000);
	isActiveCheckBox.click();
	saveLocationDetails.click();
	}
}
