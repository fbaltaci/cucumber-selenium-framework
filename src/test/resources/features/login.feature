Feature: Login functionality

  Scenario: Valid login
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click on the login button
    Then I should see the products page

  Scenario: Invalid login with wrong credentials
    Given I am on the SauceDemo login page
    When I enter username "locked_out_user" and password "wrong_password"
    And I click on the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
