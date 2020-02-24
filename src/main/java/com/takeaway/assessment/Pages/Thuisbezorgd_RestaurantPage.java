package com.takeaway.assessment.Pages;

import com.takeaway.assessment.BusinessLogic.CommonMethod;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Thuisbezorgd_RestaurantPage extends CommonMethod{
	
	private WebDriver driver;
	
	
	public Thuisbezorgd_RestaurantPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/*
	 * 
	 * I would parameterise addToBasket xpath to add any menu item to basket but PO pattern kind of restricts but i can find a work around
	 * 
	 * 
	 * */

	
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Turkish sunday breakfast')]//parent::span[@class='meal-name']//..//..//..//div[@class='js-meal__add-to-basket-button menucard-meal__sidedish-button']")
	public WebElement addToBasketButton;
	
	@FindBy(how = How.XPATH,using="//div[@class='minimumorderamount-reached' and contains(.,\"Sorry, you can't order yet\")]")
	public WebElement notReachedMinimumOrderAmountMessage;
	
	@FindBy(how = How.XPATH, using="//span[contains(text(), 'Amount needed to reach the minimum order value')]//parent::div[not(@id)]//span[contains(text(), 'Amount needed to reach the minimum order value')]")
	public WebElement amountNeededToReachMinimumOrderAmountMessage;
	
	@FindBy(how = How.XPATH,using="//button[contains(text(),'Order')]")
	public WebElement orderButton;
	
	
	
	public void checkMinimumOrderAmountMessage() {
		//checks the minimum order message
		waitForElementToAppear(notReachedMinimumOrderAmountMessage);
		
	}

	
	public void addToBasket() {
		
		//Check message and adds menu item to the basket
		checkMinimumOrderAmountMessage();
		addMenuItemToBasket();
		waitForElementToAppear(amountNeededToReachMinimumOrderAmountMessage);
		addMenuItemToBasket();
		
	}
	
	public void clickOrder() {
		//click order button
		userLeftclick(orderButton);
		
	}
	
	
	private void addMenuItemToBasket() {
		//click menu item
		userLeftclick(addToBasketButton);
	}
	
	
	
	
}
