package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage;

    @Given("I am logged in to SauceDemo")
    public void i_am_logged_in() {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        inventoryPage.clickCart();
        inventoryPage.clickCheckout();
    }

    @And("I fill in the checkout form with first name {string}, last name {string}, and zip {string}")
    public void fill_checkout_info(String first, String last, String zip) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm(first, last, zip);
        checkoutPage.continueCheckout();
    }

    @Then("I should land on the overview page")
    public void i_should_see_overview() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.getCurrentUrl().contains("checkout-step-two"));
    }

}
