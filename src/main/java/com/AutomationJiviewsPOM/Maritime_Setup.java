package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.AutomationJiviewsGeneric.BaseClass;
import com.aventstack.extentreports.model.Report;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class Maritime_Setup extends BaseClass {
	
	Faker fakeData;
	String berthName;
	//generic locators which we have to use
	@FindBy(id="txtBerth")
	private WebElement enterBerth;

	@FindBy(id="txtBerthDesc")
	private WebElement enterBerthDescription;

	@FindBy(id="//button[@class='btn btn-secondary btn-round icon-btn']")
	private WebElement cancel;

	@FindBy(id="btnSaveBerthDetails")
	private WebElement saveBerthDetails;
	
	
	//this is for add berth
@FindBy(id="lblSelectedParent")
private WebElement systemSetup;

@FindBy(xpath="//span[.='System Definitions']")
private WebElement systemDefinitions;

@FindBy(xpath="//ul[@id='ulApplicationMenu']/li/a/div[text()='Maritime Setup']")
private WebElement maritimeSetup;

@FindBy(xpath="//ul[@class='sidenav-menu']/li/a/div[.='Berth Setup']")
private WebElement birthSetup;

@FindBy(id="btnAddNew")
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



//perform action on elements

public Maritime_Setup(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
}

public void systemSetup() throws InterruptedException{
	Thread.sleep(5000);
	Reporter.log("this is working**********************",true);
	systemSetup.click();
}
public void enterBerthDescription(){
	enterBerthDescription.click();
}
public void maritimeSetup() throws InterruptedException{
	Thread.sleep(5000);
	Reporter.log("this is working**********************",true);
	maritimeSetup.click();
}
public void birthSetup(){
	birthSetup.click();
}
public void createBerth()
{
	addButton.click();
	System.out.println(berthName);
	fakeData=new Faker();
	berthName="S"+fakeData.name().fullName();
	System.out.println(berthName);
	enterBerth.sendKeys(berthName);
	enterBerthDescription.sendKeys("this is For Testing");
	cancel.isDisplayed();
	saveBerthDetails.click();
	
	}
public void editBerth()
{
	search.sendKeys(berthName);
	clickOnEdit.click();
    enterBerth.clear();
    berthName=berthName+"JIVI";
    enterBerth.sendKeys(berthName);
    saveBerthDetails.click();
	}
public void deleteBerth()
{
	search.sendKeys(berthName);
	clickOnCheckBox.click();
	deleteBerthButton.click();
	validateNoButton.isDisplayed();
	clickOnYesButton.click();
	
	}
public void reActivate()
{
	search.sendKeys(berthName);
	clickOnEdit.click();
	isActiveCheckBox.click();
	saveBerthDetails.click();
	}
}
