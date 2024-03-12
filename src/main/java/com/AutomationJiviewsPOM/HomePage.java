package com.AutomationJiviewsPOM;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.WebUtilities;

public class HomePage {
	WebDriver driver ;
	Actions action;
	WebUtilities webUtility;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement admin;

	@FindBy(xpath = "//a[@id='btnLogout']")
	private WebElement Logout;

//	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	@FindBy(xpath = "//div[@id='layout-navbar-collapse']/div/div[@id='dvOrgUnitDropdown']/a")
	private WebElement OrgUnit;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver ;
		this.webUtility= new WebUtilities(driver);
	}



	public void setOrgUnit() throws Exception {
		webUtility.ElementClickable(driver, OrgUnit);
		Thread.sleep(2000);
		OrgUnit.click();
	}	
	public void setAdmin() throws InterruptedException {
		webUtility.moveToElement(driver, admin);
		admin.click();
	}

	public void setLogout() throws InterruptedException {
		Thread.sleep(3000);
		Logout.click();
	}
	
	public void clickOnBtnLogout() throws InterruptedException {
		setAdmin();
		setLogout();
	}
}
