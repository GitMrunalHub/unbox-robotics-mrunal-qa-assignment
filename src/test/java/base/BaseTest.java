package base;

import org.testng.annotations.*;
import utils.DriverFactory;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get("https://www.flipkart.com");
    }

    @AfterMethod
    public void teardown() {

        DriverFactory.quitDriver();
    }
}
