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

public class Thuisbezorgd_CheckoutPage extends CommonMethod{

	private WebDriver driver;
	Map<String, String> testData;
	
	
	public Thuisbezorgd_CheckoutPage(WebDriver driver, String strDataFile, String strDataSheet) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testData = ExcelReade.readDataFromSheet(strDataFile, strDataSheet, System.getProperty("TestID"));
		
	}
	
	@FindBy(how = How.ID,using="iaddress")
	public WebElement addressField;
	
	@FindBy(how = How.ID,using="ipostcode")
	public WebElement postcodeField;
	
	@FindBy(how = How.ID,using="itown")
	public WebElement townField;
	
	@FindBy(how = How.ID,using="isurname")
	public WebElement surnameField;
	
	@FindBy(how = How.ID,using="iemail")
	public WebElement emailField;
	
	@FindBy(how = How.ID,using="iphonenumber")
	public WebElement phoneNumberField;
	
	@FindBy(how = How.ID,using="ideliverytime")
	public WebElement deliveryTimeDropdown;
	
	@FindBy(how = How.ID,using="ipayswith")
	public WebElement payWithDropdown;
	
	@FindBy(how = How.XPATH,using="//input[@value='Order and pay' and @type='submit']")
	public WebElement orderAndPayButton;
	
	@FindBy(how = How.XPATH,using="//span[@class='order-purchaseid']")
	public WebElement orderReference;
	
	
	
	
	public void fillOrderForm() throws InterruptedException {
		//Fill out Order form
		fillInputValue(addressField,testData.get("Address"));
		
		fillInputValue(postcodeField,testData.get("PostCodeAddress"));
		
		fillInputValue(townField,testData.get("City"));
		
		fillInputValue(surnameField,testData.get("Name"));
		
		fillInputValue(emailField,testData.get("Email"));
		
		fillInputValue(phoneNumberField,testData.get("PhoneNumber"));
		
		selectFromDropdown(deliveryTimeDropdown,testData.get("DeliveryTime"));
	
	}
	
	public void payWith() {
		//scroll to pay with dropdown and select the closest amount to the order
		ScrollIntoView(payWithDropdown);
		selectPayWithDropDownByClosestOption(payWithDropdown);
	}
	
	public void clickOrderAndPay() {
		//clicks order and pay button
		userLeftclick(orderAndPayButton);
	}
	
	public void getOrderReferenceNumber() {
		
		//gets reference number : this can be written to an external file or kept for verification.
		String referenceNumber = getTextofElement(orderReference);
		log.info("Your Reference number is: " + referenceNumber );
	}
	

	
	
	

	
	
}
