package com.AutomationJiviewsGeneric;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.AutomationJiviewsPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	public static WebDriver driver;
	public static WebUtilities webUtility = new WebUtilities(driver);
	public static ExcelUtilities excelUtility= new ExcelUtilities();
	public static String timeStamp = LocalDateTime.now().toString();

	@BeforeTest
	public void launchBrowser() throws InterruptedException{
		logger.info("Open Browser");

		// Setting up ChromeDriver and ChromeOptions
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
		
		webUtility.maximizeBrowser(driver);
		webUtility.pageLoadWait(driver, 10);
		logger.info("Browser launched successfully");

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
		logger.info("Close Browser...");
		driver.quit();
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		logger.info("Login to the Jivi application");

		configUtility congigUtil =new configUtility();
		String url = congigUtil.getCongigPropertyData("url");
		String un = congigUtil.getCongigPropertyData("username");
		String pw = congigUtil.getCongigPropertyData("password");
		driver.get(url);
		
		// Perform login using LoginPage methods
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(un, pw);
	}

	@AfterMethod
	public void logout() throws Exception {
		logger.info("Logout from Jivi application");

		//		HomePage hp=new HomePage(driver);
		//		Thread.sleep(2000);
		//		hp.setAdmin();
		//		Thread.sleep(2000);
		//		hp.setLogout();
	}

	// Capture screenshot on test failure for Test method and add it in Extent report  
	public void captureScreenshot(WebDriver driver, String res) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/" + res + ".png");
		FileUtils.copyFile(src, dest);
		logger.info("Screenshot captured for test failure. View it at: " + dest.getAbsolutePath());

	}

	// Add a boolean variable to track whether the user is logged in
	//	private boolean isLoggedIn = false;
	//	@BeforeClass
	//	public void beforeTestMethod() throws IOException, InterruptedException {
	//		login();
	//	}
	//	@AfterClass
	//	public void afterTestMethod() {
	//		try {
	//			logout();
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}
	//	public void login() throws IOException, InterruptedException {
	//		// Perform login only if the user is not already logged in
	//		if (!isLoggedIn) {
	//			Reporter.log("Login", true);
	//			logger.info("Login to the Jivi application");
	//
	//			configUtility configUtil = new configUtility();
	//			String url = configUtil.getCongigPropertyData("url");
	//			String un = configUtil.getCongigPropertyData("username");
	//			String pw = configUtil.getCongigPropertyData("password");
	//			driver.get(url);
	//			LoginPage lp = new LoginPage(driver);
	//			lp.setLogin(un, pw);
	//			isLoggedIn = true;
	//		}
	//	}
	//
	//	public void logout() {
	//		if (isLoggedIn) {
	//			Reporter.log("Logout", true);
	//			logger.info("Logout from Jivi application");
	//			//		HomePage hp=new HomePage(driver);
	//			//		Thread.sleep(2000);
	//			//		hp.setAdmin();
	//			//		Thread.sleep(2000);
	//			//		hp.setLogout();
	//			// Reset the isLoggedIn flag to allow logging in again in the future
	//			isLoggedIn = false;
	//		}
	//	}



}
