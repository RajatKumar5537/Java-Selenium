package com.AutomationJiviewsPOM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;
//import com.auto.utilities.excelUtilities;
//import com.auto.utilities.excelUtilities;
//import com.auto.utilities.reuableComponents;
import com.github.javafaker.Faker;

public class Roaster extends BaseClass {
	
//	ReusableComponents resusemain = new ReusableComponents();
//	WebElementKeys webAction = new WebElementKeys();
//	DropDown dropdown = new DropDown();
//	MouseHandler handler = new MouseHandler();

	Faker faker = new Faker();
//	 MenuNavigation menuNavigation;
	
	public Roaster() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "btnAddNew")
	WebElement btnAddNew;
	
	@FindBy(id = "txtShtBandName")
	WebElement txtShtBandName;
	
	@FindBy(id = "txtShiftbandDesc")
	WebElement txtShiftbandDesc;
	
	@FindBy(id = "txtShiftBandCode")
	WebElement txtShiftBandCode;
	
	@FindBy(id = "txtColorCode")
	WebElement txtColorCode;
	
	@FindBy(id = "txtShiftCounter")
	WebElement txtShiftCounter;

	@FindBy(xpath = "//span[text()='IsActive?']")
	WebElement chkIsActive;

	@FindBy(xpath = "//span[@aria-labelledby='select2-cmbShiftBandId-container']")
	WebElement ShiftBandList;

	// @FindBy(id = "txtStartTime")
	// WebElement txtStartTime;

	@FindBy(xpath = "//*[@id='txtStartTime']")
	WebElement txtStartTime;

	@FindBy(id = "cmbShiftBandId")
	WebElement shiftBandType;

	@FindBy(id = "txtShiftCounter")
	WebElement shiftCounter;

	@FindBy(id = "txtEndTime")
	WebElement txtEndTime;
	@FindBy(id = "txtStartRangeBegin")
	WebElement txtStartRangeBegin;
	@FindBy(id = "txtStartRangeEnd")
	WebElement txtStartRangeEnd;
	@FindBy(id = "txtEndRangeBegin")
	WebElement txtEndRangeBegin;
	@FindBy(id = "txtEndRangeEnd")
	WebElement txtEndRangeEnd;
	@FindBy(id = "btnSaveshiftbandDtls")
	WebElement btnSaveshiftbandDtls;

	@FindBys(@FindBy(xpath = "//div[text()='Shift Band created successfully']"))
	List<WebElement> txtShiftbandCreate;

	@FindBys(@FindBy(xpath = "//div[text()='Roster Group Created Successfully.']"))
	List<WebElement> txtGroupCreate;

	@FindBys(@FindBy(xpath = "//div[text()='Shift Band updated successfully']"))
	List<WebElement> txtShiftbandEdit;
	@FindBys(@FindBy(xpath = "//div[text()='ShiftBand deleted successfully.']"))
	List<WebElement> txtShiftbandDelete;

	@FindBy(xpath = "//input[@placeholder='Search records']")
	WebElement textSearchColumns;
	@FindBy(xpath = "//button[@data-original-title='Edit']")
	WebElement btnEditShiftband;
	@FindBy(xpath = "//*[@id='shftband-list']/tbody/tr[1]/td[1]/input")
	WebElement chkSelectShiftband;
	@FindBy(id = "btnDeleteshftband")
	WebElement btnDeleteshftband;
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	WebElement btnDeleteshftbandConfirmation;
	@FindBy(id = "btnAddScheduleRule")
	WebElement btnAddScheduleRule;
	@FindBy(id = "txtScheduleRuleName")
	WebElement txtScheduleRuleName;
	@FindBy(id = "txtScheduleRuleDesc")
	WebElement txtScheduleRuleDesc;
	@FindBy(id = "txtValidFrom")
	WebElement txtValidFrom;
	@FindBy(id = "txtPeriodLength")
	WebElement txtPeriodLength;

	@FindBy(xpath = "//input[@id='chkTextBox']//following::span[@class='custom-control-label'][1]")
	// @FindBy(xpath = "//input[@id='chkTextBox']//parent::label")
	// @FindBy(id = "chkTextBox")
	WebElement chkValidTo;
	@FindBy(id = "txtValidTo")
	WebElement txtValidTo;
	@FindBy(id = "txtShiftlengthMin")
	WebElement txtShiftlengthMin;
	@FindBy(id = "txtShiftlengthMax")
	WebElement txtShiftlengthMax;
	@FindBy(id = "txtContDaysScheduleOnMin")
	WebElement txtContDaysScheduleOnMin;
	@FindBy(id = "txtContDaysScheduleOnMax")
	WebElement txtContDaysScheduleOnMax;
	@FindBy(id = "txtDaysPerPeriodMin")
	WebElement txtDaysPerPeriodMin;
	@FindBy(id = "txtDaysPerPeriodMax")
	WebElement txtDaysPerPeriodMax;

	@FindBy(id = "txtContDaysScheduleOffMin")
	WebElement txtContDaysScheduleOffMin;
	@FindBy(id = "txtContDaysScheduleOffMax")
	WebElement txtContDaysScheduleOffMax;
	@FindBy(id = "txtTimePerPeriodMin")
	WebElement txtTimePerPeriodMin;
	@FindBy(id = "txtTimePerPeriodMax")
	WebElement txtTimePerPeriodMax;
	// @FindBy(xpath =
	// "//input[@id='chkTextBox']//following::span[@class='custom-control-label'][1]")
	@FindBy(xpath = "//span[text()='Include Leave']")
	WebElement chkIncludeLeave;

	@FindBy(id = "btnSaveScheduleCreationRule")
	WebElement btnSaveScheduleCreationRule;

	@FindBy(id = "btnAddRosterGroup")
	WebElement rosterGroupAssnmtAdd;

	@FindBy(id = "txtRosterGroupname")
	WebElement rosterGroupName;

	@FindBy(id = "txtRosterGroupDesc")
	WebElement rosterGroupDesc;

	@FindBy(id = "txtRemarks")
	WebElement rosterGroupRemarks;

	@FindBy(xpath = "//*[@id='btnSaveRosterGroup']")
	WebElement rosterGroupSave;

	@FindBy(xpath = "//div[@id=\"dvAvailableRosterGroup\"]/table/tbody/tr[1]")
	WebElement firstEmp;

	@FindBy(id = "txtNonMemberSearchString")
	WebElement searchNonMember;

	@FindBy(xpath = "//*[@id='currentRosterGroupTableBody']/tr[1]")
	WebElement firstEmpCurrentEmp;

	@FindBy(xpath = "//*[@id='availableEmpTableHeader']//button")
	WebElement threeDotAvailableEmp;

	@FindBy(xpath = "//*[@id='availableEmpTableHeader']/tr/td[1]//a[1]")
	WebElement addSelected;

	@FindBy(xpath = "//*[@id='availableEmpTableHeader']/tr/td[1]//a[2]")
	WebElement addAll;

	@FindBy(xpath = "//*[@id='currentEmpTableHeader']//button")
	WebElement threeDotCurrentEmp;

	@FindBy(id = "btnAddNewTemplateRoster")
	WebElement rosterCreationAdd;

	@FindBy(xpath = "//*[@id='currentEmpTableHeader']/tr/td[1]/div/div/a[1]/span")
	WebElement removeSelected;

	@FindBy(xpath = "//*[@id='currentEmpTableHeader']//div/a[2]")
	WebElement removeAll;

	@FindBy(id = "txtTemplateName")
	WebElement rosterTempName;

	@FindBy(id = "txtTemplateDesc")
	WebElement rosterTempDesc;

	@FindBy(id = "txtNumberOfDays")
	WebElement rosterNumDays;

	@FindBy(id = "bootstrap-duallistbox-nonselected-list_")
	WebElement rosterAvailGroup;

	@FindBy(xpath = "//*[@title='Move selected']")
	WebElement moveSelect;

	@FindBy(id = "btnSaveTemplateRoster")
	WebElement saveTemplateRoster;

	@FindBy(id = "btnAddSaveRosterPattern")
	WebElement saveTemplateName;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[2]")
	WebElement rosterPattern;

	@FindBy(id = "btnPublishRosterPattern")
	WebElement publishRosterPattern;

	@FindBy(xpath = "(//input[@placeholder='Publish From'])[2]")
	WebElement publishRosterFrom;

	@FindBy(xpath = "//*[@placeholder='PublishTo dd-mm-yyyy']")
	WebElement publishRosterTo;

	@FindBy(id = "btnSaveTemplateRoster")
	WebElement publishRosterPatternButton;

	@FindBy(xpath = "(//input[@placeholder='Publish From'])[1]")
	WebElement selectRosterGroup;

	@FindBy(xpath = "//*[@name='NoOfBlocks']")
	WebElement noOfBlocks;

	@FindBy(xpath = "//button[text()='Publish Now']")
	WebElement publishNow;

	// Roster Creation

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[1]")
	WebElement rosterCreation1stDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[2]")
	WebElement rosterCreation2stDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[3]")
	WebElement rosterCreation3stDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[4]")
	WebElement rosterCreation4stDay;

	@FindBy(xpath = "//*[@id='dpRosterPattern']/div[3]/div[3]/div/div[2]/div[5]")
	WebElement rosterCreation5stDay;

	@FindBy(xpath="//select[@id='cmbShiftBand']")
	WebElement shiftBandInSelection;

	@FindBy(id = "txtShiftNotes")
	WebElement shiftBandInSelectionNotes;

	@FindBy(id = "btnSelectShiftBand")
	WebElement shiftBandInSelectionSave;

	public String createShiftBand() throws Exception {

		String publicempNum = faker.numerify("8####");
		String coun = faker.company().industry();
		String des = faker.company().industry();

		String shiftbandname = "Shift Band" + " " + coun + " " + publicempNum;

		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
		// methodName);
		btnAddNew.click();
		Thread.sleep(3000);
		System.out.println("testing create shift band");

		// System.out.println("Shift Band Name: "+"Shift"+" "+coun+" "+publicempNum);
		// String nn="Shift "+" "+coun+" "+" publicempNum";
		// shiftBandNew=nn;
		// System.out.println("Shift Band Name: "+ shiftBandNew);

		// String sbn="Shift"+" "+coun+" "+publicempNum;
		txtShtBandName.sendKeys("Shift" + " " + coun + " " + publicempNum);
		txtShiftbandDesc.sendKeys("Shift Bank Code Creation");
		String nn = "Auto Band code" + " " + publicempNum;
//		shiftBandNew = nn;

		txtShiftBandCode.sendKeys("Auto Band code" + " " + publicempNum);

		// ShiftBandList.click();

//	dropdown.selectByIndex(shiftBandType, 1);
		// shiftBandType.sendKeys(Keys.ENTER);
		Thread.sleep(200);
		// chkIsActive.click();
		txtColorCode.clear();
		txtColorCode.sendKeys("#2d38cf");
		txtColorCode.sendKeys(Keys.TAB);
		Thread.sleep(200);
		shiftCounter.sendKeys("2");

		// chkIsActive.click();

//		webAction.scrollDown();

		// txtStartTime
//		webAction.scrollIntoeEement(txtStartTime);
		// webAction.waitUntilElementIsClickable(txtStartTime);
		// webAction.waitUntilElementIsVisible(txtStartTime);
		if (txtStartTime.isEnabled()) {
			System.out.println("If condition");

			txtStartTime.clear();
//			webAction.setValueUsingJavaScript(txtStartTime, "07:00");
		}

		// txtStartTime.sendKeys("07:00");
		txtEndTime.clear();
		txtEndTime.sendKeys("19:00");

		txtStartRangeBegin.clear();
		txtStartRangeBegin.sendKeys("9:00");

		txtStartRangeEnd.clear();
		txtStartRangeEnd.sendKeys("10:00");
		Thread.sleep(1000);
		txtEndRangeBegin.clear();
		txtEndRangeBegin.sendKeys("11:00");
		txtEndRangeEnd.clear();
		txtEndRangeEnd.sendKeys("12:00");

		Thread.sleep(1000);
		btnSaveshiftbandDtls.click();
//		reportUtils.addInfo("Creation of Shift Band Name:"+shiftbandname, methodName);
		return shiftbandname;
	}

//	public String createRosterGroupAssignmentAddingSelectedEmp() throws Exception {
//
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		String rosterGroupNAme = "Roster Group " + "Shift" + " " + coun + " " + publicempNum;
//		// System.out.println("Roster Group Name: "+"Shift"+" "+coun+" "+publicempNum);
//		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
//		// methodName);
//		rosterGroupAssnmtAdd.click();
//		Thread.sleep(3000);
//		System.out.println("Testing of Roster Group Assignment");
//		reportUtils.addInfo("Testing of Roster Group Assignment for Selected Employee", methodName);
//
//		System.out.println(rosterGroupNAme);
//		rosterGroupName.sendKeys(rosterGroupNAme);
//		rosterGroupDesc.sendKeys("Roster Group Description for Testing" + " " + coun + " " + publicempNum);
//		rosterGroupRemarks.sendKeys("Adding remarks for roster Group" + " " + coun + " " + publicempNum);
//		webAction.scrollDown();
//		webAction.click(searchNonMember);
//
//		System.out.println(NumberOne);
//		reportUtils.addInfo("Adding Employee Number One"+NumberOne, methodName);
//		webAction.setText(searchNonMember, NumberOne);
//		Thread.sleep(2000);
//		firstEmp.click();
//		threeDotAvailableEmp.click();
//		addSelected.click();
//
//		Thread.sleep(1000);
//
//		System.out.println(NumberTwo);
//		reportUtils.addInfo("Adding Employee Number Two"+NumberTwo, methodName);
//		webAction.setText(searchNonMember, NumberTwo);
//		Thread.sleep(2000);
//		firstEmp.click();
//		threeDotAvailableEmp.click();
//		addSelected.click();
//
//		Thread.sleep(1000);
//		System.out.println(NumberThree);
//		reportUtils.addInfo("Adding Employee Number Three"+NumberThree, methodName);
//		webAction.setText(searchNonMember, NumberThree);
//		Thread.sleep(2000);
//		firstEmp.click();
//		threeDotAvailableEmp.click();
//		addSelected.click();
//
//		Thread.sleep(1000);
//		System.out.println(NumberFour);
//		reportUtils.addInfo("Adding Employee Number Four"+NumberFour, methodName);
//		webAction.setText(searchNonMember, NumberFour);
//		Thread.sleep(2000);
//		firstEmp.click();
//		threeDotAvailableEmp.click();
//		addSelected.click();
//
//		Thread.sleep(1000);
//		System.out.println(NumberFive);
//		reportUtils.addInfo("Adding Employee Number Five"+NumberFive, methodName);
//		webAction.setText(searchNonMember, NumberFive);
//		Thread.sleep(2000);
//		firstEmp.click();
//		threeDotAvailableEmp.click();
//		addSelected.click();
//
//		Thread.sleep(2000);
//		// firstEmp.click();
//		// threeDotAvailableEmp.click();
//		// addSelected.click();
//
//		webAction.clickUsingJavaScript(rosterGroupSave);
//		// rosterGroupSave.click();
//		Thread.sleep(2000);
//
//		RosterGroupNameforRosterCreation = rosterGroupNAme;
//		System.out.println(rosterGroupNAme);
//		System.out.println(RosterGroupNameforRosterCreation);
//		return rosterGroupNAme;
//	}

//	public String createRosterGroupAssignmentAddingAllEmp() throws Exception {
//
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		String rosterGroupNAme = "Shift" + " " + coun + " " + publicempNum;
//		System.out.println("Roster Group Name: " + "Shift" + " " + coun + " " + publicempNum);
//		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
//		// methodName);
//		webAction.waitForPageLoad(2000);
//		rosterGroupAssnmtAdd.click();
//		Thread.sleep(3000);
//		System.out.println("Testing Roster Group Assignment");
//		reportUtils.addInfo("Testing of Roster Group Assignment for Adding All Employee", methodName);
//
//		rosterGroupName.sendKeys("Roster Group Name" + " " + coun + " " + publicempNum);
//		rosterGroupDesc.sendKeys("Roster Group Description for Testing" + " " + coun + " " + publicempNum);
//		rosterGroupRemarks.sendKeys("Adding remarks for roster Group" + " " + coun + " " + publicempNum);
//		webAction.scrollDown();
//		Thread.sleep(2000);
//
//		// firstEmp.click();
//		webAction.clickUsingJavaScript(threeDotAvailableEmp);
//		Thread.sleep(500);
//		// threeDotAvailableEmp.click();
//		webAction.clickUsingJavaScript(addAll);
//		Thread.sleep(500);
//		// webAction.scrollUp();
//		// webAction.waitUntilElementIsClickable(rosterGroupSave);
//	//	Actions action = new Actions(driver);
//		//action.moveToElement(rosterGroupSave).click().perform();
//		 webAction.clickUsingJavaScript(rosterGroupSave);
//
//		// webAction.clickUsingJavaScript(rosterGroupSave);
//		// rosterGroupSave.click();
//		Thread.sleep(1000);
//
//		return rosterGroupNAme;
//	}
//
//	public String createRosterGroupAssignmentRemoveSelected() throws Exception {
//
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		String rosterGroupNAme = "Shift" + " " + coun + " " + publicempNum;
//		System.out.println("Roster Group Name: " + "Shift" + " " + coun + " " + publicempNum);
//		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
//		// methodName);
//		webAction.clickUsingJavaScript(rosterGroupAssnmtAdd);
//		// rosterGroupAssnmtAdd.click();
//		Thread.sleep(3000);
//		System.out.println("testing Roster Group Assignment");
//
//		rosterGroupName.sendKeys("Roster Group Name" + " " + coun + " " + publicempNum);
//		rosterGroupDesc.sendKeys("Roster Group Description for Testing" + " " + coun + " " + publicempNum);
//		rosterGroupRemarks.sendKeys("Adding remarks for roster Group" + " " + coun + " " + publicempNum);
//		webAction.scrollDown();
//		Thread.sleep(2000);
//
//		// firstEmp.click();
//		webAction.clickUsingJavaScript(threeDotAvailableEmp);
//		Thread.sleep(500);
//		webAction.clickUsingJavaScript(addAll);
//		Thread.sleep(500);
//		webAction.clickUsingJavaScript(firstEmpCurrentEmp);
//		Thread.sleep(500);
//		webAction.clickUsingJavaScript(threeDotCurrentEmp);
//		Thread.sleep(500);
//		webAction.clickUsingJavaScript(removeSelected);
//		Thread.sleep(500);
//
//		webAction.scrollUp();
//		reportUtils.addInfo("Roster Group Assignment Removal of Selected Employee", methodName);
//		// webAction.waitUntilElementIsClickable(rosterGroupSave);
//
//		// webAction.clickUsingJavaScript(rosterGroupSave);
//		// rosterGroupSave.click();
//		// webAction.waitUntilElementIsClickable(rosterGroupSave);
//		rosterGroupSave.sendKeys(Keys.ENTER);
//		// rosterGroupSave.click();
//		Thread.sleep(500);
//
//		return rosterGroupNAme;
//	}
//
//	public String createRosterGroupAssignmentRemoveAll() throws Exception {
//
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		String rosterGroupNAme = "Shift" + " " + coun + " " + publicempNum;
//		System.out.println("Roster Group Name: " + "Shift" + " " + coun + " " + publicempNum);
//		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
//		// methodName);
//		webAction.clickUsingJavaScript(rosterGroupAssnmtAdd);
//		// rosterGroupAssnmtAdd.click();
//		Thread.sleep(3000);
//		System.out.println("testing Roster Group Assignment");
//
//		rosterGroupName.sendKeys("Roster Group Name" + " " + coun + " " + publicempNum);
//		rosterGroupDesc.sendKeys("Roster Group Description for Testing" + " " + coun + " " + publicempNum);
//		rosterGroupRemarks.sendKeys("Adding remarks for roster Group" + " " + coun + " " + publicempNum);
//		webAction.scrollDown();
//		Thread.sleep(2000);
//
//		// firstEmp.click();
//		webAction.clickUsingJavaScript(threeDotAvailableEmp);
//		// threeDotAvailableEmp.clickUsingJavaScript();
//		webAction.clickUsingJavaScript(addAll);
//		// addAll.click();
//		Thread.sleep(2000);
//		webAction.clickUsingJavaScript(threeDotCurrentEmp);
//		// threeDotCurrentEmp.clickUsingJavaScript();
//		webAction.clickUsingJavaScript(removeAll);
//		// removeAll.click();
//		Thread.sleep(2000);
//		reportUtils.addInfo("Roster Group Assignment Removal of All Employee", methodName);
//		// addSelected.click();
//		webAction.scrollUp();
//		webAction.clickUsingJavaScript(rosterGroupSave);
//		// rosterGroupSave.click();
//
//		return rosterGroupNAme;
//	}
//
//	public String rosterCreation() throws Exception {
//
//		// String rosterGroupNam=createRosterGroupAssignmentAddingAllEmp();
//		// System.out.println(rosterGroupNam);
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		// String rosterGroupNAme="Shift"+" "+coun+" "+publicempNum;
//		// System.out.println("Roster Group Name: "+"Shift"+" "+coun+" "+publicempNum);
//		// setupTest(this.getClass().getPackage(), this.getClass().toString(),
//		// methodName);
//
//		Thread.sleep(3000);
//		rosterCreationAdd.click();
//		Thread.sleep(3000);
//
//		rosterTempName.sendKeys("Roster Name for Testing" + " " + coun + " " + publicempNum);
//		rosterTempDesc.sendKeys("Roster Group Name for Description for Testing" + " " + coun + " " + publicempNum);
//		rosterNumDays.sendKeys("7");
//		// dropdown.selectByValue(rosterAvailGroup,
//		// createRosterGroupAssignmentAddingAllEmp());
//		// dropdown.selectByValue(rosterAvailGroup, "Roster Group Test 123");
//		// dropdown.selectByvisibleText(rosterAvailGroup, "Roster Group Test 123");
//		// dropdown.selectByValue(rosterAvailGroup, shiftBandNew);
//
//		// dropdown.selectByIndex(rosterAvailGroup, 5);
//
//		// @FindBy(xpath= "//*[@id='bootstrap-duallistbox-nonselected-list_']/option")
//		String RosterGroupNameforRosterCreationNew = "Roster Group Shift Philanthropy 9810";
//		
//		List<WebElement> availableRosterGroups = rosterAvailGroup
//				.findElements(By.xpath("//*[@id='bootstrap-duallistbox-nonselected-list_']/option"));
//
//		
//	
//		for (WebElement we : availableRosterGroups) {
//			Thread.sleep(500);
//			System.out.println(we.getText());
//			if (RosterGroupNameforRosterCreationNew.equals(we.getText()))
//
//				we.click();
//
//		}
//
//		moveSelect.click();
//		Thread.sleep(1000);
//		saveTemplateRoster.click();
//		Thread.sleep(3000);
//
//		saveTemplateName.click();
//		Thread.sleep(5000);
//		// First Day
//		rosterCreation1stDay.click();
//		System.out.println(shiftBandNew);
//		Thread.sleep(1000);
//		dropdown.selectByvisibleText(shiftBandInSelection, shiftBandNew);
//		shiftBandInSelectionNotes.sendKeys("Testing Purpose");
//		webAction.clickUsingJavaScript(shiftBandInSelectionSave);
//
//		// Second Day
//		rosterCreation2stDay.click();
//		Thread.sleep(1000);
//		dropdown.selectByvisibleText(shiftBandInSelection, shiftBandNew);
//		shiftBandInSelectionNotes.sendKeys("Testing Purpose");
//		webAction.clickUsingJavaScript(shiftBandInSelectionSave);
//
//		// Third Day
//		rosterCreation3stDay.click();
//		Thread.sleep(1000);
//		dropdown.selectByvisibleText(shiftBandInSelection, shiftBandNew);
//		shiftBandInSelectionNotes.sendKeys("Testing Purpose");
//		webAction.clickUsingJavaScript(shiftBandInSelectionSave);
//
//		// Fourth Day
//		rosterCreation4stDay.click();
//		Thread.sleep(1000);
//		dropdown.selectByvisibleText(shiftBandInSelection, shiftBandNew);
//		shiftBandInSelectionNotes.sendKeys("Testing Purpose");
//		webAction.clickUsingJavaScript(shiftBandInSelectionSave);
//
//		// Fifth Day
//		rosterCreation5stDay.click();
//		Thread.sleep(1000);
//		dropdown.selectByvisibleText(shiftBandInSelection, shiftBandNew);
//		shiftBandInSelectionNotes.sendKeys("Testing Purpose");
//		webAction.clickUsingJavaScript(shiftBandInSelectionSave);
//		// shiftBandInSelectionSave
//
//		webAction.clickUsingJavaScript(saveTemplateName);
//		// shiftBandInSelectionSave
//		Thread.sleep(1000);
//		webAction.clickUsingJavaScript(publishRosterPattern);
//		// publishRosterPattern.click();
//		Thread.sleep(3000);
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		String formattedDate = sdf.format(date);
//		publishRosterFrom.sendKeys(formattedDate);
//		Thread.sleep(1000);
//		noOfBlocks.sendKeys("2");
//		// publishRosterTo.sendKeys("12-05-2023");
//		Thread.sleep(1000);
//		webAction.clickUsingJavaScript(selectRosterGroup);
//		Thread.sleep(1000);
//		webAction.clickUsingJavaScript(publishRosterPatternButton);
//		// publishRosterPatternButton.click();
//		Thread.sleep(1000);
//		webAction.clickUsingJavaScript(publishNow);
//		Thread.sleep(4000);
//		return RosterGroupNameforRosterCreation;
//
//	}
//
//	public boolean verifyShiftbandCreation() {
//		boolean createShiftBand = true;
//		if (txtShiftbandCreate.size() <= 0) {
//			createShiftBand = false;
//		}
//		return createShiftBand;
//
//	}
//
//	public boolean verifyRosterGroupCreation() {
//		// System.out.println(txtGroupCreate.get(0));
//		boolean rosterGroupNAmevar = true;
//		if (txtGroupCreate.size() <= 0) {
//			rosterGroupNAmevar = false;
//		}
//		return rosterGroupNAmevar;
//
//	}
//
//	public void editShiftBand() throws Exception {
//
//		String publicempNum = faker.numerify("9###");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		String shiftbandname = "Shift" + " " + coun + " " + publicempNum;
//
//		textSearchColumns.sendKeys("Auto band Code 82220");
//		// menuNavigation.waitforLoadingIcon();
//		Thread.sleep(1000);
//		webAction.clickUsingJavaScript(btnEditShiftband);
//		// btnEditShiftband.click();
//		Thread.sleep(1000);
//		txtShiftbandDesc.clear();
//		txtShiftbandDesc.sendKeys("Updating Shift band " + publicempNum);
//		Thread.sleep(500);
//		btnSaveshiftbandDtls.click();
//		Thread.sleep(3000);
//	}
//
//	public void deleteShiftBand() throws Exception {
//		// textSearchColumns.sendKeys(excelObject.getData("EditShiftBand", "Name",
//		// "Roaster"));
//		textSearchColumns.sendKeys("Shift Alternative Medicine 88447");
//		// menuNavigation.waitforLoadingIcon();
//		Thread.sleep(2000);
//		webAction.clickUsingJavaScript(chkSelectShiftband);
//		webAction.clickUsingJavaScript(btnDeleteshftband);
//		webAction.clickUsingJavaScript(btnDeleteshftbandConfirmation);
//		// webAction.waitUntilElementIsClickable(chkSelectShiftband);
//		// chkSelectShiftband.click();
//		// btnDeleteshftband
//		// btnDeleteshftbandConfirmation
//		Thread.sleep(100);
//	}
//
//	public void reActivateDeletedShiftBand() throws IOException, InterruptedException {
//		// textSearchColumns.sendKeys(excelObject.getData("EditShiftBand", "Name",
//		// "Roaster"));
//		textSearchColumns.sendKeys("Auto Shift Band code 1234");
//		// menuNavigation.waitforLoadingIcon();
//		Thread.sleep(2000);
//		// webAction.waitUntilElementIsClickable(chkSelectShiftband);
//		chkSelectShiftband.click();
//
//		btnSaveshiftbandDtls.click();
//		Thread.sleep(100);
//	}
//
//	public boolean verifyShiftbandEdit() {
//		boolean editShiftBand = true;
//		if (txtShiftbandEdit.size() <= 0) {
//			editShiftBand = false;
//		}
//		return editShiftBand;
//
//	}
//
//	public boolean verifyShiftbandDelete() {
//		boolean deleteShiftBand = true;
//		if (txtShiftbandDelete.size() <= 0) {
//			deleteShiftBand = false;
//		}
//		return deleteShiftBand;
//
//	}
//
//	public boolean verifyShiftbandActivate() {
//		boolean activateShiftBand = true;
//		if (txtShiftbandDelete.size() <= 0) {
//			activateShiftBand = false;
//		}
//		return activateShiftBand;
//
//	}
//
//	public void scheduleCreationRule() throws Exception {
//		btnAddScheduleRule.click();
//		menuNavigation.waitforLoadingIcon();
//		Thread.sleep(300);
//		String publicempNum = faker.numerify("0##");
//		String coun = faker.company().industry();
//		String des = faker.company().industry();
//
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		String strDate = dateFormat.format(date);
//		System.out.println(strDate);
//
//		webAction.setText(txtScheduleRuleName, "Schedule Creation Rule" + publicempNum);
//		//txtScheduleRuleName.sendKeys("Schedule Creation Rule" + publicempNum);
//		webAction.setText(txtScheduleRuleDesc,"Testing Schedule Creation Rule");
//		//txtScheduleRuleDesc.sendKeys("Testing Schedule Creation Rule");
//		txtValidFrom.sendKeys(strDate);
//		txtValidFrom.sendKeys(Keys.TAB);
//		//resusemain.performWebElementTab(txtValidFrom);
//		
//		Thread.sleep(200);                                                                     */
//		// if (excelObject.getData("Schedule Creation Rule", "ValidToFlag",
//		// "Roaster").equals("Yes")) {
//		// chkValidTo.click();
//		// reuse.performWebElementClick(chkValidTo);
//
//		// txtValidTo.sendKeys(excelObject.getData("Schedule Creation Rule", "ValidTo",
//		// "Roaster"));
//		// reuse.performWebElementTab(txtValidTo);
//		// }
//		// if (excelObject.getData("Schedule Creation Rule", "IsActive?",
//		// "Roaster").equals("Yes")) {
//		// Thread.sleep(200);
//		// chkIsActive.click();
//		// }
		/*
		 * txtPeriodLength.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Period Length", "Roaster")); reuse.performWebElementTab(txtPeriodLength);
		 * txtShiftlengthMin.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Shift Length - Min", "Roaster"));
		 * reuse.performWebElementTab(txtShiftlengthMin);
		 * txtShiftlengthMax.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Shift Length - Max", "Roaster"));
		 * reuse.performWebElementTab(txtShiftlengthMax); txtContDaysScheduleOnMin
		 * .sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Cont. Working Days - Min", "Roaster"));
		 * reuse.performWebElementTab(txtContDaysScheduleOnMin);
		 * txtContDaysScheduleOnMax
		 * .sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Cont. Working Days - Max", "Roaster"));
		 * reuse.performWebElementTab(txtContDaysScheduleOnMax);
		 * txtDaysPerPeriodMin.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Days Per Period - Min", "Roaster"));
		 * reuse.performWebElementTab(txtDaysPerPeriodMin);
		 * txtDaysPerPeriodMax.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Days Per Period - Max", "Roaster"));
		 * reuse.performWebElementTab(txtDaysPerPeriodMax); txtContDaysScheduleOffMin
		 * .sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Cont. Off Days - Min", "Roaster"));
		 * reuse.performWebElementTab(txtContDaysScheduleOffMin);
		 * txtContDaysScheduleOffMax
		 * .sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Cont. Off Days - Max", "Roaster"));
		 * reuse.performWebElementTab(txtContDaysScheduleOffMax);
		 * txtTimePerPeriodMin.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Time Per Period - Min", "Roaster"));
		 * reuse.performWebElementTab(txtTimePerPeriodMin);
		 * txtTimePerPeriodMax.sendKeys(excelObject.getData("Schedule Creation Rule",
		 * "Time Per Period - Max", "Roaster"));
		 * reuse.performWebElementTab(txtTimePerPeriodMax); if
		 * (excelObject.getData("Schedule Creation Rule", "Include Leave",
		 * "Roaster").equals("Yes")) { Thread.sleep(100);
		 */
		// chkIncludeLeave.click();
		// reuse.performWebElementClick(chkIncludeLeave);
	}

