package com.AutomationJiviewsGeneric;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportManager {
	private static ExtentReports extent;

	private ExtentReportManager() {
		// private constructor to prevent instantiation
	}

	public static synchronized ExtentReports getInstance() {
		if (extent == null) {
			extent = new ExtentReports();
		}
		return extent;
	}
}
