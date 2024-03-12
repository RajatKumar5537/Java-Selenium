package com.AutomationJiviewsPOM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

	public class Maritime_Setup  {
		
		public Select select;
		public Actions action ;
		public Faker fakeData;
		public String berthName;
		WebDriver driver;
		WebUtilities  webUtility= new WebUtilities(driver);
		
		//generic locators which we have to use
		@FindBy(id="txtBerth")
		private WebElement enterBerth;

		@FindBy(id="txtBerthDesc")
		private WebElement enterBerthDescription;

		@FindBy(xpath="//button[@class='btn btn-secondary btn-round icon-btn']")
		private WebElement cancel;

		@FindBy(xpath="//button[@id='btnSaveBerthDetails']")
		private WebElement saveBerthDetails;
		
		
		//this is for add berth
	@FindBy(id="lblSelectedParent")
	private WebElement systemSetup;

	@FindBy(xpath="//span[.='System Definitions']")
	private WebElement systemDefinitions;

	@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
	private WebElement maritimeSetup;

	@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Berth Setup']")
	private WebElement birthSetup;

	@FindBy(xpath="//button[@id='btnAddNew']")
	private WebElement addButton;


	@FindBy(xpath="//div[.='Berth Created Successfully']")
	private WebElement validateSuccessfullyCreatedMessage;

	//this is for edit berth

	@FindBy(xpath="//input[@type='search']")
	private WebElement search;

	@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
	private WebElement clickOnEdit;

	@FindBy(xpath="//div[.='Berth Updated Successfully.']")
	private WebElement validateSuccessfullyUpdatedMessage;

	//this is for delete created berth
	@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
	private WebElement clickOnCheckBox;

	@FindBy(id="btnDeleteBerth")
	private WebElement deleteBerthButton;

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
		
		

	public Maritime_Setup(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
		this.action= new Actions(driver);
		this.webUtility= new WebUtilities(driver);
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
	public void enterBerthDescription(){
		enterBerthDescription.click();
	}
	public void maritimeSetup() throws InterruptedException{
		webUtility.ElementClickable(driver, maritimeSetup);
		maritimeSetup.click();
	}
	public void birthSetup(){
		webUtility.ElementClickable(driver, birthSetup);
		birthSetup.click();
	}
	public void createBerth() throws Exception
	{
		Thread.sleep(3000);
		addButton.click();
		fakeData=new Faker();
		berthName=fakeData.name().fullName();
		Thread.sleep(2000);
		enterBerth.sendKeys(berthName);
		enterBerthDescription.sendKeys("this is For Testing");

		selectAvailableShiftBand();
		moveSingleAvailableSkillToSelected();
		cancel.isDisplayed();
		saveBerthDetails.click();
		closeNotificationPopup();
		}
	public void editBerth() throws Exception
	{
		Thread.sleep(3000);
		search.sendKeys(berthName);
		clickOnEdit.click();
	    enterBerth.clear();
	    berthName=berthName+"JIVI";
	    enterBerth.sendKeys(berthName);
	    saveBerthDetails.click();
		closeNotificationPopup();
		}
	public void deleteBerth() throws Exception
	{
		Thread.sleep(3000);
		search.clear();
		search.sendKeys(berthName);
		clickOnCheckBox.click();
		deleteBerthButton.click();
		validateNoButton.isDisplayed();
		clickOnYesButton.click();
		closeNotificationPopup();
		}
	public void reActivate() throws InterruptedException
	{
		Thread.sleep(3000);
		search.clear();
		search.sendKeys(berthName);
		clickOnEdit.click();
		Thread.sleep(3000);
		isActiveCheckBox.click();
		saveBerthDetails.click();
		}
	
}
