package com.AutomationJiviewsPOM;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
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
import com.AutomationJiviewsGeneric.ExcelUtilities;
import com.AutomationJiviewsGeneric.FileLib;

public class E10_3089_SystemDefinationRoleSetupPage extends BaseClass{
	public Actions action;
	public Select select;
	public ExcelUtilities excelUtility;
	public static String timeStamp ;
	public static E10_3089_SystemDefinationRoleSetupPage sdrs;
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

	@FindBy(xpath = "//span[@id='select2-cmbPrimarySkillId-container']")
	private WebElement selectPrimarySkillId; //span[@id='select2-cmbPrimarySkillId-container']

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchField;

	@FindBy(xpath = "(//li[contains(text(),'Auto')])[1]")
	private WebElement selectSkillCode;

	@FindBy(xpath = "//input[@id='txtRolePrioritySeq']")
	private WebElement roleWaightage;

	// it is from Available Skill Table 
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement availableSkill;

	// select for move signle skill from available skill table to Selected skiil table 
	@FindBy(xpath = "//button[@class='btn move btn-default']")
	private WebElement selectMoveSingle;

	//	select for move multiple skill from available skill table to Selected skiil table 
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

	@FindBy(xpath = "//table[@id='roles-list']/tbody/tr")
	private List<WebElement> rows;
	@FindBy(xpath = "//td/input[@type='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;
	@FindBy(xpath = "//li[@id='roles-list_next']")
	private WebElement nextPage;





	@FindBy(xpath = "//button[@id='btnDeleteRoles']")
	private WebElement btnDelete;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement clickYes;

	@FindBy(xpath = "//span[text()='Is Active?']")
	private WebElement isActive;

	@FindBy(xpath = "(//button[@class='btn btn-secondary btn-round icon-btn'])[1]")
	private WebElement cancelBTN;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchColumns;

	@FindBy(xpath = "//th[text()='Role Name']")
	private WebElement chanegRoleName;

	@FindBy(xpath = "//div[text()='Role Created Successfully']")
	private WebElement roleCreatedSuccessfullyMsg;
	@FindBy(xpath = "//div[text()='Role Updated Successfully.']")
	private WebElement roleUpdatedSuccessfullyMsg;
	@FindBy(xpath = "//label[text()='Role Code is reqired']")
	private WebElement roleCodeErrorMsg;
	@FindBy(xpath = "//label[text()='Primary Skill is required']")
	private WebElement primarySkillErrorMsg;
	@FindBy(xpath = "//label[text()='Role Description is required']")
	private WebElement roleDescriptionErrorMsg;

	public E10_3089_SystemDefinationRoleSetupPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
		this.excelUtility= new ExcelUtilities();
		this.action=new Actions(driver);
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
		action.moveToElement(selectPrimarySkillId).perform();
		selectPrimarySkillId.click();
	}
	// select code in primary skill
	public void setSelectSkillCode() {
		action.scrollToElement(selectSkillCode).perform();
		selectSkillCode.click();
	}

	public void setRoleWaightage(String roleWaightageData) {
		roleWaightage.clear();
		roleWaightage.sendKeys(roleWaightageData);
	}
	// scroll down the page and select single skill from  availble skill
	public void setAvailableSkillForSingleSkill() {
		action.scrollToElement(availableSkill).perform();
		select = new Select(availableSkill);
		List<WebElement> options = select.getOptions();
		Random rand = new Random();                    // Generate a random index between 0 and the number of options minus 1
		int randomIndex = rand.nextInt(options.size());
		select.selectByIndex(randomIndex);             // Select the option at the random index

	}
	// scroll down the page and select for move multiple skill from available skill table to Selected skiil table 
	public void setAvailableSkillForMultipleSkill() {
		action.scrollToElement(availableSkill).perform();
		availableSkill.click();
	}

	//	move a singel skill from available skills to selected skill for single role  
	public void setAvailableSingleSkillMoveToSelectedSkill() {
		action.moveToElement(selectMoveSingle).perform();
		selectMoveSingle.click();
	}

	//	move skill from available skills to selected skill for Multiple  role
	public void setAvailableMultipleSkillMoveToSelectedSkill() {
		action.moveToElement(selectMoveAll).perform();
		selectMoveAll.click();
	}
	//  select one role and move to available skiil table from selected table 
	public void setSelectedSkillForMoveToAvailabelSkillForSingle() {
		action.scrollToElement(selectedSkill).perform();
		select = new Select(selectedSkill);
		List<WebElement> options = select.getOptions();
		Random rand = new Random();                    // Generate a random index between 0 and the number of options minus 1
		int randomIndex = rand.nextInt(options.size());
		select.selectByIndex(randomIndex);
	}
	// select the skill from Selected Skill tabele and mouse hover on single arrow 
	public void setRemoveSelectedSkillForSingle() {
		action.moveToElement(removeSelectedSkillSingle).perform();
		removeSelectedSkillSingle.click();

	}
	// select the skill from Selected Skill tabele and mouse hover on Double arrow
	public void setRemoveSelectedSkillForAll() {
		action.moveToElement(removeSelectedSkillAll).perform();
		removeSelectedSkillAll.click();
	}

	public void setSaveBTN() {
		action.moveToElement(saveBTN).perform();
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
		btnDelete.click();
	}
	public void setClickYes() {
		clickYes.click();
	}
	public void performDeleteAction() throws InterruptedException {
		//		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			try {
				scrollAndClick(driver, btnDelete);
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
				scrollAndClick(driver, checkbox);
				//				checkbox.click();
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
	public void scrollAndClick(WebDriver driver, WebElement element) {
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Scroll to the top of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		element.click();
	}
	// Method to perform scroll-up action
	private void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -150)"); // Adjust the scroll distance as needed
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
	public void changeRoleName() {
		chanegRoleName.click();
	}
	public void getroleCreatedSuccessfullyMsg() {
		String actualResult = roleCreatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Created Successfully"));
	}
	public void getroleUpdatedSuccessfullyMsg() {
		String actualResult = roleUpdatedSuccessfullyMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Updated Successfully."));
	}
	public void getroleCodeErrorMsg() {
		String actualResult = roleCodeErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Code is reqired"));
	}
	public void getprimarySkillErrorMsg() {
		String actualResult = primarySkillErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Primary Skill is required"));
	}
	public void getRoleDescriptionErrorMsg() {
		String actualResult = roleDescriptionErrorMsg.getText();
		Assert.assertTrue(actualResult.contains("Role Description is required"));
	}
	public void setCreateNewRole() throws Exception {
		//		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);

		//		Thread.sleep(1000);
		setAddBtn();
		Thread.sleep(1000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		//		Thread.sleep(2000);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		//		action.moveToElement(selectMoveSingle).perform();
		//		selectMoveSingle.click();
		setSaveBTN();
		getroleCreatedSuccessfullyMsg();
		setNotificationPopup();

	}

	public void setUpdateRole() throws Exception {
		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		//		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 7, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 7, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 7, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 7, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 7, 11);


		//		sdrs.changeRoleName();
		setEditBTN();
		Thread.sleep(1000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		setSaveBTN();
		getroleUpdatedSuccessfullyMsg();
		setNotificationPopup();
	}

	public void setDeactiveRole() throws InterruptedException {
		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		Thread.sleep(2000);
		deleteRowsWithEnabledCheckbox();

		//		setCheckBox();
		//		setDeleteBTN();
		setClickYes();
		setNotificationPopup();
	}

	public void setReactiveRole() throws InterruptedException {
		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		Thread.sleep(2000);
		setEditBTN();
		Thread.sleep(1000);
		setIsActive();
		setSaveBTN();
		//		sdrs.setNotificationPopup();
	}

	public void setCreateNewRoleWithoutPriarySkill() throws Exception {

		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		//		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);



		setAddBtn();
		Thread.sleep(2000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		//		setPrimarySkillID();
		//		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		setSaveBTN();
		getprimarySkillErrorMsg();

	}


	public void setCreateNewRoleWithoutRoleCode() throws Exception {

		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);

		setAddBtn();
		//		Thread.sleep(2000);
		//		sdrs.setRoleName(roleNameData+ " " + timeStamp);
		Thread.sleep(2000);
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		setSaveBTN();
		getroleCodeErrorMsg();
	}
	public void setCreateNewRoleWithoutRoleDescription() throws Exception {

		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);


		setAddBtn();
		Thread.sleep(2000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		//		Thread.sleep(2000);
		//		sdrs.setRoleDescription(roleDescriptionData+ " " + timeStamp);
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		setSaveBTN();
		getRoleDescriptionErrorMsg();

	}
	public void setCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);



		setAddBtn();
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setSaveBTN();
		setNotificationPopup();

	}
	// All Availble skiil should move to secondary skill
	public void setCreateNewRoleWithAllAvailableSkill() throws Exception {

		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);


		setAddBtn();
		Thread.sleep(2000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);

		setAvailableSkillForMultipleSkill();
		setAvailableMultipleSkillMoveToSelectedSkill();
		//		sdrs.setSelectedSkillForMoveToAvailabelSkillForSingle();
		setSaveBTN();
		setNotificationPopup();

	}
	public void setDisSelectSingleSkillFromSelectedSkill() throws Exception {
		//		sdrs= new SystemDefinationRoleSetupPage(driver);
		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);

		setAddBtn();
		Thread.sleep(2000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForSingleSkill();
		setAvailableSingleSkillMoveToSelectedSkill();
		Thread.sleep(2000);
		setSelectedSkillForMoveToAvailabelSkillForSingle();
		setRemoveSelectedSkillForSingle();
		setSaveBTN();
		setNotificationPopup();
	}

	public void setDisselectAllAvailableSkill() throws Exception {
		timeStamp = LocalDateTime.now().toString();

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		roleDescriptionData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 8);
		preparationTimeData =excelUtility.readDataFromExcelFile("EmployeeTest", 6, 9);
		depreparationTimeData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 10);
		roleWaightageData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 11);


		setAddBtn();
		Thread.sleep(2000);
		setRoleName(roleNameData+ " " + System.currentTimeMillis());
		setRoleDescription(roleDescriptionData+ " " + System.currentTimeMillis());
		Thread.sleep(2000);
		setPreparationTime(preparationTimeData);
		setDepreparationTime(depreparationTimeData);
		setPrimarySkillID();
		setSelectSkillCode();
		setRoleWaightage(roleWaightageData);
		setAvailableSkillForMultipleSkill();
		setAvailableMultipleSkillMoveToSelectedSkill();
		Thread.sleep(2000);
		setRemoveSelectedSkillForAll();
		setSaveBTN();
		setNotificationPopup();
	}

	public void setSearchColumnsForRole() throws Exception {

		roleNameData = excelUtility.readDataFromExcelFile("EmployeeTest", 6, 7);
		Thread.sleep(1000);
		setSearchColumns(roleNameData);

	}
}
