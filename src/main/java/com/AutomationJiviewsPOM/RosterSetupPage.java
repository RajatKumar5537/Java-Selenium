package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class RosterSetupPage extends BaseClass{
	
//	RosterSetupPage rsp= new RosterSetupPage(driver);

	@FindBy(xpath = "//div[text()='Roster Setup']/..")
	private WebElement RoasterSetup;
	
	@FindBy(xpath = "//div[text()='Shift Band Definition']/..")
	private WebElement shiftBandDefination;
	
	public RosterSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setRoasterSetup() {
		RoasterSetup.click();
	}
	
	public void setShiftBandDefination() {
		shiftBandDefination.click();
	}
	
	public void setCreateRoasterShiftBand() throws InterruptedException {
		RoasterSetup.click();
		Thread.sleep(2000);
		shiftBandDefination.click();
	}
}
