package com.jivi.auto.reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandler extends Common {

	public void alertAccept() {
		WebDriver driver = Browser.getInstance().getDriver();
		try {
			
			
			wait = new WebDriverWait(driver,Duration.ofSeconds(30));
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
			
			
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));;
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alerttext = alert.getText();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
		return alerttext;
	}

	public void SetPopoupText(String text) {
		WebDriver driver = Browser.getInstance().getDriver();
		try {
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));;
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
	}

}
