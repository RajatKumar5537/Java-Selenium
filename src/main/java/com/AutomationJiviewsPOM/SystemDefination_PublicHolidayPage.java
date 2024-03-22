package com.AutomationJiviewsPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ReusableComponent;

public class SystemDefination_PublicHolidayPage 
{

	WebDriver driver ;
	ReusableComponent Rc;
	Actions action;
	String HolidayName ;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // System Definitions

	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[2]")
	WebElement ulApplicationMenu; // Roster Setup

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[2]/li")
	List<WebElement> sideNavMenu; // Public Holiday


	@FindBy(xpath = "//button[@id='btnAddNew']")
	WebElement btnAddNew;

	@FindBy(id = "txtHolidayName")
	WebElement txtHolidayName;

	@FindBy(xpath = "//input[@id='txtHolidayDate']")
	WebElement txtHolidayDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[9]")
	WebElement dateCalander;

	@FindBy(xpath = "//span[text()='Paid ?']")
	WebElement chkIsPaid;

	@FindBy(id = "txtHolidayNote")
	WebElement txtHolidayNote;

	@FindBy(id = "btnSavePublicHldayDeatils")
	WebElement btnSavePublicHldayDeatils;


	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement btnEdit;


	@FindBy(xpath = "(//td[@class=' select-checkbox']/input)[1]")
	WebElement checkbox;

	@FindBy(id = "btnDeletePublicHlday")
	WebElement btnDeletePublicHlday;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;

	@FindBy(xpath = "//div[text()='Public Holiday created successfully']") 
	WebElement notificationCreatePopup;
	@FindBy(xpath = "//div[text()='Public Holiday updated successfully']")
	WebElement notificationUpdatePopup;
	@FindBy(xpath = "//div[text()='Deleted Selected Public Holiday Data.']")
	WebElement notificationDeletePopup;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchBar;

	//  ****** Constructor ******
	public SystemDefination_PublicHolidayPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver ;
		this.Rc= new ReusableComponent(driver);
		this.action= new Actions(driver);
	}

	public void createPublicHoliday() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicked");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Public Holiday", "Public Holiday is not clicked");

		Rc.explicitWait(btnAddNew, "visible");
		btnAddNew.click();
		HolidayName= Rc.name;
		Thread.sleep(2000);
		Rc.explicitWait(txtHolidayName, "visible");
		txtHolidayName.clear();
		txtHolidayName.sendKeys(HolidayName);
		
		txtHolidayDate.click();
		dateCalander.click();
		
		txtHolidayNote.clear();
		txtHolidayNote.sendKeys(Rc.description);
		Rc.explicitWait(txtHolidayName, "clickable");
		btnSavePublicHldayDeatils.click();
		Rc.explicitWait(notificationCreatePopup, "visible");
		String actualResult = notificationCreatePopup.getText();
		Assert.assertTrue(actualResult.contains("Public Holiday created successfully"));
		notificationCreatePopup.click();

	}

	public void editPublicHoliday() throws Exception 
	{
		Rc.explicitWait(searchBar, "visible");
		searchBar.clear();
		searchBar.sendKeys(HolidayName);
		action.moveToElement(btnEdit).perform();
		btnEdit.click();
		HolidayName= Rc.name;
		Rc.explicitWait(txtHolidayName, "visible");
		txtHolidayName.clear();
		txtHolidayName.sendKeys(HolidayName);
		Rc.explicitWait(searchBar, "clickable");
		chkIsPaid.click();
		txtHolidayNote.clear();
		txtHolidayNote.sendKeys(Rc.description);
		Rc.explicitWait(btnSavePublicHldayDeatils, "clickable");
		btnSavePublicHldayDeatils.click();
		Rc.explicitWait(notificationUpdatePopup, "visible");
		String actualResult = notificationUpdatePopup.getText();
		Assert.assertTrue(actualResult.contains("Public Holiday updated successfully"));
		notificationUpdatePopup.click();
	}

	public void deletePublicHoliday() throws InterruptedException 
	{
		Thread.sleep(1000);
		Rc.explicitWait(checkbox, "clickable");
		checkbox.click();
		Rc.explicitWait(btnDeletePublicHlday, "clickable");
		btnDeletePublicHlday.click();
		Rc.explicitWait(btnYes, "clickable");
		btnYes.click();
		notificationDeletePopup.click();

	}
}

