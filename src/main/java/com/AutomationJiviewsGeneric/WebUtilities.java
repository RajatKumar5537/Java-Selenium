package com.AutomationJiviewsGeneric;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebUtilities extends BaseClass{
	/**
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void pageLoadWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/**
	 * 
	 * @param driver
	 * @param i
	 * @param element
	 * @throws Exception 
	 */
	public void ElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public void visibilityOfElement(WebDriver driver,WebElement element) throws Exception {
		Duration waitTime = Duration.ofSeconds(10);
		
		int a=0;
		while(a<100)
		{
			try
			{
				WebDriverWait wait=new WebDriverWait(driver, waitTime);
			
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			}
			catch(Exception e)
			{
				a++;
			}
		}
	}


	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void fromDropDown(WebElement element,int index) {

		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void fromDropDown(WebElement element,String value) {

		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * 
	 * @param visibletext
	 * @param element
	 */
	public void fromDropDown(String visibletext,WebElement element) {

		Select sel=new Select(element);
		sel.selectByVisibleText(visibletext);
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {

		Actions a= new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element) {

		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();;

	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();

	}
	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebDriver driver,WebElement source,WebElement target) {
		Actions a= new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffset(WebDriver driver,int x,int y) {
		Actions a= new Actions(driver);
		a.moveByOffset(x, y).click().perform();

	}
	/**
	 * 
	 * @param driver
	 */
	public void forEnterKey(WebDriver driver) {
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void robotClassKeyPress() throws Exception {

		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void robotClassKeyRelease()throws Exception{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * @param driver
	 * @param name
	 */
	public void switchToFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * 
	 * @param driver
	 * @param target
	 */
	public void switchToFrame(WebDriver driver,WebElement target) {
		driver.switchTo().frame(target);
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * 
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * 
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1000)", "");

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollByAction(WebDriver driver,WebElement element) { //....................................................
		JavascriptExecutor je=(JavascriptExecutor) driver;
		int loc = element.getLocation().getY();
		je.executeScript("window.scrollBy(0,"+loc+")", element);
		//OR
		//je.executeScript("argument[0].scrollIntoView()", element);
	}

	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void getDifferentWindows(WebDriver driver,String partialTitle) {
		//get all the windows
		Set<String> allWindows = driver.getWindowHandles();
		//save in iterator
		Iterator<String> ite = allWindows.iterator();
		//check for next one
		while(ite.hasNext()) {

			//save the current one
			String windowsId=ite.next();
			//switch to current window and get title
			String title = driver.switchTo().window(windowsId).getTitle();
			//check with expected one
			if(title.contains(partialTitle)) {

				break;
			}
		}
	}

	/**
	 * 
	 * @param driver
	 * @param hiddenId
	 * @param Value
	 */
	public void handleDisableElements(WebDriver driver,String hiddenId,String Value) {

		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("document.getElementById('"+hiddenId+"').value='"+Value+"'");
	}

	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path=".//Screenshot//"+screenshotName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;

	}
	
	// Ashok's code 
	public void scrollIntoeEement(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",locator);
	}
	/*public void scrollUp() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");

	}

	public void scrollDown() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	
	public void scrollDownLittle() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollDown300() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public void scrollDown200() {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	
	public void scrollIntoeEement(WebElement locator) {
		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",locator);
	}

	public void scrollToPosition(int x, int y) {

		WebDriver driver = Browser.getInstance().getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}*/
}
