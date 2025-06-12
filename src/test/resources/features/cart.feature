Feature: Cart functionalities

  Scenario: Add one product to cart
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click on the login button
    And I add the product "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"
