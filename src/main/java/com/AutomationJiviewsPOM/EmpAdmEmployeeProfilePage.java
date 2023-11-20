package com.AutomationJiviewsPOM;



import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//span[text()='IsActive?']")
	private WebElement checkBox;

	@FindBy(xpath = "//a[text()='Roles']")
	private WebElement tabRole;

	@FindBy(xpath = "//span[@id='select2-cmbPrimaryRole-container']")
	private WebElement cmbPrimaryRole;

	@FindBy(xpath = "//ul[@id='select2-cmbPrimaryRole-results']")
	private WebElement cmbPrimaryRoleSearch;
	@FindBy(xpath = "(//li[contains(text(),'RTGO')])[2]")
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
	@FindBy(xpath = "(//td[@class=' select-checkbox'])[2]")
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

	public EmpAdmEmployeeProfilePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.action= new Actions(driver);
	}

	public void clickBtnAddEmployee() {
		btnAddEmployee.click();
	}

	public void clickBasicProfile() {
		//		        webUtility.moveToElement(driver, basicProfile);
		basicProfile.click();
	}

	public void enterEmployeeNumber(String empNumber) {
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
		txtMobileNumber.sendKeys(mobileNumber);
	}
	public void enterHomePhoneNumber(String phoneNumber) {
		txtHomePhoneNumber.sendKeys(phoneNumber);
	}
	public void enterEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	public void enterHireDate(String hireDate) { //
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
		select.selectByValue("53");               
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
		//		btnFileToUpload.click();
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
	public void chooseEmpLeaveProfileName() {
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



	public void pressBtnSaveEmployee() {
		webUtility.moveToElement(driver, btnSaveEmployee);
		btnSaveEmployee.click();
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
		clickNotificationPopup();
		clickTabMiscellaneous();
		activeCheckBoxShiftEmp();
		
		clickTabESS();
		clickBtnAddLeaveProfile();
		chooseEmpLeaveProfileName();
		selectEmpProfileName();
		enterLeaveProfileEndDate();
		clickBtnSaveLeaveProfile();

		clickTabAttachments();
		clickBtnAddEmployeeAttachment();
		enterTxtDocumentName(fakeEmployee.getDocumentName()); 
		enterTxtDescription(fakeEmployee.getDescription());
		clickBtnAddAttachment();
		selectFileToUpload();
		clickBtnUpload();
		clickBtnSaveAttachment();
		clickNotificationPopup();
		
		pressBtnSaveEmployee();
		clickNotificationPopup();
	}
}