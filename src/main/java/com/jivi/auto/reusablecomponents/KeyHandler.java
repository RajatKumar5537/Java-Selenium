package com.jivi.auto.reusablecomponents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class KeyHandler extends Common {
	public WebElement keyObject;

	public void pressKey(String locator, Keys Key) throws Exception {
		keyObject = getObject(locator);
		keyObject.sendKeys(Key);
	}
}
