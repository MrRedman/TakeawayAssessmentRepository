Feature: Takeaway - Thuisbezorgd.nl

  @TC_01 @Counter
  Scenario Outline: Case One
    Given Thuisbezorgd.nl is launched using dataFile "<TestDataFile>" and dataSheet "<DataSetSheet>"
    Then I type postcode into the address field and select postcode
    Then Navigate to restaurants page and Verify that restaurants has been listed at this address on the restaurant page
    Then Select test restaurant from restaurant list
    Then Add any item from restaurant menu into basket
    Then Press the Order button and navigate to fill the address page
    Then Fill the form with ASAP delivery option
    Then Click on Order and Pay button to finish your order process
    Then Get the order reference number from latest page

    Examples: 
      | TestDataFile | DataSetSheet |
      | TakeawayData | test_data    |

  @TC_02 @Counter
  Scenario Outline: Case Two
    Given Thuisbezorgd.nl is launched using dataFile "<TestDataFile>" and dataSheet "<DataSetSheet>"
    Then I type postcode into the address field and select postcode
    Then Navigate to restaurants page and Verify that restaurants has been listed at this address on the restaurant page
    Then Add any item from restaurant menu into basket
    Then Press the Order button and navigate to fill the address page
    Then Fill the form with ASAP delivery option
    Then Click on Order and Pay button to finish your order process
    Then Get the order reference number from latest page

    Examples: 
      | TestDataFile | DataSetSheet |
      | TakeawayData | test_data    |
