package com.practice;

import java.awt.AWTException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.JiviewsAutomation.SystemDefination_Test.skillSetUpTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AzurePractice { 

	private static final Logger logger = LogManager.getLogger(AzurePractice.class);

	/*@Test(invocationCount = 3)
	public void createSkill() {
		logger.info("Create a new Skill");

		Reporter.log("Create a new Skill...!",true);
	}
	@Test(invocationCount = 2)
	public void modifySkill() {
		logger.info("Modify Skill");
		Reporter.log("Modify a existing Skill...!",true);
	}
	@Test(invocationCount = 2)
	public void deleteSkill() {
		logger.info("Deactivate Skill");
		Reporter.log("Deactivate a Skill....!",true);
	}
	@Test(invocationCount = 1)
	public void reactiveSkill() {
		logger.info("Reactive Skill");
		Reporter.log("Deactivate a Skill....!",true);
	}
	@Test(invocationCount = 3)
	public void searchSkill() {
		logger.info("Search a Skill");
		Reporter.log("Search a Skill....!",true);
	}*/

//	@Test
//	public void practice() throws InterruptedException, AWTException {
//		//			FirefoxOptions options = new FirefoxOptions();
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option=new ChromeOptions();
//		WebDriver d = new ChromeDriver(option);
//
//		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		d.get("https://www.jiviews.com/DEMO/");
//
//		// Wait for the username field to be visible
//		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//
//		d.findElement(By.name("username")).sendKeys("admin");
//		d.findElement(By.name("password")).sendKeys("JiViews2.0");
//		d.findElement(By.id("btnSignIn")).click();




//	}
}
