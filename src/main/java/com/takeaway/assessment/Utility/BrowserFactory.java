package com.takeaway.assessment.Utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserFactory extends LoggerClass {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver getDriver() {
	return driver;
	}
	
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: openBrowser
	 * @purpose: opens a browser and launch given URL
	 * @param :Browser name and Url
	 * @author Thobela Xhakaliva
	 * @return: void
	 * @throws : InterruptedException
	 * 
	 ***/
	public static void openBrowser(String Browser, String Url) throws InterruptedException {
		if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "src/test/resources/BrowserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Fire Fox driver created");
		} else if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			
			log.info("Chrome driver created");

		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/BrowserDriver/IEDriverServer.exe");
			InternetExplorerOptions ieOpts = new InternetExplorerOptions();
			ieOpts.setCapability("nativeEvents", false);
			ieOpts.setCapability("unexpectedAlertBehaviour", "accept");
			ieOpts.setCapability("ignoreProtectedModeSettings", true);
			ieOpts.setCapability("disable-popup-blocking", true);
			ieOpts.setCapability("enablePersistentHover", true);
			ieOpts.setCapability("ignoreZoomSetting", true);
			ieOpts.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			ieOpts.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(ieOpts);
	
			log.info("IE driver created");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(Url);	
	}

	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: openBrowser
	 * @purpose: quits driver
	 * @param :
	 * @author Thobela Xhakaliva
	 * @return: void
	 * @throws 
	 * 
	 ***/
	public void closeBrowser() {
		getDriver().quit();
	}
}
