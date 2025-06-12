package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import utils.DriverFactory;

public class AddToCartSteps {

    WebDriver driver = DriverFactory.getDriver();
    InventoryPage inventoryPage;

    @And("I add the product {string} to the cart")
    public void i_add_product_to_cart(String productName) {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(productName);
    }

    @Then("the cart badge should show {string}")
    public void cart_badge_should_show(String expectedCount) {
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), expectedCount);
    }
}
