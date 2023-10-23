package com.jivi.auto.pageobjectutils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.jivi.auto.reusablecomponents.Browser;


public class FrameWindowHandler extends POMCommon {
    public WebDriver driver;

    public void switchToFrame(int frameNumber) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameNumber);
    }

    public void switchToFrame(String frameText) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameText);
    }

    public void switchToFrame(WebElement element) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(element);
    }

    public void switchToDefaultFrame() {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
    }

    public void switchToNestedFrame(int parentFrame, int childFrame) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(parentFrame).switchTo().frame(childFrame);
    }

    public void switchToNestedFrame(String parentFrame, String childFrame) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(parentFrame).switchTo().frame(childFrame);
    }

    public void switchToNestedFrame(WebElement parentFrame, WebElement childFrame) {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(parentFrame).switchTo().frame(childFrame);
    }

    // The following method will get the current window handle
    public String getMainWindowHandle() {
        driver = Browser.getInstance().getDriver();
        String windowTitle = driver.getWindowHandle();
        return windowTitle;
    }

    // This keyword is used will keep the main window open and close all the other
    // browser windows.
    public void closeAllOtherWindows() {
        driver = Browser.getInstance().getDriver();
        String CurrentwindowHandle = getMainWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String CW : allWindows) {
            if (!(CW.equals(CurrentwindowHandle))) {
                driver.switchTo().window(CW);
                driver.close();
            }
        }
        driver.switchTo().window(CurrentwindowHandle);
    }

    public void switchToNewWindow() {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchToNewTab() {
        driver = Browser.getInstance().getDriver();
        driver.switchTo().newWindow(WindowType.TAB);
    }
}
