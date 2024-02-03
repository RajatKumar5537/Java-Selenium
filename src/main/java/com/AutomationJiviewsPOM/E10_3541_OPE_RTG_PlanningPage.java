package com.AutomationJiviewsPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AutomationJiviewsGeneric.BaseClass;



public class E10_3541_OPE_RTG_PlanningPage extends BaseClass{
	public Select select;
	public Actions action;

	@FindBy(id = "dtPlanning")
	private WebElement txtPlanning;
	@FindBy(id = "select2-cmbShiftBand-container")
	private WebElement txtShiftBand;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	private WebElement txtSearchField;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectshiftBand;
	@FindBy(id = "btnSearchRTGPlanning")
	private WebElement btnSearchRTGPlanning;

	@FindBy(id = "btnAddRTGPlanning")
	private WebElement btnAddRTGPlanning;

	// Available RTG table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableRTG;

	// select for single Arrow -> move RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle; 

	//		select for move multiple RTG from available RTG table to Selected RTG table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	// here it will select a RTG from Seleceted RTG Table 
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement selectedRTG;

	//	select for move single RTG from Selected RTG table to Available RTG table 
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	private WebElement removeSelectedRTGSingle;

	//	select for move multiple skill from Selected skill table to Available RTG table 
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	private WebElement removeSelectedRTG_All;

	@FindBy(id = "btnSaveRTGPlanning")
	private WebElement btnSaveRTGPlanning;
	@FindBy(xpath = "//div[text()=' Equipments Generated For ']")
	private WebElement getEquipmentsGeneratedForMsg;

	@FindBy(xpath = "//a[text()='Equipment Summary']")
	private WebElement tabEquipmentSummary;
	@FindBy(xpath = "//a[text()='Skill Summary']")
	private WebElement tabSkillSummary;

	@FindBy(xpath = "//div[@class='centered_rowheader_inner_text']")
	private WebElement getManningRatio; // Not required 

	@FindBy(id = "btnPlanningSignOff")
	private WebElement btnPlanningSignOff;

	@FindBy(id = "select2-cmbActivityGenRule-container")
	private WebElement txtManningRatio;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']") 
	private WebElement selectManningRatio;
	@FindBy(id = "select2-cmbAllocationRule-container")
	private WebElement cmbAllocationRule;

	@FindBy(id = "btnPerformActivityGenerationTask")
	private WebElement btnPerformActivityGenerationTask;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;
	
	public E10_3541_OPE_RTG_PlanningPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
	}

	public void enterPlanningDate(String date) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Planning = wait.until(ExpectedConditions.elementToBeClickable(txtPlanning));
		Planning.clear();
		Planning.sendKeys(date);
		Planning.sendKeys(Keys.ENTER);
		
	}
	public void clickTxtShiftBand() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dvLoadingIcon")));
		WebElement bandTypeElement = wait.until(ExpectedConditions.elementToBeClickable(txtShiftBand));
		bandTypeElement.click();
	}
	public void enterShiftBandName(String name) {
		txtSearchField.clear();
		txtSearchField.sendKeys(name);
		txtSearchField.sendKeys(Keys.ENTER);
	}
	public void selectShiftBand() {
		selectshiftBand.click();
	}
	public void searchRTGPlanning() {
		btnSearchRTGPlanning.click();
	}
	public void performAddRTGPlanning() {
	    try {
	        // Wait for the overlay to be invisible or absent
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
	        WebElement btnAddRTGPlanning = driver.findElement(By.id("btnAddRTGPlanning"));
	        // Wait for the "Add" button to be clickable
//	        WebDriverWait buttonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(btnAddRTGPlanning));
	        btnAddRTGPlanning.click();
	    } catch (Exception e) {
	        System.out.println("Exception occurred: " + e.getMessage());
	    }
	}

	public void selectAvailableShiftBand() {
		action.scrollToElement(availableRTG).perform();
		select = new Select(availableRTG);
		select.selectByIndex(1);
	}

	public void moveSingleAvailableSkillToSelected() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	public void moveAllAvailableSkillsToSelected() {
		selectMoveAll.click();
	}

	public void clickSelectedSkill() {
		selectedRTG.click();
	}

	public void removeSelectedSkillSingle() {
		removeSelectedRTGSingle.click();
	}

	public void removeSelectedSkillAll() {
		removeSelectedRTG_All.click();
	}
	public void performSaveRTGPlanning() {
		btnSaveRTGPlanning.click();
	}
	public void getEquipmentsGeneratedForMsg() {
		String actualResult =getEquipmentsGeneratedForMsg.getText();
		Assert.assertTrue(actualResult.contains(" Equipments Generated For "));
	}
	public void clickonEquipmentSummary() {
//		tabEquipmentSummary.click();
        try {
            // Locate the element you want to click
            WebElement equipmentSummaryLink = driver.findElement(By.xpath("//a[text()='Equipment Summary']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blockUI")));
            // Click on the element using Actions class to avoid ElementClickInterceptedException
            Actions actions = new Actions(driver);
            actions.moveToElement(equipmentSummaryLink).click().perform();

        } catch (Exception e) {
            // Handle exceptions or log messages as needed
            System.out.println("Exception occurred: " + e.getMessage());
        }

	}
	public void clickonSkillSummary() {
//		tabSkillSummary.click();
		  try {
	            // Locate the element you want to click
	            WebElement skillSummaryLink = driver.findElement(By.xpath("//a[text()='Skill Summary']"));
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blockUI")));
	            // Click on the element using Actions class to avoid ElementClickInterceptedException
	            Actions actions = new Actions(driver);
	            actions.moveToElement(skillSummaryLink).click().perform();
	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	        }
	    }

	public void pressPlanningSignOff() {
	    try {
	        // Wait for the "Planning Sign Off" button to be clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement planningSignOffButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPlanningSignOff")));

	        // Click the "Planning Sign Off" button using JavaScriptExecutor
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", planningSignOffButton);

	    } catch (Exception e) {
	        System.out.println("Exception occurred: " + e.getMessage());
	    }
	}

	public void clickonManningRatio() {
		 try {
		        // Find the element every time before interacting with it
		        WebElement cmbActivityGenRule = driver.findElement(By.id("select2-cmbActivityGenRule-container"));
		        cmbActivityGenRule.click();
		    } catch (StaleElementReferenceException e) {
		        // If the element is stale, catch the exception and try again
		        System.out.println("StaleElementReferenceException occurred. Retrying...");
		        clickonManningRatio(); // Recursive call to try clicking again
		    } catch (Exception e) {
		        System.out.println("Exception occurred: " + e.getMessage());
		    }
	}
	public void chooseManningRatio() {
		selectManningRatio.click();
	}
	public void clickonAllocationRule() {
		cmbAllocationRule.click();
	}
	public void chooseAllocationRule() {
		selectManningRatio.click();
	}
	public void performSave() {
		btnPerformActivityGenerationTask.click();
	}
	public void closeNotificationPopup() throws Exception {
		webUtility.visibilityOfElement(driver, notificationPopup);
		notificationPopup.click();
	}

	public void E10_3542_SearchRecord () throws InterruptedException{
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate("12/02/2024");
		searchRTGPlanning();
	}

	public void E10_3543_AddEqipment() throws Exception{
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate("12/02/2024");
		searchRTGPlanning();
		
		performAddRTGPlanning();
		selectAvailableShiftBand();
		moveSingleAvailableSkillToSelected();
		performSaveRTGPlanning();
		getEquipmentsGeneratedForMsg();
		closeNotificationPopup();
	}
	public void E10_3544_VerifyEquipmentSummery () throws InterruptedException{
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate("12/02/2024");
		searchRTGPlanning();
		
		clickonEquipmentSummary();
	}
	public void E10_3545_VerifySkillSummery () throws InterruptedException{
//		Thread.sleep(2000);
		
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate("12/02/2024");
		searchRTGPlanning();
		
		clickonSkillSummary();
	}
	public void E10_3546_RTGSignOff() throws InterruptedException{
//		Thread.sleep(2000);
		
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate("12/02/2024");
		searchRTGPlanning();
//		Thread.sleep(2000);
		pressPlanningSignOff();
		clickonManningRatio();
		chooseManningRatio();
		clickonAllocationRule();
		chooseAllocationRule();
//		performSave();
	}

	
}
