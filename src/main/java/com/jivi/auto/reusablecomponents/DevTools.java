package com.jivi.auto.reusablecomponents;


import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v95.network.Network;
//import org.openqa.selenium.devtools.v85.*;
//import org.openqa.selenium.devtools.v97.network.Network;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DevTools extends GlobalVariables {

    public void networkIntercept() {
        WebDriver driver = Browser.getInstance().getDriver();
        driver.manage().window().maximize();
        org.openqa.selenium.devtools.DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
      //  devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
       // devTools.send(Network.setBlockedURLs(ImmutableList.of(".png", ".jpg")));
        //driver.get(GlobalVariables.configData.get("ApplicationURL").toString());
        //devTools.send(Network.disable());
    }

    public void emulateGeoLocation() {
        WebDriver driver = Browser.getInstance().getDriver();
        // Create a hashmap for latitude, longitude, and accuracy as needed by Google Maps
        Map<String, Object> coordinates = new HashMap<>();
        // 27.944903941357335, -82.47211430719501 : random coordinates within Tampa (USA)
        coordinates.put("latitude", GlobalVariables.configData.get("Latitude"));
        coordinates.put("longitude", GlobalVariables.configData.get("longitude"));
        coordinates.put("accuracy", GlobalVariables.configData.get("Accuracy"));// 100
        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get(GlobalVariables.configData.get("ApplicationURL").toString());
    }

}
