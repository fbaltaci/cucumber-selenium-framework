package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

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
        logger.debug("LoginPage initialized.");
    }

    /**
     * Enters the username.
     *
     * @param user Username to enter
     */
    public void enterUsername(String user) {
        logger.info("Entering username: {}", user);
        driver.findElement(username).sendKeys(user);
    }

    /**
     * Enters the password.
     *
     * @param pass Password to enter
     */
    public void enterPassword(String pass) {
        logger.info("Entering password: ********");
        driver.findElement(password).sendKeys(pass);
    }

    /**
     * Clicks on the login button.
     */
    public void clickLogin() {
        logger.info("Clicking login button.");
        driver.findElement(loginButton).click();
    }

    /**
     * Returns the error message.
     *
     * @return Error message as a string
     */
    public String getErrorMessage() {
        String message = driver.findElement(errorMsg).getText();
        logger.warn("Login error message displayed: {}", message);
        return message;
    }

    /**
     * Logs in with the given credentials.
     *
     * @param user Username
     * @param pass Password
     */
    public void login(String user, String pass) {
        logger.debug("Attempting login with username: {}", user);
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    /**
     * Handle Browser Alert
     */
    public void handleBrowserAlertIfPresent() {
        try {
            logger.debug("Checking for browser alert...");
            Alert alert = driver.switchTo().alert();
            logger.info("Browser alert found. Accepting it.");
            alert.accept();
        } catch (NoAlertPresentException ignored) {
            logger.debug("No browser alert present.");
        }
    }
}
