package com.jivi.auto.pageobjectutils;

import java.awt.Robot;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jivi.auto.reusablecomponents.Browser;

/**
 * 
 * @author Automation Team
 */

public class MouseHandler extends POMCommon {
	public WebDriver driver;
	WebElement mouseObject, mouseChildObject;
	Actions mouseAction;

	public void clickUsingActionsMethod(WebElement locator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		mouseAction = new Actions(driver);
		mouseObject = getObject(locator);
		mouseAction.click(mouseObject).perform();

	}

	public void hoverElement(WebElement parentLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).build().perform();
	}

	public void hoverAndClick(WebElement parentLocator, WebElement childLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		WebElement parent = getObject(parentLocator);
		mouseAction = new Actions(driver);
		mouseAction.moveToElement(parent).build().perform();
		mouseAction.moveToElement(getObject(childLocator)).click().perform();
	}

	public void hoverAndClick(WebElement parentLocator, WebElement childLocator, WebElement subChildLocator)
			throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).build().perform();
		mouseAction.moveToElement(getObject(childLocator)).build().perform();
		mouseAction.moveToElement(getObject(subChildLocator)).click().perform();
	}

	public void setTextUsingAction(WebElement parentLocator, String textToBeSet) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).doubleClick().sendKeys(textToBeSet).perform();
	}

	public void doubleClick(WebElement parentLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).doubleClick().perform();
	}

	public void doubleClick(WebElement parentLocator, WebElement childLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).moveToElement(getObject(childLocator)).doubleClick().build()
				.perform();
	}

	public void doubleClick(WebElement parentLocator, WebElement childLocator, WebElement subChildLocator)
			throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).moveToElement(getObject(childLocator))
				.moveToElement(getObject(subChildLocator)).doubleClick().build().perform();
	}

	public void clickAndHold(WebElement parentLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.clickAndHold(mouseObject).build().perform();
	}

	public void release(WebElement parentLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.release(mouseObject).build().perform();
	}

	public void dragAndDrop(WebElement sourceLocator, WebElement destinationLocator) throws Exception {
		driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(sourceLocator);
		mouseChildObject = getObject(destinationLocator);
		mouseAction.dragAndDrop(mouseObject, mouseChildObject).build().perform();
	}

	public void moveMousePointerToElement(WebElement parentLocator, WebElement childLocator) throws Exception {
		Point coordinates = getObject(parentLocator).getLocation();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.mouseMove(coordinates.x, coordinates.y + 80);
		getObject(childLocator).click();
	}

	public void moveMousePointerToElement(WebElement parentLocator, WebElement childLocator, WebElement subChildLocator)
			throws Exception {

		Point coordinates = getObject(parentLocator).getLocation();
		Robot robot = new Robot();
		robot.mouseMove(coordinates.x, coordinates.y + 80);
		Thread.sleep(2000);
		getObject(childLocator).click();
		Thread.sleep(2000);
		getObject(subChildLocator).click();
	}
}
