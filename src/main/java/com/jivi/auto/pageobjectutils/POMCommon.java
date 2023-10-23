package com.jivi.auto.pageobjectutils;

import java.time.Duration;

//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.jivi.auto.reusablecomponents.Browser;
import com.jivi.auto.reusablecomponents.GlobalVariables;

/**
 * 
 * @author Automation Team
 */

public class POMCommon extends GlobalVariables {

	public WebElement webObject,webReferenceObject;
	public WebDriverWait wait;
	public WebElement locator;

	public WebElement getObject(WebElement locator) throws InterruptedException {

		waitUntilElementIsVisible(locator);
		waitUntilElementIsClickable(locator);
		highlightElement(locator);
		return locator;
	}

	public void waitUntilElementIsVisible(WebElement locator) {

		WebDriver driver = Browser.getInstance().getDriver();

		//wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
			//	GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		//hard coded
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public void waitUntilElementIsClickable(WebElement locator) {

		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		/*
		 * wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get(
		 * "ExplicitWait").substring(0,
		 * GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		 */
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
	
	public boolean isObjectDisplayedAndEnabled(WebElement locator) throws Exception {
		webObject = getObject(locator);
		boolean isEnabled = webObject.isEnabled();
		boolean isDisplayed = webObject.isDisplayed();

		Assert.assertTrue(isEnabled);
		Assert.assertTrue(isDisplayed);
		return true;
	}

	public void waitForPageLoad(int timeoutLimit) {

		WebDriver driver = Browser.getInstance().getDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutLimit));
	}

	public void waitForPageReadyState(int timeoutLimit) {
		WebDriver driver = Browser.getInstance().getDriver();
		new WebDriverWait(driver, Duration.ofSeconds(timeoutLimit))
				.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) wdriver)
						.executeScript("return document.readyState").equals("complete"));
	}

	public void alertAccept() {
		WebDriver driver = Browser.getInstance().getDriver();
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			
			/*
			 * wait = new WebDriverWait(driver,
			 * Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get(
			 * "ExplicitWait").substring(0,
			 * GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
			 */
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception Ex) {
			Ex.printStackTrace();

		}
	}

	public void alertDismiss() {
		WebDriver driver = Browser.getInstance().getDriver();
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
					GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception Ex) {
			Ex.printStackTrace();

		}
	}

	public String alertGettext() {
		WebDriver driver = Browser.getInstance().getDriver();

		String alerttext = null;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
					GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alerttext = alert.getText();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
		return alerttext;
	}

	public void setPopupText(String text) {
		WebDriver driver = Browser.getInstance().getDriver();
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
					GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
	}

	public void scrollUp() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");

	}

	public void scrollDown() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	
	public void scrollDownLittle() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollDown300() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void scrollDown200() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	
	public void scrollIntoeEement(WebElement locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",locator);
	}

	public void scrollToPosition(int x, int y) {

		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void highlightElement(WebElement locator) {
		try {
			if (configData.get("highlight") != null) {

				if (configData.get("highlight").equalsIgnoreCase("Yes")) {
					WebDriver driver = Browser.getInstance().getDriver();
					String jsarg = "arguments[0].setAttribute('style', 'border: 4px solid yellow;');";

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(jsarg, locator);
					Thread.sleep(1000);
					// Disable Highlight
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", locator, "");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public By getLocatorElement(String locator, String locatorValue) {
		switch (locator) {
		case "Id":
			return By.id(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "classname":
			return By.className(locatorValue);
		case "linktext":
			return By.linkText(locatorValue);
		case "partialLinkText":
			return By.partialLinkText(locatorValue);
		case "tagname":
			return By.tagName(locatorValue);
		}
		return null;
	}
}
