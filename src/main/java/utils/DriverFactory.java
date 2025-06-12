package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to get the driver with ThreadLocal
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * This method is used to initialize the driver with ThreadLocal
     */
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    /**
     * This method is used to quit the driver with ThreadLocal
     */
    public static void quitDriver() {
        getDriver().quit();
        tlDriver.remove();
    }
}
