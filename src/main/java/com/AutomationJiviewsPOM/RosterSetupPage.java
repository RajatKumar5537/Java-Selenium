package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

public class RosterSetupPage {
	
	WebDriver driver ;
	WebUtilities webUtility;
//	RosterSetupPage rsp= new RosterSetupPage(driver);

	@FindBy(xpath = "//div[text()='Roster Setup']/..")
	private WebElement RoasterSetup;
	
	@FindBy(xpath = "//div[text()='Shift Band Definition']/..")
	private WebElement shiftBandDefination;
	
	@FindBy(xpath = "//div[text()='Roster Creation']/..")
	private WebElement rosterCreation;
	
	
	@FindBy(xpath = "//div[text()='Public Holiday']/..")
	private WebElement pubicHoliday;
	
	@FindBy(xpath = "//div[text()='Schedule Creation Rules']/..")
	private WebElement scheduleCreationRules;
	
	public RosterSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webUtility= new WebUtilities(driver);
	}
	
	
	
	public void setRoasterSetup() {
		RoasterSetup.click();
	}
	
	public void setShiftBandDefination() {
		webUtility.ElementClickable(driver, shiftBandDefination);
		shiftBandDefination.click();
	}
	
	public void setCreateRoasterShiftBand() throws InterruptedException {
		Thread.sleep(2000);
		RoasterSetup.click();
		Thread.sleep(2000);
		shiftBandDefination.click();
	}
	
	public void setRosterCreation() throws InterruptedException {
		RoasterSetup.click();
		Thread.sleep(1000);
		rosterCreation.click();
	}
	
	public void setPubicHoliday() throws InterruptedException {
		Thread.sleep(2000);
		RoasterSetup.click();
		Thread.sleep(2000);
		pubicHoliday.click();
	}
	public void setScheduleCreationRules() throws InterruptedException {
		RoasterSetup.click();
		Thread.sleep(2000);
		scheduleCreationRules.click();
		
	}
}
