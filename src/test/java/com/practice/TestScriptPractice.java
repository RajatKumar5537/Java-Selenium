package com.practice;

import java.awt.AWTException;
import java.lang.module.FindException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScriptPractice {
	@Test
	public void practice() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		WebDriver d=new ChromeDriver(option);
		
		Actions action= new Actions(d);
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.jiviews.com/DEMO/");
		d.findElement(By.name("username")).sendKeys("admin");
		d.findElement(By.name("password")).sendKeys("JiViews2.0");
		d.findElement(By.id("btnSignIn")).click();
		d.findElement(By.xpath("//div[@id='dvOrgUnitDropdown']/a/i")).click();//Organization Unit
		Thread.sleep(1000);
		d.findElement(By.xpath("//div[@id='dvGlobalOrganizationUnitTreeView']/ul/li[4]")).click();//OLM option 
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[text()='SYSTEM SETUP']/..")).click(); // click on levelSelector
		d.findElement(By.xpath("//div[@id='dvJiViewsMenuItems']/a[2]")).click(); // click SystemDefination
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='Roster Setup']/..")).click();
		d.findElement(By.xpath("//div[text()='Shift Band Definition']/..")).click();
		Thread.sleep(1000);
		d.findElement(By.id("btnAddNew")).click();
		d.findElement(By.id("txtShtBandName")).sendKeys("Day Shift");
		d.findElement(By.id("txtShiftbandDesc")).sendKeys("Day Shift");
		d.findElement(By.id("txtShiftBandCode")).sendKeys("1st Shift");
		d.findElement(By.id("select2-cmbShiftBandId-container")).click();
		
		WebElement search = d.findElement(By.className("select2-search__field"));
		action.moveToElement(search).perform();
		
		WebElement shiftType = d.findElement(By.xpath("//li[text()='Normal Shift']"));
		action.moveToElement(shiftType).perform();
		shiftType.click();
		
		
		Thread.sleep(1000);
		WebElement startTime = d.findElement(By.xpath("//input[@id='txtStartTime']")); // select start time txt
		action.moveToElement(startTime).perform();
		startTime.clear();
		Thread.sleep(2000);
		WebElement STime = d.findElement(By.xpath("//li[text()='07:00']"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(true);",STime);
		STime.click();
		
		Thread.sleep(1000);
		WebElement endTime = d.findElement(By.xpath("//input[@id='txtEndTime']"));
		action.moveToElement(endTime).perform();
		endTime.clear();
		Thread.sleep(1000);
		WebElement ETime = d.findElement(By.xpath("(//li[text()='19:00'])[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);",ETime);
		ETime.click();
		
				
		WebElement endRangeBegin = d.findElement(By.xpath("//input[@name='endRangeBegin']"));
		action.moveToElement(endRangeBegin).perform();
		endRangeBegin.clear();
		endRangeBegin.sendKeys("6:59");
		endRangeBegin.click();
		
		WebElement endRangeEnd = d.findElement(By.xpath("//input[@name='endRangeEnd']"));
		action.moveToElement(endRangeEnd).perform();
		endRangeEnd.clear();
		endRangeEnd.sendKeys("10:01");
		endRangeEnd.click();
		
	}
	
	
	
		/*public String createShiftBand() throws Exception {

			
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
			shiftBandNew = nn;

			txtShiftBandCode.sendKeys("Auto Band code" + " " + publicempNum);

			// ShiftBandList.click();

			dropdown.selectByIndex(shiftBandType, 1);
			// shiftBandType.sendKeys(Keys.ENTER);
			Thread.sleep(200);
			// chkIsActive.click();
			txtColorCode.clear();
			txtColorCode.sendKeys("#2d38cf");
			txtColorCode.sendKeys(Keys.TAB);
			Thread.sleep(200);
			shiftCounter.sendKeys("2");

			// chkIsActive.click();

			webAction.scrollDown();

			// txtStartTime
			webAction.scrollIntoeEement(txtStartTime);
			// webAction.waitUntilElementIsClickable(txtStartTime);
			// webAction.waitUntilElementIsVisible(txtStartTime);
			if (txtStartTime.isEnabled()) {
				System.out.println("If condition");

				txtStartTime.clear();
				webAction.setValueUsingJavaScript(txtStartTime, "07:00");
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
			reportUtils.addInfo("Creation of Shift Band Name:"+shiftbandname, methodName);
			return shiftbandname;
		}
//		d.findElement(By.xpath("//div[.='Employee Setup']")).click(); // Employee SetUp
//
//		d.findElement(By.xpath("//div[.='Roles']")).click();
//		Thread.sleep(2000);
//		d.findElement(By.xpath("//button[@id='btnAddNew']/span")).click(); // add button 
//		Thread.sleep(2000);
//		d.findElement(By.xpath("//input[@id='txtRoleName']")).sendKeys("Common"); // enter role name
//		Thread.sleep(2000);
//		d.findElement(By.xpath("//input[@id='txtRoleDescription']")).sendKeys("dta"); //  enter role description 
//		Thread.sleep(2000);
//		d.findElement(By.xpath("//input[@id='txtPrepareTime']")).sendKeys("2"); // eneter prparatio time
//		Thread.sleep(2000);
//		d.findElement(By.xpath("//input[@id='txtDePreparetime']")).sendKeys("3"); // enter depreparation time
//		Thread.sleep(2000);
//		WebElement search =	d.findElement(By.xpath("//span[.='Select Primary Skill Id']")); // select primary skill code 
//		search.click();
//		Actions a=new Actions(d);
//		a.moveToElement(search).perform();	
//		
//		WebElement selectSkill = d.findElement(By.xpath("//li[.='Auto_Test']")); // Select Skill Code
//		a.moveToElement(selectSkill).perform();
//		selectSkill.click();
//		
//		d.findElement(By.xpath("//input[@id='txtRolePrioritySeq']")).sendKeys("6"); //role waightage 
//		
//
//		WebElement availableSkill = d.findElement(By.xpath("(//select[@class='form-control'])[1]"));
//		a.scrollToElement(availableSkill).perform();
//		
//		Select s=new Select(availableSkill);
//		s.selectByValue("75");	
//		
//		WebElement selectMoveBtn = d.findElement(By.xpath("//button[@class='btn move btn-default']"));
//		a.moveToElement(selectMoveBtn).perform();
//		selectMoveBtn.click();
//		
//		WebElement selectMoveAll = d.findElement(By.xpath("//button[@class='btn moveall btn-default']"));
//		a.moveToElement(selectMoveAll).perform();
//		selectMoveAll.click();
//		
//		Thread.sleep(1000);
//		WebElement diselectMoveAll = d.findElement(By.xpath("//button[@class='btn removeall btn-default']"));
//		a.moveToElement(diselectMoveAll);
//		diselectMoveAll.click();
		
//		d.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
//		d.findElement(By.xpath("//a[@id='btnLogout']")).click();
		*/
	}

