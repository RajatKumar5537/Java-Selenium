package com.AutomationJiviewsPOM;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationJiviewsGeneric.BaseClass;
import com.jivi.auto.pageobjectutils.MouseHandler;
import com.jivi.auto.pageobjectutils.WebElementKeys;

public class MenuNavigation extends BaseClass {

	WebElementKeys webAction = new WebElementKeys();
	MouseHandler handler=new MouseHandler();
	
	@FindBy(xpath="//*[@id='dvOrgUnitDropdown']/a/i")
	WebElement olm;
	
	@FindBy(xpath="(//*[contains(@class,'dvGlobalOrganizationUnitTreeView')])[2]")
	WebElement olmLinkESS;
	
	@FindBy(xpath="(//*[contains(@class,'dvGlobalOrganizationUnitTreeView')])[4]")
	WebElement olmLink;
	
	@FindBy(xpath="//*[text()=\"Demo\"]")
	WebElement demo;
	
	@FindBy(id = "dvOrgUnitDropdown")
	WebElement siteMap;

	@FindBy(id = "dvApplicationMenuItems")
	WebElement menuItems;

	@FindBy(xpath = "//span[text()='Operation Planning & Execution']")
	WebElement planningExecutionMenu;
	
	@FindBy(xpath = "//span[text()='Workforce Scheduling']")
	WebElement workforceScheduling;
	
	@FindBy(xpath = "//*[@id='lblSelectedParent']")
	WebElement systemSetup;
	
	@FindBy(xpath = "//span[text()='Employee Self Service']")
	WebElement employeeSelfService;
	

	@FindBy(xpath = "//div[text()='Employee Roster']")
	WebElement employeeRoster;
	
	@FindBy(xpath = "//*[text()='System Definitions']")
	WebElement systemDefinitionsMenu;
	
	@FindBy(id = "102")
	WebElement empAdministration;
	
	
	@FindBy(id= "347")
	WebElement rosterGroupAssnmt;
	
	@FindBy(id= "btnAddRosterGroup")
	WebElement rosterGroupAssnmtAdd;
	
	@FindBy(id= "txtRosterGroupname")
	WebElement rosterGroupName;
	
	@FindBy(id= "txtRosterGroupDesc")
	WebElement rosterGroupDesc;
	
	@FindBy(id= "txtRemarks")
	WebElement rosterGroupRemarks;
	
	@FindBy(id= "btnSaveRosterGroup")
	WebElement rosterGroupSave;
	
	
	
	@FindBy(xpath = "//div[text()='Resource Set Definition']")
	WebElement resourceSetMenu;

	@FindBy(xpath = "//div[text()='Leave Administration']")
	WebElement leaveAdmin;

	@FindBy(xpath = "//div[text()='Roster Setup']")
	WebElement roasterSetup;

	@FindBy(xpath = "//div[text()='Workload Planner']")
	WebElement workLoadPlanner;
	
	@FindBy(xpath = "//div[text()='HSSE Planning']")
	WebElement HSSEPlanning;
	
	@FindBy(xpath = "//div[text()='RTG Planning']")
	WebElement RTGPlanning;
	
	@FindBy(xpath = "//div[text()='Prime Mover Planning']")
	WebElement PMlanning;
	
	@FindBy(xpath = "//div[text()='Stackers Planning']")
	WebElement Stackerslanning;
	
	@FindBy(xpath = "//div[text()='Lashing Deployment']")
	WebElement lashingPlanning;
	
	
	@FindBy(xpath = "//*[@id='217']/a/div")
	WebElement workForceExecution;
	
	@FindBy(xpath = "//div[text()='HSSE Final Booking Report']")
	WebElement hSSEFinalBookingReport;
	
	@FindBy(xpath = "//div[text()='RTG Final Booking Report']")
	WebElement rTGFinalBookingReport;
	
	@FindBy(xpath = "//div[text()='Stackers Final Booking Report']")
	WebElement StackersFinalBookingReport;
	
	@FindBy(xpath = "//div[text()='EFD Planning']")
	WebElement EFDPlanning;
	
	
	@FindBy(xpath = "//div[text()='Shift Band Definition']")
	WebElement shifitBandDefinition;
	
	@FindBy(xpath = "//div[text()='Roster Creation ']")
	WebElement rosterCreation;
	

	@FindBy(xpath = "//div[text()='Leave & Attendance Codes']")
	WebElement leaveAttendanceCode;

	@FindBy(id = "dvLoadingIcon")
	WebElement loadingIcon;

	@FindBy(xpath = "//div[text()='Schedule Creation Rules']")
	WebElement scheduleCreationRule;
	@FindBy(xpath = "//div[text()='Process Administration']")
	WebElement processAdministration;


	@FindBy(xpath = "//span[text()='Time & Attendance']")
	WebElement timeAndAttendance;
	
	@FindBy(xpath = "//div[text()='Attendance Reconciliation']")
	WebElement attendRecon;
	
	public MenuNavigation() throws FileNotFoundException {
		PageFactory.initElements(driver, this);

	}

	public void navigateToSite(String siteName) throws InterruptedException {
		siteMap.click();
		waitforLoadingIcon();
		driver.findElement(By.xpath("//li[text()='" + siteName + "']")).click();
		waitforLoadingIcon();

	}

	public void navigateToResourceSet() throws InterruptedException {
		menuItems.click();
		waitforLoadingIcon();
		planningExecutionMenu.click();
		waitforLoadingIcon();
		resourceSetMenu.click();

	}

	public void navigateToEmployeeRoaster() {
		menuItems.click();
		waitforLoadingIcon();
		workforceScheduling.click();
		waitforLoadingIcon();
		employeeRoster.click();
		waitforLoadingIcon();
	}
	public void navigateToLeaveAdmin() throws InterruptedException {
		menuItems.click();
		waitforLoadingIcon();
		systemDefinitionsMenu.click();
		waitforLoadingIcon();
		leaveAdmin.click();
		waitforLoadingIcon();
		Thread.sleep(200);
		leaveAttendanceCode.click();
	}

	public void navigateToRoasterSetup() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Landed navigateToRoasterSetup Method");
		webAction.clickUsingJavaScript(olm);
		webAction.click(olmLink);
		
		waitforLoadingIcon();
	//	menuItems.click();
		//waitforLoadingIcon();
		webAction.clickUsingJavaScript(systemSetup);
		//Thread.sleep(100);
		//webAction.waitUntilElementIsClickable(systemDefinitionsMenu);
		webAction.clickUsingJavaScript(systemDefinitionsMenu);
		//systemDefinitionsMenu.click();
		waitforLoadingIcon();
		webAction.clickUsingJavaScript(roasterSetup);
		//roasterSetup.click();
		waitforLoadingIcon();
		Thread.sleep(200);
		webAction.clickUsingJavaScript(shifitBandDefinition);
		//shifitBandDefinition.click();
		waitforLoadingIcon();

	}
	
public void navigateToRoasterCreation() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Landed navigateToRoasterCreation Method");
		webAction.clickUsingJavaScript(olm);
		webAction.click(olmLink);
		
		waitforLoadingIcon();
	//	menuItems.click();
		//waitforLoadingIcon();
		webAction.clickUsingJavaScript(systemSetup);
		//Thread.sleep(100);
		//webAction.waitUntilElementIsClickable(systemDefinitionsMenu);
		webAction.clickUsingJavaScript(systemDefinitionsMenu);
		//systemDefinitionsMenu.click();
		waitforLoadingIcon();
		roasterSetup.click();
		waitforLoadingIcon();
		Thread.sleep(200);
		rosterCreation.click();
		waitforLoadingIcon();

	}
	
public void navigateToRoasterGroupAssignment() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Landed To Roaster Group Assignment Method");
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		waitforLoadingIcon();
	//	menuItems.click();
		//waitforLoadingIcon();
		webAction.clickUsingJavaScript(systemSetup);
		//Thread.sleep(100);
		//webAction.waitUntilElementIsClickable(systemDefinitionsMenu);
		Thread.sleep(500);
		webAction.scrollIntoeEement(empAdministration);
		webAction.clickUsingJavaScript(empAdministration);
		//systemDefinitionsMenu.clickwaitforLoadingIcon();
		webAction.clickUsingJavaScript(rosterGroupAssnmt);
		waitforLoadingIcon();

	}


	public void navigateToWorkLoadPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(workLoadPlanner);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToHSSEPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(HSSEPlanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToRTGPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(RTGPlanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToPMPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(PMlanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToStackersPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(Stackerslanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToLashingPLanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(lashingPlanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	
	public void navigateToHSSEFinalBookingReport() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(workForceExecution);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(hSSEFinalBookingReport);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToPMFinalBookingReport() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(workForceExecution);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(rTGFinalBookingReport);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	
	public void navigateToRTGFinalBookingReport() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(workForceExecution);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(rTGFinalBookingReport);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToStackersFinalBookingReport() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(workForceExecution);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(StackersFinalBookingReport);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToEFDPlanning() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(planningExecutionMenu);
		Thread.sleep(500);
	
		webAction.clickUsingJavaScript(EFDPlanning);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	public void navigateToTimeAndAttendance() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(timeAndAttendance);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(attendRecon);
		waitforLoadingIcon();
		Thread.sleep(10000);
	}
	
	
	public void navigateToProcessAdministration() throws InterruptedException {
		menuItems.click();
		waitforLoadingIcon();
		systemSetup.click();
		waitforLoadingIcon();
		processAdministration.click();
		waitforLoadingIcon();

	}
	public void navigateToScheduleCreateionRule() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Landed navigateToScheduleCreateionRule Method");
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(2000);
	//	menuItems.click();
		//waitforLoadingIcon();
		webAction.clickUsingJavaScript(systemSetup);
		//Thread.sleep(100);
		//webAction.waitUntilElementIsClickable(systemDefinitionsMenu);
		webAction.clickUsingJavaScript(systemDefinitionsMenu);
		waitforLoadingIcon();
		webAction.clickUsingJavaScript(roasterSetup);
		//roasterSetup.click();
		waitforLoadingIcon();
		webAction.clickUsingJavaScript(scheduleCreationRule);
		//scheduleCreationRule.click();
		waitforLoadingIcon();
	}

	public void waitforLoadingIcon() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 30);
		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dvLoadingIcon")));
		} catch (Exception e) {

		}
	}
	
	public void navigateToOLMSelfServiceEmployee() throws Exception {
		Thread.sleep(3000);
		webAction.clickUsingJavaScript(olm);
		Thread.sleep(2000);
		webAction.clickUsingJavaScript(olmLinkESS);
		
		Thread.sleep(5000);
	}
	
	public void navigateToESSAdmin() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
		webAction.clickUsingJavaScript(employeeSelfService);
		Thread.sleep(10000);
	}
	
	
	public void navigateToESSAdminReject() throws Exception {
		webAction.clickUsingJavaScript(olm);
		webAction.clickUsingJavaScript(olmLink);
		
		Thread.sleep(500);
		webAction.clickUsingJavaScript(systemSetup);
		Thread.sleep(500);
	//	webAction.clickUsingJavaScript(employeeSelfService);
		Thread.sleep(10000);
		
		
		
	}
	
	
}
