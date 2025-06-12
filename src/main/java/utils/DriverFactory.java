package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

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
    public static void initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-infobars");
            options.addArguments("--incognito"); // Optional: prevent browser warnings
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));

            tlDriver.set(new ChromeDriver(options));
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            tlDriver.set(new FirefoxDriver());
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

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
