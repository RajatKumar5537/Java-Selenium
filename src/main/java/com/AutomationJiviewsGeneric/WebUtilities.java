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
	
	private WebDriver driver;
	

    public WebUtilities(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // Adjust the scroll distance as needed
    }

    public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		element.click();
	}
    public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -150)"); // Adjust the scroll distance as needed
	}
	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void pageLoadWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void ElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));		
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
	public void fromDropDown(WebElement element,int index) {

		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void fromDropDown(WebElement element,String value) {

		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void fromDropDown(String visibletext,WebElement element) {

		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();

	}
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();;

	}
	public void doubleClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();

	}
	public void rightClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	public void dragAndDropElement(WebDriver driver,WebElement source,WebElement target) {
		Actions action= new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	public void moveByOffset(WebDriver driver,int x,int y) {
		Actions action= new Actions(driver);
		action.moveByOffset(x, y).click().perform();

	}
	public void forEnterKey(WebDriver driver) {
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	public void robotClassKeyPress() throws Exception {

		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public void robotClassKeyRelease()throws Exception{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrame(WebDriver driver,WebElement target) {
		driver.switchTo().frame(target);
	}
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1000)", "");

	}
	public void scrollByAction(WebDriver driver,WebElement element) { //....................................................
		JavascriptExecutor je=(JavascriptExecutor) driver;
		int loc = element.getLocation().getY();
		je.executeScript("window.scrollBy(0,"+loc+")", element);
	}
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
	public void handleDisableElements(WebDriver driver,String hiddenId,String Value) {

		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("document.getElementById('"+hiddenId+"').value='"+Value+"'");
	}
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
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}
}
