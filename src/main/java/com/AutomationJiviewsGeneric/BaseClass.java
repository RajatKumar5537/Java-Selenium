package com.AutomationJiviewsGeneric;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException{
		Reporter.log("Open Browser", true);
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		
		option.addArguments("--disable-notifications");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Reporter.log("Close Browser",true);
		driver.quit();
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		Reporter.log("Login", true);
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(un, pw);
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("Logout", true);
		HomePage hp=new HomePage(driver);
		hp.setAdmin();
		Thread.sleep(2000);
		hp.setLogout();


	}
}