package com.jivi.auto.pageobjectutils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDown extends POMCommon {
	private WebElement drpObject;

	// Do not use this method getAlloptionsFromDropDown for getting all the values
	// from the dropdown
	public Select getAlloptionsFromDropDown(WebElement locator) throws Exception {
		drpObject = getObject(locator);
		Select allDropdownOptions = new Select(drpObject);
		return allDropdownOptions;
	}

	public void selectByvisibleText(WebElement locator, String text) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement locator, int index) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement locator, String value) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.selectByValue(value);
	}

	public void deSelectByVisibleText(WebElement locator, String text) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.deselectByVisibleText(text);
	}

	public void deSelectByIndex(WebElement locator, int index) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.deselectByIndex(index);
	}

	public void deSelectByValue(WebElement locator, String value) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.deselectByValue(value);
	}

	public WebElement getFirstSelectedOption(WebElement locator) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		return select.getFirstSelectedOption();
	}

	public List<WebElement> getAllSelectedOptions(WebElement locator) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		return select.getAllSelectedOptions();
	}

	public void deSelectAll(WebElement locator) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		select.deselectAll();
	}

	public List<WebElement> getOptions(WebElement locator) throws Exception {
		Select select = getAlloptionsFromDropDown(locator);
		return select.getOptions();
	}

}
