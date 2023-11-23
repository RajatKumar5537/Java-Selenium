package com.AutomationJiviewsPOM;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;

public class SystemDefinationPublicHolidayPage extends BaseClass{
	public String timeStamp = LocalDateTime.now().toString();
	public Actions action;
	public Select select;
//	public WebUtilities webUtility;
	public SystemDefinationPublicHolidayPage sdph;
//	public ExcelUtilities excelUtility;
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
	
	@FindBy(xpath = "//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1']")
	private WebElement btnEdit;
	
	@FindBy(xpath = "//table[@id='PublicHlday-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='PublicHlday-list_next']")
	private WebElement nextPage;
	
	@FindBy(xpath = "(//td[@class=' select-checkbox']/input)[1]")
	private WebElement checkbox;
	
	@FindBy(id = "btnDeletePublicHlday")
	private WebElement btnDeletePublicHlday;
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	
//	Public Holiday created successfully
	@FindBy(xpath = "//div[text()='Public Holiday created successfully']") //div[text()='Public Holiday created successfully']
	private WebElement notificationCreatePopup;
	@FindBy(xpath = "//div[text()='Public Holiday updated successfully']")
	private WebElement notificationUpdatePopup;
	@FindBy(xpath = "//div[text()='Deleted Selected Public Holiday Data.']")
	private WebElement notificationDeletePopup;
	
	
	public SystemDefinationPublicHolidayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
	}
	
	public void setBtnAddNew() {
		btnAddNew.click();
	}
	
	public void setTxtHolidayName(String holidayName) {
		txtHolidayName.clear();
		txtHolidayName.sendKeys(holidayName);
	}
	public void setTxtHolidayDate(String holidayDate) {
//	    Random random = new Random();
//	    // Generate a random date within a specific range (e.g., the last year)
//	    LocalDate startDate = LocalDate.now().minusYears(1); // Adjust the date range as needed
//	    LocalDate endDate = LocalDate.now();
//	    long startEpochDay = startDate.toEpochDay();
//	    long endEpochDay = endDate.toEpochDay();
//	    long randomEpochDay = startEpochDay + random.nextInt((int) (endEpochDay - startEpochDay + 1));
//
//	    // Convert the random epoch day back to a LocalDate
//	    LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);
//
//	    // Format the random date as a string, e.g., in "yyyy-MM-dd" format
//	    String formattedRandomDate = randomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	    // Now set the random date in your text field
	    txtHolidayDate.clear();
	    txtHolidayDate.sendKeys(holidayDate);
	    txtHolidayDate.sendKeys(Keys.ENTER);
	}
	
	public void setChkIsPaid() throws InterruptedException {
		Thread.sleep(500);
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
		String actualResult = notificationCreatePopup.getText();
		Assert.assertTrue(actualResult.contains("Public Holiday created successfully"));
		notificationCreatePopup.click();
	}
	public void setUpdateNotificationPopup() {
//		webUtility.moveToElement(driver, notificationUpdatePopup);
		String actualResult = notificationUpdatePopup.getText();
		Assert.assertTrue(actualResult.contains("Public Holiday updated successfully"));
		notificationUpdatePopup.click();
	}
	public void setDeleteNotificationPopup() {
//		webUtility.moveToElement(driver, notificationDeletePopup);
		String actualResult = notificationDeletePopup.getText();
		Assert.assertTrue(actualResult.contains("Deleted Selected Public Holiday Data."));
		notificationDeletePopup.click();
	}
	 public void performDeleteAction() throws InterruptedException {
			for (int i = 0; i < 3; i++) {
				try {
					scrollAndClick(driver, btnDeletePublicHlday);
					break; 
				} catch (ElementClickInterceptedException e) {
				}
			}
		}
		public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
			boolean checkboxFound = false;
			
			// Iterate through rows
			for (int i = 0; i < rows.size(); i++) {
				WebElement checkbox = checkboxes.get(i);
				if (checkbox.isEnabled()) {
//					scrollAndClick(driver, checkbox);
					checkbox.click();
					performDeleteAction();
					checkboxFound = true;
					break;
				}
			}

			// If no enabled checkbox found on the current page, go to the next page and try again
			if (!checkboxFound) {
				goToNextPageAndDelete();
			}
		}

		private void goToNextPageAndDelete() throws InterruptedException {
			try {
				scrollAndClick(driver, nextPage); // Click on the next page button
				scrollUp(driver);
				deleteRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page
				
			} catch (ElementClickInterceptedException e) {
				// Handle the exception if necessary
			}
		}
		// Method to perform scroll-up action
		private void scrollUp(WebDriver driver) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0, -150)"); // Adjust the scroll distance as needed
		}
		public void scrollAndClick(WebDriver driver, WebElement element) {
			WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			// Scroll to the top of the page
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
			element.click();
		}
	public void setCheckbox() {
		checkbox.click();
	}
	
//	public void setBtnDeletePublicHlday() {
//		action.moveToElement(btnDeletePublicHlday).perform();
//		btnDeletePublicHlday.click();
//	}
	public void setBtnYes() {
		btnYes.click();
	}
	public void setCreatePublicHoliday(FakeEmployee fakeEmployee) throws Exception {

//		holidayName = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 7);
//		holidayDate = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 8);
//		holidayNote = excelUtility.readDataFromExcelFile("EmployeeTest", 17, 9);

		setBtnAddNew();
		Thread.sleep(2000);
		setTxtHolidayName(fakeEmployee.getHolidayName());
		setTxtHolidayDate(fakeEmployee.getHolidayDate());
		setTxtHolidayNote(fakeEmployee.getHolidayNote());
		setBtnSavePublicHldayDeatils();
		setCreateNotificationPopup();
	}
	
	public void setUpdatePublicHoliday(FakeEmployee fakeEmployee) throws Exception {
//		timeStamp = LocalDateTime.now().toString();
//		holidayName = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 7);
//		holidayDate = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 8);
//		holidayNote = excelUtility.readDataFromExcelFile("EmployeeTest", 18, 9);
		
		Thread.sleep(2000);
		setBtnEdit();
		setTxtHolidayName(fakeEmployee.getHolidayName());
		setTxtHolidayDate(fakeEmployee.getHolidayDate());
		setChkIsPaid();
		setTxtHolidayNote(fakeEmployee.getHolidayNote());
		setBtnSavePublicHldayDeatils();
		setUpdateNotificationPopup();
	}
	
	public void setDeactivatePublicHoliday(FakeEmployee fakeEmployee) throws InterruptedException {
		
//		setBtnEdit();
//		setChkIsPaid();
//		setBtnSavePublicHldayDeatils();
//		setUpdateNotificationPopup();
//		Thread.sleep(5000);
//		setCheckbox();
//		setBtnDeletePublicHlday();
		deleteRowsWithEnabledCheckbox();
		setBtnYes();
		setDeleteNotificationPopup();
	}
}
