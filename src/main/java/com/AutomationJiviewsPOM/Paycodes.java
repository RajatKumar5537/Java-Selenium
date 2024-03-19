package com.AutomationJiviewsPOM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Paycodes {
	@FindBy(xpath="//div[@id='dvOrgUnitDropdown']/a")
	private WebElement clickOnAutoOu;
	
	@FindBy(xpath="//ul[@class='list-group']/li")
	private List<WebElement> selectAutoOu;
	
	@FindBy(xpath="//div[@id='dvApplicationMenuItems']/a")
	private WebElement clickOnSystemSetup;
	
	@FindBy(xpath="//div[@id='dvJiViewsMenuItems']/a")
	private List<WebElement> selectSystemSetup;
	
	

}
