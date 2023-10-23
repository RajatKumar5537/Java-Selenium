package com.jivi.auto.pageobjectutils;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;

import com.jivi.auto.reusablecomponents.Browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementKeys extends POMCommon {
	private WebElement webObject;

	public void setText(WebElement locator, String valueToBeEntered) throws Exception {
		getObject(locator).clear();
		getObject(locator).sendKeys(valueToBeEntered);
	}

	public void setValueUsingJavaScript(WebElement locator, String valueToBeSet) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		webObject = getObject(locator);
		jse.executeScript("arguments[0].value='" + valueToBeSet + "';", webObject);
	}

	public void setSecureText(WebElement locator, String valueToBeEntered) throws Exception {
		webObject = getObject(locator);
		webObject.clear();
		webObject.sendKeys(decode(valueToBeEntered));

	}

	public String getText(WebElement locator) throws Exception {

		webObject = getObject(locator);
		String buttonText = webObject.getText();
		return buttonText;
	}

	public String getAttributeValue(WebElement locator, String attributeType) throws Exception {

		webObject = getObject(locator);
		return webObject.getAttribute(attributeType).trim();

	}

	public void clearText(WebElement locator) throws Exception {
		webObject = getObject(locator);
		webObject.clear();

	}

	public void click(WebElement locator) throws Exception {

		webObject = getObject(locator);
		webObject.click();

	}

	public void clickUsingJavaScript(WebElement locator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		webObject = getObject(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webObject);
	}

	public void selectCheckBox(WebElement locator) throws Exception {

		webObject = getObject(locator);
		if (!webObject.isSelected()) {
			webObject.click();
		}
	}

	public void unSelectCheckBox(WebElement locator) throws Exception {

		webObject = getObject(locator);
		if (webObject.isSelected()) {
			webObject.click();
		}
	}

	public void validateText(WebElement locator, String textToBeVerified) throws Exception {

		webObject = getObject(locator);
		String actualLinkText = webObject.getText().trim();
		String expLinkText = textToBeVerified.trim();
		Assert.assertEquals(expLinkText, actualLinkText);

	}

	public boolean verifyText(WebElement locator, String expectedText) throws Exception {

		webObject = getObject(locator);
		String actualLinkText = webObject.getText().trim();
		String expLinkText = expectedText.trim();
		return expLinkText.equalsIgnoreCase(actualLinkText);
	}

	public boolean verifyAttributeValue(WebElement locator, String attributeType, String expectedValue)
			throws Exception {
		boolean result;
		String actualLinkText = getAttributeValue(locator, attributeType);
		result = expectedValue.trim().equalsIgnoreCase(actualLinkText);
		return result;
	}

	public void pressKey(WebElement locator, Keys Key) throws Exception {
		webObject = getObject(locator);
		webObject.sendKeys(Key);
	}

	public static String decode(String strEncodedString) {
		String strActualString = null;
		try {
			strActualString = new String(Base64.decodeBase64(strEncodedString.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strActualString;
	}

}
