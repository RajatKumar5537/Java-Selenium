package com.AutomationJiviewsPOM;

import java.time.Duration;
import org.openqa.selenium.By;
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
import com.github.javafaker.Faker;

public class E10_3539_RTG_FinalBookingPage {


	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String berthName;
	public WebDriver driver;
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
	private WebElement workforceExecution;

	@FindBy(xpath = "//li[@data-menu-link='Operations/FinalBookingReport/RTGFinalBookingReport']")
	private WebElement RTGFinalBookingReport;
	@FindBy(xpath = "//input[@id='dtOperation']")
	private WebElement dtOperation;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[5]")
	private WebElement calender;

	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	private WebElement shiftBand;
	//	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']") 
	@FindBy(xpath = "(//ul[@class='select2-results__options']/li)[1]")  
	private WebElement searchBar;
	@FindBy(xpath = "//button[@id='btnSearch']")
	private WebElement btnSearch;

//	Search by ......................
	
	@FindBy(xpath = "//label[@class='custom-control custom-checkbox m-0']/span[text()='Show Standby Employees']")
	private WebElement showStandbyEmployees;

	@FindBy(xpath = "//label[@class='custom-control custom-checkbox m-0']/span[text()='Non Primary Skill Deployed Employee']")
	private WebElement chkNonPrimarySkillDeployedEmployee;
	@FindBy(xpath = "//label[@class='custom-control custom-checkbox m-0']/span[text()='Unallocated Work']")
	private WebElement chkUnallocatedWork;
	@FindBy(xpath = "//label[@class='custom-control custom-checkbox m-0']/span[text()='OnCall List']")
	private WebElement chkOnCallList;

	//	Deployment ................. 

	@FindBy(xpath = "(//div[@class='demo-inline-spacing']/div/button)[1]")    //button[@class='btn btn-info btn-round icon-btn dropdown-toggle hide-arrow']
	private WebElement btnDeployment; 
	@FindBy(xpath = "//div/a[@id='btnDeploy']")
	private WebElement btnDeploy;
	@FindBy(xpath = "//input[@id='dtDeployment']")
	private WebElement dtDeployment; 
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[9]")
	private WebElement calenderDeployment;


	@FindBy(id = "select2-cmbDeploymentShiftBand-container")
	private WebElement cmbDeploymentShiftBand;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement shiftBandSearch;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG_AM1']")
	private WebElement selectShiftBand;
	@FindBy(id = "select2-cmbAllocationRule-container")
	private WebElement cmbAllocationRule;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG Deployment - RTG Deployment']")
	private WebElement selectAllocationRule;
	@FindBy(xpath="//button[@class='btn btn-secondary btn-round icon-btn']")
	private WebElement btnCancel;
	@FindBy(xpath = "//button[@id='btnBeginDeploy']")
	private WebElement btnSaveDeploy; 

	@FindBy(xpath = "(//table[@id='final-Booking-Report-list']/tbody/tr/td)[1]")
	private WebElement finalBookingReportlist ;

	// Revoke Planning SignOff.......................

	@FindBy(xpath = "//a[@id='btnRevokePlanningSignOff']")
	WebElement btnRevokePlanningSignOff;
	@FindBy(xpath = "//input[@id='dtActivityGenPlanning']")
	WebElement dtActivityGenPlanning;
	@FindBy(xpath = "//span[@id='select2-cmbActivityGenShiftBand-container']")
	WebElement cmbActivityGenShiftBand;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG_AM1']")
	WebElement chooseRTG_AM1;
	@FindBy(xpath = "//input[@id='txtActivityGenStartDate']")
	WebElement txtActivityGenStartDate;
	@FindBy(xpath = "//input[@id='txtActivityGenEndDate']")
	WebElement txtActivityGenEndDate;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement selectEquipmentType;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG']")
	WebElement chooseRTG;

	@FindBy(xpath = "//button[@id='btnPerformActivityGenerationTask']")
	WebElement btnPerformActivityGenerationTask;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[10]")
	WebElement cancleRevokeSignOff;

	// Broadcast Deployment ..............................

	@FindBy(xpath = "//div/a[@id='btnBroadcastDeployment']")
	WebElement btnBroadcastDeployment;
	@FindBy(xpath = "//input[@id='dtBroadcast']")
	WebElement dtBroadcast;
	@FindBy(xpath = "//span[@id='select2-cmbBroadcastShiftBand-container']")
	WebElement cmbBroadcastShiftBand;
	@FindBy(xpath = "//input[@id='txtBroadcastStartDate']")
	WebElement txtBroadcastStartDate;
	@FindBy(xpath = "//input[@id='txtBroadcastEndDate']")
	WebElement txtBroadcastEndDate;
	@FindBy(xpath = "//button[@id='btnStartBroadcastDeployment']")
	WebElement saveBroadcastDeployment;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[16]")
	WebElement cancleBroadcastDeployment;

	//	Execution ............

	@FindBy(xpath = "(//div[@class='demo-inline-spacing']/div/button)[2]")
	WebElement btnExecution;

	@FindBy(xpath = "//div/a[@id='btnSwapTask']")
	WebElement btnSwapEmployeeAllocation;
	@FindBy(xpath = "//span/span[@id='select2-cmbSwapFromEmployee-container']")
	WebElement cmbSwapFromEmployee;
	@FindBy(xpath = "//select[@id='cmbSwapToEmployee']")
	WebElement cmbSwapToEmployee;
	@FindBy(xpath = "(//span[text()='Show Standby Employees'])[1]")
	WebElement checkBox;

	@FindBy(xpath = "//button[@id='btnConfirmEmployeeSwap']")
	WebElement btnConfirmEmployeeSwap;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[14]")
	WebElement btnCancleEmployeeSwap;

	//	Add Equipments .............................

	@FindBy(xpath = "//div/a[@id='btnAddEquipments']")
	WebElement btnAddEquipments;

	@FindBy(xpath = "//span[@id='select2-cmbEquipSchdCraneNumber-container']")
	WebElement cmbEquipSchdCraneNumber;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement chooseCrane;
	@FindBy(xpath = "//input[@id='txtCraneStartDate']")
	WebElement txtCraneStartDate;
	@FindBy(xpath = "//input[@id='txtCraneEndDate']")
	WebElement txtCraneEndDate;

	@FindBy(xpath = "//button[@id='btnAddEquipmentType']")
	WebElement btnAddEquipmentType;
	@FindBy(xpath = "//span[@id='select2-cmbEquipmentType1-container']" )
	WebElement cmbEquipmentType;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='RTG']")
	WebElement chooseEquipmentType;
	@FindBy(xpath = "//input[@id='txtRequirement1']")
	WebElement txtRequirement;
	@FindBy(xpath = "//input[@id='dtEquipmentTypeStartDate1']")
	WebElement dtEquipmentTypeStartDate;
	@FindBy(xpath = "//input[@id='dtEquipmentTypeStartTime1']")
	WebElement dtEquipmentTypeStartTime;
	@FindBy(xpath = "//input[@id='dtEquipmentTypeEndDate1']")
	WebElement dtEquipmentTypeEndDate;
	@FindBy(xpath = "//input[@id='dtEquipmentTypeEndTime1']")
	WebElement dtEquipmentTypeEndTime;
	@FindBy(xpath = "//button[@id='btnSaveEquipmentSchedule']")
	WebElement btnSaveEquipmentSchedule;

	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[12]")
	WebElement btnCancleEquipmentSchedule;


	// Add Multiple Workloads ...................

	@FindBy(xpath = "//div/a[@id='btnAddMultipleWorkloads']")
	WebElement btnAddMultipleWorkloads;

	@FindBy(xpath = "//span[@id='select2-cmbAuxiliaryWorkMultipleSkillsShiftBand-container']")
	WebElement cmbAuxiliaryWorkMultipleSkillsShiftBand;
	@FindBy(xpath = "//input[@id='txtAuxWorkShiftBandStartTime']")
	WebElement txtAuxWorkShiftBandStartTime;
	@FindBy(xpath = "//input[@id='txtAuxWorkShiftBandEndTime']")
	WebElement txtAuxWorkShiftBandEndTime;

	@FindBy(xpath = "//button[@id='btnAddAuxWorkSkills']")
	WebElement btnAddAuxWorkSkills;
	@FindBy(xpath = "//span[@id='select2-cmbAuxWorkMultipleSkill1-container']")
	WebElement cmbAuxWorkMultipleSkill1;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement searchField;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectSkill;
	
	@FindBy(xpath = "//input[@id='txtAuxWorkSkillRequirement1']")
	WebElement txtAuxWorkSkillRequirement;
	@FindBy(xpath = "//input[@id='dtAuxWorkSkillScheduleStartDate1']")
	WebElement dtAuxWorkSkillScheduleStartDate;
	@FindBy(xpath = "//input[@id='dtAuxWorkSkillScheduleStartTime1']")
	WebElement dtAuxWorkSkillScheduleStartTime;
	@FindBy(xpath = "//input[@id='dtAuxWorkSkillScheduleEndDate1']")
	WebElement dtAuxWorkSkillScheduleEndDate;
	@FindBy(xpath = "//input[@id='dtAuxWorkSkillScheduleEndTime1']")
	WebElement dtAuxWorkSkillScheduleEndTime;
	@FindBy(xpath = "//button[@id='btnSaveAuxWorkSkills']")
	WebElement btnSaveAuxWorkSkills;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[9]")
	WebElement btnCancleAuxWorkSkills;

	@FindBy(xpath = "//div[text()='Auxiliary Work Schedule created successfully']")
	WebElement AuxiliaryWorkScheduleCreatedSuccessfullyMsg;
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

//	Swap Employee Shift ...............................
	
	@FindBy(xpath = "//div/a[@id='btnSwapEmployeeShift']")
	WebElement btnSwapEmployeeShift;
	
	@FindBy(xpath = "//input[@id='dtSource']")
	WebElement dtSource;
	@FindBy(xpath = "//span[@id='select2-cmbSourceShiftBand-container']")
	WebElement cmbSourceShiftBand;
	@FindBy(xpath = "//button[@id='btnSourceSearch']")
	WebElement btnSourceSearch;
	@FindBy(xpath = "//select[@id='cmbSourceEmployee']")
	WebElement cmbSourceEmployee;
	@FindBy(xpath = "//input[@id='txtSourceShiftStartEndTime']")
	WebElement txtSourceShiftStartEndTime;
	@FindBy(xpath = "//input[@id='dtTarget']")
	WebElement dtTarget;
	
	@FindBy(xpath = "//span[@id='select2-cmbTargetShiftBand-container']")
	WebElement cmbTargetShiftBand;
	@FindBy(xpath = "//button[@id='btnTargetSearch']")
	WebElement btnTargetSearch;
	@FindBy(xpath = "//select[@id='cmbTargetEmployee']")
	WebElement cmbTargetEmployee;
	@FindBy(xpath = "//input[@id='txtTargetShiftStartEndTime']")
	WebElement txtTargetShiftStartEndTime;
	@FindBy(xpath = "//button[@id='btnConfirmEmployeeSwapShift']")
	WebElement btnConfirmEmployeeSwapShift;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[18]")
	WebElement btnCancleEmployeeSwapShift;
	
	
//	E10_3562_Create Or Assign Task .........................
	
	
	@FindBy(xpath = "//table[@id='final-Booking-Report-list']/tbody/tr/td")
	WebElement RTGFinalBookingReportTable;
	
	@FindBy(xpath = "//button[@id='btnUnAssign']")
	WebElement btnUnAssign;
	@FindBy(xpath = "//button[@id='btnSuggestedEmployees']")
	WebElement btnSuggestedEmployees;
	@FindBy(xpath = "//button[@id='btnSwapActivity']")
	WebElement btnSwapActivity;
	@FindBy(xpath = "//button[@id='btnSaveActivity']")
	WebElement btnSaveActivity;
	@FindBy(xpath = "//button[@id='btnDeleteActivity']")
	WebElement btnDeleteActivity;
	
	@FindBy(xpath = "//div[text()='Employee Number']" )
	WebElement employeeNumber; // we can compare the Emp no from the table and compare with create table 
	@FindBy(xpath = "//div[text()='Employee Name']")
	WebElement employeeName;
	@FindBy(xpath = "//div[text()='Role']")
	WebElement Role;
	@FindBy(xpath = "//div[text()='Shift Band']")
	WebElement shiftBandText;
	@FindBy(xpath = "//div[text()='Actual Start Time']" )
	WebElement ActualStartTime;
	@FindBy(xpath = "//div[text()='Actual End Time']")
	WebElement ActualEndTime;
	
	@FindBy(xpath = "//button[@id='btnAddTask']")
	WebElement btnAddTask;
	@FindBy(xpath = "//span[@id='select2-cmbActivitySkill1-container']" )
	WebElement cmbActivitySkill1;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement skillSearch;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement chooseSkill; 
	
	@FindBy(xpath = "//input[@id='dtActivityStartDate1']")
	WebElement dtActivityStartDate;
	@FindBy(xpath = "//input[@id='dtActivityStartTime1']")
	WebElement dtActivityStartTime;
	@FindBy(xpath = "//input[@id='dtActivityEndDate1']")
	WebElement dtActivityEndDate;
	@FindBy(xpath = "//input[@id='dtActivityEndTime1']")
	WebElement dtActivityEndTime;
	@FindBy(xpath = "//span[@id='select2-cmbActivityEquipment1-container']")
	WebElement cmbActivityEquipment;
	@FindBy(xpath = "//span[@id='select2-cmbActivityLocation1-container']")
	WebElement cmbActivityLocation;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement chooseLocation;
	
	@FindBy(xpath = "//button[@id='btnActivityDel1']")
	WebElement btnActivityDelete;
	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[6]")
	WebElement btnActivityClose;
	
	
	// Equipment & Skill Summary ........
	
	@FindBy(xpath = "//a[text()='Equipment Summary']")
	WebElement equipmentSummary;
	@FindBy(xpath = "//a[text()='Skill Summary']")
	WebElement skillSummary;
	
	public E10_3539_RTG_FinalBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		this.action = new Actions(driver); 
		this.webUtility = new WebUtilities(driver);
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
		} catch (StaleElementReferenceException e) {
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
	public void selectWorkforceExecution() {
		webUtility.ElementClickable(driver, workforceExecution);
		workforceExecution.click();
	}
	public void selectRTGFinalBookingReport() {
		webUtility.ElementClickable(driver, RTGFinalBookingReport);
		RTGFinalBookingReport.click();
	}
	
	public void enterdtOperation() {
		dtOperation.clear();
		dtOperation.isDisplayed();
	}
	public void clickshiftBand() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));
		WebElement shiftBandElement = wait.until(ExpectedConditions.elementToBeClickable(shiftBand));
		shiftBandElement.click();
	}
	public void enterShiftband() {
		webUtility.ElementClickable(driver, searchBar);
		searchBar.click();
	}
	public void clickBtnDeployment() {
		webUtility.ElementClickable(driver, btnDeployment);
		btnDeployment.click();
	}
	public void clickBtnExecution() {
		webUtility.ElementClickable(driver, btnExecution);
		btnExecution.click();
	}

	public void clickBtnDeploy() {
		webUtility.ElementClickable(driver, btnDeploy);
		btnDeploy.click();
	}
	public void pressBtnCancel() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dvDeploymentModalBody")));
		WebElement btnCancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modal-header']/button[@class='close'])[1]")));
		btnCancel.click();
	}
	public void getAuxiliaryWorkScheduleCreatedSuccessfullyMsg() { 
		String actualResult = AuxiliaryWorkScheduleCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Auxiliary Work Schedule created successfully"));

	}
	public void clickNotificationPopup() throws Exception {
		Thread.sleep(1000);
		webUtility.ElementClickable(driver, notificationPopup);
		notificationPopup.click();
	}




	public void E10_3540_SearchRTGFinalBookingReport() throws InterruptedException {
		selectOrgUnit();
		selectOLMop();
		selectMainMenu();
		selectOperationPlanningExecution();
		selectWorkloadPlanning();
		selectWorkforceExecution();
		selectRTGFinalBookingReport();

		Thread.sleep(5000);
		enterdtOperation();
		Thread.sleep(2000);
		calender.click();

		clickshiftBand();
		enterShiftband();

		btnSearch.click();
	}
	public void E10_3547_SearchByShowStandbyEmployees() throws InterruptedException{
		showStandbyEmployees.isDisplayed();
		showStandbyEmployees.isEnabled();

		//		webUtility.ElementClickable(driver, showStandbyEmployees);
		Thread.sleep(5000);
		showStandbyEmployees.click();
		btnSearch.click();

		Thread.sleep(5000);
		showStandbyEmployees.click();
		btnSearch.click();
	}
	public void E10_3548_SearchByNonPrimarySkillDeployedEmployee() throws InterruptedException{

		chkNonPrimarySkillDeployedEmployee.isDisplayed();

		Thread.sleep(5000);

		chkNonPrimarySkillDeployedEmployee.click();
		btnSearch.click();

		Thread.sleep(5000);
		chkNonPrimarySkillDeployedEmployee.click();
		btnSearch.click();
	}
	public void E10_3549_SearchByUnallocatedWork() throws InterruptedException {
		chkUnallocatedWork.isDisplayed();
		Thread.sleep(5000);
		chkUnallocatedWork.click();
		btnSearch.click();

		Thread.sleep(5000);
		chkUnallocatedWork.click();
		btnSearch.click();
	}
	public void E10_3550_SearchByOnCallList() throws InterruptedException {
		chkOnCallList.isDisplayed();
		Thread.sleep(5000);
		chkOnCallList.click();
		btnSearch.click();

		Thread.sleep(5000);
		chkOnCallList.click();
		btnSearch.click();

	}

	public void E10_3551_Deployment() throws InterruptedException {
		Thread.sleep(5000);
		clickBtnDeployment();
		clickBtnDeploy();
		Thread.sleep(2000);
		dtDeployment.isDisplayed();
		cmbDeploymentShiftBand.click();
		selectShiftBand.click();


		cmbAllocationRule.click();
		selectAllocationRule.click();
		btnCancel.isDisplayed();
		btnSaveDeploy.isDisplayed();
		Thread.sleep(3000);
		pressBtnCancel();

		Thread.sleep(3000);
	}

	public void JS_866_RevokeSignOff() throws InterruptedException {

		Thread.sleep(5000);
		clickBtnDeployment();
		webUtility.ElementClickable(driver, btnRevokePlanningSignOff);
		btnRevokePlanningSignOff.click();
		Thread.sleep(3000);
		dtActivityGenPlanning.isDisplayed();
		cmbActivityGenShiftBand.isDisplayed();
		//		chooseRTG_AM1.isDisplayed(); Not required 

		txtActivityGenStartDate.isDisplayed();
		txtActivityGenEndDate.isDisplayed();
//		selectEquipmentType.isDisplayed();
		//		chooseRTG.isDisplayed(); Not required 

		btnPerformActivityGenerationTask.isDisplayed();
		cancleRevokeSignOff.click();
	}

	public void JS_867_BroadcastDeployment() throws InterruptedException {
		Thread.sleep(5000);
		clickBtnDeployment();
		webUtility.ElementClickable(driver, btnBroadcastDeployment);
		btnBroadcastDeployment.click();
		Thread.sleep(3000);
		dtBroadcast.isDisplayed();
		cmbBroadcastShiftBand.isDisplayed();
		txtBroadcastStartDate.isDisplayed();
		txtBroadcastEndDate.isDisplayed();
		saveBroadcastDeployment.isDisplayed();

		cancleBroadcastDeployment.click();
	}

	public void E10_3559_SwapEmployeeAllocation() throws InterruptedException {
		Thread.sleep(5000);
		clickBtnExecution();

		webUtility.ElementClickable(driver, btnSwapEmployeeAllocation);
		btnSwapEmployeeAllocation.click();

		btnSwapEmployeeAllocation.isDisplayed();
		Thread.sleep(5000);
		//		cmbSwapFromEmployee.isDisplayed();

		cmbSwapToEmployee.isDisplayed();
		checkBox.isDisplayed();
		btnConfirmEmployeeSwap.isDisplayed();

		btnCancleEmployeeSwap.click();
	}

	public void E10_3561_AddEquipments() throws InterruptedException{
		Thread.sleep(5000);
		clickBtnExecution();

		webUtility.ElementClickable(driver, btnAddEquipments);
		btnAddEquipments.click();


		Thread.sleep(5000);
		cmbEquipSchdCraneNumber.click();
		chooseCrane.click();
		txtCraneStartDate.isDisplayed();
		txtCraneEndDate.isDisplayed();

		btnAddEquipmentType.click();
		cmbEquipmentType.click();
		chooseEquipmentType.click();
		txtRequirement.sendKeys("1");
		dtEquipmentTypeStartDate.isDisplayed();
		dtEquipmentTypeStartTime.isDisplayed();
		dtEquipmentTypeEndDate.isDisplayed();
		dtEquipmentTypeEndTime.isDisplayed();


		// Getting one popup for... Select Activity Generation Rule.......
		btnSaveEquipmentSchedule.isDisplayed();

		btnCancleEquipmentSchedule.click();

	}

	

	public void E10_3563_AddWorkload() throws Exception {
		Thread.sleep(5000);
		clickBtnExecution();

		webUtility.ElementClickable(driver, btnAddMultipleWorkloads);
		btnAddMultipleWorkloads.click();
		Thread.sleep(3000);
		cmbAuxiliaryWorkMultipleSkillsShiftBand.isDisplayed();
		txtAuxWorkShiftBandStartTime.isDisplayed();
		txtAuxWorkShiftBandEndTime.isDisplayed();

		btnAddAuxWorkSkills.click();
		cmbAuxWorkMultipleSkill1.click();
		searchField.sendKeys("RTGO");
		selectSkill.click();
		txtAuxWorkSkillRequirement.isDisplayed();
		dtAuxWorkSkillScheduleStartDate.isDisplayed();
		dtAuxWorkSkillScheduleStartTime.isDisplayed();
		dtAuxWorkSkillScheduleEndDate.isDisplayed();
		dtAuxWorkSkillScheduleEndTime.isDisplayed();

		btnCancleAuxWorkSkills.isDisplayed();
		btnSaveAuxWorkSkills.click();

		getAuxiliaryWorkScheduleCreatedSuccessfullyMsg();
		clickNotificationPopup();

	}

	public void E10_3564_SwapEmployeeShift() throws InterruptedException {
		Thread.sleep(5000);
		clickBtnExecution();

		webUtility.ElementClickable(driver, btnSwapEmployeeShift);
		btnSwapEmployeeShift.click();
		
		
		dtSource.isDisplayed();
		cmbSourceShiftBand.isDisplayed();
		btnSourceSearch.isDisplayed();
		cmbSourceEmployee.isDisplayed();
		txtSourceShiftStartEndTime.isDisplayed();
		dtTarget.isDisplayed();
		cmbTargetShiftBand.isDisplayed();
		btnTargetSearch.isDisplayed();
		cmbTargetEmployee.isDisplayed();
		txtTargetShiftStartEndTime.isDisplayed();
		btnConfirmEmployeeSwapShift.isDisplayed();
		
		btnCancleEmployeeSwapShift.click();
	}
	
	
	public void E10_3562_CreateOrAssignTask() throws InterruptedException{

		Thread.sleep(5000);
		showStandbyEmployees.click();
		btnSearch.click();
		Thread.sleep(5000);
		RTGFinalBookingReportTable.click();
		Thread.sleep(5000);
		
		btnUnAssign.isDisplayed();
		btnSuggestedEmployees.isDisplayed();
		btnSwapActivity.isDisplayed();
		btnSaveActivity.isDisplayed();
		btnDeleteActivity.isDisplayed();
		
		// we can compare the Emp no from the table and compare with create table 
		employeeNumber.isDisplayed();
		employeeName.isDisplayed();
		Role.isDisplayed();
		shiftBandText.isDisplayed();
		ActualStartTime.isDisplayed();
		ActualEndTime.isDisplayed();
		
		btnAddTask.click();
		cmbActivitySkill1.click();
		skillSearch.sendKeys("RTGO");
		chooseSkill.click();
		dtActivityStartDate.isDisplayed();
		dtActivityStartTime.isDisplayed();
		dtActivityEndDate.isDisplayed();
		dtActivityEndTime.isDisplayed();
		cmbActivityEquipment.isDisplayed();
		
		cmbActivityLocation.click();
		chooseLocation.click();
		
//		btnActivityDelete.isDisplayed();
		btnActivityClose.click();
		
		
	}

}
