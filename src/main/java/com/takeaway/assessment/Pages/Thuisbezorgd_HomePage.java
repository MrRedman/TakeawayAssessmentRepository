package com.takeaway.assessment.Pages;


import com.takeaway.assessment.BusinessLogic.CommonMethod;
import com.takeaway.assessment.Utility.ExcelReade;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Thuisbezorgd_HomePage extends CommonMethod {	
	
	private WebDriver driver;
	Map<String, String> testData;
	
	
	/* In a complete framework i would have more control on xpaths and remove their dependency on the scripts */
	
	@FindBy(how = How.ID, using="imysearchstring")
	public WebElement addressSearchField;
	
	
	@FindBy(how = How.XPATH, using="//div[@class='lp__notice']")
	public WebElement noticeMessage;
	
	@FindBy(how = How.XPATH, using="//a[@id='reference' and contains(.,'8888 Alpha')]")
	public WebElement postAddressSuggestion;
	
	
	public Thuisbezorgd_HomePage(WebDriver driver,String strDataFile, String strDataSheet) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testData = ExcelReade.readDataFromSheet(strDataFile, strDataSheet,System.getProperty("TestID"));
		
	}
	
	public void selectRestaurantAddress() throws InterruptedException {	
		
		//wait for page load
		waitForPageLoad();

		//entering post code into search field
		sendEnterKey(addressSearchField);
		
		//wait for page load
		waitForPageLoad();
		
		fillInputValue(addressSearchField,testData.get("PostCode"));
		
		sleepTime(2);		
		
		sendEnterKey(addressSearchField);
		
		//Check for notice message if location has more delivery address
		waitForElementToAppear(noticeMessage);
		
		//click address
		userLeftclick(postAddressSuggestion);   
		
	}
	
}
