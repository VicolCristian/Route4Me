@Run
Feature: User can add to cart a product and fill in the order form

  Background:
    Given user is logged in
      | email                  | password |
      | nedved198720@gmail.com | FxbkO2R  |

  Scenario: User can add a product to cart
    When user click on a category on the left side of the web page
    Then page with category is displayed
    When user click on a sub-category
    Then the sub-category is displayed
    When user click on add to cart button on any product from the list
    Then product is added to the cart
    When user click on checkout button
    Then user is redirected to checkout page

