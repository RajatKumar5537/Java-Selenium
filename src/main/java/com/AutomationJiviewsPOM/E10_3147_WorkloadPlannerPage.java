package com.AutomationJiviewsPOM;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;

public class E10_3147_WorkloadPlannerPage extends BaseClass {

	@FindBy(xpath = "//input[@id='dtPlanning']")
	private WebElement dtPlanning;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement selectShiftBandType;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement shiftBandOption;
	@FindBy(xpath = "//button[@id='btnSearchDailyPlanning']")
	private WebElement btnSearchDailyPlanning;

	@FindBy(xpath = "//div[@class='centered_cell centered_cell_business']")
	private List<WebElement> centered_Cell; 

	@FindBy(xpath = "//button[@id='btnAddVesselSchedule']")
	private WebElement btnAddVesselSchedule;


	@FindBy(xpath = "//span[text()='Create']")
	private WebElement createOption;
	@FindBy(xpath = "//span[text()='Vessel']")
	private WebElement vesselOption;
	@FindBy(xpath = "//span[text()='Equipment']/..")
	private WebElement equipmentOption;

	@FindBy(xpath = "//button[@id='btnAddEquipmentSchedule']")
	private WebElement btnAddEquipmentSchedule;
	@FindBy(xpath = "//span[@id='select2-cmbEquipSchdCraneNumber-container']")
	private WebElement cmbEquipSchdCraneNumber;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectCraneNumber;
	@FindBy(xpath = "//button[@id='btnAddEquipmentType']")
	private WebElement btnAddEquipmentType;
	@FindBy(xpath = "//span[@id='select2-cmbEquipmentType1-container']")
	private WebElement cmbEquipmentType;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectEquipmentType;
	@FindBy(xpath = "//input[@id='txtRequirement1']")
	private WebElement txtRequirement;
	@FindBy(xpath = "//button[@id='btnGetEquipments']")
	private WebElement btnGetEquipments;
	@FindBy(xpath = "//button[@id='btnSaveEquipmentSchedule']")
	private WebElement btnSaveEquipmentSchedule;


	@FindBy(xpath = "//input[@id='txtVesselName']")
	private WebElement txtVesselName;
	@FindBy(xpath = "//input[@id='txtVesselVisitId']")
	private WebElement txtVesselVisitId;
	@FindBy(xpath = "//span[@id='select2-cmbBerth-container']")
	private WebElement selectBerth;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement chooseBerth;
	@FindBy(xpath = "//input[@id='txtNumberOfCranes']")
	private WebElement txtNumberOfCranes;
	@FindBy(xpath = "//span[@id='select2-cmbPriority-container']")
	private WebElement selectPriority;
	@FindBy(xpath = "//li[text()='High']")
	private WebElement selectHighPriority;
	@FindBy(xpath = "//input[@id='dtVesselArrival']")
	private WebElement dtVesselArrival;
	@FindBy(xpath = "//input[@id='tmVesselArrival']")
	private WebElement vesselArrivalTime;
	@FindBy(xpath = "//input[@id='dtVesselDeparture']")
	private WebElement dtVesselDeparture;
	@FindBy(xpath = "//input[@id='tmVesselDeparture']")
	private WebElement tmVesselDeparture;
	@FindBy(xpath = "//button[@id='btnSaveVesselSchedule']")
	private WebElement btnSaveVesselSchedule;
	@FindBy(xpath = "//div[text()='Vessel Schedule created successfully']") 
	private WebElement vesselScheduleCreatedSuccessfullyMsg;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(xpath = "//button[text()='No']")
	private WebElement btnNo;


	@FindBy(xpath = "//span[text()='Crane']")
	private WebElement craneOption;
	@FindBy(xpath = "//span[@id='select2-cmbCraneScheduleVesselName-container']")
	private WebElement cmbCraneScheduleVesselName;
	@FindBy(xpath = "//li[@role='treeitem']")
	private WebElement chooseCrane;

	@FindBy(xpath = "//button[@id='btnAddCrane']")
	private WebElement btnAddCrane;
	@FindBy(xpath = "//span[@id='select2-cmbCraneNumber1-container']")
	private WebElement cmbCraneNumber;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	private WebElement selectCrane;
	@FindBy(xpath = "//button[@id='btnSaveCraneSchedule']")
	private WebElement btnSaveCraneSchedule;
	@FindBy(xpath = "//div[text()='Crane Schedule created successfully']") 
	private WebElement CraneScheduleCreatedSuccessfullyMsg;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "//div[@data-event-type='Vessel Schedule']")
	private WebElement editVesselSchedule;
	@FindBy(xpath = "//button[@id='btnDelCraneSchedule62']")
	private WebElement btnDelCraneSchedule62;
	@FindBy(xpath = "//button[@id='btnDelVesselSchedule']")
	private WebElement btnDelVesselSchedule;
	@FindBy(xpath = "//div[text()='Vessel Schedule deleted successfully']")
	private WebElement vesselScheduleDeletedSuccessfullyMsg;

	@FindBy(xpath = "//div[@id='dvContent']/div[1]/div/div[1]/button") 
	private WebElement btnChangeButton; 
	@FindBy(xpath = "//a[@id='btnTimeLineView']")
	private WebElement btnTimeLineView;
	@FindBy(xpath = "//a[@id='btnTableView']")
	private WebElement btnTableView;

	@FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary icon-btn mx-1 edit'])[1]")
	private WebElement vesselScheduleEdit;

	@FindBy(xpath = "(//table[@id='vessel-schedule-list']/thead/tr/th)[1]")
	private WebElement selectAllCheckboxVessel;

	@FindBy(xpath = "//table[@id='vessel-schedule-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//button[@id='btnDeleteVesselSchedule']")
	private WebElement btnDeleteVesselSchedule;

	@FindBy(xpath = "(//table[@id='crane-schedule-list']/thead/tr/th)[1]")
	private WebElement selectAllCheckboxCrane;
	@FindBy(xpath = "//button[@id='btnDeleteCraneSchedule']") 
	private WebElement btnDeleteCraneSchedule;
	@FindBy(xpath = "//div[text()='Crane Schedule deleted successfully']")
	private WebElement CraneScheduleDeletedSuccessfullyMsg;
	//@FindBy(xpath = "//button[text()='Yes']")
	//private WebElement btnYes;

	@FindBy(xpath = "//button[@id='btnEquipmentsMatrix']")
	private WebElement btnEquipmentsMatrix;
	@FindBy(xpath = "//input[@id='dtActivityGenPlanning']")
	private WebElement dtActivityGenPlanning;
	@FindBy(xpath = "//span[@id='select2-cmbActivityGenShiftBand-container']")
	private WebElement cmbActivityGenShiftBand;
	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	private WebElement searchShiftBand;
	@FindBy(xpath = "//span[@id='select2-cmbActivityGenRule-container']")
	private WebElement equipmentRequirementMatrixTemplate;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement selectEquipmentRequirement;
	@FindBy(xpath = "//button[@id='btnPerformActivityGenerationTask']")
	private WebElement btnPerformActivityGenerationTask;

	@FindBy(xpath = "//button[@id='btnPlanningSignOff']")
	private WebElement btnPlanningSignOff;
	//@FindBy(xpath = "//input[@id='dtActivityGenPlanning']")
	//private WebElement dtActivityGenPlanning;
	//@FindBy(xpath = "//span[@id='select2-cmbActivityGenShiftBand-container']")
	//private WebElement cmbActivityGenShiftBand;
	//@FindBy(xpath = "//button[@id='btnPerformActivityGenerationTask']")
	//private WebElement btnPerformActivityGenerationTask;

	@FindBy(xpath = "//div[contains(text(),'Sign off process completed successfully for Shiftband  Between')]")
	private WebElement SignOffProcessCompletedSuccessfullyForShiftbandMsg;

	public E10_3147_WorkloadPlannerPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void enterPlanning(String planning) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement planningElement = wait.until(ExpectedConditions.elementToBeClickable(dtPlanning));
			planningElement.clear();
			planningElement.sendKeys(planning);
			planningElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	public void selectShiftBandType(String bandType) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement bandTypeElement = wait.until(ExpectedConditions.elementToBeClickable(selectShiftBandType));
			bandTypeElement.clear();
			bandTypeElement.sendKeys(bandType);
			bandTypeElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	//	public void chooseShiftBandOption() {
	//		shiftBandOption.click();	
	//	}
	public void clickSearchDailyPlanning() {
		//	webUtility.ElementClickable(driver, btnSearchDailyPlanning);
		webUtility.doubleClickOnElement(driver, btnSearchDailyPlanning);
		//	btnSearchDailyPlanning.click();
	}
	public void rightClickCentered_Cell() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			List<WebElement> allCells = wait.until(ExpectedConditions.visibilityOfAllElements(centered_Cell));

			for (WebElement cell : allCells) {
				if (cell.getText().isEmpty()) {
					// Scroll the empty cell into view using JavaScript
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
					cell.click();
					webUtility.rightClickOnElement(driver, cell);
					break;
				}
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseHovercreateOption() {
		//		webUtility.ElementClickable(driver, createOption);
		createOption.click();
	}
	public void clickVesselOption() {
		vesselOption.click();
	}
	public void clickEquipmentOption() {
		equipmentOption.click();
	}
	public void clickBtnAddVesselSchedule() {
//		webUtility.ElementClickable(driver, btnAddVesselSchedule);
		webUtility.moveToElement(driver, btnAddVesselSchedule);
		btnAddVesselSchedule.click();
	}

	public void enterVesselName(String VesselName) {
		txtVesselName.clear();
		txtVesselName.sendKeys(VesselName);
	}
	public void enterVesselVisitId(String VesselVisitId) {
		txtVesselVisitId.clear();
		txtVesselVisitId.sendKeys(VesselVisitId);
	}
	public void selectBerth() {
		selectBerth.click();
	}
	public void chooseBerth() {
		chooseBerth.click();
	}
	public void enterNumberOfCranes() {
		txtNumberOfCranes.clear();
		txtNumberOfCranes.sendKeys("2");
	}
	public void selectPriority() {
		webUtility.moveToElement(driver, selectPriority);
		selectPriority.click();
	}
	public void selectHighPriority() {
		webUtility.moveToElement(driver, selectHighPriority);
		selectHighPriority.click();
	}
	public void enterVesselArrivalDate(String VesselArrivalDate) {
		dtVesselArrival.clear();
		dtVesselArrival.sendKeys(VesselArrivalDate);
		dtVesselArrival.sendKeys(Keys.ENTER);
	}
	public void enterVesselArrivalTime(String VesselArrivalTime) {
		vesselArrivalTime.clear();
		vesselArrivalTime.sendKeys(VesselArrivalTime);
		vesselArrivalTime.sendKeys(Keys.ENTER);
	}
	public void enterVesselDepartureDate(String VesselDepartureDate) {
		dtVesselDeparture.clear();
		dtVesselDeparture.sendKeys(VesselDepartureDate);
		dtVesselDeparture.sendKeys(Keys.ENTER);
	}
	public void enterVesselDepartureTime(String VesselDepartureTime) {
		tmVesselDeparture.clear();
		tmVesselDeparture.sendKeys(VesselDepartureTime);
		tmVesselDeparture.sendKeys(Keys.ENTER);
	}
	public void clickBtnSaveVesselSchedule() throws InterruptedException {
		Thread.sleep(5000);
		webUtility.moveToElement(driver, btnSaveVesselSchedule);
		btnSaveVesselSchedule.click();
	}
	public void clickBtnYes() {
		btnYes.click();
	}
	public void clickBtnNo() {
		btnNo.click();
	}

	public void clickCraneOption() {
		craneOption.click();
	}
	public void clickCraneScheduleVesselName() {
		cmbCraneScheduleVesselName.click();
	}
	public void clickChooseCrane() {
		chooseCrane.click();
	}
	public void clickBtnSaveCraneSchedule() throws InterruptedException {
		Thread.sleep(5000);
		webUtility.moveToElement(driver, btnSaveCraneSchedule);
		btnSaveCraneSchedule.click();
	}
	public void getVesselScheduleCreatedSuccessfullyMsg() {
		String actualResult = vesselScheduleCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Vessel Schedule created successfully"));
	}
	public void getCraneScheduleCreatedSuccessfullyMsg() {
		String actualResult = CraneScheduleCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Crane Schedule created successfully"));
	}

	public void clickNotificationPopup(){
		webUtility.moveToElement(driver, notificationPopup);
		notificationPopup.click();
	}
	public void doubleClickEditVesselSchedule() {
		webUtility.ElementClickable(driver, editVesselSchedule);
		webUtility.doubleClickOnElement(driver, editVesselSchedule);
		//	editVesselSchedule.click();
	}
	public void clickbtnDelVesselSchedule() {
		webUtility.moveToElement(driver, btnDelVesselSchedule);
		btnDelVesselSchedule.click();
	}
	public void getvesselScheduleDeletedSuccessfullyMsg() {
		String actualResult = vesselScheduleDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Vessel Schedule deleted successfully"));
	}
	public void clickBtnChangeButton() {
		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		webUtility.moveToElement(driver, btnChangeButton);
		btnChangeButton.click();
	}
	public void clickBtnTimeLineView() {
		btnTimeLineView.click();
	}
	public void clickBtnTableView() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait until the button is clickable
		WebElement tableViewButton = wait.until(ExpectedConditions.elementToBeClickable(btnTableView));

		// Click the button
		tableViewButton.click();
		//		btnTableView.click();
	}

	public void clickVesselScheduleEdit() {
		webUtility.ElementClickable(driver, vesselScheduleEdit);
		vesselScheduleEdit.click();
	}
	public void clickBtnAddEquipmentSchedule() {
		webUtility.moveToElement(driver, btnAddEquipmentSchedule);
		btnAddEquipmentSchedule.click();
	}
	public void clickEquipSchdCraneNumber() {
		cmbEquipSchdCraneNumber.click();
	}
	public void selectCraneNumber() {
		selectCraneNumber.click();
	}
	public void pressBtnAddEquipmentType() {
		btnAddEquipmentType.click();
	}
	public void clickEquipmentType() {
		cmbEquipmentType.click();
	}
	public void selectEquipmentType() {
		selectEquipmentType.click();
	}
	public void enterTxtRequirement() {
		txtRequirement.sendKeys("1");
	}
	public void clickBtnGetEquipments() {
		btnGetEquipments.click();
	}
	public void clickBtnSaveEquipmentSchedule() {
		btnSaveEquipmentSchedule.click();
	}


	public void selectAllCheckboxVessel() {
		//		webUtility.moveToElement(driver, selectAllCheckboxVessel);
		selectAllCheckboxVessel.click();
	}
	public void performDeleteAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteVesselSchedule);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	public void deleteRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;

		// Iterate through rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
				//					scrollAndClick(driver, checkbox);
				checkbox.click();
				performDeleteAction();
				checkboxFound = true;
				break;
			}
		}
	}
	public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		element.click();
	}
	public void clickBtnDeleteVesselSchedule() {
		btnDeleteVesselSchedule.click();
	}
	public void clickBtnDeleteCraneSchedule() {
		btnDeleteCraneSchedule.click();
	}
	public void getCraneScheduleDeletedSuccessfullyMsg() { 
		String actualResult = CraneScheduleDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Crane Schedule deleted successfully"));
	}
	public void clickBtnEquipmentsMatrix() {
		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		webUtility.ElementClickable(driver, btnEquipmentsMatrix);
		btnEquipmentsMatrix.click();
	}
	public void enterActivityGenPlanning(String GenPlanning) {
		dtActivityGenPlanning.clear();
		dtActivityGenPlanning.sendKeys(GenPlanning);
		dtActivityGenPlanning.sendKeys(Keys.ENTER);
	}
	public void clickActivityGenShiftBand() {
		cmbActivityGenShiftBand.click();
	}
	public void enterSearchShiftBand() {
		searchShiftBand.sendKeys("Am");
		searchShiftBand.sendKeys(Keys.ENTER);
	}
	public void clickEquipmentRequirementMatrixTemplate() {
		webUtility.ElementClickable(driver, equipmentRequirementMatrixTemplate);
		equipmentRequirementMatrixTemplate.click();
	}
	public void chooseEquipmentRequirement() {
		selectEquipmentRequirement.click();
	}
	public void pressBtnPerformActivityGenerationTask() {
		btnPerformActivityGenerationTask.click();
	}
	public void pressBtnPlanningSignOff() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
		btnPlanningSignOff.click();
	}
	public void getSignOffProcessCompletedSuccessfullyForShiftbandMsg() { 
		String actualResult = SignOffProcessCompletedSuccessfullyForShiftbandMsg.getText();
		Assert.assertTrue(actualResult.contains("Sign off process completed successfully for Shiftband  Between"));
	}

	public void E10_3154_CreateVesselSchedule(FakeEmployee fakeEmployee) throws InterruptedException{
		Thread.sleep(5000);
		clickBtnChangeButton();
		//		clickBtnTableView();
		clickBtnTimeLineView();
		Thread.sleep(5000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("Am");
		Thread.sleep(1000);
		clickSearchDailyPlanning();
		Thread.sleep(5000);
		rightClickCentered_Cell();
		//		Thread.sleep(2000);
		mouseHovercreateOption();
		//		Thread.sleep(2000);
		clickVesselOption();
		enterVesselName(fakeEmployee.getTxtVesselName());
		enterVesselVisitId(fakeEmployee.getTxtVesselVisitId());
		selectBerth();
		chooseBerth();
		enterNumberOfCranes();
		Thread.sleep(2000);
		selectPriority();
		selectHighPriority();
		//		enterVesselArrivalDate(fakeEmployee.getDtVesselArrival());
		//		enterVesselArrivalTime(fakeEmployee.getVesselArrivalTime());
		//		enterVesselDepartureDate(fakeEmployee.getDtVesselDeparture());
		//		enterVesselDepartureTime(fakeEmployee.getTmVesselDeparture());
		clickBtnSaveVesselSchedule();
		//		getVesselScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();
		clickBtnYes();
		//		clickBtnNo();
		clickCraneScheduleVesselName();
		clickChooseCrane();
		clickBtnSaveCraneSchedule();
		//		getCraneScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void E10_3211_CreateVesselScheduleTableView(FakeEmployee fakeEmployee) throws InterruptedException {
		Thread.sleep(10000);
		clickBtnChangeButton();
		clickBtnTableView();
		Thread.sleep(5000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("Am");
		Thread.sleep(1000);
		clickSearchDailyPlanning();
		Thread.sleep(7000);
		clickBtnAddVesselSchedule();

		enterVesselName(fakeEmployee.getTxtVesselName());
		enterVesselVisitId(fakeEmployee.getTxtVesselVisitId());
		selectBerth();
		chooseBerth();
		enterNumberOfCranes();
		Thread.sleep(2000);
		selectPriority();
		selectHighPriority();
		clickBtnSaveVesselSchedule();
		//		getVesselScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();
		clickBtnYes();
		clickCraneScheduleVesselName();
		clickChooseCrane();
		clickBtnSaveCraneSchedule();
		//		getCraneScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();
		Thread.sleep(5000);

		clickBtnAddEquipmentSchedule();
		clickEquipSchdCraneNumber();
		selectCraneNumber();
		Thread.sleep(5000);
		pressBtnAddEquipmentType();
		clickEquipmentType();
		selectEquipmentType();
		enterTxtRequirement();
		Thread.sleep(2000);
		clickBtnGetEquipments();
		clickBtnSaveEquipmentSchedule();
		clickNotificationPopup();
	}
	public void E10_3173_UpdateVesselSchedule(FakeEmployee fakeEmployee) throws InterruptedException {
		Thread.sleep(5000);
		clickBtnChangeButton();
		clickBtnTableView();
		Thread.sleep(10000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("Am");
		Thread.sleep(5000);
		clickVesselScheduleEdit();
		Thread.sleep(5000);
		enterVesselVisitId(fakeEmployee.getTxtVesselVisitId());
		Thread.sleep(2000);
		clickBtnSaveVesselSchedule();
	}
	public void E10_3174_DeleteVesselSchedule(FakeEmployee fakeEmployee) throws InterruptedException {
		Thread.sleep(5000);
		clickBtnChangeButton();
		clickBtnTableView();
		Thread.sleep(10000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("Am");
		Thread.sleep(1000);
		clickSearchDailyPlanning();
		Thread.sleep(10000);
		deleteRowsWithEnabledCheckbox();
		clickBtnYes();
		clickNotificationPopup();
	}



	public void E10_3175_CreateCraneSchedule(FakeEmployee fakeEmployee) throws InterruptedException {
		Thread.sleep(5000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("PM");
		//		chooseShiftBandOption();
		clickSearchDailyPlanning();
		Thread.sleep(5000);
		rightClickCentered_Cell();
		//		clickIfEmpty(driver);
		Thread.sleep(2000);
		mouseHovercreateOption();
		//		Thread.sleep(2000);
		clickCraneOption();
		clickCraneScheduleVesselName();
		clickChooseCrane();


		clickBtnSaveCraneSchedule();
		getCraneScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void E10_3178_CreateEquipmentSchedule(FakeEmployee fakeEmployee) throws InterruptedException {
		Thread.sleep(5000);
		clickBtnChangeButton();
		//		clickBtnTableView();
		clickBtnTimeLineView();
		Thread.sleep(5000);
		enterPlanning(fakeEmployee.getDtPlanning());
		selectShiftBandType("Am");
		Thread.sleep(1000);
		clickSearchDailyPlanning();
		Thread.sleep(5000);
		rightClickCentered_Cell();
		//		Thread.sleep(2000);
		mouseHovercreateOption();
		//		Thread.sleep(2000);
		clickEquipmentOption();
	}

	public void E10_3181_GenerateEquipments(FakeEmployee fakeEmployee) throws InterruptedException{
		//		Thread.sleep(5000);
		//		clickBtnChangeButton();
		//		clickBtnTableView();
		Thread.sleep(5000);
		clickBtnEquipmentsMatrix();
		Thread.sleep(5000);
		clickActivityGenShiftBand();
		enterSearchShiftBand();
		Thread.sleep(2000);
		enterActivityGenPlanning(fakeEmployee.getDtPlanning());
		Thread.sleep(5000);
		clickEquipmentRequirementMatrixTemplate();
		chooseEquipmentRequirement();

		pressBtnPerformActivityGenerationTask();

	}

	public void E10_3182_PlanningSignoff(FakeEmployee fakeEmployee) throws InterruptedException{
		Thread.sleep(5000);
		pressBtnPlanningSignOff();

		clickActivityGenShiftBand();
		enterSearchShiftBand();
		Thread.sleep(2000);
		enterActivityGenPlanning(fakeEmployee.getDtPlanning());
		clickEquipmentRequirementMatrixTemplate();
		chooseEquipmentRequirement();
		pressBtnPerformActivityGenerationTask();
	}
}
