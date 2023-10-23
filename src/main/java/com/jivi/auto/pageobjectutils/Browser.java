package com.jivi.auto.pageobjectutils;



import org.openqa.selenium.Proxy;

//import com.microsoft.edge.seleniumtools.EdgeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.jivi.auto.reusablecomponents.BrowserType;
import com.jivi.auto.reusablecomponents.CapabilityFactory;
import com.jivi.auto.reusablecomponents.GlobalVariables;
import com.jivi.auto.reusablecomponents.OptionsManager;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Browser {
	public Browser() {
		// Do-nothing..Do not allow to initialize this class from outside
	}

	public static String browserName = GlobalVariables.configData.get("Browser");
	public static String gridHost = GlobalVariables.configData.get("GridHost");
	public static String os = System.getProperty("os.name");

	public static Browser instance = new Browser();
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	// public CapabilityFactory capabilityFactory = new CapabilityFactory();
	// public String browserName;

	public static Browser getInstance() {
		return instance;

	}

	// thread local driver object for web-driver
	public static ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<RemoteWebDriver>() {

		@Override
		public RemoteWebDriver initialValue() {

			if (GlobalVariables.isGridMode) {
				switch (browserName.toUpperCase()) {
				case "CHROME":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.chrome)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "FIREFOX":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.firefox)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "EDGE":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.Edge)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "IE":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.ie)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "HEADLESSCHROME":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.HeadlessChrome)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "HEADLESSFIREFOX":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.HeadlessFirefox)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;
				case "HEADLESSEDGE":
					try {
						threadDriver.set(new RemoteWebDriver(new URL(gridHost + "/wd/hub"),
								CapabilityFactory.getCapabilities(BrowserType.HeadlessEdge)));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					break;

				}
				return threadDriver.get();
			} else if (System.getProperty("os.name").contains("Linux")) {
				if (System.getenv("Browser") != null) {
					browserName = System.getenv("Browser");
					System.out.println("jenkins...." + browserName);
				} else if (System.getProperty("Browser") != null && !System.getProperty("Browser").isEmpty()) {
					browserName = System.getProperty("Browser");

					System.out.println("Tekton....." + browserName);

				}

				else {
					browserName = GlobalVariables.configData.get("Browser");
				}
				switch (browserName.toUpperCase()) {
				case "HEADLESSCHROME":
					System.out.println("LinuxTesting");
					ChromepathLinux();
					threadDriver.set(new ChromeDriver(OptionsManager.getHeadlessChromeOptions()));
					break;

				}
				return threadDriver.get();
			}

			else {
				if (GlobalVariables.configData.get("SeleniumManager").equalsIgnoreCase("Yes")) {

					switch (browserName.toUpperCase()) {
					case "CHROME":
						// WebDriverManager.chromedriver().setup();
						try {
							threadDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
						} catch (Exception e) {
							ChromeOptions options = OptionsManager.getHeadlessChromeOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new ChromeDriver(options));
						}

						break;

					case "FIREFOX":
						// WebDriverManager.firefoxdriver().setup();

						try {
							threadDriver.set(new FirefoxDriver(OptionsManager.getFirefoxOptions()));
						} catch (Exception e) {
							FirefoxOptions options = OptionsManager.getFirefoxOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new FirefoxDriver(options));

						}

						break;
					case "EDGE":
						// WebDriverManager.edgedriver().setup();
						try {
							threadDriver.set(new EdgeDriver(OptionsManager.getEdgeOptions()));
						} catch (Exception e) {

							EdgeOptions options = OptionsManager.getEdgeOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new EdgeDriver(options));

						}
						break;
					case "IE":
						// WebDriverManager.iedriver().setup();
						threadDriver.set(new InternetExplorerDriver(OptionsManager.getIEOptions()));
						break;
					case "HEADLESSCHROME":
						// WebDriverManager.chromedriver().setup();
						try {
							threadDriver.set(new ChromeDriver(OptionsManager.getHeadlessChromeOptions()));
						} catch (Exception e) {

							ChromeOptions options = OptionsManager.getHeadlessChromeOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new ChromeDriver(options));
						}

						break;

					case "HEADLESSFIREFOX":
						// WebDriverManager.firefoxdriver().setup();

						try {
							threadDriver.set(new FirefoxDriver(OptionsManager.getHeadlessFirefoxOptions()));
						} catch (Exception e) {
							FirefoxOptions options = OptionsManager.getHeadlessFirefoxOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new FirefoxDriver(options));
						}

						break;
					case "HEADLESSEDGE":
						// WebDriverManager.edgedriver().setup();

						try {
							threadDriver.set(new EdgeDriver(OptionsManager.getHeadlessEdgeOptions()));
						} catch (Exception e) {
							EdgeOptions options = OptionsManager.getHeadlessEdgeOptions();
							String[] proxyServer = GlobalVariables.configData.get("proxyServer").trim().split(":");
							Proxy proxy = new Proxy();
							proxy.setProxyType(ProxyType.MANUAL);
							proxy.setHttpProxy(proxyServer[0] + ":" + proxyServer[1]);
							proxy.setSslProxy(proxyServer[0] + ":" + proxyServer[1]);
							options.setProxy(proxy);
							threadDriver.set(new EdgeDriver(options));

						}

						break;
					case "SAFARI":
						// WebDriverManager.safaridriver().setup();
						threadDriver.set(new SafariDriver(OptionsManager.getSafariOptions()));
						break;

					}

					return threadDriver.get();
				} else {

					switch (browserName.toUpperCase()) {
					case "CHROME":
						System.setProperty("webdriver.chrome.driver", "Utilities/chromedriver.exe");
						threadDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
						break;

					case "FIREFOX":
						System.setProperty("webdriver.gecko.driver", "Utilities/geckodriver.exe");
						threadDriver.set(new FirefoxDriver(OptionsManager.getFirefoxOptions()));
						break;
					case "EDGE":
						System.setProperty("webdriver.edge.driver", "Utilities/msedgedriver.exe");
						threadDriver.set(new EdgeDriver(OptionsManager.getEdgeOptions()));
						break;

					case "HEADLESSCHROME":
						// WebDriverManager.chromedriver().setup();
						System.setProperty("webdriver.chrome.driver", "Utilities/chromedriver.exe");
						threadDriver.set(new ChromeDriver(OptionsManager.getHeadlessChromeOptions()));
						break;
					case "HEADLESSFIREFOX":

						// WebDriverManager.firefoxdriver().setup();
						System.setProperty("webdriver.gecko.driver", "Utilities/geckodriver.exe");

						threadDriver.set(new FirefoxDriver(OptionsManager.getHeadlessFirefoxOptions()));
						break;
					case "HEADLESSEDGE":
						System.setProperty("webdriver.edge.driver", "Utilities/msedgedriver.exe");
						threadDriver.set(new EdgeDriver(OptionsManager.getHeadlessEdgeOptions()));
						break;
					case "SAFARI":
						threadDriver.set(new SafariDriver(OptionsManager.getSafariOptions()));
						break;

					}

					return threadDriver.get();
				}
			}

		}

	};

	public WebDriver getDriver() // call this method to get the driver object and launch the browser
	{
		return threadDriver.get();
	}

	public static void setWebDriver(RemoteWebDriver driver) {

		threadDriver.set(driver);
	}

	public void removeDriver() // Quits the driver and closes the browser
	{
		threadDriver.get().quit();
		threadDriver.remove();
	}

	public static void ChromepathLinux() {
		try {
			if (System.getenv("CHROME_HOME") != null) {
				String chromePath = System.getenv("CHROME_HOME");
				System.setProperty("webdriver.chrome.driver", chromePath + "/chromedriver");
			} else {
				System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
