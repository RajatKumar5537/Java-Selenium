package com.jivi.auto.reusablecomponents;

import java.awt.Robot;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MouseHandler extends Common {

	WebElement mouseObject, mouseChildObject, mouseSubChildObject;
	Actions mouseAction;

	public void clickUsingActionsMethod(WebElement locator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		mouseAction = new Actions(driver);
	//	mouseObject = getObject(locator);
		mouseAction.click().perform();
	}

	public void hoverAndClick(String parentLocator, String childLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		WebElement parent = getObject(parentLocator);

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(parent).perform();

		mouseAction.moveToElement(getObject(childLocator)).click().build().perform();
	}

	public void hoverAndClick(String parentLocator, String childLocator, String subChildLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).build().perform();
		mouseAction.moveToElement(getObject(childLocator)).build().perform();
		mouseAction.moveToElement(getObject(subChildLocator)).click().perform();
	}

	public void doubleClick(String parentLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).doubleClick().build().perform();
	}

	public void setTextUsingAction(String parentLocator, String textToBeSet) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).sendKeys(textToBeSet).build().perform();
	}

	public void doubleClick(String parentLocator, String childLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).build().perform();
		mouseAction.moveToElement(getObject(childLocator)).doubleClick().perform();
	}

	public void doubleClick(String parentLocator, String childLocator, String subChildLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).moveToElement(getObject(childLocator))
				.moveToElement(getObject(subChildLocator)).doubleClick().build().perform();
	}

	public void dragAndDrop(String sourcetLocator, String destinationLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(sourcetLocator);
		mouseChildObject = getObject(destinationLocator);
		mouseAction.dragAndDrop(mouseObject, mouseChildObject).build().perform();
	}

	public void clickAndHold(String parentLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.clickAndHold(mouseObject).build().perform();
	}

	public void release(String parentLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.release(mouseObject).build().perform();
	}

	public void moveMousePointerToElement(String parentLocator, String childLocator, String subChildLocator)
			throws Exception {

		Point coordinates = getObject(parentLocator).getLocation();
		Robot robot = new Robot();
		robot.mouseMove(coordinates.x, coordinates.y + 80);
		Thread.sleep(2000);
		getObject(childLocator).click();
		Thread.sleep(2000);
		getObject(subChildLocator).click();
	}

	public void moveMousePointerToElement(String parentLocator, String childLocator) throws Exception {
		Point coordinates = getObject(parentLocator).getLocation();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.mouseMove(coordinates.x, coordinates.y + 80);
		getObject(childLocator).click();
	}

	public void hoverElement(String parentLocator) throws Exception {
		Browser browser = new Browser();
		WebDriver driver = browser.getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).build().perform();
	}

	/**
	 * � @deprecated relese method �� �
	 */
	@Deprecated
	public void relese(String parentLocator, String chileLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseChildObject = getObject(chileLocator);
		mouseAction.moveToElement(mouseObject).release(mouseChildObject).build().perform();
	}

	/**
	 * �* Deprecated HoverOverElement method. �* �* @deprecated use
	 * {@link #hoverElement()} instead.�� �
	 */
	@Deprecated
	public void HoverOverElement(String parentLocator) throws Exception {
		Browser browser = new Browser();
		WebDriver driver = browser.getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.moveToElement(mouseObject).build().perform();
	}

	/**
	 * �*Deprecated relese method. �* �* @deprecated use {@link #release()}
	 * instead.�� �
	 */
	@Deprecated
	public void relese(String parentLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseAction.release(mouseObject).build().perform();
	}

	/**
	 * �Deprecated click �* @deprecated use {@link #hoverAndClick(,,)} instead.�� �
	 */
	@Deprecated
	public void click(String parentLocator, String childLocator, String subChildLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).build().perform();
		mouseAction.moveToElement(getObject(childLocator)).build().perform();
		mouseAction.moveToElement(getObject(subChildLocator)).click().perform();
	}

	/**
	 * � @deprecated clickAndHold method �� �
	 */
	@Deprecated
	public void clickAndHold(String parentLocator, String childLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseObject = getObject(parentLocator);
		mouseChildObject = getObject(childLocator);
		mouseAction.moveToElement(mouseObject).clickAndHold(mouseChildObject).build().perform();
	}

	/**
	 * �Deprecated click1 method�* @deprecated use {@link #hoverAndClick()}
	 * instead.�� �
	 */
	@Deprecated
	public void click1(String parentLocator, String childLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).click().build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mouseAction.moveToElement(getObject(childLocator)).click().build().perform();
	}

	/**
	 * @Deprecated�click method � �
	 */
	@Deprecated
	public void click(String parentLocator, String childLocator) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();

		mouseAction = new Actions(driver);
		mouseAction.moveToElement(getObject(parentLocator)).moveToElement(getObject(childLocator)).click().build()
				.perform();
	}
}
