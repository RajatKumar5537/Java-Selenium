package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.WebUtilities;

public class SystemDefinationPublicHolidayPage extends BaseClass{
	public String timeStamp = LocalDateTime.now().toString();
	public Actions action;
	public Select select;
	public WebUtilities webUtility;
	public SystemDefinationPublicHolidayPage sdph;
	public ExcelUtilities excelUtility;
	public String holidayName;
	public String holidayDate;
	public String holidayNote;
	
	@FindBy(xpath = "//button[@id='btnAddNew']/span")
	private WebElement btnAddNew;
	
	@FindBy(id = "txtHolidayName")
	private WebElement txtHolidayName;
	
	@FindBy(id = "txtHolidayDate")
	private WebElement txtHolidayDate;
	
	@FindBy(xpath = "//span[text()='Paid ?']")
	private WebElement chkIsPaid;
	
	@FindBy(id = "txtHolidayNote")
	private WebElement txtHolidayNote;
	
	@FindBy(id = "btnSavePublicHldayDeatils")
	private WebElement btnSavePublicHldayDeatils;
	
	@FindBy(xpath = "(//td[@class='text-center text-nowrap'])[3]/button")
	private WebElement btnEdit;
	
	@FindBy(xpath = "(//td[@class=' select-checkbox']/input)[1]")
	private WebElement checkbox;
	
	@FindBy(id = "btnDeletePublicHlday")
	private WebElement btnDeletePublicHlday;
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	
//	Public Holiday created successfully
	@FindBy(xpath = "//div[text()='Public Holiday created successfully']")
	private WebElement notificationCreatePopup;
	
	@FindBy(xpath = "//div[text()='Public Holiday updated successfully']")
	private WebElement notificationUpdatePopup;
	
	@FindBy(xpath = "//div[text()='Deleted Selected Public Holiday Data.']")
	private WebElement notificationDeletePopup;
	
	
	public SystemDefinationPublicHolidayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
		this.excelUtility= new ExcelUtilities();
		this.webUtility= new WebUtilities();
	}
	
	public void setBtnAddNew() {
		btnAddNew.click();
	}
	
	public void setTxtHolidayName(String holidayName) {
		txtHolidayName.clear();
		txtHolidayName.sendKeys(holidayName);
	}
	public void setTxtHolidayDate(String holidayDate) {
		txtHolidayDate.clear();
		txtHolidayDate.sendKeys(holidayDate);
		txtHolidayDate.sendKeys(Keys.ENTER);
	}
	
	public void setChkIsPaid() throws InterruptedException {
//		Thread.sleep(500);
		chkIsPaid.click();
	}
	
	public void setTxtHolidayNote(String holidayNote) {
		txtHolidayNote.clear();
		txtHolidayNote.sendKeys(holidayNote);
	}
	
	public void setBtnSavePublicHldayDeatils() {
		btnSavePublicHldayDeatils.click();
	}
	
	public void setBtnEdit() {
		action.moveToElement(btnEdit).perform();
		btnEdit.click();
	}
	public void setCreateNotificationPopup() {
		webUtility.moveToElement(driver, notificationCreatePopup);
		notificationCreatePopup.click();
	}
	public void setUpdateNotificationPopup() {
		webUtility.moveToElement(driver, notificationUpdatePopup);
		notificationUpdatePopup.click();
	}
	public void setDeleteNotificationPopup() {
		webUtility.moveToElement(driver, notificationDeletePopup);
		notificationDeletePopup.click();
	}
	public void setCheckbox() {
		checkbox.click();
	}
	
	public void setBtnDeletePublicHlday() {
		action.moveToElement(btnDeletePublicHlday).perform();
		btnDeletePublicHlday.click();
	}
	public void setBtnYes() {
		btnYes.click();
	}
	public void setCreatePublicHoliday() throws Exception {
		sdph= new SystemDefinationPublicHolidayPage(driver);
		timeStamp = LocalDateTime.now().toString();

		holidayName = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 7);
		holidayDate = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 8);
		holidayNote = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 9);

		sdph.setBtnAddNew();
		Thread.sleep(2000);
		sdph.setTxtHolidayName(holidayName+ " "+ timeStamp);
		sdph.setTxtHolidayDate(holidayDate + " "+ timeStamp);
		sdph.setTxtHolidayNote(holidayNote+ " "+ timeStamp);
		sdph.setBtnSavePublicHldayDeatils();
		sdph.setCreateNotificationPopup();
	}
	
	public void setUpdatePublicHoliday() throws Exception {
		sdph= new SystemDefinationPublicHolidayPage(driver);
		timeStamp = LocalDateTime.now().toString();

		holidayName = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 7);
		holidayDate = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 8);
		holidayNote = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 9);
		Thread.sleep(2000);
		sdph.setBtnEdit();
		sdph.setTxtHolidayName(holidayName + " "+ timeStamp);
		sdph.setTxtHolidayDate(holidayDate + " "+ timeStamp );
		sdph.setChkIsPaid();
		sdph.setTxtHolidayNote(holidayNote + " "+ timeStamp);
		sdph.setBtnSavePublicHldayDeatils();
		sdph.setUpdateNotificationPopup();
	}
	
	public void setDeactivatePH() throws InterruptedException {
		sdph= new SystemDefinationPublicHolidayPage(driver);
		
		sdph.setBtnEdit();
		sdph.setChkIsPaid();
		sdph.setBtnSavePublicHldayDeatils();
		Thread.sleep(5000);
		sdph.setCheckbox();
		sdph.setBtnDeletePublicHlday();
		sdph.setBtnYes();
		sdph.setDeleteNotificationPopup();
	}
}
