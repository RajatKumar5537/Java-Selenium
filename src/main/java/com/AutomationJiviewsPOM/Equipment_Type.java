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

public class Equipment_Type {
	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String equipmentName;
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

@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[text()='Equipment Types']")
private WebElement equipmentTypes;

@FindBy(xpath="//button[@id='btnAddNewEquipmentTypes']")
private WebElement addButton;

@FindBy(id="txtEquipmentType")
private WebElement enterEquipmentType;

@FindBy(id="txtEquipmentTypeDesc")
private WebElement enterEquipmentDescription;


// add Skills

@FindBy(xpath="//button[@id='btnAddSkillRequired']")
private WebElement addSkillsButton;

@FindBy(xpath="//span[text()='Select Skill']")
private WebElement clickSelectkill;

@FindBy(xpath="//ul[@id='select2-cmbTableRowSkill-results']/li[1]")
private WebElement selectSkill;

@FindBy(xpath="//input[@id='txtRequirement']")
private WebElement addRequirement;

@FindBy(xpath="//button[@id='btnSaveEquipmentRequired']")
private WebElement saveSkill;

@FindBy(xpath="//button[@id='btnSaveEquipmentRequired']/../button[2]")
private WebElement editSkillButton;

@FindBy(xpath="//button[@id='btnSaveEquipmentRequired']/../button[3]")
private WebElement deleteSkillButton;


@FindBy(xpath="//button[@id='btnCloseEqpTypes']")
private WebElement cancel;

@FindBy(xpath="//button[@id='btnSaveEquipmentTypesDeatils']")
private WebElement saveEquipmentDetails;


@FindBy(xpath="//div[text()='Equipment Type Created Successfully']")
private WebElement validateSuccessfullyCreatedMessage;

//this is for edit Equipment

@FindBy(xpath="//input[@type='search']")
private WebElement search;

@FindBy(xpath="(//table/tbody/tr/td/button)[1]")
private WebElement clickOnEdit;

@FindBy(xpath="//div[text()='Equipment Type Updated Successfully.']")
private WebElement validateSuccessfullyUpdatedMessage;

//this is for delete created Equipment
@FindBy(xpath="//table/tbody/tr/td/input[@type='checkbox'][1]")
private WebElement clickOnCheckBox;

@FindBy(id="btnDeleteEquipmentTypes")
private WebElement deleteEquipmentTypeButton;

@FindBy(xpath="//button[.='No']")
private WebElement validateNoButton;

@FindBy(xpath="//button[.='Yes']")
private WebElement clickOnYesButton;

@FindBy(xpath="//div[.='Selected Equipment Types Deleted Successfully.']")
private WebElement validateSuccessfullyDeletedMessage;

@FindBy(xpath="//span[@class='custom-control-label']")
private WebElement isActiveCheckBox;

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
	
	

public Equipment_Type(WebDriver driver) {
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
	webUtility.ElementClickable(driver, equipmentTypes);
	equipmentTypes.click();
}
public void createEquipment() throws Exception
{
	Rc.explicitWait(addButton,"clickable" );
	addButton.click();
	fakeData=new Faker();
	equipmentName=fakeData.name().fullName();
	Rc.explicitWait(enterEquipmentType, "visible");
	enterEquipmentType.sendKeys(equipmentName);
	enterEquipmentDescription.sendKeys("this is For Testing");

	//add skill
	addSkillsButton.click();
	clickSelectkill.click();
	selectSkill.click();
	addRequirement.sendKeys("1");
	saveSkill.click();
	editSkillButton.isDisplayed();
	deleteSkillButton.isDisplayed();
	cancel.isDisplayed();
	saveEquipmentDetails.click();
	closeNotificationPopup();
	}
public void editEquipment() throws Exception
{
	Rc.explicitWait(search,"visible");
	search.sendKeys(equipmentName);
	clickOnEdit.click();
    enterEquipmentType.clear();
    equipmentName=equipmentName+"JIVI";
    enterEquipmentType.sendKeys(equipmentName);
    saveEquipmentDetails.click();
	closeNotificationPopup();
	}
public void deleteEquipment() throws Exception
{
	Rc.explicitWait(search,"visible");
	search.clear();
	search.sendKeys(equipmentName);
	clickOnCheckBox.click();
	deleteEquipmentTypeButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	closeNotificationPopup();
	}
public void reActivate() throws InterruptedException
{
Rc.explicitWait(search, "visible");
	search.clear();
	search.sendKeys(equipmentName);
	clickOnEdit.click();
	Thread.sleep(3000);
	isActiveCheckBox.click();
	saveEquipmentDetails.click();
	}
}
