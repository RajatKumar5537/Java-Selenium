package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.AutomationJiviewsGeneric.WebUtilities;

public class JS_790_PrimeMoverPlanning {

	public Select select;
	public Actions action ;
	WebDriver driver;
	WebUtilities webUtility;
	
	@FindBy(xpath = "//input[@id='dtPlanning']")
	WebElement dtPlanning ;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[16]")
	WebElement calenderTable;
	@FindBy(xpath = "//span[@id='select2-cmbShiftBand-container']")
	WebElement cmbShiftBand;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='1st Shift']")
	WebElement resultShiftBand;
	
	@FindBy(xpath = "//button[@id='btnSearchPMPlanning']")
	WebElement btnSearchPMPlanning;
	 
	// Add  PrimeMoverPlanning
	@FindBy(xpath = "//button[@id='btnAddPrimeMoverPlanning']")
	WebElement btnAddPrimeMoverPlanning;
	

	
	@FindBy(xpath = "//span[@id='select2-cmbActivityGenRule-container']")
	WebElement cmbActivityGenRule;
	@FindBy(xpath = "//ul[@class='select2-results__options']")
	WebElement resultsOptions;
	
	@FindBy(xpath = "//span[@id='select2-cmbAllocationRule-container']")
	WebElement cmbAllocationRule;
	@FindBy(xpath = "//ul[@class='select2-results__options']")
	WebElement resultsAllocationRule;
	
	@FindBy(xpath = "//button[@id='btnAddPrimeMoverSkill']")
	WebElement btnAddPrimeMoverSkill;
	
	@FindBy(xpath = "//span[@id='select2-cmbPrimeMoverSkill1-container']")
	WebElement cmbPrimeMoverSkill1;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='PM']")
	WebElement resultPrimeMoverSkill1;
	
	@FindBy(xpath = "//input[@id='txtPrimeMoverRequirement1']")
	WebElement txtPrimeMoverRequirement1;
	
	// Available Crane table 
		@FindBy(xpath = "(//select[@class='form-control'])[1]")
		private WebElement availableCrane;

		// select for single Arrow -> move RTG from available RTG table to Selected RTG table 
		@FindBy(xpath = "//button[@class='btn move btn-default']")
		private WebElement selectMoveSingle; 

		//		select for move multiple RTG from available RTG table to Selected RTG table 
		@FindBy(xpath = "//button[@class='btn moveall btn-default']")
		private WebElement selectMoveAll;

		@FindBy(className = "toast-close-button")
		private WebElement notificationPopup;
		
		@FindBy(xpath = "//button[@id='btnSavePrimeMoverPlanning']")
		WebElement btnSavePrimeMoverPlanning;
		
		@FindBy(xpath = "//div[text()='Prime Mover Planning Completed Successfully...']")
		WebElement PrimeMoverPlanningCompletedSuccessfullyMsg;
		
		@FindBy(xpath = "//a[text()='Equipment Summary']")
		WebElement EquipmentSummary;
		
		@FindBy(xpath = "//a[text()='Skill Summary']")
		WebElement SkillSummary;
		@FindBy(xpath = "//span[@id='select2-cmbReliefRule-container']")
		WebElement manningRatio;
		@FindBy(xpath = "//ul[@class='select2-results__options']/li[text()='PM Rule']")
		WebElement chooseManningRatio;
		
		public JS_790_PrimeMoverPlanning(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
			
			this.action= new Actions(driver);
			this.webUtility= new WebUtilities(driver);
		}
		
		public void enterPlanning() throws Exception {
			webUtility.visibilityOfElement(driver, dtPlanning);
			Thread.sleep(5000);
			dtPlanning.clear();
			dtPlanning.sendKeys("10/03/2024");
//			dtPlanning.click();
		}
		
		public void selectAvailableShiftBand() {
			action.scrollToElement(availableCrane).perform();
			select = new Select(availableCrane);
			select.selectByIndex(0);
		}

		public void moveSingleAvailableSkillToSelected() {
			action.moveToElement(selectMoveSingle).perform();
			selectMoveSingle.click();
		}
		public void closeNotificationPopup() throws Exception {
			webUtility.visibilityOfElement(driver, notificationPopup);
			notificationPopup.click();
		}
		public void getPrimeMoverPlanningCompletedSuccessfullyMsg() {
			String actualResult = PrimeMoverPlanningCompletedSuccessfullyMsg.getText();
			Assert.assertTrue(actualResult.contains("Prime Mover Planning Completed Successfully..."));

		}
		
		
		
		
		
		
		public void JS_915_SearchRecord () throws Exception {
			Thread.sleep(5000);
			enterPlanning();
//			calenderTable.click();
			
			cmbShiftBand.click();
			resultShiftBand.click();
			
			btnSearchPMPlanning.click();
		}
		
		public void JS_916_AddLocation() throws Exception{
			Thread.sleep(5000);
			webUtility.ElementClickable(driver, btnAddPrimeMoverPlanning);
			btnAddPrimeMoverPlanning.click();
			
			Thread.sleep(2000);
//			dtPlanning.clear();
//			dtPlanning.sendKeys("10/03/2024");
//			calenderTable.click();
			
			Thread.sleep(5000);
			cmbShiftBand.click();
			resultShiftBand.click();
			
			Thread.sleep(3000);
			cmbActivityGenRule.click();
			resultsOptions.click();
			
			Thread.sleep(3000);
			cmbAllocationRule.click();
			resultsAllocationRule.click();
			
			Thread.sleep(3000);
//			webUtility.visibilityOfElement(driver, btnAddPrimeMoverSkill);
//			btnAddPrimeMoverSkill.click();
			
			Thread.sleep(3000);
			cmbPrimeMoverSkill1.click();
			resultPrimeMoverSkill1.click();
			
			Thread.sleep(3000);
			txtPrimeMoverRequirement1.clear();
			txtPrimeMoverRequirement1.sendKeys("1");
			
			Thread.sleep(3000);
			selectAvailableShiftBand();
			moveSingleAvailableSkillToSelected();
			
			Thread.sleep(3000);
			action.moveToElement(btnSavePrimeMoverPlanning).perform();
			btnSavePrimeMoverPlanning.click();
			
			getPrimeMoverPlanningCompletedSuccessfullyMsg();
			closeNotificationPopup();
		}
		
		public void JS_917_VerifyEquipmentSummery() throws InterruptedException {
			Thread.sleep(3000);
			EquipmentSummary.click();
			
		}
		
		public void JS_918_VerifySkillSummery() throws InterruptedException {
			Thread.sleep(3000);
			SkillSummary.click();
			Thread.sleep(5000);
			manningRatio.click();
			chooseManningRatio.click();
		}
}
