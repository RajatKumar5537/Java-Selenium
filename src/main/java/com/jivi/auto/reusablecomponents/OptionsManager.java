package com.jivi.auto.reusablecomponents;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsManager {
	// Get Chrome Options
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		options.setExperimentalOption("prefs", getDownloadPath());
		//options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return options;
	}

	// Get Firefox Options
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options;
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		String downloadFilepath = null;
		if (GlobalVariables.configData.get("DownloadPath").trim() != null
				|| GlobalVariables.configData.get("DownloadPath").trim() != "")
			downloadFilepath = GlobalVariables.configData.get("DownloadPath").trim();
		profile.setPreference("browser.download.folderList", 2);

		// Setting custom download directory
		profile.setPreference("browser.download.dir", downloadFilepath);

		options = new FirefoxOptions();

		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		options.setProfile(profile);

		options.addPreference("network.proxy.type", Proxy.ProxyType.AUTODETECT.ordinal());
		options.setBinary(firefoxBinary);
		return options;
	}

	public static EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		// options.setBinary("C:\\Program Files
		// (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		// options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setExperimentalOption("prefs", getDownloadPath());

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return options;
	}

	// Get Safari Options
	public static SafariOptions getSafariOptions() {
		SafariOptions safarioptions = new SafariOptions();
		return safarioptions;
	}

	public static InternetExplorerOptions getIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("ignoreZoomSetting", true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		options.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
		options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		return options;
	}

	public static FirefoxOptions getHeadlessFirefoxOptions() {
		FirefoxOptions firefoxOptions;
		firefoxOptions = new FirefoxOptions();
		FirefoxProfile profile;
		profile = new FirefoxProfile();
		String downloadFilepath = null;
		if (GlobalVariables.configData.get("DownloadPath").trim() != null
				|| GlobalVariables.configData.get("DownloadPath").trim() != "") {
			downloadFilepath = GlobalVariables.configData.get("DownloadPath").trim();
		}
		if (System.getProperty("os.name").contains("Linux")) {

			File pathBinary = new File(System.getenv("FIREFOX_HOME") + "/firefox-esr");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			profile.setPreference("browser.download.folderList", 2);
			// Setting custom download directory
			profile.setPreference("browser.download.dir", downloadFilepath);
			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");

			firefoxOptions.setProfile(profile);
			firefoxBinary.addCommandLineOptions("--headless");
			firefoxOptions.addArguments("--window-size=1920,1080");
			firefoxOptions.setBinary(firefoxBinary);

		} else {

			FirefoxBinary firefoxBinary = new FirefoxBinary();
			profile.setPreference("browser.download.folderList", 2);

			// Setting custom download directory
			profile.setPreference("browser.download.dir", downloadFilepath);

			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			firefoxOptions.addPreference("network.proxy.type", Proxy.ProxyType.AUTODETECT.ordinal());
			firefoxOptions.setProfile(profile);
			firefoxBinary.addCommandLineOptions("--headless");
			firefoxOptions.addArguments("--window-size=1920,1080");
			firefoxOptions.setBinary(firefoxBinary);

		}
		return firefoxOptions;
	}

	public static ChromeOptions getHeadlessChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		String downloadFilepath = null;
		String proxyServer, proxyBypassList = null;
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		if (GlobalVariables.configData.get("DownloadPath").trim() != null
				|| GlobalVariables.configData.get("DownloadPath").trim() != "") {

			if (System.getProperty("os.name").contains("Linux")) {

				downloadFilepath = System.getProperty("user.dir") + File.separator + "Downloads";

			} else {
				downloadFilepath = GlobalVariables.configData.get("DownloadPath").trim();
			}

			chromePrefs.put("download.default_directory", downloadFilepath);

		}
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("window-size=1920,1080");
		options.addArguments("headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		// Proxy settings
		try {
			if (GlobalVariables.configData.get("proxyServer").trim() != null
					|| GlobalVariables.configData.get("proxyServer").trim() != "") {
				proxyServer = GlobalVariables.configData.get("proxyServer").trim();
				options.addArguments("--proxy-server=" + proxyServer);
				// options.addArguments("--proxy-server=http://internet.ford.com:83");
			}

			if (GlobalVariables.configData.get("proxyBypassList").trim() != null
					|| GlobalVariables.configData.get("proxyBypassList").trim() != "") {
				proxyBypassList = GlobalVariables.configData.get("proxyBypassList").trim();

				String[] proxyByPassURLs = proxyBypassList.split(",");
				for (String url : proxyByPassURLs) {
					options.addArguments("--proxy-bypass-list=" + url);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return options;
	}

	public static EdgeOptions getHeadlessEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("headless");
		options.addArguments("disable-gpu");
		options.addArguments("window-size=1920,1080");
		options.setExperimentalOption("prefs", getDownloadPath());

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return options;
	}

	private static HashMap<String, Object> getDownloadPath() {

		String downloadFilepath = null;
		if (GlobalVariables.configData.get("DownloadPath").trim() != null
				|| GlobalVariables.configData.get("DownloadPath").trim() != "")

			downloadFilepath = GlobalVariables.configData.get("DownloadPath").trim();
		// System.out.println("OS.........."+System.getProperty("os.name"));
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		if (GlobalVariables.configData.get("DownloadPath").trim() != null
				|| GlobalVariables.configData.get("DownloadPath").trim() != "")
			chromePrefs.put("download.default_directory", downloadFilepath);

		// System.out.println("RootFloderPath....."+System.getProperty("user.dir"));
		return chromePrefs;
	}

}