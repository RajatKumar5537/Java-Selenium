package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationUnitDropDown {
	// Select Demo Option 
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[1]")
		private WebElement demoOp;

		// Select EFD Option
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[2]")
		private WebElement EFDoption;

		// Select HSSE Division 
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[3]")
		private WebElement HSSEdivision;

		// Select OLM
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[4]")
		private WebElement OLMop;

		// Select Operator 
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[5]")
		private WebElement operationOp;

		// Select Test RV
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[6]")
		private WebElement testRV;

		// Select Test OC
		@FindBy(xpath = "(//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li)[7]")
		private WebElement testOC;

		public OrganizationUnitDropDown(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// for Demo 
		public void setDemo() {
			demoOp.click();
		}

		// for EFD
		public void setEFDoption() {
			EFDoption.click();
		}

		// HSSE Division
		public void setHSSEdivision() {
			HSSEdivision.click();
		}

		public void setOLMop() throws InterruptedException {
			Thread.sleep(2000);
			OLMop.click();			
		}

		// Operator 
		public void setOperationOp() {
			operationOp.click();
		}

		// Test RV
		public void setTestRV() {
			testRV.click();
		}

		// Test OC
		public void setTestOC() {
			testOC.click();
		}
}
