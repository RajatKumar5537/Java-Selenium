package com.AutomationJiviewsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class HomePage extends BaseClass{
	Actions action;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement admin;

	@FindBy(xpath = "//a[@id='btnLogout']")
	private WebElement Logout;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	private WebElement OrgUnit;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setOrgUnit() throws InterruptedException {

//		Actions a=new Actions(driver);
//		a.moveToElement(OrgUnit).perform();
		Thread.sleep(5000);
		OrgUnit.click();
	}	

	public void setAdmin() throws InterruptedException {
		Thread.sleep(2000);
		action= new Actions(driver);
		action.moveToElement(admin).perform();
		admin.click();
	}
	public void setLogout() throws InterruptedException {
		Thread.sleep(2000);
		action= new Actions(driver);
		action.moveToElement(Logout).perform();
		Logout.click();
	}
}
