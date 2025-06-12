package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import utils.DriverFactory;


public class LogoutSteps {

    WebDriver driver = DriverFactory.getDriver();

    @When("I click the menu button and log out")
    public void click_menu_and_logout() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();
    }

    @Then("I should be redirected to the login page")
    public void redirected_to_login() {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }
}
