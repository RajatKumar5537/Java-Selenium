package com.AutomationJiviewsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationJiviewsGeneric.BaseClass;

public class WorkloadPlanningPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Workload Planning']/..")
	private WebElement workloadPlanning;
	@FindBy(xpath = "//div[text()='Workload Planner']/..")
	private WebElement workloadPlanner;
	
	public WorkloadPlanningPage(WebDriver driver) {
//		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickWorkloadPlanning() {
//		webUtility.ElementClickable(driver, workloadPlanning);
		workloadPlanning.click();
	}
	public void clickWorkloadPlanner() throws InterruptedException {
		webUtility.moveToElement(driver, workloadPlanner);
		workloadPlanner.click();
	}
	
	
	
	
	public void clickOnWorkloadPlanner() throws InterruptedException {
//		clickWorkloadPlanning();
//		clickWorkloadPlanner();
		workloadPlanning.click();
		workloadPlanner.click();
	}
}
