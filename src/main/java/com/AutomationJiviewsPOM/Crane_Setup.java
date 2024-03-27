package com.AutomationJiviewsPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.ReusableComponent;
import com.github.javafaker.Faker;

public class Crane_Setup {
	public String craneName;
	WebDriver driver;
	ReusableComponent Rc;

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

	//====================================================================

	//generic locators which we have to use
	@FindBy(id="txtCraneNumber")
	private WebElement enterCraneName;

	@FindBy(id="txtCraneDesc")
	private WebElement craneDescription;

	@FindBy(xpath="//label[text()='Location']/../div")
	private WebElement clickOnLocation;

	@FindBy(xpath="//ul[@id='select2-cmbLocationId-results']/li[2]")
	private WebElement selectLocation;

	@FindBy(xpath="//button[@id='btnCloseCranesDeatils']")
	private WebElement cancel;

	@FindBy(xpath="//button[@id='btnSaveCranesDeatils']")
	private WebElement saveCraneDetails;


	//this is for add berth
	@FindBy(id="lblSelectedParent")
	private WebElement systemSetup;

	@FindBy(xpath="//span[.='System Definitions']")
	private WebElement systemDefinitions;

	@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
	private WebElement maritimeSetup;

	@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Crane Setup']")
	private WebElement craneSetup;

	@FindBy(xpath="//button[@id='btnAddNewCranes']")
	private WebElement addButton;

	@FindBy(xpath="//div[text()='Cranes Created Successfully']")
	private WebElement validateSuccessfullyCreatedMessage;


	//this is for edit berth
	@FindBy(xpath="(//label[text()='Search Columns:']/input[@type='search'])[1]")
	private WebElement search;

	@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
	private WebElement clickOnEdit;

	@FindBy(xpath="//div[.='Cranes Updated Successfully.']")
	private WebElement validateSuccessfullyUpdatedMessage;

	//this is for delete created berth
	@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
	private WebElement clickOnCheckBox;

	@FindBy(xpath="//button[@id='btnDeleteCranes']")
	private WebElement deleteCraneButton;

	@FindBy(xpath="//button[.='No']")
	private WebElement validateNoButton;

	@FindBy(xpath="//button[.='Yes']")
	private WebElement clickOnYesButton;

	@FindBy(xpath="//div[.='Selected Cranes Deleted Successfully.']")
	private WebElement validateSuccessfullyDeletedMessage;

	@FindBy(xpath="//span[@class='custom-control-label']")
	private WebElement isActiveCheckBox;

	@FindBy(xpath="//div[.='Cranes Updated Successfully.']")
	private WebElement validateSuccessfullyReactivedMessage;


	// Available Crane table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableCrane;

	//select for single Arrow -> move RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle; 

	//select for move multiple RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;


	//perform action on elements



	public Crane_Setup(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Rc= new ReusableComponent(driver);
	}
	public void createCrane() throws Exception
	{
		Rc.explicitWait(clickOu, "clickable");
		Rc.handleMultipleElements(clickOu, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Crane Setup", "Crane Setup  is not clicked");


		Rc.explicitWait(addButton, "clickable");
		addButton.click();
		craneName=Rc.name;
		Rc.explicitWait(enterCraneName,"visible");
		enterCraneName.sendKeys(craneName);
		craneDescription.sendKeys("this is For Testing");
		clickOnLocation.click();
		Rc.explicitWait(selectLocation,"clickable");
		selectLocation.click();
		cancel.isDisplayed();
		saveCraneDetails.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
	public void editCrane() throws Exception
	{
		Thread.sleep(3000);
		Rc.explicitWait(search, "visible");
		search.sendKeys(craneName);
		Thread.sleep(3000);
		clickOnEdit.click();
		enterCraneName.clear();
		craneName=craneName+"JIVI";
		enterCraneName.sendKeys(craneName);
		saveCraneDetails.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
	public void deleteCrane() throws Exception
	{
		Thread.sleep(3000);
		Rc.explicitWait(search,"visible" );
		search.clear();
		search.clear();
		search.sendKeys(craneName);
		Thread.sleep(3000);
		clickOnCheckBox.click();
		deleteCraneButton.click();
		validateNoButton.isDisplayed();
		clickOnYesButton.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
	public void reActivate() throws InterruptedException
	{
		Thread.sleep(3000);
		Rc.explicitWait(search,"visible" );
		search.clear();
		search.clear();
		search.sendKeys(craneName);
		Thread.sleep(3000);
		clickOnEdit.click();
		Rc.explicitWait(isActiveCheckBox,"clickable" );
		isActiveCheckBox.click();
		Rc.explicitWait(saveCraneDetails, "clickable");
		saveCraneDetails.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
}
