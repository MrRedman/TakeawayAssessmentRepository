package com.takeaway.assessment.Pages;

import com.takeaway.assessment.BusinessLogic.CommonMethod;
import com.takeaway.assessment.Utility.ExcelReade;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Thuisbezorgd_OrderTakeawayPage extends CommonMethod {

	private WebDriver driver;
	Map<String, String> testData;
	private String restaurantListXpath = "//div[starts-with(@id,'irestaurant') and starts-with(@class,'js-restaurant')]";

	public Thuisbezorgd_OrderTakeawayPage(WebDriver driver, String strDataFile, String strDataSheet) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		System.out.println("############ TEST CASE ID " + System.getProperty("TestID"));
		
		testData = ExcelReade.readDataFromSheet(strDataFile, strDataSheet, System.getProperty("TestID"));
	}
	
	/* I had an issue with trying to use String formatting.. 
	 * 
	 * for the restaurant names to search for with Page Object Pattern
	 *  
	 *  due to the attribute FindBy.using, is using a constant expression
	 *  
	 *  Typically i would String format xpaths like this >> //a[contains(text(),'%s') and contains(@href,'/')]
	 *  
	 *  then parameterise them. So i can have more control
	 *    */
	
	@FindBy(how = How.ID, using="irestaurantsearchstring-middle")
	public WebElement searchForRestaurant;
	
	@FindBy(how = How.XPATH, using="//span[@class='restaurant-amount']")
	public WebElement restuarantAmount;
	
	@FindBy(how = How.XPATH, using="//a[contains(text(),'EEE Test Restaurant') and contains(@href,'/')]")
	public WebElement restuarantItem;
	
	@FindBy(how = How.XPATH, using="//h1[contains(text(),'EEE Test Restaurant')]")
	public WebElement selectedRestaurantHeader;
	
	
	
	public void searchForRestaurant() {
		//enters search term
		fillInputValue(searchForRestaurant, testData.get("RestaurantSearchTerm"));
		sendEnterKey(searchForRestaurant);
		
	}
	
	public void selectRestuarant(){
		//clicks restaurant
		userLeftclick(restuarantItem);
		waitForElementToAppear(selectedRestaurantHeader);
	}
	
	public void verifyRestaurantList() {
		//Gets the current number of restaurants and compare with the total number of restaurant on the list
		String restaurantAmount = getTextofElement(restuarantAmount);
		List<WebElement> restaurantElementList = driver.findElements(By.xpath(restaurantListXpath));
		int restaurantListSize = restaurantElementList.size();
		
		
		if(Integer.valueOf(restaurantAmount).equals(restaurantListSize)) {
			Assert.assertTrue(true,"Restaurant amount is the same as restaurant listed");
			
		}else {
			Assert.assertFalse(true,"Restaurant amount is not the same as restaurant listed");
		}
	}
	
	
	
}
