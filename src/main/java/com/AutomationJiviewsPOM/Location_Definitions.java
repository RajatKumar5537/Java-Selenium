package com.AutomationJiviewsPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ReusableComponent;
import com.github.javafaker.Faker;

public class Location_Definitions extends BaseClass{
	
	public String locationName;
	WebDriver driver;
	public ReusableComponent Rc;
	
	
	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement clickOu;
	
 
	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU
 
	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;
 
	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // System Definitions
 
	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[5]")
	WebElement ulApplicationMenu; // Maritime Setup	
 
	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[5]/li")
	List<WebElement> sideNavMenu; // Berth Setup
	
	//========================================================
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

@FindBy(xpath="//input[@class='form-control form-control-sm']")
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
	this.Rc=new ReusableComponent(driver);
}


public void createLocation() throws Exception
{
	

	Rc.explicitWait(clickOu, "clickable");
	Rc.handleMultipleElements(clickOu, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
	Rc.explicitWait(dvApplicationMenuItems, "clickable");
	Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
	Rc.explicitWait(ulApplicationMenu, "clickable");
	Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Location Definitions", "Location Definitions  is not clicked");
	
	Rc.explicitWait(addButton, "clickable");
	addButton.click();
	
	locationName=Rc.name;
	Rc.explicitWait(locationNames, "visible");
	locationNames.sendKeys(locationName);
	Rc.explicitWait(locationType, "clickable");
	locationType.click();
	selectLocationType.click();
	locationDescription.sendKeys("this is For Testing");

	cancel.isDisplayed();
	saveLocationDetails.click();
	notificationPopup.click();
	}
public void editLocation() throws Exception
{
	Thread.sleep(3000);
	Rc.explicitWait(search, "visible");
	search.sendKeys(locationName);
	Thread.sleep(3000);
	clickOnEdit.click();
    locationNames.clear();
    locationName=locationName+"JIVI";
    locationNames.sendKeys(locationName);
    saveLocationDetails.click();
    notificationPopup.click();
	}
public void deleteLocation() throws Exception
{
	Thread.sleep(3000);
	Rc.explicitWait(search,"visible" );
	search.clear();
	search.clear();
	Rc.explicitWait(search,"visible" );
	search.sendKeys(locationName);
	Thread.sleep(3000);
	clickOnCheckBox.click();
	Rc.explicitWait(deleteLocationButton, "clickable");
	deleteLocationButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	notificationPopup.click();
	}
public void reActivate() throws InterruptedException
{
	Thread.sleep(3000);
	Rc.explicitWait(search,"visible" );
	search.clear();
	search.clear();
	Rc.explicitWait(search,"visible" );
	search.sendKeys(locationName);
	Thread.sleep(3000);
	clickOnEdit.click();
	Rc.explicitWait(isActiveCheckBox,"clickable" );
	isActiveCheckBox.click();
	saveLocationDetails.click();
	}
}
