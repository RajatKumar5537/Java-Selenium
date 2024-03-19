package com.AutomationJiviewsPOM;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.ReusableComponent;
import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class Berth_Setup {
	
	WebDriver driver;
	ReusableComponent Rc;
	String berthName;
 
 
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
 
 
 
	//generic locators which we have to use
	
	@FindBy(id="txtBerth")
	WebElement enterBerth;
 
	@FindBy(id="txtBerthDesc")
	WebElement enterBerthDescription;
 
	@FindBy(xpath="//button[@class='btn btn-secondary btn-round icon-btn']")
	WebElement cancel;
 
	@FindBy(xpath="//button[@id='btnSaveBerthDetails']")
	WebElement saveBerthDetails;
 
 
 
	@FindBy(xpath="//button[@id='btnAddNew']")
	WebElement addButton;
 
 
	@FindBy(xpath="//div[.='Berth Created Successfully']")
	WebElement validateSuccessfullyCreatedMessage;
 
	//this is for edit berth
 
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	WebElement search;
 
	@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
	WebElement clickOnEdit;
 
	@FindBy(xpath="//div[.='Berth Updated Successfully.']")
	WebElement validateSuccessfullyUpdatedMessage;
 
	//this is for delete created berth
	@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
	WebElement clickOnCheckBox;
 
	@FindBy(id="btnDeleteBerth")
	WebElement deleteBerthButton;
 
	@FindBy(xpath="//button[.='No']")
	WebElement validateNoButton;
 
	@FindBy(xpath="//button[.='Yes']")
	WebElement clickOnYesButton;
 
	@FindBy(xpath="//div[.='Berth deleted successfully']")
	WebElement validateSuccessfullyDeletedMessage;
 
	@FindBy(xpath="//span[@class='custom-control-label']")
	WebElement isActiveCheckBox;
 
 
	// Available Crane table
	@FindBy(xpath = "//Select[@id='bootstrap-duallistbox-nonselected-list_']")
	WebElement availableCrane;
 
	// select for single Arrow -> move RTG from available RTG table to Selected RTG table
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle;
 
	//		select for move multiple RTG from available RTG table to Selected RTG table
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	WebElement selectMoveAll;
 
	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;
	
	
	
	//this is for excel
	
	@FindBy(xpath = "//button[@class='btn btn-secondary buttons-excel buttons-html5 btn-sm mr-1']")
	private WebElement downloadExcel;
	
	//perform action on elements
 
 
	//  ****** Constructor ******
	public Berth_Setup(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.Rc= new ReusableComponent(driver);
		
	}
 
	
	public void createBerth() throws Exception
	{
		Rc.explicitWait(clickOu, "clickable");
		Rc.handleMultipleElements(clickOu, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Berth Setup", "Berth Setup is not clicked");
 
		Rc.explicitWait(addButton, "clickable");
		addButton.click();
		berthName=Rc.name;
		System.out.println(berthName);
		Rc.explicitWait(enterBerth,"visible" );
		enterBerth.sendKeys(berthName);
		enterBerthDescription.sendKeys("this is for testing");
		Rc.selectByIndex(availableCrane,0);
		selectMoveSingle.click();
		cancel.isDisplayed();
		saveBerthDetails.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
	public void editBerth() throws Exception
	{
		Rc.explicitWait(notificationPopup,"visible");
		search.sendKeys(berthName);
		clickOnEdit.click();
		berthName=Rc.name;
		Rc.explicitWait(enterBerth, "visible");
		enterBerth.clear();
		enterBerth.sendKeys(berthName);
		saveBerthDetails.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}
	public void deleteBerth() throws Exception
	{
		Rc.explicitWait(search, "visible");
		search.clear();
		search.clear();
		search.sendKeys(berthName);
		Thread.sleep(3000);
		clickOnCheckBox.click();
		Rc.explicitWait(deleteBerthButton, "clickable");
		deleteBerthButton.click();
		Rc.explicitWait(validateNoButton, "visible");
		validateNoButton.isDisplayed();
		clickOnYesButton.click();
		Rc.explicitWait(notificationPopup, "clickable");
		Rc.explicitWait(downloadExcel, "visible");
		notificationPopup.click();
	}
	public void reActivate() throws InterruptedException
	{
		Thread.sleep(3000);
		search.clear();
		search.clear();
		search.sendKeys(berthName);
		Rc.explicitWait(clickOnEdit,"clickable");
		Thread.sleep(3000);
		clickOnEdit.click();
		Rc.explicitWait(search, "clickable");
		isActiveCheckBox.click();
		saveBerthDetails.click();
	}
}
