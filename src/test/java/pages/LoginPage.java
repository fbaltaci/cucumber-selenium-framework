package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    /**
     * Constructor for LoginPage.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enters the username.
     *
     * @param user Username to enter
     */
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    /**
     * Enters the password.
     *
     * @param pass Password to enter
     */
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    /**
     * Clicks on the login button.
     */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Returns the error message.
     *
     * @return Error message as a string
     */
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    /**
     * Logs in with the given credentials.
     *
     * @param user Username
     * @param pass Password
     */
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    /**
     * Handle Browser Alert
     */
    public void handleBrowserAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();  // Clicks OK
        } catch (NoAlertPresentException ignored) {
            // Alert not shown, safe to skip
        }
    }
}
