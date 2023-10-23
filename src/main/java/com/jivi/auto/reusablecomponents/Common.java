package com.jivi.auto.reusablecomponents;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class Common extends GlobalVariables {

	public WebElement webObject;
	public String locatorType, locatorValue;
	public WebDriverWait wait;

	public WebElement getObject(String locator) throws InterruptedException {

		WebDriver driver = Browser.getInstance().getDriver();
		WebElement objectToReturn = null;
		waitUntilElementIsVisible(locator);
		waitUntilElementIsClickable(locator);
		

		if (locatorType.toLowerCase().equals("xpath")) {
			objectToReturn = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.toLowerCase().equals("name")) {
			objectToReturn = driver.findElement(By.name(locatorValue));
		} else if (locatorType.toLowerCase().equals("id")) {
			objectToReturn = driver.findElement(By.id(locatorValue));
		} else if (locatorType.toLowerCase().equals("class")) {
			objectToReturn = driver.findElement(By.className(locatorValue));
		} else if (locatorType.toLowerCase().equals("cssselector")) {
			objectToReturn = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.toLowerCase().equals("linktext")) {
			objectToReturn = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			objectToReturn = driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("tagname")) {
			objectToReturn = driver.findElement(By.tagName(locatorValue));
		}
		

		HighlightElement(objectToReturn);

		return objectToReturn;
	}

	public void waitUntilElementIsVisible(String locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		setLocatertypeLocatervalue(locator);
		switch (locatorType) {
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			break;
		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			break;
		case "name":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			break;
		case "cssselector":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "linktext":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "partiallinktext":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		case "tagname":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			break;
		}
	}

	public void waitUntilElementIsClickable(String locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(GlobalVariables.configData.get("ExplicitWait").substring(0,
				GlobalVariables.configData.get("ExplicitWait").lastIndexOf(".")))));
		setLocatertypeLocatervalue(locator);
		switch (locatorType) {
		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			break;
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
			break;
		case "name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
			break;
		case "cssselector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
			break;
		case "linktext":
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorValue)));
			break;
		// the following are the new methods
		case "partiallinktext":
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locatorValue)));
			break;
		case "tagname":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locatorValue)));
			break;
		
		}
	}

	public boolean isObjectEnabledAndDisplayed(String locator) throws Exception {
		webObject = getObject(locator);

		boolean isDisplayed = webObject.isDisplayed();
		boolean isEnabled = webObject.isEnabled();
		Assert.assertTrue(isDisplayed);
		Assert.assertTrue(isEnabled);

		return true;
	}

	public boolean verifyAttributeValue(String locator, String attribute, String expectedAttributeValue)
			throws Exception {
		isObjectEnabledAndDisplayed(locator);
		try {
			String actualAttributeValue = webObject.getAttribute(attribute);
			boolean isAttributeValueVerified = (actualAttributeValue.trim()).equals(expectedAttributeValue.trim());
			Assert.assertTrue(isAttributeValueVerified);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void click(String locator) throws Exception {
		isObjectEnabledAndDisplayed(locator);
		try {

			webObject.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void submit(String locator) throws Exception {
		isObjectEnabledAndDisplayed(locator);
		try {
			webObject.submit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLocatertypeLocatervalue(String locator) {
		if (GlobalVariables.configData.get("ObjectRepositoryFileType").toString().toLowerCase().equals("propertiesfile")) {
			locatorValue = Object.getProperty(locator.trim()).trim();
			locatorType = returnLocatorType(locator);
		} else {
			locatorType = returnLocatorType(locator);
//			locatorValue = ObjectRepository.getNodeProperty(locator, locatorType);

		}
	}
	
	
	/* @Deprecated
	 * public void waitForPageLoad(int timeoutLimit) { WebDriver driver =
	 * Browser.getInstance().getDriver();
	 * driver.manage().timeouts().pageLoadTimeout(timeoutLimit, TimeUnit.SECONDS); }
	 */
	
	public void waitForPageLoad(int timeoutLimit) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutLimit));
	}

	public void waitForPageReadyState(int timeoutLimit) {
		WebDriver driver = Browser.getInstance().getDriver();
		new WebDriverWait(driver, Duration.ofSeconds(timeoutLimit))
				.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) wdriver)
						.executeScript("return document.readyState").equals("complete"));
	}

	public String returnLocatorType(String locator) {
		String[] objectPath = locator.trim().split("_");
		int lastIndexValue = objectPath.length - 1;
		return objectPath[lastIndexValue].toLowerCase().trim();
	}

	public void clickUsingJavaScript(String locatorKey) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		WebElement btnObject = getObject(locatorKey);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnObject);
	}

	public void setValueUsingJavaScript(String locatorKey, String valueToBeSet) throws Exception {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement btnObject = getObject(locatorKey);
		jse.executeScript("arguments[0].value='" + valueToBeSet + "';", btnObject);
	}

	@Deprecated
	public void veriftTextOnApplication(String locator, String expectedText) {
		try {

			WebElement btnObject = getObject(locator);
			Assert.assertTrue(btnObject.getText().contains(expectedText));
		} catch (AssertionError | Exception e) {
//			reportUtils.addStepDetails("Assertion Error in Verifiying Text on Application" + e.getStackTrace());

		}
	}

	public void verifyTextOnApplication(String locator, String expectedText) throws InterruptedException {
		try {
			WebElement btnObject = getObject(locator);
			Assert.assertTrue(btnObject.getText().contains(expectedText));
		} catch (AssertionError | Exception e) {
//			reportUtils.addStepDetails("Assertion Error in Verifiying Text on Application" + e.getStackTrace());
		}
	}

	/**
	 *  Deprecated the VerifyDisplayStatus Method    
	 */
	@Deprecated
	public static boolean VerifyDisplayStatus(By argBy) { // Generic Function
		boolean isDisplayed = false;
		WebDriver driver = Browser.getInstance().getDriver();

		try {
			if (driver.findElement(argBy).isDisplayed())
				isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			//System.out.println("From catch block of generic_fnIsDisplayedOrNot - for xPath::" + argBy);
		}

		return isDisplayed;
	}

	/**
	 *  Deprecated the VerifyEnabledStatus Method    
	 */
	@Deprecated
	public static boolean VerifyEnabledStatus(By argBy) { // Generic Function
		boolean isEnabled = false;
		WebDriver driver = Browser.getInstance().getDriver();

		try {
			if (driver.findElement(argBy).isEnabled())
				isEnabled = true;
		} catch (Exception e) {
			isEnabled = false;
			//System.out.println("From catch block of fnIsEnabledOrNot - By xPath::" + argBy);
		}

		return isEnabled;
	}

	/**
	 *  Deprecated the ReturnWebElement Method    
	 */
	@Deprecated
	public WebElement ReturnWebElement(By by) {
		WebDriver driver = Browser.getInstance().getDriver();
		return driver.findElement(by);
	}

	/**
	 *  Deprecated the ReturnWebElement Method    
	 */
	@Deprecated
	public By ReturnWebElement(String operator, String locator) {
		switch (locator) {
		case "Id":
			return By.id(operator);
		case "xpath":
			return By.xpath(operator);
		case "name":
			return By.name(operator);
		case "classname":
			return By.className(operator);
		case "linktext":
			return By.linkText(operator);
		case "partialLinkText":
			return By.partialLinkText(operator);
		case "tagname":
			return By.tagName(operator);
		}
		return null;
	}

	// The following method will get the current window handle
	@Deprecated
	public String getMainWindowHandle(WebDriver d) {
		WebDriver driver = Browser.getInstance().getDriver();
		String windowTitle = driver.getWindowHandle();
		return windowTitle;
	}
	
	// The following method will get the current window handle
	public String getMainWindowHandle() {
		WebDriver driver = Browser.getInstance().getDriver();
		String windowTitle = driver.getWindowHandle();
		return windowTitle;
	}

	// The following method will get the current window title
	@Deprecated
	public String getCurrentWindowTitle(WebDriver d) {
		WebDriver driver = Browser.getInstance().getDriver();
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	// The following method will get the current window title
	public String getCurrentWindowTitle() {
		WebDriver driver = Browser.getInstance().getDriver();
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	// The following method will close all other browser tabs except for main tab.
	@Deprecated
	public void closeAllOtherWindows(WebDriver d) {
		WebDriver driver = Browser.getInstance().getDriver();
		String CurrentwindowHandle = getMainWindowHandle(d);
		Set<String> allWindows = driver.getWindowHandles();
		for (String CW : allWindows) {
			if (!(CW.equals(CurrentwindowHandle))) {
				driver.switchTo().window(CW);
				driver.close();
			}
		}
		driver.switchTo().window(CurrentwindowHandle);
	}
	
	// The following method will close all other browser tabs except for main tab.
	public void closeAllOtherWindows() {
		WebDriver driver = Browser.getInstance().getDriver();
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

	public void HighlightElement(WebElement locator) {
		try {
			if (configData.get("highlight") != null) {
				if (configData.get("highlight").toLowerCase().equals("Yes")) {
					WebDriver driver = Browser.getInstance().getDriver();
					String jsarg = "arguments[0].setAttribute('style', 'border: 4px solid yellow;');";

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(jsarg, locator);
					Thread.sleep(500);
					// Disable Highlight
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", locator, "");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  Deprecated the upload Method    
	 */
	@Deprecated
	public void upload(String locator, String packageName, String fileName) throws Exception {
		webObject = getObject(locator);
		try {
			String filepath = System.getProperty("user.dir") + "/src/" + packageName + "/" + fileName;
			webObject.sendKeys(filepath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Deprecated the upload Method    
	 */
	@Deprecated
	public void upload(String locator, String filePath) throws Exception {
		webObject = getObject(locator);
		try {
			webObject.sendKeys(filePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Deprecated the upload Method    
	 */
	@Deprecated
	public void uploadUsingAutoIT(String locator) throws Exception {

		WebDriver driver = Browser.getInstance().getDriver();

		webObject = getObject(locator);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(webObject);
			action.click();
			action.build().perform();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Deprecated the SwtichToFrame Method    
	 */
	@Deprecated
	public void SwtichToFrame(String frameName) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameName);
	}

	/**
	 *  Deprecated the SwtichToFrame Method    
	 */
	@Deprecated
	public void SwtichToFrame(int frameIndex) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameIndex);
	}

	/**
	 *  Deprecated the SwtichToFrame Method    
	 */
	@Deprecated
	public void SwtichToFrame(WebElement e) {
		WebDriver driver = Browser.getInstance().getDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(e);
	}

	public List<WebElement> getObjects(String locator) throws InterruptedException {

		WebDriver driver = Browser.getInstance().getDriver();
		List<WebElement> objectToReturn = null;
		waitUntilElementIsVisible(locator);
		waitUntilElementIsClickable(locator);

		if (locatorType.toLowerCase().equals("xpath")) {
			objectToReturn = driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.toLowerCase().equals("name")) {
			objectToReturn = driver.findElements(By.name(locatorValue));
		} else if (locatorType.toLowerCase().equals("id")) {
			objectToReturn = driver.findElements(By.id(locatorValue));
		} else if (locatorType.toLowerCase().equals("class")) {
			objectToReturn = driver.findElements(By.className(locatorValue));
		} else if (locatorType.toLowerCase().equals("cssselector")) {
			objectToReturn = driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.toLowerCase().equals("linkText")) {
			objectToReturn = driver.findElements(By.linkText(locatorValue));
		}

		return objectToReturn;
	}

	
	public By getLocator(String locator) throws InterruptedException {

		WebDriver driver = Browser.getInstance().getDriver();
		By locatorToReturn = null;
		waitUntilElementIsVisible(locator);
		waitUntilElementIsClickable(locator);		

		if (locatorType.toLowerCase().equals("xpath")) {
			locatorToReturn = By.xpath(locatorValue);
		} else if (locatorType.toLowerCase().equals("name")) {
			locatorToReturn = By.name(locatorValue);
		} else if (locatorType.toLowerCase().equals("id")) {
			locatorToReturn = By.id(locatorValue);
		} else if (locatorType.toLowerCase().equals("class")) {
			locatorToReturn = By.className(locatorValue);
		} else if (locatorType.toLowerCase().equals("cssselector")) {
			locatorToReturn = By.cssSelector(locatorValue);
		} else if (locatorType.toLowerCase().equals("linktext")) {
			locatorToReturn = By.linkText(locatorValue);
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			locatorToReturn = By.partialLinkText(locatorValue);
		} else if (locatorType.toLowerCase().equals("tagname")) {
			locatorToReturn = By.tagName(locatorValue);
		}
		
		return locatorToReturn;
	}	
}