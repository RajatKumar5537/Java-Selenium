package com.AutomationJiviewsGeneric;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.AutomationJiviewsPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{

	private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException{
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
		// Launch ChromeDriver with the configured ChromeOptions
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Browser launched successfully");

	}

	@BeforeClass
	public void beforeTestMethod() throws IOException, InterruptedException {
		System.out.println("Login to the Application");
		String url = ReusableComponent.readPropertyData("url", "./Configure/jiviLoginCredential.properties");
		String un  = ReusableComponent.readPropertyData("username", "./Configure/jiviLoginCredential.properties");
		String pwd = ReusableComponent.readPropertyData("password", "./Configure/jiviLoginCredential.properties");
		
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLogin(un, pwd);
	}
	@AfterClass
	public void afterTestMethod() {
		System.out.println("Logout from the Application");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		logger.info("Close Browser...");
		driver.quit();
	}

	

}
