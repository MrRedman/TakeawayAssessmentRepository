$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Restaurant.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Thobela Xhakaliva"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "RestaurantsFeature",
  "description": "Ordering From Restaurant through Takeaway platform",
  "id": "restaurantsfeature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Case One",
  "description": "",
  "id": "restaurantsfeature;case-one",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@TC_01"
    },
    {
      "line": 23,
      "name": "@Counter"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Thuisbezorgd.nl is launched using dataFile \"\u003cTestDataFile\u003e\" and datasheet \"\u003cDataSetSheet\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I type postcode into the address field and Select postcode",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Navigate to restaurants page and Verify that restaurants has been listed at this address on the restaurant page",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Select test restaurantsfrom restaurant list",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Add any item from restaurant menu into basket",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Press the Order button and navigate to fill the address page",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Fill the form with ASAP delivery option",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Select the payment amount from combobox at the bottom of the page",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Click on Order and Pay button to finish your order process",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Get the order reference number from latest page",
  "keyword": "Then "
});
formatter.examples({
  "line": 36,
  "name": "",
  "description": "",
  "id": "restaurantsfeature;case-one;",
  "rows": [
    {
      "cells": [
        "TestDataFile",
        "DataSetSheet"
      ],
      "line": 37,
      "id": "restaurantsfeature;case-one;;1"
    },
    {
      "cells": [
        "TakewayData",
        "test_data"
      ],
      "line": 38,
      "id": "restaurantsfeature;case-one;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 409499900,
  "status": "passed"
});
formatter.before({
  "duration": 57843500,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Case One",
  "description": "",
  "id": "restaurantsfeature;case-one;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    },
    {
      "line": 23,
      "name": "@TC_01"
    },
    {
      "line": 23,
      "name": "@Counter"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Thuisbezorgd.nl is launched using dataFile \"TakewayData\" and datasheet \"test_data\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I type postcode into the address field and Select postcode",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Navigate to restaurants page and Verify that restaurants has been listed at this address on the restaurant page",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Select test restaurantsfrom restaurant list",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Add any item from restaurant menu into basket",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Press the Order button and navigate to fill the address page",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Fill the form with ASAP delivery option",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Select the payment amount from combobox at the bottom of the page",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Click on Order and Pay button to finish your order process",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Get the order reference number from latest page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "RestaurantStepsDefinition.navigate_to_restaurants_page_and_Verify_that_restaurants_has_been_listed_at_this_address_on_the_restaurant_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "RestaurantStepsDefinition.add_any_item_from_restaurant_menu_into_basket()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.press_the_Order_button_and_navigate_to_fill_the_address_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.fill_the_form_with_ASAP_delivery_option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.select_the_payment_amount_from_combobox_at_the_bottom_of_the_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.click_on_Order_and_Pay_button_to_finish_your_order_process()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.get_the_order_reference_number_from_latest_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 76600,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 41,
  "name": "Case Two",
  "description": "",
  "id": "restaurantsfeature;case-two",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 40,
      "name": "@TC_01"
    },
    {
      "line": 40,
      "name": "@Counter"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "Thuisbezorgd.nl is launched using dataFile \"\u003cTestDataFile\u003e\" and datasheet \"\u003cDataSetSheet\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "I type postcode into the address field and Select postcode",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "Navigate to restaurants page and Select test restaurants from restaurant list",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "Add any item from restaurant menu into basket",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Press the Order button and navigate to fill the address page",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "Fill the form with ASAP delivery option",
  "keyword": "Then "
});
formatter.step({
  "line": 48,
  "name": "Click on Order and Pay button to finish your order process",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "Get the order reference number from latest page",
  "keyword": "Then "
});
formatter.examples({
  "line": 51,
  "name": "",
  "description": "",
  "id": "restaurantsfeature;case-two;",
  "rows": [
    {
      "cells": [
        "TestDataFile",
        "DataSetSheet"
      ],
      "line": 52,
      "id": "restaurantsfeature;case-two;;1"
    },
    {
      "cells": [
        "TakewayData",
        "test_data"
      ],
      "line": 53,
      "id": "restaurantsfeature;case-two;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 558100,
  "status": "passed"
});
formatter.before({
  "duration": 2754200,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "Case Two",
  "description": "",
  "id": "restaurantsfeature;case-two;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    },
    {
      "line": 40,
      "name": "@TC_01"
    },
    {
      "line": 40,
      "name": "@Counter"
    }
  ]
});
formatter.step({
  "line": 42,
  "name": "Thuisbezorgd.nl is launched using dataFile \"TakewayData\" and datasheet \"test_data\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "I type postcode into the address field and Select postcode",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "Navigate to restaurants page and Select test restaurants from restaurant list",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "Add any item from restaurant menu into basket",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Press the Order button and navigate to fill the address page",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "Fill the form with ASAP delivery option",
  "keyword": "Then "
});
formatter.step({
  "line": 48,
  "name": "Click on Order and Pay button to finish your order process",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "Get the order reference number from latest page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "RestaurantStepsDefinition.navigate_to_restaurants_page_and_Select_test_restaurants_from_restaurant_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.add_any_item_from_restaurant_menu_into_basket()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.press_the_Order_button_and_navigate_to_fill_the_address_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.fill_the_form_with_ASAP_delivery_option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.click_on_Order_and_Pay_button_to_finish_your_order_process()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "RestaurantStepsDefinition.get_the_order_reference_number_from_latest_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 36000,
  "status": "passed"
});
