package com.AutomationJiviewsPOM;



import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.AutomationJiviewsGeneric.ReusableComponent;

public class E10_2695_EmpAdmEmployeeProfilePage 
{

	WebDriver driver ;
	ReusableComponent Rc ;
	String employeeNumber;
	String firstName;
	String empNameID;

	@FindBy(xpath = "//div[@id='dvOrgUnitDropdown']/a")
	WebElement dvOrgUnitDropdown;

	@FindBy(xpath = "//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li")
	List<WebElement> OrgUnit; // AUTO OU

	@FindBy(xpath = "//div[@id='dvApplicationMenuItems']")
	WebElement dvApplicationMenuItems;

	@FindBy(xpath = "//div[@id='dvJiViewsMenuItems']/a")
	List<WebElement> MainMenu; // Employee Administration

	@FindBy(xpath = "//ul[@id='ulApplicationMenu']/li/a")
	WebElement ulApplicationMenu; // Employee

	@FindBy(xpath = "(//ul[@class='sidenav-menu'])[2]/li")
	List<WebElement> sideNavMenu; // Employee Profile

	@FindBy(xpath = "//div[text()='Employee Profile']/..")
	WebElement empProfile; 

	@FindBy(xpath = "//button[@id='btnAddEmployee']")
	WebElement btnAddEmployee;

	@FindBy(xpath = "//a[@class='nav-link active show']")
	WebElement basicProfile;

	@FindBy(xpath = "//input[@id='txtEmployeeNumber']")
	WebElement txtEmployeeNumber;

	@FindBy(xpath = "//input[@id='txtBadgeNumber']")
	WebElement txtBadgeNumber;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//span[@id='contactsEmpNoName']")
	WebElement contactsEmpNoName; 

	@FindBy(xpath = "//input[@id='txtMiddleName']")
	WebElement txtMiddleName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='txtDisplayName']")
	WebElement txtDisplayName;

	@FindBy(xpath = "//input[@id='dtBirthDate']")
	WebElement dtBirthDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[10]")
	WebElement birthDate;


	@FindBy(xpath = "//span[@id='select2-cmbEmploymentBasis-container']")
	WebElement employmentBasis;
	@FindBy(xpath = "//li[text()='Contract Emp - Contract Emp']")
	WebElement selectEmpBasisContract;
	@FindBy(xpath = "//li[text()='Fixed Emp - Fixed Emp']")
	WebElement selectEmpBasisFixed;
	@FindBy(xpath = "//li[text()='White Color Emp - White Color Emp']")
	WebElement selectEmpBasisWhiteClr;

	@FindBy(xpath = "//span[@id='select2-cmbGender-container']")
	WebElement txtGender; 
	@FindBy(xpath = "//li[text()='Female']")
	WebElement selectFemale;
	@FindBy(xpath = "//li[text()='Male']")
	WebElement selectMale;
	@FindBy(xpath = "//li[text()='Others']")
	WebElement selectOthers;


	@FindBy(xpath = "//span[@id='select2-cmbMaritalStatus-container']")
	WebElement meritalStatus;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectMarried;
	@FindBy(xpath = "//li[text()='Single']")
	WebElement selectSingle;

	@FindBy(xpath = "//span[@id='select2-cmbTitle-container']")
	WebElement txtTitle;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectMr;
	@FindBy(xpath = "//li[text()='Test Title']")
	WebElement selectTestTitle;

	@FindBy(xpath = "//span[@id='select2-cmbReligion-container']")
	WebElement txtReligion;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectHindu;
	@FindBy(xpath = "//li[text()='Muslim']")
	WebElement selectMuslim;

	@FindBy(xpath = "//input[@id='txtAddressLine1']")
	WebElement txtAddressLine1;
	@FindBy(xpath = "//input[@id='txtAddressLine2']")
	WebElement txtAddressLine2;
	@FindBy(xpath = "//input[@id='txtAddressLine3']")
	WebElement txtAddressLine3;

	@FindBy(xpath = "//input[@id='txtPostCode']") 
	WebElement txtPostCode;

	@FindBy(xpath = "//input[@id='txtCity']")
	WebElement txtCity;

	@FindBy(xpath = "//input[@id='txtState']")
	WebElement txtState;

	@FindBy(xpath = "//span[@id='select2-cmbCountry-container']")
	WebElement txtCountry;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectAustralian;
	@FindBy(xpath = "//li[text()='United States']")
	WebElement selectUS;


	@FindBy(xpath = "//input[@id='txtMobileNumber']")
	WebElement txtMobileNumber;

	@FindBy(xpath = "//input[@id='txtHomePhoneNumber']")
	WebElement txtHomePhoneNumber;

	@FindBy(xpath = "//input[@id='txtEmailAddress']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='dtHireDate']")
	WebElement dtHireDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[10]")
	WebElement hireDate;

	@FindBy(xpath = "//input[@id='dtProbationExpiryDate']")
	WebElement dtProbationExpiryDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[29]")
	WebElement probationExpiryDate;

	@FindBy(xpath = "//span[@id='select2-cmbPosition-container']")
	WebElement txtPosition;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectEcho;
	@FindBy(xpath = "//li[text()='QCO']")
	WebElement selectQco;

	@FindBy(xpath = "//span[@id='select2-cmbScheduleRule-container']")
	WebElement txtScheduleRule;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement selectScheduleRule;

	@FindBy(xpath = "//span[@id='select2-cmbPayGroup-container']")
	WebElement txtPayGroup;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectPayGroup;

	@FindBy(xpath = "//span[@id='select2-cmbOverTime-container']")
	WebElement txtOvertimeSetting;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectOtSetting;


	@FindBy(xpath = "//a[text()='Roles']")
	WebElement tabRole;

	@FindBy(xpath = "//span[@id='select2-cmbPrimaryRole-container']")
	WebElement cmbPrimaryRole;

	@FindBy(xpath = "//ul[@id='select2-cmbPrimaryRole-results']")
	WebElement cmbPrimaryRoleSearch;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement selectSkill;

	@FindBy(xpath = "//select[@id='bootstrap-duallistbox-nonselected-list_']")
	WebElement availableListBox;

	// select for move signle skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	WebElement selectMoveSingle;
	//		select for move multiple skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	WebElement selectMoveAll;

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement tabContacts;

	@FindBy(xpath = "//button[@id='btnAddNewContact']")
	WebElement btnAddNewContact;

	@FindBy(xpath = "//input[@id='txtContactName']")
	WebElement txtContactName;

	@FindBy(xpath = "//span[@id='select2-cmbRelationship-container']")
	WebElement cmbRelationship;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectSpouse;

	@FindBy(xpath = "//input[@id='txtContactAddressLine1']")
	WebElement txtContactAddressLine1;
	@FindBy(xpath = "//input[@id='txtContactAddressLine2']")
	WebElement txtContactAddressLine2;
	@FindBy(xpath = "//input[@id='txtContactAddressLine3']")
	WebElement txtContactAddressLine3;
	@FindBy(xpath = "//input[@id='txtContactPostCode']")
	WebElement txtContactPostCode;
	@FindBy(xpath = "//input[@id='txtContactCity']")
	WebElement txtContactCity;
	@FindBy(xpath = "//input[@id='txtContactState']")
	WebElement txtContactState;

	@FindBy(xpath = "//span[@id='select2-cmbContactCountry-container']")
	WebElement txtContactCountry;
	@FindBy(xpath = "//li[text()='Oman']")
	WebElement selectOman;

	@FindBy(xpath = "//input[@id='txtContactMobileNumber']")
	WebElement txtContactMobileNumber;
	@FindBy(xpath = "//input[@id='txtContactHomePhoneNumber']")
	WebElement txtContactHomePhoneNumber;
	@FindBy(xpath = "//input[@id='txtContactEmailAddress']")
	WebElement txtContactEmailAddress;

	@FindBy(xpath = "//button[@id='btnSaveContact']")
	WebElement btnSaveContact;
	@FindBy(xpath = "//div[text()='Add New Contact - Success']")
	WebElement addNewContactSuccessMsg;

	@FindBy(xpath = "//a[text()='Attachments']")
	WebElement tabAttachments;
	@FindBy(xpath = "//button[@id='btnAddEmployeeAttachment']")
	WebElement btnAddEmployeeAttachment;
	@FindBy(xpath = "//input[@id='txtDocumentName']")
	WebElement txtDocumentName;
	@FindBy(xpath = "//input[@id='txtDescription']")
	WebElement txtDescription;
	@FindBy(xpath = "//button[@id='btnAddAttachment']")
	WebElement btnAddAttachment;
	@FindBy(xpath = "(//input[@id='fileToUpload'])[2]") 
	WebElement btnFileToUpload;
	@FindBy(xpath = "//button[text()='Upload']")
	WebElement btnUpload;
	@FindBy(xpath = "//button[@id='btnSaveAttachment']")
	WebElement btnSaveAttachment;
	@FindBy(xpath = "//div[text()='Attachment created Successfully']") 
	WebElement attachmentcreatedSuccessfullyMsg;

	@FindBy(xpath = "//a[text()='Miscellaneous']")
	WebElement tabMiscellaneous;
	@FindBy(xpath = "//span[text()='Shift Employee']")
	WebElement checkBoxShiftEmp;

	@FindBy(xpath = "//a[text()='ESS']")
	WebElement tabESS;

	@FindBy(xpath = "//button[@id='btnAddLeaveProfile']")
	WebElement btnAddLeaveProfile;
	@FindBy(xpath = "//span[@id='select2-cmbEmpLeaveProfileName-container']")
	WebElement cmbEmpLeaveProfileName;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectEmpProfileName;
	@FindBy(xpath = "//input[@id='dtLeaveProfileEndDate']")
	WebElement dtLeaveProfileEndDate;
	@FindBy(xpath = "//td[normalize-space()='19']")
	WebElement leaveProfileEndDate;
	@FindBy(xpath = "//button[@id='btnSaveLeaveProfile']")
	WebElement btnSaveLeaveProfile;

	@FindBy(xpath = "//button[@id='btnAddEmpWorkflowRoute']")
	WebElement btnAddEmpWorkflowRoute;
	@FindBy(xpath = "//span[@id='select2-cmbWorkFlowModuleName-container']")
	WebElement selectModuleName;
	@FindBy(xpath = "//li[text()='HajLeave']")
	WebElement selectHajLeave;
	@FindBy(xpath = "//li[text()='Leave']")
	WebElement selectLeave;
	@FindBy(xpath = "//li[text()='Request Leave']")
	WebElement selectRequestLeave;
	@FindBy(xpath = "//li[text()='SpecialLeave']")
	WebElement selectSpecialLeave;
	@FindBy(xpath = "//li[text()='Time Attendance']")
	WebElement selectTimeAttendance;
	@FindBy(xpath = "//li[text()='Time Off']")
	WebElement selectTimeOff;
	@FindBy(xpath = "//li[text()='UnControlledLeave']")
	WebElement selectUnControlledLeave;
	@FindBy(xpath = "//li[text()='UnpaidLeave']")
	WebElement selectUnpaidLeave;

	@FindBy(xpath = "//span[@id='select2-cmbWorkflowRouteName-container']")
	WebElement selectRouteName;
	@FindBy(xpath = "//li[text()='Leave Route']")
	WebElement selectLeaveRoute;
	@FindBy(xpath = "//li[text()='route 01']")
	WebElement selectRoute01;

	@FindBy(xpath = "//input[@id='dtWorkFlowStartDate']")
	WebElement dtWorkFlowStartDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[10]")
	WebElement workFlowStartDate;
	@FindBy(xpath = "//input[@id='dtWorkFlowEndDate']")
	WebElement dtWorkFlowEndDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[30]")
	WebElement workFlowEndDate;
	@FindBy(xpath = "//button[@id='btnSaveEmpWorkflowRoute']")
	WebElement btnSaveEmpWorkflowRoute;

	@FindBy(className = "toast-close-button")
	WebElement notificationPopup;
	@FindBy(xpath = "//button[@id='btnSaveEmployee']")
	WebElement btnSaveEmployee;
	@FindBy(xpath = "//div[text()='Employee Profile created successfully']")
	WebElement employeeProfileCreatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='//div[text()='Employee Profile']")
	WebElement employeeProfileUpdatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Selected Employee Profile deleted successfully.']")
	WebElement employeeProfileDeletedSuccessfullyMsg;

	// Edit Employee Profile ....................//////////////////////.............................
	@FindBy(xpath = "(//button[@class='btn btn-xs btn-outline-primary icon-btn mx-1 edit'])")
	WebElement btnEdit;
	@FindBy(xpath = "(//button[@class='btn btn-xs btn-outline-primary icon-btn mx-1 duplicate'])[1]")
	WebElement btnDuplicate;

	@FindBy(xpath = "//a[text()='Excluded Skills']")
	WebElement tabExcludedSkills;
	@FindBy(xpath = "//button[@id='btnAddNewExcludedSkills']")
	WebElement btnAddNewExcludedSkills;
	@FindBy(xpath = "//span[@id='select2-cmbExcludedSkill-container']")
	WebElement txtSkillDescription;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	WebElement dropDownSkill;
	@FindBy(xpath = "//input[@id='dtExcludedSkillStartDate']")
	WebElement dtExcludedSkillStartDate;
	@FindBy(xpath = "//input[@id='dtExcludedSkillEndDate']")
	WebElement dtExcludedSkillEndDate;
	@FindBy(xpath = "//input[@id='txtExcludedSkillReason']")
	WebElement txtExcludedSkillReason;
	@FindBy(xpath = "//button[@id='btnSaveExcludedSkill']")
	WebElement btnSaveExcludedSkill;
	@FindBy(xpath = "//div[text()='Add Excluded Skill - Success']")
	WebElement addExcludedSkillSuccessMsg;

	@FindBy(xpath = "//a[text()='Disciplinary']")
	WebElement tabDisciplinary;
	@FindBy(xpath = "//button[@id='btnDeleteDisciplinary']")
	WebElement btnDeleteDisciplinary;
	@FindBy(xpath = "//button[@id='btnAddSuspension']")
	WebElement btnAddSuspension;
	@FindBy(xpath = "//input[@id='dtDisciplinaryStart']")
	WebElement dtDisciplinaryStart;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[5]")
	WebElement disciplinaryStartDate;
	@FindBy(xpath = "//input[@id='dtDisciplinaryEnd']")
	WebElement dtDisciplinaryEnd;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[22]")
	WebElement disciplinaryEndDate;
	@FindBy(xpath = "//span[@class='custom-control-label px-2 py-2 m-2']")
	WebElement chkExcludeAccrualProcess;
	@FindBy(xpath = "//input[@id='txtDisciplinaryRemarks']")
	WebElement txtDisciplinaryRemarks;
	@FindBy(xpath = "//button[@id='btnSaveDisciplinaryDetails']")
	WebElement btnSaveDisciplinaryDetails;
	@FindBy(xpath = "//div[text()='Add Disciplinary Action - Success']")
	WebElement addDisciplinaryActionSuccessMsg;

	//chk Is Employee Terminated
	@FindBy(xpath = "(//div[@class='input-group-text']/label)[3]")
	WebElement chkIsEmployeeTerminated;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;
	@FindBy(xpath = "//input[@id='dtEmployeeTerminatedDate']")
	WebElement dtEmployeeTerminatedDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[28]")
	WebElement terminatedDate;
	@FindBy(xpath = "//textarea[@id='txtEmployeeTerminationRemarks']")
	WebElement txtEmployeeTerminationRemarks;

	@FindBy(xpath = "//a[text()='Security']")
	WebElement tabSecurity;
	@FindBy(xpath = "//button[@id='btnAddEmployeeOU']")
	WebElement btnAddEmployeeOU;
	@FindBy(xpath = "//span[@id='select2-cmbSharedOrgUnit-container']")
	WebElement selectOrganizationName;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement chooseOrgUnit;
	@FindBy(xpath = "//input[@id='dtShareOrgUnitStartDate']")
	WebElement dtShareOrgUnitStartDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[4]")
	WebElement orgUnitStartDate;
	@FindBy(xpath = "//input[@id='dtShareOrgUnitEndDate']")
	WebElement dtShareOrgUnitEndDate;
	@FindBy(xpath = "(//table[@class='table-condensed']/tbody/tr/td)[27]")
	WebElement orgUnitEndDate;
	@FindBy(xpath = "//button[@id='btnSaveEmployeeOU']")
	WebElement btnSaveEmployeeOU;

	@FindBy(xpath = "//table[@id='emp-list']/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//li[@id='emp-list_next']")
	WebElement nextPage;

	@FindBy(xpath = "//button[@id='btnDeleteEmployee']")
	WebElement btnDeleteEmployee;
	@FindBy(xpath = "//span[text()='IsActive?']")
	WebElement checkBoxIsActive;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[1]")
	WebElement chooseEmpBasis;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectContractEmp;
	@FindBy(xpath = "//li[text()='Fixed Emp - Fixed Emp']")
	WebElement selectFixedEmp;
	@FindBy(xpath = "//li[text()='White Color Emp - White Color Emp']")
	WebElement selectWhiteClrEmp;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]")
	WebElement chooseRosterGroup;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectDftRosterGroup;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[3]")
	WebElement chooseRoleGroup;
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	WebElement selectRoleGroup;

	@FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[4]")
	WebElement chooseEmpStatus;
	@FindBy(xpath = "//li[text()='Active']")
	WebElement selectActiveEmp;
	@FindBy(xpath = "//li[text()='Terminated']")
	WebElement selectTerminatedEmp;


	@FindBy(xpath = "//span[text()='×']")
	WebElement removeName; 

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement txtSearchBar;

	@FindBy(xpath = "//button[@id='btnSearchEmployeeProfile']")
	WebElement btnSearchEmployeeProfile;



	public E10_2695_EmpAdmEmployeeProfilePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		this.Rc= new ReusableComponent(driver);
	}



	public void createEmpProfile() throws Exception 
	{
		employeeNumber = Rc.randomInt +  System.currentTimeMillis();
		firstName = Rc.firstName;
		Thread.sleep(2000);
		Rc.explicitWait(dvOrgUnitDropdown, "clickable");
		Rc.handleMultipleElements(dvOrgUnitDropdown, OrgUnit, "AUTO OU", "Auto Ou is not clicked");
		Rc.explicitWait(dvApplicationMenuItems, "clickable");
		Rc.handleMultipleElements(dvApplicationMenuItems, MainMenu, "Employee Administration", "Employee Administration is not clicked");
		Rc.explicitWait(empProfile, "clickable");
		empProfile.click();
		Rc.explicitWait(btnAddEmployee, "clickable");
		btnAddEmployee.click();
		Thread.sleep(4000);
		Rc.explicitWait(txtEmployeeNumber, "visible");
		txtEmployeeNumber.clear();
		txtEmployeeNumber.sendKeys(employeeNumber);
		txtBadgeNumber.clear();
		txtBadgeNumber.sendKeys(Rc.randomInt);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		Rc.explicitWait(txtMiddleName, "visible");
		txtMiddleName.clear();
		txtMiddleName.sendKeys(Rc.lastName);
		Rc.explicitWait(txtLastName, "visible");
		txtLastName.clear();
		txtLastName.sendKeys(Rc.lastName);
		Thread.sleep(1000);
		Rc.explicitWait(dtBirthDate, "clickable");
		dtBirthDate.click();
		birthDate.click();
		//		Rc.explicitWait(employmentBasis, "clickable");
		Rc.moveToElement(employmentBasis);
		employmentBasis.click();
		Rc.moveToElement(selectEmpBasisContract);
		selectEmpBasisContract.click();
		Rc.moveToElement(txtGender);
		txtGender.click();
		Rc.moveToElement(selectMale);
		selectMale.click();
		Rc.moveToElement(meritalStatus);
		meritalStatus.click();
		Rc.moveToElement(selectMarried);
		selectMarried.click();
		Rc.moveToElement(txtTitle);
		txtTitle.click();
		Rc.moveToElement(selectMr);
		selectMr.click();
		Rc.moveToElement(txtReligion);
		txtReligion.click();
		Rc.moveToElement(selectHindu);
		selectHindu.click();
		Rc.moveToElement(txtAddressLine1);
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine2);
		txtAddressLine2.clear();
		txtAddressLine2.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine3);
		txtAddressLine3.clear();
		txtAddressLine3.sendKeys(Rc.address);
		txtPostCode.clear();
		txtPostCode.sendKeys(Rc.randomInt);
		txtCity.clear();
		txtCity.sendKeys(Rc.city);
		txtState.clear();
		txtState.sendKeys(Rc.state);
		Rc.moveToElement(txtCountry);
		txtCountry.click();
		Rc.moveToElement(selectAustralian);
		selectAustralian.click();
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(Rc.mobileNo);
		txtHomePhoneNumber.clear();
		txtHomePhoneNumber.sendKeys(Rc.mobileNo);
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(Rc.email);
		dtHireDate.clear();
		dtHireDate.click();
		hireDate.click();
		dtProbationExpiryDate.clear();
		dtProbationExpiryDate.click();
		probationExpiryDate.click();
		Rc.moveToElement(txtPosition);
		txtPosition.click();
		selectEcho.click();
		Rc.moveToElement(txtScheduleRule);
		txtScheduleRule.click();
		Rc.moveToElement(selectScheduleRule);
		selectScheduleRule.click();
		Rc.moveToElement(txtPayGroup);
		txtPayGroup.click();
		txtOvertimeSetting.click();
		selectOtSetting.click();

		//		***********Click Role Tab ************************

		Rc.moveToElement(tabRole);
		tabRole.click();
		Rc.explicitWait(cmbPrimaryRole, "clickable");
		cmbPrimaryRole.click();
		Rc.explicitWait(cmbPrimaryRoleSearch, "clickable");
		Rc.moveToElement(cmbPrimaryRoleSearch);
		cmbPrimaryRoleSearch.click();
		Thread.sleep(2000);
		Rc.explicitWait(availableListBox, "visible");
		Rc.moveToElement(availableListBox);
		Rc.selectByIndex(availableListBox, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();

		//		***********Click Contact Tab ************************

		Rc.moveToElement(tabContacts);
		tabContacts.click();
		Rc.explicitWait(btnAddNewContact, "clickable");
		Rc.moveToElement(btnAddNewContact);
		btnAddNewContact.click();
		Rc.explicitWait(txtContactName, "visible");
		txtContactName.clear();
		txtContactName.sendKeys(Rc.firstName);
		Rc.moveToElement(cmbRelationship);
		cmbRelationship.click();
		Rc.moveToElement(selectSpouse);
		selectSpouse.click();
		Rc.moveToElement(txtContactAddressLine1);
		txtContactAddressLine1.clear();
		txtContactAddressLine1.sendKeys(Rc.address);
		Rc.moveToElement(txtContactAddressLine2);
		txtContactAddressLine2.clear();
		txtContactAddressLine2.sendKeys(Rc.address);
		Rc.moveToElement(txtContactAddressLine3);
		txtContactAddressLine3.clear();
		txtContactAddressLine3.sendKeys(Rc.address);
		txtContactPostCode.clear();
		txtContactPostCode.sendKeys(Rc.randomInt);
		Rc.moveToElement(txtContactCity);
		txtContactCity.clear();
		txtContactCity.sendKeys(Rc.city);
		txtContactState.clear();
		txtContactState.sendKeys(Rc.state);
		Rc.moveToElement(txtContactCountry);
		txtContactCountry.click();
		selectAustralian.click();
		txtContactMobileNumber.sendKeys(Rc.mobileNo);
		Rc.moveToElement(txtContactHomePhoneNumber);
		txtContactHomePhoneNumber.sendKeys(Rc.mobileNo);
		txtContactEmailAddress.sendKeys(Rc.email);
		Rc.moveToElement(btnSaveContact);
		btnSaveContact.click();
		Rc.explicitWait(addNewContactSuccessMsg, "visible");
		String actualResult =addNewContactSuccessMsg.getText();
		Assert.assertTrue(actualResult.contains("Add New Contact - Success"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

		//		***********Click Miscellaneous Tab ************************

		Rc.moveToElement(tabMiscellaneous);
		tabMiscellaneous.isDisplayed();
		//		checkBoxShiftEmp.click();

		//		***********Click ESS Tab ************************
		Rc.moveToElement(tabESS);
		tabESS.click();
		Rc.explicitWait(btnAddLeaveProfile, "clickable");
		Rc.moveToElement(btnAddLeaveProfile);
		btnAddLeaveProfile.click();
		Rc.moveToElement(cmbEmpLeaveProfileName);
		cmbEmpLeaveProfileName.click();
		Rc.moveToElement(selectEmpProfileName);
		selectEmpProfileName.click();
		dtLeaveProfileEndDate.clear();
		dtLeaveProfileEndDate.sendKeys("17-11-2099");
		btnSaveLeaveProfile.click();
		Rc.moveToElement(btnAddEmpWorkflowRoute);
		btnAddEmpWorkflowRoute.click();
		selectModuleName.click();
		Rc.moveToElement(selectHajLeave);
		selectHajLeave.click();
		Rc.moveToElement(selectRouteName);
		selectRouteName.click();
		Rc.moveToElement(selectLeaveRoute);
		selectLeaveRoute.click();
		Rc.explicitWait(dtWorkFlowStartDate, "clickable");
		dtWorkFlowStartDate.clear();
		workFlowStartDate.click();
		dtWorkFlowEndDate.clear();
		workFlowEndDate.click();
		Rc.moveToElement(btnSaveEmpWorkflowRoute);
		btnSaveEmpWorkflowRoute.click();


		//		***********Click Attachments Tab ************************

		Rc.moveToElement(tabAttachments);
		tabAttachments.click();	
		Rc.explicitWait(btnAddEmployeeAttachment, "clickable");
		Rc.moveToElement(btnAddEmployeeAttachment);
		btnAddEmployeeAttachment.click();
		txtDocumentName.sendKeys(Rc.description);
		txtDescription.sendKeys(Rc.description);	
		Rc.moveToElement(btnAddAttachment);
		btnAddAttachment.click();
		Rc.selectFileToUpload(btnFileToUpload);
		Rc.explicitWait(btnUpload, "clickable");
		btnUpload.click();
		Rc.explicitWait(btnSaveAttachment, "clickable");
		btnSaveAttachment.click();
		Rc.explicitWait(attachmentcreatedSuccessfullyMsg, "visibility");
		String actualResult1 = attachmentcreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult1.contains("Attachment created Successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
		Rc.explicitWait(btnSaveEmployee, "clickable");
		btnSaveEmployee.click();
		Rc.explicitWait(employeeProfileCreatedSuccessfullyMsg, "visibility");
		String actualResult3 = employeeProfileCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult3.contains("Employee Profile created successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void updateEmpProfile() throws Exception 
	{
		Thread.sleep(4000);
		Rc.explicitWait(txtSearchBar, "visible");
		txtSearchBar.clear();
		txtSearchBar.sendKeys(employeeNumber);
		Rc.explicitWait(btnEdit, "clickable");
		btnEdit.click();
		Thread.sleep(4000);
		Rc.explicitWait(txtBadgeNumber, "visible");
		txtBadgeNumber.clear();
		txtBadgeNumber.sendKeys(Rc.randomInt);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		txtMiddleName.clear();
		txtMiddleName.sendKeys(Rc.name);
		txtLastName.clear();
		txtLastName.sendKeys(Rc.lastName+" " );
		txtLastName.sendKeys(Keys.TAB);
		//		Rc.explicitWait(employmentBasis, "clickable");
		//		Rc.moveToElement(employmentBasis);
		//		employmentBasis.click();
		//		Rc.moveToElement(selectEmpBasisContract);
		//		selectEmpBasisContract.click();
		Rc.moveToElement(txtGender);
		txtGender.click();
		Rc.moveToElement(selectMale);
		selectMale.click();
		Rc.moveToElement(meritalStatus);
		meritalStatus.click();
		Rc.moveToElement(selectMarried);
		selectMarried.click();
		Rc.moveToElement(txtTitle);
		txtTitle.click();
		Rc.moveToElement(selectMr);
		selectMr.click();
		Rc.moveToElement(txtReligion);
		txtReligion.click();
		Rc.moveToElement(selectHindu);
		selectHindu.click();
		Rc.moveToElement(txtAddressLine1);
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine2);
		txtAddressLine2.clear();
		txtAddressLine2.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine3);
		txtAddressLine3.clear();
		txtAddressLine3.sendKeys(Rc.address);
		txtPostCode.clear();
		txtPostCode.sendKeys(Rc.randomInt);
		txtCity.clear();
		txtCity.sendKeys(Rc.city);
		txtState.clear();
		txtState.sendKeys(Rc.state);
		Rc.moveToElement(txtCountry);
		txtCountry.click();
		Rc.moveToElement(selectAustralian);
		selectAustralian.click();
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(Rc.mobileNo);
		txtHomePhoneNumber.clear();
		txtHomePhoneNumber.sendKeys(Rc.mobileNo);
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(Rc.email);
		Rc.moveToElement(txtPosition);
		txtPosition.click();
		selectEcho.click();
		Rc.moveToElement(txtScheduleRule);
		txtScheduleRule.click();
		Rc.moveToElement(selectScheduleRule);
		selectScheduleRule.click();
		Rc.moveToElement(txtPayGroup);
		txtPayGroup.click();
		txtOvertimeSetting.click();
		selectOtSetting.click();

		//		***********Click Role Tab ************************

		Rc.moveToElement(tabRole);
		tabRole.click();
		Rc.explicitWait(cmbPrimaryRole, "clickable");
		cmbPrimaryRole.click();
		Rc.explicitWait(cmbPrimaryRoleSearch, "clickable");
		Rc.moveToElement(cmbPrimaryRoleSearch);
		cmbPrimaryRoleSearch.click();
		Rc.explicitWait(availableListBox, "visible");
		Rc.moveToElement(availableListBox);
		Rc.selectByIndex(availableListBox, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();

		//		***********Click Disciplinary Tab ************************

		Rc.explicitWait(tabDisciplinary, "clickable");
		Rc.moveToElement(tabDisciplinary);
		tabDisciplinary.click();
		btnAddSuspension.click();
		Rc.explicitWait(dtDisciplinaryStart, "clickable");
		dtDisciplinaryStart.click();
		disciplinaryStartDate.click();
		dtDisciplinaryEnd.click();
		disciplinaryEndDate.click();
		Rc.explicitWait(chkExcludeAccrualProcess, "clickable");
		chkExcludeAccrualProcess.click();
		txtDisciplinaryRemarks.sendKeys(Rc.description);
		btnSaveDisciplinaryDetails.click();
		Rc.explicitWait(addDisciplinaryActionSuccessMsg, "visibility");
		String actualResult = addDisciplinaryActionSuccessMsg.getText();
		Assert.assertTrue(actualResult.contains("Add Disciplinary Action - Success"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

		//		***********Click Security Tab ************************

		Rc.explicitWait(tabSecurity, "clickable");
		tabSecurity.click();
		btnAddEmployeeOU.click();
		selectOrganizationName.click();
		chooseOrgUnit.click();
		dtShareOrgUnitStartDate.click();
		orgUnitStartDate.click();
		dtShareOrgUnitEndDate.click();
		orgUnitEndDate.click();
		btnSaveEmployeeOU.click();
		Rc.explicitWait(btnSaveEmployee, "clickable");
		btnSaveEmployee.click();
		//		Rc.explicitWait(employeeProfileUpdatedSuccessfullyMsg, "visibility");
		//		String ProfileUpdated = employeeProfileUpdatedSuccessfullyMsg.getText();
		//		Assert.assertTrue(ProfileUpdated.contains("//div[text()='Employee Profile']"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void deleteEmpProfile() throws Exception 
	{
		Thread.sleep(4000);
		Rc.explicitWait(txtSearchBar, "visible");
		txtSearchBar.clear();
		txtSearchBar.sendKeys(employeeNumber);
		Rc.explicitWait(checkBox, "clickable");
		checkBox.click();
		Rc.moveToElement(btnDeleteEmployee);
		btnDeleteEmployee.click();
		Rc.explicitWait(btnYes, "clickable");
		Rc.moveToElement(btnYes);
		btnYes.click();
		Rc.explicitWait(employeeProfileDeletedSuccessfullyMsg, "visibility");
		String actualResult3 = employeeProfileDeletedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult3.contains("Selected Employee Profile deleted successfully."));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}

	public void reactivateEmpProfile() throws InterruptedException 
	{
		Thread.sleep(4000);
		Rc.explicitWait(txtSearchBar, "visible");
		txtSearchBar.clear();
		txtSearchBar.sendKeys(employeeNumber);
		btnEdit.click();
		//		*********** Basic Tab ************************
		Thread.sleep(8000);
		Rc.moveToElement(txtPosition);
		txtPosition.click();
		selectEcho.click();
		Rc.moveToElement(txtScheduleRule);
		txtScheduleRule.click();
		Rc.moveToElement(selectScheduleRule);
		selectScheduleRule.click();
		Rc.moveToElement(txtPayGroup);
		txtPayGroup.click();
		txtOvertimeSetting.click();
		selectOtSetting.click();
		Rc.explicitWait(checkBoxIsActive, "clickable");
		Rc.moveToElement(checkBoxIsActive);
		checkBoxIsActive.click();

		//		***********Click Role Tab ************************
		Rc.moveToElement(tabRole);
		tabRole.click();
		Rc.explicitWait(cmbPrimaryRole, "clickable");
		cmbPrimaryRole.click();
		Rc.explicitWait(cmbPrimaryRoleSearch, "clickable");
		Rc.moveToElement(cmbPrimaryRoleSearch);
		cmbPrimaryRoleSearch.click();
		Rc.explicitWait(availableListBox, "visible");
		Rc.moveToElement(availableListBox);
		Rc.selectByIndex(availableListBox, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		Thread.sleep(4000);
		Rc.explicitWait(btnSaveEmployee, "clickable");
		btnSaveEmployee.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();
	}



	public void duplicateEmpProfile() throws Exception 
	{
		Thread.sleep(4000);
		Rc.explicitWait(txtSearchBar, "visible");
		txtSearchBar.clear();
		txtSearchBar.sendKeys(employeeNumber);
		btnDuplicate.click();
		Rc.explicitWait(txtEmployeeNumber, "visible");
		Thread.sleep(4000);
		txtEmployeeNumber.clear();
		txtEmployeeNumber.sendKeys(employeeNumber+ " Jivi");
		txtBadgeNumber.clear();
		txtBadgeNumber.sendKeys(Rc.randomInt);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		txtMiddleName.clear();
		txtMiddleName.sendKeys(Rc.lastName);
		txtLastName.clear();
		txtLastName.sendKeys(Rc.lastName);
		Rc.explicitWait(dtBirthDate, "clickable");
		dtBirthDate.click();
		birthDate.click();
		//		Rc.explicitWait(employmentBasis, "clickable");
		//		Rc.moveToElement(employmentBasis);
		//		employmentBasis.click();
		//		Rc.moveToElement(selectEmpBasisContract);
		//		selectEmpBasisContract.click();
		Rc.moveToElement(txtGender);
		txtGender.click();
		Rc.moveToElement(selectMale);
		selectMale.click();
		Rc.moveToElement(meritalStatus);
		meritalStatus.click();
		Rc.moveToElement(selectMarried);
		selectMarried.click();
		Rc.moveToElement(txtTitle);
		txtTitle.click();
		Rc.moveToElement(selectMr);
		selectMr.click();
		Rc.moveToElement(txtReligion);
		txtReligion.click();
		Rc.moveToElement(selectHindu);
		selectHindu.click();
		Rc.moveToElement(txtAddressLine1);
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine2);
		txtAddressLine2.clear();
		txtAddressLine2.sendKeys(Rc.address);
		Rc.moveToElement(txtAddressLine3);
		txtAddressLine3.clear();
		txtAddressLine3.sendKeys(Rc.address);
		txtPostCode.clear();
		txtPostCode.sendKeys(Rc.randomInt);
		txtCity.clear();
		txtCity.sendKeys(Rc.city);
		txtState.clear();
		txtState.sendKeys(Rc.state);
		Rc.moveToElement(txtCountry);
		txtCountry.click();
		Rc.moveToElement(selectAustralian);
		selectAustralian.click();
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(Rc.mobileNo);
		txtHomePhoneNumber.clear();
		txtHomePhoneNumber.sendKeys(Rc.mobileNo);
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(Rc.email);
		dtHireDate.clear();
		dtHireDate.click();
		hireDate.click();
		dtProbationExpiryDate.clear();
		dtProbationExpiryDate.click();
		probationExpiryDate.click();
		Rc.moveToElement(txtPosition);
		txtPosition.click();
		selectEcho.click();
		Rc.moveToElement(txtScheduleRule);
		txtScheduleRule.click();
		Rc.moveToElement(selectScheduleRule);
		selectScheduleRule.click();
		Rc.moveToElement(txtPayGroup);
		txtPayGroup.click();
		txtOvertimeSetting.click();
		selectOtSetting.click();

		//		***********Click Role Tab ************************

		Rc.moveToElement(tabRole);
		tabRole.click();
		Rc.explicitWait(cmbPrimaryRole, "clickable");
		cmbPrimaryRole.click();
		Rc.explicitWait(cmbPrimaryRoleSearch, "clickable");
		Rc.moveToElement(cmbPrimaryRoleSearch);
		cmbPrimaryRoleSearch.click();
		Rc.explicitWait(availableListBox, "visible");
		Rc.moveToElement(availableListBox);
		Rc.selectByIndex(availableListBox, 0);
		Rc.moveToElement(selectMoveSingle);
		selectMoveSingle.click();
		Rc.explicitWait(btnSaveEmployee, "clickable");
		btnSaveEmployee.click();
		Rc.explicitWait(employeeProfileCreatedSuccessfullyMsg, "visibility");
		String actualResult3 = employeeProfileCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult3.contains("Employee Profile created successfully"));
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}

	public void terminateEmpProfile() throws Exception 
	{
		Thread.sleep(4000);
		Rc.explicitWait(txtSearchBar, "visible");
		txtSearchBar.clear();
		txtSearchBar.sendKeys(employeeNumber);
		btnEdit.click();
		Thread.sleep(10000);
		//		***********Click Miscellaneous Tab ************************
		Rc.explicitWait(tabMiscellaneous, "clickable");
		Rc.moveToElement(tabMiscellaneous);
		tabMiscellaneous.click();
		//		***********Click Disciplinary Tab ************************
		Rc.explicitWait(tabDisciplinary, "clickable");
		Rc.moveToElement(tabDisciplinary);
		tabDisciplinary.click();
		Rc.explicitWait(chkIsEmployeeTerminated, "clickable");
		chkIsEmployeeTerminated.click();
		Rc.explicitWait(btnYes, "clickable");
		btnYes.click();
		dtEmployeeTerminatedDate.click();
		terminatedDate.click();
		txtEmployeeTerminationRemarks.sendKeys(Rc.description);
		Thread.sleep(2000);
		Rc.scrollToElement(btnSaveEmployee);
		Thread.sleep(2000);
		Rc.explicitWait(btnSaveEmployee, "clickable");
		btnSaveEmployee.click();
		Rc.explicitWait(notificationPopup, "clickable");
		notificationPopup.click();

	}


	public void searchEmpStatus() throws InterruptedException 
	{
		Thread.sleep(4000);
		Rc.explicitWait(chooseEmpStatus, "clickable");
		chooseEmpStatus.click();
		selectActiveEmp.click();
		Rc.explicitWait(btnSearchEmployeeProfile, "clickable");
		btnSearchEmployeeProfile.click();
		Thread.sleep(1000);
		Rc.explicitWait(removeName, "clickable");
		removeName.click();
	}

	public void searchEmpProfile() throws InterruptedException 
	{
		Thread.sleep(1000);
		Rc.explicitWait(chooseEmpBasis, "clickable");
		chooseEmpBasis.click();
		selectContractEmp.click();
		Rc.explicitWait(btnSearchEmployeeProfile, "clickable");
		btnSearchEmployeeProfile.click();
		Thread.sleep(1000);
		Rc.explicitWait(removeName, "clickable");
		removeName.click();
	}

	public void searchRosterGroup() throws InterruptedException 
	{
		Thread.sleep(1000);
		Rc.explicitWait(chooseRosterGroup, "clickable");
		chooseRosterGroup.click();
		selectDftRosterGroup.click();
		Rc.explicitWait(btnSearchEmployeeProfile, "clickable");
		btnSearchEmployeeProfile.click();
		Thread.sleep(1000);
		Rc.explicitWait(removeName, "clickable");
		removeName.click();

	}


	public void searchRoleGroup() throws InterruptedException 
	{
		Thread.sleep(1000);
		Rc.explicitWait(chooseRoleGroup, "clickable");
		chooseRoleGroup.click();
		selectRoleGroup.click();
		Rc.explicitWait(btnSearchEmployeeProfile, "clickable");
		btnSearchEmployeeProfile.click();
		Thread.sleep(1000);
		Rc.explicitWait(removeName, "clickable");
		removeName.click();
	}
}