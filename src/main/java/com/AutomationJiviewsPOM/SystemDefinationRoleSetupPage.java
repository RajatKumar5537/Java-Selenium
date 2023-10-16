package com.AutomationJiviewsPOM;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsGeneric.FileLib;

public class SystemDefinationRoleSetupPage extends BaseClass{
	public static Actions action;
	public static Select select;
	public static FileLib fileLib;
	public static String timeStamp ;
	public static SystemDefinationRoleSetupPage sdrs;
	public String roleNameData;
	public String roleDescriptionData;
	public String preparationTimeData;
	public String depreparationTimeData;
	public String roleWaightageData;

	@FindBy(xpath = "//button[@id='btnAddNew']/span")
	private WebElement addBtn;

	@FindBy(xpath = "//input[@id='txtRoleName']")
	private WebElement roleName;

	@FindBy(xpath = "//input[@id='txtRoleDescription']")
	private WebElement roleDescription;

	@FindBy(xpath = "//input[@id='txtPrepareTime']")
	private WebElement preparationTime;

	@FindBy(xpath = "//input[@id='txtDePreparetime']")
	private WebElement depreparationTime;

	@FindBy(xpath = "//span[.='Select Primary Skill Id']")
	private WebElement selectPrimarySkillId;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchField;

	@FindBy(xpath = "(//li[contains(text(),'Auto_Test')])[1]")
	private WebElement selectSkillCode;

	@FindBy(xpath = "//input[@id='txtRolePrioritySeq']")
	private WebElement roleWaightage;

	// it is from Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableSkill;

	// select for move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle;

	//	select for move skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn moveall btn-default']")
	private WebElement selectMoveAll;

	// it is from Seleceted Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement selectedSkill;

	//	select for move single skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn remove btn-default']")
	private WebElement removeSelectedSkillSingle;

	//	select for move multiple skill from Selected skill table to Available skiil table 
	@FindBy(xpath = "//button[@class='btn removeall btn-default']")
	private WebElement removeSelectedSkillAll;

	@FindBy(xpath = "//button[@id='btnSaveRolesDetails']/span")
	private WebElement saveBTN;
	
	@FindBy(className = "toast-close-button")
	private WebElement notificationPopup;

	@FindBy(xpath = "(//button[@type='button'])[5]/i")
	private WebElement editBTN;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement checkBox;

	@FindBy(xpath = "//button[@id='btnDeleteRoles']/span")
	private WebElement deleteBTN;

	@FindBy(xpath = "//button[.='Yes']")
	private WebElement clickYes;

	@FindBy(xpath = "//span[.='Is Active?']")
	private WebElement isActive;

	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
	private WebElement cancelBTN;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchColumns;

	public SystemDefinationRoleSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void setAddBtn() {
		addBtn.click();
	}

	public void setRoleName(String roleNameData) {
		roleName.clear();
		roleName.sendKeys(roleNameData);
	}

	public void setRoleDescription(String roleDescriptionData) {
		roleDescription.clear();
		roleDescription.sendKeys(roleDescriptionData);
	}
	public void setPreparationTime(String preparationTimeData) {
		preparationTime.clear();
		preparationTime.sendKeys(preparationTimeData);
	}

	public void setDepreparationTime(String depreparationTimeData) {
		depreparationTime.clear();
		depreparationTime.sendKeys(depreparationTimeData);
	}

	public void setPrimarySkillID() {
		Actions a= new Actions(driver);
		a.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();
	}

	//	public void setSearchField() {
	//		searchField.sendKeys("Auto_Test");
	//		searchField.click();
	//	}
	//	
	// select code in primary skill
	public void setSelectSkillCode() {
		action= new Actions(driver);
		action.moveToElement(selectSkillCode).perform();
		selectSkillCode.click();
	}

	public void setRoleWaightage(String roleWaightageData) {
		roleWaightage.clear();
		roleWaightage.sendKeys(roleWaightageData);
	}
	// scroll down the page and select single skill from  availble skill
	public void setAvailableSkillForSingleSkill() {
		action= new Actions(driver);
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
		select=new Select(availableSkill);
		select.selectByValue("75");	
	}
	// scroll down the page and select for move multiple skill from available skill table to Selected skiil table 
	public void setAvailableSkillForMultipleSkill() {
		action= new Actions(driver);
		action.scrollToElement(availableSkill).perform();

		//		select=new Select(availableSkill);
		//		List<WebElement> allOptions = select.getAllSelectedOptions();
		//		for ( WebElement option:allOptions) {
		//			select.selectByVisibleText(option.getText());
		//		}
	}
	//	move skill from available skills to selected skill for single role  
	public void setAvailableSingleSkillMoveToSelectedSkill() {
		action= new Actions(driver);
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	//	move skill from available skills to selected skill for Multiple  role
	public void setAvailableMultipleSkillMoveToSelectedSkill() {
		action= new Actions(driver);
		action.moveToElement(selectMoveAll).perform();
		selectMoveAll.click();
	}

	//  select one role and move to available skiil table from selected table 
	public void setSelectedSkillForMoveToAvailabelSkillForSingle() {
		action= new Actions(driver);
		action.scrollToElement(selectedSkill).perform();
		selectedSkill.click();
		select=new Select(selectedSkill);
		select.selectByValue("75");	
	}
	// select the skill from Selected Skill tabele and mouse hover on single arrow 
	public void setRemoveSelectedSkillForSingle() {
		action= new Actions(driver);
		action.moveToElement(removeSelectedSkillSingle).perform();
		removeSelectedSkillSingle.click();

	}
	// select the skill from Selected Skill tabele and mouse hover on Double arrow
	public void setRemoveSelectedSkillForAll() {
		action= new Actions(driver);
		action.moveToElement(removeSelectedSkillAll).perform();
		removeSelectedSkillAll.click();
	}

	public void setSaveBTN() {
		saveBTN.click();
	}
	
	public void setNotificationPopup() {
		notificationPopup.click();
	}

	public void setEditBTN() {
		editBTN.click();
	}

	public void setCheckBox() {
		checkBox.click();
	}

	public void setDeleteBTN() {
		deleteBTN.click();
	}

	public void setClickYes() {
		clickYes.click();
	}
	public void setIsActive() {
		isActive.click();
	}

	public void setSearchColumns(String roleNameData) {
		searchColumns.sendKeys(roleNameData);
		searchColumns.click();
	}
	public void setCancelBTN() {
		cancelBTN.click();
	}
	public void setCreateNewRole() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		Thread.sleep(2000);
		sdrs.setPrimarySkillID();
		Thread.sleep(2000);
		//		sdrs.setSearchField();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}

	public void setUpdateRole() throws EncryptedDocumentException, IOException, InterruptedException {
		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 7, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 7, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 7, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 7, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 7, 11);


		sdrs.setEditBTN();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();
	}

	public void setDeactiveRole() throws InterruptedException {
		sdrs= new SystemDefinationRoleSetupPage(driver);
		Thread.sleep(2000);
		sdrs.setCheckBox();
		sdrs.setDeleteBTN();
		sdrs.setClickYes();
		sdrs.setNotificationPopup();
	}

	public void setReactiveRole() throws InterruptedException {
		sdrs= new SystemDefinationRoleSetupPage(driver);
		Thread.sleep(2000);
		sdrs.setEditBTN();
		sdrs.setIsActive();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();
	}

	public void setCreateNewRoleWithoutPriarySkill() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		//		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}


	public void setCreateNewRoleWithoutRoleName() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		//		Thread.sleep(2000);
		//		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}
	public void setCreateNewRoleWithoutRoleDescription() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		//		Thread.sleep(2000);
		//		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}

	public void setCreateNewRoleWithoutSecondarySkillEmpty() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		//		sdrs.setSelectMoveSingleRole();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}

	// All Availble skiil should move to secondary skill
	public void setCreateNewRoleWithAllAvailableSkill() throws EncryptedDocumentException, IOException, InterruptedException {

		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);

		sdrs.setAvailableSkillForMultipleSkill();
		sdrs.setSelectedSkillForMoveToAvailabelSkillForSingle();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();

	}

	public void setDisSelectSingleSkillFromSelectedSkill() throws EncryptedDocumentException, IOException, InterruptedException {
		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);
		sdrs.setAvailableSkillForSingleSkill();
		sdrs.setAvailableSingleSkillMoveToSelectedSkill();
		Thread.sleep(2000);
		sdrs.setSelectedSkillForMoveToAvailabelSkillForSingle();
		sdrs.setRemoveSelectedSkillForSingle();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();
	}

	public void setDisselectAllAvailableSkill() throws InterruptedException, EncryptedDocumentException, IOException {
		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();
		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);
		roleDescriptionData = fileLib.getExcelData("EmployeeTest", 6, 8);
		preparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 9);
		depreparationTimeData = fileLib.getExcelData("EmployeeTest", 6, 10);
		roleWaightageData = fileLib.getExcelData("EmployeeTest", 6, 11);


		sdrs.setAddBtn();
		Thread.sleep(2000);
		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		Thread.sleep(2000);
		sdrs.setPreparationTime(preparationTimeData);
		sdrs.setDepreparationTime(depreparationTimeData);
		sdrs.setPrimarySkillID();
		sdrs.setSelectSkillCode();
		sdrs.setRoleWaightage(roleWaightageData);

		sdrs.setAvailableSkillForMultipleSkill();
		sdrs.setAvailableMultipleSkillMoveToSelectedSkill();
		Thread.sleep(2000);
		sdrs.setRemoveSelectedSkillForAll();
		sdrs.setSaveBTN();
		sdrs.setNotificationPopup();
	}

	public void setSearchColumnsForRole() throws EncryptedDocumentException, IOException {
		fileLib=new FileLib();
		sdrs= new SystemDefinationRoleSetupPage(driver);

		roleNameData = fileLib.getExcelData("EmployeeTest", 6, 7);

		sdrs.setSearchColumns(roleNameData);

	}
}