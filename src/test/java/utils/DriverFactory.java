package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    // ThreadLocal for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize driver
    public static void initDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException(
                    "Invalid browser: " + browser
                );
        }

        // Common browser settings
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    // Return current thread driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
