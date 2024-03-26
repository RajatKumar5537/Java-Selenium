package com.AutomationJiviewsPOM;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.AutomationJiviewsGeneric.ReusableComponent;


public class SystemDefination_SkillPage  
{
	
	WebDriver driver;
	ReusableComponent Rc ;
	String skillCodeData;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // System Definitions

	@FindBy(xpath = "(//ul[@id='ulApplicationMenu']/li)[1]")
	WebElement ulApplicationMenu; // Employee Setup

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[1]/li")
	List<WebElement> sideNavMenu; // Skills
	
	
	

	@FindBy(xpath = "//button[@id='btnAddSkill']")
	WebElement addBtn;

	@FindBy(xpath = "//input[@id='txtSkillCode']")
	WebElement skillCode;

	@FindBy(id="txtSkillCodeDescription")
	WebElement skillDescription;

	@FindBy(id = "txtSequence")
	WebElement sequence;

	@FindBy(id = "txtColourCode")
	WebElement ColourCode;

	@FindBy(id = "txtFixedRanking")
	WebElement wageLevelCode;

	@FindBy(xpath = "//span[text()='Is Active?']")
	WebElement isActiveOption;

	@FindBy(id = "btnSaveSkill")
	WebElement saveBtn;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	WebElement editBtn;

	@FindBy(xpath = "//li[@id='skill-list_next']")
	WebElement nextPage;

	@FindBy(id = "btnDeleteSkill")
	WebElement btnDeleteSkill;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement clickYes;

	@FindBy(xpath =  "(//input[@type='checkbox'])[2]")
	WebElement checkBox;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchColumns;
	@FindBy(xpath = "//button[@class='btn btn-secondary buttons-excel buttons-html5 btn-sm mr-1']")
	WebElement btnExcel;
	@FindBy(xpath = "//button[@class='btn btn-secondary buttons-pdf buttons-html5 btn-sm mr-1']")
	WebElement btnPDF;
	
	//	*********** Constructor *********
	public SystemDefination_SkillPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver; 
		this.Rc= new ReusableComponent(driver);
	}



	public void createNewSkill() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicking");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "System Definitions", "System Definitions is not clicking");
		Rc.explicitWait(ulApplicationMenu, "clickable");
		Rc.handleMultipleElements(ulApplicationMenu, sideNavMenu, "Skills", "Skills is not clicking");
		
		skillCodeData= Rc.name;
		Rc.explicitWait(addBtn, "clickable");
		addBtn.click();
		Rc.explicitWait(skillCode, "clickable");
		skillCode.clear();
		skillCode.sendKeys(skillCodeData);
		skillDescription.clear();
		skillDescription.sendKeys(Rc.description);
		sequence.clear();
		sequence.sendKeys(Rc.randomInt);
		wageLevelCode.clear();
		wageLevelCode.sendKeys(Rc.randomInt);
		Rc.explicitWait(saveBtn, "clickable");
		saveBtn.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		btnExcel.isEnabled();
		btnPDF.isSelected();


	}

	public void editSkill() throws Exception 
	{
		
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(skillCodeData);
		skillCodeData = Rc.firstName;
		Rc.explicitWait(editBtn, "clickable");
		editBtn.click();
		Rc.explicitWait(skillCode, "clickable");
		skillCode.clear();
		skillCode.sendKeys(skillCodeData );
		skillDescription.clear();
		skillDescription.sendKeys(Rc.description);
		Rc.explicitWait(saveBtn, "clickable");
		saveBtn.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void deleteSkill() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(skillCodeData);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.explicitWait(btnDeleteSkill, "clickable");
		btnDeleteSkill.click();
		Rc.explicitWait(clickYes, "clickable");
		clickYes.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void reactivateSkill() throws Exception 
	{
		Thread.sleep(2000);
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(skillCodeData);
		Thread.sleep(2000);
		Rc.explicitWait(editBtn, "clickable");
		editBtn.click();
		Rc.explicitWait(isActiveOption, "clickable");
		isActiveOption.click();
		Rc.explicitWait(saveBtn, "clickable");
		saveBtn.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void searchColumns() throws Exception {
		Thread.sleep(2000);
		Rc.explicitWait(searchColumns, "clickable");
		searchColumns.clear();
		searchColumns.sendKeys(skillCodeData);

	}

}
