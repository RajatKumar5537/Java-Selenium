package com.jivi.auto.reusablecomponents;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    public static Capabilities capabilities;
    public static Capabilities getCapabilities (BrowserType browser) {
        switch(browser){
            case ie:
                capabilities = OptionsManager.getIEOptions();
                break;
            case Edge:
                capabilities = OptionsManager.getEdgeOptions();
                break;
            case chrome:
                capabilities = OptionsManager.getChromeOptions();
                break;
            case Safari:
            	capabilities = OptionsManager.getSafariOptions();
                break;
            case firefox:
                capabilities = OptionsManager.getFirefoxOptions();
                break;
            case HeadlessEdge:
                capabilities = OptionsManager.getHeadlessEdgeOptions();
                break;
            case HeadlessChrome:
                capabilities = OptionsManager.getHeadlessChromeOptions();
                break;
            case HeadlessFirefox:
                capabilities = OptionsManager.getHeadlessFirefoxOptions();
                break;

        }

        return capabilities;
    }
}
