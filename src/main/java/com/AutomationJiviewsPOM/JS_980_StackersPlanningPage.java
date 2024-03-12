package com.AutomationJiviewsPOM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
<<<<<<< HEAD
=======
import org.openqa.selenium.interactions.Actions;
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.WebUtilities;

public class JS_980_StackersPlanningPage {
<<<<<<< HEAD
	WebDriver driver;
=======
	
	public WebDriver driver;
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	public WebUtilities webUtility;
	public Select select;



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
<<<<<<< HEAD

=======
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	@FindBy(xpath = "//div[text()='Workforce Execution']/..")
	WebElement workforceExecution;


	//li[@data-menu-link='Planning/DailyPlanning/StackersPlanning']
<<<<<<< HEAD
	@FindBy(xpath = "//ul[@class='sidenav-menu']/li/a/div[text()='Stackers Planning']")
=======
	@FindBy(xpath = "//ul[@class='sidenav-menu']/li/a/div[text()='Stackers Planning']") 
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	WebElement StackersPlanning;

	@FindBy(xpath = "//input[@id='dtPlanning']")
	WebElement dtPlanning;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[10]")
	WebElement chooseDate;
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	WebElement cmbShiftBand;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectResult;

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--multiple']")
	WebElement equipmentType;

	@FindBy(xpath = "//button[@id='btnSearchStackersPlanning']")
	WebElement btnSearchStackersPlanning;


	@FindBy(xpath = "//button[@id='btnAddStackerPlanning']")
<<<<<<< HEAD
	WebElement btnAddStackerPlanning;
=======
	WebElement btnAddStackerPlanning; 
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	//	@FindBy(xpath = "//input[@id='dtPlanning']")
	//	WebElement dtPlanning;
	//	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	//	WebElement cmbShiftBand;
	@FindBy(xpath = "//span[@id='select2-cmbEquipmentTypeName-container']")
	WebElement cmbEquipmentTypeName;

<<<<<<< HEAD
	// Available Stacker table
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableStacker;

	// select for single Arrow -> move RTG from available RTG table to Selected RTG table
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle;

	//		select for move multiple RTG from available RTG table to Selected RTG table
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	// here it will select a RTG from Seleceted RTG Table
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement selectedStacker;

	//	select for move single RTG from Selected RTG table to Available RTG table
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	private WebElement removeSelectedStackerSingle;

	//	select for move multiple skill from Selected skill table to Available RTG table
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	private WebElement removeSelectedStacker_All;


=======
	// Available Stacker table 
		@FindBy(xpath = "(//select[@class='form-control'])[1]")
		private WebElement availableStacker;

		// select for single Arrow -> move RTG from available RTG table to Selected RTG table 
		@FindBy(xpath = "//button[@class='btn move btn-default']")
		private WebElement selectMoveSingle; 

		//		select for move multiple RTG from available RTG table to Selected RTG table 
		@FindBy(xpath = "//button[@class='btn moveall btn-default']")
		private WebElement selectMoveAll;

		// here it will select a RTG from Seleceted RTG Table 
		@FindBy(xpath = "(//select[@class='form-control'])[2]")
		private WebElement selectedStacker;

		//	select for move single RTG from Selected RTG table to Available RTG table 
		@FindBy(xpath = "//button[@class='btn remove btn-default']")
		private WebElement removeSelectedStackerSingle;

		//	select for move multiple skill from Selected skill table to Available RTG table 
		@FindBy(xpath = "//button[@class='btn removeall btn-default']")
		private WebElement removeSelectedStacker_All;

		
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	@FindBy(xpath = "//button[@id='btnSaveStackersPlanning']")
	WebElement btnSaveStackersPlanning;

	@FindBy(xpath = "//button[@id='btnCloseStackersPlanning']")
	WebElement btnCloseStackersPlanning;

<<<<<<< HEAD

=======
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	@FindBy(xpath = "//a[text()='Equipment Summary']")
	WebElement textEquipmentSummary;
	@FindBy(xpath = "//a[text()='Skill Summary']")
	WebElement textSkillSummary;

<<<<<<< HEAD


=======
	
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	@FindBy(xpath = "//button[@id='btnPlanningSignOff']")
	WebElement btnPlanningSignOff;
	@FindBy(xpath = "//input[@id='dtActivityGenPlanning']")
	WebElement dtActivityGenPlanning;
<<<<<<< HEAD





=======
	
	
	
	
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
	public JS_980_StackersPlanningPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.webUtility= new WebUtilities(driver);
<<<<<<< HEAD

=======
		
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
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
<<<<<<< HEAD
			webUtility.ElementClickable(driver, OLMop);
			OLMop.click();
=======
			webUtility.ElementClickable(driver, OLMop); 
			OLMop.click(); 
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
		}
	}

	public void selectMainMenu() {
		webUtility.ElementClickable(driver, mainMenu);
		mainMenu.click();
	}
	public void selectOperationPlanningExecution() {
		selectOperationPlanningExecution.click();
	}
<<<<<<< HEAD

=======
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19

	public void selectAvailableShiftBand() {
		select = new Select(availableStacker);
		select.selectByIndex(0);
	}

	public void moveSingleAvailableSkillToSelected() {
		selectMoveSingle.click();
	}

	public void moveAllAvailableSkillsToSelected() {
		selectMoveAll.click();
	}

	public void clickSelectedSkill() {
		selectedStacker.click();
	}
<<<<<<< HEAD




=======
	
	
	
	
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19

	public void JS_981_Search() throws Exception {
		selectOrgUnit();
		selectOLMop();
		selectMainMenu();
		selectOperationPlanningExecution();
<<<<<<< HEAD

//		Thread.sleep(5000);
//		workloadPlanning.click();

=======
		
		Thread.sleep(5000);
		workloadPlanning.click();

		Thread.sleep(2000);
		workforceExecution.click();
		
		Thread.sleep(2000);
		workloadPlanning.click();
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19


		Thread.sleep(5000);
		StackersPlanning.click();
<<<<<<< HEAD

=======
		
>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
		Thread.sleep(5000);
		dtPlanning.click();
		chooseDate.click();

		cmbShiftBand.click();
		selectResult.click();
		equipmentType.isDisplayed();

		btnSearchStackersPlanning.click();
	}	

<<<<<<< HEAD
	public void JS_982_AddStackers() throws InterruptedException {
		Thread.sleep(5000);
=======
	public void JS_982_AddStackers() {

>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
		btnAddStackerPlanning.click();
		dtPlanning.isDisplayed();
		cmbShiftBand.isDisplayed();
		cmbEquipmentTypeName.isDisplayed();
<<<<<<< HEAD

		selectAvailableShiftBand();
		moveSingleAvailableSkillToSelected();

		btnCloseStackersPlanning.isDisplayed();
		btnSaveStackersPlanning.click();
		Thread.sleep(5000);
	}



=======
		
		selectAvailableShiftBand();
		moveSingleAvailableSkillToSelected();
		
		btnCloseStackersPlanning.isDisplayed();
		btnSaveStackersPlanning.click();
	}


>>>>>>> 3b832536dba7a98e260f532249f5242e31160e19
}
