package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    /**
     * Init Driver
     */
    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    /**
     * Quit Driver
     */
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
