package com.AutomationJiviewsPOM;

import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class SystemDefinationShiftBandPage  extends BaseClass{
	String timeStamp = LocalDateTime.now().toString();
	Actions action= new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SystemDefinationShiftBandPage sb;
	
	@FindBy(id = "btnAddNew")
	private WebElement addBtn;
	
	@FindBy(id = "txtShtBandName")
	private WebElement shiftBandNameTxt;
	
	@FindBy (id = "txtShiftbandDesc")
	private WebElement descriptionTxt;
	
	@FindBy(id = "txtShiftBandCode")
	private WebElement bandCodeTxt;
	
	@FindBy(id = "select2-cmbShiftBandId-container")
	private WebElement shiftBandTypeTxt;
	
	@FindBy(className  ="select2-search__field")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//li[text()='Normal Shift']")
	private WebElement shiftType;
	
	@FindBy(className = "select2-search__field")
	private WebElement searchBox;
	
	// inside searchbox we have to select one shift type
	@FindBy(xpath = "//li[text()='Normal Shift']") 
	private WebElement shiftTypeSearch;
	
	@FindBy(xpath = "//input[@id='txtStartTime']")
	private WebElement startTime;
	
	@FindBy(xpath = "//li[text()='07:00']")
	private WebElement selectStartTime;
	
	@FindBy(xpath = "//input[@id='txtEndTime']")
	private WebElement endTime;
	
	@FindBy(xpath = "(//li[text()='19:00'])[2]")
	private WebElement selectEndTime;
	
	
	@FindBy(xpath = "//input[@id='txtStartRangeBegin']")
	private WebElement startRangeBegin;
	
	@FindBy(xpath = "//input[@id='txtStartRangeEnd']")
	private WebElement startRangeEnd;	
	
	
	@FindBy(xpath = "//input[@name='endRangeBegin']")
	private WebElement endRangeBegin;
	
	@FindBy(xpath = "//input[@name='endRangeEnd']")
	private WebElement endRangeEnd;
	
	@FindBy(id = "btnSaveshiftbandDtls")
	WebElement btnSaveshiftbandDtls;
	
	public SystemDefinationShiftBandPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setAddBtn() {
		addBtn.click();
	}
	
	public void setShiftBandName() {
		shiftBandNameTxt.sendKeys("Day Shift");
	}
	public void setDescriptionTxt() {
		descriptionTxt.sendKeys("Day Shift");
	}
	public void setBandCodeTxt() {
		bandCodeTxt.sendKeys("1st Shift");
	}
	public void setShiftBandTypeTxt() {
		shiftBandTypeTxt.click();
	}
	public void setSearchBox() {
		action.moveToElement(searchBox).perform();
	}
	public void setShiftTypeSearch() {
		action.moveToElement(shiftTypeSearch).perform();
		shiftTypeSearch.click();
	}
	public void setStartTime() {
		action.moveToElement(startTime).perform();
		startTime.clear();
	}
	
	public void setSelectStartTime() {
		
		js.executeScript("arguments[0].scrollIntoView(true);",selectStartTime);
		selectStartTime.click();
	}
	
	public void setEndTime() {
		action.moveToElement(endTime).perform();
		endTime.clear();
	}
	
	public void setSelectEndTime() {
		js.executeScript("arguments[0].scrollIntoView(true);",selectEndTime);
		selectEndTime.click();
	}
	
	public void setStartRangeBegin() {
		action.moveToElement(startRangeBegin).perform();
		startRangeBegin.clear();
		startRangeBegin.sendKeys("6:59");
		startRangeBegin.click();
	}
	public void setStartRangeEnd() {
		action.moveToElement(startRangeEnd).perform();
		startRangeEnd.clear();
		startRangeEnd.sendKeys("6:59");
		startRangeEnd.click();
	}
	
	public void setEndRangeBegin() {
		action.moveToElement(endRangeBegin).perform();
		endRangeBegin.clear();
		endRangeBegin.sendKeys("6:59");
		endRangeBegin.click();
	}
	public void setEndRangeEnd() {
		action.moveToElement(endRangeEnd).perform();
		endRangeEnd.clear();
		endRangeEnd.sendKeys("10:01");
		endRangeEnd.click();
	}
	
	public void setBtnSaveshiftbandDtls() {
		btnSaveshiftbandDtls.click();
	}
	public void createShiftBandDefinition() {
		sb= new SystemDefinationShiftBandPage(driver);
		sb.setAddBtn();
		sb.setShiftBandName();
		sb.setDescriptionTxt();
		sb.setBandCodeTxt();
		sb.setShiftBandTypeTxt();
		sb.setSearchBox();
		sb.setShiftTypeSearch();
		sb.setStartTime();
		sb.setSelectStartTime();
		sb.setEndTime();
		sb.setSelectEndTime();
		sb.setStartRangeBegin();
		sb.setStartRangeEnd();
		sb.setEndRangeBegin();
		sb.setEndRangeEnd();
		sb.setBtnSaveshiftbandDtls();
	}
}
