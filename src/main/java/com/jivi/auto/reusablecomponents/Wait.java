package com.jivi.auto.reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Wait {// extends BaseTest {

	public static WebElement webObject;
	public static WebDriverWait wait;
	// public Wait explicitwait;
	public static Common common = new Common(); // these are modifications
	// public static Browser browser = new Browser();
	public static String locatorType, locatorValue;

	public static void waitUntilElementIsVisible(String locator) {

		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		common.setLocatertypeLocatervalue(locator);// these are modifications
		locatorType = common.locatorType; // these are modifications
		locatorValue = common.locatorValue; // these are modifications
		switch (locatorType) {

		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			break;

		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			break;

		case "name":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			break;

		case "cssselector":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "LinkText":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		// the following are the new methods
		case "PartialLinkText":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		case "TagName":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			break;
		// the following are the new methods
		}

	}

	public void waitUntilElementIsClickable(String locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		common.setLocatertypeLocatervalue(locator);
		locatorType = common.locatorType;
		locatorValue = common.locatorValue;
		switch (locatorType) {

		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			break;

		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
			break;

		case "name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
			break;
		case "cssselector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
			break;
		case "LinkText":
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorValue)));
			break;
		// the following are the new methods
		case "PartialLinkText":
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locatorValue)));
			break;
		case "TagName":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locatorValue)));
			break;
		// the following are the new methods
		}

	}

	public void waitUntilElementIsPresented(String locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		common.setLocatertypeLocatervalue(locator);
		locatorType = common.locatorType;
		locatorValue = common.locatorValue;
		switch (locatorType) {

		case "xpath":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
			break;

		case "id":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
			break;

		case "name":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
			break;
		case "cssselector":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "LinkText":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
			break;
		// the following are the new methods
		case "PartialLinkText":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		case "TagName":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
			break;
		// the following are the new methods
		}
	}

	public void waitUntilElementIsNotVisible(String locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		common.setLocatertypeLocatervalue(locator);
		locatorType = common.locatorType;
		locatorValue = common.locatorValue;
		switch (locatorType) {
		case "xpath":
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath(locatorValue))));
			break;

		case "id":
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id(locatorValue))));
			break;

		case "name":
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.name(locatorValue))));
			break;
		// the following are the new methods
		case "PartialLinkText":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		case "TagName":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(locatorValue)));
			break;
		// the following are the new methods
		}
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
}