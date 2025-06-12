package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Fill the checkout form
     *
     * @param fName First name
     * @param lName Last name
     * @param zip   Postal code
     */
    public void fillForm(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    /**
     * Click on the "continue" button
     */
    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    /**
     * Get the current URL
     *
     * @return Current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
