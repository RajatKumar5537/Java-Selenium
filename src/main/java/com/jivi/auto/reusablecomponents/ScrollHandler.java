package com.jivi.auto.reusablecomponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ScrollHandler extends Common {

	WebElement webObj;

	public void scrollup() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
	}

	public void scrolldown() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public void Popupscrolldown(String locator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		webObj = getObject(locator);
		js.executeScript("arguments[0].click();", webObj);
	}

}
