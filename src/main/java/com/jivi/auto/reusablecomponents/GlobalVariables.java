package com.jivi.auto.reusablecomponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class GlobalVariables {
	public static HashMap<String, String> configData = new HashMap<String, String>();
	public static Properties Config, Object, Database = null;
	public static List<String> allModules = new ArrayList<String>();
//	public static TestVerification testVerification = new TestVerification();
	public static String errorTrace;
	public static String workingDir = System.getProperty("user.dir");
//	public static ReportUtils reportUtils;
//	public static JSONReader dataTable;
	public static RemoteWebDriver windriver = null;
	public static Select listBox = null;
	public static WebElement sObject = null;
	public static Set<String> windows = null;
	public static Actions builder = null;
	public static String refNo = null;
	public static String gModuleName;
	public static String gClassName;
	public static boolean isGridMode = false;
	public static String strBrowserChoice;
	public static boolean mobileBrowser = false;
	public static String globalClassName;
	public static String globalPackageName;
	public static String globalMethodName;
	public static String NumberOne;
	public static String NumberTwo;
	public static String NumberThree;
	public static String NumberFour;
	public static String NumberFive;
	public static String shiftBandNew="Auto Band code 82220";
	public static String RosterGroupNameforRosterCreation;
	
}
