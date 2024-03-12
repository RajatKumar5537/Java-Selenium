package com.AutomationJiviewsPOM;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import com.AutomationJiviewsGeneric.WebUtilities;



public class E10_3541_OPE_RTG_PlanningPage {

	public WebDriver driver;
	public Select select;
	public Actions action;
	public String dateRTG;
	public WebUtilities webUtility;



	@FindBy(xpath = "//div[@id='layout-navbar-collapse']/div/div[@id='dvOrgUnitDropdown']/a")
	private WebElement OrgUnit;
	@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[7]")
	private WebElement OLMop;
	@FindBy(xpath = "//span[text()='SYSTEM SETUP']/..")
	private WebElement mainMenu;

	@FindBy(xpath = "//span[text()='Operation Planning & Execution']/..")
	private WebElement selectOperationPlanningExecution;
	@FindBy(xpath = "//div[text()='Workload Planning']/..")
	private WebElement workloadPlanning;
	@FindBy(xpath = "//div[text()='Workforce Execution']/..")
	WebElement workforceExecution;
	
	@FindBy(xpath = "//li[@data-menu-link='Planning/DailyPlanning/RTGPlanning']")
	WebElement RTGPlanning;



	@FindBy(xpath = "//input[@id='dtPlanning']")
	private WebElement txtPlanning;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[18]")
	private WebElement calender;




	@FindBy(xpath  = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement txtShiftBand;
	@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	private WebElement txtSearchField;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG_AM1']")
	private WebElement selectshiftBand;
	@FindBy(xpath = "//button[@id='btnSearchRTGPlanning']")
	private WebElement btnSearchRTGPlanning;

	@FindBy(xpath = "//button[@id='btnAddRTGPlanning']")
	private WebElement btnAddRTGPlanning;
	@FindBy(xpath = "//input[@id='dtPlanning']")
	WebElement dtPlanning;
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	WebElement cmbShiftBand;





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


	// Constructor .................
	public E10_3541_OPE_RTG_PlanningPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
		this.action= new Actions(driver);
		this.webUtility= new WebUtilities(driver);
	}



	public void selectOrgUnit() throws InterruptedException {
		webUtility.ElementClickable(driver, OrgUnit);
		Thread.sleep(2000);
		OrgUnit.click();
	}
	public void selectOLMop() {
		try {
			webUtility.ElementClickable(driver, OLMop);
			OLMop.click();
		} 
		
		catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occurred. Retrying...");
			webUtility.ElementClickable(driver, OLMop); 
			OLMop.click(); 
		}
	}

	public void selectMainMenu() {
		webUtility.ElementClickable(driver, mainMenu);
		mainMenu.click();
	}
	public void selectOperationPlanningExecution() {
		selectOperationPlanningExecution.click();
	}
	public void selectWorkloadPlanning(){
		workloadPlanning.click();
	}











	public void enterPlanningDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		WebElement Planning = wait.until(ExpectedConditions.elementToBeClickable(txtPlanning));
		try {
			Planning.click();
		} catch (ElementClickInterceptedException ex) {
			System.out.println("Element is still not clickable after clearing: " + ex.getMessage());
		}

	}
	public void enterDate() throws InterruptedException {
		webUtility.ElementClickable(driver, calender);
		calender.click();
	}
	public void clickTxtShiftBand() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dvLoadingIcon")));
		WebElement bandTypeElement = wait.until(ExpectedConditions.visibilityOf(txtShiftBand));

		Actions actions = new Actions(driver);
		actions.moveToElement(bandTypeElement).click().perform();
	}


	public void enterShiftBandName(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement bandTypeElement = wait.until(ExpectedConditions.visibilityOf(txtSearchField));
		bandTypeElement.clear();
		bandTypeElement.sendKeys(name);
		bandTypeElement.sendKeys(Keys.ENTER);
	}
	public void selectShiftBand() {
		selectshiftBand.click();
	}
	public void searchRTGPlanning() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		// Locate and click the search button
		WebElement searchButton = driver.findElement(By.id("btnSearchRTGPlanning"));
		searchButton.click();
	}

	public void performAddRTGPlanning() {
		try {
			// Wait for the overlay to be invisible or absent
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
			WebElement btnAddRTGPlanning = driver.findElement(By.id("btnAddRTGPlanning"));
			// Wait for the "Add" button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(btnAddRTGPlanning));
			btnAddRTGPlanning.click();
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	public void selectAvailableShiftBand() {
		action.scrollToElement(availableRTG).perform();
		select = new Select(availableRTG);
		select.selectByIndex(0);
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
		try {
			// Locate the element you want to click
			WebElement equipmentSummaryLink = driver.findElement(By.xpath("//a[text()='Equipment Summary']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blockUI")));
			// Click on the element using Actions class to avoid ElementClickInterceptedException
			Actions actions = new Actions(driver);
			actions.moveToElement(equipmentSummaryLink).click().perform();

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}

	}
	public void clickonSkillSummary() {
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
		selectOrgUnit();
		selectOLMop();
		selectMainMenu();
		selectOperationPlanningExecution();
		
//		Thread.sleep(5000);
//		workloadPlanning.click();

//		selectWorkloadPlanning();
		Thread.sleep(3000);
		RTGPlanning.click();
//
		//		txtPlanning.clear();
//		txtPlanning.click();
//		//		calender.click();
//
//		//txtShiftBand.click();
//		//selectshiftBand.click();
		
		Thread.sleep(10000);
		btnSearchRTGPlanning.click();


Thread.sleep(10000);
//		btnAddRTGPlanning.click();
//		dtPlanning.isDisplayed();
//		cmbShiftBand.isDisplayed();

	}

	public void E10_3543_AddEqipment() throws Exception{
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate();
		enterDate();
		searchRTGPlanning();

		performAddRTGPlanning();
		selectAvailableShiftBand();
		moveSingleAvailableSkillToSelected();
		performSaveRTGPlanning();
		//		getEquipmentsGeneratedForMsg();
		//		closeNotificationPopup();
	}
	public void E10_3544_VerifyEquipmentSummery () throws InterruptedException{
		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate();
		enterDate();
		searchRTGPlanning();

		clickonEquipmentSummary();
	}
	public void E10_3545_VerifySkillSummery () throws InterruptedException{
		//		Thread.sleep(2000);

		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate();
		enterDate();
		searchRTGPlanning();

		clickonSkillSummary();
	}
	public void E10_3546_RTGSignOff() throws InterruptedException{
		//		Thread.sleep(2000);

		clickTxtShiftBand();
		enterShiftBandName("RTG_AM1");
		enterPlanningDate();
		enterDate();
		searchRTGPlanning();
		//		Thread.sleep(2000);
		pressPlanningSignOff();
		clickonManningRatio();
		chooseManningRatio();
		clickonAllocationRule();
		chooseAllocationRule();
		//				performSave();
	}

}
