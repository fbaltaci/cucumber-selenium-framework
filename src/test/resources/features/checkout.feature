Feature: Checkout functionality

  Scenario: Enter user info on checkout step one
    Given I am logged in to SauceDemo
    When I add the product "Sauce Labs Bike Light" to the cart
    And I proceed to checkout
    And I fill in the checkout form with first name "John", last name "Doe", and zip "12345"
    Then I should land on the overview page
