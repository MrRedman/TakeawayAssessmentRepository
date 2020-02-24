package com.takeaway.assessment.BusinessLogic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.management.OperationsException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.takeaway.assessment.Utility.BrowserFactory;
import com.vimalselvam.cucumber.listener.Reporter;
import com.takeaway.assessment.BusinessLogic.*;
import com.google.common.base.Function;
import com.google.common.io.Files;



@SuppressWarnings("unused")
public class CommonMethod extends BrowserFactory {
	WebElement webelement;
	
	Accessors accessor = new Accessors();
	public static int parentStepNo;
	public static int childStepNo;
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name:  waitForElementToAppear
	 * @purpose: wait for an element to appear on a page
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public void waitForElementToAppear(WebElement argWebElement) {
		try {
			WebElement element = argWebElement;
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			reportStep(element + " appeared ");
		} catch (Exception e) {
			String lines[] = e.getMessage().split("\\r?\\n");
			reportStep("*#* " + lines[0]);
			takeScreenShot_reporter();
			log.info(e.getMessage());
			Assert.assertFalse(true, e.getMessage());
		}
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: waitForPageLoad
	 * @purpose: wait for a page to load
	 * @param :
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: fillInputValue
	 * @purpose: enters text to given input element
	 * @param : WebElement and value to enter
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	protected void fillInputValue(WebElement argWebElement, String strValue) {
		try {
			waitForElementToAppear(argWebElement);
			argWebElement.clear();
			argWebElement.sendKeys(strValue);
			reportStep(strValue + " Entered in " + argWebElement);
		}catch(Exception e) {
			Assert.assertFalse(true, e.getMessage());
		}
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: userLeftClick
	 * @purpose: click on element
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public void userLeftclick(WebElement argWebElement) {
		try {
			waitForElementToAppear(argWebElement);
			argWebElement.click();
			reportStep("Clicked on element");		
		}catch(Exception e) {
			Assert.assertFalse(true, e.getMessage());
		}
	}
	

	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: 
	 * @purpose: 
	 * @param :
	 * @author 
	 * @return: void
	 * 
	 * 
	 ***/
	
	public WebElement waitElementClicakbility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name:sendEnterKey 
	 * @purpose: sends enter key
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public void sendEnterKey(WebElement argWebElement) {
		argWebElement.sendKeys(Keys.ENTER);
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: getElementAttribute
	 * @purpose: get an element attribute 
	 * @param : WebElement and attribute value
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public String getElementAttribute(WebElement argWebElement, String attribute) {
	
		String attrValue="";
		
		try {
		
			attrValue = argWebElement.getAttribute(attribute);
			
		} catch (Exception e) {
			Assert.assertFalse(true, e.getMessage());
			String lines[] = e.getMessage().split("\\r?\\n");
			reportStep("*#* " + lines[0]);
			takeScreenShot_reporter();
			log.info(e.getMessage());
		}
		return attrValue;
	}
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: getTextofElement
	 * @purpose: gets an element text
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public String getTextofElement(WebElement argWebElement) {
		try {
			waitForElementToAppear(argWebElement);
			return argWebElement.getText();
		} catch (Exception e) {
			log.error(e.getMessage());
			// TODO: handle exception
		}
		return "";
	}

	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: selectFromDropdown
	 * @purpose: selects from dropdown by visible text
	 * @param :Weblement and text value to select
	 * @author Thobela Xhakaliva
	 * @return: void
	 ***/
	
	public void selectFromDropdown(WebElement argWebElement, String value) {
		try {
			
			this.waitForElementToAppear(argWebElement);
			Select select = new Select(argWebElement);
			select.selectByVisibleText(value);
			reportStep("Option " + value + " Selected from " + " dropdown");
		} catch (Exception e) {
			String lines[] = e.getMessage().split("\\r?\\n");
			log.info(e.getMessage());
			reportStep("*#* " + lines[0]);
			takeScreenShot_reporter();
			Assert.assertFalse(true, e.getMessage());
		}
	}
	

	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: selectPayWithDropDownClosestOption
	 * @purpose: selects closest amount to order price payment
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	public void selectPayWithDropDownByClosestOption(WebElement argWebElement) {
		
		try {
			waitForElementToAppear(argWebElement);
			if (argWebElement.isEnabled()) {

				Select value = new Select(argWebElement);
				List<WebElement> options = value.getOptions();
				
				for (int i=0; i < options.size(); i++ ) {
					
					if (!options.get(i).getText().contains("Exact amount:")) {
						options.get(i).click();
						break;
						
					}
					
				}

							
			}

		} catch (Exception e) {
			String lines[] = e.getMessage().split("\\r?\\n");
			System.out.println("lines " + lines[0]);
			reportStep("*#* " + lines[0]);
			takeScreenShot_reporter();
			Assert.assertFalse(true, e.getMessage());
		}
	}
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: sleep
	 * @purpose: sleeps for seconds given
	 * @param : seconds in float
	 * @author
	 * @return: void
	 * @throws 
	 * 
	 * 
	 ***/
	public void sleepTime(float sec) {
		DecimalFormat dec = new DecimalFormat("#0.000");
		try {
			System.out.println(dec.format(sec));
			Thread.sleep((long) Float.parseFloat(dec.format(sec)) * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}
	}
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: ScrollIntoView
	 * @purpose: scroll to element view with JavascriptExecutor
	 * @param : WebElement
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	public void ScrollIntoView(WebElement argWebElement) {

		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView();", argWebElement);

		} catch (Exception e) {

			Assert.assertFalse(true, e.getMessage());
			String lines[] = e.getMessage().split("\\r?\\n");
			reportStep("*#* " + lines[0]);
			accessor.setStatus("FAILED");
			takeScreenShot_reporter();
			log.info(e.getMessage());

		}

	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: takeScreenShot
	 * @purpose: takes screenshot
	 * @param :
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/

	public void takeScreenShot() {

		try {
			// This takes a screenshot from the driver at save it to the specified location
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			File ScreenShotPath = new File(System.getProperty("ReportPath")  + "\\" + System.getProperty("TestID"));
			File destinationPath = new File(System.getProperty("ReportPath")  + "\\" + System.getProperty("TestID")
					+ "\\" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".png");
			
			if(!ScreenShotPath.exists()) {
				ScreenShotPath.mkdir();
			}
			// Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			//Reporter.addScreenCaptureFromPath(destinationPath.toString());

		} catch (IOException e) {
		}
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: takeScreenShot_reporter
	 * @purpose: takes screenshots attach to report
	 * @param :
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	
	public void takeScreenShot_reporter() {

		try {
			// This takes a screenshot from the driver at save it to the specified location
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			parentStepNo = accessor.getParentStepNumber();
			childStepNo = accessor.getChildStepNumber();

			
			File ScreenShotPath = new File(System.getProperty("ReportPath")  + "\\" + System.getProperty("TestID")+ "\\"
					+ System.getProperty("Browser"));
			File destinationPath = new File(System.getProperty("ReportPath")  + "\\" + System.getProperty("TestID")
					+ "\\" +   System.getProperty("Browser") + "\\Step_" + parentStepNo + "." + childStepNo + ".png"); 
			
			parentStepNo++;
			accessor.setParentStepNo(parentStepNo);
			
			// re initialize child step count as parent step changed
			accessor.setChildStepno(1);
			if (!ScreenShotPath.exists()) {
				ScreenShotPath.mkdirs();
			}
			
			// Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());

		} catch (Exception e) {
			String lines[] = e.getMessage().split("\\r?\\n");
			reportStep("*#* " + lines[0]);
			log.info(e.getMessage());
		}
	}
	
	
	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: closeBrowser
	 * @purpose: quits the driver
	 * @param :
	 * @author Thobela Xhakaliva
	 * @return: void
	 * 
	 * 
	 ***/
	

	public void closeBrowser() {
		reportStep("Browser closed");
		BrowserFactory.getDriver().quit();

	}


	/**
	 * @FUNCTION_HEADER*****************************************************************************
	 * @name: reportStep
	 * @purpose: reports on execution steps
	 * @param :
	 * @author 
	 * @return: void
	 * 
	 * 
	 ***/
	 public void reportStep(String string) {
		 	//Reporter.addStepLog(string);
			log.info(string);
	 }
	
}
