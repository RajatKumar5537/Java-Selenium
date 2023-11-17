package com.AutomationJiviewsPOM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FakeEmployee;

public class EmpAdmEmployeeProfilePage extends BaseClass{
	private static final Logger logger = LogManager.getLogger(EmpAdmEmployeeProfilePage.class);
	Select select;

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

	@FindBy(xpath = "//button[@id='btnSaveEmployee']")
	private WebElement btnSaveEmployee;

	/*
		public EmpAdmEmployeeProfilePage(WebDriver driver) {
			super();
			PageFactory.initElements(driver, this);
		}

		public void clickBtnAddEmployee() {
			btnAddEmployee.click();
		}
		public void clickBasicProfile() {
			webUtility.moveToElement(driver, basicProfile);
			basicProfile.click();
		}

		public void enterEmployeeNumber() {
			txtEmployeeNumber.clear();
			txtEmployeeNumber.sendKeys(fakeEmployee.getEmpNumber());
		}
		public void enterBadgeNumber() {
			txtBadgeNumber.clear();
			txtBadgeNumber.sendKeys(fakeEmployee.getBadgeNumber());
		}
		public void enterFirstName() {
			txtFirstName.clear();
			txtFirstName.sendKeys(fakeEmployee.getFirstName());
		}
		public void enterMiddleName() {
			txtMiddleName.clear();
			txtMiddleName.sendKeys(fakeEmployee.getMiddleName());
		}
		public void enterLastName() {
			txtLastName.sendKeys(fakeEmployee.getLastName());
		}
		//	public void enterDisplayName() {
		//		txtDisplayName.sendKeys(fakeEmployee.getDisplayName());
		//		txtDisplayName.click();
		//	}
		public void enterDateBirthDate() {
			webUtility.moveToElement(driver, dtBirthDate);
			dtBirthDate.clear();
			dtBirthDate.sendKeys(fakeEmployee.getDOB());
			dtBirthDate.sendKeys(Keys.ENTER);
		}
		public void chooseEmploymentBasis() {
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
		public void chooseGender() {
			txtGender.click();
			selectOthers.click();
		}
		public void chooseMale() {
			webUtility.moveToElement(driver, selectMale);
			selectMale.click();
		}
		public void chooseFemale() {
			webUtility.moveToElement(driver, selectFemale);
			selectFemale.click();
		}
		public void chooseOthers() {
			webUtility.moveToElement(driver, selectFemale);
			selectOthers.click();
		}
		public void chooseMeritalStatus() {
			webUtility.moveToElement(driver, meritalStatus);
			meritalStatus.click();
		}
		public void selectMarried() {
			webUtility.moveToElement(driver, selectMarried);
			selectMarried.click();
		}
		public void selectSingle() {
			webUtility.moveToElement(driver, selectSingle);
			selectSingle.click();
		}
		public void chooseTitle() {
			webUtility.moveToElement(driver, txtTitle);
			txtTitle.click();
		}
		public void selectMr() {
			webUtility.moveToElement(driver, selectMr);
			selectMr.click();
		}
		public void chooseReligion() {
			webUtility.moveToElement(driver, txtReligion);
			txtReligion.click();
		}
		public void selectHindu() {
			webUtility.moveToElement(driver, selectHindu);
			selectHindu.click();
		}
		public void selectMuslim() {
			webUtility.moveToElement(driver, selectMuslim);
			selectMuslim.click();
		}
		public void enterAddressLine1() {
			webUtility.moveToElement(driver, txtAddressLine1);
			txtAddressLine1.clear();
			txtAddressLine1.sendKeys(fakeEmployee.getAddress1());
		}
		public void enterAddressLine2() {
			webUtility.moveToElement(driver, txtAddressLine2);
			txtAddressLine2.clear();
			txtAddressLine2.sendKeys(fakeEmployee.getAddress1());
		}
		public void enterAddressLine3() {
			webUtility.moveToElement(driver, txtAddressLine3);
			txtAddressLine3.clear();
			txtAddressLine3.sendKeys(fakeEmployee.getAddress1());
		}
		public void enterPostCode() {
			txtPostCode.clear();
			txtPostCode.sendKeys(fakeEmployee.getPostCode());
		}
		public void enterCity() {
			txtCity.clear();
			txtCity.sendKeys(fakeEmployee.getCity());
		}
		public void enterState() {
			txtState.clear();
			txtState.sendKeys(fakeEmployee.getState());
		}
		public void chooseCountry() {
			webUtility.moveToElement(driver, txtCountry);
			txtCountry.click();
		}
		public void selectAustralian() {
			webUtility.moveToElement(driver, selectAustralian);
			selectAustralian.click();
		}
		public void selectUS() {
			webUtility.moveToElement(driver, selectUS);
			selectUS.click();
		}
		public void enterMobileNumber() { 
			txtMobileNumber.sendKeys(fakeEmployee.getMobileNumber());
		}
		public void entertxtHomePhoneNumber() {
			txtHomePhoneNumber.sendKeys(fakeEmployee.getPhoneNumber());
		}
		public void enterEmailAddress() {
			txtEmailAddress.sendKeys(fakeEmployee.getEmail());
		}
		public void enterHireDate() {
			dtHireDate.sendKeys(fakeEmployee.getHireDate());
		}
		public void enterProbationExpiryDate() {
			dtProbationExpiryDate.sendKeys(fakeEmployee.getProbationExpirydate());
		}
		public void choosePosition() {
			webUtility.moveToElement(driver, txtPosition);
			txtPosition.click();
			//		select=new Select(txtPosition);
			//		select.selectByIndex(1);
		}
		public void selectEcho() {
			webUtility.moveToElement(driver, selectEcho);
			selectEcho.click();
		}
		public void selectQco() {
			webUtility.moveToElement(driver, selectQco);
			selectQco.click();
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
		public void pressBtnSaveEmployee() {
			webUtility.moveToElement(driver, btnSaveEmployee);
			btnSaveEmployee.click();
		}*/

	public EmpAdmEmployeeProfilePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
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

	public void chooseEmploymentBasis() {
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

		public void entertxtHomePhoneNumber(String phoneNumber) {
			txtHomePhoneNumber.sendKeys(phoneNumber);
		}

		public void enterEmailAddress(String email) {
			txtEmailAddress.sendKeys(email);
		}

		public void enterHireDate(String hireDate) {
			dtHireDate.sendKeys(Keys.ENTER);
			dtHireDate.sendKeys(hireDate);
			dtHireDate.sendKeys(Keys.TAB);
			//		        dtHireDate.sendKeys(Keys.ENTER);
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

		public void pressBtnSaveEmployee() {
			webUtility.moveToElement(driver, btnSaveEmployee);
			btnSaveEmployee.click();
		}

		public void createEmpProfile(FakeEmployee fakeEmployee) throws InterruptedException {
			clickBtnAddEmployee();
			//		    	clickBasicProfile();
			enterEmployeeNumber(fakeEmployee.getEmpNumber());
			enterBadgeNumber(fakeEmployee.getBadgeNumber());
			enterFirstName(fakeEmployee.getFirstName());
			enterMiddleName(fakeEmployee.getMiddleName());
			enterLastName(fakeEmployee.getLastName());
			enterDateBirthDate(fakeEmployee.getDOB());
			chooseEmploymentBasis(); // You may need to select a specific employment basis
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
			entertxtHomePhoneNumber(fakeEmployee.getPhoneNumber());
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
			pressBtnSaveEmployee();
		}
	}