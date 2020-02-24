package com.takeaway.assessment.runner.Steps;



import com.takeaway.assessment.runner.Steps.ParentStep;
import com.takeaway.assessment.Pages.*;
import com.takeaway.assessment.Utility.BrowserFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RestaurantStepsDefinition {

	//Store dataFile and dataSheet 
	String DataFile,DataSheet;

	
	//Holds the Order Takeaway Page object
	Thuisbezorgd_OrderTakeawayPage orderFromRestuarant;
	Thuisbezorgd_RestaurantPage restaurantPage;
	Thuisbezorgd_CheckoutPage checkoutPage;


	@Given("^Thuisbezorgd\\.nl is launched using dataFile \"([^\"]*)\" and dataSheet \"([^\"]*)\"$")
	public void thuisbezorgd_nl_is_launched_using_dataFile_and_dataSheet(String dataFile, String dataSheet) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions "https://www.thuisbezorgd.nl/en/"
		BrowserFactory.openBrowser(ParentStep.getProperty("Browser"),ParentStep.getProperty("Url"));
		
		//holds data file name from feature file
		DataFile = dataFile;
		DataSheet = dataSheet;

	}

	@Then("^I type postcode into the address field and select postcode$")
	public void i_type_postcode_into_the_address_field_and_select_postcode() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions | "TakeawayData","test_data"		
		Thuisbezorgd_HomePage restaurantsSite = new Thuisbezorgd_HomePage(BrowserFactory.getDriver(),DataFile,DataSheet);
		restaurantsSite.selectRestaurantAddress();

	}
	
	@Then("^Navigate to restaurants page and Verify that restaurants has been listed at this address on the restaurant page$")
	public void navigate_to_restaurants_page_and_Verify_that_restaurants_has_been_listed_at_this_address_on_the_restaurant_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		orderFromRestuarant = new Thuisbezorgd_OrderTakeawayPage(BrowserFactory.getDriver(),DataFile,DataSheet);
		orderFromRestuarant.verifyRestaurantList();
	    
	}
	

	@Then("^Select test restaurant from restaurant list$")
	public void select_test_restaurant_from_restaurant_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions		
		if(orderFromRestuarant == null)
			orderFromRestuarant = new Thuisbezorgd_OrderTakeawayPage(BrowserFactory.getDriver(),DataFile,DataSheet);
		
		orderFromRestuarant.searchForRestaurant();
		orderFromRestuarant.selectRestuarant();
	}

	@Then("^Add any item from restaurant menu into basket$")
	public void add_any_item_from_restaurant_menu_into_basket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		restaurantPage = new Thuisbezorgd_RestaurantPage(BrowserFactory.getDriver());
		restaurantPage.addToBasket();
	    
	}

	@Then("^Press the Order button and navigate to fill the address page$")
	public void press_the_Order_button_and_navigate_to_fill_the_address_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(restaurantPage == null)
			restaurantPage = new Thuisbezorgd_RestaurantPage(BrowserFactory.getDriver());
		
		restaurantPage.clickOrder();
	    
	}

	@Then("^Fill the form with ASAP delivery option$")
	public void fill_the_form_with_ASAP_delivery_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage = new Thuisbezorgd_CheckoutPage(BrowserFactory.getDriver(),DataFile,DataSheet);
		checkoutPage.fillOrderForm();
	    
	}

	@Then("^Click on Order and Pay button to finish your order process$")
	public void click_on_Order_and_Pay_button_to_finish_your_order_process() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(checkoutPage == null)
			checkoutPage = new Thuisbezorgd_CheckoutPage(BrowserFactory.getDriver(),DataFile,DataSheet);
		
		checkoutPage.clickOrderAndPay();
	    
	}

	@Then("^Get the order reference number from latest page$")
	public void get_the_order_reference_number_from_latest_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(checkoutPage == null)
			checkoutPage = new Thuisbezorgd_CheckoutPage(BrowserFactory.getDriver(),DataFile,DataSheet);
		
		checkoutPage.getOrderReferenceNumber();
	}
	


	
}
