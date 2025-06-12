package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final By pageTitle = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By menuBtn = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By checkoutButton = By.id("checkout");

    /**
     * Constructor for InventoryPage.
     *
     * @param driver WebDriver instance
     */
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the title of the page.
     *
     * @return Title of the page as a string
     */
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    /**
     * Adds a product to the cart.
     *
     * @param productName Name of the product to add
     */
    public void addProductToCart(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        String buttonId = "add-to-cart-" + formattedName;
        driver.findElement(By.id(buttonId)).click();
    }

    /**
     * Returns the count of items in the cart.
     *
     * @return Count of items in the cart as a string
     */
    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    /**
     * Logs out from the application.
     */
    public void logout() {
        driver.findElement(menuBtn).click();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
        driver.findElement(logoutLink).click();
    }

    /**
     * Clicks on the cart icon.
     */
    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    /**
     * Clicks on the checkout button.
     */
    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
}
