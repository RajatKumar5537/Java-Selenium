package com.AutomationJiviewsGeneric;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.AutomationJiviewsPOM.LoginPage;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	public static WebDriver driver;
	public static WebUtilities webUtility = new WebUtilities(driver);
	public static ExcelUtilities excelUtility= new ExcelUtilities();
	public static configUtility configUtil = new configUtility();
	public static FakeEmployee fakeEmployee=new FakeEmployee();
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
		generateFakeEmployeeData();

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		logger.info("Close Browser...");
//		driver.quit();
	}
	/*	@BeforeMethod
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
	}*/

	// Capture screenshot on test failure for Test method and add it in Extent report  
	public void captureScreenshot(WebDriver driver, String res) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/" + res + ".png");
		FileUtils.copyFile(src, dest);
		logger.info("Screenshot captured for test failure. View it at: " + dest.getAbsolutePath());

	}

	private void generateFakeEmployeeData() {
		Faker fakeData=new Faker();
		fakeEmployee.setFirstName(fakeData.name().firstName());
		 // Generate a fake description
	    fakeEmployee.setDescription(fakeData.lorem().sentence()); 
	    fakeEmployee.setDocumentName("Medical Report"); 
		fakeEmployee.setMiddleName(fakeData.name().firstName());
		fakeEmployee.setLastName(fakeData.name().lastName());
		// For AlphaNumeric value
		//	fakeEmployee.setEmpNumber(UUID.randomUUID().toString());
		//	fakeEmployee.setBadgeNumber(UUID.randomUUID().toString().substring(0, 8).toUpperCase()); //"BADGE_" +

		// For Numeric value
		fakeEmployee.setEmpNumber(generateNumericString(8));
		fakeEmployee.setBadgeNumber(generateNumericString(8));

		fakeEmployee.setDisplayName(fakeData.name().fullName());
		// Set date of birth (DOB) at least 20 years ago and Generate a random date between minDOB (inclusive) and maxDOB (inclusive)
		LocalDate minDOB = LocalDate.of(1990, 1, 1);
		LocalDate maxDOB = LocalDate.of(2004, 12, 31);
		LocalDate randomDOB = minDOB.plusDays(new Random().nextInt((int) (maxDOB.toEpochDay() - minDOB.toEpochDay()) + 1));
		fakeEmployee.setDOB(randomDOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		fakeEmployee.setAddress(fakeData.address().streetAddress());
		fakeEmployee.setCity(fakeData.address().city());
		fakeEmployee.setState(fakeData.address().state());
		fakeEmployee.setPostCode(fakeEmployee.generateFakePostalCode());
		fakeEmployee.setMobileNumber(fakeData.phoneNumber().cellPhone());
		fakeEmployee.setPhoneNumber(fakeData.phoneNumber().cellPhone());
		fakeEmployee.setEmail(fakeData.internet().emailAddress());
		
		// Set the minimum hire date (2 years ago from the current date)
		LocalDate hireDate = LocalDate.now().minusYears(2);
		fakeEmployee.setHireDate(hireDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		
		// Set probation expiry date (hire date + 90 days)
		LocalDate probationExpiryDate = LocalDate.parse(fakeEmployee.getHireDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).plusDays(90);
		fakeEmployee.setProbationExpirydate(probationExpiryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		System.out.println("Hire Date: " + fakeEmployee.getHireDate());
		System.out.println("Probation Expiry Date: " + fakeEmployee.getProbationExpirydate());
		//		fakeEmployee.setDesignation(fakeData.job().position());
		//		fakeEmployee.setInterests(fakeData.internet().domainWord());

	}
	private String generateNumericString(int length) {
		Random random = new Random();
		StringBuilder numericString = new StringBuilder();

		for (int i = 0; i < length; i++) {
			numericString.append(random.nextInt(10)); // Append a random digit (0-9)
		}

		return numericString.toString();
	}


	// Add a boolean variable to track whether the user is logged in
	private boolean isLoggedIn = false;
	@BeforeClass
	public void beforeTestMethod() throws IOException, InterruptedException {
		login();
	}
	@AfterClass
	public void afterTestMethod() {
		try {
			logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void login() throws IOException, InterruptedException {
		// Perform login only if the user is not already logged in
		if (!isLoggedIn) {
			Reporter.log("Login", true);
			logger.info("Login to the Jivi application");

//			configUtility configUtil = new configUtility();
			String url = configUtil.getCongigPropertyData("url");
			String un = configUtil.getCongigPropertyData("username");
			String pw = configUtil.getCongigPropertyData("password");
			driver.get(url);
			LoginPage lp = new LoginPage(driver);
			lp.setLogin(un, pw);
			isLoggedIn = true;
		}
	}
	public void logout() {
		if (isLoggedIn) {
			Reporter.log("Logout", true);
			logger.info("Logout from Jivi application");
			//		HomePage hp=new HomePage(driver);
			//		Thread.sleep(2000);
			//		hp.setAdmin();
			//		Thread.sleep(2000);
			//		hp.setLogout();
			// Reset the isLoggedIn flag to allow logging in again in the future
			isLoggedIn = false;
		}
	}



}
