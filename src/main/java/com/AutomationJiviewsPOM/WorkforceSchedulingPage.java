package com.AutomationJiviewsPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationJiviewsGeneric.BaseClass;

public class WorkforceSchedulingPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Scheduling']/..")
	private WebElement Scheduling;
	@FindBy(xpath = "//div[text()='Employee Roster V2']/..")
	private WebElement EmployeeRosterV2;

	public WorkforceSchedulingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickScheduling() {
		Scheduling.click();
	}
	public void clickEmployeeRosterV2() {
		EmployeeRosterV2.click();
	}


	public void setEmployeeRosterV2() throws InterruptedException {
		//		clickScheduling();
		//		clickEmployeeRosterV2();
		Scheduling.click();
		EmployeeRosterV2.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			// Click on Scheduling
			wait.until(ExpectedConditions.elementToBeClickable(Scheduling)).click();
			// Click on EmployeeRosterV2
			wait.until(ExpectedConditions.elementToBeClickable(EmployeeRosterV2)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
