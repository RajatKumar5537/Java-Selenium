package com.AutomationJiviewsPOM;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

import io.netty.handler.timeout.TimeoutException;

public class OrganizationUnitDropDown extends BaseClass{
	WebUtilities webUtility;

	//	select Auto OU
	@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[2]")
	private WebElement autoOu;


	// Select OLM
	@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[7]")
	private WebElement OLMop;


	public OrganizationUnitDropDown(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webUtility= new WebUtilities(driver);
	}


	//	for Auto OU
	public void clickAutoOu() {
		autoOu.click();
	}

	public void clickOLMop() {
		webUtility.ElementClickable(driver, OLMop);
		OLMop.click();
	}
	public void setAutoOu() throws InterruptedException  {
		webUtility.ElementClickable(driver, autoOu);
		autoOu.click();	
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    try {
//	        WebElement clickableAutoOu = wait.until(ExpectedConditions.elementToBeClickable(autoOu));
//	        clickableAutoOu.click();
//	    } catch (TimeoutException e) {
//	        System.out.println("Element 'autoOu' was not clickable within the specified time.");
//	        e.printStackTrace();
//	    }
	}
}


