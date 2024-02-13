package com.AutomationJiviewsPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationJiviewsGeneric.WebUtilities;
import com.github.javafaker.Faker;

public class E10_3539_OperationPlanningExecutionPage {


	public Select select;
	public Actions action ;
	public Faker fakeData;
	public String berthName;
	WebDriver driver;
	WebUtilities webUtility;

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

	@FindBy(xpath = "//label[@class='custom-control custom-checkbox m-0']/span[text()='Show Standby Employees']")
	private WebElement showStandbyEmployees;

	@FindBy(xpath = "//input[@id='chkNonPrimarySkillDeployedEmployee']")
	private WebElement chkNonPrimarySkillDeployedEmployee;
	@FindBy(xpath = "//input[@id='chkUnallocatedWork']")
	private WebElement chkUnallocatedWork;
	@FindBy(xpath = "//input[@id='chkOnCallList']")
	private WebElement chkOnCallList;

	@FindBy(xpath = "(//div[@class='demo-inline-spacing']/div/button)[1]")//button[@class='btn btn-info btn-round icon-btn dropdown-toggle hide-arrow']
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
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	private WebElement selectAllocationRule;
	@FindBy(xpath="//button[@class='btn btn-secondary btn-round icon-btn']")
	private WebElement btnCancel;
	@FindBy(xpath = "//button[@id='btnBeginDeploy']")
	private WebElement btnSaveDeploy; 

	@FindBy(xpath = "(//table[@id='final-Booking-Report-list']/tbody/tr/td)[1]")
	private WebElement finalBookingReportlist ;

	public E10_3539_OperationPlanningExecutionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver); 
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

		Thread.sleep(5000);
		clickshiftBand();
		Thread.sleep(5000);
		enterShiftband();

		btnSearch.click();

		//		showStandbyEmployees.isDisplayed();
		//		showStandbyEmployees.isEnabled();

		//		chkNonPrimarySkillDeployedEmployee.isDisplayed();

		//		chkUnallocatedWork.isDisplayed();
		//		chkOnCallList.isDisplayed();

		//		clickBtnDeployment();
		//		clickBtnDeploy();
		//		Thread.sleep(5000);
		//		dtDeployment.isDisplayed();
		//		cmbDeploymentShiftBand.click();
		//		selectShiftBand.click();
		//
		//
		//		cmbAllocationRule.click();
		//		selectAllocationRule.click();
		//		btnCancel.isDisplayed();
		//		btnSaveDeploy.isDisplayed();
	}
	public void E10_3547_SearchByShowStandbyEmployees(){
		showStandbyEmployees.isDisplayed();
		showStandbyEmployees.isEnabled();
	}
	public void E10_3548_SearchByNonPrimarySkillDeployedEmployee(){
		chkNonPrimarySkillDeployedEmployee.isDisplayed();
	}
	public void E10_3549_SearchByUnallocatedWork() {
		chkUnallocatedWork.isDisplayed();
	}
	public void E10_3550_SearchByOnCallList() {
		chkOnCallList.isDisplayed();

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

}
