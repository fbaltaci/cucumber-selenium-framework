package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addProductToCart(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        String buttonId = "add-to-cart-" + formattedName;
        driver.findElement(By.id(buttonId)).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
}
