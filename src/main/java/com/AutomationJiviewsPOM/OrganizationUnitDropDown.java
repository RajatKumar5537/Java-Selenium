package com.AutomationJiviewsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

public class OrganizationUnitDropDown extends BaseClass{
	WebUtilities webUtility;

	//	select Auto OU
	@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[6]")
	private WebElement autoOu;


	// Select OLM
	@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[12]")
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
	}
}


