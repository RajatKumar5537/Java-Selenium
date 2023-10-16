package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.JiviewsAutomation.SystemDefination_TestScript.skillSetUpTestScript;


public class AzurePractice { 
	
	private static final Logger logger = LogManager.getLogger(AzurePractice.class);
	
	@Test(invocationCount = 3)
	public void createSkill() {
		logger.info("Create a new Skill");
		
		Reporter.log("Create a new Skill...!",true);
	}
	@Test(invocationCount = 2)
	public void modifySkill() {
		logger.info("Modify Skill");
		Reporter.log("Modify a existing Skill...!",true);
	}
	@Test(invocationCount = 2)
	public void deleteSkill() {
		logger.info("Deactivate Skill");
		Reporter.log("Deactivate a Skill....!",true);
	}
	@Test(invocationCount = 1)
	public void reactiveSkill() {
		logger.info("Reactive Skill");
		Reporter.log("Deactivate a Skill....!",true);
	}
	@Test(invocationCount = 3)
	public void searchSkill() {
		logger.info("Search a Skill");
		Reporter.log("Search a Skill....!",true);
	}
}
