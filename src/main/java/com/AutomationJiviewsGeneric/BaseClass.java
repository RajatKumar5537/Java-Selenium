package com.AutomationJiviewsGeneric;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	//	static {
	//		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe"); 
	//	}
	static {
		System.setProperty("webdriver.chrome.driver","./driver/IEDriverServer.exe"); //IEDriverServer.exe
	}
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException{
		Reporter.log("Open Browser", true);
		logger.info("Open Browser");

		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();

		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*"); // allowing to open chrome in Azure
		option.addArguments("start-maximized"); // open Browser in maximized mode
		option.addArguments("disable-infobars"); // disabling infobars
		option.addArguments("--disable-extensions"); // disabling extensions
		option.addArguments("--disable-gpu"); // applicable to windows os only
		option.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		option.addArguments("--no-sandbox"); // Bypass OS security model


		// Check the execution environment (e.g., using an environment variable)
		String executionEnvironment = System.getenv("EXECUTION_ENVIRONMENT");

		if (executionEnvironment != null && executionEnvironment.equalsIgnoreCase("azure")) {
			// Running in Azure, enable headless mode
			option.addArguments("--headless");
		}
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Browser launched successfully");

		Reporter.log("Open Browser", true);
		logger.info("Open Browser");

		/*   WebDriverManager.firefoxdriver().setup();
	    FirefoxOptions options = new FirefoxOptions();
	    driver = new FirefoxDriver(options);
	    String executionEnvironment = System.getenv("EXECUTION_ENVIRONMENT");

	    if (executionEnvironment != null && executionEnvironment.equalsIgnoreCase("azure")) {
	        // Running in Azure, enable headless mode
	        options.addArguments("--headless");
	        // Add other Azure-specific options here
	    }



	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    logger.info("Firefox Browser launched successfully");
		 */

	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Reporter.log("Close Browser",true);
		driver.quit();
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		Reporter.log("Login", true);
		FileLib fileLib= new FileLib();
		String url = fileLib.getPropertyData("url");
		String un = fileLib.getPropertyData("username");
		String pw = fileLib.getPropertyData("password");
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
