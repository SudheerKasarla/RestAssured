package com.selenium.seleniumfour;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.ConnectionType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevTools
{
	
	WebDriver driver;
	
	
	@Test
	public void enableNetworkOffline() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver)driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.of(1000000),Optional.empty(), Optional.empty()));
		
		/*
		 * devTools.send(emulateNetworkConditions(true,100,1000,2000,Optional.of(
		 * ConnectionType.WIFI)));
		 * 
		 * devTools.addListener(loadingfailed, null);
		 */
		

	}

}
