package com.jivi.auto.reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FrameHandler extends Common {

	public void switchToFrame(int frameNumber) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().frame(frameNumber);
	}

	public void switchToFrame(String frameText) throws InterruptedException {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().frame(frameText);
	}

	public void switchToFrame(WebElement element) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().frame(element);
	}

	public void switchToDefaultFrame() {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
	}

	public void switchToNestedFrame(int parentFrame, int childFrame) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(parentFrame).switchTo().frame(childFrame);
	}

	public void switchToNestedFrame(String parentFrame, String childFrame) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(parentFrame);
		driver.switchTo().frame(childFrame);
	}

	public void switchToNestedFrame(WebElement parentFrame, WebElement childFrame) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(parentFrame).switchTo().frame(childFrame);
	}
}
