package com.AutomationJiviewsPOM;



import java.io.File;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.AutomationJiviewsGeneric.FakeEmployee;

public class EmpAdmEmployeeProfilePage extends BaseClass{
	private static final Logger logger = LogManager.getLogger(EmpAdmEmployeeProfilePage.class);
	Select select;
	public Actions action;

	@FindBy(xpath = "//button[@id='btnAddEmployee']")
	private WebElement btnAddEmployee;

	@FindBy(xpath = "//a[text()='Basic Profile']")
	private WebElement basicProfile;

	@FindBy(xpath = "//input[@id='txtEmployeeNumber']")
	private WebElement txtEmployeeNumber;

	@FindBy(xpath = "//input[@id='txtBadgeNumber']")
	private WebElement txtBadgeNumber;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='txtMiddleName']")
	private WebElement txtMiddleName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='txtDisplayName']")
	private WebElement txtDisplayName;

	@FindBy(xpath = "//input[@id='dtBirthDate']")
	private WebElement dtBirthDate;

	@FindBy(xpath = "//span[@id='select2-cmbEmploymentBasis-container']")
	private WebElement employmentBasis;
	@FindBy(xpath = "//li[text()='Contract Emp - Contract Emp']")
	private WebElement selectEmpBasisContract;
	@FindBy(xpath = "//li[text()='Fixed Emp - Fixed Emp']")
	private WebElement selectEmpBasisFixed;
	@FindBy(xpath = "//li[text()='White Color Emp - White Color Emp']")
	private WebElement selectEmpBasisWhiteClr;

	@FindBy(xpath = "//span[@id='select2-cmbGender-container']")
	private WebElement txtGender; 
	@FindBy(xpath = "//li[text()='Female']")
	private WebElement selectFemale;
	@FindBy(xpath = "//li[text()='Male']")
	private WebElement selectMale;
	@FindBy(xpath = "//li[text()='Others']")
	private WebElement selectOthers;


	@FindBy(xpath = "//span[@id='select2-cmbMaritalStatus-container']")
	private WebElement meritalStatus;
	@FindBy(xpath = "//li[text()='Married']")
	private WebElement selectMarried;
	@FindBy(xpath = "//li[text()='Single']")
	private WebElement selectSingle;

	@FindBy(xpath = "//span[@id='select2-cmbTitle-container']")
	private WebElement txtTitle;
	@FindBy(xpath = "//li[text()='Mr.']")
	private WebElement selectMr;
	@FindBy(xpath = "//li[text()='Test Title']")
	private WebElement selectTestTitle;

	@FindBy(xpath = "//span[@id='select2-cmbReligion-container']")
	private WebElement txtReligion;
	@FindBy(xpath = "//li[text()='Hindu']")
	private WebElement selectHindu;
	@FindBy(xpath = "//li[text()='Muslim']")
	private WebElement selectMuslim;

	@FindBy(xpath = "//input[@id='txtAddressLine1']")
	private WebElement txtAddressLine1;
	@FindBy(xpath = "//input[@id='txtAddressLine2']")
	private WebElement txtAddressLine2;
	@FindBy(xpath = "//input[@id='txtAddressLine3']")
	private WebElement txtAddressLine3;

	@FindBy(xpath = "//input[@id='txtPostCode']") 
	private WebElement txtPostCode;

	@FindBy(xpath = "//input[@id='txtCity']")
	private WebElement txtCity;

	@FindBy(xpath = "//input[@id='txtState']")
	private WebElement txtState;

	@FindBy(xpath = "//span[@id='select2-cmbCountry-container']")
	private WebElement txtCountry;
	@FindBy(xpath = "//li[text()='Australian']")
	private WebElement selectAustralian;
	@FindBy(xpath = "//li[text()='United States']")
	private WebElement selectUS;


	@FindBy(xpath = "//input[@id='txtMobileNumber']")
	private WebElement txtMobileNumber;

	@FindBy(xpath = "//input[@id='txtHomePhoneNumber']")
	private WebElement txtHomePhoneNumber;

	@FindBy(xpath = "//input[@id='txtEmailAddress']")
	private WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='dtHireDate']")
	private WebElement dtHireDate;

	@FindBy(xpath = "//input[@id='dtProbationExpiryDate']")
	private WebElement dtProbationExpiryDate;

	@FindBy(xpath = "//span[@id='select2-cmbPosition-container']")
	private WebElement txtPosition;
	@FindBy(xpath = "//li[text()='ECHO']")
	private WebElement selectEcho;
	@FindBy(xpath = "//li[text()='QCO']")
	private WebElement selectQco;

	@FindBy(xpath = "//span[@id='select2-cmbScheduleRule-container']")
	private WebElement txtScheduleRule;
	@FindBy(xpath = "//li[contains(text(),'Deafault SCR')]")
	private WebElement selectScheduleRule;

	@FindBy(xpath = "//span[@id='select2-cmbPayGroup-container']")
	private WebElement txtPayGroup;
	@FindBy(xpath = "//li[text()='Default Pay Group - Default Pay Group']")
	private WebElement selectPayGroup;

	@FindBy(xpath = "//span[@id='select2-cmbOverTime-container']")
	private WebElement txtOvertimeSetting;
	@FindBy(xpath = "//li[text()='Fixed OT']")
	private WebElement selectOtSetting;


	@FindBy(xpath = "//a[text()='Roles']")
	private WebElement tabRole;

	@FindBy(xpath = "//span[@id='select2-cmbPrimaryRole-container']")
	private WebElement cmbPrimaryRole;

	@FindBy(xpath = "//ul[@id='select2-cmbPrimaryRole-results']")
	private WebElement cmbPrimaryRoleSearch;
	@FindBy(xpath = "(//li[contains(text(),'RTGO')])")
	private WebElement selectSkill;
	@FindBy(xpath = "//select[@id='bootstrap-duallistbox-nonselected-list_']")
	private WebElement availableListBox;

	// select for move signle skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle;
	//		select for move multiple skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement tabContacts;

	@FindBy(xpath = "//button[@id='btnAddNewContact']")
	private WebElement btnAddNewContact;

	@FindBy(xpath = "//input[@id='txtContactName']")
	private WebElement txtContactName;

	@FindBy(xpath = "//span[@id='select2-cmbRelationship-container']")
	private WebElement cmbRelationship;
	@FindBy(xpath = "//li[text()='Spouse']")
	private WebElement selectSpouse;

	@FindBy(xpath = "//input[@id='txtContactAddressLine1']")
	private WebElement txtContactAddressLine1;
	@FindBy(xpath = "//input[@id='txtContactAddressLine2']")
	private WebElement txtContactAddressLine2;
	@FindBy(xpath = "//input[@id='txtContactAddressLine3']")
	private WebElement txtContactAddressLine3;
	@FindBy(xpath = "//input[@id='txtContactPostCode']")
	private WebElement txtContactPostCode;
	@FindBy(xpath = "//input[@id='txtContactCity']")
	private WebElement txtContactCity;
	@FindBy(xpath = "//input[@id='txtContactState']")
	private WebElement txtContactState;

	@FindBy(xpath = "//span[@id='select2-cmbContactCountry-container']")
	private WebElement txtContactCountry;
	@FindBy(xpath = "//li[text()='Oman']")
	private WebElement selectOman;

	@FindBy(xpath = "//input[@id='txtContactMobileNumber']")
	private WebElement txtContactMobileNumber;
	@FindBy(xpath = "//input[@id='txtContactHomePhoneNumber']")
	private WebElement txtContactHomePhoneNumber;
	@FindBy(xpath = "//input[@id='txtContactEmailAddress']")
	private WebElement txtContactEmailAddress;

	@FindBy(xpath = "//button[@id='btnSaveContact']")
	private WebElement btnSaveContact;
	@FindBy(xpath = "//div[text()='Add New Contact - Success']")
	private WebElement addNewContactSuccessMsg;

	@FindBy(xpath = "//a[text()='Attachments']")
	private WebElement tabAttachments;
	@FindBy(xpath = "//button[@id='btnAddEmployeeAttachment']")
	private WebElement btnAddEmployeeAttachment;
	@FindBy(xpath = "//input[@id='txtDocumentName']")
	private WebElement txtDocumentName;
	@FindBy(xpath = "//input[@id='txtDescription']")
	private WebElement txtDescription;
	@FindBy(xpath = "//button[@id='btnAddAttachment']")
	private WebElement btnAddAttachment;
	@FindBy(xpath = "(//input[@id='fileToUpload'])[2]")
	private WebElement btnFileToUpload;
	@FindBy(xpath = "//button[text()='Upload']")
	private WebElement btnUpload;
	@FindBy(xpath = "//button[@id='btnSaveAttachment']")
	private WebElement btnSaveAttachment;
	@FindBy(xpath = "//div[text()='Attachment created Successfully']") 
	private WebElement attachmentcreatedSuccessfullyMsg;

	@FindBy(xpath = "//a[text()='Miscellaneous']")
	private WebElement tabMiscellaneous;
	@FindBy(xpath = "//span[text()='Shift Employee']")
	private WebElement checkBoxShiftEmp;

	@FindBy(xpath = "//a[text()='ESS']")
	private WebElement tabESS;

	@FindBy(xpath = "//button[@id='btnAddLeaveProfile']")
	private WebElement btnAddLeaveProfile;
	@FindBy(xpath = "//span[@id='select2-cmbEmpLeaveProfileName-container']")
	private WebElement cmbEmpLeaveProfileName;
	@FindBy(xpath = "//li[text()='Default Leave Profile ']")
	private WebElement selectEmpProfileName;
	@FindBy(xpath = "//input[@id='dtLeaveProfileEndDate']")
	private WebElement dtLeaveProfileEndDate;
	@FindBy(xpath = "//button[@id='btnSaveLeaveProfile']")
	private WebElement btnSaveLeaveProfile;

	@FindBy(xpath = "//button[@id='btnAddEmpWorkflowRoute']")
	private WebElement btnAddEmpWorkflowRoute;
	@FindBy(xpath = "//span[@id='select2-cmbWorkFlowModuleName-container']")
	private WebElement selectModuleName;
	@FindBy(xpath = "//li[text()='HajLeave']")
	private WebElement selectHajLeave;
	@FindBy(xpath = "//li[text()='Leave']")
	private WebElement selectLeave;
	@FindBy(xpath = "//li[text()='Request Leave']")
	private WebElement selectRequestLeave;
	@FindBy(xpath = "//li[text()='SpecialLeave']")
	private WebElement selectSpecialLeave;
	@FindBy(xpath = "//li[text()='Time Attendance']")
	private WebElement selectTimeAttendance;
	@FindBy(xpath = "//li[text()='Time Off']")
	private WebElement selectTimeOff;
	@FindBy(xpath = "//li[text()='UnControlledLeave']")
	private WebElement selectUnControlledLeave;
	@FindBy(xpath = "//li[text()='UnpaidLeave']")
	private WebElement selectUnpaidLeave;

	@FindBy(xpath = "//span[@id='select2-cmbWorkflowRouteName-container']")
	private WebElement selectRouteName;
	@FindBy(xpath = "//li[text()='Leave Route']")
	private WebElement selectLeaveRoute;
	@FindBy(xpath = "//li[text()='route 01']")
	private WebElement selectRoute01;

	@FindBy(xpath = "//input[@id='dtWorkFlowStartDate']")
	private WebElement dtWorkFlowStartDate;
	@FindBy(xpath = "//input[@id='dtWorkFlowEndDate']")
	private WebElement dtWorkFlowEndDate;
	@FindBy(xpath = "//button[@id='btnSaveEmpWorkflowRoute']")
	private WebElement btnSaveEmpWorkflowRoute;

	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;
	@FindBy(xpath = "//button[@id='btnSaveEmployee']")
	private WebElement btnSaveEmployee;
	@FindBy(xpath = "//div[text()='Employee Profile created successfully']")
	private WebElement employeeProfilecreatedSuccessfullyMsg;

	// Edit Employee Profile ....................//////////////////////.............................
	@FindBy(xpath = "(//button[@class='btn btn-xs btn-outline-primary icon-btn mx-1 edit'])")
	private WebElement btnEdit;
	@FindBy(xpath = "(//button[@class='btn btn-xs btn-outline-primary icon-btn mx-1 duplicate'])[1]")
	private WebElement btnDuplicate;

	@FindBy(xpath = "//a[text()='Excluded Skills']")
	private WebElement tabExcludedSkills;
	@FindBy(xpath = "//button[@id='btnAddNewExcludedSkills']")
	private WebElement btnAddNewExcludedSkills;
	@FindBy(xpath = "//span[@id='select2-cmbExcludedSkill-container']")
	private WebElement txtSkillDescription;
	@FindBy(xpath = "//li[contains(text(),'Auto_Test')]")
	private WebElement dropDownSkill;
	@FindBy(xpath = "//input[@id='dtExcludedSkillStartDate']")
	private WebElement dtExcludedSkillStartDate;
	@FindBy(xpath = "//input[@id='dtExcludedSkillEndDate']")
	private WebElement dtExcludedSkillEndDate;
	@FindBy(xpath = "//input[@id='txtExcludedSkillReason']")
	private WebElement txtExcludedSkillReason;
	@FindBy(xpath = "//button[@id='btnSaveExcludedSkill']")
	private WebElement btnSaveExcludedSkill;
	@FindBy(xpath = "//div[text()='Add Excluded Skill - Success']")
	private WebElement addExcludedSkillSuccessMsg;

	@FindBy(xpath = "//a[text()='Disciplinary']")
	private WebElement tabDisciplinary;
	@FindBy(xpath = "//button[@id='btnDeleteDisciplinary']")
	private WebElement btnDeleteDisciplinary;
	@FindBy(xpath = "//button[@id='btnAddSuspension']")
	private WebElement btnAddSuspension;
	@FindBy(xpath = "//input[@id='dtDisciplinaryStart']")
	private WebElement dtDisciplinaryStart;
	@FindBy(xpath = "//input[@id='dtDisciplinaryEnd']")
	private WebElement dtDisciplinaryEnd;
	@FindBy(xpath = "//span[text()='Exclude Accrual Process']")
	private WebElement chkExcludeAccrualProcess;
	@FindBy(xpath = "//input[@id='txtDisciplinaryRemarks']")
	private WebElement txtDisciplinaryRemarks;
	@FindBy(xpath = "//button[@id='btnSaveDisciplinaryDetails']")
	private WebElement btnSaveDisciplinaryDetails;
	@FindBy(xpath = "//div[text()='Add Disciplinary Action - Success']")
	private WebElement addDisciplinaryActionSuccessMsg;

	//chk Is Employee Terminated
	@FindBy(xpath = "(//div[@class='input-group-text']/label)[3]")
	private WebElement chkIsEmployeeTerminated;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(xpath = "//input[@id='dtEmployeeTerminatedDate']")
	private WebElement dtEmployeeTerminatedDate;
	@FindBy(xpath = "//textarea[@id='txtEmployeeTerminationRemarks']")
	private WebElement txtEmployeeTerminationRemarks;

	@FindBy(xpath = "//a[text()='Security']")
	private WebElement tabSecurity;
	@FindBy(xpath = "//button[@id='btnAddEmployeeOU']")
	private WebElement btnAddEmployeeOU;
	@FindBy(xpath = "//span[@id='select2-cmbSharedOrgUnit-container']")
	private WebElement selectOrganizationName;
	@FindBy(xpath = "(//li[text()='DEMO'])[2]")
	private WebElement chooseOrgUnit;
	@FindBy(xpath = "//input[@id='dtShareOrgUnitStartDate']")
	private WebElement dtShareOrgUnitStartDate;
	@FindBy(xpath = "//input[@id='dtShareOrgUnitEndDate']")
	private WebElement dtShareOrgUnitEndDate;
	@FindBy(xpath = "//button[@id='btnSaveEmployeeOU']")
	private WebElement btnSaveEmployeeOU;

	@FindBy(xpath = "//table[@id='emp-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//li[@id='emp-list_next']")
	private WebElement nextPage;

	@FindBy(xpath = "//button[@id='btnDeleteEmployee']")
	private WebElement btnDeleteEmployee;
	//	@FindBy(xpath = "//button[text()='Yes']")
	//	private WebElement btnYes;
	@FindBy(xpath = "//span[text()='IsActive?']")
	private WebElement checkBoxIsActive;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[1]")
	private WebElement chooseEmpBasis;
	@FindBy(xpath = "//li[text()='Contract Emp - Contract Emp']")
	private WebElement selectContractEmp;
	@FindBy(xpath = "//li[text()='Fixed Emp - Fixed Emp']")
	private WebElement selectFixedEmp;
	@FindBy(xpath = "//li[text()='White Color Emp - White Color Emp']")
	private WebElement selectWhiteClrEmp;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]")
	private WebElement chooseRosterGroup;
	@FindBy(xpath = "//li[text()='Default Roster  Group']")
	private WebElement selectDftRosterGroup;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[3]")
	private WebElement chooseRoleGroup;
	@FindBy(xpath = "//li[text()='RTGO Operator  2023-11-10T00:21:32.396903900']")
	private WebElement selectRoleGroup;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[4]")
	private WebElement chooseEmpStatus;
	@FindBy(xpath = "//li[text()='Active']")
	private WebElement selectActiveEmp;
	@FindBy(xpath = "//li[text()='Terminated']")
	private WebElement selectTerminatedEmp;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement txtSearchBar;

	@FindBy(xpath = "//button[@id='btnSearchEmployeeProfile']")
	private WebElement btnSearchEmployeeProfile;



	public EmpAdmEmployeeProfilePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
	}
	public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		element.click();
	}
	public void clickBtnAddEmployee() {
		btnAddEmployee.click();
	}

	public void clickBasicProfile() {
		//	webUtility.moveToElement(driver, basicProfile);
		basicProfile.click();
	}

	public void enterEmployeeNumber(String empNumber) throws InterruptedException {
		Thread.sleep(5000);
		txtEmployeeNumber.clear();
		txtEmployeeNumber.sendKeys(empNumber);
	}

	public void enterBadgeNumber(String badgeNumber) {
		txtBadgeNumber.clear();
		txtBadgeNumber.sendKeys(badgeNumber);
	}

	public void enterFirstName(String firstName) {
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}

	public void enterMiddleName(String middleName) {
		txtMiddleName.clear();
		txtMiddleName.sendKeys(middleName);
	}

	public void enterLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}

	public void enterDateBirthDate(String dob) {
		webUtility.moveToElement(driver, dtBirthDate);
		dtBirthDate.clear();
		dtBirthDate.sendKeys(dob);
		dtBirthDate.sendKeys(Keys.ENTER);
	}

	public void chooseEmploymentBasis() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, employmentBasis);
		employmentBasis.click();
	}

	public void chooseEmpBasisContract() {
		webUtility.moveToElement(driver, selectEmpBasisContract);
		selectEmpBasisContract.click();
	}

	public void chooseEmpBasisFixed() {
		webUtility.moveToElement(driver, selectEmpBasisFixed);
		selectEmpBasisFixed.click();
	}

	public void chooseEmpBasisWhiteClr() {
		webUtility.moveToElement(driver, selectEmpBasisWhiteClr);
		selectEmpBasisWhiteClr.click();
	}
	public void chooseGender(String gender) {
		webUtility.moveToElement(driver, txtGender);
		txtGender.click();
		switch (gender.toLowerCase()) {
		case "male":
			logger.info("Choosing Male gender...");
			webUtility.moveToElement(driver, selectMale);
			selectMale.click();
			logger.info("Male gender selected.");
			break;
		case "female":
			logger.info("Choosing Female gender...");
			webUtility.moveToElement(driver, selectFemale);
			selectFemale.click();
			logger.info("Female gender selected.");
			break;
		case "others":
			logger.info("Choosing Others gender...");
			webUtility.moveToElement(driver, selectOthers);
			selectOthers.click();
			logger.info("Others gender selected.");
			break;
		default:
			logger.error("Invalid gender provided: " + gender);
			throw new IllegalArgumentException("Invalid gender: " + gender);
		}


	}
	public void chooseMeritalStatus(String status) {
		webUtility.moveToElement(driver, meritalStatus);
		meritalStatus.click();
		switch (status.toLowerCase()) {
		case "married":
			webUtility.moveToElement(driver, selectMarried);
			selectMarried.click();
			break;
		case "single":
			selectSingle.click();
			break;
		}
	}
	public void chooseTitle(String title) {
		webUtility.moveToElement(driver, txtTitle);
		txtTitle.click();
		switch (title.toLowerCase()) {
		case "mr.":
			webUtility.moveToElement(driver, selectMr);
			selectMr.click();
			break;
		case "test title":
			selectTestTitle.click();
			break;
		}
	}
	public void chooseReligion(String religion) {
		webUtility.moveToElement(driver, txtReligion);
		txtReligion.click();
		switch (religion.toLowerCase()) {
		case "hindu":
			webUtility.moveToElement(driver, selectHindu);
			selectHindu.click();
			break;
		case "muslim":
			selectMuslim.click();
			break;
		}
	}
	public void enterAddressLine1(String address1) {
		webUtility.moveToElement(driver, txtAddressLine1);
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(address1);
	}
	public void enterAddressLine2(String address2) {
		webUtility.moveToElement(driver, txtAddressLine2);
		txtAddressLine2.clear();
		txtAddressLine2.sendKeys(address2);
	}
	public void enterAddressLine3(String address3) {
		webUtility.moveToElement(driver, txtAddressLine3);
		txtAddressLine3.clear();
		txtAddressLine3.sendKeys(address3);
	}
	public void enterPostCode(String postCode) {
		txtPostCode.clear();
		txtPostCode.sendKeys(postCode);
	}
	public void enterCity(String city) {
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	public void enterState(String state) {
		txtState.clear();
		txtState.sendKeys(state);
	}
	public void chooseCountry(String country) {
		webUtility.moveToElement(driver, txtCountry);
		txtCountry.click();
		switch (country.toLowerCase()) {
		case "australian":
			selectAustralian.click();
			break;
		case "united states":
			selectUS.click();
			break;
		}
	}
	public void enterMobileNumber(String mobileNumber) {
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(mobileNumber);
	}
	public void enterHomePhoneNumber(String phoneNumber) {
		txtHomePhoneNumber.clear();
		txtHomePhoneNumber.sendKeys(phoneNumber);
	}
	public void enterEmailAddress(String email) {
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(email);
	}
	public void enterHireDate(String hireDate) { 
		dtHireDate.clear();
		dtHireDate.sendKeys(hireDate);
		dtHireDate.sendKeys(Keys.ENTER);
	}
	public void enterProbationExpiryDate(String probationExpiryDate) {
		dtProbationExpiryDate.sendKeys(probationExpiryDate);
		dtProbationExpiryDate.sendKeys(Keys.ENTER);
	}
	public void choosePosition(String position) {
		webUtility.moveToElement(driver, txtPosition);
		txtPosition.click();
		switch (position.toLowerCase()) {
		case "echo":
			selectEcho.click();
			break;
		case "qco":
			selectQco.click();
			break;
		}
	}
	public void chooseScheduleRule() {
		webUtility.moveToElement(driver, txtScheduleRule);
		txtScheduleRule.click();
	}
	public void selectScheduleRule() {
		webUtility.moveToElement(driver, selectScheduleRule);
		selectScheduleRule.click();
	}
	public void choosetxtPayGroup() {
		webUtility.moveToElement(driver, txtPayGroup);
		txtPayGroup.click();
	}
	public void selectPayGroup() {
		selectPayGroup.click();
	}
	public void chooseOvertimeSetting() {
		txtOvertimeSetting.click();
	}
	public void selectOtSetting() {
		selectOtSetting.click();
	}
	public void clickTabRole() {
		webUtility.moveToElement(driver, tabRole);
		tabRole.click();
	}
	public void clickPrimaryRole() {
		cmbPrimaryRole.click();
	}
	public void selectPrimaryRoleSearch() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, cmbPrimaryRoleSearch);
		cmbPrimaryRoleSearch.click();
	}
	public void selectAvailableListBox() throws InterruptedException {
		Thread.sleep(2000);
		action.moveToElement(availableListBox).perform();
		select = new Select(availableListBox);
		select.selectByIndex(0);               
	}
	//	move a singel skill from available skills to selected skill for single role  
	public void setAvailableSingleSkillMoveToSelectedSkill() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}
	public void clickTabContacts() {
		webUtility.moveToElement(driver, tabContacts);
		tabContacts.click();
	}
	public void clickAddNewContact() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, btnAddNewContact);
		btnAddNewContact.click();
	}
	public void enterContactName(String contactName) throws InterruptedException {
		Thread.sleep(2000);
		txtContactName.clear();
		txtContactName.sendKeys(contactName);
	}
	public void selectRelationship(String relation){
		//cmbRelationship.click();
		webUtility.moveToElement(driver, cmbRelationship);
		cmbRelationship.click();
		switch (relation.toLowerCase()) {
		case "spouse":
			webUtility.moveToElement(driver, selectSpouse);
			selectSpouse.click();
			break;
		}
	}
	public void enterContactAddressLine1(String address) {
		webUtility.moveToElement(driver, txtContactAddressLine1);
		txtContactAddressLine1.clear();
		txtContactAddressLine1.sendKeys(address);
	}
	public void enterContactAddressLine2(String address) {
		webUtility.moveToElement(driver, txtContactAddressLine2);
		txtContactAddressLine2.clear();
		txtContactAddressLine2.sendKeys(address);
	}
	public void enterContactAddressLine3(String address) {
		webUtility.moveToElement(driver, txtContactAddressLine3);
		txtContactAddressLine3.clear();
		txtContactAddressLine3.sendKeys(address);
	}
	public void enterContactPostCode(String postCode) {
		txtContactPostCode.clear();
		txtContactPostCode.sendKeys(postCode);
	}
	public void enterContactCity(String city) {
		txtContactCity.clear();
		txtContactCity.sendKeys(city);
	}
	public void enterContactState(String state) {
		txtContactState.clear();
		txtContactState.sendKeys(state);
	}
	public void chooseContactCountry(String country) {
		webUtility.moveToElement(driver, txtContactCountry);
		txtContactCountry.click();
		switch (country.toLowerCase()) {
		case "australian":
			selectAustralian.click();
			break;
		case "united states":
			selectUS.click();
			break;
		case"oman":
			selectOman.click();
			break;
		}
	}
	public void enterContactMobileNumber(String mobileNumber) {
		txtContactMobileNumber.sendKeys(mobileNumber);
	}
	public void enterContactHomePhoneNumber(String phoneNumber) {
		webUtility.moveToElement(driver, txtContactHomePhoneNumber);
		txtContactHomePhoneNumber.sendKeys(phoneNumber);
	}
	public void enterContactEmailAddress(String email) {
		txtContactEmailAddress.sendKeys(email);
	}
	public void clickBtnSaveContact() {
		webUtility.moveToElement(driver, btnSaveContact);
		btnSaveContact.click();
	}

	public void clickNotificationPopup() throws Exception {
		Thread.sleep(1000);
		action.moveToElement(notificationPopup).perform();
		notificationPopup.click();
	}
	public void clickTabAttachments() {
		webUtility.moveToElement(driver, tabAttachments);
		tabAttachments.click();	
	}
	public void clickBtnAddEmployeeAttachment() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, btnAddEmployeeAttachment);
		btnAddEmployeeAttachment.click();
	}
	public void enterTxtDocumentName(String docuName) {
		txtDocumentName.sendKeys(docuName);
	}
	public void enterTxtDescription(String description) {
		txtDescription.sendKeys(description);	
	}
	public void clickBtnAddAttachment() {
		webUtility.moveToElement(driver, btnAddAttachment);
		btnAddAttachment.click();
	}
	public void selectFileToUpload() {
		File file= new File(".\\src\\test\\resources\\TestData\\Jiviews Team.jpg");
		String  absolutePath = file.getAbsolutePath();
		btnFileToUpload.sendKeys(absolutePath);
	}
	public void clickBtnUpload() {
		btnUpload.click();
	}
	public void clickBtnSaveAttachment() {
		btnSaveAttachment.click();
	}
	public void clickTabMiscellaneous() {
		webUtility.moveToElement(driver, tabMiscellaneous);
		tabMiscellaneous.click();
	}
	public void activeCheckBoxShiftEmp() {
		checkBoxShiftEmp.click();
	}
	public void clickTabESS()  {
		webUtility.moveToElement(driver, tabESS);
		tabESS.click();
	}
	public void clickBtnAddLeaveProfile() throws InterruptedException {
		Thread.sleep(1000);
		webUtility.moveToElement(driver, btnAddLeaveProfile);
		btnAddLeaveProfile.click();
	}
	public void chooseEmpLeaveProfileName() throws InterruptedException {
		Thread.sleep(1000);
		webUtility.moveToElement(driver, cmbEmpLeaveProfileName);
		cmbEmpLeaveProfileName.click();
	}
	public void selectEmpProfileName() {
		webUtility.moveToElement(driver, selectEmpProfileName);
		selectEmpProfileName.click();
	}
	public void enterLeaveProfileEndDate() {
		dtLeaveProfileEndDate.clear();
		dtLeaveProfileEndDate.sendKeys("17-11-2099");

	}
	public void clickBtnSaveLeaveProfile() {
		btnSaveLeaveProfile.click();
	}
	public void clickBtnAddEmpWorkflowRoute() {
		webUtility.moveToElement(driver, btnAddEmpWorkflowRoute);
		btnAddEmpWorkflowRoute.click();
	}
	public void chooseModuleName() {
		//		webUtility.moveToElement(driver, selectModuleName);
		selectModuleName.click();
		//		switch (moduleName.toLowerCase()) {
		//		case "HajLeav":
		//			webUtility.moveToElement(driver, selectHajLeave);
		//			selectHajLeave.click();
		//			break;
		//		case "Leave":
		//			selectLeave.click();
		//			break;
		//		case"RequestLeave":
		//			selectRequestLeave.click();
		//			break;
		//		case"SpecialLeave":
		//			selectSpecialLeave.click();
		//			break;
		//		case"TimeAttendance":
		//			selectTimeAttendance.click();
		//			break;
		//		case"TimeOff":
		//			selectTimeOff.click();
		//			break;
		//		case"UnControlledLeave":
		//			selectUnControlledLeave.click();
		//			break;
		//		case"UnpaidLeave":
		//			selectUnpaidLeave.click();
		//			break;
		//		}
	}
	public void selectHajLeave() {
		webUtility.moveToElement(driver, selectHajLeave);
		selectHajLeave.click();
	}
	public void chooseRouteName() {
		webUtility.moveToElement(driver, selectRouteName);
		selectRouteName.click();
		//		switch (routeName.toLowerCase()) {
		//		case "LeaveRoute":
		//			webUtility.moveToElement(driver, selectLeaveRoute);
		//			selectLeaveRoute.click();
		//			break;
		//		case "Route01":
		//			selectRoute01.click();
		//			break;
		//		}
	}
	public void selectLeaveRoute() {
		webUtility.moveToElement(driver, selectLeaveRoute);
		selectLeaveRoute.click();
	}
	public void enterWorkFlowStartDate(String workFlowStartDate) {
		dtWorkFlowStartDate.clear();
		dtWorkFlowStartDate.sendKeys(workFlowStartDate);
		dtWorkFlowStartDate.sendKeys(Keys.ENTER);
	}
	public void enterWorkFlowEndDate(String workFlowEndDate) {
		dtWorkFlowEndDate.clear();
		dtWorkFlowEndDate.sendKeys(workFlowEndDate);
		dtWorkFlowEndDate.sendKeys(Keys.ENTER);
	}
	public void clickBtnSaveEmpWorkflowRoute() {
		webUtility.moveToElement(driver, btnSaveEmpWorkflowRoute);
		btnSaveEmpWorkflowRoute.click();
	}
	public void pressBtnSaveEmployee() throws InterruptedException {
		//		webUtility.moveToElement(driver, btnSaveEmployee);
		//		btnSaveEmployee.click();
		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnSaveEmployee);
				break; 
			} catch (ElementClickInterceptedException e) {
			}
		}
	}
	//............................................../////////////////////////////////............................................\

	public void clickonBtnEdit() {
		btnEdit.click();
		
	}
	public void enableCheckBoxIsActive() throws InterruptedException{
//		scrollAndClick(driver, checkBoxIsActive);
		webUtility.moveToElement(driver, checkBoxIsActive);
		Thread.sleep(5000);
		checkBoxIsActive.click();
		
	}
	public void updateRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		// Iterate through rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isEnabled()) {
				clickonBtnEdit();
//				checkboxFound = true;
				break;
			}
		}

		// If no enabled checkbox found on the current page, go to the next page and try again
		if (!checkboxFound) {
			goToNextPageAndUpdate();
		}
	}
	private void goToNextPageAndUpdate() throws InterruptedException {
		try {
			scrollAndClick(driver, nextPage); // Click on the next page button
			scrollUp(driver);
			updateRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page

		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}
	public void reactivateRowsWithEnabledCheckbox() throws InterruptedException {
		boolean checkboxFound = false;
		// Iterate through rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			if (!checkbox.isEnabled()) {
				clickonBtnEdit();
				enableCheckBoxIsActive();
				//...................................................
//				checkboxFound = true;
				break;
			}
		}

		// If no enabled checkbox found on the current page, go to the next page and try again
		if (checkboxFound) {
			goToNextPageAndReactivate();
		}
	}
	private void goToNextPageAndReactivate() throws InterruptedException {
		try {
			scrollAndClick(driver, nextPage); // Click on the next page button
			scrollUp(driver);
			reactivateRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page

		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}
	public void clickBtnDuplicate() {
		btnDuplicate.click();
	}
	public void clickonTabExcludedSkills() throws Exception {
		Thread.sleep(5000);
		webUtility.moveToElement(driver, tabExcludedSkills);
		tabExcludedSkills.click();
	}
	public void clickonBtnAddNewExcludedSkills() throws InterruptedException {
		Thread.sleep(1000);
		webUtility.moveToElement(driver, btnAddNewExcludedSkills);
		btnAddNewExcludedSkills.click();	
	}
	public void selecttxtSkillDescription() throws InterruptedException {
		Thread.sleep(1000);
		//		webUtility.moveToElement(driver, txtSkillDescription);
		txtSkillDescription.click();
	}
	public void chooseSkill() {
		dropDownSkill.click();
	}
	public void enterExcludedSkillStartDate(String skillStartDate) {
		dtExcludedSkillStartDate.clear();
		dtExcludedSkillStartDate.sendKeys(skillStartDate);
		dtExcludedSkillStartDate.sendKeys(Keys.ENTER);
	}
	public void enterExcludedSkillEndDate(String skillEndDate) {
		dtExcludedSkillEndDate.clear();
		dtExcludedSkillEndDate.sendKeys(skillEndDate);
		dtExcludedSkillEndDate.sendKeys(Keys.ENTER);
	}
	public void entertxtExcludedSkillReason(String reason) {
		txtExcludedSkillReason.sendKeys(reason);
	}
	public void clickonBtnSaveExcludedSkill() {
		btnSaveExcludedSkill.click();
	}
	public void clickonTabDisciplinary() {
		webUtility.moveToElement(driver, tabDisciplinary);
		tabDisciplinary.click();
	}
	public void deleteDisciplinaryIfPresentAndClickAddSuspension(WebDriver driver) throws InterruptedException {
		try {
			webUtility.ElementClickable(driver, btnDeleteDisciplinary);
			btnDeleteDisciplinary.click();
		} catch (Exception e) {
			// If btnDeleteDisciplinary is not present or not clickable, do nothing
		}
		btnAddSuspension.click();
	}
	public void enterdtDisciplinaryStart(String disciplinaryStartDate) throws InterruptedException {
		Thread.sleep(1000);
		dtDisciplinaryStart.clear();
		dtDisciplinaryStart.sendKeys(disciplinaryStartDate);
		dtDisciplinaryStart.sendKeys(Keys.ENTER);
	}
	public void enterDisciplinaryEnd(String disciplinaryEndDate) {
		dtDisciplinaryEnd.clear();
		dtDisciplinaryEnd.sendKeys(disciplinaryEndDate);
		dtDisciplinaryEnd.sendKeys(Keys.ENTER);
	}
	public void clickonExcludeAccrualProcess() throws InterruptedException {
		Thread.sleep(1000);
		chkExcludeAccrualProcess.click();
	}
	public void entertxtDisciplinaryRemarks(String remark) {
		txtDisciplinaryRemarks.sendKeys(remark);
	}
	public void clickonbtnSaveDisciplinaryDetails() {
		btnSaveDisciplinaryDetails.click();
	}
	
	public void clickonIsEmployeeTerminated() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, chkIsEmployeeTerminated);
		chkIsEmployeeTerminated.click();
	}
	public void clickonBtnYes() throws InterruptedException {
		Thread.sleep(2000);
		webUtility.moveToElement(driver, btnYes);
		btnYes.click();
	}
	public void enterEmployeeTerminatedDate(String terminatedDate) {
		dtEmployeeTerminatedDate.clear();
		dtEmployeeTerminatedDate.sendKeys(terminatedDate);
		dtEmployeeTerminatedDate.sendKeys(Keys.ENTER);
	}
	public void entertxtEmployeeTerminationRemarks(String remark) {
		txtEmployeeTerminationRemarks.sendKeys(remark);
	}
	public void clickonTabSecurity() {
		tabSecurity.click();
	}
	public void clickonBtnAddEmployeeOU() {
		btnAddEmployeeOU.click();
	}
	public void enterOrganizationName() {
		selectOrganizationName.click();
	}
	public void chooseOrgUnit() {
		chooseOrgUnit.click();
	}
	public void enterShareOrgUnitStartDate(String orgUnitStartDate) {
		dtShareOrgUnitStartDate.sendKeys(orgUnitStartDate);
	}
	public void enterdtShareOrgUnitEndDate(String orgUnitEndDate) {
		dtShareOrgUnitEndDate.sendKeys(orgUnitEndDate);
	}

	public void performDeleteAction() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDeleteEmployee);
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
				//				scrollAndClick(driver, checkbox);
				checkbox.click();
				performDeleteAction();
				checkboxFound = true;
				break;
			}
		}

		// If no enabled checkbox found on the current page, go to the next page and try again
		if (!checkboxFound) {
			goToNextPageAndDelete();
		}
	}

	private void goToNextPageAndDelete() throws InterruptedException {
		try {
			scrollAndClick(driver, nextPage); // Click on the next page button
			scrollUp(driver);
			deleteRowsWithEnabledCheckbox(); // Recursive call to check for checkboxes on the next page

		} catch (ElementClickInterceptedException e) {
			// Handle the exception if necessary
		}
	}
	// Method to perform scroll-up action
	private void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -150)"); // Adjust the scroll distance as needed
	}
	public void cickonBtnSaveEmployeeOU() {
		btnSaveEmployeeOU.click();
	}
	public void chooseEmpBasis(String empBasis) throws InterruptedException {
		//		Thread.sleep(5000);
		webUtility.moveToElement(driver, chooseEmpBasis);
		chooseEmpBasis.click();
		switch (empBasis) {
		case "Contract Emp":
			selectContractEmp.click();
			break;
		case "Fixed Emp":
			selectFixedEmp.click();
			break;
		case "White Color Emp":
			selectWhiteClrEmp.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid employment basis: " + empBasis);
		}
	}
	public void chooseRosterGroup(String rosterGroup) {
		webUtility.moveToElement(driver, chooseRosterGroup);
		chooseRosterGroup.click();
		switch (rosterGroup) {
		case "Default Roster  Group":
			selectDftRosterGroup.click();
			break;
		}
	}
	public void chooseRoleGroup(String roleGroup) {
		webUtility.moveToElement(driver, chooseRoleGroup);
		chooseRoleGroup.click();
		switch (roleGroup) {
		case "RTGO Operator":
			selectRoleGroup.click();
			break;
		}
	}
	public void chooseEmpStatus(String empStatus) {
		webUtility.moveToElement(driver, chooseEmpStatus);
		chooseEmpStatus.click();
		switch (empStatus) {
		case "Active":
			selectActiveEmp.click();
			break;
		case "Terminated":
			selectTerminatedEmp.click();
			break;
		}
	}
	public void performSearchEmployeeProfile() {
		btnSearchEmployeeProfile.click();
	}
	public void performSearchBar(String empNo){
		txtSearchBar.sendKeys(empNo);	
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	public void getAddNewContactSuccessMsg() {
		String actualResult =addNewContactSuccessMsg.getText();
		Assert.assertTrue(actualResult.contains("Add New Contact - Success"));
	}
	public void getAttachmentcreatedSuccessfullyMsg() {
		String actualResult = attachmentcreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Attachment created Successfully"));
	}
	public void getEmployeeProfilecreatedSuccessfullyMsg() {
		String actualResult = employeeProfilecreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Employee Profile created successfully"));
	}
	public void getaddExcludedSkillSuccessMsg() {
		String actualResult = addExcludedSkillSuccessMsg.getText();
		Assert.assertTrue(actualResult.contains("Add Excluded Skill - Success"));
	}
	public void getAddDisciplinaryActionSuccessMsg() {
		String actualResult = addDisciplinaryActionSuccessMsg.getText();
		Assert.assertTrue(actualResult.contains("Add Disciplinary Action - Success"));
	}

	//-------------------------------------------------#############**********####################------------------------------------------//

	public void createEmpProfile(FakeEmployee fakeEmployee) throws Exception {
		clickBtnAddEmployee();
		//		    	clickBasicProfile();
		enterEmployeeNumber(fakeEmployee.getEmpNumber());
		enterBadgeNumber(fakeEmployee.getBadgeNumber());
		enterFirstName(fakeEmployee.getFirstName());
		enterMiddleName(fakeEmployee.getMiddleName());
		enterLastName(fakeEmployee.getLastName());
		enterDateBirthDate(fakeEmployee.getDOB());
		chooseEmploymentBasis();
		chooseEmpBasisContract();
		chooseGender("male");
		chooseMeritalStatus("married");
		chooseTitle("mr.");
		chooseReligion("hindu");
		enterAddressLine1(fakeEmployee.getAddress());
		enterAddressLine2(fakeEmployee.getAddress());
		enterAddressLine3(fakeEmployee.getAddress());
		enterPostCode(fakeEmployee.getPostCode());
		enterCity(fakeEmployee.getCity());
		enterState(fakeEmployee.getState());
		chooseCountry("australian");
		enterMobileNumber(fakeEmployee.getMobileNumber());
		enterHomePhoneNumber(fakeEmployee.getPhoneNumber());
		enterEmailAddress(fakeEmployee.getEmail());
		enterHireDate(fakeEmployee.getHireDate());
		enterProbationExpiryDate(fakeEmployee.getProbationExpirydate());
		choosePosition("echo");
		chooseScheduleRule();
		selectScheduleRule();
		choosetxtPayGroup();
		selectPayGroup();
		chooseOvertimeSetting();
		selectOtSetting();
		clickTabRole();
		clickPrimaryRole();
		selectPrimaryRoleSearch();
		selectAvailableListBox();
		setAvailableSingleSkillMoveToSelectedSkill();
		clickTabContacts();
		clickAddNewContact();
		enterContactName(fakeEmployee.getFirstName());
		selectRelationship("spouse");
		enterContactAddressLine1(fakeEmployee.getAddress());
		enterContactAddressLine2(fakeEmployee.getAddress());
		enterContactAddressLine3(fakeEmployee.getAddress());
		enterContactPostCode(fakeEmployee.getPostCode());
		enterContactCity(fakeEmployee.getCity());
		enterContactState(fakeEmployee.getState());
		chooseContactCountry("oman");
		enterContactMobileNumber(fakeEmployee.getMobileNumber());
		enterContactHomePhoneNumber(fakeEmployee.getPhoneNumber());
		enterContactEmailAddress(fakeEmployee.getEmail());
		clickBtnSaveContact();
		getAddNewContactSuccessMsg();
		clickNotificationPopup();
		clickTabMiscellaneous();
		activeCheckBoxShiftEmp();
		clickTabESS();
		clickBtnAddLeaveProfile();
		chooseEmpLeaveProfileName();
		selectEmpProfileName();
		enterLeaveProfileEndDate();
		clickBtnSaveLeaveProfile();
		clickBtnAddEmpWorkflowRoute();
		chooseModuleName();
		selectHajLeave();
		chooseRouteName();
		selectLeaveRoute();
		enterWorkFlowStartDate(fakeEmployee.getWorkFlowStartDate());
		enterWorkFlowEndDate(fakeEmployee.getWorkFlowEndDate());
		clickBtnSaveEmpWorkflowRoute();
		clickTabAttachments();
		clickBtnAddEmployeeAttachment();
		enterTxtDocumentName(fakeEmployee.getDocumentName()); 
		enterTxtDescription(fakeEmployee.getDescription());
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		clickBtnSaveAttachment();
		getAttachmentcreatedSuccessfullyMsg();
		clickNotificationPopup();
		pressBtnSaveEmployee();
		getEmployeeProfilecreatedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void updateEmpProfile(FakeEmployee fakeEmployee) throws Exception {
//		clickonBtnEdit();
		updateRowsWithEnabledCheckbox();
		enterFirstName(fakeEmployee.getFirstName());
		enterMiddleName(fakeEmployee.getMiddleName());
		enterLastName(fakeEmployee.getLastName());
		enterDateBirthDate(fakeEmployee.getDOB());
		enterAddressLine1(fakeEmployee.getAddress());
		enterMobileNumber(fakeEmployee.getMobileNumber());
		enterHomePhoneNumber(fakeEmployee.getPhoneNumber());
		enterEmailAddress(fakeEmployee.getEmail());
		clickonTabExcludedSkills();
		clickonBtnAddNewExcludedSkills();
		selecttxtSkillDescription();
		chooseSkill();
		enterExcludedSkillStartDate(fakeEmployee.getSkillStartDate());
		enterExcludedSkillEndDate(fakeEmployee.getSkillEndDate());
		entertxtExcludedSkillReason(fakeEmployee.getDescription());
		clickonBtnSaveExcludedSkill();
		getaddExcludedSkillSuccessMsg();
		clickNotificationPopup();
		clickonTabDisciplinary();
		deleteDisciplinaryIfPresentAndClickAddSuspension(driver);
		enterdtDisciplinaryStart(fakeEmployee.getSkillStartDate());
		enterDisciplinaryEnd(fakeEmployee.getSkillEndDate());
		clickonExcludeAccrualProcess();
		entertxtDisciplinaryRemarks(fakeEmployee.getDescription());
		clickonbtnSaveDisciplinaryDetails();
		getAddDisciplinaryActionSuccessMsg();
		clickNotificationPopup();
		clickonTabSecurity();
		clickonBtnAddEmployeeOU();
		enterOrganizationName();
		chooseOrgUnit();
		enterShareOrgUnitStartDate(fakeEmployee.getSkillStartDate());
		enterdtShareOrgUnitEndDate(fakeEmployee.getSkillEndDate());
		cickonBtnSaveEmployeeOU();
//		clickNotificationPopup();
		pressBtnSaveEmployee();
//		getEmployeeProfilecreatedSuccessfullyMsg();
//		clickNotificationPopup();
	}
	public void duplicateEmpProfile(FakeEmployee fakeEmployee) throws Exception {
		clickBtnDuplicate();
		enterEmployeeNumber(fakeEmployee.getEmpNumber());
		enterBadgeNumber(fakeEmployee.getBadgeNumber());
		enterFirstName(fakeEmployee.getFirstName());
		enterMiddleName(fakeEmployee.getMiddleName());
		enterLastName(fakeEmployee.getLastName());
		enterDateBirthDate(fakeEmployee.getDOB());
		enterHomePhoneNumber(fakeEmployee.getPhoneNumber());
		enterEmailAddress(fakeEmployee.getEmail());
		//		Thread.sleep(3000);
		//		clickTabMiscellaneous();
		//		activeCheckBoxShiftEmp();
		pressBtnSaveEmployee();
		getEmployeeProfilecreatedSuccessfullyMsg();
		clickNotificationPopup();
	}
	public void terminateEmpProfile() throws Exception {
		clickonBtnEdit();
		Thread.sleep(15000);
		clickonTabDisciplinary();
		
		 if (chkIsEmployeeTerminated.isEnabled()) {
		        // Checkbox is enabled, proceed with termination
		        clickonIsEmployeeTerminated();
		        clickonBtnYes();
		        enterEmployeeTerminatedDate(fakeEmployee.getTerminatedDate());
		        entertxtEmployeeTerminationRemarks(fakeEmployee.getDescription());
		        pressBtnSaveEmployee();
		        // Uncomment the line below if there is a notification popup
		        // clickNotificationPopup();
		    } else {
		        System.out.println("Employee is already terminated.");
		    }
		
//		clickonIsEmployeeTerminated();
//		clickonBtnYes();
//		enterEmployeeTerminatedDate(fakeEmployee.getTerminatedDate());
//		entertxtEmployeeTerminationRemarks(fakeEmployee.getDescription());
//		pressBtnSaveEmployee();
		//		clickNotificationPopup();
	}
	public void deleteEmpProfile() throws Exception {
		deleteRowsWithEnabledCheckbox();
		clickonBtnYes();
		clickNotificationPopup();
	}
	public void reactivateEmpProfile() throws InterruptedException {
		reactivateRowsWithEnabledCheckbox();
		pressBtnSaveEmployee();
	}
	public void searchEmpProfile() throws InterruptedException {
		chooseEmpBasis("Contract Emp");
		performSearchEmployeeProfile();
	}
	public void searchRosterGroup() {
		chooseRosterGroup("Default Roster  Group");
		performSearchEmployeeProfile();
	}
	public void searchRoleGroup() {
		chooseRoleGroup("roleGroup");
		performSearchEmployeeProfile();

	}
	public void searchEmpStatus() {
		chooseEmpStatus("Active");
		performSearchEmployeeProfile();
	}
	public void enterEmpNoInSearchBar() {
		performSearchBar("00418009");
	}
}