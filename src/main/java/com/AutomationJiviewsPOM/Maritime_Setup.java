//package com.AutomationJiviewsPOM;
//
//
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//import com.AutomationJiviewsGeneric.ReusableComponent;
//import com.AutomationJiviewsGeneric.WebUtilities;
//import com.github.javafaker.Faker;
//
//public class Maritime_Setup {
//	
//	public Select select;
//	public Actions action ;
//	public Faker fakeData;
//	public String berthName;
//	WebDriver driver;
//	ReusableComponent Rc;
//	WebUtilities  webUtility= new WebUtilities(driver);
//	
//	//generic locators which we have to use
//	@FindBy(id="txtBerth")
//	private WebElement enterBerth;
//
//	@FindBy(id="txtBerthDesc")
//	private WebElement enterBerthDescription;
//
//	@FindBy(xpath="//button[@class='btn btn-secondary btn-round icon-btn']")
//	private WebElement cancel;
//
//	@FindBy(xpath="//button[@id='btnSaveBerthDetails']")
//	private WebElement saveBerthDetails;
//	
//	
//	//this is for add berth
//@FindBy(id="lblSelectedParent")
//private WebElement systemSetup;
//
//@FindBy(xpath="//span[.='System Definitions']")
//private WebElement systemDefinitions;
//
//@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
//private WebElement maritimeSetup;
//
//@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Berth Setup']")
//private WebElement birthSetup;
//
//@FindBy(xpath="//button[@id='btnAddNew']")
//private WebElement addButton;
//
//
//@FindBy(xpath="//div[.='Berth Created Successfully']")
//private WebElement validateSuccessfullyCreatedMessage;
//
////this is for edit berth
//
//@FindBy(xpath="//input[@type='search']")
//private WebElement search;
//
//@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
//private WebElement clickOnEdit;
//
//@FindBy(xpath="//div[.='Berth Updated Successfully.']")
//private WebElement validateSuccessfullyUpdatedMessage;
//
////this is for delete created berth
//@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
//private WebElement clickOnCheckBox;
//
//@FindBy(id="btnDeleteBerth")
//private WebElement deleteBerthButton;
//
//@FindBy(xpath="//button[.='No']")
//private WebElement validateNoButton;
//
//@FindBy(xpath="//button[.='Yes']")
//private WebElement clickOnYesButton;
//
//@FindBy(xpath="//div[.='Berth deleted successfully']")
//private WebElement validateSuccessfullyDeletedMessage;
//
//@FindBy(xpath="//span[@class='custom-control-label']")
//private WebElement isActiveCheckBox;
//
//
//
//// Available Crane table 
//	@FindBy(xpath = "(//select[@class='form-control'])[1]")
//	private WebElement availableCrane;
//
//	// select for single Arrow -> move RTG from available RTG table to Selected RTG table 
//	@FindBy(xpath = "//button[@class='btn move btn-default']")
//	private WebElement selectMoveSingle; 
//
//	//		select for move multiple RTG from available RTG table to Selected RTG table 
//	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
//	private WebElement selectMoveAll;
//
//	@FindBy(className = "toast-close-button")
//	private WebElement notificationPopup;
//	
//	
//	//this locator is for excel
//	
//	@FindBy(xpath = "//button[@class='btn btn-secondary buttons-excel buttons-html5 btn-sm mr-1']")
//	private WebElement downloadExcel;
//	
//	
//	
//	//this locator is for oOOOOOOOOOOOOOOuUUUUUUUUUUUUUUUUUUUUU
//	@FindBy(xpath = "//span[@id='lblSelectedOrgUnit']")
//	private WebElement clickOnOrganizationUnit;
//	
//	@FindBy(xpath = "//ul[@class='list-group']/li")
//	private List<WebElement> selectOnOrganizationUnit;
//	
//	
//	@FindBy(xpath = "//span[@id='lblSelectedParent']")
//	private WebElement clickOnSystemSetup;
//	
//	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
//	private List<WebElement> selectOnSystemSetup;
//	
//	
//	@FindBy(xpath ="(//ul[@id='ulApplicationMenu']/li)[5]")
//	private WebElement clickOnSideMenu;
//	
//	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[5]/li" )
//	private List<WebElement> selectOnSideMenu;
//	
//	
////perform action on elements
//	
//	
//
//public Maritime_Setup(WebDriver driver) {
//	PageFactory.initElements(driver, this);
//	this.driver = driver;
//	this.Rc=new ReusableComponent(driver);
//	this.action= new Actions(driver);
//	this.webUtility= new WebUtilities(driver);
//}
//
//public void selectAvailableShiftBand() {
//	action.scrollToElement(availableCrane).perform();
//	select = new Select(availableCrane);
//	select.selectByIndex(0);
//}
//
//public void moveSingleAvailableSkillToSelected() {
//	action.moveToElement(selectMoveSingle).perform();
//	selectMoveSingle.click();
//}
//public void closeNotificationPopup() throws Exception {
//	webUtility.visibilityOfElement(driver, notificationPopup);
//	notificationPopup.click();
//}
//public void ou() throws InterruptedException
//{
//	Rc.handleMultipleElements(clickOnOrganizationUnit,selectOnOrganizationUnit,"auto ou","the element is not present in this Organization unit");
//	Rc. explicitWait(clickOnSystemSetup,"clickable");
//	Rc.handleMultipleElements(clickOnSystemSetup,selectOnSystemSetup,"System Definitions", "the main menu is not present");
//	Rc. explicitWait(clickOnSystemSetup,"clickable");
//	Rc.handleMultipleElements(clickOnSideMenu,selectOnSideMenu, "Berth Setup", "the side navigation menu is not present");
//	}
//
//public void createBerth() throws Exception
//{
//	
//	
//	Rc. explicitWait(addButton,"clickable");//********************************************************************
//	addButton.click();
//	fakeData=new Faker();
//	berthName=fakeData.name().fullName();
//	Rc. explicitWait(enterBerth,"visibility");
//	enterBerth.sendKeys(berthName);
//	enterBerthDescription.sendKeys("this is For Testing");
//
//	selectAvailableShiftBand();
//	moveSingleAvailableSkillToSelected();
//	cancel.isDisplayed();
//	saveBerthDetails.click();
//	closeNotificationPopup();
//	}
//public void editBerth() throws Exception
//{
//	//Rc.alertPopup("accept");
//	Rc. explicitWait(search,"visibility");
//	search.sendKeys(berthName);
//	Rc. explicitWait(clickOnEdit,"visibility");
//	clickOnEdit.click();
//    enterBerth.clear();
//    berthName=berthName+"JIVI";
//    enterBerth.sendKeys(berthName);
//    saveBerthDetails.click();
//	closeNotificationPopup();
//	}
//public void deleteBerth() throws Exception
//{
//	Rc. explicitWait(search,"visibility");
//	search.clear();
//	search.sendKeys(berthName);
//	Rc. explicitWait(clickOnCheckBox,"visibility");
//	clickOnCheckBox.click();
//	deleteBerthButton.click();
//	validateNoButton.isDisplayed();
//	clickOnYesButton.click();
//	closeNotificationPopup();
//	}
//public void reActivate() throws InterruptedException
//{
//	Thread.sleep(3000);
//	
//	search.clear();
//	search.sendKeys(berthName);
//	Rc. explicitWait(clickOnEdit,"visibility");
//	clickOnEdit.click();
//	Rc. explicitWait(isActiveCheckBox,"clickable");
//	isActiveCheckBox.click();
//	Rc. explicitWait(isActiveCheckBox,"clickable");
//	saveBerthDetails.click();
//	}
//}
