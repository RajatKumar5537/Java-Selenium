package com.AutomationJiviewsGeneric;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class ReusableComponent {

	public static  WebDriver driver;

	//************Faker Data************
	Faker faker=new Faker();
	public String name = faker.name().fullName();
	public String firstName = faker.name().firstName();
	public String lastName = faker.name().lastName();
	public String email = faker.internet().emailAddress();
	public String phoneNumber = faker.phoneNumber().phoneNumber();
	public String address = faker.address().fullAddress();
	public String dateOfBirth = faker.date().birthday().toString();
	public String randomDate = faker.date().birthday().toString();
	
	//************Constructor************
	public ReusableComponent(WebDriver driver) {
		System.out.println(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//************Handling Multiple Elements************
	public void handleMultipleElements(WebElement locator,List<WebElement> locator1,String text,String errorMessage) throws InterruptedException{
		Thread.sleep(3000);
		locator.click();
		Thread.sleep(3000);
		List<WebElement> multipleElement=locator1;
		try {
			for (WebElement ele : multipleElement) {
				String eleText = ele.getText();
				if (eleText.equalsIgnoreCase(text)) {
					ele.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(errorMessage);
		}
		return;
	}
	
	//************File Upload************
	public void selectFileToUpload(WebElement fileInputElement) {
		File file = new File("./TestData/Jiviews Team.png");
		String absolutePath = file.getAbsolutePath();
		fileInputElement.sendKeys(absolutePath);
	}
	
	//************Implicit Wait Condition************
	public void setImplicitWait(WebDriver driver, long timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	//************Explicit Wait Condition************
	public void explicitWait( WebElement locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

		switch (text) {

		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			break;

		case "visibility":
			wait.until(ExpectedConditions.visibilityOf(locator));
			break;

		case "invisibility":
			wait.until(ExpectedConditions.invisibilityOf(locator));
			break;
		}
	}

	//************List Box************
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//************Action Class Methods************
	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	//************Alert Popup************
    public void alertPopup(String text)
    {
    	Alert a;
    	switch(text)
    	{
    	case "accept" :
    	a=driver.switchTo().alert();
    	a.accept();
    	break;
    	case "dismiss" :
        a=driver.switchTo().alert();
        a.dismiss();
        break;
    	}
    }
    
    //************Reading & Writing Data from Excel File and Property File************
    public String readDataFromExcelFile(String sheetName, int rowNo, int columnNo,String FILE_PATH) throws Exception {

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getStringCellValue();
		return data;
	}
    
    public void writeDataExcelFile(String sheetName, int rowNo, int columnNo, String writeValue,String FILE_PATH) throws Exception {

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNo).getCell(columnNo).setCellValue(writeValue);
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		wb.write(fos);
		wb.close();
	}
    
    public static String readPropertyData(String key,String FILE_PATH) throws IOException
    {
    	FileInputStream fis=new FileInputStream(FILE_PATH);
    	Properties p=new Properties();
    	p.load(fis);
    	String data=p.getProperty(key);
    	return data;
    }
    
    //************Comparing Excel with Html Data************
    public void compareExcelAndHtml(String url)throws IOException 
    {
    	
            // Step 1: Scrape HTML Table Data
            Document doc = Jsoup.connect(url).get();
            Element table = doc.select("table").first();
            Elements rows = table.select("tr");

            // Step 2: Read Excel Data
            FileInputStream excelFile = new FileInputStream(new File("./data/jivi.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            // Step 3: Compare Data
            int rowNum = 0;
            for (Element row : rows) {
                Elements cells = row.select("td");
                Row excelRow = sheet.getRow(rowNum++);
                int cellNum = 0;
                for (Element cell : cells) {
                    Cell excelCell = excelRow.getCell(cellNum++);
                    String htmlCellValue = cell.text();
                    String excelCellValue = excelCell.getStringCellValue();
                    if (!htmlCellValue.equals(excelCellValue)) {
                        System.out.println("Difference found at row " + rowNum + ", column " + cellNum);
                        System.out.println("HTML Value: " + htmlCellValue);
                        System.out.println("Excel Value: " + excelCellValue);
                    }
                }
            }

            workbook.close();
    	
    }


		
	}
    


