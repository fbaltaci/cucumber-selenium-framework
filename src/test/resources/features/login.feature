Feature: Login functionality

  Scenario: Valid login
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click on the login button
    Then I should see the products page
