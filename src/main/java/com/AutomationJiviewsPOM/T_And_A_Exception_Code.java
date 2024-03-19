package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class T_And_A_Exception_Code {
	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String equipmentName;
	WebDriver driver;
	WebUtilities  webUtility= new WebUtilities(driver);
	
	
	//this is for validate
@FindBy(id="lblSelectedParent")
private WebElement systemSetup;

@FindBy(xpath="//span[.='System Definitions']")
private WebElement systemDefinitions;

@FindBy(xpath="//a[@class='sidenav-link sidenav-toggle']/div[text()='Time & Attendance']")
private WebElement timeAndAttendance;

@FindBy(xpath="//a[@class='sidenav-link']/div[text()='T&A Exception Codes']")
private WebElement tAndAExceptionCodes;

@FindBy(xpath="//select[@name='ExceptionType-list_length']")
private WebElement shawEntries;

@FindBy(xpath="//input[@class='form-control form-control-sm']")
private WebElement searchRecords;

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
	
	

public T_And_A_Exception_Code(WebDriver driver) {
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
public void clicktAndAExceptionCodes(){
	webUtility.ElementClickable(driver, tAndAExceptionCodes);
	tAndAExceptionCodes.click();
}
public void validationTAndA() throws Exception
{
	Thread.sleep(3000);
	shawEntries.isDisplayed();
	searchRecords.isDisplayed();
	excel.isDisplayed();
	pdf.isDisplayed();
	}
}
