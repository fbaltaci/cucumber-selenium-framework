package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.InventoryPage;
import utils.DriverFactory;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on the login button")
    public void i_click_login() {
        loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void i_should_see_products_page() {
        inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }
}
